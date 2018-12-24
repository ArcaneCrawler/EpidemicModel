package com.math.epidemic.Controller;

import com.math.epidemic.Main;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

public class RootLayoutController {

    private Main main;



    public void clickAbout(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("The Epidemic Modeling");
        alert.setHeaderText("About program");
        alert.setContentText("Author: Ilya Rodionov\nGroup # 455\nSaint-Petersburg State Institute of Technology\n2018-2019");
        alert.showAndWait();

    }

    public void clickReadme(ActionEvent actionEvent) {
        AboutLayoutController readme = new AboutLayoutController();
        readme.clickAbout(actionEvent);


    }

    public void initialize() {

    }

    public void setMainApp(Main main) {
        this.main = main;
    }
}
