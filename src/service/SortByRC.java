package service;
import entities.*;
import java.util.Comparator;

public class SortByRC extends SortBy implements Comparator<Student> {

    public int compare(Student a, Student b) {
        double res = a.getCr() - b.getCr();
        if(res>0){
            return 1;
        } else if (res==0) {
            return 0;
        } else{
            return -1;
        }
    }

    @Override
    public String toString() {
        return "Ordenado por CR";
    }
}
