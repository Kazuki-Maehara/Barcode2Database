package com.example.bar2db;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText typeField, ipField, amountField;
    private TextView textView;
    private Button sendButton;
    private ImageButton cameraButton;
    private static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendButton = (Button)findViewById(R.id.sendButton);
        cameraButton = (ImageButton)findViewById(R.id.cameraButton);
        typeField = (EditText)findViewById(R.id.typeField);
        ipField = (EditText)findViewById(R.id.ipField);
        amountField = (EditText)findViewById(R.id.amountField);
        textView = (TextView)findViewById(R.id.textView);

        cameraButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(getApplication(), CameraActivity.class);
               startActivityForResult(intent, REQUEST_CODE);
           }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_CODE) {
            if(resultCode == RESULT_OK) {
                typeField.setText(data.getStringExtra("barcode_string"));
            } else if(resultCode == RESULT_CANCELED) {
                typeField.setText("");
            }
        }
    }

    public void sendPost(View view) {
        String typeText = typeField.getText().toString();
        String ipText = ipField.getText().toString();
        String amountText = amountField.getText().toString();

        textView.setText(R.string.sending);
        new SendPostDataActivity(this, textView).execute(typeText, ipText, amountText);

    }

}
