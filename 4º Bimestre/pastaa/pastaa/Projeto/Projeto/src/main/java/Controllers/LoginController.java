package Controllers;
import GerenciadorDeTarefas.projeto.Application;
import classes.Usuario;

import GerenciadorDeTarefas.projeto.util.HibernateUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.hibernate.Session;

public class LoginController {
    @FXML
    private PasswordField Lsenha;
    @FXML
    private TextField Lnome;
    @FXML
    private Button Lentra;

    @FXML
    private Button Lcadastro;

    @FXML
    private Button Vsenha;

    @FXML
    private Button Vuser;


    //ao clicar no botão cadastrar o usuario é mandado para a tela de cadastro
    @FXML
    void buttonCadastrar(ActionEvent event){
        Application.mudartela("CriaContaController");
    }

   @FXML
    void buttonEntrar(ActionEvent event) {
        verificacaoUser();
       if (verificacaoSenha())
           Application.mudartela("Principal");
    }


    protected void verificacaoUser(){
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            Usuario usuario = session.createQuery("from Usuario where Lnome = :nome", Usuario.class)
                    .setParameter("email", Lnome.getText().toLowerCase())
                    .uniqueResult();

            if(usuario == null){
                Vsenha.setText("usuário não encontrado!");
            }

            //System.out.println(usuario);
            //transaction.commit();
            //Application.mudartela("Principal");
            session.getTransaction().commit();
        } catch(Exception e) {
            if(session.getTransaction() != null)
                session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    protected Boolean verificacaoSenha(){
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            Usuario usuario = session.createQuery("from Usuario where senha = :senha", Usuario.class)
                    .setParameter("senha", Lsenha.getText())
                    .uniqueResult();

            if(usuario == null){
                Vsenha.setText("Senha incorreta!");
                return false;
            }

            //System.out.println(usuario);
            //transaction.commit();
            //Application.mudartela("Principal");
        session.getTransaction().commit();
        } catch(Exception e) {
            if(session.getTransaction() != null)
                session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return true;
    }

    protected void limpar(){
        Vsenha.setText("");
        Vuser.setText("");
    }
}
