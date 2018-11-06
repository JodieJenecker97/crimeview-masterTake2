package t.flatearchsocie.crimeview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EditProfile extends Activity {


    DatabaseHandler databaseHandler;

    String username;
    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        Intent intent = this.getIntent();
        username = intent.getStringExtra("user");
        EditText txtView = findViewById(R.id.nameChange);
        txtView.setText(username);
        databaseHandler = DatabaseHandler.getInstance();
    }


    public Integer getUserId() {

        return null;
    }

    public void editProfileSQL(View view) {
        EditText edtTextUsername = findViewById(R.id.nameChange);
        EditText edtTextPassword = findViewById(R.id.surnameChange);
        //Integer UserID = 2;
       // username = edtTextUsername.getText().toString();
       password = edtTextPassword.getText().toString();


        String Name = "Clint";
        String Surname = "Mclean";
        Integer UserType = 1;

        try {
            //Query works
            // String sql = " UPDATE UserTable SET Username = '" + username + "', Password = '" + password + "', UserType=1  WHERE UserID = 2 ";
            // String sql = " UPDATE UserTable SET Username = '" + username + "', Password = '" + password + "', Name ='" + Name + "', Surname='" + Surname + "', UserType=1  WHERE UserID = 2 ";
            //   String sql = " UPDATE UserTable SET Username = '" + Username + "', Password = '" + Password + "', Name ='" + Name + "', Surname='" + Surname + "', UserType=1  WHERE User
            if (databaseHandler.editProfile(password, username)) {
                Toast.makeText(this, "Update successful", Toast.LENGTH_LONG).show();
            } else {

                Toast.makeText(this, "Could not update", Toast.LENGTH_LONG).show();
            }

        } catch (Exception e) {

            Log.d("Fail", "editProfileSQL: Fail");
        }
    }
}
