package com.example.harry_potter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.control.Alert;
import javafx.stage.Stage;


public class Scene3 {

    @FXML
    private VBox window;
    @FXML
    private Label The_philosopher_stone;

    @FXML
    private Label The_philosopher_stone_Intro;
    @FXML
    private Label Label_suite_intro;
    Wizard wizard=new Wizard(HelloController.getName(),100,0,Scene2.getHouse(),HelloController.getPet(), HelloController.getCore());


    private void Intro_scene(){
        window.getChildren().addAll(The_philosopher_stone, The_philosopher_stone_Intro, Label_suite_intro);
    }
    public void StopGame() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText("Thank for playing !");
        Stage stage = (Stage) window.getScene().getWindow();
        stage.close();
    }
    @FXML
    private void Fight() {
        window.getChildren().clear();
        Label choose_pet = new Label("Please your compagnon for the adventure !");
    }
}
