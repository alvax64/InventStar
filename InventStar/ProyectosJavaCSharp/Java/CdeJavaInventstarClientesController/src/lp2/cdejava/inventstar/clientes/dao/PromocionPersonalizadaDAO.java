/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lp2.cdejava.inventstar.clientes.dao;

import java.util.ArrayList;
import lp2.cdejava.inventstar.clientes.model.PromocionPersonalizada;


/**
 *
 * @author Usuario
 */
public interface PromocionPersonalizadaDAO {
    public int insertar(PromocionPersonalizada promocion);
    public int modificar(PromocionPersonalizada promocion);
    public int eliminar(int idpromocion);
    public ArrayList<PromocionPersonalizada> listarTodasPromocionPersonalizadaPorTarjeta(int id_tarjeta);    
}
