package com.math.epidemic.Controller;

import com.math.epidemic.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AboutLayoutController implements Initializable {
    @FXML
    public ImageView sirView;
    @FXML
    public ImageView sirmView;
    @FXML
    public ImageView sisView;
    @FXML
    public ImageView sirsView;


    private Main main;


    public void clickAbout(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/AboutLayout.fxml"));


            AnchorPane pane = loader.load();


            Stage dialogStage = new Stage();
            dialogStage.setTitle("Read me");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            Scene scene = new Scene(pane);
            dialogStage.setScene(scene);


            dialogStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initialize() {

    }

    public void setMainApp(Main main) {
        this.main = main;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        File file1 = new File("src/main/resources/SIR.PNG");
        Image image1 = new Image(file1.toURI().toString());
        sirView.setImage(image1);

        File file2 = new File("src/main/resources/SIRM.PNG");
        Image image2 = new Image(file2.toURI().toString());
        sirmView.setImage(image2);

        File file3 = new File("src/main/resources/SIS.PNG");
        Image image3 = new Image(file3.toURI().toString());
        sisView.setImage(image3);

        File file4 = new File("src/main/resources/SIRS.PNG");
        Image image4 = new Image(file4.toURI().toString());
        sirsView.setImage(image4);
    }
}
