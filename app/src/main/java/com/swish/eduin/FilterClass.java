package com.swish.eduin;

public class FilterClass {
    public static final String TABLE_NAME = "FilterClass";

    public static final String NAME = "name";
    public static final String LOCATION = "location";
    public static final String PH_NO = "phno";

    public String location;
    public String syllabus;
    public String category;


    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + NAME + " Text,"
                    + LOCATION + " Text,"
                    + PH_NO + " Text"
                    + ")";

    public FilterClass() {
    }

    public FilterClass(String location , String syllabus, String category) {
        this.location = location;
        this.syllabus = syllabus;
        this.category = category;
    }

    public String getLocation() { return location; }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSyllabus() {
        return syllabus;
    }

    public void setSyllabus(String syllabus) {
        this.syllabus = syllabus;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
