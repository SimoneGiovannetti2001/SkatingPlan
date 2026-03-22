module com.example.skatingplan {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.skatingplan to javafx.fxml;
    exports com.example.skatingplan;
    exports com.example.skatingplan.ControllerGrafici;
    opens com.example.skatingplan.ControllerGrafici to javafx.fxml;
}