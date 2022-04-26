package com.example.appfilm;

public class Slide {
    private int Image;
    private String Title;

    public Slide(int image, String title) {
        Image = image;
        Title = title;
    }
    //add mor field depend on what u want

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }
}
