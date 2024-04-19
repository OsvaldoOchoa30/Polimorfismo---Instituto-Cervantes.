package org.osvaldoochoa.polimorfismoc3.models;
import java.util.ArrayList;

public class Database1 implements Database {
    private ArrayList<Student> students1 = new ArrayList<>();

    public Database1(){
        students1 = new ArrayList<>();
    }

    @Override
    public void saveStudent(Student student) {
        students1.add(student);
    }

    public ArrayList<Student> getStudents1() {
        return students1;
    }

    @Override
    public void updateStudent(Student student) {
        for (Student students : students1) {
            if (students.getMatricula().equals(student.getMatricula())) {
                students.setName(student.getName());
                students.setlName(student.getlName());
                break;
            }
        }
    }
}