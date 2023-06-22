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
    public partial class frmRoles : Form
    {
        private PersonalWSClient _daoPersonal;
        private sucursal _personalSeleccionado;

        [DllImport("user32.DLL", EntryPoint = "ReleaseCapture")]
        private extern static void ReleaseCapture();
        [DllImport("user32.DLL", EntryPoint = "SendMessage")]
        private extern static void SendMessage(System.IntPtr hWnd, int wMsg, int wParam, int IParam);

        public frmRoles()
        {
            InitializeComponent();
            _daoPersonal = new PersonalWSClient();
            dgvRoles.AutoGenerateColumns = false;
            dgvRoles.DataSource = _daoPersonal.listarTodosPersonales();
        }
        public sucursal PersonalSeleccionado { get => _personalSeleccionado; set => _personalSeleccionado = value; }

        private void dgvRoles_CellFormatting(object sender, DataGridViewCellFormattingEventArgs e)
        {
            personal personalGenerico = (personal)dgvRoles.Rows[e.RowIndex].DataBoundItem;
            dgvRoles.Rows[e.RowIndex].
                Cells[0].Value = personalGenerico.nombres + " " + personalGenerico.apellidoPat;
            dgvRoles.Rows[e.RowIndex].
                Cells[1].Value = (personalGenerico.cargo.modificaInventario==true)?"Si":"No";
            dgvRoles.Rows[e.RowIndex].
                Cells[2].Value = personalGenerico.numDocumento;
            dgvRoles.Rows[e.RowIndex].
                Cells[3].Value = personalGenerico.domicilio;
            dgvRoles.Rows[e.RowIndex].
                Cells[4].Value = personalGenerico.fechaRegistro.ToShortDateString();
            dgvRoles.Rows[e.RowIndex].
                Cells[5].Value = personalGenerico.telefono1;
            dgvRoles.Rows[e.RowIndex].
                Cells[6].Value = personalGenerico.email;
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
            frmCambiarRol formCambioRol = new frmCambiarRol((personal)dgvRoles.CurrentRow.DataBoundItem);
            this.Hide();
            formCambioRol.ShowDialog();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            dgvRoles.DataSource = _daoPersonal.listarTodosPersonalesPorNombre_Apellido_DNI(textBox1.Text);
        }



        private void button3_Click(object sender, EventArgs e)
        {
            //_sucursalSeleccionadoEliminar = (sucursal)dgvRoles.CurrentRow.DataBoundItem;
            //int _codigoEliminar= _sucursalSeleccionadoEliminar.id_sucursal;
            //String _nombreSucursal = _sucursalSeleccionadoEliminar.nombre;
            //int resultado=_daoSucursal.eliminarSucursal(_sucursalSeleccionadoEliminar);
            //if (resultado != 0)
            //{
            //    MessageBox.Show("Se ha eliminado la sucursal " + _nombreSucursal + " de código " + _codigoEliminar,
            //        "Mensaje de éxito", MessageBoxButtons.OK,
            //        MessageBoxIcon.Information);
            //    dgvRoles.DataSource = _daoSucursal.listarTodosSucursales();
            //}
            //else
            //{
            //    MessageBox.Show("Ha ocurrido un error con la eliminación",
            //        "Mensaje de éxito", MessageBoxButtons.OK,
            //        MessageBoxIcon.Error);
            //}
        }
    }
}
