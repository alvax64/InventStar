using InventStar.ClientesWS;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using static System.Windows.Forms.VisualStyles.VisualStyleElement;

namespace InventStar
{
    public partial class frmPromociones : Form
    {
        private tarjetaInventstar _tarjetaSeleccionada;
        private ClientesWSClient _daoPromocion;
        private promocionPersonalizada _promocionPersonalizada;
        DateTime fechaActual = DateTime.Now;
        public frmPromociones(tarjetaInventstar tarjetaSeleccionada)
        {
            InitializeComponent();
            _tarjetaSeleccionada = tarjetaSeleccionada;
            _daoPromocion = new ClientesWSClient();
            _promocionPersonalizada = new promocionPersonalizada();
        }

        private void label2_Click(object sender, EventArgs e)
        {

        }

        private void textBox6_TextChanged(object sender, EventArgs e)
        {

        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {

            _promocionPersonalizada.nombre = textBox1.Text;
            _promocionPersonalizada.precioUnitario = Convert.ToDouble(textBox2.Text);
            _promocionPersonalizada.descripcion = textBox3.Text;
            _promocionPersonalizada.fechaInicio = fechaActual;
            _promocionPersonalizada.fechaInicioSpecified = true;
            _promocionPersonalizada.fechaFin = dateTimePicker2.Value;
            _promocionPersonalizada.fechaFinSpecified = true;
            if(radioButton1.Checked)
            {
                _promocionPersonalizada.tipoPromocion = tipoDePromocion.desayunos;

            } else if(radioButton2.Checked)
            {
                _promocionPersonalizada.tipoPromocion = tipoDePromocion.antojos_de_la_tarde;
            } else if(radioButton3.Checked)
            {
                _promocionPersonalizada.tipoPromocion = tipoDePromocion.coffee_for_share;
            } else if(radioButton4.Checked)
            {
                _promocionPersonalizada.tipoPromocion = tipoDePromocion.otros;
            }
            _promocionPersonalizada.tipoPromocionSpecified = true;
            _promocionPersonalizada.mensaje = textBox5.Text;
            _promocionPersonalizada.tarjeta = _tarjetaSeleccionada;
            int resultado = _daoPromocion.insertarPromocion(_promocionPersonalizada);
            if (resultado != 0)
            {
                MessageBox.Show("Se ha registrado promocion correctamente",
                    "Mensaje de éxito", MessageBoxButtons.OK,
                    MessageBoxIcon.Information);
                _promocionPersonalizada.idItemVenta = resultado;

            }
            else
            {
                MessageBox.Show("Ha ocurrido un error con el registro",
                    "Mensaje de éxito", MessageBoxButtons.OK,
                    MessageBoxIcon.Error);
            }
        }

        private void frmPromociones_Load(object sender, EventArgs e)
        {

        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void textBox2_TextChanged(object sender, EventArgs e)
        {

        }

        private void textBox3_TextChanged(object sender, EventArgs e)
        {

        }

        private void label3_Click(object sender, EventArgs e)
        {

        }

        private void label5_Click(object sender, EventArgs e)
        {

        }

        private void dateTimePicker2_ValueChanged(object sender, EventArgs e)
        {

        }

        private void textBox4_TextChanged(object sender, EventArgs e)
        {

        }

        private void textBox5_TextChanged(object sender, EventArgs e)
        {

        }

        private void label7_Click(object sender, EventArgs e)
        {

        }

        private void panel1_Paint(object sender, PaintEventArgs e)
        {

        }

        private void pictureBox2_Click(object sender, EventArgs e)
        {
            frmTarjetas formTar = new frmTarjetas(_tarjetaSeleccionada);
            this.Hide();
            formTar.ShowDialog();
        }

        private void radioButton1_CheckedChanged(object sender, EventArgs e)
        {

        }
    }
}
