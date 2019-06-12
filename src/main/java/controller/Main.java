package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Main {

//    public void btnEmpClick() throws Exception{
//        System.out.println("BtnEmplClick");
//        Stage primaryStage=new Stage();
//        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("empl.fxml")));
//        primaryStage.setTitle("Employees - Departements Management System");
//        primaryStage.setMaximized(true);
//        primaryStage.setScene(new Scene(root));
//        primaryStage.initModality(Modality.APPLICATION_MODAL);
//        primaryStage.show();
//    }

    public void btnAddBaseClick() throws IOException {
        System.out.println("Dodaj baze");
        Stage primaryStage=new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("base.fxml")));
        primaryStage.setTitle("Dodaj bazę danych");
        primaryStage.setMaximized(false);
        Scene scene=new Scene(root);
        scene.getStylesheets().add(getClass().getClassLoader().getResource("style.css").toExternalForm());
        primaryStage.setScene(scene);
       // primaryStage.initModality(Modality.APPLICATION_MODAL);
        primaryStage.show();
    }

    public void btnProgramStartClick() {
        System.out.println("Wystartuj program");
    }

    public void btnAddCSVClick() {
        System.out.println("Dodaj plik CSV");
    }

}