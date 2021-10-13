package it.mtank.cellar.model;

/**
 * Entity of Product POJO
 *
 * @version 1.0
 * @author Matteo Tancredi <matteotank@gmail.com>
 */

public class Product
{
    /** ID product */
    private long id;
    /** ID category */
    private long categoryId;
    /** name of product */
    private String name;
    /** name of company */
    private String company;
    /** type of denomination */
    private String denomination;
    /** biologic */
    private boolean bio;
    /** year of product */
    private int year;
    /** minimum of pieces in cellar */
    private int minimum;
    /** quantity of product */
    private int quantity;
    /** product saled */
    private int sales;
    /** cost of product */
    private double price;
    /** position of order */
    private int pos;


    /**
     * Default Constructor
     *
     * @param id
     * @param categoryId
     * @param name
     * @param company
     * @param denomination
     * @param bio
     * @param year
     * @param minimum
     * @param quantity
     * @param sales
     * @param price
     */
    public Product(long id, long categoryId, String name, String company, String denomination, int year, boolean bio,
                   int minimum, int quantity, int sales, double price, int pos)
    {
        this.id = id;
        this.categoryId = categoryId;
        this.name = name;
        this.company = company;
        this.denomination = denomination;
        this.bio = bio;
        this.year = year;
        this.minimum = minimum;
        this.quantity = quantity;
        this.sales = sales;
        this.price = price;
        this.pos = pos;
    }

    /**
     * Default Constructor
     *
     * @param categoryId
     * @param name
     * @param company
     * @param denomination
     * @param bio
     * @param year
     * @param minimum
     * @param quantity
     * @param sales
     * @param price
     */
    public Product(long categoryId, String name, String company, String denomination, int year, boolean bio,
                   int minimum, int quantity, int sales, double price, int pos)
    {
        this.categoryId = categoryId;
        this.name = name;
        this.company = company;
        this.denomination = denomination;
        this.bio = bio;
        this.year = year;
        this.minimum = minimum;
        this.quantity = quantity;
        this.sales = sales;
        this.price = price;
        this.pos = pos;
    }

    /**
     * Gets the product ID
     *
     * @return
     */
    public long getId()
    {
        return id;
    }

    /**
     * Sets the product ID
     * @param id
     */
    public void setId(long id)
    {
        this.id = id;
    }

    /**
     * Gets the category ID
     *
     * @return
     */
    public long getCategoryId()
    {
        return categoryId;
    }

    /**
     * Sets the ID category
     *
     * @param categoryId
     */
    public void setCategoryId(long categoryId)
    {
        this.categoryId = categoryId;
    }

    /**
     * Gets the product's name
     *
     * @return
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the product's name
     *
     * @param name
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Gets the company's name
     *
     * @return
     */
    public String getCompany()
    {
        return company;
    }

    /**
     * Sets the company's name
     *
     * @param company
     */
    public void setCompany(String company)
    {
        this.company = company;
    }

    /**
     * Gets the year's product
     *
     * @return
     */
    public int getYear()
    {
        return year;
    }

    /**
     * Sets the year's product
     * @param year
     */
    public void setYear(int year)
    {
        this.year = year;
    }

    /**
     * Gets the product minimum
     *
     * @return
     */
    public int getMinimum()
    {
        return minimum;
    }

    /**
     * Sets the product minimum
     *
     * @param minimum
     */
    public void setMinimum(int minimum)
    {
        this.minimum = minimum;
    }

    /**
     * Gets the quantity
     *
     * @return
     */
    public int getQuantity()
    {
        return quantity;
    }

    /**
     * Sets the quantity
     *
     * @param quantity
     */
    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    /**
     * Gets the product's denomination
     *
     * @return
     */
    public String getDenomination()
    {
        return denomination;
    }

    /**
     * Sets the product's denomination
     *
     * @param denomination
     */
    public void setDenomination(String denomination)
    {
        this.denomination = denomination;
    }

    /**
     * Verify if is biologic
     * @return
     */
    public boolean isBio()
    {
        return bio;
    }

    /**
     * Sets the flag biologic
     *
     * @param bio
     */
    public void setBio(boolean bio)
    {
        this.bio = bio;
    }

    /**
     * Gets the quantity saled
     *
     * @return
     */
    public int getSales()
    {
        return sales;
    }

    /**
     * Sets the sales
     * @param sales
     */
    public void setSales(int sales)
    {
        this.sales = sales;
    }

    /**
     * Gets the product's price
     * @return
     */
    public double getPrice()
    {
        return price;
    }

    /**
     * Sets the product's price
     * @param price
     */
    public void setPrice(double price)
    {
        this.price = price;
    }

    /**
     * Gets the position of the product
     * @return
     */
    public int getPos()
    {
        return pos;
    }

    /**
     * Sets the position of product
     * @param pos
     */
    public void setPos(int pos)
    {
        this.pos = pos;
    }

    public String toString(int code)
    {
        String string = null;

        switch (code) {
            case 0:
                string = String.format("%s - %s", this.getName(), this.getCompany());
                break;

            case 1:
                String bio = (this.isBio()) ? "bio" : null;

                string = String.format("%s - %d - %s", this.getDenomination(), this.getYear(), bio);
                break;
        }

        return string;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        return id == product.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}