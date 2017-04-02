/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
<<<<<<< HEAD
 * nuevo agregado para esto del maven y git hook
 * prueba ddos del hook :P
 * prueba 3
=======
 * ni modo
 * :P
>>>>>>> create
 * esto es la prueba definitiva
 * Al parecer esto no esta funcinando
 */
package controller;

import java.io.Serializable;

/**
 *
 * @author omar
 * @param <T>
 */
public abstract class AbstractController<T> implements Serializable{

 boolean editando = false;
 public T tipo;

    public T getTipo() {
        return tipo;
    }

    public void setTipo(T tipo) {
        this.tipo = tipo;
    }
 
    
 
    public boolean isEditando() {
        return editando;
    }

    public void setEditando(boolean editando) {
        this.editando = editando;   
    
    }
    
    public void limpiar() {
        this.tipo = null;
        this.editando = false;
    }
    
    public void seleccionar(T tr) {
        this.tipo=tr;
        this.editando = true;
    }
}
