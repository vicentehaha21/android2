package com.example.lucas.todoapplication.util;

import android.content.Context;
import android.support.v7.app.AlertDialog;

public class DialogUtils {
    public static void errorDialog(Context context) {
        new AlertDialog.Builder(context)
                .setTitle("Ops")
                .setMessage("Deu um erro")
                .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                .create()
                .show();
    }
}
