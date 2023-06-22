package lp2.cdejava.inventstar.clientes.dao;

import java.util.ArrayList;
import lp2.cdejava.inventstar.clientes.model.TarjetaInventstar;

/**
 *
 * @author Usuario
 */
public interface TarjetaInventstarDAO {
    public int insertar(TarjetaInventstar tarjeta);
    public int modificar(TarjetaInventstar tarjeta);
    public int eliminar(int idtarjeta);
    public ArrayList<TarjetaInventstar> listarTodasTarjetas();
}
