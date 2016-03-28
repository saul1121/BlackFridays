package deals.mac.com.blackfridays.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ShareActionProvider;
import android.widget.TextView;

import deals.mac.com.blackfridays.R;
import deals.mac.com.blackfridays.entity.Deal;

public class DealDetailActivity extends Activity {

    public static final String DEAL_NUMBER = "dealNumber";
    private ShareActionProvider shareActionProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_deal_detail);


        getActionBar().setDisplayHomeAsUpEnabled(true);


        int dealNo = (Integer)getIntent().getExtras().get(DEAL_NUMBER);
        String dealName = Deal.deals[dealNo].getName();
        TextView textView = (TextView)findViewById(R.id.deal_text);
        textView.setText(dealName);
        int dealImage = Deal.deals[dealNo].getImageResourceId();
        ImageView imageView = (ImageView)findViewById(R.id.deal_image);
        imageView.setImageDrawable(getResources().getDrawable(dealImage));
        imageView.setContentDescription(dealName);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);



        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
/*
        case R.id.action_create_order:
            Intent intent = new Intent(this, OrderActivity.class);
            startActivity(intent);
            return true;
*/
        default:
            return super.onOptionsItemSelected(item);
        }
    }
}
