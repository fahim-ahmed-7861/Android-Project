package com.example.asus.searchviewtest;

public class player {

    private String name ;

    private int img;

    public player(String name, int img) {
        this.name = name;
        this.img = img;
    }

    public String getName()
    {
        return name ;
    }
    public  void setName()
    {
        this.name= name;
    }

    public int getImg()
    {
        return img ;
    }
    public  void setImg()
    {
        this.img= img;
    }
}
