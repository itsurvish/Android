package com.example.pritjoshi.prit_project1;


import java.util.ArrayList;

public class ProductSingleton {
    private ArrayList<Product> mProductList;
    private static com.example.pritjoshi.prit_project1.ProductSingleton mProductSingleton;

    public static com.example.pritjoshi.prit_project1.ProductSingleton getProductSingleton() {
        if (mProductSingleton == null) {
            mProductSingleton = new com.example.pritjoshi.prit_project1.ProductSingleton();
        }
        return mProductSingleton;
    }

    private ProductSingleton() {
        mProductList = new ArrayList<>();

        Product product1 = new Product("Jaguar XE", "xe", (float) 43900.00);
        Product product2 = new Product("Jaguar XF", "xf",(float) 59100.00);
        Product product3 = new Product("Jaguar XJ", "xj",(float) 93500.00);
        Product product4 = new Product("Jaguar E-PACE", "epace",(float) 42900);
        Product product5 = new Product("Jaguar F-PACE", "fpace",(float) 51500);
        Product product6 = new Product("Jaguar F-TYPE", "ftype",(float) 69500);
        Product product7 = new Product("Jaguar I-TYPE", "ipace",(float) 86500);
        mProductList.add(product1);
        mProductList.add(product2);
        mProductList.add(product3);
        mProductList.add(product4);
        mProductList.add(product5);
        mProductList.add(product6);
        mProductList.add(product7);
    }

    public ArrayList<Product> getmProductList() {return mProductList;}
}
