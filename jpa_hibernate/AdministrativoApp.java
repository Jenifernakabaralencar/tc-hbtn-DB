package demo;

import entities.Pessoa;
import entities.Produto;
import models.PessoaModel;
import models.ProdutoModel;

import java.util.List;

public class AdministrativoApp {
    public static void main(String[] args) {
        ProdutoModel produtoModel = new ProdutoModel();

        Produto p1 = new Produto();
        p1.setNome("TV");
        p1.setPreco(300.0);
        p1.setQuantidade(100);
        p1.setStatus(true);

        produtoModel.create(p1);
        List<Produto> produtos = produtoModel.findAll();
        System.out.println("Qtde de produtos encontrados : " + produtos.size());
        Produto p2 = produtoModel.findById(p1);
        System.out.println("O produto encontrado é " + p2.getNome());
        p1.setNome("Monitor");
        produtoModel.update(p1);
        p2 = produtoModel.findById(p1);
        System.out.println("Produto atualizado");
        System.out.println("O produto encontrao é " + p2.getNome());
        produtoModel.delete(p1);

        PessoaModel pessoaModel = new PessoaModel();

        Pessoa pessoa1 = new Pessoa();
        pessoa1.setNome("Ana");
        pessoa1.setEmail("ana@tech.com");
        pessoa1.setDataDeNascimento("31/03/1990");
        pessoa1.setCpf("205.352.025-98");
        pessoa1.setIdade(18);
        pessoaModel.create(pessoa1);
        List<Pessoa> pessoas = pessoaModel.findAll();
        System.out.println("O total de pessoa da lista é: " + pessoas.size());
        Pessoa pessoa2 = pessoaModel.findById(pessoa1);
        System.out.println("A pessoa encontrada é: " + pessoa2.getNome());
        pessoa1.setNome("Antonio");
        pessoaModel.update(pessoa1);
        System.out.println("nome atualizado");
        System.out.println("A pessoa encontrada é: " + pessoa2.getNome());
        pessoaModel.delete(pessoa1);
    }
}
