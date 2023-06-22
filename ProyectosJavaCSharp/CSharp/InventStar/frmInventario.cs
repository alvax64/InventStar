using InventStar;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Runtime.InteropServices;

namespace InventstarInventario
{
    public partial class frmInventario : Form
    {
        [DllImport("user32.DLL", EntryPoint = "ReleaseCapture")]
        private extern static void ReleaseCapture();
        [DllImport("user32.DLL", EntryPoint = "SendMessage")]
        private extern static void SendMessage(System.IntPtr hWnd, int wMsg, int wParam, int IParam);
        public frmInventario()
        {
            InitializeComponent();
        }

        private void pnlTop_MouseDown(object sender, MouseEventArgs e)
        {
            ReleaseCapture();
            SendMessage(this.Handle, 0xA1, 0x2, 0);
        }

        private void frmInventario_Load(object sender, EventArgs e)
        {

        }

        private void frmInventario_Paint(object sender, PaintEventArgs e)
        {

        }

        private void panel1_Paint(object sender, PaintEventArgs e)
        {

        }

        private void pictureBox1_Click(object sender, EventArgs e)
        {

        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void pictureBox2_Click(object sender, EventArgs e)
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

        private void dataGridView1_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }

        private void button2_Click(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {

        }

        private void button4_Click(object sender, EventArgs e)
        {
            frmNuevoArticulo formArt = new frmNuevoArticulo();
            if (formArt.ShowDialog() == DialogResult.OK)
            {
                dataGridView1.Rows.Add(1,formArt.getName(), formArt.getStock(), formArt.getUnit(), DateTime.Now);
            }

            //this.Hide();
            //formArt.ShowDialog();
        }

        private void button1_Click_1(object sender, EventArgs e)
        {
            frmInventarioActualizar formActu = new frmInventarioActualizar();
            this.Hide();
            formActu.ShowDialog();
        }

        private void button5_Click(object sender, EventArgs e)
        {
            dataGridView1.Rows.RemoveAt(dataGridView1.CurrentRow.Index);
        }
    }
}
