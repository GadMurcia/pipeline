/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import casos.acad.acceso.TipoPasoFacadeLocal;
import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import java.util.List;
import javax.ejb.EJB;
import casos.acad.casosacaddatalibmvn.TipoPaso;

/**
 *
 * @author omar
 */
@Named(value = "tipoPasoController")
@ViewScoped
public class TipoPasoController extends AbstractController<TipoPaso> implements Serializable {

    @EJB
    private TipoPasoFacadeLocal tipoPasoFacade;
    
    

    public TipoPasoController() {
    }

    public List<TipoPaso> findAll() {
        return this.tipoPasoFacade.findAll();
    }


    public void agregar() {
        this.tipoPasoFacade.crear(this.tipo);
        this.tipo = new TipoPaso();
        this.editando = false;
    }

    public String borrar() {
        if (this.tipo.getIdTipoPaso() != null) {
            this.tipoPasoFacade.remover(this.tipo);
            this.tipo = new TipoPaso();
        } else {
            System.out.println("no se puede eliminar si no hay seleccionado");
        }
        this.editando = false;
        return "borrar";

    }


    public String editar() {
        if (this.tipo.getIdTipoPaso() != null) {
            this.tipoPasoFacade.editar(this.tipo);
            this.tipo = new TipoPaso();
        } else {
            System.out.println("no se puede eliminar si no hay seleccionado");
        }
        this.editando = false;
        return "index";
    }

}
