package deals.mac.com.blackfridays.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import deals.mac.com.blackfridays.R;
import deals.mac.com.blackfridays.restentity.ebay.Item;


public class EbayAdapter extends RecyclerView.Adapter<EbayAdapter.EbayItemViewHolder> {


    private List<Item> resultsItems;

    public static class EbayItemViewHolder extends RecyclerView.ViewHolder {

        private CardView cardView;

        public EbayItemViewHolder(CardView itemView) {
            super(itemView);
            cardView = itemView;
        }
    }


    public EbayAdapter() {
        //       mContext = context;
        resultsItems = new ArrayList<>();
    }


    /*
    * 1. inflate the layout and create a cardview from it
    * */
    @Override
    public EbayAdapter.EbayItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        CardView ebayCardView =
                (CardView) LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.ebay_item_layout, parent, false);

        return new EbayItemViewHolder(ebayCardView);

    }

    /*
    *
    *2. Set Values for each item on the recycler
    * */
    @Override
    public void onBindViewHolder(EbayItemViewHolder holder, int position) {

        CardView cardView = holder.cardView;
        Item ebayItem = resultsItems.get(position);

        ((TextView) cardView.findViewById(R.id.info_text_ebay)).setText(ebayItem.getTitle().get(0));
        ((TextView) cardView.findViewById(R.id.info_price_ebay)).setText(ebayItem.getSellingStatus().get(0).getCurrentPrice().get(0).getValue());
        Picasso.with(cardView.getContext())
                .load(ebayItem.getGalleryURL().get(0))
                .placeholder(R.color.cardview_dark_background)
                .into((ImageView) cardView.findViewById(R.id.info_image_ebay));

    }

    @Override
    public int getItemCount() {
        return resultsItems == null ? 0 : resultsItems.size();
    }


    public void setResultsItems(List<Item> deals) {

        this.resultsItems.clear();
        this.resultsItems.addAll(deals);
        notifyDataSetChanged();

    }


}
