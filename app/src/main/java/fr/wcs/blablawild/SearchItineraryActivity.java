package fr.wcs.blablawild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SearchItineraryActivity extends AppCompatActivity {

    Button buttonSearch;
    String departContent;
    String destinationContent;
    EditText editTextSearchDeparture;
    EditText editTextSearchDestination;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_itinerary);

        editTextSearchDeparture = (EditText) findViewById(R.id.editTextSearchDeparture);
        editTextSearchDestination = (EditText) findViewById(R.id.editTextSearchDestination);

        buttonSearch = (Button) findViewById(R.id.buttonSearch);
        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                departContent = editTextSearchDeparture.getText().toString();
                destinationContent = editTextSearchDestination.getText().toString();

                if ((departContent.equals("")) || (destinationContent.equals(""))) {
                    Toast.makeText(SearchItineraryActivity.this, "Veuillez renseigner votre départ et votre destination", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                        Intent intent = new Intent(SearchItineraryActivity.this, ViewSearchItineraryResultsListActivity.class);
                        String message = departContent;
                        String message2 = destinationContent;
                        intent.putExtra("lieuDepart", message);
                        intent.putExtra("lieuDepart2", message2);
                        startActivity(intent);
                }
            }
        });
    }
}
