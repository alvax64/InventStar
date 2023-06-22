using InventStar.PersonalWS;
using InventstarInventario;
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
using static System.Windows.Forms.VisualStyles.VisualStyleElement.Button;

namespace InventStar
{
    public partial class frmCambiarRol : Form
    {
        private cargo _rol;
        private personal _personalSeleccionado;
        private PersonalWSClient _daoPersonal;

        [DllImport("user32.DLL", EntryPoint = "ReleaseCapture")]
        private extern static void ReleaseCapture();
        [DllImport("user32.DLL", EntryPoint = "SendMessage")]
        private extern static void SendMessage(System.IntPtr hWnd, int wMsg, int wParam, int IParam);
        public frmCambiarRol(personal personalSeleccionado)
        {
            InitializeComponent();
            this.BackColor = System.Drawing.Color.FromArgb(229, 229, 229);
            btAceptar.FlatStyle = FlatStyle.Flat;
            btAceptar.FlatAppearance.BorderSize = 0;
            btCancelar.FlatStyle = FlatStyle.Flat;
            btCancelar.FlatAppearance.BorderSize = 0;
            _rol= new cargo();
            this._personalSeleccionado= personalSeleccionado;
            textBox2.Text = personalSeleccionado.nombres+" "+personalSeleccionado.apellidoPat;
            textBox2.Enabled = false;
            if (personalSeleccionado.cargo.modificaInventario == true) checkBox1.Checked = true;
            if (personalSeleccionado.cargo.modificaInventario == false) checkBox1.Checked = false;
            checkBox1.Enabled = false;
            _daoPersonal = new PersonalWSClient();
        }

        private void btCancelar_Click(object sender, EventArgs e)
        {
            frmRoles formRol = new frmRoles();
            this.Hide();
            formRol.ShowDialog();
        }

        private void btAceptar_Click(object sender, EventArgs e)
        {
            int resultado = _daoPersonal.modificarPermisoPersonal(_personalSeleccionado.idPersona,_rol.idCargo);
            if (resultado != 0)
            {
                MessageBox.Show("Se ha cambiado el rol correctamente",
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

        private void btBuscar_Click(object sender, EventArgs e)
        {
            frmBuscarRoles frmBuscarR = new frmBuscarRoles(_personalSeleccionado);
            //this.Hide();
            if (frmBuscarR.ShowDialog() == DialogResult.OK)
            {
                _rol = frmBuscarR.RolSeleccionado;
                if (_rol != null)
                { 
                    textBox1.Text = _rol.nombre;
                    if (_rol.modificaInventario == true) checkBox1.Checked = true;
                    if (_rol.modificaInventario == false) checkBox1.Checked = false;
                }
            }
        }

        private void panel1_MouseDown(object sender, MouseEventArgs e)
        {
            ReleaseCapture();
            SendMessage(this.Handle, 0xA1, 0x2, 0);
        }
    }
}
