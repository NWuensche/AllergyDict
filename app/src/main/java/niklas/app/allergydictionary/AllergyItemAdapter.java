package niklas.app.allergydictionary;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by nwuensche on 28.01.18.
 */

public class AllergyItemAdapter extends ArrayAdapter<String> {

    public AllergyItemAdapter(Context context, ArrayList<String> allergies) {
        super(context, 0, allergies);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String name = this.getItem(position);
        ViewHolder holder;
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.allergy_item, null);
            holder = new ViewHolder();
            holder.textView = convertView.findViewById(R.id.allergyItemText);
            holder.imageView = convertView.findViewById(R.id.allergyImageItem);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder)convertView.getTag();
        }

        TextView t = convertView.findViewById(R.id.allergyItemText);
        t.setText(name);

        if(DataStorage.isMarked[position]) {
            holder.imageView.setVisibility(View.VISIBLE);
        }
        else {
            holder.imageView.setVisibility(View.INVISIBLE);
        }

        return convertView;
    }
    private class ViewHolder{
        public TextView textView;
        public ImageView imageView;
    }
}

