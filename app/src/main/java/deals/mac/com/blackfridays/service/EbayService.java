package deals.mac.com.blackfridays.service;


import deals.mac.com.blackfridays.restentity.ebay.EntityEbay;
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
                                 @Query("callback") String callback,
                                 @Query("REST-PAYLOAD") String restPayloadEmpty,
                                 @Query("paginationInput.entriesPerPage") String sort,
                                 @Query("keywords") String keyword
                                 );

}
