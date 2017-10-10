package com.alura.javajpa.test;

import com.alura.javajpa.model.Conta;
import com.alura.javajpa.utils.JPAUtil;

import javax.persistence.EntityManager;

/**
 * Created by MarcosNami on 10/10/2017.
 */
public class TestRemove {

    public static void main(String[] args) {


        Conta conta = new Conta();
        conta.setId(1);
        // outros setters

        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        conta = em.find(Conta.class, 1);
        System.out.println(conta);
        em.remove(conta);
        System.out.println(conta);

        em.getTransaction().commit();
        em.close();


    }
}
