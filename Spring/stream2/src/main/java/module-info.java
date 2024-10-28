module com.example.stream2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.stream2 to javafx.fxml;
    exports com.example.stream2;
}