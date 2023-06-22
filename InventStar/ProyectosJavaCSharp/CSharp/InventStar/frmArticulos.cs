using InventStar.PersonalWS;
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
    public partial class frmArticulos : Form
    {
        private PersonalWSClient _daoPersonal;
        private articulo _articuloSeleccionado;

        [DllImport("user32.DLL", EntryPoint = "ReleaseCapture")]
        private extern static void ReleaseCapture();
        [DllImport("user32.DLL", EntryPoint = "SendMessage")]
        private extern static void SendMessage(System.IntPtr hWnd, int wMsg, int wParam, int IParam);
        public frmArticulos()
        {
            InitializeComponent();
            _daoPersonal = new PersonalWSClient();
            dataGridView1.AutoGenerateColumns = false;
            dataGridView1.DataSource = _daoPersonal.listarTodosArticulos();
        }

        private void pictureBox2_Click(object sender, EventArgs e)
        {
            frmGuias formGuia = new frmGuias();
            this.Hide();
            formGuia.ShowDialog();
        }

        private void pnlTop_MouseDown(object sender, MouseEventArgs e)
        {
            ReleaseCapture();
            SendMessage(this.Handle, 0xA1, 0x2, 0);
        }

        private void button1_Click(object sender, EventArgs e)
        {
            articulo articulo = (articulo)dataGridView1.CurrentRow.DataBoundItem;
            frmVerArticulo formVerArticulo = new frmVerArticulo(articulo);
            this.Hide();
            formVerArticulo.ShowDialog();
        }

        private void dataGridView1_CellFormatting(object sender, DataGridViewCellFormattingEventArgs e)
        {
            articulo articuloGen = (articulo)dataGridView1.Rows[e.RowIndex].DataBoundItem;

            dataGridView1.Rows[e.RowIndex].Cells[0].Value = articuloGen.titulo;
            dataGridView1.Rows[e.RowIndex].Cells[1].Value = articuloGen.descripcion;
        }
    }
}
