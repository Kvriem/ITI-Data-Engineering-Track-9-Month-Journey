module com.mycompany.texteditorgui {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.texteditorgui to javafx.fxml;
    exports com.mycompany.texteditorgui;
}
