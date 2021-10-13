package it.mtank.cellar.libs.interfaces;

import java.util.List;

import it.mtank.cellar.database.DBstring;
import it.mtank.cellar.model.Category;

/**
 * Interface DAO for Category
 * implement CRUD operation
 *
 * @version 1.0
 * @author Matteo Tancredi <matteotank@gmail.com>
 */

public interface InterfaceCategoryDAO
{
    public static final String TABLE = DBstring.TBCATEGORIES;

    /** Gets all Category Object from DataSource */
    public List<Category> getAllCategory();

    /** Gets a Category Object from DataSource by the id */
    public Category getCategory(long id);

    /** Creates Category Object */
    public boolean createCategory(Category category);

    /** Updates Category Object */
    public boolean updateCategory(Category category);

    /** Deletes Category Object */
    public boolean deleteCategory(Category category);
}
