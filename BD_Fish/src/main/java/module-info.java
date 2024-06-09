module com.example.bd_fish {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.bd_fish to javafx.fxml;
    exports com.example.bd_fish;
}