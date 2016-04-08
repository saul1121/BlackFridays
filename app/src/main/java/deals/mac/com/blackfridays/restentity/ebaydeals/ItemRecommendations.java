
package deals.mac.com.blackfridays.restentity.ebaydeals;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ItemRecommendations {

    @SerializedName("item")
    @Expose
    private List<Item> item = new ArrayList<Item>();

    /**
     * 
     * @return
     *     The item
     */
    public List<Item> getItem() {
        return item;
    }

    /**
     * 
     * @param item
     *     The item
     */
    public void setItem(List<Item> item) {
        this.item = item;
    }

}
