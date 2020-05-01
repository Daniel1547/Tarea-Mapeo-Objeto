package mx.uacm.tarea.daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import mx.uacm.tarea.daos.impl.GeneroDAOImpl;
import mx.uacm.tarea.entidades.Genero;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GeneroDAOTest {

    private static EntityManager em;

    private static GeneroDAO generoDAO;

    @BeforeAll
    public static void inicializar() {
        System.out.println("inicializando");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("base-pruebas-memoria");        
        //Para usar la base de datos "de verdad", comente la linea de arriba y descomente la siguiente linea.
        //EntityManagerFactory emf = Persistence.createEntityManagerFactory("base-pruebas");
        em = emf.createEntityManager();
        generoDAO = new GeneroDAOImpl(em);
    }

    @AfterAll
    public static void terminar() {
        System.out.println("terminando");
    }

    @BeforeEach
    public void antesDeCadaTest() {
        System.out.println("antes del test");
        em.getTransaction().begin(); //iniciamos transaccion
    }

    @AfterEach
    public void despuesDeCadaTest() {
        System.out.println("despues del test");
        em.flush();
        em.getTransaction().rollback();
    }

  //-------------------------------EJERCICIO 2
    @Test
    public void buscarPorId() {
        System.out.println("GENEROS");
        Genero d = generoDAO.buscarPorId(1);
        Assertions.assertNotNull(d);
        
        Assertions.assertNotNull(d.getPelicula());
        Assertions.assertEquals(1,d.getPelicula().size());
        
    }

}
