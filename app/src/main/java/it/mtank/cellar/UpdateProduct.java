package it.mtank.cellar;

import android.content.Context;
import android.content.Intent;
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

public class UpdateProduct extends AppCompatActivity
{
    private Context cxt;
    private CategoryDAO categoryDAO;
    private ProductDAO productDAO;
    private Product product;
    private List<Category> list;
    private long catValue;
    private Object denomValue;
    private int bioValue;
    private int sales;
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
        setContentView(R.layout.update_product);

        cxt = this;

        //gets data from the previous activity
        Bundle data = getIntent().getExtras();

        categoryDAO = new CategoryDAO(cxt);
        productDAO = new ProductDAO(cxt);

        product = productDAO.getProduct(data.getLong("id"));

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
        price = findViewById(R.id.price_input);
        pos = findViewById(R.id.pos_input);
        submit = findViewById(R.id.submit_btn);

        setValueProduct(product);

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
                    if (setProduct(product)) {
                        Toast.makeText(cxt, "Prodotto modificato!", Toast.LENGTH_SHORT).show();

                        Intent openBack = new Intent(cxt, ProductManager.class);
                        cxt.startActivity(openBack);
                    } else {
                        Toast.makeText(cxt, "Prodotto non modificato!", Toast.LENGTH_SHORT).show();
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

    private void setValueProduct(Product product)
    {

        category.setSelection((int) (product.getCategoryId() - 1));

        name.setText(product.getName());
        company.setText(product.getCompany());

        if (product.getDenomination() != null) {
            for (int i = 0; i < denomination.getCount(); i++) {
                Object denValue = denomination.getAdapter().getItem(i);

                if (denValue.equals(product.getDenomination())) {
                    denomination.setSelection(i);
                }
            }
        }

        year.setText(Integer.toString(product.getYear()));
        bio.setChecked(product.isBio());
        minimum.setText(Integer.toString(product.getMinimum()));
        quantity.setText(Integer.toString(product.getQuantity()));
        price.setText(Double.toString(product.getPrice()));
        pos.setText(Integer.toString(product.getPos()));
        sales = product.getSales();
    }

    private boolean setProduct(Product product)
    {
        boolean flag;

        int yearValue = year.getText().toString().length() == 0 ? null : Integer.parseInt(year.getText().toString());
        int minValue = minimum.getText().toString().length() == 0 ? 0 : Integer.parseInt(minimum.getText().toString());
        int qtyValue = quantity.getText().toString().length() == 0 ? 0 : Integer.parseInt(quantity.getText().toString());
        int posValue = pos.getText().toString().length() == 0 ? 0 : Integer.parseInt(pos.getText().toString());
        double priceValue = price.getText().toString().length() == 0 ? 0.00 : Double.parseDouble(price.getText().toString());

        product.setCategoryId(catValue);
        product.setName(name.getText().toString());
        product.setCompany(company.getText().toString());
        product.setDenomination(denomValue.toString());
        product.setYear(yearValue);
        product.setBio(bio.isChecked());
        product.setMinimum(minValue);
        product.setQuantity(qtyValue);
        product.setPrice(priceValue);
        product.setPos(posValue);

        flag = productDAO.updateProduct(product);

        return flag;
    }
}
