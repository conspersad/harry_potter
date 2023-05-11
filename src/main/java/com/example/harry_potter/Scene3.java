package com.example.harry_potter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.control.Alert;
import javafx.stage.Stage;


public class Scene3 {

    @FXML
    private Button fight;
    @FXML
    private Button left;
    @FXML
    private VBox window;
    @FXML
    private Label The_philosopher_stone;

    @FXML
    private Label The_philosopher_stone_Intro;
    @FXML
    private Label Label_suite_intro;
    Enemy enemy;
    static Wizard wizard=new Wizard(HelloController.getName(),100,0,Scene2.getHouse(),HelloController.getPet(), HelloController.getCore());


    private void Intro_scene(){
        window.getChildren().addAll(The_philosopher_stone, The_philosopher_stone_Intro, Label_suite_intro);
    }
    public void StopGame() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        left.setOnAction(e->{
            alert.setHeaderText(null);
            alert.setContentText("Thank for playing !");
            alert.showAndWait();
            Stage stage = (Stage) window.getScene().getWindow();
            stage.close();
        });
    }
    @FXML
    private void Fight() {
        fight.setOnAction(e->{
            enemy = new Enemy("Troll", 30, 10);
            Button go_toScene6 = new Button("Continue");
            window.getChildren().add(go_toScene6);
            go_toScene6.setOnAction(event ->battle());
    });
}
    public void battle(){
        window.getChildren().clear();
        // Boucle principale du jeu
        while (wizard.isAlive() && enemy.isAlive()) {
            wizard.xp=Spell.damage;

            Label score = new Label(wizard.getName() + " (" + wizard.hp + " hp, " + wizard.getXp() + " Xp) vs " + enemy.getName() + " (" + enemy.getHp() + " hp, " +  enemy.getXp() + " xp)");

            ToggleGroup choose = new ToggleGroup();

            RadioButton fight = new RadioButton("Fight "+ enemy.getName());
            fight.setToggleGroup(choose);

            RadioButton life = new RadioButton("Use a sort to have more Hp (only if your life is < 100");
            life.setToggleGroup(choose);

            window.getChildren().addAll(fight, life);
            Button submitButton = new Button("Choose");

            window.getChildren().add(submitButton);

            submitButton.setOnAction(event -> {
                window.getChildren().clear();
                        if (fight.isSelected()){
                            int damage =  wizard.attack();
                            int reducedDamage = enemy.defend();
                            int totalDamage = reducedDamage * damage;
                            int enemy_hp = enemy.getHp()- totalDamage;
                            enemy.setHp(enemy_hp);
                            Label attack = new Label(wizard.getName()+ " attack inflict " + damage + " damage points\n");

                            if(totalDamage==0){
                                Label result = new Label(enemy.getName() + " dodge your attack\n");
                            }else {
                                Label result = new Label( enemy.getName() + " was hit!\n");
                        }}
                        else if (life.isSelected()) {
                            if((wizard.getHouse().equals("Hufflepuff"))&&(wizard.getHp() <100))
                            {
                                int healed = 20;
                                wizard.setHp(wizard.getHp() +healed);
                                Label result = new Label("You healed "+ healed+" Hp !\n");
                                Wizard.nbr_de_potion = Wizard.nbr_de_potion -1;

                            }else if((!wizard.getHouse().equals("Hufflepuff"))&&(wizard.getHp()<100)){
                                int healed = 25;
                                Label result = new Label("You healed "+ healed+" Hp !\n");
                                wizard.setHp(wizard.getHp() +healed);
                                Wizard.nbr_de_potion = Wizard.nbr_de_potion -1;

                            }  else if (wizard.getHp() >=100) {
                                Label result = new Label("You have enough hp\n");
                            }
                        }
            });

            if (enemy.isAlive()) {
                int damage = enemy.attack();
                int reducedDamage = wizard.defend();
                int totalDamage = reducedDamage * damage;
                int wizard_hp = wizard.getHp()- totalDamage;
                wizard.setHp(wizard_hp);
                Label result2 = new Label( enemy.getName() + " attack causing " + damage + " damage points. \n\n"
                        + wizard.getName() + " take " + totalDamage + " damage points.\n");
            }
        }
        // Fin du jeu
        if (wizard.isAlive()) {
            Label result3 = new Label(wizard.getName()+ " defeat " + enemy.getName() + " !\n");

        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            Label result4 = new Label(enemy.getName()+ " defeat " + wizard.getName()+ " !\n");
            alert.setHeaderText(null);
            alert.setContentText("You died ! Thank for playing !");
            alert.showAndWait();
            Stage stage = (Stage) window.getScene().getWindow();
            stage.close();
        }
    }
}

