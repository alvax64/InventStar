/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lp2.cdejava.inventstar.inventario.dao;

import java.util.ArrayList;
import lp2.cdejava.inventstar.inventario.model.Ingrediente;

/**
 *
 * @author Lenovo
 */
public interface IngredienteDAO{
    public int insertarIngrediente(Ingrediente ingrediente);
    public int modificarIngrediente(Ingrediente ingrediente);
    public int eliminarIngrediente(int idIngrediente);
    public ArrayList<Ingrediente> listarIngrediente();
}
