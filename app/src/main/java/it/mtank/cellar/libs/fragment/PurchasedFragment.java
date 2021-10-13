package it.mtank.cellar.libs.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;

import java.util.List;

import it.mtank.cellar.DAO.CategoryDAO;
import it.mtank.cellar.DAO.ProductDAO;
import it.mtank.cellar.R;
import it.mtank.cellar.adapter.CategoryAdapter;
import it.mtank.cellar.adapter.ProductAdapter;
import it.mtank.cellar.model.Category;
import it.mtank.cellar.model.Product;

/**
 * A simple {@link Fragment} subclass.
 */
public class PurchasedFragment extends Fragment
{
    private Context cxt;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter salesAdapter;

    public PurchasedFragment() {}

    /**
     * {@inheritDoc}
     *
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    /**
     * {@inheritDoc}
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_purchased, container, false);

        final Context cxt = view.getContext();

        //set the DAO from data source
        CategoryDAO categoryDAO = new CategoryDAO(cxt);
        final ProductDAO productDAO = new ProductDAO(cxt);

        List<Category> list = categoryDAO.getAllCategory();

        //initialize the spinner
        Spinner spinner = inizializeSpinner(view, list);

        final RecyclerView recyclerView = view.findViewById(R.id.base_list);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id)
            {

                List<Product> products = productDAO.getAllProductByCat(id);

                setProductAdapter(recyclerView, products);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });

        return view;
    }

    /**
     * Sets and inizializes the Spinner object and sets the adapter
     *
     * @param view
     * @param list
     * @return
     */
    private Spinner inizializeSpinner(View view, List list)
    {
        Spinner spinner = view.findViewById(R.id.category_spinner);

        CategoryAdapter adapter = new CategoryAdapter(view.getContext(), list);

        spinner.setAdapter(adapter);

        return spinner;
    }

    /**
     * Sets the Adapter for the products
     *
     * @param recyclerView
     * @param list
     */
    private void setProductAdapter(RecyclerView recyclerView, List list)
    {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(cxt));

        salesAdapter = new ProductAdapter(recyclerView.getContext(), list, "purchased");

        recyclerView.setAdapter(salesAdapter);
    }
}
