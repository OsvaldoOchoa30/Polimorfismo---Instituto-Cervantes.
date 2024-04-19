package org.osvaldoochoa.polimorfismoc3.models;
import javafx.beans.property.SimpleStringProperty;

public class Student {
    private SimpleStringProperty name;
    private  SimpleStringProperty lName;
    private  SimpleStringProperty matricula;

    public Student(String name, String lName, String matricula) {
        this.name = new SimpleStringProperty(name);
        this.lName = new SimpleStringProperty(lName);
        this.matricula = new SimpleStringProperty(matricula);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getlName() {
        return lName.get();
    }

    public SimpleStringProperty lNameProperty() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName.set(lName);
    }

    public String getMatricula() {
        return matricula.get();
    }

    public SimpleStringProperty matriculaProperty() {
        return matricula;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", firstName='" + lName + '\'' +
                ", matricula=" + matricula +
                '}';
    }
}
