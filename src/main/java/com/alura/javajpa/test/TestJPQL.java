package com.alura.javajpa.test;

import com.alura.javajpa.dao.MovimentacaoDao;
import com.alura.javajpa.model.Conta;
import com.alura.javajpa.model.Movimentacao;
import com.alura.javajpa.model.TipoMovimentacao;
import com.alura.javajpa.utils.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by MarcosNami on 10/10/2017.
 */
public class TestJPQL {

    public static void main(String[] args) {

        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        Conta conta = new Conta();
        conta.setId(2);

        MovimentacaoDao dao = new MovimentacaoDao(em);
        List<Movimentacao> movimentacoes = dao.getMovimentacaoPorTipo(TipoMovimentacao.SAIDA, conta);

        for (Movimentacao movimentacao : movimentacoes) {
            System.out.println("Descricao: " + movimentacao.getDescricao());
            System.out.println("Conta.id: " + movimentacao.getConta().getId());
        }

        em.getTransaction().commit();
        em.close();

    }
}
