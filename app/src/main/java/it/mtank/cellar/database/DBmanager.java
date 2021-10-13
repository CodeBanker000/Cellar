package it.mtank.cellar.database;

import android.database.sqlite.SQLiteDatabase;

/**
 * Creates the connection to the database that is an
 * instance of singleton
 *
 * @version 1.0
 * @author Matteo Tancredi <matteotank@gmail.com>
 */

public class DBmanager
{
    /** counter */
    private int mOpenCounter;

    /** Instance singleton */
    private static DBmanager instance;
    /** Instance of class DBhelper */
    private static DBhelper myDBhelper;


    private SQLiteDatabase db;

    /**
     * default Constructor
     * @param dbhelper
     */
    private DBmanager(DBhelper dbhelper)
    {
        this.myDBhelper = dbhelper;
    }

    /**
     * Initializes the instance of connection to the databases
     *
     * @param dbhelper
     * @return
     */
    public static synchronized DBmanager getInstance(DBhelper dbhelper)
    {
        if (instance == null) {
            instance = new DBmanager(dbhelper);
        }

        return instance;
    }

    /**
     * Opens the connection to the database
     *
     * @return
     */
    public synchronized SQLiteDatabase openDB()
    {
        mOpenCounter++;

        if (mOpenCounter == 1) {
            db = myDBhelper.getWritableDatabase();
        }

        return db;
    }

    /**
     * Closes the connection to the database
     */
    public synchronized void closeDB()
    {
        mOpenCounter--;

        if (mOpenCounter == 0) {
            db.close();
        }
    }

}