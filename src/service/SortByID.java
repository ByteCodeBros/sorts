package service;

import entities.Student;

import java.util.Comparator;

public class SortByID extends SortBy implements Comparator<Student> {
    public int compare(Student a, Student b) {
        return a.getId() - b.getId();
    }

    @Override
    public String toString() {
        return "Ordenado por ID";
    }
}
