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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class SavePasswordController {

    @FXML
    private Button saveButton, backButton;

    @FXML
    private TextField fileNameTF, websiteTF, userNameTF;

    public static String password = "";

    @FXML
    public void savePass(ActionEvent actionEvent) throws IOException {
        //method for saveButton
        // saves password and creates new file with user info


        String fileName = "", website = "", username = "";
        if (fileNameTF.getText().equals("")) {
            System.out.println("Enter a file name");
            return;
        } else {
            fileName = "Passwords/" + fileNameTF.getText() + ".pdf";
        }

        if (websiteTF.getText().equals("")) {
            website = "None";
        } else {
            website = websiteTF.getText();
        }

        if (userNameTF.getText().equals("")) {
            username = "None";
        } else {
            username = userNameTF.getText();
        }
        String one = "";
        Document document = new Document();
        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(fileName));
            writer.setEncryption(one.getBytes(), one.getBytes(), PdfWriter.ALLOW_PRINTING,PdfWriter.ENCRYPTION_AES_128);
            document.open();
            document.add(new Paragraph("Website - " + website + "\n\nUsername - " + username + "\n\nPassword - " + password));
            document.close();
            writer.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Done");

        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/Scenes/saved.fxml"));
        stage.setTitle("Saved");
        stage.setScene(new Scene(root, 250, 150));
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    public void back(ActionEvent actionEvent) throws Exception{
        //method for back button
        //launches main.fxml and closes current scene
        Stage stage = (Stage)backButton.getScene().getWindow();
        stage.close();
        Stage stage2 = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/Scenes/Main.fxml"));
        stage2.setTitle("Locked In");
        stage2.setScene(new Scene(root, 600, 325));
        stage2.setResizable(false);
        stage2.show();
    }
}
