package niklas.app.allergydictionary;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {

    private String[] AllergeneAusland;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_view);

        findForeignAllergies();

        Button b = findViewById(R.id.exitButton);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });

        ArrayList<String> items = new ArrayList<>();

        for(int i = 0; i < AllergeneAusland.length; i++) {
                if(DataStorage.isMarked[i]) {
                    items.add(AllergeneAusland[i] + "(" + DataStorage.AllergeneNutzer[i] + ")");
                }
        }
        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        ListView list = findViewById(R.id.ResultListView);
        list.setAdapter(itemsAdapter);

    }

    private void findForeignAllergies() {
        switch (DataStorage.ForeignCountryID) {
            case 0:
                AllergeneAusland = DataStorage.AllergeneDeutschland;
                break;
            case 1:
                AllergeneAusland = DataStorage.AllergeneEngland;
                break;
            case 2:
                AllergeneAusland = DataStorage.AllergeneFrankreich;
                break;
            case 3:
                AllergeneAusland = DataStorage.AllergeneSpanien;
                break;
            case 4:
                AllergeneAusland = DataStorage.AllergenePortugal;
                break;
            case 5:
                AllergeneAusland = DataStorage.AllergeneItalien;
                break;
            case 6:
                AllergeneAusland = DataStorage.AllergeneDänemark;
                break;
            case 7:
                AllergeneAusland = DataStorage.AllergeneSchweden;
                break;
            case 8:
                AllergeneAusland = DataStorage.AllergeneNorwegen;
                break;
            case 9:
                AllergeneAusland = DataStorage.AllergeneFinnland;
                break;
            case 10:
                AllergeneAusland = DataStorage.AllergeneNiederlande;
                break;
            case 11:
                AllergeneAusland = DataStorage.AllergeneTürkei;
                break;
            case 12:
                AllergeneAusland = DataStorage.AllergeneKroatien;
                break;
            case 13:
                AllergeneAusland = DataStorage.AllergeneGriechenland;
                break;
            case 14:
                AllergeneAusland = DataStorage.AllergeneUngarn;
                break;
            case 15:
                AllergeneAusland = DataStorage.AllergeneRussland;
                break;
            case 16:
                AllergeneAusland = DataStorage.AllergeneTschechien;
            case 17:
                AllergeneAusland = DataStorage.AllergeneSlowakei;
                break;
            case 18:
                AllergeneAusland = DataStorage.AllergeneSlowenien;
                break;
            case 19:
                AllergeneAusland = DataStorage.AllergenePolen;
                break;
            case 20:
                AllergeneAusland = DataStorage.AllergeneBulgarien;
                break;
            case 21:
                AllergeneAusland = DataStorage.AllergeneArabien;
                break;
            case 22:
                AllergeneAusland = DataStorage.AllergeneChina;
                break;
            case 23:
                AllergeneAusland = DataStorage.AllergeneJapan;
                break;
            default:
                AllergeneAusland = DataStorage.AllergeneEngland;
        }

    }
}
