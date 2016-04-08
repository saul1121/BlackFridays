package deals.mac.com.blackfridays.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import deals.mac.com.blackfridays.R;


public class DealDetailActivity extends Activity {

    public static final String DEAL_NUMBER = "dealNumber";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_deal_detail);


        getActionBar().setDisplayHomeAsUpEnabled(true);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        TextView textView = (TextView) findViewById(R.id.deal_text);
        CharSequence dealName = textView.getText();
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, dealName);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

        default:
            return super.onOptionsItemSelected(item);
        }
    }
}
