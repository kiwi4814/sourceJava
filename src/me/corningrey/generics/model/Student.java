package me.corningrey.generics.model;

public class Student implements Comparable<Student> {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Student o) {
        if (age > o.age) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "学生信息{" +
                "名称='" + name + '\'' +
                ", 年龄=" + age +
                '}';
    }
}