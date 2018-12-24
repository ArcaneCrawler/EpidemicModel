package com.math.epidemic.Controller;

import com.math.epidemic.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TextField;

public class NoNameTset {
    Dif dif = new Dif();
    private Main main;
    public TextField sirsSusceptibleField;
    public TextField sirsInfectedField;
    public TextField sirsRecoveredField;
    public TextField sirsContactField;
    public TextField sirsInfluenceTimeField;
    public TextField sirsDeathRation;
    public TextField sirsLossOfImmunity;
    public LineChart sirsLineChart;


    public double[][] result;
    int n = 100;
    int arrayLenght = 3;

    public void sirsClickEnter() {
        float susceptible = Float.parseFloat(sirsSusceptibleField.getText());
        float infected = Float.parseFloat(sirsInfectedField.getText());
        float recovered = Float.parseFloat(sirsRecoveredField.getText());
        float contact = Float.parseFloat(sirsContactField.getText());
        float influenceTime = Float.parseFloat(sirsInfluenceTimeField.getText());
        float deathRation = Float.parseFloat(sirsDeathRation.getText());
        float lossOfImmunity = Float.parseFloat(sirsLossOfImmunity.getText());
        result = dif.SIRS(susceptible, infected, recovered, contact, influenceTime,deathRation,lossOfImmunity );

       /* for (int a = 0;a <= n - 1; a++) {

            System.out.print("a:"+ result[0][a] + "; b:"+ result[1][a] +"; c:"+ result[2][a]);
            System.out.println();
        }*/

        sirsLineChart.setData(sirsModSIRData());
        sirsLineChart.setTitle("SIS");
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
}
