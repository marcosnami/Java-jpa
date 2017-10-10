package com.alura.javajpa.test;

import com.alura.javajpa.model.Conta;
import com.alura.javajpa.model.Movimentacao;
import com.alura.javajpa.model.TipoMovimentacao;
import com.alura.javajpa.utils.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Calendar;

/**
 * Created by marcos.nami on 10/10/2017.
 */
public class TestRelation {

    public static void main(String[] args) {

        Conta conta = new Conta();
        conta.setTitular("Ana Paula");
        conta.setBanco("Banco Intermedium");
        conta.setAgencia("0002");
        conta.setNumero("01234-7");

        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setData(Calendar.getInstance());
        movimentacao.setDescricao("Churrascaria");
        movimentacao.setTipo(TipoMovimentacao.SAIDA);
        movimentacao.setValor(new BigDecimal("200.00"));

        movimentacao.setConta(conta);

        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        em.persist(conta);
        em.persist(movimentacao);

        em.getTransaction().commit();
        em.close();

    }
}
