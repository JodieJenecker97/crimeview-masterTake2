package t.flatearchsocie.crimeview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLException;

public class Verify_Delete extends AppCompatActivity {
    DatabaseHandler databaseHandler;
    Crime crime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify__delete);
        Intent intent = getIntent();
        crime = (Crime) intent.getSerializableExtra("crime");
        databaseHandler = DatabaseHandler.getInstance();
        try {
            populateUI();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void populateUI() throws SQLException {

        TextView txtCrimeType = findViewById(R.id.txtCrimeType);
        txtCrimeType.setText("Crime Type : " + databaseHandler.getCategory(crime.getCategoryID()));

        TextView txtUser = findViewById(R.id.txtUserReported);
        txtUser.setText("Reported By : " + databaseHandler.getUser(crime.getUserID()));

        TextView txtTime = findViewById(R.id.txtTimeReported);
        txtTime.setText("Time Reported : " + crime.getTimeRecorded().toString());

        TextView txtDate = findViewById(R.id.txtDateRecorded);
        txtDate.setText("Date Reported : " + crime.getDate().toString());
        TextView txtVerified = findViewById(R.id.txtVerified);

        if (crime.getVerified()) {
            txtVerified.setText("Verified : Yes");
        } else {
            txtVerified.setText("Verified : No");
        }
    }


    public void deleteCrime(View view) {

    }

    public void verifyCrime(View view) throws SQLException {


        //Check why it doesn't toast

        if (databaseHandler.verifyCrime(crime.getCrimeID())) {

            Toast.makeText(getApplicationContext(), "Crime Verified", Toast.LENGTH_LONG);
            crime.setVerified(true);
        } else {

            Toast.makeText(getApplicationContext(), "Crime Verification failed", Toast.LENGTH_LONG);
        }


    }
}
