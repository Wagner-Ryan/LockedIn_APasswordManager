package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ownPassController {

    @FXML
    private Button backButton, saveButton;

    @FXML
    private TextField passwordBox;

    public static String password = "";


    @FXML
    public void back(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage)backButton.getScene().getWindow();
        stage.close();
        Stage stage2 = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/Scenes/Main.fxml"));
        stage2.setTitle("Random Password Generator");
        stage2.setScene(new Scene(root, 600, 400));
        stage2.setResizable(false);
        stage2.show();
    }

    @FXML
    public void save(ActionEvent actionEvent) throws IOException {
        try{
            password = passwordBox.getText();
        }
        catch(Exception e){
            System.out.println("Enter a password");
        }
        SavePasswordController.password = password;

        Stage stage = (Stage)saveButton.getScene().getWindow();
        stage.close();
        Stage stage2 = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/Scenes/savePassword.fxml"));
        stage2.setTitle("Save Password");
        stage2.setScene(new Scene(root, 400, 300));
        stage2.setResizable(false);
        stage2.show();
    }
}
