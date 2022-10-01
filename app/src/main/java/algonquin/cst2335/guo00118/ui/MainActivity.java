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

        //load the first TextView
 //       variableBinding.textview.setText(model.editString); //returns a TextView or null if not found

        //load first Button
        variableBinding.mybutton.setOnClickListener(click -> {
            model.editString.postValue(variableBinding.edittext.getText().toString());
        });

        // setting textview to edit text when button is clicked
        model.editString.observe(this, s -> {
            variableBinding.textview.setText("Your edit text has: "+ s);
        });


        // setting compound buttons to checked
        model.isSelected.observe(this, selected -> {
            variableBinding.mycheckbox.setChecked(selected);
            variableBinding.myradio.setChecked(selected);
            variableBinding.myswitch.setChecked(selected);

            //instantiating and setting toast message
            Context context = getApplicationContext();
            CharSequence text = "The value is now: " + selected;
            int duration = Toast.LENGTH_SHORT;

            //adding listener to compound buttons
            variableBinding.mycheckbox.setOnCheckedChangeListener( (btn, isChecked) -> {
                Toast.makeText(context, text, duration).show();
            });
            variableBinding.myradio.setOnCheckedChangeListener( (btn, isChecked) -> {
                Toast.makeText(context, text, duration).show();
            });
            variableBinding.myswitch.setOnCheckedChangeListener( (btn, isChecked) -> {
                Toast.makeText(context, text, duration).show();
            });
        });
    }
}