module com.example.grpc {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.grpc to javafx.fxml;
    exports com.example.grpc;
}