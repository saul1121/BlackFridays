package deals.mac.com.blackfridays.fragment;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import deals.mac.com.blackfridays.R;

public class AmazonDealsFragment extends ListFragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ArrayAdapter<String> amazonAdapter = new ArrayAdapter<String>(
                inflater.getContext(),
                android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.amazon));
        setListAdapter(amazonAdapter);
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
