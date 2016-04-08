
package deals.mac.com.blackfridays.restentity.ebaydeals;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class GetMostWatchedItemsResponse {

    @SerializedName("ack")
    @Expose
    private String ack;
    @SerializedName("version")
    @Expose
    private String version;
    @SerializedName("timestamp")
    @Expose
    private String timestamp;
    @SerializedName("itemRecommendations")
    @Expose
    private ItemRecommendations itemRecommendations;

    /**
     * 
     * @return
     *     The ack
     */
    public String getAck() {
        return ack;
    }

    /**
     * 
     * @param ack
     *     The ack
     */
    public void setAck(String ack) {
        this.ack = ack;
    }

    /**
     * 
     * @return
     *     The version
     */
    public String getVersion() {
        return version;
    }

    /**
     * 
     * @param version
     *     The version
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * 
     * @return
     *     The timestamp
     */
    public String getTimestamp() {
        return timestamp;
    }

    /**
     * 
     * @param timestamp
     *     The timestamp
     */
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * 
     * @return
     *     The itemRecommendations
     */
    public ItemRecommendations getItemRecommendations() {
        return itemRecommendations;
    }

    /**
     * 
     * @param itemRecommendations
     *     The itemRecommendations
     */
    public void setItemRecommendations(ItemRecommendations itemRecommendations) {
        this.itemRecommendations = itemRecommendations;
    }

}
