package GerenciadorDeTarefas.projeto;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {

    //para poder usar em outros métodos
    private static Stage stage;
    private static Scene login;
    private static Scene cadastro;
    private static Scene principal;


    @Override
    public void start(Stage stageInicial) throws IOException {

        this.stage = stageInicial;

        FXMLLoader fxmlLoaderLogin = new FXMLLoader(Application.class.getResource("login.fxml"));
        FXMLLoader fxmlLoaderCadastro = new FXMLLoader(Application.class.getResource("cadastro.fxml"));
        FXMLLoader fxmlLoaderPrincipal = new FXMLLoader(Application.class.getResource("principal.fxml"));

        cadastro = new Scene(fxmlLoaderCadastro.load());
        login = new Scene(fxmlLoaderLogin.load());
        principal = new Scene(fxmlLoaderPrincipal.load());

        stage.setTitle("FireNote");
        stage.setScene(login);
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
            case "login":
                stage.setScene(login);
                break;
            case "cadastro":
                stage.setScene(cadastro);
                break;
            case "principal":
                stage.setScene(principal);
                break;
        }
    }

    /*@Override
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
    }*/
}