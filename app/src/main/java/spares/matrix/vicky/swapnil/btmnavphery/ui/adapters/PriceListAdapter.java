package spares.matrix.vicky.swapnil.btmnavphery.ui.adapters;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.ArrayList;
import java.util.HashMap;

import spares.matrix.vicky.swapnil.btmnavphery.R;
import spares.matrix.vicky.swapnil.btmnavphery.ui.categorystore.Vegetable;

import static android.widget.Toast.*;

public class PriceListAdapter extends RecyclerView.Adapter<PriceListAdapter.ViewHolder> {
    Context mContext;
    ArrayList<HashMap<String, String>> mArray;
    public PriceListAdapter(Context cxt, ArrayList<HashMap<String, String>> mArray) {
        this.mContext = cxt;
        this.mArray = mArray;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder  {
        ImageView imgBanner;

        TextView txtCre, txtTitsb, txtDis, txtShop,txtCd_sbi,txtSbi_cd_validity;

        public ViewHolder(View v) {
            super(v);
            imgBanner = v.findViewById(R.id.img);
            txtCre = v.findViewById(R.id.credit_debit_sbi);
            txtTitsb = v.findViewById(R.id.id_title_sbi);
            txtDis = v.findViewById(R.id.sbi_dis);
            txtShop = v.findViewById(R.id.shop_title_sbi);
            txtCd_sbi = v.findViewById(R.id.cd_sbi);
            txtSbi_cd_validity = v.findViewById(R.id.sbi_cd_validity);

        }



    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        HashMap<String, String> map = mArray.get(position);
        Glide.with(mContext).load(map.get("imgUrl")).into(holder.imgBanner);
        holder.txtCre.setText(map.get("card"));
        holder.txtTitsb.setText(map.get("instant"));
        holder.txtDis.setText(map.get("discount"));
        holder.txtShop.setText(map.get("shop"));
        holder.txtCd_sbi.setText(map.get("code"));
        holder.txtSbi_cd_validity.setText(map.get("vaild"));

    }
    @Override
    public int getItemCount() {
        return mArray.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mRowView = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_offer, parent, false);
        ViewHolder vh = new ViewHolder(mRowView);

        return vh;
    }

}
