package deals.mac.com.blackfridays.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.List;

import deals.mac.com.blackfridays.R;
import deals.mac.com.blackfridays.adapter.EbayAdapter;
import deals.mac.com.blackfridays.restentity.ebay.EntityEbay;
import deals.mac.com.blackfridays.restentity.ebay.FindItemsByKeywordsResponse;
import deals.mac.com.blackfridays.restentity.ebay.Item;
import deals.mac.com.blackfridays.service.EbayService;
import deals.mac.com.blackfridays.utils.OkHttpHandler;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class EbayFragment extends Fragment implements Callback<EntityEbay> {


    private RecyclerView myRecyclerView;
    private EbayAdapter mAdapter;
    private List<Item> resultsItems;
    private final String INFO_EBAY = "EBAY INFO REQ>>>";
    private OkHttpHandler mOkHttpHandler;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mOkHttpHandler = new OkHttpHandler();

        myRecyclerView = (RecyclerView) inflater.inflate(R.layout.fragment_ebay_material, container, false);

        mAdapter = new EbayAdapter();
        this.callEbay();

        myRecyclerView.setLayoutManager(new GridLayoutManager(getActivity().getApplicationContext(), 2));

        myRecyclerView.setAdapter(mAdapter);


        return myRecyclerView;
    }


    public void callEbay() {

        Retrofit retrofit;
        retrofit = new Retrofit.Builder()
                .baseUrl(getString(R.string.base_ebay))
                .client(mOkHttpHandler.setUpClient())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();


        EbayService ebayService = retrofit.create(EbayService.class);

        Call<EntityEbay> listCall =
                ebayService.getItemEbay(
                        getString(R.string.operation_name_ebay),
                        getString(R.string.service_version_ebay),
                        getString(R.string.security_app_name_ebay),
                        getString(R.string.goblal_id_ebay),
                        getString(R.string.reponse_data_format_ebay),
                        getString(R.string.rest_payload_ebay),
                        getString(R.string.entries_per_page_ebay),
                        getString(R.string.keywords_ebay)
                );


        listCall.enqueue(this);

    }


    @Override
    public void onResponse(Call<EntityEbay> call, Response<EntityEbay> response) {

        Log.d(INFO_EBAY, response.message());
        Log.d(INFO_EBAY, new Boolean(response.isSuccessful()).toString());
        Log.d(INFO_EBAY, new Integer(response.body().getFindItemsByKeywordsResponse().size()).toString());
        List<FindItemsByKeywordsResponse> allList = response.body().getFindItemsByKeywordsResponse();
        this.resultsItems = allList.get(0).getSearchResult().get(0).getItem();
        mAdapter.setResultsItems(resultsItems);


    }

    @Override
    public void onFailure(Call<EntityEbay> call, Throwable t) {

        Toast.makeText(this.getActivity().getApplicationContext(), "FAILURE>>>" + t.getMessage(), Toast.LENGTH_SHORT);

    }


}
