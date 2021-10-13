package it.mtank.cellar.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;

import java.util.ArrayList;
import java.util.List;

import it.mtank.cellar.libs.interfaces.InterfaceCategoryDAO;
import it.mtank.cellar.model.Category;

/**
 * Interface DAO for Product
 * implement CRUD operation
 *
 * @version 1.0
 * @author Matteo Tancredi <matteotank@gmail.com>
 */

public class CategoryDAO implements InterfaceCategoryDAO
{
    private Context cxt;
    private DAOadapter adapter;

    /**
     * Dafault Construct
     *
     * @param context
     */
    public CategoryDAO(Context context)
    {
        this.cxt = context;

        adapter = new DAOadapter(cxt);
    }

    /**
     * {@inheritDoc}
     *
     * @return
     */
    @Override
    public List<Category> getAllCategory()
    {
        List categories = new ArrayList<>();
        Category category;
        Cursor rows = null;

        try {

            rows = adapter.getDb().query(TABLE, null, null,
                    null, null,null, null, null);

            if (rows.getCount() > 0) {
                while (rows.moveToNext()) {

                    category = new Category(rows.getLong(0), rows.getString(1));

                    categories.add(category);
                }
            }

        } catch (SQLiteException e) {
            e.printStackTrace();
        }

        return categories;
    }

    /**
     * {@inheritDoc}
     *
     * @param id
     * @return
     */
    @Override
    public Category getCategory(long id)
    {
        Category category = null;
        Cursor row;

        try {
            String[] args = new String[] {Long.toString(id)};

            row = adapter.getDb().query(TABLE, null, "category_id = ?",
                    args, null,null, null, null);

            row.moveToFirst();

            category = new Category(row.getLong(0), row.getString(1));

        } catch (SQLiteException e) {
            e.printStackTrace();
        }

        return category;
    }

    /**
     * {@inheritDoc}
     *
     * @param category
     * @return
     */
    @Override
    public boolean createCategory(Category category)
    {
        boolean flag = false;
        long row;

        ContentValues args = new ContentValues();

        //args.put("category_id", category.getId());
        args.put("category", category.getName());

        try {
            row = adapter.getDb().insert(TABLE, null, args);

            if (row != -1) {
                category.setId(row);
                flag = true;
            }
        } catch (SQLiteException e) {
            e.printStackTrace();
        }

        return flag;
    }

    /**
     * {@inheritDoc}
     *
     * @param category
     * @return
     */
    @Override
    public boolean updateCategory(Category category)
    {
        boolean flag = false;
        long row;

        ContentValues args = new ContentValues();

        args.put("category", category.getName());

        try {

            String[] param = new String[] {Long.toString(category.getId())};

            row = adapter.getDb().update(TABLE, args, "category_id = ?", param);

            if (row != -1) {
                flag = true;
            }
        } catch (SQLiteException e) {
            e.printStackTrace();
        }

        return flag;
    }

    /**
     * {@inheritDoc}
     *
     * @param category
     * @return
     */
    @Override
    public boolean deleteCategory(Category category)
    {
        boolean flag = false;
        int row;

        try {

            String[] param = new String[] {Long.toString(category.getId())};

            row = adapter.getDb().delete(TABLE, "category_id = ?", param);

            if (row == 1) {
                flag = true;
            }
        } catch(SQLiteException e) {
            e.printStackTrace();
        }


        return flag;
    }
}
