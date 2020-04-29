package com.app.hunterkill.fishrun;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class GameOverAcitvity extends AppCompatActivity {

    private Button gameStartAgain;
    private TextView txtViewScore;
    private String score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);


        score = getIntent().getExtras().get("score").toString();

        gameStartAgain= (Button) findViewById(R.id.btn_play_again);
        txtViewScore = (TextView) findViewById(R.id.txtViewScore);

        gameStartAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(GameOverAcitvity.this, MainActivity.class);
                startActivity(mainIntent);
            }
        });

        txtViewScore.setText( "" + score);
    }
}
