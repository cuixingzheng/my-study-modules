package com.gof.code.clone;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @author: cxz
 * @create: 2020/8/5 18:53
 * @description:
 **/
public class User implements Cloneable, Serializable {

    private Integer id;
    private String name;
    private Score score;
    private int[] items;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        User clone = (User)super.clone();
        if(this.score != null)
           clone.setScore((Score) this.score.clone());
        return clone;
    }

    public User(Integer id, String name, Score score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public User(Integer id, String name, Score score, int[] items) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.items = items;
    }

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public int[] getItems() {
        return items;
    }

    public void setItems(int[] items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                ", items=" + Arrays.toString(items) +
                '}';
    }
}
