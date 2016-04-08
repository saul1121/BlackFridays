package deals.mac.com.blackfridays.utils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;


public class OkHttpHandler {

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

                                return res;
                            }
                        })
                .build();

        return okClient;

    }
}
