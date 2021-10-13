package it.mtank.cellar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.List;

import it.mtank.cellar.DAO.CategoryDAO;
import it.mtank.cellar.DAO.ProductDAO;
import it.mtank.cellar.model.Category;
import it.mtank.cellar.model.Product;

/**
 * Created by mtank on 09/05/2018.
 */

public class SendInventories extends AppCompatActivity
{
    private Context cxt;
    private CheckBox emailTo;
    private Button send;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send_inventories);

        cxt = this;

        emailTo = findViewById(R.id.email);
        send = findViewById(R.id.send_email);

        send.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                sendEmail();
            }
        });
    }

    private void sendEmail()
    {
        if(emailTo.isChecked()) {
            final String emailToString = emailTo.getText().toString();

            String message = setMessage();

            Intent email = new Intent(Intent.ACTION_SEND);

                email.putExtra(Intent.EXTRA_EMAIL, new String[] {emailToString});

                email.putExtra(Intent.EXTRA_SUBJECT, "Inventario Vino");

                email.putExtra(Intent.EXTRA_TEXT, message);

                email.setType("message/rfc822");

                startActivity(Intent.createChooser(email, "Scegli il client:"));

        } else {
            Toast.makeText(cxt, "l'email deve essere selezionata", Toast.LENGTH_LONG).show();
        }
    }

    private String setMessage()
    {
        String message = "";

        CategoryDAO categoryDAO = new CategoryDAO(cxt);
        ProductDAO productDAO = new ProductDAO(cxt);

        List<Category> categories = categoryDAO.getAllCategory();

        for (Category category:categories) {
            message += category.getName() + ": \n";

            List<Product> products = productDAO.getAllProductByCat(category.getId());

            for (Product product:products) {
                message += product.getName() + " - " + product.getCompany() + " - " + product.getYear() + " --- " + product.getQuantity() + "\n";
            }
        }

        return message;
    }
}
