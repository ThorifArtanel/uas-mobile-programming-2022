package edu.upi.cs.yudiwbs.uas_template;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class ViewModelFragmentSatu extends ViewModel {
    public MutableLiveData<ArrayList<Advice>> dataAdvice;

    public void setData(ArrayList<Advice> data) {
        this.dataAdvice.setValue(data);
    }

    public ViewModelFragmentSatu() {
        //inisialisasi
        this.dataAdvice = new MutableLiveData<ArrayList<Advice>>();
    }

}
