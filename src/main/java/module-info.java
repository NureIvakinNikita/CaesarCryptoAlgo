module com.example.caesarwithgui {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.caesarwithgui to javafx.fxml;
    exports com.example.caesarwithgui;
}