/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.tarea.daos;

/**
 *
 * @author Alumno
 */
public interface GenericDAO<T,PK> {

    // T - ENTIDAD
    // PK - PRIMARY KEY    
     
    //IMPLEMENTAMOS LOS METODOS CRUD
    public T buscarPorId(PK id);
    
    public T guardar(T a);
    
    public void remover(T a);
}
