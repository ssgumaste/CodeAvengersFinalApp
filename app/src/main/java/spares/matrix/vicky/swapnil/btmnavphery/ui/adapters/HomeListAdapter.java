package spares.matrix.vicky.swapnil.btmnavphery.ui.adapters;

import android.content.Context;
import android.graphics.Color;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.graphics.Color;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;

import java.util.ArrayList;
import java.util.HashMap;

import spares.matrix.vicky.swapnil.btmnavphery.R;
import spares.matrix.vicky.swapnil.btmnavphery.ui.categorystore.Vegetable;

import static android.graphics.Color.RED;
import static android.widget.Toast.LENGTH_SHORT;
import static android.widget.Toast.makeText;
import static androidx.constraintlayout.widget.Constraints.TAG;

public class HomeListAdapter extends RecyclerView.Adapter<HomeListAdapter.ViewHolder>  {
    Context mContext;
    ArrayList<HashMap<String, String>> mArray;
    public ElegantNumberButton btn1;
    public ElegantNumberButton btn2;
    public TextView textView;



    public HomeListAdapter(Context cxt, ArrayList<HashMap<String, String>> mArray){
        this.mContext = cxt;
        this.mArray = mArray;
    }



    public  static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imgBanner;
        TextView txtTitle, txtquantity, txtmrp, txtprice;
        Button buttond;

        Button add1,sub1;
        TableLayout tableLayout;
        TextView disp;
        static int numtest = 1;
        LinearLayout linearLayout;

        public ViewHolder(View v){
            super(v);
            imgBanner = v.findViewById(R.id.img);
            txtTitle =  v.findViewById(R.id.textTitle);
            txtquantity =  v.findViewById(R.id.textquantity);
            txtmrp =  v.findViewById(R.id.textmrp);
            txtprice =  v.findViewById(R.id.textprice);
            buttond=v.findViewById(R.id.buttondta);
            buttond.setOnClickListener(this);
            add1=v.findViewById(R.id.bt2);
            sub1=v.findViewById(R.id.bt1);
            disp=v.findViewById(R.id.tex1);

tableLayout=v.findViewById(R.id.table1);
            linearLayout=v.findViewById(R.id.layoutL12);
              buttond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttond.setVisibility(View.GONE);
                linearLayout.setVisibility(View.VISIBLE);
                tableLayout.setVisibility(View.VISIBLE);
                linearLayout.setGravity(View.TEXT_ALIGNMENT_TEXT_START);
            }
        });

        add1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numtest ++;
                String s= String.valueOf(numtest);
                disp.setText("" + s);
            }
        });

        sub1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n=disp.getText().toString().trim();

                int n1= Integer.parseInt(n);
                if (n1 == 1){


                    buttond.setVisibility(View.VISIBLE);
                    tableLayout.setVisibility(View.GONE);
                    linearLayout.setVisibility(View.GONE);


                  /*  disp.setText(s + "");*/
                }
                if (numtest > 1) {
                    numtest--;
                    String s= String.valueOf(numtest);
                    disp.setText(s+ "");
                }
            }
        });
        }

        @Override
        public void onClick(View v) {
            if (v.getId() == txtTitle.getId()) {
                Toast.makeText(v.getContext(), "ITEM PRESSED = " + String.valueOf(getAdapterPosition()), Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(v.getContext(), "ROW PRESSED = " + String.valueOf(getAdapterPosition()), Toast.LENGTH_SHORT).show();
            }


        }
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        HashMap<String,String> map = mArray.get(position);
        Glide.with(mContext).load(map.get("url")).into(holder.imgBanner);
        holder.txtTitle.setText(map.get("title"));
        holder.txtquantity.setText(map.get("quantity"));
        holder.txtmrp.setText(map.get("mrp"));
        holder.txtprice.setText(map.get("price"));
        Vegetable.description1=map.get("detail");
    }

    @Override
    public int getItemCount()
    {
        return mArray.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mRowView = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_content, parent, false);
        ViewHolder vh = new ViewHolder(mRowView);



        return vh;
    }


}
