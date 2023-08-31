package entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Turma")
@Table(name = "Turma")

public class Turma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String codigo;
    @Column
    private Integer horario;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "professor_id")
    private String professor;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "turma-aluno", joinColumns = @JoinColumn(name = "turma_id"), inverseJoinColumns = @JoinColumn(name = "aluno_id"))
    private static List<Aluno> alunos = new ArrayList<>();

    public Turma(String codigo, Integer horario, String professor) {
        this.codigo = codigo;
        this.horario = horario;
        this.professor = professor;
    }

    public static List<Aluno> getAlunos() {
        return alunos;
    }

    public static void setAlunos(List<Aluno> alunos) {
        Turma.alunos = alunos;
    }

    @Override
    public String toString() {
        return "Turma{" +
                "id=" + id +
                ", codigo='" + codigo + '\'' +
                ", horario=" + horario +
                ", professor='" + professor + '\'' +
                '}';
    }
}
