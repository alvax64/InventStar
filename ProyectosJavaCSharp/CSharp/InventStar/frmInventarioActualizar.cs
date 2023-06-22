using InventstarInventario;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace InventStar
{
    public partial class frmInventarioActualizar : Form
    {
        public frmInventarioActualizar()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            frmInventario formInv = new frmInventario();
            this.Hide();
            formInv.ShowDialog();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            frmInventario formInv = new frmInventario();
            this.Hide();
            formInv.ShowDialog();
        }
    }
}
