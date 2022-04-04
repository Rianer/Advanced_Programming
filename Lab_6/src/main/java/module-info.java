module com.example.gamelab6 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;

    opens com.example.gamelab6 to javafx.fxml;
    exports com.example.gamelab6;
}