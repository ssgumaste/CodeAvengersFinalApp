package spares.matrix.vicky.swapnil.btmnavphery.ui.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import spares.matrix.vicky.swapnil.btmnavphery.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Starting#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Starting extends Fragment {
    Button log,reg;


    ViewPager viewPager;
    LinearLayout dotsLayout;
    SliderAdapter sliderAdapter;
    TextView[] dots;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Starting() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Starting.
     */
    // TODO: Rename and change types and number of parameters
    public static Starting newInstance(String param1, String param2) {
        Starting fragment = new Starting();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_starting, container, false);
        viewPager = v.findViewById(R.id.ViewPager);
        dotsLayout = v.findViewById(R.id.dotsLayout);
log=v.findViewById(R.id.btnCreateAcc);


        sliderAdapter = new SliderAdapter(getContext());

        viewPager.setAdapter(sliderAdapter);

        addDotIndicator();

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginpage();
            }
        });

        return v;
    }

    public void addDotIndicator() {
        dots = new TextView[2];
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(getContext());
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor((R.color.colorPrimary)));

            dotsLayout.addView(dots[i]);
        }
    }



    private void loginpage() {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction
                .replace(R.id.fragment_container, new LoginFragment())
                .addToBackStack(null)
                .commit();

    }
}
