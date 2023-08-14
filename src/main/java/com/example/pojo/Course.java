package com.example.pojo;

/**
 * @Author: 班前程
 * @Company:北京万相信息
 * @Description:
 * @DateTime: 2023/8/1 18:08
 **/
public class Course {
    private String name;
    private String teacher;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", teacher='" + teacher + '\'' +
                '}';
    }
}
