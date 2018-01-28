package niklas.app.allergydictionary;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.ActionMenuItem;
import android.support.v7.view.menu.ActionMenuItemView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class AllergyListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allergy_list);


        this.setTitle(DataStorage.counriesUser[DataStorage.foreignCountryID]);

        ListView listView = findViewById(R.id.AllergyListView);
        ArrayList<String>  items = new ArrayList<>(Arrays.asList(DataStorage.allergenesUser));

        ArrayAdapter<String> itemsAdapter = new AllergyItemAdapter(this, items);
        listView.setAdapter(itemsAdapter);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (DataStorage.isMarked[(int) l]) {
                    final ImageView image = view.findViewById(R.id.allergyImageItem);

                    Animation a = new ScaleAnimation(1.0f,0.0f,1.0f,0.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);

                    a.setDuration(500);
                    a.setAnimationListener(new Animation.AnimationListener() {

                        public void onAnimationStart(Animation animation) {
                            // TODO Auto-generated method stub

                        }

                        public void onAnimationRepeat(Animation animation) {
                            // TODO Auto-generated method stub

                        }

                        public void onAnimationEnd(Animation animation) {
                            image.setVisibility(View.INVISIBLE);

                        }
                    });

                   /* image.setVisibility(View.VISIBLE);
                    image.setAnimation(new AlphaAnimation(100, 0));
                    image.animate().alphaBy(-100).start();*/
                    image.startAnimation(a);

                    DataStorage.isMarked[(int) l] = false;
                } else {
                    final ImageView image = view.findViewById(R.id.allergyImageItem);

                    Animation a = new ScaleAnimation(0.0f,1.0f,0.0f,1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);

                    a.setDuration(500);
                    a.setAnimationListener(new Animation.AnimationListener() {

                        public void onAnimationStart(Animation animation) {
                            // TODO Auto-generated method stub

                        }

                        public void onAnimationRepeat(Animation animation) {
                            // TODO Auto-generated method stub

                        }

                        public void onAnimationEnd(Animation animation) {
                            image.setVisibility(View.VISIBLE);

                        }
                    });
                    image.startAnimation(a);
                    DataStorage.isMarked[(int) l] = true;

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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_finished) {
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
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.allergy_list_menu, menu);
        return super.onCreateOptionsMenu(menu);

    }

}
