package com.tpg.interview.student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class StudentUtil {
    
    public static final Comparator<Student> STUDENT_COMPARATOR = new Comparator<Student>() {

        @Override
        public int compare(Student s1, Student s2) {
            return Double.compare(s2.getGpa(), s1.getGpa()) != 0 ? Double.compare(s2.getGpa(), s1.getGpa())
                    : (s1.getName().compareTo(s2.getName()) != 0 ? s1.getName().compareTo(s2.getName())
                            : Integer.compare(s1.getId(), s2.getId()));
        }
    };

    public static void sort(List<Student> students) {
        if (students == null || students.isEmpty()) return;
        
        Collections.sort(students, STUDENT_COMPARATOR);
    }

    /**
     * pls see more junit test {@StudentUtilTest}
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new StudentUtil().getClass().getResourceAsStream("students.txt"));
        String line = null;
        String[] lines = null;
        List<Student> stus = new ArrayList<>();

        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            lines = line.split(" ");
            stus.add(new Student(Integer.valueOf(lines[0]), lines[1], Double.valueOf(lines[2])));
        }
        scanner.close();

        // sort here
        StudentUtil.sort(stus);
        
        for (Student stu : stus) {
            System.out.println(stu.getId() + " " + stu.getName() + " " + stu.getGpa());
        }
    }
}
