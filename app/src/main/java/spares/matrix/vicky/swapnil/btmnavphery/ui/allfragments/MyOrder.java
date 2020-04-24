package spares.matrix.vicky.swapnil.btmnavphery.ui.allfragments;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import spares.matrix.vicky.swapnil.btmnavphery.R;

public class MyOrder extends Fragment {

    public static MyOrder newInstance() {
        return new MyOrder();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.my_order_fragment, container, false);
    }

}
