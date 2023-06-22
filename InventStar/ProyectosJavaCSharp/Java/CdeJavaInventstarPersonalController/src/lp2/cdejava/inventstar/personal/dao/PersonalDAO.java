/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lp2.cdejava.inventstar.personal.dao;

import java.util.ArrayList;
import lp2.cdejava.inventstar.personal.model.Personal;

/**
 *
 * @author Usuario
 */
public interface PersonalDAO {
    public int insertar(Personal personal);
    public int modificar(Personal personal);
    public int eliminar(int idPersonal);
    public ArrayList<Personal> listarPersonal();
    public ArrayList<Personal> listarPersonalesPorNombre_Apellido_DNI(String nombre_Apellido_DNI); 
    public Personal obtenerPorId(int idPersonal);
    public int modificarPermisosCargo(int idPersonal,int fidCargo);
}
