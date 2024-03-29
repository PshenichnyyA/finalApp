package com.example.finalapp.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Category {
    //Таблица категорий товаров
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    //Связь один ко многим т.к. одна категория может относится ко многим товарам
    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    private List<Product> product;
    //В одной категории может лежать целый лист продуктов


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

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }
}
