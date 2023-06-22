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
    public partial class frmVideos : Form
    {

        private PersonalWSClient _daoPersonal;
        private video _videoSeleccionado;

        [DllImport("user32.DLL", EntryPoint = "ReleaseCapture")]
        private extern static void ReleaseCapture();
        [DllImport("user32.DLL", EntryPoint = "SendMessage")]
        private extern static void SendMessage(System.IntPtr hWnd, int wMsg, int wParam, int IParam);

        public frmVideos()
        {
            InitializeComponent();
            _daoPersonal = new PersonalWSClient();
            dgvVideos.AutoGenerateColumns = false;
            dgvVideos.DataSource = _daoPersonal.listarTodosVideos();
        }

        public video VideoSeleccionado { get => _videoSeleccionado; set => _videoSeleccionado = value; }

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
            video video = (video)dgvVideos.CurrentRow.DataBoundItem;
            int id = video.idVideo;
            string nombre = video.titulo;
            frmVerVideo formVerVideo = new frmVerVideo(id, nombre);
            this.Hide();
            formVerVideo.ShowDialog();
        }

        private void dgvVideos_CellFormatting(object sender, DataGridViewCellFormattingEventArgs e)
        {
            video videoGenerico = (video)dgvVideos.Rows[e.RowIndex].DataBoundItem;

            dgvVideos.Rows[e.RowIndex].Cells[0].Value = videoGenerico.titulo;
            dgvVideos.Rows[e.RowIndex].Cells[1].Value = videoGenerico.duracion;
            dgvVideos.Rows[e.RowIndex].Cells[2].Value = videoGenerico.descripcion;
        }
    }
}
