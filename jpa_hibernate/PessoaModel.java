package models;

import entities.Pessoa;
;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.List;

public class PessoaModel {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
    EntityManager em = emf.createEntityManager();

    public void create(Pessoa p) {

        try {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            System.out.println("Pessoa criado com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao criar o pessoa !!!" + e.getMessage());
        } finally {
            System.out.println("Finalizando a transação");
        }

    }


    public void update(Pessoa p) {
        try {
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }

    }

    public Pessoa findById(Pessoa p) {
        return em.find(Pessoa.class, p.getId());
    }

    public List<Pessoa> findAll() {
        return em.createQuery("FROM " + Pessoa.class.getName()).getResultList();
    }

    public void delete(Pessoa p) {

        try {
            Pessoa pessoa = em.find(Pessoa.class, p.getId());
            em.getTransaction().begin();
            em.remove(pessoa);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.close();
            em.getTransaction().rollback();
        }
    }
}
