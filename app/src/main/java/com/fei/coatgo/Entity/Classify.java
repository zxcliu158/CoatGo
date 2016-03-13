package com.fei.coatgo.Entity;


import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

@Table(name ="Classify")
public class Classify {
    @Column(name = "id",isId = true)
    private int id;
    @Column(name = "c_id")
    private String c_id;
    @Column(name = "c_name")
    private String c_name;
    @Column(name = "c_child")
    private String c_child;
    @Column(name = "img_rid")
    private int img_rid;

    public Classify(String c_name,String c_id,int img_rid){
        this.c_name=c_name;
        this.c_id=c_id;
        this.img_rid=img_rid;
    }

    public int getImg_rid() {
        return img_rid;
    }

    public void setImg_rid(int img_rid) {
        this.img_rid = img_rid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getC_id() {
        return c_id;
    }

    public void setC_id(String c_id) {
        this.c_id = c_id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getC_child() {
        return c_child;
    }

    public void setC_child(String c_child) {
        this.c_child = c_child;
    }
}
