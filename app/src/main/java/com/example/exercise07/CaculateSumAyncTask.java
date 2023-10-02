package com.example.exercise07;

import android.app.AlertDialog;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class CaculateSumAyncTask extends AsyncTask<String,Integer,Long> {
    private ProgressBar progressBar;
    private TextView textView;

    public CaculateSumAyncTask(ProgressBar progressBar, TextView textView) {
        this.progressBar = progressBar;
        this.textView = textView;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressBar.setMax(100);
        textView.setText("Loading...!");
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        int progress = values[0];
        progressBar.setProgress(progress);
        textView.setText("Đang tính toán... " + progress + "%");
    }

    @Override
    protected Long doInBackground(String... strings) {

        for (int i = 1; i <= 3000000; i++) {
//
//            // Cập nhật tiến trình trong 100 lần lặp
            if (i % 30000 == 0) {
                int progress = (int) ((i / 3000000.0) * 100);
                publishProgress(progress);
                try {
                    // Tạm dừng việc chạy trong 100ms
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(Long aLong) {
        super.onPostExecute(aLong);
        AlertDialog.Builder builder = new AlertDialog.Builder(textView.getContext());
        LayoutInflater layoutInflater = LayoutInflater.from(textView.getContext());
        View dialogView = layoutInflater.inflate(R.layout.custom_alertdialog, null);

        builder.setView(dialogView);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
