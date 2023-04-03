package com.example.honeypop;

public class Model_text_IMG {
    String text;

    public String get_text() {
        return text;
    }

    public void set_text(String text) {
        this.text = text;
    }

    int img;
    public int get_img_id() {
        return img;
    }

    public void set_img_id(int img) {
        this.img = img;
    }

    Model_text_IMG(String text, int img) {
        this.text = text;
        this.img = img;
    }
}
