package com.example.square;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private FoursquareApiService apiService;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = findViewById(R.id.tv1);
        apiService = ApiClient.getClient().create(FoursquareApiService.class);

        // Example API call
        String apiKey = "fsq3NJIqZ1A36C92gWCrqNZTpm0Y86NY5T/dTVDwL0e0ncM=";
        Call<FoursquareResponse> call = apiService.searchPlaces(apiKey, "coffee", "New York, NY", 10);
        call.enqueue(new Callback<FoursquareResponse>() {
            @Override
            public void onResponse(Call<FoursquareResponse> call, Response<FoursquareResponse> response) {
                if (response.isSuccessful()) {
                    FoursquareResponse foursquareResponse = response.body();
                    List<Place> places = foursquareResponse.getResults();
                    // Handle the response and update TextView
                    StringBuilder result = new StringBuilder();
                    for (Place place : places) {
                        result.append("Name: ").append(place.getName()).append("\n");
                        result.append("Address: ").append(place.getLocation().getAddress()).append("\n");
                        result.append("Rating: ").append(place.getRating()).append("\n\n");
                    }
                    tv1.setText(result.toString());
                } else {
                    tv1.setText("Failed to fetch data: " + response.message());
                    Log.e("API Error", "Response Code: " + response.code() + ", Message: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<FoursquareResponse> call, Throwable t) {
                // Handle the error
                tv1.setText("Failed to fetch data: " + t.getMessage());
                Log.e("API Error", t.getMessage());
            }
        });
    }
}
