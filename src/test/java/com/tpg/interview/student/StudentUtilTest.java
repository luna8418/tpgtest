package com.tpg.interview.student;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class StudentUtilTest {
    private Student stu1;
    private Student stu2;

    @Test
    public void GpaDescFirst() {
        stu1 = new Student(1, "1", 1.1D);
        stu2 = new Student(2, "2", 1.12D);
        List<Student> list = new ArrayList<>();
        list.add(stu1);
        list.add(stu2);
        StudentUtil.sort(list);
        assertEquals(list.get(0), stu2);
        assertEquals(list.get(1), stu1);

        // no matter how the student is added into list, gpa desc after sort
        list = new ArrayList<>();
        list.add(stu2);
        list.add(stu1);
        StudentUtil.sort(list);
        assertEquals(list.get(0), stu2);
        assertEquals(list.get(1), stu1);
    }

    @Test
    public void sameGpaThenNameAlphabetically() {
        stu1 = new Student(1, "Eric", 1.1D);
        stu2 = new Student(2, "Erik", 1.1D);
        // 1st double is always the bigger one
        List<Student> list = new ArrayList<>();
        list.add(stu1);
        list.add(stu2);
        StudentUtil.sort(list);
        assertEquals(list.get(0), stu1);
        assertEquals(list.get(1), stu2);

        list = new ArrayList<>();
        list.add(stu2);
        list.add(stu1);
        StudentUtil.sort(list);
        assertEquals(list.get(0), stu1);
        assertEquals(list.get(1), stu2);
    }

    @Test
    public void sameGpaAndNameThenIdAsc() {
        stu1 = new Student(1, "Eric", 1.1D);
        stu2 = new Student(2, "Eric", 1.1D);
        // 1st double is always the bigger one
        List<Student> list = new ArrayList<>();
        list.add(stu1);
        list.add(stu2);
        StudentUtil.sort(list);
        assertEquals(list.get(0), stu1);
        assertEquals(list.get(1), stu2);

        list = new ArrayList<>();
        list.add(stu2);
        list.add(stu1);
        StudentUtil.sort(list);
        assertEquals(list.get(0), stu1);
        assertEquals(list.get(1), stu2);
    }
}
