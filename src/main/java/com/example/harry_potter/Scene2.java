package com.example.harry_potter;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;

public class Scene2 {
    @FXML
    private RadioButton answer51Button, answer52Button, answer53Button, answer54Button;
    @FXML
    private RadioButton answer41Button, answer42Button, answer43Button, answer44Button;
    @FXML
    private RadioButton answer31Button, answer32Button, answer33Button, answer34Button;
    @FXML
    private RadioButton answer21Button, answer22Button, answer23Button, answer24Button;
    @FXML
    private RadioButton answer1Button, answer2Button, answer3Button, answer4Button;

    @FXML
    private Label wandSizeLabel;
    @FXML
    private VBox window;

    @FXML
    private TextField wandSizeField;

    @FXML
    private Button wandSizeButton;
    @FXML
    private Label Outro;

    private String[] house = {"Gryffindor", "Hufflepuff", "Ravenclaw", "Slytherin"};
    public static String test1;
    public void showHouse() {
        your_house();
    }

    public String your_house() {
        int a = 0, b = 0, c = 0, d = 0;
        if (answer1Button.isSelected() || answer21Button.isSelected() || answer31Button.isSelected() || answer41Button.isSelected() || answer51Button.isSelected()) {
            a++;
        }
        else if (answer2Button.isSelected() || answer22Button.isSelected() || answer32Button.isSelected() || answer42Button.isSelected()|| answer52Button.isSelected()) {
            b++;
        }
        else if (answer3Button.isSelected() || answer23Button.isSelected() || answer33Button.isSelected() || answer43Button.isSelected()|| answer53Button.isSelected()) {
            c++;
        }
        else if (answer4Button.isSelected() || answer24Button.isSelected() || answer34Button.isSelected() || answer44Button.isSelected()|| answer54Button.isSelected()) {
            d++;
        }

        int max = a;
        String test1 = null;
        if (b > max) {
            Outro.setText("""
                    Your house is Ravenclaw,
                    Intensely intelligent, Ravenclaws are also unique and think outside the box.
                    his is usually a good thing, unless by 'thinking outside the box' you mean stealing other wizards' stories and erasing their memories, like a certain Ravenclaw called Gilder Lockhart.""");
            test1 = house[2];
            Button GoToScene_fight = new Button("Continue");
            window.getChildren().add(GoToScene_fight);
            GoToScene_fight.setOnAction(e -> GoToScene_fight());

        }

       else if (c > max) {
            max = c;
            test1 = house[1];
            Outro.setText("""
                    Your house is Hufflepuff,
                    Hufflepuff characteristics include a strong sense of justice, loyalty, patience, and a propensity for hard work.
                    Hufflepuff are also seen as nice, almost to a fault. Hogwarts houses have moved beyond the realm of fiction and into the real worlds""");
            Button GoToScene_fight = new Button("Continue");
            window.getChildren().add(GoToScene_fight);
            GoToScene_fight.setOnAction(e -> GoToScene_fight());
        }

        else if (d > max) {
            max = d;
            test1 = house[0];
            Outro.setText("""
                    Your house is Gryffindor,
                    Courage and chivalry are two of the most recognisable qualities when it comes to this house\s
                    but that doesn't mean that every Gryffindor is always supremely confident and self-assured.
                    Some can be nervous or unsure of themselves and still belong there. Courage doesn't have to involve flashy or daring gestures.""");
            Button GoToScene_fight = new Button("Continue");
            window.getChildren().add(GoToScene_fight);
            GoToScene_fight.setOnAction(e -> GoToScene_fight());
        }
        else if (max == a) {
            test1 = house[3];
            Outro.setText("""
                    Your house is Slytherin, Slytherin are known for being ambitious, cunning, and resourceful.s
                    Slytherins are also sometimes regarded as being evil thanks to the fact that many of the most sinister witches and wizards
                    have been associated with this house.""");
            Button GoToScene_fight = new Button("Continue");
            window.getChildren().add(GoToScene_fight);
            GoToScene_fight.setOnAction(e -> GoToScene_fight());
        }
        return test1;

    }
    public static String getHouse() {
        return test1;
    }
    public void GoToScene_fight(){
        window.getChildren().clear();
        // Get the current stage

        Stage stage = (Stage) window.getScene().getWindow();

        // Load the FXML file for the second scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view3.fxml"));
        Parent root = null;
        try {
            root = loader.<Parent>load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Create a new scene with the loaded root node
        Scene Scene3;
        Scene3 = new Scene(root,600,600 );

        // Set the new scene to be displayed on the stage
        stage.setScene(Scene3);
    }

}
