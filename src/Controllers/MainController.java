package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.IOException;


public class MainController {

    @FXML
    private Button randomPasswordButton, tutorialButton;

    @FXML
    void randomPassword(ActionEvent event) throws Exception {
        //method for start button
        //launches rpg.fxml scene and closes main
        Stage stage = (Stage)randomPasswordButton.getScene().getWindow();
        stage.close();
        Stage stage2 = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/Scenes/rpg.fxml"));
        stage2.setTitle("Random Password Generator");
        stage2.setScene(new Scene(root, 600, 400));
        stage2.setResizable(false);
        stage2.show();
    }

    @FXML
    public void ownPassword(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage)randomPasswordButton.getScene().getWindow();
        stage.close();
        Stage stage2 = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/Scenes/ownPass.fxml"));
        stage2.setTitle("Save Own Password");
        stage2.setScene(new Scene(root, 600, 400));
        stage2.setResizable(false);
        stage2.show();
    }

    @FXML
    void tutorial(ActionEvent event) throws Exception{
        //method for tutorial button
        //launches tutorial.fxml scene and closes main
        Stage stage = (Stage)tutorialButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/Scenes/tutorial.fxml"));
        Scene scene = new Scene(root, 600, 400);
        stage.setTitle("Tutorial");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    public void openFiles(ActionEvent actionEvent) throws IOException{
        //method for openFilesButton
        //launches finder to see files
        if(Desktop.isDesktopSupported()){
            Desktop.getDesktop().browse(new File("/Users/ryanwagner/Desktop/Password Manager/Passwords").toURI());
        }
    }
}
