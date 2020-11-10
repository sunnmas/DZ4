package com.example.dz4;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvInfo;
    EditText etInput;
    Button bControl;
    int guess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvInfo = (TextView)findViewById(R.id.result);
        bControl = (Button)findViewById(R.id.check);
        etInput = (EditText)findViewById(R.id.input);
        etInput.setFilters(new InputFilter[]{ new InputFilterMinMax("1", "100")});
        etInput.setText("1");
        genNewValue();
    }

    //генерируем число от 1 до 100
    protected void genNewValue() {
        guess = (int)(Math.random()*100)+1;
    }

    public void checkResult(View v) {
        if (etInput.getText().length() == 0) {
            etInput.setText("1");
        }
        int val = Integer.parseInt(etInput.getText().toString());

        if (guess > val) {
            tvInfo.setText(R.string.behind);
            bControl.setText(R.string.input_value);
        } else if (guess < val) {
            tvInfo.setText(R.string.ahead);
            bControl.setText(R.string.input_value);
        } else {
            tvInfo.setText(R.string.hit);
            bControl.setText(R.string.play_more);
            genNewValue();
        }
    }
}
