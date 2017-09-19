package fr.wcs.blablawild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SearchItineraryActivity extends AppCompatActivity {

    Button buttonSearch;
    String departContent;
    String destinationContent;
    String dateContent;
    EditText editTextSearchDeparture;
    EditText editTextSearchDestination;
    EditText editTextSearchDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_itinerary);

        editTextSearchDeparture = (EditText) findViewById(R.id.editTextSearchDeparture);
        editTextSearchDestination = (EditText) findViewById(R.id.editTextSearchDestination);
        editTextSearchDate = (EditText) findViewById(R.id.editTextSearchDate);

        buttonSearch = (Button) findViewById(R.id.buttonSearch);

        final Intent intent = new Intent(this, ViewSearchItineraryResultsListActivity.class);

        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                departContent = editTextSearchDeparture.getText().toString();
                destinationContent = editTextSearchDestination.getText().toString();
                dateContent = editTextSearchDate.getText().toString();

                if ((departContent.equals("")) || (destinationContent.equals(""))) {
                    Toast.makeText(SearchItineraryActivity.this, "Veuillez renseigner votre départ et votre destination", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    Date date;
                    try {
                        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy-hh:mm");
                        date = dateFormat.parse(dateContent);
                    }
                    catch (ParseException e) {
                        Log.e("Bla Bla Wild", "Can't Parse Date");
                        date = new Date();
                    }

                    Intent intent = new Intent(getApplicationContext(), ViewSearchItineraryResultsListActivity.class);
                    SearchRequestModel searchRequestModel = new SearchRequestModel(departContent, destinationContent, date);
                    intent.putExtra("searchRequestModel", searchRequestModel);
                    startActivity(intent);
                }
            }
        });
    }
}
