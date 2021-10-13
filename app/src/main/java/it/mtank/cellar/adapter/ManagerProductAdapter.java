package it.mtank.cellar.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import it.mtank.cellar.CategoryManager;
import it.mtank.cellar.DAO.CategoryDAO;
import it.mtank.cellar.DAO.ProductDAO;
import it.mtank.cellar.R;
import it.mtank.cellar.UpdateCategory;
import it.mtank.cellar.UpdateProduct;
import it.mtank.cellar.model.Category;
import it.mtank.cellar.model.Product;


/**
 * Created by mtank on 19/04/2018.
 */

public class ManagerProductAdapter extends RecyclerView.Adapter<ManagerProductAdapter.ViewHolder>
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
    public ManagerProductAdapter(Context context, List products)
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
        public Button deleteBtn;
        public Button updateBtn;
        public Button duplicateBtn;

        public ViewHolder(View row)
        {
            super(row);

            title = row.findViewById(R.id.row_label);
            deleteBtn = row.findViewById(R.id.delete_btn);
            updateBtn = row.findViewById(R.id.update_btn);
            duplicateBtn = row.findViewById(R.id.duplicate_btn);
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
    public ManagerProductAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_row, parent, false);

        return new ViewHolder(view);
    }

    /**
     * {@inheritDoc}
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(final ManagerProductAdapter.ViewHolder holder, int position)
    {
        final Product item = products.get(position);

        holder.title.setText(item.getName() + " - " + item.getCompany() + " - " + item.getYear());

        holder.updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent openUpdateProduct = new Intent(cxt, UpdateProduct.class);

                openUpdateProduct.putExtra("id", item.getId());

                cxt.startActivity(openUpdateProduct);
            }
        });

        holder.duplicateBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {

            }
        });

        holder.deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                actionDelete(item, holder);
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
     * Method to switch the operation to makes with the input
     *
     * @param product
     * @param holder
     * @return
     */
    private void actionDelete(final Product product, ManagerProductAdapter.ViewHolder holder)
    {
        final AlertDialog.Builder myAlert = new AlertDialog.Builder(cxt);
        myAlert.setMessage("Sicuro di voler eliminare il prodotto");

        myAlert.setCancelable(false);
        myAlert.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                ProductDAO dao = new ProductDAO(cxt);

                boolean flag = dao.deleteProduct(product);

                final AlertDialog.Builder dialog = new AlertDialog.Builder(cxt);

                if (flag) {
                    dialog.setMessage("Il prodotto è stato eliminato");
                } else {
                    dialog.setMessage("Il prodotto non è stato eliminato");
                }

                AlertDialog box = dialog.create();
                box.show();
            }
        });

        myAlert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AlertDialog alert = myAlert.create();
        alert.show();
    }

}
