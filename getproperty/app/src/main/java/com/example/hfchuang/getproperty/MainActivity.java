package com.example.hfchuang.getproperty;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Properties;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private TextView textView;
    private Button onebtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText=(EditText)findViewById(R.id.editText);
        textView=(TextView)findViewById(R.id.textView);
        onebtn=(Button)findViewById(R.id.button);
        onebtn.setOnClickListener(onebtnclick);


    }

    private Button.OnClickListener onebtnclick=new Button.OnClickListener(){
        public void onClick(View v){

            Toast.makeText(getApplicationContext(), "button onclick", Toast.LENGTH_LONG).show();
            Properties prots = System.getProperties();
            //String osName = prots.getProperty("os.name");
            String f=editText.getText().toString();
            Log.v("HF debug", f);
            String osName = prots.getProperty(f);
            textView.setText(osName);
        }
    };



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
