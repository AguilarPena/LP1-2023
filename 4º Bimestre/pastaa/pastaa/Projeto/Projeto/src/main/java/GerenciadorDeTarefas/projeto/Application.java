package GerenciadorDeTarefas.projeto;

import classes.Usuario;
import GerenciadorDeTarefas.projeto.util.HibernateUtil;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.Transaction;


import java.io.IOException;

public class Application extends javafx.application.Application {

    //para poder usar em outros métodos
    private static Stage stage;
    private static Scene Login;
    private static Scene CriaContaController;
    private static Scene Principal;


    @Override
    public void start(Stage stageInicial) throws IOException {

        this.stage = stageInicial;

        FXMLLoader fxmlLoaderLogin = new FXMLLoader(Application.class.getResource("Login.fxml"));
        FXMLLoader fxmlLoaderCadastro = new FXMLLoader(Application.class.getResource("CriaContaController.fxml"));
        FXMLLoader fxmlLoaderPrincipal = new FXMLLoader(Application.class.getResource("Principal.fxml"));
        CriaContaController = new Scene(fxmlLoaderCadastro.load());
        Login = new Scene(fxmlLoaderLogin.load());
        Principal = new Scene(fxmlLoaderPrincipal.load());
        stage.setTitle("Seu gerenciador de tarefas preferido!");
        stage.setScene(Login); //primeira scene que aparece
        stage.show();

          /*Usuario user1 = new Usuario("Sarah", "sarah@gmail", "123");
          Session session = HibernateUtil.getSessionFactory().openSession();
          Transaction transaction = session.beginTransaction();
          session.persist(user1);
          transaction.commit();*/
    }

    //settar uma scene no stage
    public static void mudartela(String tela){
        switch(tela){
            case "Login":
                stage.setScene(Login);
                break;
            case "CriaContaController":
                stage.setScene(CriaContaController);
                break;
            case "Principal":
                stage.setScene(Principal);
                break;
        }
    }

    @Override
    public void init() throws Exception{
        Usuario user1 = new Usuario("Sarah", "sarah@gmail", "123");
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(user1);
        transaction.commit();
        session.close();
    }

    public static void main(String[] args) {
        launch();
    }
}