/*
 * @ (#) Course.java    1.0     8/26/2024
 * Copyright (c) 2024 IUH. All rights reserved
 */

package edu.iuh.fit;

/*
 * @description: Mo ta cac khoa hoc trong truong hoc
 * @author: Doan, Nguyen Nhut
 * @version: 1.0
 * @created: 8/26/2024 11:32 AM
 */
public class Course {
    //attributes
    private String id;
    private String title;
    private int credit;
    private String department;
    //constructors
    public Course () {
        this(" ", " ",0," ");
    }
    public Course (String id, String title, int credit, String department) {
        this.id = id;
        this.title = title;
        this.credit = credit;
        this.department = department;
    }
    //Method

    //Getter
    public String getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public int getCredit() {
        return credit;
    }
    public String getDepartment() {
        return department;
    }
    public void setId(String id) {
        if (id == null || id.length()<3)
            throw new IllegalArgumentException("ID must have at least 3 characters");
        for (int i=0;i<id.length();i++) {
            if (!Character.isLetterOrDigit(id.charAt(i)))
                throw new IllegalArgumentException("ID must contain only letters or digits");
        }
        this.id = id;
    }
    public void setTitle(String title) {
        if (title == null || title.isEmpty())
            throw new IllegalArgumentException("Title must not be empty");
        this.title = title;
    }
    public void setCredit(int credit) {
        if (credit < 0)
            throw new IllegalArgumentException("Credit must be greater than 0");
        this.credit = credit;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    @Override
    public String toString() {
        return String.format("%-10s%-30s%2d  %-10s", id, title, credit, department);
    }
}
