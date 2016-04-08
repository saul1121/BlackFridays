package deals.mac.com.blackfridays.adapter;


import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import deals.mac.com.blackfridays.R;
import deals.mac.com.blackfridays.restentity.ebaydeals.Item;


public class MainAdapter extends RecyclerView.Adapter<MainAdapter.EbayDealViewHolder> {



    private List<Item> resultsItems;
    private Listener listener;

    public static interface Listener {
        public void onClick(int position);
    }


    public static class EbayDealViewHolder extends RecyclerView.ViewHolder{

        private CardView cardView;
        public EbayDealViewHolder(CardView itemView) {
            super(itemView);
            cardView=  itemView;
        }
    }

    public MainAdapter(){
        resultsItems = new ArrayList<>();
    }



    public void setListener(Listener listener) {
        this.listener = listener;
    }

    @Override
    public MainAdapter.EbayDealViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext())
            .inflate(R.layout.deal_item_layout, parent, false);
        return new EbayDealViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(EbayDealViewHolder holder, final int position) {
        CardView cardView = holder.cardView;
           Item item= resultsItems.get(position);

        ((TextView) cardView.findViewById(R.id.info_text)).setText(item.getTitle());
        ((TextView)cardView.findViewById(R.id.info_price)).setText(item.getBuyItNowPrice().getValue());

        Picasso.with(cardView.getContext())
                .load(item.getImageURL())
                .placeholder(R.color.cardview_dark_background)
                .into((ImageView) cardView.findViewById(R.id.info_image));


        cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        listener.onClick(position);
                    }
                }
            });
    }

    @Override
    public int getItemCount() {
        return resultsItems==null? 0: resultsItems.size();
    }

    public void setResultsItems(List<Item> deals){

        this.resultsItems.clear();
        this.resultsItems.addAll(deals);
        notifyDataSetChanged();

    }



}
