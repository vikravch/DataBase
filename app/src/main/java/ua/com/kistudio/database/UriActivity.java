package ua.com.kistudio.database;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UriActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uri);

        ((Button) findViewById(R.id.btnCall)).setOnClickListener(this);
        ((Button) findViewById(R.id.btnLocation)).setOnClickListener(this);
        ((Button) findViewById(R.id.btnWeb)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i = null;
        switch (v.getId()){
            case R.id.btnLocation:
                i = new Intent();
                i.setAction(Intent.ACTION_VIEW);
                i.setData(Uri.parse("geo:50.407299, 30.674523"));
                startActivity(i);
                break;

            case R.id.btnCall:
                i = new Intent();
                i.setAction(Intent.ACTION_DIAL);
//                i.setData(Uri.parse("tel:3423456"));
                i.setData(Uri.parse("content://contacts/people/1"));
                startActivity(i);
                break;
            case R.id.btnWeb:
                i = new Intent();
                i.setAction(Intent.ACTION_VIEW);
                i.setData(Uri.parse("http://google.com"));
                startActivity(i);
                break;
        }
    }
}
