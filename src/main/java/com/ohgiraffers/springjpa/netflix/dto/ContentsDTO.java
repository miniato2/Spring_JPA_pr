package com.ohgiraffers.springjpa.netflix.dto;

public class ContentsDTO {
    private int conCode;                //번호
    private String conName;             //제목
    private int categoryCode;           //카테고리코드
    private String nation;              //제작국가
    private int rating;                 //연령등급

    public ContentsDTO() {
    }

    public ContentsDTO(int conCode, String conName, int categoryCode, String nation, int rating) {
        this.conCode = conCode;
        this.conName = conName;
        this.categoryCode = categoryCode;
        this.nation = nation;
        this.rating = rating;
    }

    public int getConCode() {
        return conCode;
    }

    public void setConCode(int conCode) {
        this.conCode = conCode;
    }

    public String getConName() {
        return conName;
    }

    public void setConName(String conName) {
        this.conName = conName;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "ContentsDTO{" +
                "conCode=" + conCode +
                ", conName='" + conName + '\'' +
                ", categoryCode=" + categoryCode +
                ", nation='" + nation + '\'' +
                ", rating=" + rating +
                '}';
    }
}
