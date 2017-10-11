package com.alura.javajpa.test;

import com.alura.javajpa.model.Conta;
import com.alura.javajpa.model.TipoMovimentacao;
import com.alura.javajpa.utils.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by MarcosNami on 10/10/2017.
 */
public class TestFunctionAvg {

    public static void main(String[] args) {

        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        Conta conta = new Conta();
        conta.setId(2);

        String jpql = "select avg(m.valor) from Movimentacao m where m.conta = :pConta" +
                " and m.tipo = :pTipo" +
                " group by date_trunc('day', m.data)";

        TypedQuery<Double> query = em.createQuery(jpql, Double.class);
        query.setParameter("pConta", conta);
        query.setParameter("pTipo", TipoMovimentacao.SAIDA);

        List<Double> medias = query.getResultList();

        for (Double media : medias) {
            System.out.println("A media e: " + media);
        }

        em.getTransaction().commit();
        em.close();

    }
}
