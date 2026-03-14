module com.example.skatingplan {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.skatingplan to javafx.fxml;
    exports com.example.skatingplan;
}