package spares.matrix.vicky.swapnil.btmnavphery.ui.allfragments;

import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.TextView;

import spares.matrix.vicky.swapnil.btmnavphery.R;
import spares.matrix.vicky.swapnil.btmnavphery.ui.activites.HomeActivity;
import spares.matrix.vicky.swapnil.btmnavphery.ui.categorystore.Fruits;
import spares.matrix.vicky.swapnil.btmnavphery.ui.categorystore.Grains;
import spares.matrix.vicky.swapnil.btmnavphery.ui.categorystore.Others;
import spares.matrix.vicky.swapnil.btmnavphery.ui.categorystore.Vegetable;

public class CategoryFragment extends Fragment implements View.OnClickListener {
    ImageButton vege, frui, grain, spices;
    Vegetable vegetable = new Vegetable();
    DrawerLayout drawerLayout;

    Fruits fruits = new Fruits();
    Grains grains1 = new Grains();
    Others others1 = new Others();
    Toolbar toolbar1;
    TextView text12;

    public static CategoryFragment newInstance() {
        return new CategoryFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View V1 = inflater.inflate(R.layout.category_fragment, container, false);
        text12=V1.findViewById(R.id.text12);
        toolbar1 =V1.findViewById(R.id.toolbar);
        drawerLayout = V1.findViewById(R.id.homelayoutcat);
        vege = V1.findViewById(R.id.vege12);
        frui = V1.findViewById(R.id.fruits1);
        grain = V1.findViewById(R.id.Grains1);
        spices = V1.findViewById(R.id.others1);
        frui.setOnClickListener(this);
        spices.setOnClickListener(this);
        grain.setOnClickListener(this);
        vege.setOnClickListener(this);
        toolbar1.setNavigationIcon(R.drawable.backbtn);
        text12.setText("Category");
toolbar1.setNavigationOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(getContext(), HomeActivity.class);
        startActivity(intent);
    }
});


        return V1;


    }


    private void change_Fragment(Fragment fragment) {
        FragmentManager fragmentTransaction4 = getFragmentManager();
        FragmentTransaction ft1=fragmentTransaction4.beginTransaction();
        ft1.addToBackStack(null);
        ft1.add(R.id.homelayoutcat, fragment);
        ft1.commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.vege12:
                change_Fragment(vegetable);
                Animation developmentv = AnimationUtils.loadAnimation(getContext(),R.anim.custom_animaion);
                drawerLayout.startAnimation(developmentv);
                break;

            case R.id.fruits1:
                change_Fragment(fruits);
                Animation developmentv1 = AnimationUtils.loadAnimation(getContext(),R.anim.custom_animaion);
                drawerLayout.startAnimation(developmentv1);
                break;

            case R.id.Grains1:
                change_Fragment(grains1);
                Animation developmentv2 = AnimationUtils.loadAnimation(getContext(),R.anim.custom_animaion);
                drawerLayout.startAnimation(developmentv2);
                break;

            case R.id.others1:
                change_Fragment(others1);
                Animation developmentv3 = AnimationUtils.loadAnimation(getContext(),R.anim.custom_animaion);
                drawerLayout.startAnimation(developmentv3);
                break;
            default:
                break;


        }

    }
}
