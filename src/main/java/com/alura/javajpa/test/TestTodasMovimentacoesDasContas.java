package com.alura.javajpa.test;

import com.alura.javajpa.model.Conta;
import com.alura.javajpa.utils.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by MarcosNami on 10/10/2017.
 */
public class TestTodasMovimentacoesDasContas {

    public static void main(String[] args) {

        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        String jpql = "select distinct c from Conta c left join fetch c.movimentacoes";
        Query query = em.createQuery(jpql);

        List<Conta> contaList = query.getResultList();
        for (Conta conta : contaList) {
            System.out.println("Titular: " + conta.getTitular());
            System.out.println("Movimentacoes: ");
            System.out.println(conta.getMovimentacoes());
        }

        em.getTransaction().commit();
        em.close();
    }
}
