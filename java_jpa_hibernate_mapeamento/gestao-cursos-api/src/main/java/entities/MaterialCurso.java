package entities;

import javax.persistence.*;

@Entity
@Table(name = "materialCurso")
public class MaterialCurso {
    @Id
    @GeneratedValue
    private Long id;
    private String url;
    @OneToOne(cascade = CascadeType.ALL)
    private Curso curso;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
