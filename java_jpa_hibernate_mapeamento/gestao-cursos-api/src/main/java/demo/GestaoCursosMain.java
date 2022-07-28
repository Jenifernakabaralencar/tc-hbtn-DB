package demo;

import entities.*;
import models.AlunoModel;
import models.CursoModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GestaoCursosMain {
    public static void main(String[] args) {
        Endereco endereco = new Endereco();
        endereco.setLogradouro("Rua");
        endereco.setEndereco("lagoa santa");
        endereco.setNumero("145");
        endereco.setBairro("Centro");
        endereco.setCidade("Poa");
        endereco.setEstado("SP");
        endereco.setCep("06585-245");

        Telefone telefone = new Telefone();
        telefone.setDDD("11");
        telefone.setNumero("1234-5857");

        MaterialCurso materialCurso = new MaterialCurso();
        materialCurso.setUrl("www.curso.com");


        Professor professor = new Professor();
        professor.setNomeCompleto("Antonio Alves");
        professor.setEmail("antonio.alves@curso.com");
        professor.setMatricula("5242");

        List<Endereco> listaDeEndereco = new ArrayList<>();
        listaDeEndereco.add(endereco);

        List<Telefone> listaDeTelefone = new ArrayList<>();
        listaDeTelefone.add(telefone);

        Aluno aluno = new Aluno();
        aluno.setNomeCompleto("Ana Laura");
        aluno.setEmail("anqa.laura@curso.com");
        aluno.setNascimento(new Date("31/03/1999"));
        aluno.setMatricula("524865");
        aluno.setEndereco(listaDeEndereco);
        aluno.setTelefone(listaDeTelefone);

        List<Aluno> listaDeAlunos = new ArrayList<>();
        listaDeAlunos.add(aluno);

        Curso curso = new Curso();
        curso.setNome("Historia");
        curso.setSigla("HIST");
        curso.setProfessor(professor);
        curso.setAlunos(listaDeAlunos);
        curso.setMaterialCurso(materialCurso);

        AlunoModel alunoModel = new AlunoModel();
        alunoModel.create(aluno);
        Aluno a2 = alunoModel.findById(1l);
        alunoModel.findAll();
        aluno.setEmail("ana.laura@curso.com");
        alunoModel.update(aluno);
        System.out.println("Aluno atualizado com sucesso " +aluno.getEmail());
        alunoModel.delete(aluno);

        CursoModel cursoModel = new CursoModel();
        cursoModel.create(curso);
        Curso c2 = cursoModel.findById(1l);
        cursoModel.findAll();
        curso.setNome("Geografia");
        cursoModel.update(curso);
        System.out.println("Curso alterado com sucesso " + curso.getNome());
        cursoModel.delete(curso);

    }
}
