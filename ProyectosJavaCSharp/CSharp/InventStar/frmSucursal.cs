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
    public partial class frmSucursal : Form
    {
        private PersonalWSClient _daoSucursal;
        private sucursal _sucursalSeleccionado;
        private sucursal _sucursalSeleccionadoEliminar;

        [DllImport("user32.DLL", EntryPoint = "ReleaseCapture")]
        private extern static void ReleaseCapture();
        [DllImport("user32.DLL", EntryPoint = "SendMessage")]
        private extern static void SendMessage(System.IntPtr hWnd, int wMsg, int wParam, int IParam);

        public frmSucursal()
        {
            InitializeComponent();
            _daoSucursal = new PersonalWSClient();
            dgvSucursales.AutoGenerateColumns = false;
            dgvSucursales.DataSource = _daoSucursal.listarTodosSucursales();
        }
        public sucursal SucursalSeleccionado { get => _sucursalSeleccionado; set => _sucursalSeleccionado = value; }

        private void dgvSucursal_CellFormatting(object sender, DataGridViewCellFormattingEventArgs e)
        {
            sucursal sucursalGenerico = (sucursal)dgvSucursales.Rows[e.RowIndex].DataBoundItem;
            dgvSucursales.Rows[e.RowIndex].
                Cells[0].Value = sucursalGenerico.nombre;
            dgvSucursales.Rows[e.RowIndex].
                Cells[1].Value = sucursalGenerico.aforo;
            dgvSucursales.Rows[e.RowIndex].
                Cells[2].Value = sucursalGenerico.telefono;
            dgvSucursales.Rows[e.RowIndex].
                Cells[3].Value = sucursalGenerico.email;
        }
        private void pictureBox2_Click(object sender, EventArgs e)
        {
            frmPaginaPermisos fromPerm = new frmPaginaPermisos();
            this.Hide();
            fromPerm.LblVentas.Cursor = System.Windows.Forms.Cursors.Hand;
            fromPerm.LblClientes.Cursor = System.Windows.Forms.Cursors.Hand;
            fromPerm.LblInventario.Cursor = System.Windows.Forms.Cursors.Hand;
            fromPerm.LblGuias.Cursor = System.Windows.Forms.Cursors.Hand;
            fromPerm.Lbl1.Cursor = System.Windows.Forms.Cursors.Hand;

            fromPerm.PbVentasEnabled.Visible = true;
            fromPerm.PbClientesEnabled.Visible = true;
            fromPerm.PbGuiasEnabled.Visible = true;
            fromPerm.PB6Enabled.Visible = true;
            fromPerm.PbSucursalEnabled.Visible = true;

            fromPerm.Show();
        }

        private void pnlTop_MouseDown(object sender, MouseEventArgs e)
        {
            ReleaseCapture();
            SendMessage(this.Handle, 0xA1, 0x2, 0);
        }

        private void button2_Click(object sender, EventArgs e)
        {
            frmDetalleSucursal formSuc = new frmDetalleSucursal();
            this.Hide();
            formSuc.ShowDialog();
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
            dgvSucursales.DataSource = _daoSucursal.listarTodosSucursalesPorNombre(textBox1.Text);
        }



        private void button3_Click(object sender, EventArgs e)
        {
            _sucursalSeleccionadoEliminar = (sucursal)dgvSucursales.CurrentRow.DataBoundItem;
            int _codigoEliminar= _sucursalSeleccionadoEliminar.id_sucursal;
            String _nombreSucursal = _sucursalSeleccionadoEliminar.nombre;
            int resultado=_daoSucursal.eliminarSucursal(_sucursalSeleccionadoEliminar);
            if (resultado != 0)
            {
                MessageBox.Show("Se ha eliminado la sucursal " + _nombreSucursal + " de código " + _codigoEliminar,
                    "Mensaje de éxito", MessageBoxButtons.OK,
                    MessageBoxIcon.Information);
                dgvSucursales.DataSource = _daoSucursal.listarTodosSucursales();
            }
            else
            {
                MessageBox.Show("Ha ocurrido un error con la eliminación",
                    "Mensaje de éxito", MessageBoxButtons.OK,
                    MessageBoxIcon.Error);
            }
        }

        private void dgvSucursales_CellDoubleClick(object sender, DataGridViewCellEventArgs e)
        {
            _sucursalSeleccionado = (sucursal)dgvSucursales.CurrentRow.DataBoundItem;
            frmDetalleSucursal2 formDet = new frmDetalleSucursal2(_sucursalSeleccionado);
            this.Hide();
            formDet.ShowDialog();
        }
    }
}
