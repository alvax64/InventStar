using InventStar.ClientesWS;
using InventStar.PersonalWS;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Runtime.InteropServices;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

using cliWS = InventStar.ClientesWS;

namespace InventStar
{
    public partial class frmDetalleCliente2 : Form
    {
        private ClientesWSClient _daoClientes;
        private cliWS.cliente _clienteSeleccionado;
        private ClientesWSClient _daoTarjeta;
        private tarjetaInventstar _tarjetaInventstar;
        private PersonalWSClient _daoOrdenVenta;
        private ordenVenta _ordenVentaSeleccionada;
        
        int idCliente = 0, foundCard = 0;
        DateTime fechaActual = DateTime.Now;

        public ordenVenta OrdenVentaSeleccionada { get => _ordenVentaSeleccionada; set => _ordenVentaSeleccionada = value; }

        [DllImport("user32.DLL", EntryPoint = "ReleaseCapture")]
        private extern static void ReleaseCapture();
        [DllImport("user32.DLL", EntryPoint = "SendMessage")]
        private extern static void SendMessage(System.IntPtr hWnd, int wMsg, int wParam, int IParam);

        public frmDetalleCliente2(cliWS.cliente _clienteSeleccionado)
        {
            InitializeComponent();
            _daoClientes = new ClientesWSClient();
            _daoTarjeta = new ClientesWSClient();
            _tarjetaInventstar = new tarjetaInventstar();
            this._clienteSeleccionado = _clienteSeleccionado;
            idCliente = _clienteSeleccionado.idPersona;
            textBox1.Text = _clienteSeleccionado.nombres;
            textBox2.Text = _clienteSeleccionado.apellidoPat;
            textBox7.Text = _clienteSeleccionado.apellidoMat;
            textBox3.Text = _clienteSeleccionado.numDocumento;
            textBox4.Text = _clienteSeleccionado.telefono1;
            textBox8.Text = _clienteSeleccionado.telefono2;
            textBox9.Text = _clienteSeleccionado.email;
            dateTimePicker2.Value = _clienteSeleccionado.fechaCumpleanhos;
            dateTimePicker1.Value = _clienteSeleccionado.fechaRegistro;
            textBox5.Text = _clienteSeleccionado.domicilio;
            tarjetaInventstar[] tarjetas = _daoTarjeta.listarTodasTarjetas();
            _daoOrdenVenta = new PersonalWSClient();
            dgvVentas.AutoGenerateColumns = false;
            dgvVentas.DataSource = _daoOrdenVenta.listarOrdenVentaPorCliente(_clienteSeleccionado.idPersona);

            if (tarjetas != null)
            {
                foreach (tarjetaInventstar t in tarjetas)
                {
                    if (t.cliente.idPersona == _clienteSeleccionado.idPersona)
                    {
                        _tarjetaInventstar = t;
                        button4.Enabled = false;
                        button3.Enabled = true;
                        button2.Enabled = true;
                        textBox6.Text = t.idTarjeta.ToString();
                        foundCard = 1;
                    }

                }
                
            } 
            if(foundCard == 0)
            {
                button3.Enabled = false;
                button2.Enabled = false;
            }
            
            

        }

        

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void pictureBox2_Click(object sender, EventArgs e)
        {
            frmClientes formCli = new frmClientes();
            this.Hide();
            formCli.ShowDialog();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            _clienteSeleccionado.nombres = textBox1.Text;
            _clienteSeleccionado.apellidoPat = textBox2.Text;
            _clienteSeleccionado.apellidoMat = textBox7.Text;
            _clienteSeleccionado.numDocumento = textBox3.Text;
            _clienteSeleccionado.telefono1 = textBox4.Text;
            _clienteSeleccionado.telefono2 = textBox8.Text;
            _clienteSeleccionado.email = textBox9.Text;
            _clienteSeleccionado.fechaCumpleanhos = dateTimePicker2.Value;
            _clienteSeleccionado.fechaCumpleanhosSpecified = true;
            _clienteSeleccionado.fechaRegistro = dateTimePicker1.Value;
            _clienteSeleccionado.fechaRegistroSpecified = true;
            _clienteSeleccionado.domicilio = textBox5.Text;

            int resultado = _daoClientes.modificarCliente(_clienteSeleccionado);
            if (resultado != 0)
            {
                MessageBox.Show("Se ha modificado correctamente",
                    "Mensaje de éxito", MessageBoxButtons.OK,
                    MessageBoxIcon.Information);
            }
            else
            {
                MessageBox.Show("Ha ocurrido un error con la modificación",
                    "Mensaje de éxito", MessageBoxButtons.OK,
                    MessageBoxIcon.Error);
            }
        }

