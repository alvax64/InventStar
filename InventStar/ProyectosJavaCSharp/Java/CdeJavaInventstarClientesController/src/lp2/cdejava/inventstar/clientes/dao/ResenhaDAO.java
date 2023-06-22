/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lp2.cdejava.inventstar.clientes.dao;

import java.util.ArrayList;
import lp2.cdejava.inventstar.clientes.model.Reseña;


/**
 *
 * @author Usuario
 */
public interface ResenhaDAO {
    public int insertar(Reseña resenha);
    public int modificar(Reseña resenha);
    public int eliminar(int idresenha);
    public ArrayList<Reseña> listarTodasReseñas();
}
