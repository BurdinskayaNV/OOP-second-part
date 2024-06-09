using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace game
{
    public partial class Form1 : Form
    {
        private bool lose = false;
        private int kol = 0;
        public Form1()
        {
            InitializeComponent();
            labelLose.Visible = false;
            button.Visible = false;
            KeyPreview = true;
        }

        private void Form1_KeyPress(object sender, KeyPressEventArgs e)
        {
            if (e.KeyChar == (char)Keys.Escape)
                this.Close();
        }

        private void Timer_Tick(object sender, EventArgs e)
        {
            int speed = 10;
            pg1.Top += speed; pg2.Top += speed;
            money.Top += speed;

            if (pg1.Top >= 850)
            {
                pg1.Top = 0;
                pg2.Top = -850;
            }

            if (money.Top >= 850)
            {
                money.Top = -50;
                Random random = new Random();
                money.Left = random.Next(150, 590);
            }

            int speedOpp = 7;
            opponent1.Top += speedOpp;
            opponent2.Top += speedOpp;
            if (opponent1.Top >= 850)
            {
                opponent1.Top = -150;
                Random random = new Random();
                opponent1.Left = random.Next(150, 400);
            }
            if (opponent2.Top >= 850)
            {
                opponent2.Top = -400;
                Random random = new Random();
                opponent2.Left = random.Next(420, 590);
            }

            if (player.Bounds.IntersectsWith(opponent1.Bounds)
                || player.Bounds.IntersectsWith(opponent2.Bounds))
            {
                timer.Enabled = false;
                labelLose.Visible = true;
                button.Visible = true;
                lose = true;
            }

            if (player.Bounds.IntersectsWith(money.Bounds))
            {
                kol++;
                label.Text = "Монеты : " + kol.ToString();
                money.Top = -50;
                Random random = new Random();
                money.Left = random.Next(150, 590);
            }

        }
        private void Form1_KeyDown(object sender, KeyEventArgs e)
        {
            if (lose) return;
            int speed = 10;
            if (e.KeyCode == Keys.Left && player.Left > 150)
                player.Left -= speed;
            else if (e.KeyCode == Keys.Right && player.Right < 700)
                player.Left += speed;
        }

        private void button_Click(object sender, EventArgs e)
        {
            opponent1.Top = -150;
            opponent2.Top = -400;
            labelLose.Visible = false;
            button.Visible = false;
            timer.Enabled = true;
            lose = false;
            kol = 0;
            label.Text = "Монеты : 0";
            money.Top = -550;
        }
    }
}

