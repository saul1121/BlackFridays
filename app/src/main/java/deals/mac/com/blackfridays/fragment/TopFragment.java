package deals.mac.com.blackfridays.fragment;

import android.app.Fragment;
import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import deals.mac.com.blackfridays.R;
import deals.mac.com.blackfridays.activity.DealDetailActivity;
import deals.mac.com.blackfridays.adapter.MainAdapter;


import deals.mac.com.blackfridays.restentity.ebaydeals.GetMostWatchedItemsResponse;
import deals.mac.com.blackfridays.restentity.ebaydeals.Item;
import deals.mac.com.blackfridays.restentity.ebaydeals.EbayEntityDeals;
import deals.mac.com.blackfridays.service.EbayService;
import deals.mac.com.blackfridays.utils.OkHttpHandler;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class TopFragment extends Fragment implements Callback<EbayEntityDeals> {

    private List<Item> resultsItems;
    private RecyclerView myRecyclerView;
    private MainAdapter mAdapter;
    private OkHttpHandler mOkHttpHandler;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        myRecyclerView = (RecyclerView) inflater.inflate(R.layout.fragment_ebay_material, container, false);

        mOkHttpHandler = new OkHttpHandler();
        mAdapter = new MainAdapter();
        this.callEbay();

        GridLayoutManager layoutManager = new GridLayoutManager(getActivity().getApplicationContext(), 2);
        myRecyclerView.setLayoutManager(layoutManager);

        myRecyclerView.setAdapter(mAdapter);

        mAdapter.setListener(new MainAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), DealDetailActivity.class);
                intent.putExtra(DealDetailActivity.DEAL_NUMBER, position);
                getActivity().startActivity(intent);
            }
        });


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

        Call<EbayEntityDeals> listCall =
                ebayService.getDailyDeals(
                        getString(R.string.operation_name),
                        getString(R.string.service_name),
                        getString(R.string.service_version),
                        getString(R.string.consumer_id),
                        getString(R.string.RESPONSE_DATA_FORMAT),
                        getString(R.string.REST_PAYLOAD),
                        getString(R.string.MAX_RESULTS)

                );


        listCall.enqueue(this);

    }


    @Override
    public void onResponse(Call<EbayEntityDeals> call, Response<EbayEntityDeals> response) {
        GetMostWatchedItemsResponse resp = response.body().getGetMostWatchedItemsResponse();
        List<deals.mac.com.blackfridays.restentity.ebaydeals.Item> itemss = resp.getItemRecommendations().getItem();
        this.resultsItems = itemss;
        mAdapter.setResultsItems(resultsItems);
    }

    @Override
    public void onFailure(Call<EbayEntityDeals> call, Throwable t) {
        Toast.makeText(this.getActivity().getApplicationContext(), "FAILURE>>>" + t.getMessage(), Toast.LENGTH_SHORT);
    }


    public OkHttpClient setUpClient() {


        OkHttpClient okClient = new OkHttpClient.Builder()
                .addInterceptor(
                        new Interceptor() {
                            @Override
                            public okhttp3.Response intercept(Chain chain) throws IOException {
                                Request original = chain.request();

                                Request.Builder requestBuilder = original.newBuilder()
                                        .method(original.method(), original.body());

                                Request request = requestBuilder.build();

                                okhttp3.Response res = chain.proceed(request);

                                return res;
                            }
                        })
                .build();

        return okClient;

    }

}
