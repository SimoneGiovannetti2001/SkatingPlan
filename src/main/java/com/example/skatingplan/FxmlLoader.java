package com.example.skatingplan;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;


public class FxmlLoader extends Application {

    private static Stage currentStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage stage;
        FXMLLoader fxmlLoader = new FXMLLoader(FxmlLoader.class.getResource("views1/sceltamodalita-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage = primaryStage;
        stage.setTitle("SkatingPlan");
        stage.setResizable(false);
        stage.setScene(scene);
        setStage(stage);
        stage.show();
    }

    private static void setStage(Stage stage){
        currentStage = stage;
    }

    public static FXMLLoader setPage(String fileName){
        URL fileURL = FxmlLoader.class.getResource(fileName + ".fxml");

        if (fileURL == null){
            throw new RuntimeException("FXML non trovato: "+ fileName);
        }

        FXMLLoader loader = new FXMLLoader(fileURL);

        try{
            Parent root = loader.load();
            Scene scene = new Scene(root, 1280, 720);
            currentStage.setScene(scene);
            return loader;
        }catch (IOException e) {
            //da implementare
        }
        return loader;

    }

    public static void main(String[] args) {
        launch();
    }

}
