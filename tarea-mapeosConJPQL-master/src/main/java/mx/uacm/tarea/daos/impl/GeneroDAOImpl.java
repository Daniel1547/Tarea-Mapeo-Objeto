/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.tarea.daos.impl;

import javax.persistence.EntityManager;
import mx.uacm.tarea.daos.GeneroDAO;
import mx.uacm.tarea.entidades.Genero;

public class GeneroDAOImpl extends GenericDAOImpl<Genero, Integer> implements GeneroDAO {

    public GeneroDAOImpl(EntityManager em) {
        super(em);
    }

}
