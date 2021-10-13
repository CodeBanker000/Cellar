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
 * Extends the RecyclerViewAdapter to set the row
 * for the fragment Orders
 *
 * @version 1.0
 * @author Matteo Tancredi <matteotank@gmail.com>
 */

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder>
{

    private Context cxt;
    private List<Product> products;

    /**
     * Default Constructor
     *
     * @param context
     * @param products
     */
    public OrderAdapter(Context context, List products)
    {
        this.cxt = context;
        this.products = products;
    }

    /**
     * ViewHolder constructor
     */
    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView title;
        public TextView subtitle;
        public TextView lblInventories;

        public ViewHolder(View row)
        {
            super(row);

            title = row.findViewById(R.id.row_label);
            subtitle = row.findViewById(R.id.rowSecond_label);
            lblInventories = row.findViewById(R.id.inventories_label);
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
    public OrderAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_orders, parent, false);

        return new ViewHolder(view);
    }

    /**
     * {@inheritDoc}
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(final OrderAdapter.ViewHolder holder, int position)
    {
        final Product item = products.get(position);

        holder.title.setText(item.toString(0));
        holder.subtitle.setText(item.toString(1));

        holder.lblInventories.setText("( " + setValueOrder(item) + " )");

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
     * Method to switch the operation to makes with the input
     *
     * @param product
     * @return
     */
    private int setValueOrder(Product product)
    {
        int order;
        int minimum = product.getMinimum();
        int quantity = product.getQuantity();

        if (quantity < minimum) {
            order = minimum - quantity;
            return order;
        } else {
            return 0;
        }
    }
}
