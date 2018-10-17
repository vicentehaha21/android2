package com.example.lucas.todoapplication;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.lucas.todoapplication.domain.ResponseData;
import com.example.lucas.todoapplication.domain.TmdbData;
import com.example.lucas.todoapplication.integration.ResponseCallback;
import com.example.lucas.todoapplication.service.DownloadImageService;
import com.example.lucas.todoapplication.service.TmdbService;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ResponseCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
    }

    @Override
    public void onSuccess(ResponseData data) {

    }

    @Override
    public void onSuccess(List data) {

    }

    @Override
    public void onError(Throwable e) {
        new AlertDialog.Builder(this)
                .setTitle("Ops")
                .setMessage("Deu um erro")
                .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                .create()
                .show();
    }
}
