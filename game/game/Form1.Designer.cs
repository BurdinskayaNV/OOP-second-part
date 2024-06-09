namespace game
{
    partial class Form1
    {
        /// <summary>
        /// Обязательная переменная конструктора.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Освободить все используемые ресурсы.
        /// </summary>
        /// <param name="disposing">истинно, если управляемый ресурс должен быть удален; иначе ложно.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Код, автоматически созданный конструктором форм Windows

        /// <summary>
        /// Требуемый метод для поддержки конструктора — не изменяйте 
        /// содержимое этого метода с помощью редактора кода.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Form1));
            this.timer = new System.Windows.Forms.Timer(this.components);
            this.player = new System.Windows.Forms.PictureBox();
            this.pg2 = new System.Windows.Forms.PictureBox();
            this.opponent1 = new System.Windows.Forms.PictureBox();
            this.opponent2 = new System.Windows.Forms.PictureBox();
            this.pg1 = new System.Windows.Forms.PictureBox();
            this.labelLose = new System.Windows.Forms.Label();
            this.button = new System.Windows.Forms.Button();
            this.money = new System.Windows.Forms.PictureBox();
            this.label = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.player)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pg2)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.opponent1)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.opponent2)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pg1)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.money)).BeginInit();
            this.SuspendLayout();
            // 
            // timer
            // 
            this.timer.Enabled = true;
            this.timer.Interval = 20;
            this.timer.Tick += new System.EventHandler(this.Timer_Tick);
            // 
            // player
            // 
            this.player.BackColor = System.Drawing.Color.Transparent;
            this.player.Image = ((System.Drawing.Image)(resources.GetObject("player.Image")));
            this.player.Location = new System.Drawing.Point(430, 600);
            this.player.Name = "player";
            this.player.Size = new System.Drawing.Size(70, 150);
            this.player.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.player.TabIndex = 1;
            this.player.TabStop = false;
            // 
            // pg2
            // 
            this.pg2.BackColor = System.Drawing.Color.Transparent;
            this.pg2.Image = ((System.Drawing.Image)(resources.GetObject("pg2.Image")));
            this.pg2.Location = new System.Drawing.Point(0, -850);
            this.pg2.Name = "pg2";
            this.pg2.Size = new System.Drawing.Size(840, 850);
            this.pg2.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pg2.TabIndex = 2;
            this.pg2.TabStop = false;
            // 
            // opponent1
            // 
            this.opponent1.BackColor = System.Drawing.Color.Transparent;
            this.opponent1.Image = ((System.Drawing.Image)(resources.GetObject("opponent1.Image")));
            this.opponent1.Location = new System.Drawing.Point(180, -150);
            this.opponent1.Name = "opponent1";
            this.opponent1.Size = new System.Drawing.Size(70, 150);
            this.opponent1.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.opponent1.TabIndex = 3;
            this.opponent1.TabStop = false;
            // 
            // opponent2
            // 
            this.opponent2.BackColor = System.Drawing.Color.Transparent;
            this.opponent2.Image = ((System.Drawing.Image)(resources.GetObject("opponent2.Image")));
            this.opponent2.Location = new System.Drawing.Point(590, -400);
            this.opponent2.Name = "opponent2";
            this.opponent2.Size = new System.Drawing.Size(70, 150);
            this.opponent2.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.opponent2.TabIndex = 4;
            this.opponent2.TabStop = false;
            // 
            // pg1
            // 
            this.pg1.BackColor = System.Drawing.Color.Transparent;
            this.pg1.Image = ((System.Drawing.Image)(resources.GetObject("pg1.Image")));
            this.pg1.Location = new System.Drawing.Point(0, 0);
            this.pg1.Name = "pg1";
            this.pg1.Size = new System.Drawing.Size(840, 850);
            this.pg1.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pg1.TabIndex = 0;
            this.pg1.TabStop = false;
            // 
            // labelLose
            // 
            this.labelLose.AutoSize = true;
            this.labelLose.BackColor = System.Drawing.Color.RosyBrown;
            this.labelLose.Font = new System.Drawing.Font("Times New Roman", 26.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.labelLose.ForeColor = System.Drawing.SystemColors.ButtonFace;
            this.labelLose.Location = new System.Drawing.Point(320, 200);
            this.labelLose.Name = "labelLose";
            this.labelLose.Size = new System.Drawing.Size(247, 40);
            this.labelLose.TabIndex = 5;
            this.labelLose.Text = "Вы проиграли";
            // 
            // button
            // 
            this.button.BackColor = System.Drawing.Color.IndianRed;
            this.button.FlatStyle = System.Windows.Forms.FlatStyle.Popup;
            this.button.Font = new System.Drawing.Font("Times New Roman", 21.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.button.ForeColor = System.Drawing.SystemColors.ButtonFace;
            this.button.Location = new System.Drawing.Point(330, 295);
            this.button.Name = "button";
            this.button.Size = new System.Drawing.Size(220, 45);
            this.button.TabIndex = 6;
            this.button.Text = "Перезапустить";
            this.button.UseVisualStyleBackColor = false;
            this.button.Click += new System.EventHandler(this.button_Click);
            // 
            // money
            // 
            this.money.Image = ((System.Drawing.Image)(resources.GetObject("money.Image")));
            this.money.Location = new System.Drawing.Point(430, -550);
            this.money.Name = "money";
            this.money.Size = new System.Drawing.Size(40, 40);
            this.money.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.money.TabIndex = 7;
            this.money.TabStop = false;
            // 
            // label
            // 
            this.label.AutoSize = true;
            this.label.BackColor = System.Drawing.Color.White;
            this.label.Font = new System.Drawing.Font("Times New Roman", 18F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.label.ForeColor = System.Drawing.SystemColors.ActiveCaptionText;
            this.label.Location = new System.Drawing.Point(148, 9);
            this.label.Name = "label";
            this.label.Size = new System.Drawing.Size(134, 26);
            this.label.TabIndex = 8;
            this.label.Text = "Монеты : 0";
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.ControlDarkDark;
            this.ClientSize = new System.Drawing.Size(840, 850);
            this.Controls.Add(this.label);
            this.Controls.Add(this.money);
            this.Controls.Add(this.button);
            this.Controls.Add(this.labelLose);
            this.Controls.Add(this.opponent2);
            this.Controls.Add(this.opponent1);
            this.Controls.Add(this.player);
            this.Controls.Add(this.pg1);
            this.Controls.Add(this.pg2);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
            this.Name = "Form1";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Машинка";
            this.KeyDown += new System.Windows.Forms.KeyEventHandler(this.Form1_KeyDown);
            this.KeyPress += new System.Windows.Forms.KeyPressEventHandler(this.Form1_KeyPress);
            ((System.ComponentModel.ISupportInitialize)(this.player)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pg2)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.opponent1)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.opponent2)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pg1)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.money)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion
        private System.Windows.Forms.Timer timer;
        private System.Windows.Forms.PictureBox player;
        private System.Windows.Forms.PictureBox pg2;
        private System.Windows.Forms.PictureBox opponent1;
        private System.Windows.Forms.PictureBox opponent2;
        private System.Windows.Forms.PictureBox pg1;
        private System.Windows.Forms.Label labelLose;
        private System.Windows.Forms.Button button;
        private System.Windows.Forms.PictureBox money;
        private System.Windows.Forms.Label label;
    }
}

