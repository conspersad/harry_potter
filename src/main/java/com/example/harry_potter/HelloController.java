package com.example.harry_potter;


import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    public Button gotoname;
    public static String name;
    public static int size;
    public static Pet SelectPet;
    public static Core SelectCore;
    @FXML
    private VBox window;
    @FXML
    private Label welcomeText;


    @FXML
    private void onHelloButtonClick() {

     GoToScene2();

    }
    private void GoToScene2() {
        window.getChildren().removeAll(welcomeText,gotoname);
        Label ask_name = new Label("What's your name ??");
        TextField enter_name = new TextField("Enter your name");
        Button name_ok = new Button("OK");
        window.getChildren().addAll(ask_name,enter_name,name_ok);
        name_ok.setOnAction(event -> {
            name = enter_name.getText();
            Label welcome = new Label("Welcome to Poudlard "+ name);
            Button go_toScene3 = new Button("Continue");
            window.getChildren().addAll(welcome,go_toScene3);
            go_toScene3.setOnAction(e -> GoToScene3());
        });
    }
    public static String getName() {
        return name;
    }
    private void GoToScene3(){
        window.getChildren().clear();
        Label choose_pet = new Label("Please your compagnon for the adventure !");
        window.getChildren().add(choose_pet);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        // Créer un ToggleGroup pour que les boutons radio soient mutuellement exclusifs
        ToggleGroup animalGroup = new ToggleGroup();

        // Créer des boutons radio pour chaque option de choix d'animal
        RadioButton owlButton = new RadioButton("Owl");
        owlButton.setToggleGroup(animalGroup);

        RadioButton ratButton = new RadioButton("Rat");
        ratButton.setToggleGroup(animalGroup);

        RadioButton catButton = new RadioButton("Cat");
        catButton.setToggleGroup(animalGroup);

        RadioButton toadButton = new RadioButton("Toad");
        toadButton.setToggleGroup(animalGroup);

        // Ajouter les boutons radio à la VBox
        window.getChildren().addAll(owlButton, ratButton, catButton, toadButton);
        // Ajouter un bouton pour permettre à l'utilisateur de valider son choix
        Button submitButton = new Button("Choose");
        // Ajouter le bouton de soumission à la VBox
        window.getChildren().add(submitButton);

        submitButton.setOnAction(event -> {

            // Récupérer l'option sélectionnée par l'utilisateur
            Pet  SelectPet = null;
            if (owlButton.isSelected()) {
                SelectPet = Pet.Owl;
            } else if (ratButton.isSelected()) {
                SelectPet = Pet.Rat;
            } else if (catButton.isSelected()) {
                SelectPet = Pet.Cat;
            } else if (toadButton.isSelected()) {
                SelectPet = Pet.Toad;
            }

            // Afficher un message de confirmation
            if (SelectPet != null) {
                alert.setTitle("Pet selected");
                alert.setHeaderText(null);
                alert.setContentText("Nice, you have a new " + SelectPet.toString() + " as your companion!");
                alert.showAndWait();
            }
            Button goToWand = new Button("Continue");
            window.getChildren().addAll(goToWand);
            goToWand.setOnAction(e -> GoToScene4());
        });
        }

    public static Pet getPet() {
        return SelectPet;
    }
    private void GoToScene4(){
        window.getChildren().clear();
        Label choose_core = new Label("Please the core for your wand!");
        window.getChildren().add(choose_core);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        // Créer un ToggleGroup pour que les boutons radio soient mutuellement exclusifs
        ToggleGroup Wand_core = new ToggleGroup();

        // Créer des boutons radio pour chaque option de choix d'animal
        RadioButton Phoenix_feather = new RadioButton("Phoenix feather");
        Phoenix_feather.setToggleGroup(Wand_core);

        RadioButton Dragon_heartstring = new RadioButton("Dragon heartstring");
        Dragon_heartstring.setToggleGroup(Wand_core);

        window.getChildren().addAll(Phoenix_feather, Dragon_heartstring);
        // Ajouter un bouton pour permettre à l'utilisateur de valider son choix
        Button submitButton = new Button("Choose");
        // Ajouter le bouton de soumission à la VBox
        window.getChildren().add(submitButton);

        submitButton.setOnAction(event -> {

            // Récupérer l'option sélectionnée par l'utilisateur
            Core SelectCore = null;
            if (Phoenix_feather.isSelected()) {
                SelectCore = Core.Phoenix_feather;
            } else if (Dragon_heartstring.isSelected()) {
                SelectCore = Core.Dragon_heartstring;
            }
            // Afficher un message de confirmation
            if (SelectCore != null) {
                alert.setTitle("Wand Core selected");
                alert.setHeaderText(null);
                alert.setContentText("Your wand is made of " + SelectCore.toString() + ", you are very wise");
                alert.showAndWait();
            }
            Button goToWand_size = new Button("Continue");
            window.getChildren().addAll(goToWand_size);
            goToWand_size.setOnAction(e -> GoToScene5());
        });
    }

    private void GoToScene5(){
        window.getChildren().clear();
        Label promptLabel = new Label("Now you have to choose your wand\n" +  "this one would choose you but what size would you like ?\n"+"It has to be between 9 and 40 inches");
        TextField field_size = new TextField("Enter the size of your wand");
        Button size_ok = new Button("OK");
        window.getChildren().addAll(promptLabel,field_size,size_ok);
        size_ok.setOnAction(event -> {
            Label promptLabel2 =new Label();
            size = Integer.parseInt(field_size.getText());
            do {
                if (size > 40) {
                    size = Integer.parseInt(field_size.getText());
                    promptLabel2.setText("Your wand is too long, please choose a shorter one");
                    window.getChildren().add(promptLabel2);

                } else if (size < 9) {
                    size = Integer.parseInt(field_size.getText());
                    promptLabel2.setText("Your wand is too short, please choose a longer one");
                    window.getChildren().add(promptLabel2);
                }
            } while ((size > 40) || (size < 9));
            promptLabel2.setText("Perfect your wand is " + size + " inches");
            window.getChildren().add(promptLabel2);
            Button go_toScene6 = new Button("Continue");
            window.getChildren().add(go_toScene6);
            go_toScene6.setOnAction(e -> GoToScene6());
        });

    }public static int getCore() {
        return size;
    }
    private void GoToScene6(){
        window.getChildren().clear();
        // Get the current stage

        Stage stage = (Stage) window.getScene().getWindow();

        // Load the FXML file for the second scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view2.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Create a new scene with the loaded root node
        Scene Scene2 = new Scene(root,600,600 );

        // Set the new scene to be displayed on the stage
        stage.setScene(Scene2);
    }
    }