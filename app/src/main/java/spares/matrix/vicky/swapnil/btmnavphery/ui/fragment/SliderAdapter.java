package spares.matrix.vicky.swapnil.btmnavphery.ui.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import spares.matrix.vicky.swapnil.btmnavphery.R;

public class SliderAdapter extends PagerAdapter
{
     Context context;
     LayoutInflater  layoutInflater;

     public SliderAdapter(Context context)
     {
         this.context=context;
     }

    public int[] slide_images = {
            R.drawable.fruitsveg,
            R.drawable.delivery2
    };

    public  String[] slide_headings={
           "Find grocery you love",
            "Fast Delivery"
    };

    public  String[] slide_descs={
        "Discover the best grocery from over 1,000 farmers.",
            "Fast Delivery to your home, office and where you are."
    };
    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==(LinearLayout) object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position)
    {
        layoutInflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.slide_layout,container,false);


        ImageView slideImageView=(ImageView) view.findViewById(R.id.slide_image);
        TextView slideHeading=(TextView) view.findViewById(R.id.slide_heading);
        TextView slideDesc=(TextView) view.findViewById(R.id.slide_desc);

        slideImageView .setImageResource(slide_images[position]);
        slideHeading.setText(slide_headings[position]);
        slideDesc.setText(slide_descs[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }
}
