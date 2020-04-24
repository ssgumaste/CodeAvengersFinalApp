package spares.matrix.vicky.swapnil.btmnavphery.ui.allfragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import spares.matrix.vicky.swapnil.btmnavphery.R;

public class BasketFragment extends Fragment {

    public static BasketFragment newInstance() {
        return new BasketFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.basket_fragment, container, false);
    }
}
