/*
 * @ (#) TestCourse.java    1.0     8/26/2024
 * Copyright (c) 2024 IUH. All rights reserved
 */

package edu.iuh.fit;

import java.util.Scanner;

/*
 * @description: Mo ta cac khoa hoc trong truong hoc
 * @author: Doan, Nguyen Nhut
 * @version: 1.0
 * @created: 8/26/2024 11:33 AM
 */
public class TestCourse {
    public static void main(String[] args) {
        CourseList courseList = new CourseList(10);

        initData(courseList);
        // Them va lay danh sach khoa hoc
        System.out.printf("%-10s%-30s%10s %-30s\n", "Id", "Title", "Credit", "Department");
        Course[] temp = courseList.getCourses();
        for(Course c : temp)
        {
            if(c != null) System.out.println(c);
        }
        String s = new Scanner(System.in).nextLine();
//  Xoa mot khoa hoc trong danh sach
        /*
        System.out.print("Nhap ma khoa hoc can xoa: ");

        courseList.removeCourse(s);
        System.out.printf("%-10s%-30s%10s %-30s\n", "Id", "Title", "Credit", "Department");
        for(Course c : courseList.getCourses())

            if (c != null) System.out.println(c);

         */

//    Tim kiem khoa hoc theo id
        System.out.print("Nhap ma khoa hoc can tim: ");
        s = new Scanner(System.in).nextLine();
        System.out.printf("%-10s%-30s%10s %-30s\n", "Id", "Title", "Credit", "Department");
        System.out.println(courseList.searchById(s));

//  Tim kiem khoa hoc theo ten
        System.out.print("Nhap ten khoa hoc can tim: ");
        s = new Scanner(System.in).nextLine();
        System.out.printf("%-10s%-30s%10s %-30s\n", "Id", "Title", "Credit", "Department");
        for(Course c : courseList.SearchByTitle(s))
            if(c != null) System.out.println(c);

// Tim kiem khoa hoc theo khoa phu trach
        System.out.print("Nhap khoa phu trach: ");
        s = new Scanner(System.in).nextLine();
        System.out.printf("%-10s%-30s%10s %-30s\n", "Id", "Title", "Credit", "Department");
        for(Course c : courseList.SearchByDepartment(s))
            if(c != null) System.out.println(c);

// Sap xep theo ten khoa hoc
        System.out.println("Danh sach khoa hoc sau khi sap xep theo ten khoa hoc");
        System.out.printf("%-10s%-30s%10s %-30s\n", "Id", "Title", "Credit", "Department");
        for(Course c : courseList.sortCourse())
            if(c != null) System.out.println(c);

//        Tim khoa phu trach nhieu hoc nhat
        System.out.println("Khoa phu trach nhieu khoa hoc nhat: " + courseList.findDepartmentWithMostCourse(temp));

//  Tim khoa hoc co so tin chi lon nhat
        System.out.println("Cac khoa hoc co so tin chi lon nhat");
        System.out.printf("%-10s%-30s%10s %-30s\n", "Id", "Title", "Credit", "Department");
        for(Course c : courseList.findMaxCreditCourse(temp))
            if(c != null) System.out.println(c);
    }
    private static void initData(CourseList courseList) {
        Course c1 = new Course("CS101", "Java Progarmmings 1", 3, "CS");
        Course c2 = new Course("CS102", "Java Progarmmings 2", 3, "SE");
        Course c3 = new Course("CS103", "Java Progarmmings 3", 4, "ABC");
        Course c4 = new Course("CS104", "Java Progarmmings 4", 5, "DEF");
        Course c5 = new Course("CS105", "Java Progarmmings 5", 6, "GHI");

        courseList.addCourse(c1);
        courseList.addCourse(c2);
        courseList.addCourse(c3);
        courseList.addCourse(c4);
        courseList.addCourse(c5);
        /*
        for (Course c : courseList.getCourses())
            if (c != null)
                System.out.println(c);

         */

    }

}