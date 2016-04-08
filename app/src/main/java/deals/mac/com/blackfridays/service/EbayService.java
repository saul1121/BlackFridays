package deals.mac.com.blackfridays.service;


import deals.mac.com.blackfridays.restentity.ebay.EntityEbay;
import deals.mac.com.blackfridays.restentity.ebaydeals.EbayEntityDeals;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface EbayService {

    @GET("services/search/FindingService/v1/")
    Call<EntityEbay> getItemEbay(@Query("OPERATION-NAME") String operationName,
                                 @Query("SERVICE-VERSION") String serviceVersion,
                                 @Query("SECURITY-APPNAME") String seccurityAppName,
                                 @Query("GLOBAL-ID") String globalId,
                                 @Query("RESPONSE-DATA-FORMAT") String responseDataFormat,
                                 //@Query("callback") String callback,
                                 @Query("REST-PAYLOAD") String restPayloadEmpty,
                                 @Query("paginationInput.entriesPerPage") String sort,
                                 @Query("keywords") String keyword
    );




/*
    http://svcs.ebay.com/MerchandisingService?
    OPERATION-NAME=getMostWatchedItems&
    SERVICE-NAME=MerchandisingService&
    SERVICE-VERSION=1.1.0&
    CONSUMER-ID=MAC-dea-PRD-33890c490-ca2c0396&
    RESPONSE-DATA-FORMAT=JSON&
    REST-PAYLOAD&
    maxResults=3
            &keywords=SAMSUNG
*/


    @GET("MerchandisingService/")
    Call<EbayEntityDeals> getDailyDeals(@Query("OPERATION-NAME") String operationName,
                                        @Query("SERVICE-NAME") String serviceName,
                                        @Query("SERVICE-VERSION") String serviceVersion,
                                        @Query("CONSUMER-ID") String consumerId,
                                        @Query("RESPONSE-DATA-FORMAT") String responseDataFormat,
                                        @Query("REST-PAYLOAD") String restPayloadEmpty,
                                        @Query("maxResults") String maxResults
                                        // @Query("keywords") String keyword
    );


}
