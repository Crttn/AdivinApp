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

    @Override
    public void start(Stage stage) throws Exception {

        Label statementLabel = new Label();
        statementLabel.setText("Introduce el número de 1 al 100");

        TextField responseText = new TextField();
        responseText.setMaxWidth(100);

        Alert winAlert = new Alert(Alert.AlertType.INFORMATION);
        winAlert.setTitle("¡Has ganado!");

        Button checkButton = new Button();
        checkButton.setText("Comprobar");
        checkButton.setDefaultButton(true);
        checkButton.setOnAction(e -> {
            String userInput = responseText.getText();
            winAlert.setHeaderText("Solo has necesitado " + userInput + " intentos.");
            winAlert.setContentText("Vuelve a jugar y hazlo mejor");
            winAlert.showAndWait();  // Show the alert
        });
        //checkButton.setOnAction(this::onActionCheckButton);

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

    }
}
