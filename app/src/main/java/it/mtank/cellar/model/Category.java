package it.mtank.cellar.model;


/**
 * Entity of Category POJO
 *
 * @version 1.0
 * @author Matteo Tancredi <matteotank@gmail.com>
 */

public class Category
{
    /** Category ID */
    private long id;
    /** Name of category */
    private String name;

    /**
     * Default constructor of Category
     *
     * @param id
     * @param name
     */
    public Category(long id, String name)
    {
        this.id = id;
        this.name = name;
    }

    /**
     * Default constructor of Category
     *
     * @param name
     */
    public Category(String name)
    {
        this.name = name;
    }

    /**
     * Gets the ID of category
     * @return
     */
    public long getId()
    {
        return id;
    }

    /**
     * Sets the ID of category
     *
     * @param id
     */
    public void setId(long id)
    {
        this.id = id;
    }

    /**
     * Gets the name value of category
     *
     * @return
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name of category
     *
     * @param name
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Checks if the passed object is equal to another
     * that compare their ID
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        return id == category.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
