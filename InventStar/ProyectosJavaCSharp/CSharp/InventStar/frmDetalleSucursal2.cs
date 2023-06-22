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
using static System.Windows.Forms.VisualStyles.VisualStyleElement;

namespace InventStar
{
    public partial class frmDetalleSucursal2 : Form
    {
        private PersonalWSClient _daoSucursal;
        private sucursal _sucursalSeleccionado;

        [DllImport("user32.DLL", EntryPoint = "ReleaseCapture")]
        private extern static void ReleaseCapture();
        [DllImport("user32.DLL", EntryPoint = "SendMessage")]
        private extern static void SendMessage(System.IntPtr hWnd, int wMsg, int wParam, int IParam);

        public frmDetalleSucursal2(sucursal sucursalSeleccionada)
        {
            InitializeComponent();
            _daoSucursal = new PersonalWSClient();
            _sucursalSeleccionado = new sucursal();
            this._sucursalSeleccionado=sucursalSeleccionada;
            txtNombre.Text = _sucursalSeleccionado.nombre;
            txtAforo.Text = _sucursalSeleccionado.aforo.ToString();
            txtDireccion.Text = _sucursalSeleccionado.direccion;
            txtCorreoElectronico.Text = _sucursalSeleccionado.email;
            txtTelefono.Text = _sucursalSeleccionado.telefono;
        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void pictureBox2_Click(object sender, EventArgs e)
        {
            frmSucursal formSuc = new frmSucursal();
            this.Hide();
            formSuc.ShowDialog();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            _sucursalSeleccionado.nombre = txtNombre.Text;
            _sucursalSeleccionado.aforo = int.Parse(txtAforo.Text);
            _sucursalSeleccionado.telefono = txtTelefono.Text;
            _sucursalSeleccionado.email = txtCorreoElectronico.Text;
            _sucursalSeleccionado.direccion = txtDireccion.Text;
            int resultado = _daoSucursal.modificarSucursal(_sucursalSeleccionado);
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

    }
}
