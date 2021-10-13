package it.mtank.cellar.libs.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

import java.util.List;

import it.mtank.cellar.AddCategory;
import it.mtank.cellar.AddProduct;
import it.mtank.cellar.CategoryManager;
import it.mtank.cellar.DAO.CategoryDAO;
import it.mtank.cellar.DAO.ProductDAO;
import it.mtank.cellar.ProductManager;
import it.mtank.cellar.R;
import it.mtank.cellar.SendInventories;
import it.mtank.cellar.StatiticSales;
import it.mtank.cellar.model.Category;
import it.mtank.cellar.model.Product;


/**
 * A simple {@link Fragment} subclass.
 *
 */
public class ManagementFragment extends Fragment
{

    private Button addCategoryButton;
    private Button categoryButton;
    private Button addProductButton;
    private Button productButton;
    private Button sendEmail;
    private Button graphButton;
    /**
     * Default Constructor
     */
    public ManagementFragment() {}

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
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_management, container, false);

        //initializes the buttons
        addCategoryButton = view.findViewById(R.id.add_category_btn);
        categoryButton = view.findViewById(R.id.category_btn);
        addProductButton = view.findViewById(R.id.add_product_btn);
        productButton = view.findViewById(R.id.product_btn);
        sendEmail = view.findViewById(R.id.inventories_btn);
        graphButton = view.findViewById(R.id.graph_btn);

        addCategoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent openAddCategory = new Intent(container.getContext(), AddCategory.class);
                startActivity(openAddCategory);
            }
        });

        categoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent openCategoryManager = new Intent(container.getContext(), CategoryManager.class);
                startActivity(openCategoryManager);
            }
        });

        addProductButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent openAddProduct = new Intent(container.getContext(), AddProduct.class);
                startActivity(openAddProduct);
            }
        });

        productButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent openProductManager = new Intent(container.getContext(), ProductManager.class);
                startActivity(openProductManager);
            }
        });

        sendEmail.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent openSendEmail = new Intent(container.getContext(), SendInventories.class);
                startActivity(openSendEmail);
            }
        });

        graphButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent openGraph = new Intent(container.getContext(), StatiticSales.class);
                startActivity(openGraph);
            }
        });
        return view;
    }
}
