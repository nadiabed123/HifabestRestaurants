package com.example.haifasbestrestaurants;

/*
private String tof
private boolean IsKosher
private int imageid
private String category
public Resturant(String tof, boolean isKosher, int imageid, String category)

 */
public class Resturant {
    private String name;
    private String isKosher;
    private int imageid;
    private String key;

    public Resturant()
    {

    }
    public Resturant(String typeOfFood, String isKosher, int imageid, String key) {
        this.name = typeOfFood;
        this.isKosher = isKosher;
        this.imageid = imageid;
        this.key = key;
    }

    public String getTypeOfFood() {
        return this.name;
    }

    public void setTypeOfFood(String typeOfFood) {
        this.name = typeOfFood;
    }

    public String getisKosher() {
      return this.isKosher;
    }

    public void setKosher(String kosher) {
        this.isKosher = kosher;
    }

    public int getImageid() {
        return this.imageid;
    }

    public void setImageid(int imageid) {
        this.imageid = imageid;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
