package es.crttn;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;


public class App extends Application {

    private TextField responseText;
    private Label highScoreText;
    private int highScoreCount;
    private int number;
    private int counter = 0;

    @Override
    public void start(Stage stage) throws Exception {

        number = (int) (Math.random() * 100 + 1);

        Label statementLabel = new Label();
        statementLabel.setText("Introduce el número de 1 al 100");

        responseText = new TextField();
        responseText.setMaxWidth(100);

        Button checkButton = new Button();
        checkButton.setText("Comprobar");
        checkButton.setDefaultButton(true);
        checkButton.setOnAction(this::onActionCheckButton);

        highScoreText = new Label("Puntuación máxima: " + highScoreCount);

        VBox firstPanel = new VBox();
        firstPanel.setPadding(new Insets(5));
        firstPanel.setSpacing(5);
        firstPanel.setAlignment(Pos.CENTER);
        firstPanel.getChildren().addAll(statementLabel, responseText, checkButton);

        VBox secondPanel = new VBox();
        secondPanel.setPadding(new Insets(5));
        secondPanel.setSpacing(5);
        secondPanel.setAlignment(Pos.CENTER);
        secondPanel.getChildren().add(highScoreText);

        VBox root = new VBox();
        root.setPadding(new Insets(5));
        root.setSpacing(5);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(firstPanel, secondPanel);


        Scene scene = new Scene(root, 640, 480);

        stage.setTitle("AdivinApp");
        stage.setScene(scene);
        stage.show();
    }

    public void onActionCheckButton(ActionEvent e) {
        try {
            String userInput = responseText.getText();
            int responseNumber = Integer.parseInt(userInput);

            counter ++;

        if (responseNumber == number) {
            Alert winAlert = new Alert(Alert.AlertType.INFORMATION);
            winAlert.setTitle("AdivinApp");
            winAlert.setHeaderText("¡Has ganado!");
            winAlert.setContentText("Solo has necesitado " + counter + " intentos." + "\n\nVuelve a jugar y hazlo mejor");
            winAlert.showAndWait();  // Show the alert

            if (counter < highScoreCount || highScoreCount == 0) {
                highScoreCount = counter;
            }

            highScoreText.setText("Puntuación máxima: " + highScoreCount);

            number = (int) (Math.random() * 100 + 1);
            counter = 0;
            responseText.clear();

        } else {
            Alert failAlert = new Alert(Alert.AlertType.WARNING);
            failAlert.setTitle("AdivinApp");
            failAlert.setHeaderText("¡Has fallado!");
            if (number > responseNumber) {
                failAlert.setContentText("El número es mayor que " + responseNumber + "\n\nVuelve a jugar y hazlo mejor.");
            } else {
                failAlert.setContentText("El número es menor que " + responseNumber + "\n\nVuelve a jugar y hazlo mejor.");
            }
            failAlert.showAndWait();
            responseText.clear();
        }

    } catch (NumberFormatException ex) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("AdivinApp");
            errorAlert.setHeaderText("Entrada inválida");
            errorAlert.setContentText("El número introducido no es válido");
            errorAlert.showAndWait();
            responseText.clear();
        }
    }

}

