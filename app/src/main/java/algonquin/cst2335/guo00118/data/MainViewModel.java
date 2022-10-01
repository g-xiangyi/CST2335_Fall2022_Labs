package algonquin.cst2335.guo00118.data;
/*
Implements all the variables required by MainActivity so they remain permanent

This should ONLY hold data variables, never View or Widget objects! These need to be deleted and
recreated so permanency might render them invalid.
 */

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    public MutableLiveData<String> editString = new MutableLiveData<>();

    //variable for compound buttons
    public MutableLiveData<Boolean> isSelected = new MutableLiveData<>();
}
