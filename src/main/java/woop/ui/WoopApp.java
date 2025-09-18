package woop.ui;

import woop.logic.Storage;
import woop.logic.WoopLogic;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class WoopApp extends Application {
    private static final int MIN_HEIGHT = 220;
    private static final int MIN_WIDTH = 417;
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
            setDimensions(stage);
            loadUi(stage);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setDimensions(Stage s) {
        s.setMinHeight(MIN_HEIGHT);
        s.setMinWidth(MIN_WIDTH);
    }

    private void loadUi(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(WoopApp.class.getResource("/view/MainWindow.fxml"));
        AnchorPane ap = fxmlLoader.load();
        Scene scene = new Scene(ap);
        stage.setScene(scene);
        fxmlLoader.<MainWindow>getController().setWoop(woop);
    }
}
