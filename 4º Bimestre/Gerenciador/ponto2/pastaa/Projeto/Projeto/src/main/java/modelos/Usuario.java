package modelos;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

// A classe abaixo armazena todos os dados e informações referentes ao usuário.

@Table
@Entity

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //gera numero em sequencia
    private int id;		// Chave primária
    @Column
    private String nome;	// Indica o nome do usuário.
    @Column
    private String email;	// Indica email utilizado para conexão do usuário.
    @Column
    private String senha;	// Indica a senha que de entrada do usuário.
    @OneToMany(cascade = CascadeType.ALL)
    private List<Tarefa> tarefas = new ArrayList<>();		// Define uma lista das tarefas. criadas pelo usuário.

    public Usuario(){
    }

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", senha='" + senha + '\'' +
                ", tarefas=" + tarefas +
                '}';
    }

    public void addTarefa(Tarefa tarefa){
        tarefas.add(tarefa);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public void setTarefas(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }



}
