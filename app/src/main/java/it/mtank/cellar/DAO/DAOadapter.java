package it.mtank.cellar.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import it.mtank.cellar.database.DBhelper;
import it.mtank.cellar.database.DBmanager;
import it.mtank.cellar.database.DBstring;

/**
 * Connects to the DataSource
 *
 * @version 1.0
 * @author Matteo Tancredi <matteotank@gmail.com>
 */

public class DAOadapter
{
    private Context cxt;
    private SQLiteDatabase db;

    public DAOadapter(Context context)
    {
        this.cxt = context;

        this.db = DBmanager.getInstance(new DBhelper(cxt)).openDB();

        this.fillDB();
    }

    /**
     * Gets the instance to the database
     *
     * @return
     */
    public SQLiteDatabase getDb()
    {
        return this.db;
    }

    /**
     * Fills the table with the dafault values
     */
    private void fillDB()
    {
        Cursor rowsCategory = db.query("categories", null, null, null, null, null, null, null);

        if (rowsCategory.getCount() == 0) {
            db.execSQL(DBstring.FILL_CATEGORIES);
        }

        Cursor rowsProducts = db.query("products", null, null, null, null, null, null, null);

        if (rowsProducts.getCount() == 0) {
            db.execSQL(DBstring.FILL_PRODUCTS);
        }
    }
}
