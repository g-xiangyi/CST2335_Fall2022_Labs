package algonquin.cst2335.guo00118.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;

import algonquin.cst2335.guo00118.data.MainViewModel;
import algonquin.cst2335.guo00118.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding variableBinding;
    private MainViewModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //calls parent onCreate()

        //connecting AppCompatActivity to the ViewModel class
        model = new ViewModelProvider(this).get(MainViewModel.class);

        //after enabling binding
        variableBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(variableBinding.getRoot()); //loads XML on screen

        //load the first TextView
 //       variableBinding.textview.setText(model.editString); //returns a TextView or null if not found

        //load first Button
        variableBinding.mybutton.setOnClickListener(click -> {
            model.editString.postValue(variableBinding.edittext.getText().toString());
        });

        model.editString.observe(this, s -> {
 //           @Override
 //           public void onChanged(String s) {
                variableBinding.textview.setText("Your edit text has: "+ s);
            }
        );


    /*    //load EditText
        EditText myedit = variableBinding.edittext;

        //adding event listener to button with lambda function
        String editString = myedit.getText().toString();
        btn.setOnClickListener( vw -> mytext.setText("Your edit text has: " + editString) );
    */}
}