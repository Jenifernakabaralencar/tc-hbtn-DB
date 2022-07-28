package entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "curso")
public class Curso {
    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private String sigla;
    @OneToOne(cascade = CascadeType.ALL)
    private MaterialCurso materialCurso;
    @ManyToMany
    @JoinTable(name="curso_aluno",
            joinColumns={@JoinColumn(name="curso_id")},
            inverseJoinColumns={@JoinColumn(name="aluno_id")})
    private List<Aluno> alunos;
    @OneToOne(cascade = CascadeType.ALL)
    private Professor professor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public MaterialCurso getMaterialCurso() {
        return materialCurso;
    }

    public void setMaterialCurso(MaterialCurso materialCurso) {
        this.materialCurso = materialCurso;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
}
