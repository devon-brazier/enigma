import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;

import java.awt.*;

public class GUI extends Application {

    EnigmaMachine enigma = new EnigmaMachine("", 3, new int[]{0,0,0}, "");

    @Override
    public void start(Stage stage) {

        Text inputText = new Text("Input");
        Text encryptionText = new Text("Encryption");
        Text plugsText = new Text("Plugboard Pairs");
        Text plugExplain = new Text("Enter char pairs e.g. ABCD = A->B, C->D");
        Text Rotors = new Text("No. of rotors");
        Text numberOfRotors = new Text(String.valueOf(enigma.getNumberOfRotors()));
        Text rotorPresetText = new Text("Rotor Presets");


        TextField inputTextField = new TextField();
        TextField encryptionTextField = new TextField();
        TextField plugboardPairsField = new TextField();
        TextField rotorPresetTextField1 = new TextField("0");
        TextField rotorPresetTextField2 = new TextField("0");
        TextField rotorPresetTextField3 = new TextField("0");

        Button addRotorButton = new Button("+");
        Button removeRotorButton = new Button("-");
        Button clearButton1 = new Button("Clear");
        Button clearButton2 = new Button("Clear");
        Button closeButton = new Button("Close");
        Button encryptButton = new Button("Encrypt");
        Button decryptButton = new Button("Decrypt");

        final EventHandler<MouseEvent> eventHandlerAddRotor = e -> {
            if (enigma.getNumberOfRotors() + 1 <= enigma.getMaxRotors()){
                enigma.setNumberOfRotors(enigma.getNumberOfRotors() + 1);
                numberOfRotors.setText(String.valueOf(enigma.getNumberOfRotors()));
            }
        };
        addRotorButton.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandlerAddRotor);

        final EventHandler<MouseEvent> eventHandlerRemoveRotor = e -> {
            if (enigma.getNumberOfRotors() - 1 >= 0){
                enigma.setNumberOfRotors(enigma.getNumberOfRotors() - 1);
                numberOfRotors.setText(String.valueOf(enigma.getNumberOfRotors()));
            }
        };
        removeRotorButton.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandlerRemoveRotor);

        final EventHandler<MouseEvent> eventHandlerClearInput = e -> {
            inputTextField.setText("");
        };
        clearButton1.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandlerClearInput);

        final EventHandler<MouseEvent> eventHandlerClearE = e -> {
            encryptionTextField.setText("");
        };
        clearButton2.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandlerClearE);

        final EventHandler<MouseEvent> eventHandlerClose = e -> {
            System.exit(1);
        };
        closeButton.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandlerClose);

        final EventHandler<MouseEvent> eventHandlerEncrypt = e -> {
            enigma = new EnigmaMachine(inputTextField.getText(), enigma.getNumberOfRotors(), new int[]{Integer.parseInt(rotorPresetTextField1.getText()),Integer.parseInt(rotorPresetTextField1.getText()),Integer.parseInt(rotorPresetTextField1.getText())}, plugboardPairsField.getText());
            encryptionTextField.setText(enigma.encrypt(false).toString());
        };
        encryptButton.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandlerEncrypt);

        final EventHandler<MouseEvent> eventHandlerDecrypt = e -> {
            enigma = new EnigmaMachine(encryptionTextField.getText(), enigma.getNumberOfRotors(), new int[]{Integer.parseInt(rotorPresetTextField1.getText()),Integer.parseInt(rotorPresetTextField1.getText()),Integer.parseInt(rotorPresetTextField1.getText())}, plugboardPairsField.getText());
            inputTextField.setText(enigma.encrypt(true).toString());
        };
        decryptButton.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandlerDecrypt);

        //Creating a Grid Pane
        GridPane gridPane = new GridPane();

        //Setting the vertical and horizontal gaps between the columns
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setPadding(new Insets(10, 10, 10, 10));

        //Adding the nodes to the grid
        gridPane.add(Rotors, 0, 0);
        gridPane.add(numberOfRotors, 1, 0);
        gridPane.add(addRotorButton, 2, 0);
        gridPane.add(removeRotorButton, 3, 0);

        gridPane.add(rotorPresetText, 0, 1);
        gridPane.add(rotorPresetTextField1, 1, 1);
        gridPane.add(rotorPresetTextField2, 2, 1);
        gridPane.add(rotorPresetTextField3, 3, 1);

        gridPane.add(plugsText, 0, 2);
        gridPane.add(plugboardPairsField, 1, 2);
        gridPane.add(plugExplain, 2, 2);

        gridPane.add(inputText, 0, 3);
        gridPane.add(inputTextField, 1, 3);
        gridPane.add(clearButton1, 2, 3);

        gridPane.add(encryptionText, 0, 4);
        gridPane.add(encryptionTextField, 1, 4);
        gridPane.add(clearButton2, 2, 4);

        gridPane.add(encryptButton, 0, 5);
        gridPane.add(decryptButton, 1, 5);
        gridPane.add(closeButton, 3, 5);

        Scene scene = new Scene(gridPane);
        stage.setTitle("Enigma Page");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}