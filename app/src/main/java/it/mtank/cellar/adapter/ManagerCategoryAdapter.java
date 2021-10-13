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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import it.mtank.cellar.AddCategory;
import it.mtank.cellar.CategoryManager;
import it.mtank.cellar.DAO.CategoryDAO;
import it.mtank.cellar.DAO.ProductDAO;
import it.mtank.cellar.R;
import it.mtank.cellar.UpdateCategory;
import it.mtank.cellar.model.Category;
import it.mtank.cellar.model.Product;


/**
 * Created by mtank on 19/04/2018.
 */

public class ManagerCategoryAdapter extends RecyclerView.Adapter<ManagerCategoryAdapter.ViewHolder>
{

    private String action;
    private Context cxt;
    private List<Category> categories;


    /**
     * Default Constructor
     *
     * @param context
     * @param categories
     */
    public ManagerCategoryAdapter(Context context, List categories)
    {
        this.cxt = context;
        this.categories = categories;
    }

    /**
     * ViewHolder constructor
     */
    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView title;
        public Button deleteBtn;
        public Button updateBtn;

        public ViewHolder(View row)
        {
            super(row);

            title = row.findViewById(R.id.row_label);
            deleteBtn = row.findViewById(R.id.delete_btn);
            updateBtn = row.findViewById(R.id.update_btn);
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
    public ManagerCategoryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_row, parent, false);

        return new ViewHolder(view);
    }

    /**
     * {@inheritDoc}
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(final ManagerCategoryAdapter.ViewHolder holder, int position)
    {
        final Category item = categories.get(position);

        holder.title.setText(item.getName());

        holder.updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent openUpdateCategory = new Intent(cxt, UpdateCategory.class);

                openUpdateCategory.putExtra("id", item.getId());

                cxt.startActivity(openUpdateCategory);
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
        return categories.size();
    }


    /**
     * Method to switch the operation to makes with the input
     *
     * @param category
     * @param holder
     * @return
     */
    private void actionDelete(final Category category, ManagerCategoryAdapter.ViewHolder holder)
    {
        final AlertDialog.Builder myAlert = new AlertDialog.Builder(cxt);
        myAlert.setMessage("Sicuro di voler eliminare il prodotto");

        myAlert.setCancelable(false);
        myAlert.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                CategoryDAO dao = new CategoryDAO(cxt);

                boolean flag = dao.deleteCategory(category);

                final AlertDialog.Builder dialog = new AlertDialog.Builder(cxt);

                if (flag) {
                    dialog.setMessage("Il prodotto è stato eliminato");

                    Intent refresh = new Intent(cxt, CategoryManager.class);

                    cxt.startActivity(refresh);
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
