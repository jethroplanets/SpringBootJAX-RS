package com.Demoproject.Demojaxrs.model;

import javax.persistence.*;

@Entity
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true  , nullable = false)
    private int code;

    @Column(unique = true  , nullable = false)
    private String levelDesc;

    public Item() {
        super();
    }

    public Item(int code, String levelDesc) {
        super();
        this.code = code;
        this.levelDesc = levelDesc;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public String getLevelDesc() {
        return levelDesc;
    }
    public void setLevelDesc(String levelDesc) {
        this.levelDesc = levelDesc;
    }

    @Override
    public String toString() {
        return "Item [code=" + code + ", levelDesc=" + levelDesc + "]";
    }


}
