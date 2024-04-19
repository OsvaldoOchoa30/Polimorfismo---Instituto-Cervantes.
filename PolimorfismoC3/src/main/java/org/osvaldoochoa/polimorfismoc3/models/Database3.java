package org.osvaldoochoa.polimorfismoc3.models;
import java.util.ArrayList;

public class Database3 implements Database {
    private ArrayList<Student> students3 = new ArrayList<>();

    public Database3(){
        students3 = new ArrayList<>();
    }

    public ArrayList<Student> getStudents3()  {
        return students3;
    }

    @Override
    public void saveStudent(Student student) {
        students3.add(student);
    }

    @Override
    public void updateStudent(Student student) {
        for (Student students : students3) {
            if (students.getMatricula().equals(student.getMatricula())) {
                students.setName(student.getName());
                students.setlName(student.getlName());
                break;
            }
        }
    }
}