import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

import static javafx.application.Application.launch;

public class totalGraph extends Application {
    public static Person p;

    static {
        try {
            p = BonusMethods.readFromFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void start(Stage stage) throws FileNotFoundException {
        stage.setTitle("Powaah App");

        //defining the axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Days");
        yAxis.setLabel("Weight (lbs)");

        final LineChart<Number,Number> lineChart= new LineChart<Number, Number>(xAxis, yAxis);

        lineChart.setTitle(p.name + "'s Weight");

        XYChart.Series weightLine = new XYChart.Series();
        weightLine.setName(p.name);
        XYChart.Series idealRangeTop = new XYChart.Series();
        idealRangeTop.setName("Top of Ideal Weight Range");
        XYChart.Series idealRangeBot = new XYChart.Series();
        idealRangeBot.setName("Bottom of Ideal Weight Range");
        int counter =1;
        double top = Math.ceil(24.0 * p.height / 703 * p.height);
        double bot = Math.ceil(18.5 * p.height / 703 * p.height);
        System.out.println(top + "and" + bot);
        for(Integer i: BonusMethods.allWeights()){
            weightLine.getData().add(new XYChart.Data(counter, i));
            idealRangeTop.getData().add(new XYChart.Data(counter, top));
            idealRangeBot.getData().add(new XYChart.Data(counter, bot));
            counter ++;
        }

        Scene scene= new Scene(lineChart, 800,600);
        lineChart.getData().add(weightLine);
        lineChart.getData().add(idealRangeBot);
        lineChart.getData().add(idealRangeTop);

        stage.setScene(scene);
        stage.show();

    }


}
