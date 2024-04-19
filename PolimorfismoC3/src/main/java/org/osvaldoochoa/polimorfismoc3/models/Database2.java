package org.osvaldoochoa.polimorfismoc3.models;
import java.util.ArrayList;

public class Database2 implements Database {
    private ArrayList<Student> students2 = new ArrayList<>();

    public Database2(){
        students2 = new ArrayList<>();
    }

    public ArrayList<Student> getStudents2() {
        return students2;
    }

    @Override
    public void saveStudent(Student student) {
        students2.add(student);
    }

    @Override
    public void updateStudent(Student student) {
        for (Student students : students2) {
            if (students.getMatricula().equals(student.getMatricula())) {
                students.setName(student.getName());
                students.setlName(student.getlName());
                break;
            }
        }
    }
}