module com.example.skatingplan {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.skatingplan to javafx.fxml;
    exports com.example.skatingplan;
    exports com.example.skatingplan.controllergrafici;
    opens com.example.skatingplan.controllergrafici to javafx.fxml;
    exports com.example.skatingplan.model;
    opens com.example.skatingplan.model to javafx.fxml;
    exports com.example.skatingplan.model.bean;
    opens com.example.skatingplan.model.bean to javafx.fxml;
    exports com.example.skatingplan.model.enumerazioni;
    opens com.example.skatingplan.model.enumerazioni to javafx.fxml;
}