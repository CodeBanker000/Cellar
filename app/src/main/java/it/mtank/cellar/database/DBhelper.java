package it.mtank.cellar.database;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


/**
 * Creates or upgrades the database
 *
 * @version 1.0
 * @author Matteo Tancredi <matteotank@gmail.com>
 */

public class DBhelper extends SQLiteOpenHelper
{

    /**
     * Constructor class
     * create the database for the app
     *
     * @param cxt
     */
    public DBhelper(Context cxt)
    {
        super(cxt, DBstring.DBNAME, null, DBstring.DBVERSION);
    }

    /**
     * Creates the tables
     *
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        try {
            db.execSQL(DBstring.DBCREATE_CATEGORIES);
            db.execSQL(DBstring.DBCREATE_PRODUCTS);
        } catch (SQLException e) {
            Log.w("DATABASE", e);
        }
    }

    /**
     *  TODO: for upgrades the database
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        try {
            db.execSQL(DBstring.DBDELETE_TBCATEGORIES);
            db.execSQL(DBstring.DBDELETE_TBPRODUCTS);
            onCreate(db);
        } catch (SQLException e) {
            Log.w("DATABASE", e);
        }
    }

}
