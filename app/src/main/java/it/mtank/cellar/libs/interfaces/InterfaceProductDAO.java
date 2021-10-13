package it.mtank.cellar.libs.interfaces;

import java.util.List;

import it.mtank.cellar.database.DBstring;
import it.mtank.cellar.model.Product;

/**
 * Implements the interface ProductDAO
 *
 * @version 1.0
 * @author Matteo Tancredi <matteotank@gmail.com>
 */

public interface InterfaceProductDAO
{
    public static final String TABLE = DBstring.TBPRODUCTS;

    /** Gets all Product Object from DataSource */
    public List<Product> getAllProduct();

    /** Gets all Product Object from DataSource by category id */
    public List<Product> getAllProductByCat(long idCategory);

    /** Gets a Product Object from DataSource by the id */
    public Product getProduct(long id);

    /** Creates Product Object */
    public boolean createProduct(Product product);

    /** Updates Product Object */
    public boolean updateProduct(Product product);

    /** Deletes Product Object */
    public boolean deleteProduct(Product product);
}
