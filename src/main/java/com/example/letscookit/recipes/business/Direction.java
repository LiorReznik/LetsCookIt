package com.example.letscookit.recipes.business;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Direction {
    @Id
    @GeneratedValue
    private Integer id;
    private String direction;

    protected Direction() {
    }

    public Direction(String direction) {
        this.direction = direction;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
