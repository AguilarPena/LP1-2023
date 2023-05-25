import java.util.ArrayList;
import java.util.List;

public class biblioteca {
    private String nome;
    private Dono dono;
    private List<livros> Livros = new ArrayList<>();
    private List<funcionarios> Func = new ArrayList<>();

    public biblioteca(String nome, Dono dono) {
        this.nome = nome;
        this.dono = dono;
    }

    public List<livros> getLivros() {
        return Livros;
    }

    public void setLivros(List<livros> livros) {
        this.Livros = Livros;
    }

    public void addlivros(livros livro){
        Livros.add(livro);
    }

    public List<funcionarios> getFunc() {
        return Func;
    }

    public void setFunc(List<funcionarios> funcionarios) {
        this.Func = Func;
    }

    public void addfuncionarios(funcionarios Funcionario){
        Func.add(Funcionario);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Dono getDono() {
        return dono;
    }

    public void setDono(Dono dono) {
        this.dono = dono;
    }

    public void mostrarLivros(){
        for (int i = 0; i < Livros.size(); i++) {
            System.out.println(Livros.get(i).getNome());
            System.out.println(Livros.get(i).getAutor());
            System.out.println(Livros.get(i).getAno());
        }
    }

    public void mostrarFuncionarios(){
        for (int i = 0; i < Func.size(); i++) {
            System.out.println(Func.get(i).getNome());
            System.out.println(Func.get(i).getCPF());
        }
    }

}
