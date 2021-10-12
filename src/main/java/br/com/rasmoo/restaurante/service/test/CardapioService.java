package br.com.rasmoo.restaurante.service.test;

import br.com.rasmoo.restaurante.dao.CardapioDAO;
import br.com.rasmoo.restaurante.util.CargaDeDadosUtil;
import br.com.rasmoo.restaurante.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CardapioService {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManagerRasFood();
        entityManager.getTransaction().begin();
        CargaDeDadosUtil.cadastarCategorias(entityManager);
        CargaDeDadosUtil.cadastrarProdutosCardapio(entityManager);
        CardapioDAO cardapioDao = new CardapioDAO(entityManager);
        System.out.println("Lista de produtos por valor:  "+ cardapioDao.consultarProValor(BigDecimal.valueOf(59.00)));
        System.out.println("O Produto pesquisado foi: " + cardapioDao.consultarPorNome("Moqueca"));

        entityManager.close();
    }


}
