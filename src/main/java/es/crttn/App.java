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
    private int number;

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

        VBox root = new VBox();
        root.setPadding(new Insets(5));
        root.setSpacing(5);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(statementLabel, responseText, checkButton);

        Scene scene = new Scene(root, 640, 480);

        stage.setTitle("AdivinApp");
        stage.setScene(scene);
        stage.show();
    }

    public void onActionCheckButton(ActionEvent e) {
        try {
        String userInput = responseText.getText();
        int responseNumber = Integer.parseInt(userInput);

        if (responseNumber == number) {
            Alert winAlert = new Alert(Alert.AlertType.INFORMATION);
            winAlert.setTitle("¡Has ganado!");
            winAlert.setHeaderText("Solo has necesitado " + userInput + " intentos.");
            winAlert.setContentText("Vuelve a jugar y hazlo mejor");
            winAlert.showAndWait();  // Show the alert

            number = (int) (Math.random() * 100 + 1);

        } else {
            Alert failAlert = new Alert(Alert.AlertType.WARNING);
            failAlert.setTitle("¡Has fallado!");
            if (number > responseNumber) {
                failAlert.setContentText("El número es mayor que " + responseNumber + "\nVuelve a jugar y hazlo mejor.");
            } else {
                failAlert.setContentText("El número es menor que " + responseNumber + "\nVuelve a jugar y hazlo mejor.");
            }
            failAlert.setTitle("¡Has fallado!");
            failAlert.showAndWait();  // Show the alert
        }

    } catch (NumberFormatException ex) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Entrada inválida");
            errorAlert.setContentText("El número introducido no es válido");
            errorAlert.showAndWait();  // Show the alert
        }
    }

}

