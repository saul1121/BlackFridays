
package deals.mac.com.blackfridays.restentity.ebay;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class EntityEbay {

    @SerializedName("findItemsByKeywordsResponse")
    @Expose
    private List<FindItemsByKeywordsResponse> findItemsByKeywordsResponse = new ArrayList<FindItemsByKeywordsResponse>();

    /**
     * 
     * @return
     *     The findItemsByKeywordsResponse
     */
    public List<FindItemsByKeywordsResponse> getFindItemsByKeywordsResponse() {
        return findItemsByKeywordsResponse;
    }

    /**
     * 
     * @param findItemsByKeywordsResponse
     *     The findItemsByKeywordsResponse
     */
    public void setFindItemsByKeywordsResponse(List<FindItemsByKeywordsResponse> findItemsByKeywordsResponse) {
        this.findItemsByKeywordsResponse = findItemsByKeywordsResponse;
    }

}
