package algonquin.cst2335.guo00118.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

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

        //setting Toaster message duration
        int duration = Toast.LENGTH_SHORT;

        //setting listener to textview edit text button
        variableBinding.mybutton.setOnClickListener(click -> {
            model.editString.postValue(variableBinding.edittext.getText().toString());
        });

        // setting textview to edit text when button is clicked
        model.editString.observe(this, s -> {
            variableBinding.textview.setText("Your edit text has: "+ s);
        });

        //setting listener to switch button
        variableBinding.myswitch.setOnCheckedChangeListener(
                (btn, isChecked) -> {model.isSelected.postValue(isChecked);}
        );

        //setting listener to checkbox button
        variableBinding.mycheckbox.setOnCheckedChangeListener(
                (btn, isChecked) -> {model.isSelected.postValue(isChecked);}
        );

        //setting listener to radio button
        variableBinding.myradio.setOnCheckedChangeListener(
                (btn, isChecked) -> {model.isSelected.postValue(isChecked);}
        );

        /* observe function for compound buttons
        - set compound buttons to checked
        - toast message when button value is changed
         */
        model.isSelected.observe(this, selected -> {

            variableBinding.mycheckbox.setChecked(selected);
            variableBinding.myradio.setChecked(selected);
            variableBinding.myswitch.setChecked(selected);

            //instantiating and setting toast message
            CharSequence text = "The value is now: " + selected;
            Toast.makeText(getApplicationContext(), text, duration).show();
        });

        //ImageButton function
        variableBinding.imagebutton.setOnClickListener( v -> {

            //Setting toaster message to display height and width of image
            int height = variableBinding.imagebutton.getHeight();
            int width = variableBinding.imagebutton.getWidth();
            String text = "Width = " + width + " and height = " + height;

            //setting toaster message to return height and width
            Toast.makeText(getApplicationContext(), text, duration).show();
        });
    }
}