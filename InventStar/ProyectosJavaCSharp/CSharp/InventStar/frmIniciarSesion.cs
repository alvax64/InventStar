using InventStar.PersonalWS;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.SqlClient;
using System.Drawing;
using System.Drawing.Text;
using System.Linq;
using System.Runtime.InteropServices;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace InventStar
{
    public partial class frmIniciarSesion : Form
    {
        [DllImport("user32.DLL", EntryPoint = "ReleaseCapture")]
        private extern static void ReleaseCapture();
        [DllImport("user32.DLL", EntryPoint = "SendMessage")]
        private extern static void SendMessage(System.IntPtr hWnd, int wMsg, int wParam, int IParam);
        private PersonalWSClient daoPersonal;
        public frmIniciarSesion()
        {
            InitializeComponent();
            //InitializeFontCollection();
            daoPersonal = new PersonalWSClient();
            lblError.Text = "";
        }

        private void InitializeFontCollection()
        {
            #region PrivateFonts
            PrivateFontCollection pfc_regular = new PrivateFontCollection();
            byte[] prop_regular = Properties.Resources.SoDoSans_Regular;
            PrivateFontCollection pfc_bold = new PrivateFontCollection();
            byte[] prop_bold = Properties.Resources.SoDoSans_Bold;
            PrivateFontCollection pfc_black = new PrivateFontCollection();
            byte[] prop_black = Properties.Resources.SoDoSans_Black;
            #endregion

            InitializeFonts(pfc_regular, prop_regular);
            InitializeFonts(pfc_bold, prop_bold);
            InitializeFonts(pfc_black, prop_black);

            lblPanel.Font = new Font(pfc_regular.Families[0], lblPanel.Font.Size);
            txtUser.Font = new Font(pfc_regular.Families[0], txtUser.Font.Size);
            lblUsuario.Font = new Font(pfc_regular.Families[0], lblUsuario.Font.Size);
            lblPassword.Font = new Font(pfc_regular.Families[0], lblPassword.Font.Size);
        }

        private void InitializeFonts(PrivateFontCollection pfc, byte[] prop)
        {
            int fontLength = prop.Length;
            byte[] fontdata = prop;
            System.IntPtr data = Marshal.AllocCoTaskMem(fontLength);
            Marshal.Copy(fontdata, 0, data, fontLength);
            pfc.AddMemoryFont(data, fontLength);
        }

        private void pnlTop_MouseDown(object sender, MouseEventArgs e)
        {
            ReleaseCapture();
            SendMessage(this.Handle, 0xA1, 0x2, 0);
        }

        private void pictureBox3_Click(object sender, EventArgs e)
        {
            cuentaPersonal cuentaUsuario = new cuentaPersonal();
            cuentaUsuario.username = txtUser.Text;
            cuentaUsuario.password = txtPassword.Text;

            int resultado1= daoPersonal.verificarCuentaPersonalConPermisos(cuentaUsuario);
            if (resultado1 != 0)
            {
                frmPaginaPrincipal1 formHome1 = new frmPaginaPrincipal1();
                this.Hide();
                formHome1.LblVentas.Cursor = System.Windows.Forms.Cursors.Hand;
                formHome1.LblClientes.Cursor = System.Windows.Forms.Cursors.Hand;
                formHome1.LblInventario.Cursor = System.Windows.Forms.Cursors.Hand;
                formHome1.LblGuias.Cursor = System.Windows.Forms.Cursors.Hand;
                formHome1.PbVentas.Cursor = System.Windows.Forms.Cursors.Hand;
                formHome1.PbClientes.Cursor = System.Windows.Forms.Cursors.Hand;
                formHome1.PbInventario.Cursor = System.Windows.Forms.Cursors.Hand;
                formHome1.PbGuias.Cursor = System.Windows.Forms.Cursors.Hand;
                formHome1.LblUsuarioActual.Text = txtUser.Text != null ? txtUser.Text.ToUpper() : "";
                formHome1.LblUsuarioActual.Visible = true;
                formHome1.LblInicioSesion.Visible = false;
                formHome1.PbVentasEnabled.Visible = true;
                formHome1.PbClientesEnabled.Visible = true;
                formHome1.PbInventarioEnabled.Visible = true;
                formHome1.PbGuiasEnabled.Visible = true;
                formHome1.PB6Enabled.Visible = true;
                formHome1.PbPermisosEnabled.Visible = true;
                formHome1.Show();
            }
            else
            {
                int resultado = daoPersonal.verificarCuentaPersonal(cuentaUsuario);

                if (resultado != 0)
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
                    formHome.LblUsuarioActual.Text = txtUser.Text != null ? txtUser.Text.ToUpper() : "";
                    formHome.LblUsuarioActual.Visible = true;
                    formHome.LblInicioSesion.Visible = false;
                    formHome.PbVentasEnabled.Visible = true;
                    formHome.PbClientesEnabled.Visible = true;
                    formHome.PbInventarioEnabled.Visible = true;
                    formHome.PbGuiasEnabled.Visible = true;
                    formHome.PB6Enabled.Visible = true;
                    formHome.Show();
                }
                else
                {
                    lblError.Text = "Ha ingresado incorrectamente su usuario/password";
                }
            }
        }

        private void lblOlvido_Click(object sender, EventArgs e)
        {
            frmInicioSinPassword frmSinPass = new frmInicioSinPassword();
            this.Hide();
            frmSinPass.ShowDialog();
        }

        private void txtPassword_KeyPress(object sender, KeyPressEventArgs e)
        {
            if ((int)e.KeyChar == (int)Keys.Enter)
            pictureBox3_Click(sender, e);
        }

        private void txtPassword_Enter(object sender, EventArgs e)
        {
            lblError.Text = "";
            txtPassword.Text = "";
        }

        private void pictureBox3_Click_1(object sender, EventArgs e)
        {
            frmPaginaPrincipal formHome = new frmPaginaPrincipal();
            this.Hide();
            //formHome.LblVentas.Cursor = System.Windows.Forms.Cursors.Hand;
            //formHome.LblClientes.Cursor = System.Windows.Forms.Cursors.Hand;
            //formHome.LblInventario.Cursor = System.Windows.Forms.Cursors.Hand;
            //formHome.LblGuias.Cursor = System.Windows.Forms.Cursors.Hand;
            //formHome.PbVentas.Cursor = System.Windows.Forms.Cursors.Hand;
            //formHome.PbClientes.Cursor = System.Windows.Forms.Cursors.Hand;
            //formHome.PbInventario.Cursor = System.Windows.Forms.Cursors.Hand;
            //formHome.PbGuias.Cursor = System.Windows.Forms.Cursors.Hand;
            //formHome.LblUsuarioActual.Visible = true;
            //formHome.LblInicioSesion.Visible = false;
            //formHome.PbVentasEnabled.Visible = true;
            //formHome.PbClientesEnabled.Visible = true;
            //formHome.PbInventarioEnabled.Visible = true;
            //formHome.PbGuiasEnabled.Visible = true;
            formHome.Show();
        }
    }
}
