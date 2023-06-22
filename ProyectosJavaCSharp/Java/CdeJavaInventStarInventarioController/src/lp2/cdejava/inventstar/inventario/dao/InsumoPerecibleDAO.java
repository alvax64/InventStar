/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lp2.cdejava.inventstar.inventario.dao;

import java.util.ArrayList;
import lp2.cdejava.inventstar.inventario.model.InsumoPerecible;

/**
 *
 * @author Lenovo
 */
public interface InsumoPerecibleDAO {
    public int insertar(InsumoPerecible insumoPerecible);
    public  int modificar(InsumoPerecible insumoPerecible);
    public  int eliminar(InsumoPerecible insumoPerecible);
    public  ArrayList<InsumoPerecible> listar();
}
