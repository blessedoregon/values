package com.tz.tz_web.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String count;
    private String name;
    private String position;
    private String age;
    private String price;
    private String imgP;
    private String imgC;
    private String imgCl;

    public long getId() { return id; }

    public String getCount() {
        return count;
    }

    public String getName() { return name; }

    public String getPosition() {
        return position;
    }

    public String getAge() {
        return age;
    }

    public String getPrice() {
        return price;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImgP() { return imgP; }

    public String getImgC() { return imgC; }

    public String getImgCl() { return imgCl; }

    public void setImgP(String imgP) { this.imgP = imgP; }

    public void setImgC(String imgC) { this.imgC = imgC; }

    public void setImgCl(String imgCl) { this.imgCl = imgCl; }
}
