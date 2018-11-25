package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {


    @FXML
    private Button btnStart;

    @FXML
    private TextField textY;

    @FXML
    private TextField textX;

    @FXML
    private TextField textA;

    @FXML
    private TextField textB;

    @FXML
    private TextField textC;

    @FXML
    private TextField textD;

    @FXML
    private TextField textT0;

    @FXML
    private TextField textTK;

    @FXML
    private LineChart<Number, Number> chart;

    @FXML
    private NumberAxis xAxis;

    @FXML
    private NumberAxis yAxis;

    private double dt = 0.25;

    @FXML
    void btnStart(ActionEvent event) {

        chart.getData().removeAll(chart.getData());

        double y = Double.parseDouble(textY.getText());
        double x = Double.parseDouble(textX.getText());

        double a = Double.parseDouble(textA.getText());
        double b = Double.parseDouble(textB.getText());
        double c = Double.parseDouble(textC.getText());
        double d = Double.parseDouble(textD.getText());

        double t0 = Double.parseDouble(textT0.getText());
        double tk = Double.parseDouble(textTK.getText());

        CalkaLotkiVolterry populacja = new CalkaLotkiVolterry(dt, t0, tk, x, y, a, b, c, d);
        populacja.calkowanie();
        double[] populDrap = populacja.getEulerY();
        double[] populOfia = populacja.getEulerX();


        xAxis.setLabel("czas");
        yAxis.setLabel("populacja");

        xAxis.setTickUnit(1);
        yAxis.setTickUnit(1);

        xAxis.setAutoRanging(true);
        yAxis.setAutoRanging(true);

        XYChart.Series<Number, Number> drapiezniki = new XYChart.Series<>();
        XYChart.Series<Number, Number> ofiary = new XYChart.Series<>();
        drapiezniki.setName("populacja drapiezników");
        ofiary.setName("populacja ofiar");

        int n = 0;
        for (double i = t0 + 1; i <= tk; i += dt) {
            drapiezniki.getData().add(new XYChart.Data<Number, Number>(i, populDrap[n]));
            ofiary.getData().add(new XYChart.Data<Number, Number>(i, populOfia[n]));
            n++;
        }

        chart.getData().addAll(drapiezniki);
        chart.getData().addAll(ofiary);
    }


}


