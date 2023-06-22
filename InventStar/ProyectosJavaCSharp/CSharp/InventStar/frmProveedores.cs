using InventStar.ClientesWS;
using InventStar.InventarioWS;
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

using cliWS = InventStar.ClientesWS;

namespace InventStar
{
    public partial class frmProveedores : Form
    {
        private InventarioWSClient _daoProveedores;
        private proveedor _proveedorSeleccionado;

        public proveedor ProveedorSeleccionado { get => _proveedorSeleccionado; set => _proveedorSeleccionado = value; }

        //private cliWS.cliente _clienteSeleccionadoEliminar;

        [DllImport("user32.DLL", EntryPoint = "ReleaseCapture")]
        private extern static void ReleaseCapture();
        [DllImport("user32.DLL", EntryPoint = "SendMessage")]
        private extern static void SendMessage(System.IntPtr hWnd, int wMsg, int wParam, int IParam);

        public frmProveedores()
        {
            InitializeComponent();
            _daoProveedores = new InventarioWSClient();
            dgvProveedores.AutoGenerateColumns = false;
            dgvProveedores.DataSource = _daoProveedores.listarProveedor();
        }


        private void dgvProveedores_CellFormatting(object sender, DataGridViewCellFormattingEventArgs e)
        {
            proveedor proveedorGenerico = (proveedor)dgvProveedores.Rows[e.RowIndex].DataBoundItem;
            dgvProveedores.Rows[e.RowIndex].
                Cells[0].Value = proveedorGenerico.RUC;
            dgvProveedores.Rows[e.RowIndex].
                Cells[1].Value = proveedorGenerico.nombre;
            dgvProveedores.Rows[e.RowIndex].
                Cells[2].Value = proveedorGenerico.razonSocial;
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
            formHome.PB6Enabled.Visible = true;
            formHome.Show();
        }

        private void pnlTop_MouseDown(object sender, MouseEventArgs e)
        {
            ReleaseCapture();
            SendMessage(this.Handle, 0xA1, 0x2, 0);
        }

        private void button2_Click(object sender, EventArgs e)
        {
            frmDetalleProveedor formDet = new frmDetalleProveedor(_proveedorSeleccionado);
            this.Hide();
            formDet.ShowDialog();
        }

        private void pnlTop_Paint(object sender, PaintEventArgs e)
        {

        }

        private void panel1_Paint(object sender, PaintEventArgs e)
        {

        }

        private void lblPanel_Click(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            //dgvProveedores.DataSource = _daoProveedores.listarTodasClientesPorNombre_Apellido_DNI(textBox1.Text);
        }

        private void dgvProveedores_CellDoubleClick(object sender, DataGridViewCellEventArgs e)
        {
            _proveedorSeleccionado = (proveedor)dgvProveedores.CurrentRow.DataBoundItem;
            frmDetalleProveedor formDet = new frmDetalleProveedor(_proveedorSeleccionado);
            this.Hide();
            formDet.ShowDialog();
        }

        private void button3_Click(object sender, EventArgs e)
        {
            
        }

        private void dgvProveedores_CellContentDoubleClick(object sender, DataGridViewCellEventArgs e)
        {
            
        }

    }
}
