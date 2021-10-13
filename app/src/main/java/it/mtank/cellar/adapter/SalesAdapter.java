package it.mtank.cellar.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import it.mtank.cellar.R;
import it.mtank.cellar.model.Product;

/**
 * Extends the RecyclerViewAdapter to set the row
 * for the fragment Orders
 *
 * @version 1.0
 * @author Matteo Tancredi <matteotank@gmail.com>
 */

public class SalesAdapter extends RecyclerView.Adapter<SalesAdapter.ViewHolder>
{

    private Context cxt;
    private List<Product> products;

    /**
     * Default Constructor
     *
     * @param context
     * @param products
     */
    public SalesAdapter(Context context, List products)
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
        public TextView lblSales;

        public ViewHolder(View row)
        {
            super(row);

            title = row.findViewById(R.id.row_label);
            subtitle = row.findViewById(R.id.rowSecond_label);
            lblSales = row.findViewById(R.id.sales_label);
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
    public SalesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_sales, parent, false);

        return new ViewHolder(view);
    }

    /**
     * {@inheritDoc}
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(final SalesAdapter.ViewHolder holder, int position)
    {
        final Product item = products.get(position);

        holder.title.setText(item.toString(0));
        holder.subtitle.setText(item.toString(1));

        holder.lblSales.setText("( " + item.getSales() + " )");

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

}
