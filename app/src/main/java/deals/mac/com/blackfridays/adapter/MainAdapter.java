package deals.mac.com.blackfridays.adapter;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import deals.mac.com.blackfridays.R;



public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private String[] titles;
    private int[] imageIds;
    private Listener listener;

    public static interface Listener {
        public void onClick(int position);
    }
    
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;
        public ViewHolder(CardView v) {
            super(v);
            cardView=v;
        }
    }

    public MainAdapter(String[] titles, int[] imageIds){
        this.titles = titles;
        this.imageIds = imageIds;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext())
            .inflate(R.layout.deal_item_layout, parent, false);
        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        CardView cardView = holder.cardView;


        ImageView imageView = (ImageView)cardView.findViewById(R.id.info_image);
        Drawable drawable = cardView.getResources().getDrawable(imageIds[position]);
        imageView.setImageDrawable(drawable);
        imageView.setContentDescription(titles[position]);
        TextView textView = (TextView)cardView.findViewById(R.id.info_text);
        textView.setText(titles[position]);
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
        return titles.length;
    }
}
