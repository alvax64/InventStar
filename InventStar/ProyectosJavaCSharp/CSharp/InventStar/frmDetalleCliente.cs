using InventStar.ClientesWS;
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

namespace InventStar
{
    public partial class frmDetalleCliente : Form
    {
        private ClientesWSClient _daoClientes;
        private cliente _cliente;
        private ClientesWSClient _daoTarjeta;
        private tarjetaInventstar _tarjetaInventstar;
        DateTime fechaActual = DateTime.Now;

        [DllImport("user32.DLL", EntryPoint = "ReleaseCapture")]
        private extern static void ReleaseCapture();
        [DllImport("user32.DLL", EntryPoint = "SendMessage")]
        private extern static void SendMessage(System.IntPtr hWnd, int wMsg, int wParam, int IParam);

        public frmDetalleCliente()
        {
            InitializeComponent();
            _daoClientes = new ClientesWSClient();
            _daoTarjeta = new ClientesWSClient();
            _cliente = new cliente();
            _tarjetaInventstar = new tarjetaInventstar();
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
            _cliente.nombres = textBox1.Text;
            _cliente.apellidoPat = textBox2.Text;
            _cliente.apellidoMat = textBox7.Text;
            _cliente.numDocumento = textBox3.Text;
            _cliente.telefono1 = textBox4.Text;
            _cliente.telefono2 = textBox8.Text;
            _cliente.email = textBox9.Text;
            _cliente.fechaCumpleanhos = dateTimePicker2.Value;
            _cliente.fechaCumpleanhosSpecified = true;
            _cliente.fechaRegistro = dateTimePicker1.Value;
            _cliente.fechaRegistroSpecified = true;
            _cliente.domicilio = textBox5.Text;

            int resultado = _daoClientes.insertarCliente(_cliente);
            if (resultado != 0)
            {
                MessageBox.Show("Se ha registrado correctamente",
                    "Mensaje de éxito", MessageBoxButtons.OK,
                    MessageBoxIcon.Information);
            }
            else
            {
                MessageBox.Show("Ha ocurrido un error con el registro",
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
            _tarjetaInventstar.puntosAcumulados = 0;
            _tarjetaInventstar.fechaRegistro = fechaActual;
            int resultado = _daoTarjeta.insertarTarjeta(_tarjetaInventstar);
            if (resultado != 0)
            {
                MessageBox.Show("Se ha registrado correctamente",
                    "Mensaje de éxito", MessageBoxButtons.OK,
                    MessageBoxIcon.Information);
            }
            else
            {
                MessageBox.Show("Ha ocurrido un error con el registro",
                    "Mensaje de éxito", MessageBoxButtons.OK,
                    MessageBoxIcon.Error);
            }
        }
    }
}
