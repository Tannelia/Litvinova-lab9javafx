package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Hello World");
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        Label firstLable = new Label("Первое значение: ");
        grid.add(firstLable, 1, 1);
        TextField farg = new TextField();
        farg.setText("0");
        grid.add(farg, 1, 2);
        ObservableList<String> options =
                FXCollections.observableArrayList(
                        "+",
                        "-",
                        "/",
                        "*"
                );

        final  ComboBox comboBox = new ComboBox(options);
        comboBox.setValue("+");
        grid.add(comboBox, 1,3);
        Label secondLable = new Label("Ворое значение: ");
        grid.add(secondLable, 1, 4);
        TextField sarg = new TextField();
        sarg.setText("0");
        grid.add(sarg, 1, 5);
        Label result = new Label();
        grid.add(result, 1, 7);
        Button calculate = new Button("=");
        calculate.setOnAction(e -> {
            try {
                int one = Integer.parseInt(farg.getText());
                int two = Integer.parseInt(sarg.getText());
                switch (comboBox.getValue().toString()) {
                    case "+":
                        result.setText(Integer.toString(one + two));
                        break;
                    case "-":
                        result.setText(Integer.toString(one - two));
                        break;
                    case "*":
                        result.setText(Integer.toString(one * two));
                        break;
                    case "/":
                        result.setText(Float.toString((float) one / (float) two));
                        break;
                }
            } catch (NumberFormatException exc) {
                result.setText("Вводить необохдимо только цифры!");
            }
        });
        grid.add(calculate, 1, 6);
        Scene scene = new Scene(grid, 250, 275);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
