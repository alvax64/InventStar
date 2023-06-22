/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lp2.cdejava.inventstar.inventario.dao;

import java.util.ArrayList;
import lp2.cdejava.inventstar.inventario.model.UtensiliosDeServicio;

/**
 *
 * @author Arian
 */
public interface UtensiliosDeServicioDAO {
    public int insertar(UtensiliosDeServicio utensiliosDeServicio);
    public int modificar(UtensiliosDeServicio utensiliosDeServicio);
    public int eliminar(int idUtensiliosDeServicio);
    public ArrayList<UtensiliosDeServicio> listarTodosUtensiliosDeServicios();
}
