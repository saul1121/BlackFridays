
package deals.mac.com.blackfridays.restentity.ebaydeals;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class EbayEntityDeals {

    @SerializedName("getMostWatchedItemsResponse")
    @Expose
    private GetMostWatchedItemsResponse getMostWatchedItemsResponse;

    /**
     * 
     * @return
     *     The getMostWatchedItemsResponse
     */
    public GetMostWatchedItemsResponse getGetMostWatchedItemsResponse() {
        return getMostWatchedItemsResponse;
    }

    /**
     * 
     * @param getMostWatchedItemsResponse
     *     The getMostWatchedItemsResponse
     */
    public void setGetMostWatchedItemsResponse(GetMostWatchedItemsResponse getMostWatchedItemsResponse) {
        this.getMostWatchedItemsResponse = getMostWatchedItemsResponse;
    }

}
