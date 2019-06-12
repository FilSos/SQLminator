//package view;
//
//import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.stage.Stage;
//
//import java.io.IOException;
//import java.util.Objects;
//
//public class Empl extends Application {
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//
//    @Override
//    public void start(Stage primaryStage) throws IOException {
//        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("empl.fxml")));
//        primaryStage.setTitle("Employees");
//        primaryStage.setMaximized(true);
//        primaryStage.setScene(new Scene(root));
//        primaryStage.show();
//    }
//}
