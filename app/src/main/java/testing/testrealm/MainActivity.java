package testing.testrealm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView output;    //output textView of the grand total
    EditText topNum;
    EditText middleNum;
    EditText bottomNum;
    int total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        topNum = (EditText) findViewById(R.id.editText);
        middleNum = (EditText) findViewById(R.id.editText2);
        bottomNum = (EditText) findViewById(R.id.editText3);

        textListener(topNum);
        textListener(middleNum);
        textListener(bottomNum);

    }
    public void textListener(EditText editTextObject) {
        editTextObject.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                sumOfAllFields();
                displayTotal();
            }
        });
    }

    public void sumOfAllFields(){
        total = getIntOfInput(topNum) + getIntOfInput(middleNum) + getIntOfInput(bottomNum);
    }
        public int getIntOfInput(EditText number){
            return number.getText().toString().equals("") ? 0 : Integer.parseInt(number.getText().toString());
        }
    public void displayTotal() {
        output = (TextView)findViewById(R.id.total);
        String convertedTotal = String.valueOf(total);
        output.setText(convertedTotal);

    }



    public void theToasting(CharSequence message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
    public void theToasting(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

}
