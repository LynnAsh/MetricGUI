import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GUI extends Application {
    private String[] unitsM = {"Kilometers", "Meters", "Kilograms", "Grams", "Celsius"};
    private String[] unitsI = {"Miles", "Pounds", "Fahrenheit"};
    private String lengthI = "Miles";
    private String tempI = "Fahrenheit";
    private String lb = "Pounds";
    public static ChoiceBox<String> metric = new ChoiceBox<>();
    public static ChoiceBox<String> imperial = new ChoiceBox<>();
    public static TextField input = new TextField();
    public static TextField output = new TextField();

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Metric Converter");
        GridPane gridPane = new GridPane();
        gridPane.setHgap(5);
        gridPane.setVgap(5);

        metric.getItems().addAll(unitsM);
        imperial.getItems().addAll(unitsI);

        Button btCalc = new Button("Calculate");
        output.setEditable(false);

        gridPane.add(new Label("Metric Unit"), 0, 0);
        gridPane.add(metric, 1, 0);
        gridPane.add(input, 2, 0);
        gridPane.add(new Label("Imperial Unit"), 0, 1);
        gridPane.add(imperial, 1, 1);
        gridPane.add(btCalc, 1, 2);
        gridPane.add(output, 2, 2);
        gridPane.setAlignment(Pos.CENTER);

        metric.setOnAction(e -> {
            String choice = metric.getValue();

            if (choice.equals("Kilometers") || choice.equals("Meters")) {
                imperial.getItems().setAll(lengthI);
                imperial.setValue(" ");
            } else if (choice.equals("Kilograms") || choice.equals("Grams")) {
                imperial.getItems().setAll(lb);
                imperial.setValue(" ");
            } else if (choice.equals("Celsius")) {
                imperial.getItems().setAll(tempI);
                imperial.setValue(" ");
            }
        });

        btCalc.setOnAction(e -> {
            output.setText(Converter.calculate());
        });

        Scene scene = new Scene(gridPane, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) throws Exception {
        launch(args);
    }
}
