package com.example.skatingplan.utili;

import javafx.animation.PauseTransition;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class GestoreMessaggiGUI {
    private GestoreMessaggiGUI() {
        //non dovrebbe essere istanziata
    }


    private static PauseTransition pausa;

    public static void mostraErrore(Label label, String message){
        label.setText(message);
        label.setVisible(true);

        // se c'è già un timer attivo lo fermo
        if (pausa != null) {
            pausa.stop();
        }

        pausa = new PauseTransition(Duration.seconds(2));
        pausa.setOnFinished(e -> label.setVisible(false));
        pausa.playFromStart();

    }
}
