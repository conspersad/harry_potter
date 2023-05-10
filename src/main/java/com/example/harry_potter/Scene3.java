package com.example.harry_potter;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;


public class Scene3 {

    @FXML
    private VBox window;
    @FXML
    private Label The_philosopher_stone;


    @FXML
    private Label The_philosopher_stone_Intro;
    Wizard wizard=new Wizard(HelloController.getName(),100,0,Scene2.getHouse(),HelloController.getPet(), HelloController.getCore());

    private void Intro_scene(){
        window.getChildren().removeAll(The_philosopher_stone,The_philosopher_stone_Intro);
    }

}
