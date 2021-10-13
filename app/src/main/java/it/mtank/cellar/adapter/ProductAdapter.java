package it.mtank.cellar.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import it.mtank.cellar.DAO.ProductDAO;
import it.mtank.cellar.R;
import it.mtank.cellar.model.Product;

/**
 * Created by mtank on 19/04/2018.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder>
{

    private String action;
    private Context cxt;
    private List<Product> products;

    /**
     * Default Constructor
     *
     * @param context
     * @param products
     */
    public ProductAdapter(Context context, List products, String action)
    {
        this.cxt = context;
        this.products = products;
        this.action = action;
    }

    /**
     * ViewHolder constructor
     */
    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView title;
        public TextView subtitle;
        public TextView lblInventories;
        public EditText input;
        public Button submit;

        public ViewHolder(View row)
        {
            super(row);

            title = row.findViewById(R.id.row_label);
            subtitle = row.findViewById(R.id.rowSecond_label);
            lblInventories = row.findViewById(R.id.inventories_label);
            input = row.findViewById(R.id.value_input);
            submit = row.findViewById(R.id.submit_btn);
        }
    }

    /**
     * {@inheritDoc}
     *
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public ProductAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row, parent, false);

        return new ViewHolder(view);
    }

    /**
     * {@inheritDoc}
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(final ProductAdapter.ViewHolder holder, int position)
    {
        final Product item = products.get(position);

        holder.title.setText(item.toString(0));
        holder.subtitle.setText(item.toString(1));

        holder.lblInventories.setText("( " + item.getQuantity() + " )");

        holder.submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                actionOnSubmit(item, holder);
            }
        });
    }

    /**
     * {@inheritDoc}
     *
     * @return
     */
    @Override
    public int getItemCount()
    {
        return products.size();
    }

    /**
     * Calls the method on submit button
     *
     * @param product
     * @param holder
     */
    public void actionOnSubmit(Product product, ProductAdapter.ViewHolder holder)
    {

        boolean flag = makeAction(product, holder);

        if (flag) {
            Toast.makeText(cxt, "Campo Aggiornato", Toast.LENGTH_LONG).show();
            holder.input.setText(null);
        } else {
            Toast.makeText(cxt, "Campo non Aggiornato", Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Method to switch the operation to makes with the input
     *
     * @param product
     * @param holder
     * @return
     */
    private boolean makeAction(Product product, ProductAdapter.ViewHolder holder)
    {
        int inventories;

        ProductDAO dao = new ProductDAO(cxt);

        //gets the vakue for the action
        int value = Integer.parseInt(holder.input.getText().toString());

        //sets and makes the operation
        switch (action) {
            case "sales":
                product.setSales(value);

                inventories = product.getQuantity() - value;
                product.setQuantity(inventories);
                break;

            case "purchased":
                inventories = product.getQuantity() + value;
                product.setQuantity(inventories);
                break;
        }

        //prints the new quantity
        holder.lblInventories.setText("( " + product.getQuantity() + " )");

        return  dao.updateProduct(product);
    }
}
