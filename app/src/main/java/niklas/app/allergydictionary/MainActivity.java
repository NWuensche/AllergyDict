package niklas.app.allergydictionary;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;


public class MainActivity extends AppCompatActivity {

    // TODO Datenbank
    //TODO Neue APK + Bilder in App Store

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        DataStorage.setUpItemsByLanguage();

        ListView list = findViewById(R.id.ListeID);
        ArrayList<String> items = new ArrayList<>(Arrays.asList(DataStorage.counriesUser));

        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        list.setAdapter(itemsAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, AllergyListActivity.class);
                DataStorage.foreignCountryID = (int) l;
                startActivity(intent);
            }
        });

        showSecurityDialog();

        itemsAdapter.notifyDataSetChanged();
    }

    private void showSecurityDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        switch (Locale.getDefault().getLanguage()) {
            case "de":
                builder.setTitle("Haftungsausschluss")
                        .setMessage("Es gibt keine Garantie, dass diese App 100% richtig ist. Durch das Nutzen dieser App akzeptierst du, dass dies kein Problem ist.")
                        .setPositiveButton("Ich akzeptiere", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .create().show();
                break;
            default:
                builder.setTitle("Disclaimer")
                        .setMessage("There is no warrenty that this app is 100% right. By using this app, you agree that this is no problem.")
                        .setPositiveButton("I Agree", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .create().show();
                break;

        }
    }
}
