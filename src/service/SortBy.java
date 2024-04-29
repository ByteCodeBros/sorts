package service;

import entities.Student;

import java.util.Comparator;

public abstract class SortBy implements Comparator<Student> {
    public abstract int compare(Student a, Student b);

    @Override
    public String toString() {
        return "";
    }
}
