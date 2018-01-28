package niklas.app.allergydictionary;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;


public class MainActivity extends AppCompatActivity {

    Integer SpracheID = -1;
    ArrayList<String> Items;
    Integer InhaltArray = 1;
    ListView Liste;
    boolean NichtsAusgewähltAllerge = true;

    ProgressDialog mProgressDialog;

   // Thre t = new Thre();
    String LänderAuslandName;
    int AnzahlAllergene = 21;
    int[] woRot = new int[AnzahlAllergene];
    boolean ErstesmalAllergene = true;
    ArrayAdapter<String> itemsAdapter;


    // TODO Datenbank
    String[] AllergeneAusland;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        DataStorage.setUpItemsByLanguage();

        Liste = (ListView) findViewById(R.id.ListeID);
        Items = new ArrayList<>(Arrays.asList(DataStorage.LänderNutzer));

        itemsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Items);
        Liste.setAdapter(itemsAdapter);
        Liste.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, AllergyListActivity.class);
                DataStorage.ForeignCountryID = (int) l;
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        } else if (id == R.id.action_ueber) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

            builder.setTitle(DataStorage.UeberItemText)
                    .setMessage("Font by  Adobe: http://www.fontsquirrel.com/fonts/source-sans-pro \n Logo by")
                    .setPositiveButton("Back", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    })
                    .create().show();
        }

        return super.onOptionsItemSelected(item);
    }
}

 /*
                Button WeiterB = new Button(getApplicationContext());
                WeiterB.setText(WeiterButtonText);

                        if(NichtsAusgewähltAllerge) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            LayoutInflater inflater = MainActivity.this.getLayoutInflater();

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
            if(InhaltArray == 3){
                Button BeendenB = new Button(getApplicationContext());
                BeendenB.setText(BeendenBText); // TODO In Sprache
            }
            Button UeberB = new Button(getApplicationContext());
            //TODO wenn kein Allergen ausgewählt


            UeberB.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
            UeberB.setTypeface(Schrift);
            UeberB.setTextSize(30);


            int id = 0;

            for(String s : Items){
                final TextView TextV = new TextView(getApplicationContext());
                TextV.setText(s);
                TextV.setTextColor(Color.BLACK);
                TextV.setTextSize(30);
                final int id2 = id;

                DisplayMetrics metrics = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(metrics);
                TextV.setWidth(metrics.widthPixels);
                TextV.setTypeface(Schrift);
                TextV.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
//                Liste.addView(TextV);
                TextV.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        if (InhaltArray == 2) {
                            if (TextV.getCurrentTextColor() == Color.RED) {
                                TextV.setTextColor(Color.BLACK);
                                woRot[id2] = 0;
                            } else {
                                TextV.setTextColor(Color.RED);
                                woRot[id2] = 1;
                            }
                        }
                        InhaltArray = 2;
                        if (ErstesmalAllergene) {


                            Thre t1 = new Thre();
                            t1.execute();
                            LänderAuslandName = TextV.getText().toString();
                            SpracheID = id2; // TODO geht das?
                            ErstesmalAllergene = false;
                        }

                    }
                });
                id++;

            }

            mProgressDialog.dismiss();

        }
    }
}*/
