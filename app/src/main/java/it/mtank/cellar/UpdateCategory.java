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
 * Created by mtank on 27/04/2018.
 */

public class UpdateCategory extends AppCompatActivity
{
    private Context cxt;
    private EditText categoryInput;
    private Button submitBtn;
    private CategoryDAO dao;
    private Category category;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_category);

        cxt = this;

        //gets data from the previous activity
        Bundle data = getIntent().getExtras();

        categoryInput = findViewById(R.id.category_input);
        submitBtn = findViewById(R.id.submit_btn);

        dao = new CategoryDAO(cxt);
        category = dao.getCategory(data.getLong("id"));

        categoryInput.setText(category.getName());

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(actionUpdate(category)) {
                    Toast.makeText(cxt, "Campo Aggiornato", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(cxt, "Campo non Aggiornato", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean actionUpdate(Category category)
    {
        category.setName(categoryInput.getText().toString());

        return dao.updateCategory(category);
    }
}
