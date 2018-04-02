package practicaltest01.eim.systems.cs.pub.ro.practicaltest01var06;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PracticalTest01Var03ChooseNumber extends AppCompatActivity {
    private EditText no = null;

    private final static int SECONDARY_ACTIVITY_REQUEST_CODE = 1;
    private Button navigateToSecondaryActivityButton = null;

    public static boolean isNumeric(String str)
    {
        return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            int res = 0, upNumber, downNumber;
            switch(view.getId()) {
                case R.id.navigate_button:
                    if (!isNumeric(no.getText().toString())) {
                        break;
                    }

                    Intent intent = new Intent(getApplicationContext(), PracticalTest01Var02PlayActivity.class);
                    int number = Integer.parseInt(no.getText().toString());

                    //intent.putExtra("number", number);
                    startActivityForResult(intent, SECONDARY_ACTIVITY_REQUEST_CODE);
                    break;
            }
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var03_choose_number);

        no = (EditText) findViewById(R.id.left_edit_text);
        no.setText(String.valueOf(0));

        navigateToSecondaryActivityButton = (Button)findViewById(R.id.navigate_button);
        navigateToSecondaryActivityButton.setOnClickListener(buttonClickListener);
    }
}
