/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import casos.acad.acceso.TipoRequisitoFacadeLocal;
import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import java.util.List;
import javax.ejb.EJB;
import casos.acad.casosacaddatalibmvn.TipoRequisito;

/**
 *
 * @author omar
 */
@Named(value = "tipoRequisitoController")
@ViewScoped
public class TipoRequisitoController extends AbstractController<TipoRequisito> implements Serializable {

    @EJB
    private TipoRequisitoFacadeLocal tipoRequisitoFacade;


    public TipoRequisitoController() {
    }

    public List<TipoRequisito> findAll() {
        return this.tipoRequisitoFacade.findAll();
    }

    public void agregar() {
        this.tipoRequisitoFacade.crear(this.tipo);
        this.tipo = new TipoRequisito();
        this.editando = false;
    }

    public String borrar() {
        if(this.tipo.getIdTipoRequisito()!=null){
        this.tipoRequisitoFacade.remover(this.tipo);
        this.tipo = new TipoRequisito();
        }else{
            System.out.println("no se puede eliminar si no hay seleccionado");
        }
        this.editando = false;
        return "borrar";
        
    }

   

    public String editar() {
        if (this.tipo.getIdTipoRequisito() != null) {
            this.tipoRequisitoFacade.editar(this.tipo);
            this.tipo = new TipoRequisito();
        } else {
            System.out.println("no se puede eliminar si no hay seleccionado");
        }
        this.editando = false;
        return "index";
    }
    
}
