package controles;

import GerenciadorDeTarefas.projeto.Application;
import GerenciadorDeTarefas.projeto.util.HibernateUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import modelos.Usuario;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class LoginController {
    @FXML
    private TextField Lsenha;

    @FXML
    private TextField Lemail;

    @FXML
    private Label mensagem;

    @FXML
    private Button Lentra;

    @FXML
    private Button Lcadastro;

    @FXML
    void buttonCadastrar(ActionEvent event){
        Application.mudartela("cadastro");
    }

    public void verificacaoUser(ActionEvent actionEvent) {
        String email = Lemail.getText();
        String senha = Lsenha.getText();

        if(email.isEmpty() && senha.isEmpty())
            exibirErro(0);

        else  if(email.isEmpty())
            exibirErro(1);

        else if(senha.isEmpty())
            exibirErro(2);

        else{

            String hql = "FROM Usuario u WHERE u.login = :login AND u.senha = :senha";
            Query<Usuario> query = HibernateUtil.getSessionFactory().openSession().createQuery(hql, Usuario.class);
            query.setParameter("email", Lemail.getText());
            query.setParameter("senha", Lsenha.getText());

            List<Usuario> usuarios = query.getResultList();

            if (!usuarios.isEmpty()) {

                Application.mudartela("principal");
            } else {
                System.out.println("usuário não está registrado no banco.");
                exibirErro(3);
            }
        }
    }


    public void exibirErro(int i) {
        if (i == 0)
            mensagem.setText("Campos  vazios");

        else if (i == 1)
            mensagem.setText("Campo nome vazio");

        else if (i == 2)
            mensagem.setText("Campo Senha vazio");
        else
            mensagem.setText("inválido!!");
    }

    /*protected Boolean verificacaoSenha(){
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
            //Application.mudartela("principal");

        session.getTransaction().commit();
        } catch(Exception e) {
            if(session.getTransaction() != null)
                session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return true;
    }*/

    protected void limpar(){
        Lemail.setText("");
        Lsenha.setText("");
    }

    public void cadastrar() {
        Application.mudartela("cadastro");
    }

}