package niklas.app.allergydictionary;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.view.LayoutInflater;
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

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.allergy_item, parent, false);
        }

        TextView t = convertView.findViewById(R.id.allergyItemText);
        t.setText(name);

        return convertView;
    }
}
