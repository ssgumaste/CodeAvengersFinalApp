package spares.matrix.vicky.swapnil.btmnavphery.ui.allfragments;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;

import spares.matrix.vicky.swapnil.btmnavphery.R;
import spares.matrix.vicky.swapnil.btmnavphery.ui.adapters.PriceListAdapter;

public class OffersFragment extends Fragment {
    RecyclerView mRecyclerview;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;
    ArrayList<HashMap<String, String>> arrayListNews;
    public static OffersFragment newInstance() {
        return new OffersFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v2=inflater.inflate(R.layout.offers_fragment, container, false);
        mRecyclerview=v2.findViewById(R.id.mRecyclerViewOfr);
        //mLayoutManager=new LinearLayoutManager(getContext());
        mLayoutManager=new GridLayoutManager(getContext(),2);
        mRecyclerview.setLayoutManager(mLayoutManager);
        callAPI();
        return v2;
    }
    private void callAPI() {
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(getContext());
        String url = "https://swapnilz.000webhostapp.com/Pherywala/json/Offers.json";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        Log.d("=====", "=========response:" + response);
                        parseAPIResponse(response);
                    }
                },
                new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //mTextView.setText("That didn't work!");
            }
        });
        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

    private void parseAPIResponse(String response) {
        try {
            JSONObject objResponse = new JSONObject(response);
            JSONArray arrayHeadlines = objResponse.getJSONArray("Offers");
            arrayListNews = new ArrayList<>();

            for (int i = 0; i < arrayHeadlines.length(); i++) {
                JSONObject objItem = arrayHeadlines.getJSONObject(i);
                String imgUrl = objItem.getString("imgUrl");
                String card = objItem.getString("card");
                String discount = objItem.getString("discount");
                String instant = objItem.getString("instant");
                String shop = objItem.getString("shop");
                String code = objItem.getString("code");
                String vaild = objItem.getString("vaild");

                HashMap<String, String> map = new HashMap<>();

                map.put("imgUrl", imgUrl);
                map.put("card", card);
                map.put("discount", discount);
                map.put("instant", instant);
                map.put("shop", shop);
                map.put("code", code);
                map.put("vaild", vaild);
                arrayListNews.add(map);
            }
            //set adapter
            mAdapter = new PriceListAdapter(getContext(), arrayListNews);
            mRecyclerview.setAdapter(mAdapter);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
