package com.geekbrains.db.model;

public class Categories {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column CATEGORIES.ID
     *
     * @mbg.generated Thu Dec 23 19:37:49 YEKT 2021
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column CATEGORIES.TITLE
     *
     * @mbg.generated Thu Dec 23 19:37:49 YEKT 2021
     */
    private String title;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CATEGORIES.ID
     *
     * @return the value of CATEGORIES.ID
     *
     * @mbg.generated Thu Dec 23 19:37:49 YEKT 2021
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CATEGORIES.ID
     *
     * @param id the value for CATEGORIES.ID
     *
     * @mbg.generated Thu Dec 23 19:37:49 YEKT 2021
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CATEGORIES.TITLE
     *
     * @return the value of CATEGORIES.TITLE
     *
     * @mbg.generated Thu Dec 23 19:37:49 YEKT 2021
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CATEGORIES.TITLE
     *
     * @param title the value for CATEGORIES.TITLE
     *
     * @mbg.generated Thu Dec 23 19:37:49 YEKT 2021
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    @Override
    public String toString() {
        return "Categories{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}