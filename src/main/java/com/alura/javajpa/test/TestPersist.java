package com.alura.javajpa.test;

import com.alura.javajpa.model.Conta;
import com.alura.javajpa.utils.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by MarcosNami on 10/9/2017.
 */
public class TestPersist {

    public static void main(String[] args) {

        Conta conta = new Conta();
        conta.setTitular("Marcos");
        conta.setBanco("Banco Inter");
        conta.setAgencia("0001");
        conta.setNumero("123456-7");

        EntityManager em = new JPAUtil().getEntityManager();

        em.getTransaction().begin();
        em.persist(conta);
        em.getTransaction().commit();

        em.close();


    }
}
