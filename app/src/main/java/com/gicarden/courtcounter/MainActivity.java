package com.gicarden.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override

        public void onClick(View v) {

            if (v.getId() == R.id.home_team_1point_bt) {
                scoreIncrement(1, (TextView) findViewById(R.id.home_team_score_tv)); }
            if (v.getId() == R.id.home_team_2point_bt) {
                scoreIncrement(2, (TextView) findViewById(R.id.home_team_score_tv)); }
            if (v.getId() == R.id.home_team_3point_bt) {
                scoreIncrement(3, (TextView) findViewById(R.id.home_team_score_tv)); }

            if (v.getId() == R.id.away_team_1point_bt) {
                scoreIncrement(1, (TextView) findViewById(R.id.away_team_score_tv)); }
            if (v.getId() == R.id.away_team_2point_bt) {
                scoreIncrement(2, (TextView) findViewById(R.id.away_team_score_tv)); }
            if (v.getId() == R.id.away_team_3point_bt) {
                scoreIncrement(3, (TextView) findViewById(R.id.away_team_score_tv)); }

            if (v.getId() == R.id.home_team_deduct_bt) {
                scoreDecrement(1, (TextView) findViewById(R.id.home_team_score_tv)); }

            if (v.getId() == R.id.away_team_deduct_bt) {
                scoreDecrement(1, (TextView) findViewById(R.id.away_team_score_tv)); }

            if (v.getId() == R.id.reset_bt) {
                resetScores((TextView) findViewById(R.id.home_team_score_tv),
                        (TextView) findViewById(R.id.away_team_score_tv));
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initButtonClickListeners();
    }

    /**
     * Private helper method to set OnClickListener on specific button views.
     */
    private void initButtonClickListeners () {

        findViewById(R.id.home_team_1point_bt).setOnClickListener(onClickListener);
        findViewById(R.id.home_team_2point_bt).setOnClickListener(onClickListener);
        findViewById(R.id.home_team_3point_bt).setOnClickListener(onClickListener);

        findViewById(R.id.away_team_1point_bt).setOnClickListener(onClickListener);
        findViewById(R.id.away_team_2point_bt).setOnClickListener(onClickListener);
        findViewById(R.id.away_team_3point_bt).setOnClickListener(onClickListener);

        findViewById(R.id.home_team_deduct_bt).setOnClickListener(onClickListener);
        findViewById(R.id.away_team_deduct_bt).setOnClickListener(onClickListener);

        findViewById(R.id.reset_bt).setOnClickListener(onClickListener);
    }

    /**
     * Private helper method that will increment the score value of a specific TextView.
     *
     * @param score to add.
     * @param textView to update value.
     */
    private void scoreIncrement(int score, TextView textView) {

        int temp = Integer.parseInt(textView.getText().toString());
        temp += score;
        textView.setText(String.valueOf(temp));
    }

    /**
     * Private helper method that will decrement the score value of a specific TextView.
     *
     * @param score to deduct.
     * @param textView to update
     */
    private void scoreDecrement(int score, TextView textView) {

        int temp = Integer.parseInt(textView.getText().toString());

        if (temp != 0) {

            temp -= score;
            textView.setText(String.valueOf(temp));
        } else {

            Toast.makeText(this, R.string.deduct_from_zero, Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Private helper method that will reset the score values of specific TextViews.
     *
     * @param home to reset.
     * @param away to reset.
     */
    private void resetScores(TextView home, TextView away) {

        home.setText(R.string.initial_score_value);
        away.setText(R.string.initial_score_value);
    }

}//End of Class.
