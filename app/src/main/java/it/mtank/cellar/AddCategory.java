package it.mtank.cellar;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import it.mtank.cellar.DAO.CategoryDAO;
import it.mtank.cellar.model.Category;

/**
 * Created by mtank on 25/04/2018.
 */

public class AddCategory extends AppCompatActivity
{
    private Context cxt;
    private EditText categoryInput;
    private Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_category);

        this.cxt = this;

        categoryInput = findViewById(R.id.category_input);
        buttonSubmit = findViewById(R.id.submit_btn);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String value = categoryInput.getText().toString();

                if (setNewCategory(value)) {
                    Toast.makeText(cxt, "Categoria Creata", Toast.LENGTH_LONG).show();
                    categoryInput.setText(null);
                } else {
                    Toast.makeText(cxt, "Categoria Non Creata", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    private boolean setNewCategory(String name)
    {
        Category category;
        CategoryDAO dao;

        category = new Category(name);

        dao = new CategoryDAO(cxt);

        boolean result = dao.createCategory(category);

        return result;
    }
}
