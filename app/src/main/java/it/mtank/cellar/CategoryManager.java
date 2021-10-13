package it.mtank.cellar;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import it.mtank.cellar.DAO.CategoryDAO;
import it.mtank.cellar.adapter.ManagerCategoryAdapter;
import it.mtank.cellar.model.Category;

/**
 * Created by mtank on 27/04/2018.
 */

public class CategoryManager extends AppCompatActivity
{
    private Context cxt;
    private CategoryDAO dao;
    private List<Category> list;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mCategoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_category);

        cxt = this;

        dao = new CategoryDAO(cxt);

        list = dao.getAllCategory();

        recyclerView = findViewById(R.id.base_list);

        setManagerCategoryAdapter(recyclerView, list);
    }

    /**
     * Sets the Adapter for the products
     *
     * @param recyclerView
     * @param list
     */
    private void setManagerCategoryAdapter(RecyclerView recyclerView, List list)
    {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(cxt));

        mCategoryAdapter = new ManagerCategoryAdapter(recyclerView.getContext(), list);

        recyclerView.setAdapter(mCategoryAdapter);
    }
}

