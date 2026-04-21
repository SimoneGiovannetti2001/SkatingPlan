package com.example.skatingplan.utili;

import com.example.skatingplan.model.enumerazioni.ModalitaGui;
import com.example.skatingplan.model.enumerazioni.ModalitaPersistenza;


public class AppConfig {

    private static AppConfig istanza;

    private final ModalitaGui modalitaGuiCorrente;
    private final ModalitaPersistenza modalitaPersistenzaCorrente;

    private AppConfig(ModalitaPersistenza modalitaPersistenza, ModalitaGui modalitaGui) {
        this.modalitaGuiCorrente = modalitaGui;
        this.modalitaPersistenzaCorrente = modalitaPersistenza;
    }

    //Inizializzazione
    public static void init(ModalitaPersistenza modalitaPersistenza, ModalitaGui modalitaGui) {
        if (istanza != null) {
            throw new IllegalStateException("AppConfig già inizializzato");
        }
        istanza = new AppConfig(modalitaPersistenza, modalitaGui);
    }

    //accesso
    public static AppConfig getInstance() {
        if (istanza == null) {
            throw new IllegalStateException("AppConfig non inizializzato");
        }
        return istanza;
    }

    public ModalitaGui getModalitaGuiCorrente() {
        return modalitaGuiCorrente;
    }

    public ModalitaPersistenza getModalitaPersistenzaCorrente() {
        return modalitaPersistenzaCorrente;
    }
}
