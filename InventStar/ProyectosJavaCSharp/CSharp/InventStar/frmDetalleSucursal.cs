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

namespace InventStar
{
    public partial class frmDetalleSucursal : Form
    {
        private PersonalWSClient _daoSucursal;
        private sucursal _sucursal;

        [DllImport("user32.DLL", EntryPoint = "ReleaseCapture")]
        private extern static void ReleaseCapture();
        [DllImport("user32.DLL", EntryPoint = "SendMessage")]
        private extern static void SendMessage(System.IntPtr hWnd, int wMsg, int wParam, int IParam);

        public frmDetalleSucursal()
        {
            InitializeComponent();
            _daoSucursal = new PersonalWSClient();
            _sucursal = new sucursal();
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
            _sucursal.nombre = txtNombre.Text;
            _sucursal.aforo = int.Parse(txtAforo.Text);
            _sucursal.telefono = txtTelefono.Text;
            _sucursal.email = txtCorreoElectronico.Text;
            _sucursal.direccion = txtDireccion.Text;
            _sucursal.matriz=new matriz();
            int fidMatriz = _daoSucursal.listarMatriz();
            _sucursal.matriz.id_matriz= fidMatriz;
            int resultado = _daoSucursal.insertarSucursal(_sucursal);
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

    }
}
