
package deals.mac.com.blackfridays.restentity.ebaydeals;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Item {

    @SerializedName("itemId")
    @Expose
    private String itemId;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("subtitle")
    @Expose
    private String subtitle;
    @SerializedName("viewItemURL")
    @Expose
    private String viewItemURL;
    @SerializedName("globalId")
    @Expose
    private String globalId;
    @SerializedName("timeLeft")
    @Expose
    private String timeLeft;
    @SerializedName("primaryCategoryId")
    @Expose
    private String primaryCategoryId;
    @SerializedName("primaryCategoryName")
    @Expose
    private String primaryCategoryName;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("imageURL")
    @Expose
    private String imageURL;
    @SerializedName("shippingType")
    @Expose
    private String shippingType;
    @SerializedName("buyItNowPrice")
    @Expose
    private BuyItNowPrice buyItNowPrice;
    @SerializedName("shippingCost")
    @Expose
    private ShippingCost shippingCost;
    @SerializedName("watchCount")
    @Expose
    private String watchCount;

    /**
     * 
     * @return
     *     The itemId
     */
    public String getItemId() {
        return itemId;
    }

    /**
     * 
     * @param itemId
     *     The itemId
     */
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    /**
     * 
     * @return
     *     The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 
     * @param title
     *     The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 
     * @return
     *     The subtitle
     */
    public String getSubtitle() {
        return subtitle;
    }

    /**
     * 
     * @param subtitle
     *     The subtitle
     */
    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    /**
     * 
     * @return
     *     The viewItemURL
     */
    public String getViewItemURL() {
        return viewItemURL;
    }

    /**
     * 
     * @param viewItemURL
     *     The viewItemURL
     */
    public void setViewItemURL(String viewItemURL) {
        this.viewItemURL = viewItemURL;
    }

    /**
     * 
     * @return
     *     The globalId
     */
    public String getGlobalId() {
        return globalId;
    }

    /**
     * 
     * @param globalId
     *     The globalId
     */
    public void setGlobalId(String globalId) {
        this.globalId = globalId;
    }

    /**
     * 
     * @return
     *     The timeLeft
     */
    public String getTimeLeft() {
        return timeLeft;
    }

    /**
     * 
     * @param timeLeft
     *     The timeLeft
     */
    public void setTimeLeft(String timeLeft) {
        this.timeLeft = timeLeft;
    }

    /**
     * 
     * @return
     *     The primaryCategoryId
     */
    public String getPrimaryCategoryId() {
        return primaryCategoryId;
    }

    /**
     * 
     * @param primaryCategoryId
     *     The primaryCategoryId
     */
    public void setPrimaryCategoryId(String primaryCategoryId) {
        this.primaryCategoryId = primaryCategoryId;
    }

    /**
     * 
     * @return
     *     The primaryCategoryName
     */
    public String getPrimaryCategoryName() {
        return primaryCategoryName;
    }

    /**
     * 
     * @param primaryCategoryName
     *     The primaryCategoryName
     */
    public void setPrimaryCategoryName(String primaryCategoryName) {
        this.primaryCategoryName = primaryCategoryName;
    }

    /**
     * 
     * @return
     *     The country
     */
    public String getCountry() {
        return country;
    }

    /**
     * 
     * @param country
     *     The country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * 
     * @return
     *     The imageURL
     */
    public String getImageURL() {
        return imageURL;
    }

    /**
     * 
     * @param imageURL
     *     The imageURL
     */
    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    /**
     * 
     * @return
     *     The shippingType
     */
    public String getShippingType() {
        return shippingType;
    }

    /**
     * 
     * @param shippingType
     *     The shippingType
     */
    public void setShippingType(String shippingType) {
        this.shippingType = shippingType;
    }

    /**
     * 
     * @return
     *     The buyItNowPrice
     */
    public BuyItNowPrice getBuyItNowPrice() {
        return buyItNowPrice;
    }

    /**
     * 
     * @param buyItNowPrice
     *     The buyItNowPrice
     */
    public void setBuyItNowPrice(BuyItNowPrice buyItNowPrice) {
        this.buyItNowPrice = buyItNowPrice;
    }

    /**
     * 
     * @return
     *     The shippingCost
     */
    public ShippingCost getShippingCost() {
        return shippingCost;
    }

    /**
     * 
     * @param shippingCost
     *     The shippingCost
     */
    public void setShippingCost(ShippingCost shippingCost) {
        this.shippingCost = shippingCost;
    }

    /**
     * 
     * @return
     *     The watchCount
     */
    public String getWatchCount() {
        return watchCount;
    }

    /**
     * 
     * @param watchCount
     *     The watchCount
     */
    public void setWatchCount(String watchCount) {
        this.watchCount = watchCount;
    }

}
