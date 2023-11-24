package controles;
import GerenciadorDeTarefas.projeto.Application;
import modelos.Usuario;
import sessoes.UsuarioSessao;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;

public class CadastroController {

    @FXML
    public Button novoUsuario;

    @FXML
    public TextField Cnome;

    @FXML
    public TextField Cemail;

    @FXML
    public TextField Csenha;

    @FXML
    public TextField senhaConf;

    @FXML
    public Label mensagem;

    UsuarioSessao usuarioSessao = new UsuarioSessao();

    /*if(Cnome.isEmpty() || Cnome.isEmpty(0 || Csenha.isEmpty())){
        exibirErro("Usuário já existe. Entre com outro nome e usuário");
    } else {
        usuarioService.salvarUsuario(novoUsuario);
        GerenciadorApplication.mudarTela("login");
    }

    public void novoUsuario() {
        boolean senhaIgual  = senhaConf.getText().equals(Csenha.getText());

        if(!senhaIgual) {
            return;
        }

        String senhaBdd = Csenha.getText();
        String usuarioBdd = Cnome.getText();
        String emailbdd = Cemail.getText();

        Usuario usuarioA = new Usuario(usuarioBdd,emailbdd, senhaBdd);

        System.out.println("Cadastrado!");
    }*/

    public void fazerLogin(ActionEvent event) {

        String nome = Cnome.getText();
        String email = Cemail.getText();
        String senha = Csenha.getText();

        if(nome.isEmpty() && email.isEmpty() && senha.isEmpty())
            exibirErro(0);

        else  if(nome.isEmpty())
            exibirErro(1);

        else if(email.isEmpty())
            exibirErro(2);

        else if(senha.isEmpty())
            exibirErro(3);

        else {
            Usuario u = new Usuario(nome, email, senha);
            usuarioSessao.salvarUsuario(u);
            Application.mudartela("login");
        }
    }

    public void retornar(ActionEvent event) {
        Application.mudartela("login");
    }

    public void exibirErro(int i) {
        if(i==0)
            mensagem.setText("Campos vazios");

        else if(i==1)
            mensagem.setText("Campo nome está vazio");

        else if(i==2)
            mensagem.setText("Campo usuário está vazio");

        else if(i==3)
            mensagem.setText("Campo Senha está vazio");

    }

}


