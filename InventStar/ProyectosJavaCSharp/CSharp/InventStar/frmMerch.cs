using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Runtime.InteropServices;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace InventStar
{
    public partial class frmMerch : Form
    {
        [DllImport("user32.DLL", EntryPoint = "ReleaseCapture")]
        private extern static void ReleaseCapture();
        [DllImport("user32.DLL", EntryPoint = "SendMessage")]
        private extern static void SendMessage(System.IntPtr hWnd, int wMsg, int wParam, int IParam);
        public frmMerch()
        {
            InitializeComponent();
        }

        private void panelTop_MouseDown(object sender, MouseEventArgs e)
        {
            ReleaseCapture();
            SendMessage(this.Handle, 0xA1, 0x2, 0);
        }

        private void picBack_Click(object sender, EventArgs e)
        {
            frmPaginaPrincipal formHome = new frmPaginaPrincipal();
            this.Hide();
            formHome.LblVentas.Cursor = System.Windows.Forms.Cursors.Hand;
            formHome.LblClientes.Cursor = System.Windows.Forms.Cursors.Hand;
            formHome.LblInventario.Cursor = System.Windows.Forms.Cursors.Hand;
            formHome.LblGuias.Cursor = System.Windows.Forms.Cursors.Hand;
            formHome.PbVentas.Cursor = System.Windows.Forms.Cursors.Hand;
            formHome.PbClientes.Cursor = System.Windows.Forms.Cursors.Hand;
            formHome.PbInventario.Cursor = System.Windows.Forms.Cursors.Hand;
            formHome.PbGuias.Cursor = System.Windows.Forms.Cursors.Hand;
            formHome.LblUsuarioActual.Visible = true;
            formHome.LblInicioSesion.Visible = false;
            formHome.PbVentasEnabled.Visible = true;
            formHome.PbClientesEnabled.Visible = true;
            formHome.PbInventarioEnabled.Visible = true;
            formHome.PbGuiasEnabled.Visible = true;
            formHome.Show();
        }

        private void pictureBox2_Click(object sender, EventArgs e)
        {
            frmBebidas formBebidas = new frmBebidas();
            this.Hide();
            formBebidas.ShowDialog();
        }

        private void pictureBox4_Click(object sender, EventArgs e)
        {
            frmAlimentos formAlim = new frmAlimentos();
            this.Hide();
            formAlim.ShowDialog();
        }

        private void pictureBox5_Click(object sender, EventArgs e)
        {
            frmPacksYBoxes formPyB = new frmPacksYBoxes();
            this.Hide();
            formPyB.ShowDialog();
        }
    }
}
