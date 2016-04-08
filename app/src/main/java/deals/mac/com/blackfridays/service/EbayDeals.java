package deals.mac.com.blackfridays.service;

import android.util.Log;

import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.List;

import deals.mac.com.blackfridays.restentity.ebaydeals.EbayEntityDeals;
import deals.mac.com.blackfridays.restentity.ebaydeals.GetMostWatchedItemsResponse;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class EbayDeals  implements Callback<EbayEntityDeals> {

    final String ab = "http://svcs.ebay.com/";

    final String OPERATION_NAME="getMostWatchedItems";
    final String SERVICE_NAME="MerchandisingService";
    final String SERVICE_VERSION="1.0.0";
    final String CONSUMER_ID="MAC-dea-PRD-33890c490-ca2c0396";
    final String RESPONSE_DATA_FORMAT="JSON";
    final String REST_PAYLOAD = "";
    final String MAX_RESULTS="30";
    final String KEYWORDS="SAMSUNG";








    public  void callEbays(){


        GsonBuilder g = new GsonBuilder();

        g.setLenient();

        Retrofit retrofit;
        retrofit = new Retrofit.Builder()
                .baseUrl(ab)
                .client(setUpClient())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(g.create()))
                .build();

        EbayService ebayService = retrofit.create(EbayService.class);

        Call<EbayEntityDeals> listCall = ebayService.getDailyDeals(
                OPERATION_NAME,
                SERVICE_NAME,
                SERVICE_VERSION,
                CONSUMER_ID,
                RESPONSE_DATA_FORMAT,
                REST_PAYLOAD,
                MAX_RESULTS
              //  KEYWORDS
        );

        listCall.enqueue(this);

    }


        /*
    *
    *
    * OPERATION-NAME=getMostWatchedItems&
SERVICE-NAME=MerchandisingService&
SERVICE-VERSION=1.1.0&
CONSUMER-ID=MAC-dea-PRD-33890c490-ca2c0396&
RESPONSE-DATA-FORMAT=JSON&
REST-PAYLOAD&
maxResults=3
&keywords=SAMSUNG
    *
    *
    * */

    @Override
    public void onResponse(Call<EbayEntityDeals> call, Response<EbayEntityDeals> response) {
        GetMostWatchedItemsResponse resp =response.body().getGetMostWatchedItemsResponse();
        List<deals.mac.com.blackfridays.restentity.ebaydeals.Item> itemss =resp.getItemRecommendations().getItem();

        if(itemss != null){
            Log.d("size>>>",""+ new Integer(itemss.size()));
        }


    }

    @Override
    public void onFailure(Call<EbayEntityDeals> call, Throwable t) {
        System.out.println("error onFailure <<<<<< " + t.getMessage());
    }




    public OkHttpClient setUpClient(){


        OkHttpClient okClient = new OkHttpClient.Builder()
                .addInterceptor(
                        new Interceptor() {
                            @Override
                            public okhttp3.Response intercept(Chain chain) throws IOException {
                                Request original = chain.request();
                                Request.Builder requestBuilder = original.newBuilder()
                                        .method(original.method(), original.body());

                                Request request = requestBuilder.build();
                                okhttp3.Response res  = chain.proceed(request);
                                System.out.println("orignal message >>>"+res.message());
                                System.out.println("is succesfull >>>"+res.isSuccessful());

                                return res;
                            }
                        })
                .build();

        return okClient;

    }



}
