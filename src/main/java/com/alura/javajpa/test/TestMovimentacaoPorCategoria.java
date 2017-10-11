package com.alura.javajpa.test;

import com.alura.javajpa.model.Categoria;
import com.alura.javajpa.model.Conta;
import com.alura.javajpa.model.Movimentacao;
import com.alura.javajpa.model.TipoMovimentacao;
import com.alura.javajpa.utils.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by MarcosNami on 10/10/2017.
 */
public class TestMovimentacaoPorCategoria {

    public static void main(String[] args) {

        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        Categoria categoria = new Categoria();
        categoria.setId(1);

        String jpql = "select m from Movimentacao m join m.categorias c where c = :pCategoria";
        Query query = em.createQuery(jpql);
        query.setParameter("pCategoria", categoria);

        List<Movimentacao> resultList = query.getResultList();

        for (Movimentacao movimentacao : resultList) {
            System.out.println("Descricao: " + movimentacao.getDescricao());
            System.out.println("Conta.id: " + movimentacao.getConta().getId());
        }

        em.getTransaction().commit();
        em.close();

    }
}

