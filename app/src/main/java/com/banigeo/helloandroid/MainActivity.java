package com.banigeo.helloandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.net.URI;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private TextView textView;
    private EditText editText;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.app_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.go_to_dev_site:
                goToDevSite();
                return true;
            case R.id.about:
                Snackbar.make(textView, "Android App", Snackbar.LENGTH_SHORT).show();
                return true;
            case R.id.camera:
                takePicture();
                return true;
            default : return super.onOptionsItemSelected(item);
        }

    }

    private void takePicture() {
        Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(takePicture, 1);
    }

    private void goToDevSite() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://developer.android.com"));
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view);
        editText = findViewById(R.id.edit_text);
        Button button = findViewById(R.id.hello_button);
        button.setOnClickListener(this::sayHello);

        if(savedInstanceState != null) {
            textView.setText(savedInstanceState.getString("greeting"));
        }
        Log.d(TAG, "onCreate");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("greeting", textView.getText().toString());
    }

    public void sayHello(View view) {
        String name = editText.getText().toString();
        textView.setText(String.format("Hello %s !", name));
        editText.setText("");
    }


    @Override
    protected void onStart() {
        Log.d(TAG, "onStart");
        super.onStart();
    }
}