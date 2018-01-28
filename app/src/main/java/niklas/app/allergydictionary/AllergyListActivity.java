package niklas.app.allergydictionary;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class AllergyListActivity extends AppCompatActivity {

    private ArrayList<String> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allergy_list);

        ListView listView = findViewById(R.id.AllergyListView);
        items = new ArrayList<>(Arrays.asList(DataStorage.AllergeneNutzer));
        //TODO Add Toolbar


        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Show Haken Picture
                if (DataStorage.isMarked[(int) l]) {
                    //TODO Don't show Haken
                    DataStorage.isMarked[(int) l] = false;
                } else {
                    //TODO Show Picture
                    DataStorage.isMarked[(int) l] = true;

                }
            }
        });

        Button b = findViewById(R.id.button);
        b.setText(DataStorage.WeiterButtonText);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(atleastOneMarkedAllery()) {
                    Intent intent = new Intent(AllergyListActivity.this, ResultActivity.class);
                    startActivity(intent);
                }
                else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(AllergyListActivity.this);

                    switch (Locale.getDefault().getLanguage()) {
                        case "de":
                            builder.setTitle("Fehler")
                                    .setMessage("Wählen sie mindestens ein Allergen aus.")
                                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {

                                        }
                                    })
                                    .create().show();
                            break;
                        default:
                            builder.setTitle("Error")
                                    .setMessage("Select atleast one allergen")
                                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {

                                        }
                                    })
                                    .create().show();
                            break;
                    }
                }

            }
        });

    }

    public boolean atleastOneMarkedAllery() {
        for(boolean marked: DataStorage.isMarked) {
            if(marked) {
                return true;
            }
        }
        return false;
    }

}
