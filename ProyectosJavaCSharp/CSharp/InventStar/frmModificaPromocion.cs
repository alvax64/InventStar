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
    public partial class frmModificaPromocion : Form
    {
        private ClientesWSClient _daoPromociones;
        private promocionPersonalizada promocionSeleccionada;
        DateTime fechaActual = DateTime.Now;
        public frmModificaPromocion(promocionPersonalizada _promocionSeleccionada)
        {
            InitializeComponent();
            _daoPromociones = new ClientesWSClient();
            this.promocionSeleccionada = _promocionSeleccionada;
            textBox1.Text = _promocionSeleccionada.nombre;
            textBox2.Text = _promocionSeleccionada.precioUnitario.ToString();
            textBox3.Text = _promocionSeleccionada.descripcion;
            dateTimePicker2.Value = _promocionSeleccionada.fechaFin;
            if (_promocionSeleccionada.tipoPromocion.ToString() == "desayunos")
            {
                radioButton1.Checked = true;
            }
            else if (_promocionSeleccionada.tipoPromocion.ToString() == "antojos_de_la_tarde")
            {
                radioButton2.Checked = true;
            }
            else if (_promocionSeleccionada.tipoPromocion.ToString() == "coffee_for_share")
            {
                radioButton3.Checked = true;
            } else if (_promocionSeleccionada.tipoPromocion.ToString() == "otros")
            {
                radioButton4.Checked = true;
            }
            textBox5.Text = _promocionSeleccionada.mensaje;
        }

        private void frmModificaPromocion_Load(object sender, EventArgs e)
        {

        }

        private void pictureBox1_Click(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            promocionSeleccionada.nombre = textBox1.Text;
            promocionSeleccionada.precioUnitario = Convert.ToInt32(textBox2.Text);
            promocionSeleccionada.descripcion = textBox3.Text;
            promocionSeleccionada.fechaInicio = fechaActual;
            promocionSeleccionada.fechaFin = dateTimePicker2.Value;
            if (radioButton1.Checked)
            {
                promocionSeleccionada.tipoPromocion = tipoDePromocion.desayunos;
            }
            else if (radioButton2.Checked)
            {
                promocionSeleccionada.tipoPromocion = tipoDePromocion.antojos_de_la_tarde;
            }
            else if (radioButton3.Checked)
            {
                promocionSeleccionada.tipoPromocion = tipoDePromocion.coffee_for_share;
            }
            else if (radioButton4.Checked)
            {
                promocionSeleccionada.tipoPromocion = tipoDePromocion.otros;
            }
            promocionSeleccionada.mensaje = textBox5.Text;

            int resultado = _daoPromociones.modificarPromocion(promocionSeleccionada);
            if (resultado != 0)
            {
                MessageBox.Show("Se ha modificado promocion correctamente",
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

        private void pictureBox2_Click(object sender, EventArgs e)
        {
            frmTarjetas formTar = new frmTarjetas(promocionSeleccionada.tarjeta);
            this.Hide();
            formTar.ShowDialog();
        }
    }
}
