package org.osvaldoochoa.polimorfismoc3.controllers;



import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.osvaldoochoa.polimorfismoc3.App;
import org.osvaldoochoa.polimorfismoc3.models.Database;
import org.osvaldoochoa.polimorfismoc3.models.Sistema;
import org.osvaldoochoa.polimorfismoc3.models.Student;

public class GuardarEstudianteController {



    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonGuardar;

    @FXML
    private Button buttonRegresar;

    @FXML
    private TextField textFieldLlastName;

    @FXML
    private TextField textFieldMatricula;

    @FXML
    private TextField textFieldName;

    private Sistema sistema = App.getControl();

    @FXML
    void onMouseClickedButtonGuardar(MouseEvent event) {
        if (sistema != null){
            String name = textFieldName.getText();
            String lname = textFieldLlastName.getText();
            String matricula = textFieldMatricula.getText();
            Student student = new Student(name,lname,matricula);

            try {
                if (sistema.getDatabase2() != null){
                    sistema.saveBddStudent(student);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("Alumno Agregado.");
                    alert.showAndWait();
                    textFieldName.clear();
                    textFieldLlastName.clear();
                    textFieldMatricula.clear();
                }

            } catch (Exception e){
                System.out.println(".");

            }
        }else {
            System.out.println("El registro no se inicializo correctamente.");
        }

    }

    @FXML
    void onMouseClickedbuttonRegresar(MouseEvent event) {
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


    }

}
