package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class tutorialController {

    @FXML
    private Button backButton;

    @FXML
    private RadioButton upperButton, specialCharButton;

    @FXML
    public void upperButtonClick(ActionEvent actionEvent) {
    }

    @FXML
    public void specialButtonClick(ActionEvent actionEvent) {
    }

    @FXML
    public void back(javafx.event.ActionEvent actionEvent) throws Exception{
        Stage stage = (Stage)backButton.getScene().getWindow();
        stage.close();
        Stage stage2 = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/Scenes/Main.fxml"));
        stage2.setTitle("Tutorial");
        stage2.setScene(new Scene(root, 600, 325));
        stage2.setResizable(false);
        stage2.show();
    }
}
