package com.example.lab2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.widget.TextView
import android.widget.RadioButton
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.lab2.R

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //連結xml的元件
        val gamer = findViewById<EditText>(R.id.gamer)
        val status = findViewById<TextView>(R.id.status)
        val winner = findViewById<TextView>(R.id.winner)
        val name = findViewById<TextView>(R.id.name)
        val mmora = findViewById<TextView>(R.id.mmora)
        val cmora = findViewById<TextView>(R.id.cmora)
        val scissor = findViewById<RadioButton>(R.id.scissor)
        val stone = findViewById<RadioButton>(R.id.stone)
        val paper = findViewById<RadioButton>(R.id.paper)
        val btn_mora = findViewById<Button>(R.id.btn_mora)
        btn_mora.setOnClickListener {
            //判斷字串是否是空白來要求輸入姓名
            if (gamer.length() < 1) status.setText("請輸入玩家姓名") else {
                //顯示玩家姓名與我方出拳
                val playername = gamer.text
                name.setText("名字\n$playername")
                if (scissor.isChecked()) mmora.setText("我方出拳\n剪刀")
                else if (stone.isChecked()) mmora.setText("我方出拳\n石頭")
                else mmora.setText("我方出拳\n布")
                //Random0產生介於0~1間不含1的亂數,乘3產生0~2当作電腦的出拳
                val computer = (Math.random() * 3).toInt()
                if (computer == 0) cmora.setText("電腦出拳\n剪刀")
                else if (computer == 1) cmora.setText("電腦出拳\n石頭")
                else cmora.setText("電腦出拳\n布")
                //用三個判斷式判斷並顯示猜拳結果
                if (scissor.isChecked() && computer == 2 ||
                        stone.isChecked() && computer == 0 ||
                        paper.isChecked() && computer == 1) {
                    winner.setText("勝利者\n$playername")
                    status.setText("恭喜你獲勝了!!!")
                } else if (scissor.isChecked() && computer == 1 ||
                        stone.isChecked() && computer == 2 ||
                        paper.isChecked() && computer == 0) {
                    winner.setText("勝利者\n電腦")
                    status.setText("可惜,電腦獲勝了!")
                } else {
                    winner.setText("勝利者\n平手")
                    status.setText("平局,請再試一次!")
                }
            }
        }
    }
}