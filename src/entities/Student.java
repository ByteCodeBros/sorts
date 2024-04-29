package entities;

public class Student implements Comparable<Student> {
    int id;
    double rc;
    String name;

    public Student(int id, double rc, String name){
        this.id = id;
        this.rc = rc;
        this.name = name;
    }

    @Override
    public int compareTo(Student o) {
        return 0;
    }

    public int getId() {
        return id;
    }

    public double getCr() {
        return rc;
    }

    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        String rcString = String.format("%.4f", rc);
        return"\n { Aluno: " + name +
                " | ID: " + id +
                " | CR: " + rcString +
                " }";
    }
}
