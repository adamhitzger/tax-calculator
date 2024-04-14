module net.stredniskola.adamhitzger.it.files {
    requires javafx.controls;
    requires javafx.fxml;


    opens net.stredniskola.adamhitzger.it.files to javafx.fxml;
    exports net.stredniskola.adamhitzger.it.files;
}