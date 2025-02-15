module com.example.oopproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires jdk.compiler;


    opens com.example.oopproject to javafx.fxml;
    exports com.example.oopproject;
}