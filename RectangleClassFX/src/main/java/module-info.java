module com.example.rectangleclassfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.rectangleclassfx to javafx.fxml;
    exports com.example.rectangleclassfx;
}

