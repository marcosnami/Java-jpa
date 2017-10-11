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
public class TestFunctionMax {

    public static void main(String[] args) {

        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        Conta conta = new Conta();
        conta.setId(2);

        String jpql = "select min(m.valor) from Movimentacao m where m.conta = :pConta" +
                " and m.tipo = :pTipo" +
                " group by m.conta";

        Query query = em.createQuery(jpql);
        query.setParameter("pConta", conta);
        query.setParameter("pTipo", TipoMovimentacao.SAIDA);

        BigDecimal maximo = (BigDecimal) query.getSingleResult();
        //Double media = (Double) query.getSingleResult();

        System.out.println("O maximo e: " + maximo);
        //System.out.println("A media e: " + media);

        em.getTransaction().commit();
        em.close();

    }
}
