package practicaltest01.eim.systems.cs.pub.ro.practicaltest01var06;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class PracticalTest01Var02PlayActivity extends AppCompatActivity {
    int getValue;
    Random rand = new Random();
    TextView guessTextView = null;
    Button generateButton = null;
    Button checkButton = null;
    Button backButton = null;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            int res = 0, upNumber, downNumber;
            switch(view.getId()) {
                case R.id.generate_button:
                    int random = rand.nextInt(10);

                    guessTextView.setText(String.valueOf(random));
                    /*try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    guessTextView.setText(String.valueOf(0));
                    */
                    break;
                /*case R.id.navigate_button:
                    Intent intent = new Intent(getApplicationContext(), PracticalTest01Var06ChooseNumber.class);
                    int numberOfClicks = Integer.parseInt(upEditText.getText().toString()) +
                            Integer.parseInt(downEditText.getText().toString());
                    intent.putExtra("numberOfClicks", numberOfClicks);
                    startActivityForResult(intent, SECONDARY_ACTIVITY_REQUEST_CODE);
                    break;
                    */

            }
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var02_play);

        guessTextView = (TextView) findViewById(R.id.guess);
        /*Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey("number")) {
            getValue = intent.getIntExtra("number", -1);

        }
        */

        generateButton = (Button) findViewById(R.id.generate_button);
        generateButton.setOnClickListener(buttonClickListener);
        checkButton = (Button) findViewById(R.id.check_button);
        checkButton.setOnClickListener(buttonClickListener);

        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey("guess")) {
                guessTextView.setText(savedInstanceState.getString("guess"));
            } else {
                guessTextView.setText(String.valueOf(0));
            }
        } else {
            guessTextView.setText(String.valueOf(0));
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("guess", guessTextView.getText().toString());
//        savedInstanceState.putString("downCount", downEditText.getText().toString());
//        savedInstanceState.putString("result", result.getText().toString());


    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState.containsKey("guess")) {
            guessTextView.setText(savedInstanceState.getString("guess"));
        } else {
            guessTextView.setText(String.valueOf(0));
        }
        Toast.makeText(getApplication(), savedInstanceState.getString("guess"), Toast.LENGTH_LONG).show();
    }

}
