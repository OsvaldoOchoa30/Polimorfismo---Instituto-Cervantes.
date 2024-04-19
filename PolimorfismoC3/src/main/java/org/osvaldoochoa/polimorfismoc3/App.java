package org.osvaldoochoa.polimorfismoc3;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.osvaldoochoa.polimorfismoc3.models.Sistema;

import java.io.IOException;

public class App extends Application {
    public static Sistema sistema = new Sistema();
    public static Sistema getControl() {
        return sistema;
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("principal-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Menu Principal");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
