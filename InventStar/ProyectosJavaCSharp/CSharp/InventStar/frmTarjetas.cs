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

namespace InventStar
{
    public partial class frmTarjetas : Form
    {
        private ClientesWSClient _daoTarjeta;
        private tarjetaInventstar _tarjetaSeleccionada;
        private ClientesWSClient _daoPromociones;
        private promocionPersonalizada _promocionSeleccionada;
        DateTime fechaActual = DateTime.Now;
        public frmTarjetas(tarjetaInventstar _tarjetaSeleccionada)
        {
            InitializeComponent();
            _daoTarjeta = new ClientesWSClient();
            _daoPromociones = new ClientesWSClient();
            this._tarjetaSeleccionada = _tarjetaSeleccionada;
            textBox1.Text = _tarjetaSeleccionada.puntosAcumulados.ToString();
            dataGridViewProm.AutoGenerateColumns = false;
            dataGridViewProm.DataSource = _daoPromociones.listarTodasPromociones(_tarjetaSeleccionada.idTarjeta);
            dateTimePicker1.Value = _tarjetaSeleccionada.fechaRegistro;
        }

        public promocionPersonalizada PromocionSeleccionada { get => _promocionSeleccionada; set => _promocionSeleccionada = value; }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void label2_Click(object sender, EventArgs e)
        {

        }

        private void dateTimePicker1_ValueChanged(object sender, EventArgs e)
        {

        }

        private void label3_Click(object sender, EventArgs e)
        {

        }

        private void pictureBox2_Click(object sender, EventArgs e)
        {
            frmDetalleCliente2 formDet2 = new frmDetalleCliente2(_tarjetaSeleccionada.cliente);
            this.Hide();
            formDet2.ShowDialog();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            _tarjetaSeleccionada.puntosAcumulados = Convert.ToInt32(textBox1.Text);
            _tarjetaSeleccionada.fechaRegistro = fechaActual;
            _tarjetaSeleccionada.fechaRegistroSpecified = true;
            int resultado = _daoTarjeta.modificarTarjeta(_tarjetaSeleccionada);
            if (resultado != 0)
            {
                MessageBox.Show("Se ha modificado correctamente",
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

        private void button2_Click(object sender, EventArgs e)
        {
            frmPromociones formProm = new frmPromociones(_tarjetaSeleccionada);
            this.Hide();
            formProm.ShowDialog();
        }

        private void button4_Click(object sender, EventArgs e)
        {
            _promocionSeleccionada = (promocionPersonalizada)dataGridViewProm.CurrentRow.DataBoundItem;
            frmModificaPromocion formModProm = new frmModificaPromocion(_promocionSeleccionada);
            this.Hide();
            formModProm.ShowDialog();
        }

        private void dataGridViewProm_CellFormatting(object sender, DataGridViewCellFormattingEventArgs e)
        {
            promocionPersonalizada promocionGenerico = (promocionPersonalizada)dataGridViewProm.Rows[e.RowIndex].DataBoundItem;
            if (promocionGenerico != null)
            {
                dataGridViewProm.Rows[e.RowIndex].
                Cells[0].Value = promocionGenerico.idItemVenta;
                dataGridViewProm.Rows[e.RowIndex].
                    Cells[1].Value = promocionGenerico.nombre;
                dataGridViewProm.Rows[e.RowIndex].
                    Cells[2].Value = promocionGenerico.precioUnitario;
                dataGridViewProm.Rows[e.RowIndex].
                    Cells[3].Value = promocionGenerico.fechaInicio.ToShortDateString();
                dataGridViewProm.Rows[e.RowIndex].
                    Cells[4].Value = promocionGenerico.fechaFin.ToShortDateString();
                dataGridViewProm.Rows[e.RowIndex].
                    Cells[5].Value = promocionGenerico.tipoPromocion.ToString();
            }
            
        }

        private void button3_Click(object sender, EventArgs e)
        {
            _promocionSeleccionada = (promocionPersonalizada)dataGridViewProm.CurrentRow.DataBoundItem;
            int _codigoEliminar = _promocionSeleccionada.idItemVenta;
            int resultado = _daoPromociones.eliminarPromocion(_codigoEliminar);
            if (resultado != 0)
            {
                MessageBox.Show("Se ha eliminado la promocion",
                    "Mensaje de éxito", MessageBoxButtons.OK,
                    MessageBoxIcon.Information);
                dataGridViewProm.DataSource = _daoPromociones.listarTodasPromociones(_tarjetaSeleccionada.idTarjeta);
            }
            else
            {
                MessageBox.Show("Ha ocurrido un error con la eliminación",
                    "Mensaje de éxito", MessageBoxButtons.OK,
                    MessageBoxIcon.Error);
            }
        }

        private void dataGridViewProm_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }
    }
}
