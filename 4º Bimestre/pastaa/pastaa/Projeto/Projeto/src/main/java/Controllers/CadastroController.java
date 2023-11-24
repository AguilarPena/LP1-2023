package Controllers;
import classes.Usuario;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.fxml.FXML;

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

    /*if(Cnome.isEmpty() || Cnome.isEmpty(0 || Csenha.isEmpty())){
        exibirErro("Usuário já existe. Entre com outro nome e usuário");
    } else {
        usuarioService.salvarUsuario(novoUsuario);
        GerenciadorApplication.mudarTela("Login");
    }*/

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
    }
}