        private void pnlTop_MouseDown(object sender, MouseEventArgs e)
        {
            ReleaseCapture();
            SendMessage(this.Handle, 0xA1, 0x2, 0);
        }

        private void button2_Click(object sender, EventArgs e)
        {
            
            frmTarjetas formTar = new frmTarjetas(_tarjetaInventstar);
            this.Hide();
            formTar.ShowDialog();
        }

        private void label8_Click(object sender, EventArgs e)
        {

        }

        private void panel1_Paint(object sender, PaintEventArgs e)
        {

        }

        private void button4_Click(object sender, EventArgs e)
        {
            
            _tarjetaInventstar.puntosAcumulados = 0;
            _tarjetaInventstar.fechaRegistro = fechaActual;
            _tarjetaInventstar.fechaRegistroSpecified = true;
            _tarjetaInventstar.cliente = _clienteSeleccionado;
            int resultado = _daoTarjeta.insertarTarjeta(_tarjetaInventstar);
            if (resultado != 0)
            {
                MessageBox.Show("Se ha registrado correctamente",
                    "Mensaje de éxito", MessageBoxButtons.OK,
                    MessageBoxIcon.Information);
                _tarjetaInventstar.idTarjeta = resultado;
                textBox6.Text = resultado.ToString();
                button3.Enabled = true;
                button2.Enabled = true;
                button4.Enabled = false;

            }
            else
            {
                MessageBox.Show("Ha ocurrido un error con el registro",
                    "Mensaje de éxito", MessageBoxButtons.OK,
                    MessageBoxIcon.Error);
            }
        }

        private void dgvVentas_CellFormatting(object sender, DataGridViewCellFormattingEventArgs e)
        {
            
            ordenVenta ordenGenerica = (ordenVenta)dgvVentas.Rows[e.RowIndex].DataBoundItem;
            if(ordenGenerica == null)
            {
                return;
            }
            dgvVentas.Rows[e.RowIndex].Cells["fecha"].Value = ordenGenerica.fecha;
            dgvVentas.Rows[e.RowIndex].Cells["total"].Value = ordenGenerica.total;
            dgvVentas.Rows[e.RowIndex].Cells["estado"].Value = ordenGenerica.estado;
            dgvVentas.Rows[e.RowIndex].Cells["horaVenta"].Value = ordenGenerica.horaVenta.ToString();
            dgvVentas.Rows[e.RowIndex].Cells["horaFinPedido"].Value = ordenGenerica.horaFinPedido.ToString();
            dgvVentas.Rows[e.RowIndex].Cells["tipo"].Value = ordenGenerica.tipo;


        }

        private void dgvVentas_CellDoubleClick(object sender, DataGridViewCellEventArgs e)
        {
            OrdenVentaSeleccionada = (ordenVenta)dgvVentas.CurrentRow.DataBoundItem;
            //frmDetalleVenta formDetalleVenta = new frmDetalleVenta(_ordenVentaSeleccionada);
            //this.Hide();
            //formDet.ShowDialog();
            
        }

        private void button3_Click(object sender, EventArgs e)
        {
            
            int _codigoEliminar = _tarjetaInventstar.idTarjeta;
            int resultado = _daoTarjeta.eliminarTarjeta(_codigoEliminar);
            if (resultado != 0)
            {
                MessageBox.Show("Se ha eliminado la tarjeta",
                    "Mensaje de éxito", MessageBoxButtons.OK,
                    MessageBoxIcon.Information);
                    textBox6.Text = " ";
                    button3.Enabled = false;
                    button2.Enabled = false;
                    button4.Enabled = true;
            }
            else
            {
                MessageBox.Show("Ha ocurrido un error con la eliminación",
                    "Mensaje de éxito", MessageBoxButtons.OK,
                    MessageBoxIcon.Error);
            }

        }
    }
}
