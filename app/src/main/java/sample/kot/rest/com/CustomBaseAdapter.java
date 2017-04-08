package sample.kot.rest.com;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.hm.kot.model.Table;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class CustomBaseAdapter extends BaseAdapter implements Filterable {
    Context context;
    List<TableRowItem> rowItems;
    List<TableRowItem> filteredList;
    private FriendFilter friendFilter;

    @Override
    public Filter getFilter() {
        if (friendFilter == null) {
            friendFilter = new FriendFilter();
        }

        return friendFilter;
    }

    public void updateList(List<TableRowItem> datanew) {
        this.rowItems = new ArrayList<>();
        this.filteredList = new ArrayList<>();

        this.rowItems.addAll(datanew);
        this.filteredList.addAll(datanew);
        notifyDataSetChanged();
    }


    private class FriendFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults filterResults = new FilterResults();
            if (constraint != null && constraint.length() > 0) {
                ArrayList<TableRowItem> tempList = new ArrayList<TableRowItem>();

                // search content in friend list
                for (TableRowItem user : rowItems) {
                    Log.e(TAG, "performFiltering:    " + user.toString());
                    if (user.getTitle().toLowerCase().contains(constraint.toString().toLowerCase())) {
                        tempList.add(user);
                    }
                }


                filterResults.count = tempList.size();
                filterResults.values = tempList;
            } else {
                filterResults.count = rowItems.size();
                filterResults.values = rowItems;
            }

            return filterResults;
        }

        /**
         * Notify about filtered list to ui
         *
         * @param constraint text
         * @param results    filtered result
         */
        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            filteredList = (ArrayList<TableRowItem>) results.values;
            notifyDataSetChanged();
        }
    }


    private class ViewHolder {
        ImageView imageView;
        TextView txtDesc;
        TextView txtTitle;

        private ViewHolder() {
        }
    }

    public CustomBaseAdapter(Context context, List<TableRowItem> items) {
        this.context = context;
        this.rowItems = items;
        this.filteredList = items;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        LayoutInflater mInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.outlet_tables_list_item, null);
            holder = new ViewHolder();
            holder.txtTitle = (TextView) convertView.findViewById(R.id.tableId);
            holder.txtDesc = (TextView) convertView.findViewById(R.id.tableAvailability);
            holder.imageView = (ImageView) convertView.findViewById(R.id.vacancyIndicator);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        TableRowItem rowItem = (TableRowItem) getItem(position);
        holder.txtTitle.setText(rowItem.getTitle());
        holder.txtDesc.setText(rowItem.getDesc());
        holder.imageView.setImageResource(rowItem.getImageId());
        holder.txtDesc.setVisibility(View.GONE);


        return convertView;
    }

    public int getCount() {
        return this.filteredList.size();
    }

    public Object getItem(int position) {
        return this.filteredList.get(position);
    }

    public long getItemId(int position) {
        return (long) this.filteredList.indexOf(getItem(position));
    }
}
