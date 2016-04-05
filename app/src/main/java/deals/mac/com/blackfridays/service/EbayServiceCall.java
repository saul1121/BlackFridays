package deals.mac.com.blackfridays.service;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import deals.mac.com.blackfridays.restentity.ebay.EntityEbay;
import deals.mac.com.blackfridays.restentity.ebay.FindItemsByKeywordsResponse;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class EbayServiceCall implements Callback<EntityEbay>{

    final String ab = "http://svcs.ebay.com/";

    final String OPERATION_NAME="findItemsByKeywords";
    final String SERVICE_VERSION="1.0.0";
    final String SECURITY_APPNAME="MAC-dea-PRD-33890c490-ca2c0396";
    final String GLOBAL_ID="EBAY-US";
    final String RESPONSE_DATA_FORMAT="JSON";
   // final String callback="cb_findItemsByKeywords";
    final String REST_PAYLOAD = "";
    final String entriesPerPage="5";
    final String keywords="NIRVANA";



    public  void callEbay(){



        Retrofit retrofit;
        retrofit = new Retrofit.Builder()
                .baseUrl(ab)
                .client(setUpClient())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();


        EbayService ebayService = retrofit.create(EbayService.class);

        Call<EntityEbay> listCall =
                ebayService.getItemEbay(
                        OPERATION_NAME,
                        SERVICE_VERSION,
                        SECURITY_APPNAME,
                        GLOBAL_ID,
                        RESPONSE_DATA_FORMAT,
                    //    callback,
                        REST_PAYLOAD,
                        entriesPerPage,
                        keywords);


            listCall.enqueue(this);

    }


    @Override
    public void onResponse(Call<EntityEbay> call, Response<EntityEbay> response) {

     List<FindItemsByKeywordsResponse> allList=   response.body().getFindItemsByKeywordsResponse();

        if(allList!=null){
            System.out.println("size >>>>>>> "+ allList.size());
        }

    }

    @Override
    public void onFailure(Call<EntityEbay> call, Throwable t) {
        System.out.println("error onFailure <<<<<< "+ t.getMessage());
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
