package sample.kot.rest.com;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;
import java.util.List;
import java.util.Map;

public class CustomListAdapter extends SimpleAdapter {
    public CustomListAdapter(Context context, List<Map<String, String>> items, int resource, String[] from, int[] to) {
        super(context, items, resource, from, to);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view = super.getView(position, convertView, parent);
        System.out.println("View");
        if (position % 2 == 0) {
            view.setBackgroundColor(Color.parseColor("#F9CBCA"));
        } else {
            view.setBackgroundColor(Color.parseColor("#FB9A98"));
        }
        return view;
    }
}
