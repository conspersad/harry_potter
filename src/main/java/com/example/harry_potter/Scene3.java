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
        String existingText = The_philosopher_stone_Intro.getText();
        String newText = existingText +  wizard.getName() + " : Do you know what happend to Nevile ? He never miss potion class !\n" +
                "Hermione: Well, i saw him coming back from the toilets of the donjon yesterdays he looked very scared, it's seems like he saw a ghost!!\n" +
                wizard.getName()+" : I should probably find him ! \n" +
                wizard.getName()+" : I'm gonna find where he is hiding !\n"+
                wizard.getName()+" : Are you here..\n"+
                wizard.getName()+": Ho my god, WHAT HAPPEND HERE !!!\n"+
                "Nevile: I'm SORRY\nNevile: I'm SORRY\nNevile: I heard weird noise in the toilet yesterday night so i passe again today but\nNevile: I'm  didn't know it was a\nNevile: TROLL !!!\nNevile: You have to use Wingardium Leviosa !!!\n ";
        The_philosopher_stone_Intro.setText(newText);
        window.getChildren().addAll(The_philosopher_stone,The_philosopher_stone_Intro);
    }

}
