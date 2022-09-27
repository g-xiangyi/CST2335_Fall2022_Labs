package algonquin.cst2335.guo00118;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;

import algonquin.cst2335.guo00118.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding variableBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //calls parent onCreate()

        variableBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(variableBinding.getRoot()); //loads XML on screen

        //load the first TextView
        TextView mytext = variableBinding.textview; //returns a TextView or null if mytext not found
        String value = mytext.getText().toString(); // returns string mytext

        //load first Button
        final Button btn = variableBinding.mybutton;

        //load EditText
        EditText myedit = variableBinding.edittext;

        //adding event listener
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //code here executes on main thread after user presses button
                String editString = myedit.getText().toString();
                mytext.setText("Your edit text has: " + editString);

            }
        });
    }
}