/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.tarea.daos.impl;

//import com.sun.xml.bind.v2.runtime.output.SAXOutput;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import mx.uacm.tarea.daos.PeliculaDAO;
import mx.uacm.tarea.entidades.Pelicula;

public class PeliculaDAOImpl extends GenericDAOImpl<Pelicula, Integer> implements PeliculaDAO {

    public PeliculaDAOImpl(EntityManager em) {
        super(em);
    }
    
    
    @Override
    public List<Pelicula> peliculasPorFecha(Date fechaMin, Date fechaMax) {
       TypedQuery<Pelicula> consulta = em.createQuery("SELECT a FROM Pelicula a WHERE a.fechaEstreno>=?1 AND a.fechaEstreno<=?2",Pelicula.class);
       consulta.setParameter(1,fechaMin);
       consulta.setParameter(2,fechaMax);
       List<Pelicula> peliculas = consulta.getResultList();
       
       return peliculas;
    }

    @Override
    public List<Pelicula> peliculasPorNombre(String nombre) {
        TypedQuery<Pelicula> consulta = em.createQuery("SELECT p FROM Pelicula p WHERE p.titulo LIKE :patron", Pelicula.class);
        consulta.setParameter("patron", "%nunca%");
        List<Pelicula> pelicula = consulta.getResultList();
        System.out.println("peliculas nombre:" + pelicula);
        
        return pelicula;
    }

    @Override
    public List<Pelicula> peliculasSinGenero() {
        TypedQuery<Pelicula> consulta = em.createQuery("SELECT p FROM Pelicula p WHERE p.genero IS EMPTY",Pelicula.class);
        List<Pelicula> peliculaSinGenero = consulta.getResultList();
        System.out.println("Pelisculas sin genero: " + peliculaSinGenero);
        return peliculaSinGenero;
    }

}
