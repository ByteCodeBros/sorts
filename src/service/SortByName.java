package service;

import entities.Student;

import java.util.Comparator;

public class SortByName extends SortBy implements Comparator<Student> {
    public int compare(Student a, Student b) {
        return a.getName().compareTo(b.getName());
    }

    @Override
    public String toString() {
        return "Ordenado por nome";
    }
}
