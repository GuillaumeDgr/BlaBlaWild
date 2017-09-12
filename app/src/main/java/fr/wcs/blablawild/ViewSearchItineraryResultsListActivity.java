package fr.wcs.blablawild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static fr.wcs.blablawild.R.id.textView5;

public class ViewSearchItineraryResultsListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_search_itinerary_results_list);

        Intent intent = getIntent();
        String message = intent.getStringExtra("lieuDepart");
        String message2 = intent.getStringExtra("lieuDepart2");
        TextView textView = (TextView) findViewById(R.id.textView4);
        TextView textView2 = (TextView) findViewById(textView5);
        textView.setText(message);
        textView2.setText(message2);

        setTitle(message + " >> " + message2);
    }
}
