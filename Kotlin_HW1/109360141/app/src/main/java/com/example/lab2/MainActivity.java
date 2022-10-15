package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
        private EditText gamer;
        private TextView status, name, winner, mmora, cmora;
        private RadioButton scissor, stone, paper;
        private Button btn_mora;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
                //連結xml的元件
            gamer = findViewById(R.id.gamer);
            status = findViewById(R.id.status);
            winner = findViewById(R.id.winner);
            name = findViewById(R.id.name);
            mmora = findViewById(R.id.mmora);
            cmora = findViewById(R.id.cmora);
            scissor = findViewById(R.id.scissor);
            stone = findViewById(R.id.stone);
            paper = findViewById(R.id.paper);
            btn_mora = findViewById(R.id.btn_mora);

            btn_mora.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        //判斷字串是否是空白來要求輸入姓名
                    if(gamer.length()<1)
                        status.setText("請輸入玩家姓名");
                    else {
                            //顯示玩家姓名與我方出拳
                        name.setText(String.format("名字\n%s",
                                        gamer.getText().toString()));
                        if (scissor.isChecked())
                            mmora.setText("我方出拳\n剪刀");
                        else if (stone.isChecked())
                            mmora.setText("我方出拳\n石頭");
                        else
                            mmora.setText("我方出拳\n布");
                            //Random0產生介於0~1間不含1的亂數,乘3產生0~2当作電腦的出拳
                        int computer = (int) (Math.random() * 3);
                        if (computer == 0)
                                    cmora.setText("電腦出拳\n剪刀");
                        else if (computer == 1)
                                    cmora.setText("電腦出拳\n石頭");
                        else
                                    cmora.setText("電腦出拳\n布");
                            //用三個判斷式判斷並顯示猜拳結果
                        if ((scissor.isChecked() && computer == 2) ||
                                    (stone.isChecked() && computer == 0) ||
                                    (paper.isChecked() && computer == 1)) {
                                    winner.setText("勝利者\n" +
                                            gamer.getText().toString());
                                    status.setText("恭喜你獲勝了!!!");
                            } else if ((scissor.isChecked() && computer == 1) ||
                            (stone.isChecked() && computer == 2) ||
                            (paper.isChecked() && computer == 0)){
                            winner.setText("勝利者\n電腦");
                            status.setText("可惜,電腦獲勝了!");
                    }else{
                        winner.setText("勝利者\n平手");
                        status.setText("平局,請再試一次!");
                                }
                                }
                        }
                });
        }
}