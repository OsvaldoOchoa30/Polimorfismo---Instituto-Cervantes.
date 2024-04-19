package org.osvaldoochoa.polimorfismoc3.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.osvaldoochoa.polimorfismoc3.App;
import org.osvaldoochoa.polimorfismoc3.models.Sistema;
import org.osvaldoochoa.polimorfismoc3.models.Student;

public class ActualizarEstudianteController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonActualizar;

    @FXML
    private Button buttonBuscar;

    @FXML
    private Button buttonBack;

    @FXML
    private TableView<Student> tableActualizar;

    @FXML
    private TableColumn<Student, String> tableColoumnMatricula;

    @FXML
    private TableColumn<Student, String> tableColumnLastN;

    @FXML
    private TableColumn<Student, String> tableColumnName;

    @FXML
    private TextField textFieldBuscador;

    @FXML
    private TextField textFieldLastName;

    @FXML
    private TextField textFieldMatricula;

    @FXML
    private TextField textFieldName;

    private Sistema sistema = App.getControl();

    @FXML
    void OnMouseClickedbuttonBuscar(MouseEvent event) {
        if (sistema !=null&&sistema.getDatabase1()!=null&&sistema.getDatabase1().getStudents1()!=null) {
            tableActualizar.getItems().addAll(sistema.getDatabase1().getStudents1());

        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("La lista se encuentra vacia.");
            alert.showAndWait();

        }

    }




    @FXML
    void onMouseClickedButtonActualizar(MouseEvent event) {
        tableActualizar.getItems().clear();

        String upDateName = textFieldName.getText();
        String upDatelName = textFieldLastName.getText();
        String buscarEstudiante = textFieldBuscador.getText();



        textFieldBuscador.clear();
        textFieldName.clear();
        textFieldLastName.clear();


        if (buscarEstudiante.isEmpty() || upDatelName.isEmpty() ){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Rellene los campos correctamente.");
            alert.showAndWait();
        }else {
            for (Student estudent: App.getControl().getDatabase1().getStudents1()){
                if (buscarEstudiante.equals(estudent.getMatricula())){
                    estudent.setName(upDateName);
                    estudent.setlName(upDatelName);
                    Student estudianteActualizado = new Student(upDateName,upDatelName,"");
                    App.getControl().updateBddStudent(estudianteActualizado);

                    Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                    alert2.setHeaderText(null);
                    alert2.setContentText("Estudiante Actualizado");
                    alert2.showAndWait();



                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("Estudiante no encontrado");
                    alert.showAndWait();
                }

            }
        }

    }

    @FXML
    void onMouseCLickedButtonBack(MouseEvent event) {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("principal-view.fxml"));
        try {
            Pane root = fxmlLoader.load();
            Scene scene = new Scene(root);
            stage.setTitle("Menu Principal.");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Node source = (Node) event.getSource();
        stage = (Stage) source.getScene().getWindow();
        stage.close();
    }



    @FXML
    void initialize() {
        tableColumnName.setCellValueFactory(studentStringCellDataFeatures -> studentStringCellDataFeatures.getValue().nameProperty());
        tableColumnLastN.setCellValueFactory(studentStringCellDataFeatures -> studentStringCellDataFeatures.getValue().lNameProperty());
        tableColoumnMatricula.setCellValueFactory(studentStringCellDataFeatures -> studentStringCellDataFeatures.getValue().matriculaProperty());
    }

}
