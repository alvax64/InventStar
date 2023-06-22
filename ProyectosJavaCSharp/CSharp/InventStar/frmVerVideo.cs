using InventStar.PersonalWS;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Runtime.InteropServices;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace InventStar
{
    public partial class frmVerVideo : Form
    {
        private PersonalWSClient _daoPersonal;
        [DllImport("user32.DLL", EntryPoint = "ReleaseCapture")]
        private extern static void ReleaseCapture();
        [DllImport("user32.DLL", EntryPoint = "SendMessage")]
        private extern static void SendMessage(System.IntPtr hWnd, int wMsg, int wParam, int IParam);

        public frmVerVideo()
        {
            InitializeComponent();
            _daoPersonal = new PersonalWSClient();
            // Cargar el reproductor de video de YouTube
            //chromiumWebBrowser1.Load("https://youtu.be/eY52Zsg-KVI");
            // Establecer el enlace directo al archivo MP4
            
            string videoUrl = "Videos/mi_video.mp4";

            // Cargar el video en el control AxWindowsMediaPlayer
            axWindowsMediaPlayer1.URL = videoUrl;

            // Reproducir el video
            axWindowsMediaPlayer1.Ctlcontrols.play();
        }

        public frmVerVideo(int id, string titulo)
        {
            InitializeComponent();
            _daoPersonal = new PersonalWSClient();
            byte[] url = _daoPersonal.obtenerVideoPorId(id);
            lblTitulo.Text = titulo.ToUpper();
            lblTitulo.TextAlign = ContentAlignment.MiddleCenter;
            lblTitulo.Anchor = AnchorStyles.None;

            string tempFilePath = Path.GetTempFileName(); // Genera un nombre de archivo temporal único
            string tempFileWithExtension = Path.ChangeExtension(tempFilePath, ".mp4"); // Cambia la extensión a .mp4

            using (FileStream fs = new FileStream(tempFileWithExtension, FileMode.Create))
            {
                fs.Write(url, 0, url.Length); 
            }
        
            axWindowsMediaPlayer1.URL = tempFileWithExtension; 
           

            axWindowsMediaPlayer1.Ctlcontrols.play();

        }

        private void pictureBox2_Click(object sender, EventArgs e)
        {
            axWindowsMediaPlayer1.Ctlcontrols.stop();
            frmVideos formVideos = new frmVideos();
            this.Hide();
            formVideos.ShowDialog();
        }

        private void pnlTop_MouseDown(object sender, MouseEventArgs e)
        {
            ReleaseCapture();
            SendMessage(this.Handle, 0xA1, 0x2, 0);
        }

        private void axWindowsMediaPlayer1_Buffering(object sender, AxWMPLib._WMPOCXEvents_BufferingEvent e)
        {

        }

            private void axWindowsMediaPlayer1_PlayStateChange(object sender, AxWMPLib._WMPOCXEvents_PlayStateChangeEvent e)
            {
                // Check the value of e.newState to determine the current state of the control
                if (e.newState == (int)WMPLib.WMPPlayState.wmppsStopped)
                {
                    // The media playback has stopped
                    Console.WriteLine("The media playback has stopped");
                }
                else if (e.newState == (int)WMPLib.WMPPlayState.wmppsPaused)
                {
                    // The media playback has been paused
                    Console.WriteLine("The media playback has been paused");
                }
                else if (e.newState == (int)WMPLib.WMPPlayState.wmppsPlaying)
                {
                    // The media is currently playing
                    Console.WriteLine("The media is currently playing");
                }
            }
    }
}
