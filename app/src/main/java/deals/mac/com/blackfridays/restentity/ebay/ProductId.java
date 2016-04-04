
package deals.mac.com.blackfridays.restentity.ebay;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ProductId {

    @SerializedName("@type")
    @Expose
    private String Type;
    @SerializedName("__value__")
    @Expose
    private String Value;

    /**
     * 
     * @return
     *     The Type
     */
    public String getType() {
        return Type;
    }

    /**
     * 
     * @param Type
     *     The @type
     */
    public void setType(String Type) {
        this.Type = Type;
    }

    /**
     * 
     * @return
     *     The Value
     */
    public String getValue() {
        return Value;
    }

    /**
     * 
     * @param Value
     *     The __value__
     */
    public void setValue(String Value) {
        this.Value = Value;
    }

}
