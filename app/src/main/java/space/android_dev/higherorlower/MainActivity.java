package space.android_dev.higherorlower;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int correctGuess;

    public void guessFunction (View view) {

        EditText insertedNumber = (EditText) findViewById(R.id.numberField);
        String inNumber = insertedNumber.getText().toString();
        if (inNumber.isEmpty()){
            Toast.makeText(getApplicationContext(), "Nothing inserted !", Toast.LENGTH_SHORT).show();
        }  else {

            int insertedNumberInt = Integer.parseInt(insertedNumber.getText().toString());

            if (insertedNumberInt > correctGuess) {
                makeToast("Guess lower number");
                //Toast.makeText(getApplicationContext(), "Guess lower number", Toast.LENGTH_SHORT).show();
            } else if (insertedNumberInt < correctGuess) {
                makeToast("Guess higher number");
                //Toast.makeText(getApplicationContext(), "Guess higher number", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "You guess " + insertedNumber.getText().toString() + " is correct !", Toast.LENGTH_SHORT).show();
                correctGuess = generateNewNumber();
            }
        }
    }

    private int generateNewNumber(){
        Random rand = new Random();
        return rand.nextInt(21);
    }

    private void makeToast(String string ){
        Toast.makeText(getApplicationContext(), string, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int correctGuess = generateNewNumber();
    }
}
