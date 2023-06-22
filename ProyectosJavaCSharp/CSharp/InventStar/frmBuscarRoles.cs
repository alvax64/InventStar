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
    public partial class frmBuscarRoles : Form
    {
        private PersonalWSClient _daoRoles;
        private cargo _rolSeleccionado;
        private personal _personalSeleccionado;

        [DllImport("user32.DLL", EntryPoint = "ReleaseCapture")]
        private extern static void ReleaseCapture();
        [DllImport("user32.DLL", EntryPoint = "SendMessage")]
        private extern static void SendMessage(System.IntPtr hWnd, int wMsg, int wParam, int IParam);

        public frmBuscarRoles(personal personalSeleccionado)
        {
            InitializeComponent();
            _daoRoles = new PersonalWSClient();
            dgvRoles.AutoGenerateColumns = false;
            dgvRoles.DataSource = _daoRoles.listarTodosCargos();
            this._personalSeleccionado=personalSeleccionado;
        }
        public cargo RolSeleccionado { get => _rolSeleccionado; set => _rolSeleccionado = value; }

        private void dgvSucursal_CellFormatting(object sender, DataGridViewCellFormattingEventArgs e)
        {
            cargo rolGenerico = (cargo)dgvRoles.Rows[e.RowIndex].DataBoundItem;
            dgvRoles.Rows[e.RowIndex].
                Cells[0].Value = rolGenerico.nombre;
            dgvRoles.Rows[e.RowIndex].
                Cells[1].Value = rolGenerico.descripcion;
            dgvRoles.Rows[e.RowIndex].
                Cells[2].Value = rolGenerico.salario;
            dgvRoles.Rows[e.RowIndex].
                Cells[3].Value = (rolGenerico.modificaInventario==true)?"Si":"No";
        }
        private void pictureBox2_Click(object sender, EventArgs e)
        {
            //frmCambiarRol formCamR = new frmCambiarRol(_personalSeleccionado);
            //this.Hide();
            //formCamR.Show();
            this.DialogResult = DialogResult.OK;
        }

        private void pnlTop_MouseDown(object sender, MouseEventArgs e)
        {
            ReleaseCapture();
            SendMessage(this.Handle, 0xA1, 0x2, 0);
        }

        private void btnBuscar_Click(object sender, EventArgs e)
        {
            dgvRoles.DataSource = _daoRoles.listarTodosCargosPorNombre(textBox1.Text);
        }

        private void btnSeleccionar_Click(object sender, EventArgs e)
        {
            _rolSeleccionado = (cargo)dgvRoles.CurrentRow.DataBoundItem;
            this.DialogResult = DialogResult.OK;
        }
    }
}
