package com.math.epidemic;

import com.math.epidemic.Controller.AllModelController;
import com.math.epidemic.Controller.RootLayoutController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Main extends Application {
    private Stage primaryStage = null;
    private BorderPane rootPane;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Epidemic");
        this.primaryStage.setResizable(false);
        this.primaryStage.sizeToScene();
        initRootLayout();
        showMainLayout();

    }


    private void initRootLayout() {


        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("View/RootLayout.fxml"));
            rootPane = loader.load();
            Scene scene = new Scene(rootPane);
            primaryStage.setScene(scene);
            primaryStage.show();

            RootLayoutController rootLayoutController = loader.getController();
            rootLayoutController.setMainApp(this);



        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showMainLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("View/AllModel.fxml"));
            AnchorPane mainPane = loader.load();

            rootPane.setCenter(mainPane);

            //расскоментирую эту стрчку чтоб чекнуть подключение к базе
            //и незабудь настроить файл resources/persistence.xml
            //EntityManager em = Persistence.createEntityManagerFactory("EPIDEMIC").createEntityManager();

            AllModelController allModelController = loader.getController();
            allModelController.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
