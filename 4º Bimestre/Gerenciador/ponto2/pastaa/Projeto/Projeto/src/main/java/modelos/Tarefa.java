package modelos;

import jakarta.persistence.*;

import java.util.Date;

// A classe abaixo define as tarefas que o usuário quer armazenar no gerenciador.

@Table
@Entity

public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;			// Chave primária
    @Column
    private String nome;		// Indica o nome da tarefa.
    @Column
    private String descricao;		// Indica a descrição da tarefa.
    @Column
    private Date vencimento;		// Indica a data de vencimento da tarefa.
    @Column
    private boolean situacao;		// Indica se a tarefa já foi concluída.
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;


    public Tarefa(String nome, String descricao, Date vencimento, boolean situacao) {
        this.nome = nome;
        this.descricao = descricao;
        this.vencimento = vencimento;
        this.situacao = situacao;
    }

    public Tarefa() {
    }

    public Tarefa(String nome, String descricao, Date vencimento, boolean situacao, Categoria categoria) {
        this.nome = nome;
        this.descricao = descricao;
        this.vencimento = vencimento;
        this.situacao = situacao;
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Tarefa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", vencimento='" + vencimento + '\'' +
                ", situacao=" + situacao +
                ", categoria=" + categoria +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getnome() {
        return nome;
    }

    public void setnome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getvencimento() {
        return vencimento;
    }

    public void setvencimento(Date vencimento) {
        this.vencimento = vencimento;
    }

    public boolean issituacao() {
        return situacao;
    }

    public void setsituacao(boolean situacao) {
        this.situacao = situacao;
    }

    public Categoria getDisciplina() {
        return categoria;
    }

    public void setDisciplina(Categoria categoria) {
        this.categoria = categoria;
    }

}


