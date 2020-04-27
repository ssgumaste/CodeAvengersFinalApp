package spares.matrix.vicky.swapnil.btmnavphery.ui.adapters;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.List;

import spares.matrix.vicky.swapnil.btmnavphery.R;
import spares.matrix.vicky.swapnil.btmnavphery.ui.categorystore.Vegetable;
import spares.matrix.vicky.swapnil.btmnavphery.ui.model.GeneralFood;


public class VerticalAdapter extends RecyclerView.Adapter<VerticalAdapter.VerticalViewHolder> {

    private List<GeneralFood> regularFoods;
    private Context context;


    public static class VerticalViewHolder extends RecyclerView.ViewHolder{

        ImageView imgBanner;
        TextView txtTitle, txtquantity, txtmrp, txtprice;
        Button buttond;

        Button add1,sub1;
        TableLayout tableLayout;
        TextView disp;
        //  static int numtest = 1;
        LinearLayout linearLayout;
        public VerticalViewHolder(View v) {
            super(v);
            imgBanner = v.findViewById(R.id.img1);
            txtTitle = v.findViewById(R.id.textTitle);
            txtquantity = v.findViewById(R.id.textquantity);
            txtmrp = v.findViewById(R.id.textmrp);
            txtprice = v.findViewById(R.id.textprice);
            buttond = v.findViewById(R.id.buttondta);
            linearLayout = itemView.findViewById(R.id.vertical_parent_layout);

            txtmrp.setPaintFlags(txtmrp.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            /*verticalLayout = itemView.findViewById(R.id.vertical_parent_layout);
            regularTitle = itemView.findViewById(R.id.regular_food_title);
            regularImage = itemView.findViewById(R.id.regular_food_pc);
            regularPrice = itemView.findViewById(R.id.regular_food_price);
            regularPlus = itemView.findViewById(R.id.regular_food_plus);*/

        }
    }

    public VerticalAdapter(List<GeneralFood> regularFoods, int vertical_recyclerview, Context context){
        this.context = context;
        this.regularFoods = regularFoods;
    }

    @NonNull
    @Override
    public VerticalAdapter.VerticalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_content, parent, false);
        return new VerticalAdapter.VerticalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final VerticalAdapter.VerticalViewHolder holder, final int position) {
        holder.txtTitle.setText(regularFoods.get(position).getProductName());
        holder.txtprice.setText((((regularFoods.get(position).getProductPrice()))));
        holder.txtmrp.setText("Rs "+(((regularFoods.get(position).getProductPriceBeforeDiscount()))) );
        holder.txtquantity.setText((((regularFoods.get(position).getQuantity()))) );
  //  Picasso.get().load(regularFoods.get(position).getFilepath()).fit().into(holder.imgBanner);
        Glide.with(context)
                .load((regularFoods.get(position).getFilepath()))
                .fitCenter()
                .into(holder.imgBanner);

    }

/*    @Override
    public int getItemCount() {
        return 0;
    }*/

    @Override
    public int getItemCount() {
        return regularFoods.size();
    }
}
