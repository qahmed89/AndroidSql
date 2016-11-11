package com.example.dragonsaiyan.androidsql;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText ed1 = (EditText) findViewById(R.id.editText);
        final TextView tx = (TextView)findViewById(R.id.textView);
        Button button= (Button)findViewById(R.id.button );
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread run = new Thread();
                CallWebService cweb = new CallWebService();
                cweb.getcount(ed1.getText().toString());
                run.start();
                try {
                    run.join();
                    tx.setText(ContactResult.getcountResult);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
