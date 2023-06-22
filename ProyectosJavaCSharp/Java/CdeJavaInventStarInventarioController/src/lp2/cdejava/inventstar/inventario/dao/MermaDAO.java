/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lp2.cdejava.inventstar.inventario.dao;

import java.util.ArrayList;
import lp2.cdejava.inventstar.inventario.model.Merma;

/**
 *
 * @author Lenovo
 */
public interface MermaDAO {
    public  int insertarMerma(Merma merma);
    public  int modificarMerma(Merma merma);
    public  int eliminarMerma(int idMerma);
    public  ArrayList<Merma> listarMerma();
}
