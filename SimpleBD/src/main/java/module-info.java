module org.example.SimpleBD {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.compiler;


    opens org.example.SimpleBD to javafx.fxml;
    exports org.example.SimpleBD;
}