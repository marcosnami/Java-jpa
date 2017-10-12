package com.alura.javajpa.dao;

import com.alura.javajpa.model.Conta;
import com.alura.javajpa.model.Movimentacao;
import com.alura.javajpa.model.TipoMovimentacao;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by MarcosNami on 10/11/2017.
 */
public class MovimentacaoDao {

    private EntityManager em;

    public MovimentacaoDao(EntityManager em) {
        this.em = em;
    }

    public List<Movimentacao> getMovimentacaoPorTipo(TipoMovimentacao tipoMovimentacao, Conta conta) {

        String jpql = "select m from Movimentacao m where m.conta = :pConta" +
                " and m.tipo = :pTipo" +
                " order by m.valor desc";

        Query query = em.createQuery(jpql);

        query.setParameter("pConta", conta);
        query.setParameter("pTipo", tipoMovimentacao);

        return query.getResultList();
    }
}
