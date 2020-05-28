package com.example.dialogfragmentactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MyCustomDialog.OnInputListener {

    public static final String TAG="MainActivity";
    private Button mOpenDialog;
    public TextView mInputDisplay;

    public String mInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mOpenDialog = findViewById(R.id.open_dialog_btn);
        mOpenDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"OnClick: Opening Dialog");
                MyCustomDialog dialog = new MyCustomDialog();
                dialog.show(getSupportFragmentManager(),"MyCustomDialog");
            }
        });

    }

    @Override
    public void sendInput(String input) {
        Log.d(TAG,"sendInput" + input);
        mInputDisplay.setText(input);
    }
}
