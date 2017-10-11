package com.alura.javajpa.test;

import com.alura.javajpa.model.Conta;
import com.alura.javajpa.model.TipoMovimentacao;
import com.alura.javajpa.utils.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.math.BigDecimal;

/**
 * Created by MarcosNami on 10/11/2017.
 */
public class TestFunctionCount {

    public static void main(String[] args) {

        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        Conta conta = new Conta();
        conta.setId(2);

        String jpql = "select count(m) from Movimentacao m where m.conta = :pConta";

        Query query = em.createQuery(jpql);
        query.setParameter("pConta", conta);

        Long count = (Long) query.getSingleResult();

        System.out.println("Total de movimentações: " + count);

        em.getTransaction().commit();
        em.close();

    }
}
