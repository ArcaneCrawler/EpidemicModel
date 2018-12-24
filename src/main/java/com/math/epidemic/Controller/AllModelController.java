package com.math.epidemic.Controller;

import com.math.epidemic.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class AllModelController implements Initializable {
    public TextField susceptibleField;
    public TextField infectedField;
    public TextField recoveredField;
    public TextField contactField;
    public TextField influenceTimeField;
    public LineChart sirLineChart;
    public TextField modSusceptibleField;
    public TextField modInfectedField;
    public TextField modRecoveredField;
    public TextField modContactField;
    public TextField modInfluenceTimeField;
    public TextField modDeathRation;
    public LineChart modLineChart;
    public TextField sisSusceptibleField;
    public TextField sisInfectedField;
    public TextField sisContactField;
    public TextField sisInfluenceTimeField;
    public TextField sisDeathRation;
    public LineChart sisLineChart;
    public TextField sirsSusceptibleField;
    public TextField sirsInfectedField;
    public TextField sirsRecoveredField;
    public TextField sirsContactField;
    public TextField sirsInfluenceTimeField;
    public TextField sirsDeathRation;
    public TextField sirsLossOfImmunity;
    public LineChart sirsLineChart;
    public double[][] result;
    Dif dif = new Dif();
    int n = 100;
    private Main main;


    public void sirClickEnter() {
        float susceptible = Float.parseFloat(susceptibleField.getText());
        float infected = Float.parseFloat(infectedField.getText());
        float recovered = Float.parseFloat(recoveredField.getText());
        float contact = Float.parseFloat(contactField.getText());
        float influenceTime = Float.parseFloat(influenceTimeField.getText());

        float sum =((susceptible + infected + recovered));
        System.out.println((susceptible + infected + recovered ));

        if (sum != 100.0 )
        {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Warning");
            alert.setHeaderText("Warning");
            alert.setContentText("The sum of the shares of suspected, infected and recovered should be 100! \n");

            alert.showAndWait();
            return;

        }
        result = dif.SIR(susceptible, infected, recovered, contact, influenceTime);
        sirLineChart.setData(getSIRData());
        sirLineChart.setTitle("SIR");
    }


    private ObservableList<XYChart.Series<String, Double>> getSIRData() {
        ObservableList<XYChart.Series<String, Double>> answer = FXCollections.observableArrayList();
        XYChart.Series<String, Double> sSeries = new XYChart.Series<String, Double>();
        XYChart.Series<String, Double> iSeries = new XYChart.Series<String, Double>();
        XYChart.Series<String, Double> rSeries = new XYChart.Series<String, Double>();
        sSeries.setName("S");
        iSeries.setName("I");
        rSeries.setName("R");
        for (int i = 0; i < n - 1; i = i + 5) {
            sSeries.getData().add(new XYChart.Data(Integer.toString(i), result[0][i]));
            iSeries.getData().add(new XYChart.Data(Integer.toString(i), result[1][i]));
            rSeries.getData().add(new XYChart.Data(Integer.toString(i), result[2][i]));
        }
        answer.addAll(sSeries, iSeries, rSeries);
        return answer;
    }


    public void modClickEnter() {
        float susceptible = Float.parseFloat(modSusceptibleField.getText());
        float infected = Float.parseFloat(modInfectedField.getText());
        float recovered = Float.parseFloat(modRecoveredField.getText());
        float contact = Float.parseFloat(modContactField.getText());
        float influenceTime = Float.parseFloat(modInfluenceTimeField.getText());
        float deathRation = Float.parseFloat(modDeathRation.getText());
        float sum =((susceptible + infected + recovered));
        System.out.println((susceptible + infected + recovered ));

        if (sum != 100.0 )
        {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Warning");
            alert.setHeaderText("Warning");
            alert.setContentText("The sum of the shares of suspected, infected and recovered should be 100! \n");

            alert.showAndWait();
            return;

        }
        result = dif.SIRmod(susceptible, infected, recovered, contact, influenceTime, deathRation);

       /* for (int a = 0;a <= n - 1; a++) {

            System.out.print("a:"+ result[0][a] + "; b:"+ result[1][a] +"; c:"+ result[2][a]);
            System.out.println();
        }*/

        modLineChart.setData(getModSIRData());
        modLineChart.setTitle("SIR with modification");
    }


    private ObservableList<XYChart.Series<String, Double>> getModSIRData() {
        ObservableList<XYChart.Series<String, Double>> answer = FXCollections.observableArrayList();
        XYChart.Series<String, Double> sSeries = new XYChart.Series<String, Double>();
        XYChart.Series<String, Double> iSeries = new XYChart.Series<String, Double>();
        XYChart.Series<String, Double> rSeries = new XYChart.Series<String, Double>();
        sSeries.setName("S");
        iSeries.setName("I");
        rSeries.setName("R");
        for (int i = 0; i < n - 1; i = i + 5) {
            sSeries.getData().add(new XYChart.Data(Integer.toString(i), result[0][i]));
            iSeries.getData().add(new XYChart.Data(Integer.toString(i), result[1][i]));
            rSeries.getData().add(new XYChart.Data(Integer.toString(i), result[2][i]));
        }
        answer.addAll(sSeries, iSeries, rSeries);
        return answer;
    }


    public void sisClickEnter() {
        float susceptible = Float.parseFloat(sisSusceptibleField.getText());
        float infected = Float.parseFloat(sisInfectedField.getText());
        float contact = Float.parseFloat(sisContactField.getText());
        float influenceTime = Float.parseFloat(sisInfluenceTimeField.getText());
        float deathRation = Float.parseFloat(sisDeathRation.getText());
        float sum =((susceptible + infected ));
        System.out.println((susceptible + infected  ));

        if (sum != 100.0 )
        {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Warning");
            alert.setHeaderText("Warning");
            alert.setContentText("The sum of the shares of suspected, infected and recovered should be 100! \n");

            alert.showAndWait();
            return;

        }
        result = dif.SIS(susceptible, infected, contact, influenceTime, deathRation);

       /* for (int a = 0;a <= n - 1; a++) {

            System.out.print("a:"+ result[0][a] + "; b:"+ result[1][a] +"; c:"+ result[2][a]);
            System.out.println();
        }*/

        sisLineChart.setData(sisModSIRData());
        sisLineChart.setTitle("SIS");
    }


    private ObservableList<XYChart.Series<String, Double>> sisModSIRData() {
        ObservableList<XYChart.Series<String, Double>> answer = FXCollections.observableArrayList();
        XYChart.Series<String, Double> sSeries = new XYChart.Series<String, Double>();
        XYChart.Series<String, Double> iSeries = new XYChart.Series<String, Double>();

        sSeries.setName("S");
        iSeries.setName("I");

        for (int i = 0; i < n - 1; i = i + 5) {
            sSeries.getData().add(new XYChart.Data(Integer.toString(i), result[0][i]));
            iSeries.getData().add(new XYChart.Data(Integer.toString(i), result[1][i]));

        }
        answer.addAll(sSeries, iSeries);
        return answer;
    }

    public void sirsClickEnter() {
        float susceptible = Float.parseFloat(sirsSusceptibleField.getText());
        float infected = Float.parseFloat(sirsInfectedField.getText());
        float recovered = Float.parseFloat(sirsRecoveredField.getText());
        float contact = Float.parseFloat(sirsContactField.getText());
        float influenceTime = Float.parseFloat(sirsInfluenceTimeField.getText());
        float deathRation = Float.parseFloat(sirsDeathRation.getText());
        float lossOfImmunity = Float.parseFloat(sirsLossOfImmunity.getText());
        float sum =((susceptible + infected + recovered));
        System.out.println((susceptible + infected + recovered ));

        if (sum != 100.0 )
        {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Warning");
            alert.setHeaderText("Warning");
            alert.setContentText("The sum of the shares of suspected, infected and recovered should be 100! \n");

            alert.showAndWait();
            return;

        }
        result = dif.SIRS(susceptible, infected, recovered, contact, influenceTime, deathRation, lossOfImmunity);

       /* for (int a = 0;a <= n - 1; a++) {

            System.out.print("a:"+ result[0][a] + "; b:"+ result[1][a] +"; c:"+ result[2][a]);
            System.out.println();
        }*/

        sirsLineChart.setData(sirsModSIRData());
        sirsLineChart.setTitle("SIRS");
    }


    private ObservableList<XYChart.Series<String, Double>> sirsModSIRData() {
        ObservableList<XYChart.Series<String, Double>> answer = FXCollections.observableArrayList();
        XYChart.Series<String, Double> sSeries = new XYChart.Series<String, Double>();
        XYChart.Series<String, Double> iSeries = new XYChart.Series<String, Double>();
        XYChart.Series<String, Double> rSeries = new XYChart.Series<String, Double>();
        sSeries.setName("S");
        iSeries.setName("I");
        rSeries.setName("R");
        for (int i = 0; i < n - 1; i = i + 5) {
            sSeries.getData().add(new XYChart.Data(Integer.toString(i), result[0][i]));
            iSeries.getData().add(new XYChart.Data(Integer.toString(i), result[1][i]));
            rSeries.getData().add(new XYChart.Data(Integer.toString(i), result[2][i]));
        }
        answer.addAll(sSeries, iSeries, rSeries);
        return answer;
    }

    public void initialize() {

    }

    public void setMainApp(Main main) {
        this.main = main;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Pattern p = Pattern.compile("(\\d+\\.?\\d*)?");
        susceptibleField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) susceptibleField.setText(oldValue);
        });
        infectedField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) infectedField.setText(oldValue);
        });

        recoveredField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) recoveredField.setText(oldValue);
        });

        contactField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) contactField.setText(oldValue);
        });

        influenceTimeField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) influenceTimeField.setText(oldValue);
        });

        modSusceptibleField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) modSusceptibleField.setText(oldValue);
        });

        modInfectedField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) modInfectedField.setText(oldValue);
        });

        modRecoveredField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) modRecoveredField.setText(oldValue);
        });

        modContactField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) modContactField.setText(oldValue);
        });

        modInfluenceTimeField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) modInfluenceTimeField.setText(oldValue);
        });

        modDeathRation.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) modDeathRation.setText(oldValue);
        });

        sisSusceptibleField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) sisSusceptibleField.setText(oldValue);
        });

        sisInfectedField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) sisInfectedField.setText(oldValue);
        });

        sisContactField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) sisContactField.setText(oldValue);
        });

        sisInfluenceTimeField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) sisInfluenceTimeField.setText(oldValue);
        });

        sisDeathRation.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) sisDeathRation.setText(oldValue);
        });

        sirsSusceptibleField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) sirsSusceptibleField.setText(oldValue);
        });

        sirsInfectedField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) sirsInfectedField.setText(oldValue);
        });

        sirsRecoveredField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) sirsRecoveredField.setText(oldValue);
        });

        sirsContactField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) sirsContactField.setText(oldValue);
        });

        sirsInfluenceTimeField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) sirsInfluenceTimeField.setText(oldValue);
        });

        sirsDeathRation.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) sirsDeathRation.setText(oldValue);
        });

        sirsLossOfImmunity.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) sirsLossOfImmunity.setText(oldValue);
        });



    }
}
