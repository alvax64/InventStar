/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lp2.cdejava.inventstar.personal.dao;

import java.util.ArrayList;
import lp2.cdejava.inventstar.personal.model.Cargo;

/**
 *
 * @author Usuario
 */
public interface CargoDAO {
    public int insertar(Cargo cargo);
    public int modificar(Cargo cargo);
    public int eliminar(Cargo cargo);
    public ArrayList<Cargo> listarCargos();
    public ArrayList<Cargo> listarCargosPorNombre(String nombre);
}
