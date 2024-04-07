package com.ohgiraffers.springjpa.netflix.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "category")
@Table(name = "net_category")
public class Category {
    @Id
    @Column(name = "category_code")
    private int categoryCode;       //카테고리번호
    @Column(name = "category_name")
    private String categoryName;    //카테고리이름

    protected Category(){}

    public Category(int categoryCode, String categoryName) {
        this.categoryCode = categoryCode;
        this.categoryName = categoryName;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public String getCategoryName() {
        return categoryName;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryCode=" + categoryCode +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
