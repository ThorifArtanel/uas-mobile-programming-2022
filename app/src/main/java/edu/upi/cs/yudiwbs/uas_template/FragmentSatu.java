package edu.upi.cs.yudiwbs.uas_template;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import edu.upi.cs.yudiwbs.uas_template.databinding.FragmentSatuBinding;

public class FragmentSatu extends Fragment {

    private FragmentSatuBinding binding;

    ArrayList<Advice> alAdvice = new ArrayList<>();
    AdapterAdvice adapter;
    RecyclerView.LayoutManager lm;


    public FragmentSatu() {
        // Required empty public constructor
    }

    public static FragmentSatu newInstance(String param1, String param2) {
        FragmentSatu fragment = new FragmentSatu();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSatuBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        adapter = new AdapterAdvice(alAdvice);
        binding.rvAdvice.setAdapter(adapter);

        lm = new LinearLayoutManager(getActivity());
        binding.rvAdvice.setLayoutManager(lm);

        //supaya ada garis antar row
        binding.rvAdvice.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));

        binding.btnFrag1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ApiAdvice.get("advice", null, new JsonHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode,
                                          cz.msebera.android.httpclient.Header[] headers,
                                          org.json.JSONObject response) {
                        Log.d("debugyudi","onSuccess jsonobjek");

                        /*
                        {
                          "slip": {
                            "id": 44,
                            "advice": "If you are feeling down, try holding a pencil between your top lip and your nose for five minutes."
                          }
                        }
                         */

                        // get Advice
                        String advice="";
                        try {
                            JSONObject slip = response.getJSONObject("slip"); // get slip data
                            advice = (String) slip.get("advice");
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.e("debugyudi", "msg error" +":" +e.getMessage());
                        }
                        Log.d("debugyudi", "advice" +":" +advice);
                        alAdvice.add(new Advice(advice));
                        adapter.notifyDataSetChanged();
                    }

                    public void onSuccess(int statusCode,
                                          cz.msebera.android.httpclient.Header[] headers,
                                          org.json.JSONArray response) {

                        Log.d("debugyudi","onSuccess jsonarray");

                    }

                    @Override
                    public  void onFailure(int statusCode, cz.msebera.android.httpclient.Header[] headers, String err, Throwable throwable)  {
                        Log.e("debugyudi", "error " + ":" + statusCode +":"+ err);
                    }
                });
//                alHasil.add(new Hasil("satu..."));
//                adapter.notifyDataSetChanged();
            }
        });
        return view;
    }
}