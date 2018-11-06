package t.flatearchsocie.crimeview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BanReasons extends AppCompatActivity {

    TextView test;
    DatabaseHandler databaseHandler;
    private  Connection connection = null;
    private Statement preparedStatement = null;
    ResultSet resultSet = null;
    String userName = "";
    String reason ;
    EditText editText;
    Button proceedBut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ban_reasons);

        editText = (EditText) findViewById(R.id.ETreason);
        databaseHandler = DatabaseHandler.getInstance();
        connection = databaseHandler.getCon();
        proceedBut = (Button) findViewById(R.id.proceedBut);
        test = (TextView) findViewById(R.id.textView3);

        Intent thisIntent = getIntent();
        if (thisIntent != null) {
            Bundle extras = thisIntent.getExtras();
            if (extras != null) {
                userName = extras.getString("nameOfUser");
                //test.setText(userName);
            }
        }

        proceedBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    reason = editText.getText().toString();
                    proceedButton();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void proceedButton() throws SQLException {
        databaseHandler.BanUser(userName, reason);
    }

}
