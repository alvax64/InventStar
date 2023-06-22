/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lp2.cdejava.inventstar.personal.dao;

import java.util.ArrayList;
import lp2.cdejava.inventstar.personal.model.CuentaPersonal;

/**
 *
 * @author Lenovo
 */
public interface CuentaPersonalDAO {
    
    public int insertar(CuentaPersonal cuenta);
    public int modificar(CuentaPersonal cuenta);
    public int eliminar(CuentaPersonal cuenta);
    public ArrayList<CuentaPersonal> listarCuentas();

    public int verificar(CuentaPersonal cuentaPersonal);
    public int verificarPermisos(CuentaPersonal cuentaPersonal);

    
}
