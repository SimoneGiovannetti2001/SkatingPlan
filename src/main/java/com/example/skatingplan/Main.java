package com.example.skatingplan;


import javafx.application.Application;

import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FxmlLoader fxmlLoader = new FxmlLoader();
        fxmlLoader.start(stage);
    }

    public static void main(String[] args) {
        launch();
    }
}