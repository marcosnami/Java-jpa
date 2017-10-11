package com.alura.javajpa.test;

import com.alura.javajpa.model.Conta;
import com.alura.javajpa.model.Movimentacao;
import com.alura.javajpa.utils.JPAUtil;

import javax.persistence.EntityManager;

/**
 * Created by MarcosNami on 10/10/2017.
 */
public class TestMovimentacaoConta {

    public static void main(String[] args) {

        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        Movimentacao movimentacao = em.find(Movimentacao.class, 3);
        Conta conta = movimentacao.getConta();
        System.out.println(conta);
        System.out.println(conta.getMovimentacoes().size());

        em.getTransaction().commit();
        em.close();
    }
}
