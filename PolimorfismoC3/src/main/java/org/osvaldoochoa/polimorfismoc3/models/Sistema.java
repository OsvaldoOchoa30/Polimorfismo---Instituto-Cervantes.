package org.osvaldoochoa.polimorfismoc3.models;
import java.util.ArrayList;

public class Sistema {
    private ArrayList<Database> basesDeDatos = new ArrayList<>();

    private Database1 database1;
    private Database2 database2;
    private Database3 database3;

    public Sistema() {
        database1 = new Database1();
        database2 = new Database2();
        database3 = new Database3();

        basesDeDatos.add(database1);
        basesDeDatos.add(database2);
        basesDeDatos.add(database3);
    }

    public void saveBddStudent(Student student) {
        for (Database database1 : basesDeDatos) {
            database1.saveStudent(student);
        }
    }


    public void updateBddStudent(Student student) {
        for (Database database : basesDeDatos) {
            database.updateStudent(student);
        }
    }

    public Database1 getDatabase1(){
        return database1;
    }

    public Database2 getDatabase2(){
        return database2;
    }

    public Database3 getDatabase3(){
        return database3;
    }
}