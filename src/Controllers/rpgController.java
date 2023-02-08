package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.File;
import java.util.Random;

public class rpgController {

    public static String password = "";

    @FXML
    private Label passwordLabel, length;

    @FXML
    private Button backButton, savePasswordButton, minusButton, plusButton;

    @FXML
    private RadioButton upperCaseButton, specialCharButton;

    private File file;

    private boolean upper = false, special = false, number = false;

    @FXML
    public void generate(ActionEvent actionEvent) {
        //method for generate button
        //generates password
        int value = 0;
        try {
            value = Integer.parseInt(length.getText());

        } catch (Exception e) {
            passwordLabel.setText("Enter a number value for length of password");
        }
        passwordLabel.setText(generatePassword(value));
    }

    @FXML
    public void back(javafx.event.ActionEvent actionEvent) throws Exception{
        //method for back button
        //launches Main and closes current scene
        Stage stage = (Stage)backButton.getScene().getWindow();
        stage.close();
        Stage stage2 = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/Scenes/Main.fxml"));
        stage2.setTitle("Locked In");
        stage2.setScene(new Scene(root, 600, 325));
        stage2.setResizable(false);
        stage2.show();
    }

    @FXML
    public void upperButtonClick(ActionEvent actionEvent) {
        //button to select uppercase letters
        if(upper){
            upper = false;
        }
        else upper = true;
    }

    @FXML
    public void specialButtonClick(ActionEvent actionEvent) {
        //button to select special characters
        if(special){
            special = false;
        }
        else special = true;
    }

    public void numberButtonClick(ActionEvent actionEvent) {
        if(number){
            number = false;
        }
        else number = true;
    }

    public String generatePassword(int length){
        //method to randomly create password
        Random rand = new Random();
        String password = "";
        String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        String[] capAlpha = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        String[] specialC = {"!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "_", "-", "+", "="};
        String[] numbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
        for(int i = 0; i < length; i++){
            int c = rand.nextInt(4);
            if(c == 0) {
                int index = rand.nextInt(26);
                password += alphabet[index];
            }
            if(c == 1 && upper){
                int index = rand.nextInt(26);
                password += capAlpha[index];
            }
            if(c == 1 && !upper){
                int index = rand.nextInt(26);
                password += alphabet[index];
            }
            if(c == 2 && special){
                int index = rand.nextInt(14);
                password += specialC[index];
            }
            if(c == 2 && !special){
                int index = rand.nextInt(26);
                password += alphabet[index];
            }
            if(c == 3 && number){
                int index = rand.nextInt(10);
                password += numbers[index];
            }
            if(c == 3 && !number){
                int index = rand.nextInt(26);
                password += alphabet[index];
            }
        }
        return password;
    }

    @FXML
    public void savePassword(ActionEvent actionEvent) throws Exception{
        //saves password and launches save password scene
        password = passwordLabel.getText();
        SavePasswordController.password = password;
        Stage stage = (Stage)savePasswordButton.getScene().getWindow();
        stage.close();
        Stage stage2 = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/Scenes/savePassword.fxml"));
        stage2.setTitle("Save Password");
        stage2.setScene(new Scene(root, 400, 300));
        stage2.setResizable(false);
        stage2.show();
    }

    public void minus(ActionEvent actionEvent) {
        int count = Integer.parseInt(length.getText());
        count--;
        length.setText(String.valueOf(count));
    }

    public void plus(ActionEvent actionEvent) {
        int count = Integer.parseInt(length.getText());
        count++;
        length.setText(String.valueOf(count));
    }
}
