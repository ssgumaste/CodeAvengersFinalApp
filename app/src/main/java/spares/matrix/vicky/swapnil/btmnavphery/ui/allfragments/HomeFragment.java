package spares.matrix.vicky.swapnil.btmnavphery.ui.allfragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import androidx.navigation.ui.AppBarConfiguration;


import spares.matrix.vicky.swapnil.btmnavphery.R;
import spares.matrix.vicky.swapnil.btmnavphery.ui.categorystore.Fruits;
import spares.matrix.vicky.swapnil.btmnavphery.ui.categorystore.Grains;
import spares.matrix.vicky.swapnil.btmnavphery.ui.categorystore.Others;
import spares.matrix.vicky.swapnil.btmnavphery.ui.categorystore.Vegetable;
import technolifestyle.com.imageslider.FlipperLayout;
import technolifestyle.com.imageslider.FlipperView;


public class HomeFragment extends Fragment implements View.OnClickListener {
    private AppBarConfiguration mAppBarConfiguration;
    ImageButton vege, frui, grain, spices;
    final Vegetable vegetable = new Vegetable();
    ConstraintLayout drawerLayout;

    Fruits fruits = new Fruits();
    Grains grains1 = new Grains();
    Others others1 = new Others();
    FlipperLayout flipperLayout;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View root = inflater.inflate(R.layout.fragment_home, container, false);
        drawerLayout = root.findViewById(R.id.homelayout2);
        flipperLayout = root.findViewById(R.id.flipper);

        int imagesDrawable[] = {R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4};
        for (int i = 0; i < imagesDrawable.length; i++) {

            FlipperView flipperView = new FlipperView(getContext());
            flipperView.setImageDrawable(imagesDrawable[i]);
            flipperLayout.addFlipperView(flipperView);

        }


        vege = root.findViewById(R.id.vege1);
        frui = root.findViewById(R.id.fruits);
        grain = root.findViewById(R.id.Grains);
        spices = root.findViewById(R.id.others);
        frui.setOnClickListener(this);
        spices.setOnClickListener(this);
        grain.setOnClickListener(this);
        vege.setOnClickListener(this);

        return root;


    }

    private void change_Fragment(Fragment fragment) {
        FragmentManager fragmentTransaction3 = getFragmentManager();
        FragmentTransaction ft = fragmentTransaction3.beginTransaction();
        ft.addToBackStack(null);
        ft.add(R.id.homelayout2, fragment);
        ft.commit();
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.vege1:
                change_Fragment(vegetable);
                Animation developmentv = AnimationUtils.loadAnimation(getContext(), R.anim.custom_animaion);
                drawerLayout.startAnimation(developmentv);
                break;

            case R.id.fruits:
                change_Fragment(fruits);
                Animation developmentv1 = AnimationUtils.loadAnimation(getContext(), R.anim.custom_animaion);
                drawerLayout.startAnimation(developmentv1);
                break;

            case R.id.Grains:
                change_Fragment(grains1);
                Animation developmentv2 = AnimationUtils.loadAnimation(getContext(), R.anim.custom_animaion);
                drawerLayout.startAnimation(developmentv2);
                break;

            case R.id.others:
                change_Fragment(others1);
                Animation developmentv3 = AnimationUtils.loadAnimation(getContext(), R.anim.custom_animaion);
                drawerLayout.startAnimation(developmentv3);
                break;
            default:
                break;


        }

    }
}




