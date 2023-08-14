package com.example.pojo;

import java.util.Objects;

/**
 * @Author: 班前程
 * @Company:北京万相信息
 * @Description:
 * @DateTime: 2023/8/1 17:55
 **/
public class Cat {
    private String breed;
    private String name;

    public Cat() {
    }

    public Cat(String breed, String name) {
        this.breed = breed;
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return Objects.equals(breed, cat.breed) && Objects.equals(name, cat.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(breed, name);
    }
}
