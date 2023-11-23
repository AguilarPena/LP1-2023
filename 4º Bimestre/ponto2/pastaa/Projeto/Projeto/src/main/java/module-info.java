module gaeeds.projeto {
    requires jakarta.persistence;
    requires javafx.controls;
    requires org.hibernate.orm.core;
    requires javafx.fxml;
    requires java.naming;


    opens GerenciadorDeTarefas.projeto to javafx.fxml, org.hibernate.orm.core;
    exports GerenciadorDeTarefas.projeto;
    exports controles;
    opens controles to javafx.fxml, org.hibernate.orm.core;
    exports modelos;
    opens modelos to javafx.fxml, org.hibernate.orm.core;
}