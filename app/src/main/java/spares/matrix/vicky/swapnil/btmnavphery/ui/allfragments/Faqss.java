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

public class Faqss extends Fragment {
    public static Faqss newInstance() {
        return new Faqss();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.faqss_fragment, container, false);
    }

}
