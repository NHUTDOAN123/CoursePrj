/*
 * @ (#) CourseList.java    1.0     8/26/2024
 * Copyright (c) 2024 IUH. All rights reserved
 */

package edu.iuh.fit;

/*
 * @description: Mo ta cac khoa hoc trong truong hoc
 * @author: Doan, Nguyen Nhut
 * @version: 1.0
 * @created: 8/26/2024 11:33 AM
 */
public class CourseList {
    private Course[] courses;
    int cnt = 0;
    private static int count = 0;
    // contructor
    public CourseList(int n)  {
        if (n<=0)
            throw new IllegalArgumentException("Length of the array must be greater than 0");
        courses = new Course[n];
    }
    // property get - getCourses(): Course[]

    // addCourse(Course): boolean
    public boolean addCourse(Course course) {
        // check if course is null
        if (course==null) {
            return false;
        }
        // check if course already exists
        if (isExists(course)) {
            return false;
        }
        // check if the array is full
        if (count == courses.length) {
            return false;
        }
        // add course to the array
        courses[count++] = course;
        return true;

    }
    // exists(Course): boolean
    public boolean isExists(Course course) {
        for (int i = 0; i<count; i++) {
            if (courses[i] != null && courses[i].getId().equalsIgnoreCase(course.getId()))
                return true;
        }
        return false;
    }
    //lay danh sach khoa hoc
    public Course[] getCourses() {
        return courses;
    }
    public Course searchById(String s){
        for(int i = 0; i < cnt; ++i){
            if(courses[i].getId().equalsIgnoreCase(s)){
                return courses[i];
            }
        }
        return null;
    }
    //    Phuong thuc xoa khoa hoc khoi danh sach
    public boolean removeCourse(String s){
        for(int i = 0; i < cnt; ++i){
            if(courses[i].getId().equalsIgnoreCase(s)){
                for(int j = i; j < cnt - 1; ++j){
                    courses[j] = courses[j + 1];
                }
                courses[cnt - 1] = null;
                --cnt;
                return true;
            }
        }
        throw new IllegalArgumentException("This ID does not exist");
    }

    //    Tim kiem theo ten khoa hoc
    public Course[] SearchByTitle(String s){
        Course[] tmp = new Course[cnt];
        int res = 0;
        for(int i = 0; i < cnt; ++i){
            if(courses[i].getTitle().equalsIgnoreCase(s)) {
                tmp[res] = courses[i];
                ++res;
            }
        }
        return tmp;
    }
    // Tim kiem khao hoc theo khoa phu trach
    public Course[] SearchByDepartment(String s){
        Course[] tmp = new Course[cnt];
        int res = 0;
        for(int i = 0; i < cnt; ++i) {
            if (courses[i].getDepartment().equalsIgnoreCase(s)) {
                tmp[res] = courses[i];
                ++res;
            }
        }
        return tmp;
    }
    // Sap xep khoa hoc theo ten khoa hoc
    public Course[] sortCourse(){
        Course[] tmp = courses;
        for(int i = 0; i < cnt - 1; ++i){
            for(int j = i + 1; j < cnt; ++j)
                if(tmp[i].getDepartment().compareTo(tmp[j].getDepartment()) > 0) {
                    Course tmp2 = tmp[i];
                    tmp[i] = tmp[j];
                    tmp[j] = tmp2;
                }
        }
        return tmp;
    }
    //  Tim khoa phu trach co nhieu khoa hoc nhat
    public String findDepartmentWithMostCourse(Course[] course){
        int max = 0;
        String s = "";
        for(int i = 0; i < cnt - 1; ++i)
        {
            int res = 1;
            for(int j = i + 1; j < cnt; ++j){
                if(courses[i].getDepartment().equalsIgnoreCase(courses[j].getDepartment()))
                    ++res;
            }
            if(res > max){
                max = res;
                s = courses[i].getDepartment();
            }
        }
        return s;
    }
    // Tim khoa hoc co so tin chi lon nhat
    public Course[] findMaxCreditCourse(Course[] course) {
        int max = 0;
        Course[] tmp = new Course[cnt];
        for (int i = 0; i < cnt - 1; ++i) {
            if (courses[i].getCredit() > max)
                max = courses[i].getCredit();
        }
        int res = 0;
        for (int i = 0; i < cnt; ++i) {
            if (courses[i].getCredit() == max){
                tmp[res] = courses[i];
                ++res;
            }
        }
        return tmp;
    }
}
