package it.mtank.cellar.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteException;

import java.util.ArrayList;
import java.util.List;

import it.mtank.cellar.libs.interfaces.InterfaceProductDAO;
import it.mtank.cellar.model.Product;

/**
 * Implements the interface CategoryDAO
 *
 * @version 1.0
 * @author Matteo Tancredi <matteotank@gmail.com>
 */

public class ProductDAO implements InterfaceProductDAO
{
    private Context cxt;
    private DAOadapter adapter;

    /**
     * Dafault Construct
     *
     * @param context
     */
    public ProductDAO(Context context)
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
    public List<Product> getAllProduct()
    {

        List products = new ArrayList();
        Product product = null;
        Cursor rows = null;

        try {

            rows = adapter.getDb().query(TABLE, null, null,
                    null, null,null, null, null);


            if (rows.getCount() > 0) {
                while (rows.moveToNext()) {
                    boolean flag = rows.getInt(6) == 1;

                    product = new Product(rows.getLong(0), rows.getLong(1), rows.getString(2), rows.getString(3),
                                            rows.getString(4), rows.getInt(5), flag, rows.getInt(7), rows.getInt(8),
                                            rows.getInt(9), rows.getDouble(10), rows.getInt(11));

                    products.add(product);
                }
            }

        } catch (SQLiteException e) {
            e.printStackTrace();
        }

        return products;
    }

    /**
     * {@inheritDoc}
     *
     * @param idCategory
     * @return
     */
    @Override
    public List getAllProductByCat(long idCategory)
    {

        List products = new ArrayList();
        Product product = null;
        Cursor rows = null;

        try {
            String[] args = new String[] {Long.toString(idCategory)};

            rows = adapter.getDb().query(TABLE, null, "category_id = ?",
                    args, null,null, "pos ASC", null);

            if (rows.getCount() > 0) {
                while (rows.moveToNext()) {
                    boolean flag = rows.getInt(6) == 1;

                    System.out.println(rows.getColumnCount());

                    product = new Product(rows.getLong(0), rows.getLong(1), rows.getString(2), rows.getString(3),
                            rows.getString(4), rows.getInt(5), flag, rows.getInt(7), rows.getInt(8),
                            rows.getInt(9), rows.getDouble(10), rows.getInt(11));

                    products.add(product);
                }
            }

        } catch (SQLiteException e) {
            e.printStackTrace();
        }

        return products;
    }

    @Override
    public Product getProduct(long id)
    {
        Product product = null;
        Cursor row = null;

        try {
            String[] args = new String[] {Long.toString(id)};

            row = adapter.getDb().query(TABLE, null, "product_id = ?",
                    args, null,null, null, null);

            if (row.getCount() > 0) {
                row.moveToFirst();

                boolean flag = row.getInt(6) == 1;

                product = new Product(row.getLong(0), row.getLong(1), row.getString(2), row.getString(3),
                        row.getString(4), row.getInt(5), flag, row.getInt(7), row.getInt(8),
                        row.getInt(9), row.getDouble(10), row.getInt(11));
            }

        } catch (SQLiteException e) {
            e.printStackTrace();
        }

        return product;
    }

    /**
     * {@inheritDoc}
     *
     * @param product
     * @return
     */
    @Override
    public boolean createProduct(Product product)
    {
        boolean flag = false;
        int bio;
        long row;

        bio = product.isBio() ? 1 : 0;

        ContentValues args = new ContentValues();

        args.put("category_id", product.getCategoryId());
        args.put("product", product.getName());
        args.put("company", product.getCompany());
        args.put("denomination", product.getDenomination());
        args.put("year", product.getYear());
        args.put("bio", bio);
        args.put("minimum", product.getMinimum());
        args.put("quantity", product.getQuantity());
        args.put("sales", product.getSales());
        args.put("price", product.getPrice());
        args.put("pos", product.getPos());

        try {
            row = adapter.getDb().insert(TABLE, null, args);

            if (row != -1) {
                product.setId(row);
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
     * @param product
     * @return
     */
    @Override
    public boolean updateProduct(Product product)
    {
        boolean flag = false;
        long row;

        ContentValues args = new ContentValues();

        args.put("category_id", product.getCategoryId());
        args.put("product", product.getName());
        args.put("company", product.getCompany());
        args.put("denomination", product.getDenomination());
        args.put("year", product.getYear());
        args.put("bio", product.isBio());
        args.put("minimum", product.getMinimum());
        args.put("quantity", product.getQuantity());
        args.put("sales", product.getSales());
        args.put("price", product.getPrice());
        args.put("pos", product.getPos());

        try {

            String[] param = new String[] {Long.toString(product.getId())};

            row = adapter.getDb().update(TABLE, args, "product_id = ?", param);

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
     * @param product
     * @return
     */
    @Override
    public boolean deleteProduct(Product product)
    {
        boolean flag = false;
        int row;

        try {

            String[] param = new String[] {Long.toString(product.getId())};

            row = adapter.getDb().delete(TABLE, "product_id = ?", param);

            if (row == 1) {
                flag = true;
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }


        return flag;
    }
}
