package it.mtank.cellar.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import it.mtank.cellar.R;
import it.mtank.cellar.model.Category;

/**
 * Extends the BaseAdapter to set the spinner row
 * for the Category
 *
 * @version 1.0
 * @author Matteo Tancredi <matteotank@gmail.com>
 */

public class CategoryAdapter extends BaseAdapter
{
    private List<Category> list;
    private Context cxt;

    /**
     * Default Constructor
     *
     * @param cxt
     * @param categories
     */
    public CategoryAdapter(Context cxt, List<Category> categories)
    {
        this.cxt = cxt;
        this.list = categories;
    }

    @Override
    public int getCount()
    {
        return list.size();
    }

    @Override
    public Object getItem(int position)
    {
        return list.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return getItem(position).hashCode();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup)
    {
        if (view == null) {
            view = LayoutInflater.from(cxt).inflate(R.layout.spinner_row, null);
        }

        Category category = (Category) getItem(position);
        TextView txtLabel = view.findViewById(R.id.item_spinner);
        txtLabel.setText(category.getName());

        return view;
    }
}
