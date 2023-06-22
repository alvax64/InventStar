using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Drawing.Text;
using System.Linq;
using System.Runtime.InteropServices;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace InventStar
{
    public partial class frmInicioSinPassword : Form
    {
        [DllImport("user32.DLL", EntryPoint = "ReleaseCapture")]
        private extern static void ReleaseCapture();
        [DllImport("user32.DLL", EntryPoint = "SendMessage")]
        private extern static void SendMessage(System.IntPtr hWnd, int wMsg, int wParam, int IParam);
        public frmInicioSinPassword()
        {
            InitializeComponent();
            InitializeFontCollection();
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
            lblIndicacion1.Font = new Font(pfc_bold.Families[0], lblIndicacion1.Font.Size);
            lblIndicacion2.Font = new Font(pfc_bold.Families[0], lblIndicacion2.Font.Size);
            lblIngresarCodigo.Font = new Font(pfc_regular.Families[0], lblIngresarCodigo.Font.Size);
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

        private void pbContinuar_Click(object sender, EventArgs e)
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
            formHome.LblUsuarioActual.Text = txtCodigo.Text.ToUpper();
            formHome.LblUsuarioActual.Visible = true;
            formHome.LblInicioSesion.Visible = false;
            formHome.PbVentasEnabled.Visible = true;
            formHome.PbClientesEnabled.Visible = true;
            formHome.PbInventarioEnabled.Visible = true;
            formHome.PbGuiasEnabled.Visible = true;
            formHome.ShowDialog();
        }
    }
}
