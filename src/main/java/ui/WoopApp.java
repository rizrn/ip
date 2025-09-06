package ui;

import WoopAI.Storage;
import WoopAI.TaskList;
import WoopAI.Woop;
import WoopAI.WoopLogic;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class WoopApp extends Application {
    private WoopLogic woop;

    @Override
    public void start(Stage stage) {
        try {
            Storage.checkDirectory();
            woop = new WoopLogic(Storage.retrieveSave());
            Ui.showIntro();

        } catch (Exception e) {
            Ui.showIoError();
        }

        try {
            stage.setMinHeight(220);
            stage.setMinWidth(417);
            FXMLLoader fxmlLoader = new FXMLLoader(WoopApp.class.getResource("/view/MainWindow.fxml"));
            AnchorPane ap = fxmlLoader.load();
            Scene scene = new Scene(ap);
            stage.setScene(scene);
            fxmlLoader.<MainWindow>getController().setWoop(woop);  // inject the Duke instance
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
