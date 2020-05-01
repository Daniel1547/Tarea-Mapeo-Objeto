package mx.uacm.tarea.daos;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import mx.uacm.tarea.daos.impl.PeliculaDAOImpl;
import mx.uacm.tarea.entidades.Pelicula;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PeliculaDAOTest {

    private static EntityManager em;

    private static PeliculaDAO peliculaDAO;

    @BeforeAll
    public static void inicializar() {
        System.out.println("inicializando");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("base-pruebas-memoria");
        //Para usar la base de datos "de verdad", comente la linea de arriba y descomente la siguiente linea.
        //EntityManagerFactory emf = Persistence.createEntityManagerFactory("base-pruebas");
        em = emf.createEntityManager();
        peliculaDAO = new PeliculaDAOImpl(em);
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

    
  // -------------------------EJERCICIO 1
    @Test
    @Order(1)
    public void buscarPorId() {
        System.out.println("Peliculas");
        Pelicula d = peliculaDAO.buscarPorId(1);
        Assertions.assertNotNull(d);
        
        Assertions.assertNotNull(d.getGenero());
        Assertions.assertEquals(1, d.getGenero().size());
    }
    
    
    //--------------------------------EJERCICIO 3
    @Test
    @Order(2)
    public void peliculasPorFechaTest(){
        GregorianCalendar calMin= new GregorianCalendar(1979,3,1);
        GregorianCalendar calMax= new GregorianCalendar(2013,8,19);
        Date fechaMin = calMin.getTime();
        Date fechaMax = calMax.getTime();
        List<Pelicula> peliculas = peliculaDAO.peliculasPorFecha(fechaMin, fechaMax);
        System.out.println("Peliculas Fecha: "+ peliculas );
        Assertions.assertEquals(4, peliculas.size());
        
    }
    
    //-------------------------------------------- EJERCICIO 4
    @Test
    @Order(3)
    public void peliculasPorNombreTest(){
        String nombre = "";
        List <Pelicula> peliculas = peliculaDAO.peliculasPorNombre(nombre);
        System.out.println("Peliculas nombre: " + peliculas);
        Assertions.assertEquals(1, peliculas.size());
                
    }
    
    //------------------------------------------- EJERCICIO 5
    @Test
    @Order(4)
    public void peliculasSinGeneroTest(){
        List<Pelicula> peliculas = peliculaDAO.peliculasSinGenero();
        System.out.println("Peliculas sin genero");
        Assertions.assertEquals(2, peliculas.size());
    }

}
