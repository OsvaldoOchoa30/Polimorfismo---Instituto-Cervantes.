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

public class VerEstudiantesController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonRegresar;

    @FXML
    private TextField matriculaBuscarText;


    @FXML
    private TableView<Student> tableBDD1;

    @FXML
    private TableView<Student> tableBDD2;

    @FXML
    private TableView<Student> tableBDD3;


    @FXML
    private TableColumn<Student, String> tableColumnBDD1LastN;

    @FXML
    private TableColumn<Student, String> tableColumnBDD1matricula;

    @FXML
    private TableColumn<Student, String> tableColumnBDD1name;


    @FXML
    private TableColumn<Student, String> tableColumnBDD2LastN;

    @FXML
    private TableColumn<Student, String> tableColumnBDD2matricula;

    @FXML
    private TableColumn<Student, String> tableColumnBDD2name;


    @FXML
    private TableColumn<Student, String> tableColumnBDD3lastN;

    @FXML
    private TableColumn<Student, String> tableColumnBDD3matricula;

    @FXML
    private TableColumn<Student, String> tableColumnBDD3name;


    @FXML
    private Button verButton;

    private Sistema sistema = App.getControl();

    @FXML
    void onMouseClickedButtonRegresar(MouseEvent event) {
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
    void onMouseClickedVerButton(MouseEvent event) {
        tableBDD1.getItems().clear();
        tableBDD2.getItems().clear();
        tableBDD3.getItems().clear();
        if (sistema != null && sistema.getDatabase1() != null && sistema.getDatabase1().getStudents1() != null) {
            tableBDD1.getItems().addAll(sistema.getDatabase1().getStudents1());
            tableBDD2.getItems().addAll(sistema.getDatabase2().getStudents2());
            tableBDD3.getItems().addAll(sistema.getDatabase3().getStudents3());

        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Lista Vacia.");
            alert.showAndWait();
        }
    }

    @FXML
    void initialize() {

        tableColumnBDD1name.setCellValueFactory(studentStringCellDataFeatures -> studentStringCellDataFeatures.getValue().nameProperty());
        tableColumnBDD1LastN.setCellValueFactory(studentStringCellDataFeatures -> studentStringCellDataFeatures.getValue().lNameProperty());
        tableColumnBDD1matricula.setCellValueFactory(studentStringCellDataFeatures -> studentStringCellDataFeatures.getValue().matriculaProperty());

        tableColumnBDD2name.setCellValueFactory(studentStringCellDataFeatures -> studentStringCellDataFeatures.getValue().nameProperty());
        tableColumnBDD2LastN.setCellValueFactory(studentStringCellDataFeatures -> studentStringCellDataFeatures.getValue().lNameProperty());
        tableColumnBDD2matricula.setCellValueFactory(studentStringCellDataFeatures -> studentStringCellDataFeatures.getValue().matriculaProperty());

        tableColumnBDD3name.setCellValueFactory(studentStringCellDataFeatures -> studentStringCellDataFeatures.getValue().nameProperty());
        tableColumnBDD3lastN.setCellValueFactory(studentStringCellDataFeatures -> studentStringCellDataFeatures.getValue().lNameProperty());
        tableColumnBDD3matricula.setCellValueFactory(studentStringCellDataFeatures -> studentStringCellDataFeatures.getValue().matriculaProperty());


    }
}

