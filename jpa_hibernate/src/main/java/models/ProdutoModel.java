package models;

import entities.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ProdutoModel {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
    EntityManager em = emf.createEntityManager();

    public void create(Produto p) {

        try {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            System.out.println("Produto criado com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao criar o produto !!!" + e.getMessage());
        } finally {
            System.out.println("Finalizando a transação");
        }

    }


    public void update(Produto p) {
        try{
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }

    }

    public Produto findById(Produto p) {
        return em.find(Produto.class, p.getId());
    }

    public List<Produto> findAll() {
        return em.createQuery("FROM " + Produto.class.getName()).getResultList();
    }

    public void delete(Produto p) {

        try {
            Produto produto = em.find(Produto.class, p.getId());
            em.getTransaction().begin();
            em.remove(produto);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.close();
            em.getTransaction().rollback();
        }

    }


}


