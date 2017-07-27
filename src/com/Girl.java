package com;

public class Girl {
    private int id;
    private String name;
    private String image;
    /**
     *setºÍget·½·¨
     */
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    @Override
    public String toString() {
        return "People [id=" + id + ", image=" + image + ", name=" + name + "]";
    }

}