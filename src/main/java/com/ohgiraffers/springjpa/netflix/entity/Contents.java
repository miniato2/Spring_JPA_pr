package com.ohgiraffers.springjpa.netflix.entity;

import jakarta.persistence.*;

@Entity(name = "Contents")
@Table(name = "net_contents")
public class Contents {
    @Id
    @Column(name = "con_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int conCode;                //번호
    @Column(name = "con_name", nullable = false)
    private String conName;             //제목
    @Column(name = "category_code", nullable = false)
    private int categoryCode;           //카테고리코드
    @Column(name = "con_nation", nullable = false)
    private String nation;              //제작국가
    @Column(name = "con_rating", nullable = false)
    private int rating;                 //연령등급

    public Contents conName(String val){
        this.conName = val;
        return this;
    }
    public Contents categoryCode(int val){
        this.categoryCode = val;
        return this;
    }
    public Contents nation(String val){
        this.nation = val;
        return this;
    }
    public Contents rating(int val){
        this.rating = val;
        return this;
    }

    public Contents builder(){
        return new Contents(conCode,conName,categoryCode,nation,rating);
    }

    protected Contents(){}

    public Contents(String conName, int categoryCode, String nation, int rating) {
        this.conName = conName;
        this.categoryCode = categoryCode;
        this.nation = nation;
        this.rating = rating;
    }

    public Contents(int conCode, String conName, int categoryCode, String nation, int rating) {
        this.conCode = conCode;
        this.conName = conName;
        this.categoryCode = categoryCode;
        this.nation = nation;
        this.rating = rating;
    }

    public int getConCode() {
        return conCode;
    }

    public String getConName() {
        return conName;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public String getNation() {
        return nation;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Contents{" +
                "conCode=" + conCode +
                ", conName='" + conName + '\'' +
                ", categoryCode=" + categoryCode +
                ", nation='" + nation + '\'' +
                ", rating=" + rating +
                '}';
    }
}
