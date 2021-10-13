package it.mtank.cellar;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import it.mtank.cellar.DAO.CategoryDAO;
import it.mtank.cellar.DAO.ProductDAO;
import it.mtank.cellar.adapter.CategoryAdapter;
import it.mtank.cellar.model.Category;
import it.mtank.cellar.model.Product;

/**
 * Created by mtank on 01/05/2018.
 */

public class AddProduct extends AppCompatActivity
{
    private Context cxt;
    private CategoryDAO categoryDAO;
    private ProductDAO productDAO;
    private Product product;
    private List<Category> list;
    private long catValue;
    private Object denomValue;
    private int bioValue;
    private Spinner category;
    private EditText name;
    private EditText company;
    private EditText year;
    private Spinner denomination;
    private CheckBox bio;
    private EditText minimum;
    private EditText quantity;
    private EditText pos;
    private EditText price;
    private Button submit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_product);

        cxt = this;

        categoryDAO = new CategoryDAO(cxt);
        productDAO = new ProductDAO(cxt);

        list = categoryDAO.getAllCategory();

        // initialize the component form
        category = initializeSpinnerCategory(list);

        name = findViewById(R.id.name_input);
        company = findViewById(R.id.company_input);
        denomination = initializeSpinnerDenomination();
        year = findViewById(R.id.year_input);
        bio = findViewById(R.id.bio_checkbox);
        minimum = findViewById(R.id.minimum_input);
        quantity = findViewById(R.id.quantity_input);
        pos = findViewById(R.id.pos_input);
        price = findViewById(R.id.price_input);
        submit = findViewById(R.id.submit_btn);

        category.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                catValue = id;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });

        denomination.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                denomValue = adapterView.getItemAtPosition(position);

                if (denomValue.toString() == "nessuna") {
                    denomValue = null;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        submit.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view) {
                if (validateForm()) {
                    if (setProduct()) {
                        Toast.makeText(cxt, "Prodotto inserito!", Toast.LENGTH_SHORT).show();
                        name.setText(null);
                        company.setText(null);
                        denomination.setSelection(0);
                        year.setText(null);
                        bio.setChecked(false);
                        minimum.setText(null);
                        quantity.setText(null);
                        pos.setText(null);
                        price.setText(null);
                    } else {
                        Toast.makeText(cxt, "Prodotto non inserito!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }

    /**
     * Sets and inizializes the Spinner object and sets the adapter
     *
     * @param list
     * @return
     */
    private Spinner initializeSpinnerCategory(List list)
    {
        Spinner spinner = findViewById(R.id.category_spinner);

        CategoryAdapter adapter = new CategoryAdapter(cxt, list);

        spinner.setAdapter(adapter);

        return spinner;
    }

    /**
     * Sets and inizializes the Spinner object and sets the adapter
     *
     * @return
     */
    private Spinner initializeSpinnerDenomination()
    {
        Spinner spinner = findViewById(R.id.denomination_spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(cxt,
                R.array.denomination_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        return spinner;
    }

    private boolean validateForm()
    {
        if(name.getText().toString().length() == 0) {
            name.setError("Il campo non puo essere vuoto!");
            return false;
        } else if (company.getText().toString().length() == 0) {
            company.setError("Il campo non puo essere vuoto!");
            return false;
        }

        return true;
    }

    private boolean setProduct()
    {
        boolean flag;

        int yearValue = year.getText().toString().length() == 0 ? null : Integer.parseInt(year.getText().toString());
        int minValue = minimum.getText().toString().length() == 0 ? 0 : Integer.parseInt(minimum.getText().toString());
        int qtyValue = quantity.getText().toString().length() == 0 ? 0 : Integer.parseInt(quantity.getText().toString());
        int posValue = pos.getText().toString().length() == 0 ? 0 : Integer.parseInt(pos.getText().toString());
        double priceValue = price.getText().toString().length() == 0 ? 0.00 : Double.parseDouble(price.getText().toString());

        product = new Product(
                catValue,
                name.getText().toString(),
                company.getText().toString(),
                denomValue.toString(),
                yearValue,
                bio.isChecked(),
                minValue,
                qtyValue,
                0,
                priceValue,
                posValue
        );

        flag = productDAO.createProduct(product);

        return flag;
    }
}
