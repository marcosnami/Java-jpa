package com.alura.javajpa.test;

import com.alura.javajpa.model.Cliente;
import com.alura.javajpa.model.Conta;
import com.alura.javajpa.utils.JPAUtil;

import javax.persistence.EntityManager;

/**
 * Created by marcos.nami on 10/10/2017.
 */
public class TestContaCliente {

    public static void main(String[] args) {

        Conta conta = new Conta();
        conta.setId(2);

        Cliente cliente = new Cliente();
        cliente.setNome("Marcos Nami");
        cliente.setProfissao("Engenheiro");
        cliente.setEndereco("Rua Zero, S/N");
        cliente.setConta(conta);


        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        em.persist(cliente);

        em.getTransaction().commit();
        em.close();
    }
}
