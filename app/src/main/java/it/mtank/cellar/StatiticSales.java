package it.mtank.cellar;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import java.util.List;

import it.mtank.cellar.DAO.CategoryDAO;
import it.mtank.cellar.DAO.ProductDAO;
import it.mtank.cellar.adapter.CategoryAdapter;
import it.mtank.cellar.adapter.ManagerProductAdapter;
import it.mtank.cellar.adapter.SalesAdapter;
import it.mtank.cellar.model.Category;
import it.mtank.cellar.model.Product;

/**
 * Created by mtank on 15/05/2018.
 */

public class StatiticSales extends Activity
{
    private Context cxt;
    private CategoryDAO categoryDAO;
    private ProductDAO productDAO;
    private List<Category> categories;
    private List<Product> products;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mSalesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.statitic_sales);

        cxt = this;

        categoryDAO = new CategoryDAO(cxt);
        productDAO = new ProductDAO(cxt);

        categories = categoryDAO.getAllCategory();

        Spinner spinner = initializeSpinner(categories);

        recyclerView = findViewById(R.id.base_list);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {
                products = productDAO.getAllProductByCat(id);

                setManagerSalesAdapter(recyclerView, products);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    /**
     * Sets the Adapter for the products
     *
     * @param recyclerView
     * @param list
     */
    private void setManagerSalesAdapter(RecyclerView recyclerView, List list)
    {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(cxt));

        mSalesAdapter = new SalesAdapter(recyclerView.getContext(), list);

        recyclerView.setAdapter(mSalesAdapter);
    }

    /**
     * Sets and initializes the Spinner object and sets the adapter
     *
     * @param list
     * @return
     */
    private Spinner initializeSpinner(List list)
    {
        Spinner spinner = findViewById(R.id.category_spinner);

        CategoryAdapter adapter = new CategoryAdapter(cxt, list);

        spinner.setAdapter(adapter);

        return spinner;
    }
}