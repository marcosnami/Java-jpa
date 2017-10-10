package com.alura.javajpa.test;

import com.alura.javajpa.model.Conta;
import com.alura.javajpa.utils.JPAUtil;

import javax.persistence.EntityManager;

/**
 * Created by MarcosNami on 10/10/2017.
 */
public class TestFind {

    public static void main(String[] args) {

        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        Conta conta = em.find(Conta.class, 1);
        conta.setTitular("Marcos Nami");
        conta.setBanco("077 - BANCO INTER");
        conta.setNumero("12345-6");
        System.out.println(conta);

        em.getTransaction().commit();
        em.close();

        EntityManager em2 = new JPAUtil().getEntityManager();
        em2.getTransaction().begin();

        conta.setTitular("Leonardo Di Caprio");
        em2.merge(conta);
        System.out.println(conta);
        em2.getTransaction().commit();
        em2.close();

    }
}
