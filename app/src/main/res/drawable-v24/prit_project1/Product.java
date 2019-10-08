package com.example.pritjoshi.prit_project1;

class Product {

    public String name;
    public String img;
    public Float price;

    public Product(String name, String img, Float price ) {
        this.name= name;
        this.img= img;
        this.price=price;
    }

    public Product(){

    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
