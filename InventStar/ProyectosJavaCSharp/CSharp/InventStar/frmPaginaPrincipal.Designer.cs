using System.Drawing;

namespace InventStar
{
    partial class frmPaginaPrincipal
    {
        /// <summary>
        /// Variable del diseñador necesaria.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Limpiar los recursos que se estén usando.
        /// </summary>
        /// <param name="disposing">true si los recursos administrados se deben desechar; false en caso contrario.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Código generado por el Diseñador de Windows Forms

        /// <summary>
        /// Método necesario para admitir el Diseñador. No se puede modificar
        /// el contenido de este método con el editor de código.
        /// </summary>
        private void InitializeComponent()
        {
            this.pnlTop = new System.Windows.Forms.Panel();
            this.lblUsuarioActual = new System.Windows.Forms.Label();
            this.pictureBox3 = new System.Windows.Forms.PictureBox();
            this.lblIniciarSesion = new System.Windows.Forms.Label();
            this.pictureBox1 = new System.Windows.Forms.PictureBox();
            this.pnlBottom = new System.Windows.Forms.Panel();
            this.lblFooter = new System.Windows.Forms.Label();
            this.pnlHeader = new System.Windows.Forms.Panel();
            this.pictureBox4 = new System.Windows.Forms.PictureBox();
            this.lblPanel = new System.Windows.Forms.Label();
            this.pnlMain = new System.Windows.Forms.Panel();
            this.pictureBox6 = new System.Windows.Forms.PictureBox();
            this.pbGuiasEnabled = new System.Windows.Forms.PictureBox();
            this.pbInventarioEnabled = new System.Windows.Forms.PictureBox();
            this.pbClientesEnabled = new System.Windows.Forms.PictureBox();
            this.pbVentasEnabled = new System.Windows.Forms.PictureBox();
            this.lblInventario = new System.Windows.Forms.Label();
            this.lblGuias = new System.Windows.Forms.Label();
            this.lblClientes = new System.Windows.Forms.Label();
            this.lblVentas = new System.Windows.Forms.Label();
            this.pbGuias = new System.Windows.Forms.PictureBox();
            this.pbInventario = new System.Windows.Forms.PictureBox();
            this.pbClientes = new System.Windows.Forms.PictureBox();
            this.pbVentas = new System.Windows.Forms.PictureBox();
            this.lblSede = new System.Windows.Forms.Label();
            this.lblStarbucks = new System.Windows.Forms.Label();
            this.pictureBox2 = new System.Windows.Forms.PictureBox();
            this.pictureBox5 = new System.Windows.Forms.PictureBox();
            this.label1 = new System.Windows.Forms.Label();
            this.pnlTop.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox3)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
            this.pnlBottom.SuspendLayout();
            this.pnlHeader.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox4)).BeginInit();
            this.pnlMain.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox6)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pbGuiasEnabled)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pbInventarioEnabled)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pbClientesEnabled)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pbVentasEnabled)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pbGuias)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pbInventario)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pbClientes)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pbVentas)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox2)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox5)).BeginInit();
            this.SuspendLayout();
            // 
            // pnlTop
            // 
            this.pnlTop.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(22)))), ((int)(((byte)(44)))), ((int)(((byte)(38)))));
            this.pnlTop.Controls.Add(this.lblUsuarioActual);
            this.pnlTop.Controls.Add(this.pictureBox3);
            this.pnlTop.Controls.Add(this.lblIniciarSesion);
            this.pnlTop.Controls.Add(this.pictureBox1);
            this.pnlTop.Dock = System.Windows.Forms.DockStyle.Top;
            this.pnlTop.Location = new System.Drawing.Point(0, 0);
            this.pnlTop.Name = "pnlTop";
            this.pnlTop.Size = new System.Drawing.Size(800, 61);
            this.pnlTop.TabIndex = 0;
            this.pnlTop.MouseDown += new System.Windows.Forms.MouseEventHandler(this.panelTop_MouseDown);
            // 
            // lblUsuarioActual
            // 
            this.lblUsuarioActual.AutoSize = true;
            this.lblUsuarioActual.Cursor = System.Windows.Forms.Cursors.Arrow;
            this.lblUsuarioActual.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblUsuarioActual.ForeColor = System.Drawing.SystemColors.Control;
            this.lblUsuarioActual.Location = new System.Drawing.Point(634, 23);
            this.lblUsuarioActual.Name = "lblUsuarioActual";
            this.lblUsuarioActual.Size = new System.Drawing.Size(0, 19);
            this.lblUsuarioActual.TabIndex = 12;
            this.lblUsuarioActual.TextAlign = System.Drawing.ContentAlignment.TopRight;
            this.lblUsuarioActual.UseCompatibleTextRendering = true;
            this.lblUsuarioActual.Visible = false;
            // 
            // pictureBox3
            // 
            this.pictureBox3.Image = global::InventStar.Properties.Resources.userIcon;
            this.pictureBox3.Location = new System.Drawing.Point(740, 6);
            this.pictureBox3.Name = "pictureBox3";
            this.pictureBox3.Size = new System.Drawing.Size(50, 46);
            this.pictureBox3.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pictureBox3.TabIndex = 2;
            this.pictureBox3.TabStop = false;
            // 
            // lblIniciarSesion
            // 
            this.lblIniciarSesion.AutoSize = true;
            this.lblIniciarSesion.Cursor = System.Windows.Forms.Cursors.Hand;
            this.lblIniciarSesion.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblIniciarSesion.ForeColor = System.Drawing.SystemColors.Control;
            this.lblIniciarSesion.Location = new System.Drawing.Point(634, 23);
            this.lblIniciarSesion.Name = "lblIniciarSesion";
            this.lblIniciarSesion.Size = new System.Drawing.Size(108, 20);
            this.lblIniciarSesion.TabIndex = 1;
            this.lblIniciarSesion.Text = "INICIAR SESIÓN";
            this.lblIniciarSesion.UseCompatibleTextRendering = true;
            this.lblIniciarSesion.Click += new System.EventHandler(this.lblIniciarSesion_Click);
            // 
            // pictureBox1
            // 
            this.pictureBox1.Image = global::InventStar.Properties.Resources.Logo;
            this.pictureBox1.Location = new System.Drawing.Point(5, 2);
            this.pictureBox1.Name = "pictureBox1";
            this.pictureBox1.Size = new System.Drawing.Size(182, 56);
            this.pictureBox1.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pictureBox1.TabIndex = 0;
            this.pictureBox1.TabStop = false;
            // 
            // pnlBottom
            // 
            this.pnlBottom.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(198)))), ((int)(((byte)(201)))), ((int)(((byte)(196)))));
            this.pnlBottom.Controls.Add(this.lblFooter);
            this.pnlBottom.Dock = System.Windows.Forms.DockStyle.Bottom;
            this.pnlBottom.Location = new System.Drawing.Point(0, 513);
            this.pnlBottom.Name = "pnlBottom";
            this.pnlBottom.Size = new System.Drawing.Size(800, 37);
            this.pnlBottom.TabIndex = 1;
            // 
            // lblFooter
            // 
            this.lblFooter.AutoSize = true;
            this.lblFooter.Font = new System.Drawing.Font("Segoe UI", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblFooter.Location = new System.Drawing.Point(322, 12);
            this.lblFooter.Name = "lblFooter";
            this.lblFooter.Size = new System.Drawing.Size(165, 20);
            this.lblFooter.TabIndex = 0;
            this.lblFooter.Text = "InventStar © 2023 - Starbucks";
            this.lblFooter.TextAlign = System.Drawing.ContentAlignment.TopCenter;
            this.lblFooter.UseCompatibleTextRendering = true;
            // 
            // pnlHeader
            // 
            this.pnlHeader.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(132)))), ((int)(((byte)(142)))), ((int)(((byte)(136)))));
            this.pnlHeader.Controls.Add(this.pictureBox4);
            this.pnlHeader.Controls.Add(this.lblPanel);
            this.pnlHeader.Dock = System.Windows.Forms.DockStyle.Top;
            this.pnlHeader.Location = new System.Drawing.Point(0, 61);
            this.pnlHeader.Name = "pnlHeader";
            this.pnlHeader.Size = new System.Drawing.Size(800, 36);
            this.pnlHeader.TabIndex = 2;
            // 
            // pictureBox4
            // 
            this.pictureBox4.Cursor = System.Windows.Forms.Cursors.Hand;
            this.pictureBox4.Image = global::InventStar.Properties.Resources.btn_close;
            this.pictureBox4.Location = new System.Drawing.Point(758, 6);
            this.pictureBox4.Name = "pictureBox4";
            this.pictureBox4.Size = new System.Drawing.Size(30, 27);
            this.pictureBox4.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pictureBox4.TabIndex = 1;
            this.pictureBox4.TabStop = false;
            this.pictureBox4.Click += new System.EventHandler(this.pictureBox4_Click);
            // 
            // lblPanel
            // 
            this.lblPanel.AutoSize = true;
            this.lblPanel.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblPanel.Location = new System.Drawing.Point(286, 9);
            this.lblPanel.Name = "lblPanel";
            this.lblPanel.Size = new System.Drawing.Size(229, 24);
            this.lblPanel.TabIndex = 0;
            this.lblPanel.Text = "P A N E L  D E  C O N T R O L";
            this.lblPanel.UseCompatibleTextRendering = true;
            // 
            // pnlMain
            // 
            this.pnlMain.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(242)))), ((int)(((byte)(240)))), ((int)(((byte)(235)))));
            this.pnlMain.Controls.Add(this.pictureBox6);
            this.pnlMain.Controls.Add(this.pbGuiasEnabled);
            this.pnlMain.Controls.Add(this.pbInventarioEnabled);
            this.pnlMain.Controls.Add(this.pbClientesEnabled);
            this.pnlMain.Controls.Add(this.pbVentasEnabled);
            this.pnlMain.Controls.Add(this.lblInventario);
            this.pnlMain.Controls.Add(this.lblGuias);
            this.pnlMain.Controls.Add(this.lblClientes);
            this.pnlMain.Controls.Add(this.lblVentas);
            this.pnlMain.Controls.Add(this.pbGuias);
            this.pnlMain.Controls.Add(this.pbInventario);
            this.pnlMain.Controls.Add(this.pbClientes);
            this.pnlMain.Controls.Add(this.pbVentas);
            this.pnlMain.Controls.Add(this.lblSede);
            this.pnlMain.Controls.Add(this.lblStarbucks);
            this.pnlMain.Controls.Add(this.pictureBox2);
            this.pnlMain.Controls.Add(this.label1);
            this.pnlMain.Controls.Add(this.pictureBox5);
            this.pnlMain.Dock = System.Windows.Forms.DockStyle.Fill;
            this.pnlMain.Location = new System.Drawing.Point(0, 97);
            this.pnlMain.Name = "pnlMain";
            this.pnlMain.Size = new System.Drawing.Size(800, 416);
            this.pnlMain.TabIndex = 3;
            // 
            // pictureBox6
            // 
            this.pictureBox6.Cursor = System.Windows.Forms.Cursors.Hand;
            this.pictureBox6.Image = global::InventStar.Properties.Resources.btn_success_proveedores;
            this.pictureBox6.Location = new System.Drawing.Point(559, 183);
            this.pictureBox6.Name = "pictureBox6";
            this.pictureBox6.Size = new System.Drawing.Size(229, 91);
            this.pictureBox6.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pictureBox6.TabIndex = 18;
            this.pictureBox6.TabStop = false;
            this.pictureBox6.Visible = false;
            this.pictureBox6.Click += new System.EventHandler(this.pictureBox6_Click);
            // 
            // pbGuiasEnabled
            // 
            this.pbGuiasEnabled.Cursor = System.Windows.Forms.Cursors.Hand;
            this.pbGuiasEnabled.Image = global::InventStar.Properties.Resources.btn_success_guias;
            this.pbGuiasEnabled.Location = new System.Drawing.Point(435, 292);
            this.pbGuiasEnabled.Name = "pbGuiasEnabled";
            this.pbGuiasEnabled.Size = new System.Drawing.Size(229, 91);
            this.pbGuiasEnabled.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pbGuiasEnabled.TabIndex = 15;
            this.pbGuiasEnabled.TabStop = false;
            this.pbGuiasEnabled.Visible = false;
            this.pbGuiasEnabled.Click += new System.EventHandler(this.pbGuiasEnabled_Click);
            // 
            // pbInventarioEnabled
            // 
            this.pbInventarioEnabled.Cursor = System.Windows.Forms.Cursors.Hand;
            this.pbInventarioEnabled.Image = global::InventStar.Properties.Resources.btn_success_inventario;
            this.pbInventarioEnabled.Location = new System.Drawing.Point(297, 183);
            this.pbInventarioEnabled.Name = "pbInventarioEnabled";
            this.pbInventarioEnabled.Size = new System.Drawing.Size(229, 91);
            this.pbInventarioEnabled.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pbInventarioEnabled.TabIndex = 14;
            this.pbInventarioEnabled.TabStop = false;
            this.pbInventarioEnabled.Visible = false;
            this.pbInventarioEnabled.Click += new System.EventHandler(this.pbInventarioEnabled_Click);
            // 
            // pbClientesEnabled
            // 
            this.pbClientesEnabled.Cursor = System.Windows.Forms.Cursors.Hand;
            this.pbClientesEnabled.Image = global::InventStar.Properties.Resources.btn_success_clientes;
            this.pbClientesEnabled.Location = new System.Drawing.Point(130, 292);
            this.pbClientesEnabled.Name = "pbClientesEnabled";
            this.pbClientesEnabled.Size = new System.Drawing.Size(229, 91);
            this.pbClientesEnabled.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pbClientesEnabled.TabIndex = 13;
            this.pbClientesEnabled.TabStop = false;
            this.pbClientesEnabled.Visible = false;
            this.pbClientesEnabled.Click += new System.EventHandler(this.pbClientesEnabled_Click);
            // 
            // pbVentasEnabled
            // 
            this.pbVentasEnabled.Cursor = System.Windows.Forms.Cursors.Hand;
            this.pbVentasEnabled.Image = global::InventStar.Properties.Resources.btn_success_ventas;
            this.pbVentasEnabled.Location = new System.Drawing.Point(37, 183);
            this.pbVentasEnabled.Name = "pbVentasEnabled";
            this.pbVentasEnabled.Size = new System.Drawing.Size(229, 91);
            this.pbVentasEnabled.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pbVentasEnabled.TabIndex = 12;
            this.pbVentasEnabled.TabStop = false;
            this.pbVentasEnabled.Visible = false;
            this.pbVentasEnabled.Click += new System.EventHandler(this.pbVentasEnabled_Click);
            // 
            // lblInventario
            // 
            this.lblInventario.AutoSize = true;
            this.lblInventario.BackColor = System.Drawing.Color.Transparent;
            this.lblInventario.Cursor = System.Windows.Forms.Cursors.No;
            this.lblInventario.Font = new System.Drawing.Font("Microsoft Sans Serif", 20.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblInventario.Location = new System.Drawing.Point(346, 211);
            this.lblInventario.Name = "lblInventario";
            this.lblInventario.Size = new System.Drawing.Size(132, 37);
            this.lblInventario.TabIndex = 10;
            this.lblInventario.Text = "Inventario";
            this.lblInventario.UseCompatibleTextRendering = true;
            // 
            // lblGuias
            // 
            this.lblGuias.AutoSize = true;
            this.lblGuias.BackColor = System.Drawing.Color.Transparent;
            this.lblGuias.Cursor = System.Windows.Forms.Cursors.No;
            this.lblGuias.Font = new System.Drawing.Font("Microsoft Sans Serif", 20.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblGuias.Location = new System.Drawing.Point(509, 320);
            this.lblGuias.Name = "lblGuias";
            this.lblGuias.Size = new System.Drawing.Size(82, 37);
            this.lblGuias.TabIndex = 11;
            this.lblGuias.Text = "Guías";
            this.lblGuias.UseCompatibleTextRendering = true;
            // 
            // lblClientes
            // 
            this.lblClientes.AutoSize = true;
            this.lblClientes.BackColor = System.Drawing.Color.Transparent;
            this.lblClientes.Cursor = System.Windows.Forms.Cursors.No;
            this.lblClientes.Font = new System.Drawing.Font("Microsoft Sans Serif", 20.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblClientes.Location = new System.Drawing.Point(190, 320);
            this.lblClientes.Name = "lblClientes";
            this.lblClientes.Size = new System.Drawing.Size(110, 37);
            this.lblClientes.TabIndex = 9;
            this.lblClientes.Text = "Clientes";
            this.lblClientes.UseCompatibleTextRendering = true;
            // 
            // lblVentas
            // 
            this.lblVentas.AutoSize = true;
            this.lblVentas.BackColor = System.Drawing.Color.Transparent;
            this.lblVentas.Cursor = System.Windows.Forms.Cursors.No;
            this.lblVentas.Font = new System.Drawing.Font("Microsoft Sans Serif", 20.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblVentas.Location = new System.Drawing.Point(106, 211);
            this.lblVentas.Name = "lblVentas";
            this.lblVentas.Size = new System.Drawing.Size(96, 37);
            this.lblVentas.TabIndex = 8;
            this.lblVentas.Text = "Ventas";
            this.lblVentas.UseCompatibleTextRendering = true;
            // 
            // pbGuias
            // 
            this.pbGuias.Cursor = System.Windows.Forms.Cursors.No;
            this.pbGuias.Image = global::InventStar.Properties.Resources.round_rectangle___copia;
            this.pbGuias.Location = new System.Drawing.Point(435, 292);
            this.pbGuias.Name = "pbGuias";
            this.pbGuias.Size = new System.Drawing.Size(229, 91);
            this.pbGuias.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pbGuias.TabIndex = 6;
            this.pbGuias.TabStop = false;
            // 
            // pbInventario
            // 
            this.pbInventario.Cursor = System.Windows.Forms.Cursors.No;
            this.pbInventario.Image = global::InventStar.Properties.Resources.round_rectangle___copia;
            this.pbInventario.Location = new System.Drawing.Point(297, 183);
            this.pbInventario.Name = "pbInventario";
            this.pbInventario.Size = new System.Drawing.Size(229, 91);
            this.pbInventario.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pbInventario.TabIndex = 5;
            this.pbInventario.TabStop = false;
            // 
            // pbClientes
            // 
            this.pbClientes.Cursor = System.Windows.Forms.Cursors.No;
            this.pbClientes.Image = global::InventStar.Properties.Resources.round_rectangle___copia;
            this.pbClientes.Location = new System.Drawing.Point(130, 292);
            this.pbClientes.Name = "pbClientes";
            this.pbClientes.Size = new System.Drawing.Size(229, 91);
            this.pbClientes.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pbClientes.TabIndex = 4;
            this.pbClientes.TabStop = false;
            // 
            // pbVentas
            // 
            this.pbVentas.Cursor = System.Windows.Forms.Cursors.No;
            this.pbVentas.Image = global::InventStar.Properties.Resources.round_rectangle___copia;
            this.pbVentas.Location = new System.Drawing.Point(37, 183);
            this.pbVentas.Name = "pbVentas";
            this.pbVentas.Size = new System.Drawing.Size(229, 91);
            this.pbVentas.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pbVentas.TabIndex = 3;
            this.pbVentas.TabStop = false;
            // 
            // lblSede
            // 
            this.lblSede.AutoSize = true;
            this.lblSede.Font = new System.Drawing.Font("Microsoft Sans Serif", 24F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblSede.Location = new System.Drawing.Point(256, 92);
            this.lblSede.Name = "lblSede";
            this.lblSede.Size = new System.Drawing.Size(384, 44);
            this.lblSede.TabIndex = 2;
            this.lblSede.Text = "L a  R a m b l a   B r a s i l";
            this.lblSede.UseCompatibleTextRendering = true;
            // 
            // lblStarbucks
            // 
            this.lblStarbucks.Font = new System.Drawing.Font("Microsoft Sans Serif", 36F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblStarbucks.Location = new System.Drawing.Point(229, 32);
            this.lblStarbucks.Name = "lblStarbucks";
            this.lblStarbucks.Size = new System.Drawing.Size(435, 55);
            this.lblStarbucks.TabIndex = 1;
            this.lblStarbucks.Text = "S T A R B U C K S";
            this.lblStarbucks.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            this.lblStarbucks.UseCompatibleTextRendering = true;
            // 
            // pictureBox2
            // 
            this.pictureBox2.Image = global::InventStar.Properties.Resources.starbucks_logo_png_transparent;
            this.pictureBox2.Location = new System.Drawing.Point(105, 21);
            this.pictureBox2.Name = "pictureBox2";
            this.pictureBox2.Size = new System.Drawing.Size(128, 126);
            this.pictureBox2.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pictureBox2.TabIndex = 0;
            this.pictureBox2.TabStop = false;
            // 
            // pictureBox5
            // 
            this.pictureBox5.Cursor = System.Windows.Forms.Cursors.No;
            this.pictureBox5.Image = global::InventStar.Properties.Resources.round_rectangle___copia;
            this.pictureBox5.Location = new System.Drawing.Point(559, 183);
            this.pictureBox5.Name = "pictureBox5";
            this.pictureBox5.Size = new System.Drawing.Size(229, 91);
            this.pictureBox5.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pictureBox5.TabIndex = 19;
            this.pictureBox5.TabStop = false;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.BackColor = System.Drawing.Color.Transparent;
            this.label1.Cursor = System.Windows.Forms.Cursors.No;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 20.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(590, 211);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(167, 37);
            this.label1.TabIndex = 20;
            this.label1.Text = "Proveedores";
            this.label1.UseCompatibleTextRendering = true;
            // 
            // frmPaginaPrincipal
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 550);
            this.Controls.Add(this.pnlMain);
            this.Controls.Add(this.pnlHeader);
            this.Controls.Add(this.pnlBottom);
            this.Controls.Add(this.pnlTop);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
            this.Name = "frmPaginaPrincipal";
            this.Text = "Form1";
            this.pnlTop.ResumeLayout(false);
            this.pnlTop.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox3)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
            this.pnlBottom.ResumeLayout(false);
            this.pnlBottom.PerformLayout();
            this.pnlHeader.ResumeLayout(false);
            this.pnlHeader.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox4)).EndInit();
            this.pnlMain.ResumeLayout(false);
            this.pnlMain.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox6)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pbGuiasEnabled)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pbInventarioEnabled)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pbClientesEnabled)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pbVentasEnabled)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pbGuias)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pbInventario)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pbClientes)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pbVentas)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox2)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox5)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Panel pnlTop;
        private System.Windows.Forms.Panel pnlBottom;
        private System.Windows.Forms.Panel pnlHeader;
        private System.Windows.Forms.Panel pnlMain;
        private System.Windows.Forms.PictureBox pictureBox1;
        private System.Windows.Forms.Label lblFooter;
        private System.Windows.Forms.Label lblIniciarSesion;
        private System.Windows.Forms.Label lblPanel;
        private System.Windows.Forms.PictureBox pictureBox2;
        private System.Windows.Forms.Label lblStarbucks;
        private System.Windows.Forms.Label lblSede;
        private System.Windows.Forms.PictureBox pictureBox3;
        private System.Windows.Forms.PictureBox pbClientes;
        private System.Windows.Forms.PictureBox pbVentas;
        private System.Windows.Forms.PictureBox pbGuias;
        private System.Windows.Forms.PictureBox pbInventario;
        private System.Windows.Forms.Label lblGuias;
        private System.Windows.Forms.Label lblInventario;
        private System.Windows.Forms.Label lblClientes;
        private System.Windows.Forms.Label lblVentas;
        private System.Windows.Forms.Label lblUsuarioActual;
        private System.Windows.Forms.PictureBox pbVentasEnabled;
        private System.Windows.Forms.PictureBox pbClientesEnabled;
        private System.Windows.Forms.PictureBox pbInventarioEnabled;
        private System.Windows.Forms.PictureBox pbGuiasEnabled;
        private System.Windows.Forms.PictureBox pictureBox4;
        private System.Windows.Forms.PictureBox pictureBox6;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.PictureBox pictureBox5;
    }
}
