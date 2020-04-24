package spares.matrix.vicky.swapnil.btmnavphery.ui.allfragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import spares.matrix.vicky.swapnil.btmnavphery.R;

public class NotifiAlert extends Fragment {


    public NotifiAlert() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View root=inflater.inflate(R.layout.notifialert_fragment, container, false);
        TextView output= root.findViewById(R.id.alert);
        output.setText("Order Placed Succesfully.Dear Jon,\n" +
                "Your order #DXMHSFO-5684255 is placed.\n" +
                " It will be delivered on Fri 19 Jul 2019 between 06:30 PM and 08:30 PM.\n" +
                " Happy Shopping!\n" +
                "Team Pherywala.\"");

        return root;
    }

}
