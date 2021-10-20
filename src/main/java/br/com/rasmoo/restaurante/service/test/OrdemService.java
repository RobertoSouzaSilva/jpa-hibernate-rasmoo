package br.com.rasmoo.restaurante.service.test;

import br.com.rasmoo.restaurante.dao.CardapioDAO;
import br.com.rasmoo.restaurante.dao.ClienteDAO;
import br.com.rasmoo.restaurante.dao.EnderecoDAO;
import br.com.rasmoo.restaurante.dao.OrdemDAO;
import br.com.rasmoo.restaurante.entity.*;
import br.com.rasmoo.restaurante.util.CargaDeDadosUtil;
import br.com.rasmoo.restaurante.util.JPAUtil;

import javax.persistence.EntityManager;

public class OrdemService {

    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManagerRasFood();
        entityManager.getTransaction().begin();
        CargaDeDadosUtil.cadastarCategorias(entityManager);
        CargaDeDadosUtil.cadastrarProdutosCardapio(entityManager);
        CargaDeDadosUtil.cadastrarClientes(entityManager);
        CargaDeDadosUtil.cadastrarOrdensClientes(entityManager);
        EnderecoDAO enderecoDao = new EnderecoDAO(entityManager);
        System.out.println(enderecoDao.consultarClientes(null,null,"lapa"));
        System.out.println(enderecoDao.consultarClientesUsandoCriteria(null,null,"lapa"));

        ClienteDAO clienteDao = new ClienteDAO(entityManager);
        System.out.println(clienteDao.consultar(new ClienteId("tayane@email.com","111111111123")));
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
