package com.gof.code.clone;

import java.io.Serializable;

/**
 * @author: cxz
 * @create: 2020/8/5 18:54
 * @description:
 **/
public class Score implements Cloneable , Serializable {

    private String subject;

    private Integer score;

    public Score(String subject, Integer score) {
        this.subject = subject;
        this.score = score;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Score{" +
                "subject='" + subject + '\'' +
                ", score=" + score +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
