using InventstarInventario;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Drawing.Text;
using System.Linq;
using System.Reflection.Emit;
using System.Runtime.InteropServices;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace InventStar
{
    public partial class frmPaginaPrincipal1 : Form
    {
        [DllImport("user32.DLL", EntryPoint = "ReleaseCapture")]
        private extern static void ReleaseCapture();
        [DllImport("user32.DLL", EntryPoint = "SendMessage")]
        private extern static void SendMessage(System.IntPtr hWnd, int wMsg, int wParam, int IParam);

        #region Constructores
        public PictureBox PbVentas
        {
            get => pbVentas;
            set => pbVentas = value;
        }

        public PictureBox PbInventario
        {
            get => pbInventario;
            set => pbInventario = value;
        }

        public PictureBox PbClientes
        {
            get => pbClientes;
            set => pbClientes = value;
        }

        public PictureBox PbGuias
        {
            get => pbGuias;
            set => pbGuias = value;
        }

        public System.Windows.Forms.Label LblVentas
        {
            get => lblVentas;
            set => lblVentas = value;
        }

        public System.Windows.Forms.Label LblInventario
        {
            get => lblInventario;
            set => lblInventario = value;
        }

        public System.Windows.Forms.Label LblClientes
        {
            get => lblClientes;
            set => lblClientes = value;
        }

        public System.Windows.Forms.Label LblGuias
        {
            get => lblGuias;
            set => lblGuias = value;
        }

        public System.Windows.Forms.Label LblInicioSesion
        {
            get => lblIniciarSesion;
            set => lblIniciarSesion = value;
        }

        public System.Windows.Forms.Label LblUsuarioActual
        {
            get => lblUsuarioActual;
            set => lblUsuarioActual = value;
        }

        public PictureBox PbVentasEnabled
        {
            get => pbVentasEnabled;
            set => pbVentasEnabled = value;
        }

        public PictureBox PbInventarioEnabled
        {
            get => pbInventarioEnabled;
            set => pbInventarioEnabled = value;
        }

        public PictureBox PbClientesEnabled
        {
            get => pbClientesEnabled;
            set => pbClientesEnabled = value;
        }

        public PictureBox PbGuiasEnabled
        {
            get => pbGuiasEnabled;
            set => pbGuiasEnabled = value;
        }
        public PictureBox PB6Enabled
        {
            get => pictureBox6;
            set => pictureBox6 = value;
        }

        public PictureBox PbPermisosEnabled
        {
            get => pbPermisosEnabled;
            set => pbPermisosEnabled = value;
        }

        #endregion

        public frmPaginaPrincipal1()
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

            #region Labels
            lblFooter.Font = new Font(pfc_regular.Families[0], lblFooter.Font.Size);
            lblIniciarSesion.Font = new Font(pfc_regular.Families[0], lblIniciarSesion.Font.Size);
            lblPanel.Font = new Font(pfc_regular.Families[0], lblPanel.Font.Size);
            lblStarbucks.Font = new Font(pfc_black.Families[0], lblStarbucks.Font.Size);
            lblSede.Font = new Font(pfc_regular.Families[0], lblSede.Font.Size);
            lblVentas.Font = new Font(pfc_regular.Families[0], lblVentas.Font.Size);
            lblInventario.Font = new Font(pfc_regular.Families[0], lblInventario.Font.Size);
            lblClientes.Font = new Font(pfc_regular.Families[0], lblClientes.Font.Size);
            lblGuias.Font = new Font(pfc_regular.Families[0], lblGuias.Font.Size);
            lblUsuarioActual.Font = new Font(pfc_regular.Families[0], lblUsuarioActual.Font.Size);
            #endregion
        }

        private void panelTop_MouseDown(object sender, MouseEventArgs e)
        {
            ReleaseCapture();
            SendMessage(this.Handle, 0xA1, 0x2, 0);
        }

        private void InitializeFonts(PrivateFontCollection pfc, byte[] prop)
        {
            int fontLength = prop.Length;
            byte[] fontdata = prop;
            System.IntPtr data = Marshal.AllocCoTaskMem(fontLength);
            Marshal.Copy(fontdata, 0, data, fontLength);
            pfc.AddMemoryFont(data, fontLength);
        }

        private void lblIniciarSesion_Click(object sender, EventArgs e)
        {
            frmIniciarSesion formInicSesion = new frmIniciarSesion();
            this.Hide();
            formInicSesion.Show();
        }

        private void pbGuiasEnabled_Click(object sender, EventArgs e)
        {
            frmGuias frmGuia = new frmGuias();
            this.Hide();
            frmGuia.ShowDialog(); 
        }

        private void pbClientesEnabled_Click(object sender, EventArgs e)
        {
            frmClientes formCli = new frmClientes();
            this.Hide();
            formCli.ShowDialog();
        }

        private void pictureBox4_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void pbInventarioEnabled_Click(object sender, EventArgs e)
        {
            frmInventario formInv= new frmInventario();
            this.Hide();
            formInv.ShowDialog();
        }

        private void pbVentasEnabled_Click(object sender, EventArgs e)
        {
            frmBebidas formBebidas = new frmBebidas();
            this.Hide();
            formBebidas.ShowDialog();
        }

        private void pictureBox6_Click(object sender, EventArgs e)
        {
            frmProveedores formProveedores = new frmProveedores();
            this.Hide();
            formProveedores.ShowDialog();
        }

        private void pbPermisosEnabled_Click(object sender, EventArgs e)
        {
            frmPaginaPermisos formPermisos= new frmPaginaPermisos();
            this.Hide();
            formPermisos.LblVentas.Cursor = System.Windows.Forms.Cursors.Hand;
            formPermisos.LblClientes.Cursor = System.Windows.Forms.Cursors.Hand;
            formPermisos.LblInventario.Cursor = System.Windows.Forms.Cursors.Hand;
            formPermisos.LblGuias.Cursor = System.Windows.Forms.Cursors.Hand;
            formPermisos.PbVentas.Cursor = System.Windows.Forms.Cursors.Hand;
            formPermisos.PbClientes.Cursor = System.Windows.Forms.Cursors.Hand;
            formPermisos.PbInventario.Cursor = System.Windows.Forms.Cursors.Hand;
            formPermisos.PbGuias.Cursor = System.Windows.Forms.Cursors.Hand;
            formPermisos.PbVentasEnabled.Visible = true;
            formPermisos.PbClientesEnabled.Visible = true;
            formPermisos.PbSucursalEnabled.Visible = true;
            formPermisos.PbGuiasEnabled.Visible = true;
            formPermisos.PB6Enabled.Visible = true;
            formPermisos.ShowDialog();
        }
    }
}
