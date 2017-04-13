package com.example.tennispointcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.lang.*;

public class MainActivity extends AppCompatActivity {
    int GameScorePlayer1 = 0;
    int GameScorePlayer2 = 0;
    int GamesPlayer1 = 0;
    int GamesPlayer2 = 0;
    int setPlayer1 = 0;
    int setPlayer2 = 0;
    int setLength = 6;
    boolean TieBreak = false;
    private String[] gamePoints = {
            "0",
            "15",
            "30",
            "40",
            "AD"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void setCheck() {
        if (setPlayer1 == 2 & setPlayer2 < 2) {
            EditText edit_text1   = (EditText)findViewById(R.id.player1);
            displayScorePlayer1("Winner " + edit_text1.getText().toString());
        }
        else if (setPlayer2 == 2 & setPlayer1 < 2) {
            EditText edit_text2   = (EditText)findViewById(R.id.player2);
            displayScorePlayer2("Winner " + edit_text2.getText().toString());
        } else {
            if (GamesPlayer1 == 6 & GamesPlayer2 <= 4) {
                setPlayer1 = setPlayer1 + 1;
                GamesPlayer1 = 0;
                GamesPlayer2 = 0;
            } else if (GamesPlayer2 == 6 & GamesPlayer1 <= 4) {
                setPlayer2 = setPlayer2 + 1;
                GamesPlayer1 = 0;
                GamesPlayer2 = 0;
            } else if (GamesPlayer1 >= 5 & GamesPlayer2 >= 5) {
                setLength = 7;
                if (GamesPlayer1 == 7 & GamesPlayer2 == 5) {
                    setPlayer1 = setPlayer1 + 1;
                    GamesPlayer1 = 0;
                    GamesPlayer2 = 0;
                } else if (GamesPlayer2 == 7 & GamesPlayer1 == 5) {
                    setPlayer2 = setPlayer2 + 1;
                    GamesPlayer1 = 0;
                    GamesPlayer2 = 0;
                } else if (GamesPlayer1 == 6 & GamesPlayer2 == 6) {
                    TieBreak = true;
                }
            }
    }
    }
    //Methods for application:
    public void GameCheck() {
        if (TieBreak) {
            if(GameScorePlayer1==7 & GameScorePlayer2 <=5){
                setPlayer1 = ++setPlayer1;
                TieBreak = false;
                GameScorePlayer1=0;
                GameScorePlayer2=0;
                GamesPlayer1=0;
                GamesPlayer2=0;
            }else if( GameScorePlayer2==7 & GameScorePlayer1 <=5){
                setPlayer2 = ++setPlayer2;
                TieBreak = false;
                GameScorePlayer1=0;
                GameScorePlayer2=0;
                GamesPlayer1=0;
                GamesPlayer2=0;}
            else if (GameScorePlayer1>=6 & GameScorePlayer2>=6){
                    if(GameScorePlayer1-GameScorePlayer2 ==2){
                        setPlayer1 = ++setPlayer1;
                        TieBreak=false;
                        GameScorePlayer1=0;
                        GameScorePlayer2=0;
                        GamesPlayer1=0;
                        GamesPlayer2=0;
                    }
                    else if(GameScorePlayer2-GameScorePlayer1 ==2){
                        setPlayer2 = ++setPlayer2;
                        TieBreak=false;
                        GameScorePlayer1=0;
                        GameScorePlayer2=0;
                        GamesPlayer1=0;
                        GamesPlayer2=0;
                    }
            }
            displayGamePlayer2TB(GameScorePlayer2);
            displayGamePlayer1TB(GameScorePlayer1);
        }
        else{
            if (GameScorePlayer2 == 4 & GameScorePlayer1 <= 2) {
                GameScorePlayer1 = 0;
                GameScorePlayer2 = 0;
                GamesPlayer2 = GamesPlayer2 + 1;
            } else if (GameScorePlayer1 == 4 & GameScorePlayer2 <= 2) {
                GameScorePlayer1 = 0;
                GameScorePlayer2 = 0;
                GamesPlayer1 = GamesPlayer1 + 1;
            } else if (GameScorePlayer1 + GameScorePlayer2 > 7) {
                if (GameScorePlayer1 == GameScorePlayer2) {
                    GameScorePlayer1 = 3;
                    GameScorePlayer2 = 3;
                } else if (GameScorePlayer1 - GameScorePlayer2 == 2 | GameScorePlayer1 - GameScorePlayer2 == -2) {
                    if (GameScorePlayer1 > GameScorePlayer2) {
                        GamesPlayer1 = GamesPlayer1 + 1;
                    } else {
                        GamesPlayer2 = GamesPlayer2 + 1;
                    }
                    GameScorePlayer1 = 0;
                    GameScorePlayer2 = 0;
                }
            }
            displayScorePlayer1(gamePoints[GameScorePlayer1]);
            displayScorePlayer2(gamePoints[GameScorePlayer2]);
            displayGamePlayer1(GamesPlayer1);
            displayGamePlayer2(GamesPlayer2);
            displaySetPlayer2(setPlayer2);
            displaySetPlayer1(setPlayer1);
        }
    }
    public void addOnePointPlayer1(View v) {
        GameScorePlayer1 = GameScorePlayer1 + 1;
        GameCheck();
        setCheck();
    }
    public void addOnePointPlayer2(View v) {
        GameScorePlayer2 = GameScorePlayer2 + 1;
        GameCheck();
        setCheck();
         };
    //Display methods
    public void displaySetPlayer1(int score){
        TextView scoreView = (TextView) findViewById(R.id.sets1);
        scoreView.setText(String.valueOf(setPlayer1));}
        //method for calculating the set score of Player2
    public void displaySetPlayer2(int score) {
        TextView scoreView = (TextView) findViewById(R.id.sets2);
        scoreView.setText(String.valueOf(setPlayer2));
    }
    //method for calculating the score of the Game Player1
    public void displayGamePlayer1(int score) {
        TextView scoreView = (TextView) findViewById(R.id.Games1);
        scoreView.setText(String.valueOf(GamesPlayer1));
    }
    //method for calculating the score of the Game Player2
    public void displayGamePlayer2(int score) {
        TextView scoreView = (TextView) findViewById(R.id.Games2);
        scoreView.setText(String.valueOf(GamesPlayer2));
    }
    //method for calculating the score of the Game Player1
    public void displayScorePlayer1(String score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(score);
    }
    //method for calculating the score of the Game Player2
    public void displayScorePlayer2(String score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(score);
    }
    public void displayGamePlayer1TB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }
    //method for calculating the score of the Game Player2
    public void displayGamePlayer2TB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }
    public void erase(View v) {
        GameScorePlayer1 = 0;
        GameScorePlayer2 = 0;
        GamesPlayer1 = 0;
        GamesPlayer2 = 0;
        setPlayer1 = 0;
        setPlayer2 = 0;
        displayScorePlayer1(gamePoints[GameScorePlayer1]);
        displayScorePlayer2(gamePoints[GameScorePlayer2]);
        displayGamePlayer1(GamesPlayer1);
        displayGamePlayer2(GamesPlayer2);
        displaySetPlayer2(setPlayer2);
        displaySetPlayer1(setPlayer1);
    }
}




