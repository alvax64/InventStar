namespace InventStar
{
    partial class frmInicioSinPassword
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.lblPanel = new System.Windows.Forms.Label();
            this.pnlHeader = new System.Windows.Forms.Panel();
            this.pnlTop = new System.Windows.Forms.Panel();
            this.panel1 = new System.Windows.Forms.Panel();
            this.lblIndicacion1 = new System.Windows.Forms.Label();
            this.lblIndicacion2 = new System.Windows.Forms.Label();
            this.txtCodigo = new System.Windows.Forms.TextBox();
            this.lblIngresarCodigo = new System.Windows.Forms.Label();
            this.pbContinuar = new System.Windows.Forms.PictureBox();
            this.pictureBox1 = new System.Windows.Forms.PictureBox();
            this.pnlHeader.SuspendLayout();
            this.pnlTop.SuspendLayout();
            this.panel1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pbContinuar)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
            this.SuspendLayout();
            // 
            // lblPanel
            // 
            this.lblPanel.AutoSize = true;
            this.lblPanel.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblPanel.Location = new System.Drawing.Point(307, 9);
            this.lblPanel.Name = "lblPanel";
            this.lblPanel.Size = new System.Drawing.Size(190, 24);
            this.lblPanel.TabIndex = 0;
            this.lblPanel.Text = "I N I C I A R   S E S I Ó N";
            this.lblPanel.UseCompatibleTextRendering = true;
            // 
            // pnlHeader
            // 
            this.pnlHeader.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(132)))), ((int)(((byte)(142)))), ((int)(((byte)(136)))));
            this.pnlHeader.Controls.Add(this.lblPanel);
            this.pnlHeader.Dock = System.Windows.Forms.DockStyle.Top;
            this.pnlHeader.Location = new System.Drawing.Point(0, 61);
            this.pnlHeader.Name = "pnlHeader";
            this.pnlHeader.Size = new System.Drawing.Size(800, 36);
            this.pnlHeader.TabIndex = 6;
            // 
            // pnlTop
            // 
            this.pnlTop.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(22)))), ((int)(((byte)(44)))), ((int)(((byte)(38)))));
            this.pnlTop.Controls.Add(this.pictureBox1);
            this.pnlTop.Dock = System.Windows.Forms.DockStyle.Top;
            this.pnlTop.Location = new System.Drawing.Point(0, 0);
            this.pnlTop.Name = "pnlTop";
            this.pnlTop.Size = new System.Drawing.Size(800, 61);
            this.pnlTop.TabIndex = 5;
            this.pnlTop.MouseDown += new System.Windows.Forms.MouseEventHandler(this.pnlTop_MouseDown);
            // 
            // panel1
            // 
            this.panel1.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(242)))), ((int)(((byte)(240)))), ((int)(((byte)(235)))));
            this.panel1.Controls.Add(this.pbContinuar);
            this.panel1.Controls.Add(this.lblIngresarCodigo);
            this.panel1.Controls.Add(this.txtCodigo);
            this.panel1.Controls.Add(this.lblIndicacion2);
            this.panel1.Controls.Add(this.lblIndicacion1);
            this.panel1.Cursor = System.Windows.Forms.Cursors.Arrow;
            this.panel1.Dock = System.Windows.Forms.DockStyle.Fill;
            this.panel1.Location = new System.Drawing.Point(0, 97);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(800, 453);
            this.panel1.TabIndex = 7;
            // 
            // lblIndicacion1
            // 
            this.lblIndicacion1.AutoSize = true;
            this.lblIndicacion1.Font = new System.Drawing.Font("Microsoft Sans Serif", 20.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblIndicacion1.Location = new System.Drawing.Point(237, 61);
            this.lblIndicacion1.Name = "lblIndicacion1";
            this.lblIndicacion1.Size = new System.Drawing.Size(314, 37);
            this.lblIndicacion1.TabIndex = 0;
            this.lblIndicacion1.Text = "SE LE HA ENVIADO UN";
            this.lblIndicacion1.UseCompatibleTextRendering = true;
            // 
            // lblIndicacion2
            // 
            this.lblIndicacion2.AutoSize = true;
            this.lblIndicacion2.Font = new System.Drawing.Font("Microsoft Sans Serif", 20.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblIndicacion2.Location = new System.Drawing.Point(237, 98);
            this.lblIndicacion2.Name = "lblIndicacion2";
            this.lblIndicacion2.Size = new System.Drawing.Size(319, 37);
            this.lblIndicacion2.TabIndex = 1;
            this.lblIndicacion2.Text = "CÓDIGO POR CORREO";
            this.lblIndicacion2.UseCompatibleTextRendering = true;
            // 
            // txtCodigo
            // 
            this.txtCodigo.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txtCodigo.Location = new System.Drawing.Point(253, 198);
            this.txtCodigo.Name = "txtCodigo";
            this.txtCodigo.Size = new System.Drawing.Size(279, 26);
            this.txtCodigo.TabIndex = 13;
            // 
            // lblIngresarCodigo
            // 
            this.lblIngresarCodigo.AutoSize = true;
            this.lblIngresarCodigo.Location = new System.Drawing.Point(250, 172);
            this.lblIngresarCodigo.Name = "lblIngresarCodigo";
            this.lblIngresarCodigo.Size = new System.Drawing.Size(142, 17);
            this.lblIngresarCodigo.TabIndex = 14;
            this.lblIngresarCodigo.Text = "Por favor, ingrese el código";
            this.lblIngresarCodigo.UseCompatibleTextRendering = true;
            // 
            // pbContinuar
            // 
            this.pbContinuar.Cursor = System.Windows.Forms.Cursors.Hand;
            this.pbContinuar.Image = global::InventStar.Properties.Resources.btn_continue;
            this.pbContinuar.Location = new System.Drawing.Point(332, 272);
            this.pbContinuar.Name = "pbContinuar";
            this.pbContinuar.Size = new System.Drawing.Size(119, 38);
            this.pbContinuar.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pbContinuar.TabIndex = 15;
            this.pbContinuar.TabStop = false;
            this.pbContinuar.Click += new System.EventHandler(this.pbContinuar_Click);
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
            // frmInicioSinPassword
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 550);
            this.Controls.Add(this.panel1);
            this.Controls.Add(this.pnlHeader);
            this.Controls.Add(this.pnlTop);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
            this.Name = "frmInicioSinPassword";
            this.Text = "frmInicioSinPassword";
            this.pnlHeader.ResumeLayout(false);
            this.pnlHeader.PerformLayout();
            this.pnlTop.ResumeLayout(false);
            this.panel1.ResumeLayout(false);
            this.panel1.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pbContinuar)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Label lblPanel;
        private System.Windows.Forms.Panel pnlHeader;
        private System.Windows.Forms.Panel pnlTop;
        private System.Windows.Forms.PictureBox pictureBox1;
        private System.Windows.Forms.Panel panel1;
        private System.Windows.Forms.Label lblIndicacion2;
        private System.Windows.Forms.Label lblIndicacion1;
        private System.Windows.Forms.PictureBox pbContinuar;
        private System.Windows.Forms.Label lblIngresarCodigo;
        private System.Windows.Forms.TextBox txtCodigo;
    }
}