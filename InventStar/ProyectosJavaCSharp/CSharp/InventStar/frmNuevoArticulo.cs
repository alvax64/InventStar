using InventStar.InventarioWS;
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

namespace InventStar
{
    public partial class frmNuevoArticulo : Form
    {
        //private comida _comida;
        private int flagg = 1;

        private InventarioWSClient _daoInventario;
        [DllImport("user32.DLL", EntryPoint = "ReleaseCapture")]
        private extern static void ReleaseCapture();
        [DllImport("user32.DLL", EntryPoint = "SendMessage")]
        private extern static void SendMessage(System.IntPtr hWnd, int wMsg, int wParam, int IParam);
        public frmNuevoArticulo()
        {
            InitializeComponent();
            _daoInventario = new InventarioWSClient();
            dataGridView1.AutoGenerateColumns = false;
            if (radioButton2.Checked)
            {
                dataGridView1.DataSource = _daoInventario.listarTodasComidas();
            }
            else
            {
                dataGridView1.DataSource = _daoInventario.listarIngrediente();
            }
        }

        public String getName()
        {
            return dataGridView1.CurrentRow.Cells[0].Value.ToString();
        }

        public String getUnit()
        {
            return dataGridView1.CurrentRow.Cells[1].Value.ToString();
        }

        public String getQuant()
        {
            return dataGridView1.CurrentRow.Cells[2].Value.ToString();
        }

        public Decimal getStock()
        {
            return numericUpDown1.Value;
        }

        private void pnlTop_MouseDown(object sender, MouseEventArgs e)
        {
            ReleaseCapture();
            SendMessage(this.Handle, 0xA1, 0x2, 0);
        }

        private void textBox2_TextChanged(object sender, EventArgs e)
        {

        }

        private void radioButton1_CheckedChanged(object sender, EventArgs e)
        {

        }

        private void button2_Click(object sender, EventArgs e)
        {
            this.DialogResult = DialogResult.Cancel;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            this.DialogResult = DialogResult.OK;
        }

        private void button3_Click(object sender, EventArgs e)
        {
            if (radioButton2.Checked)
            {
                dataGridView1.DataSource = _daoInventario.listarTodasComidas();
                flagg = 1;
            }
            else
            {
                dataGridView1.DataSource = _daoInventario.listarIngrediente();
                flagg = 0;
            }
        }

        private void dataGridView1_CellFormatting(object sender, DataGridViewCellFormattingEventArgs e)
        {
            if (flagg == 1)
            {
                
                comida comi = (comida)dataGridView1.Rows[e.RowIndex].DataBoundItem;

                dataGridView1.Rows[e.RowIndex].Cells[0].Value = comi.nombre;
                dataGridView1.Rows[e.RowIndex].Cells[1].Value = comi.unidadMedida;
                dataGridView1.Rows[e.RowIndex].Cells[2].Value = comi.cantidad;
            }
            else if (flagg == 0)
            {
                
                ingrediente ingre = (ingrediente)dataGridView1.Rows[e.RowIndex].DataBoundItem;

                dataGridView1.Rows[e.RowIndex].Cells[0].Value = ingre.nombre;
                dataGridView1.Rows[e.RowIndex].Cells[1].Value = ingre.unidadMedida;
                dataGridView1.Rows[e.RowIndex].Cells[2].Value = ingre.cantidad;
            }
        }
    }
}
