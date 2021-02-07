package com.example.bar2db;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class SendPostDataActivity extends AsyncTask<String, String, String> {
    private Context context;
    private TextView textView;

    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");

    public SendPostDataActivity(Context context, TextView textView) {
        this.context = context;
        this.textView = textView;
    }

    @Override
    protected String doInBackground(String... strings) {
        String json = "{\"typeText\":\"" + strings[0] + "\", \"amountText\":" + strings[2] + "}";

        //this.textView.setText(json);
        Log.d("json", json);
        OkHttpClient client = new OkHttpClient();

        String url = "http://" + strings[1] +"/postMysql.php";
        RequestBody body = RequestBody.create(JSON, json);

        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        try {
            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            //return new String("Exception: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String str){
        Log.d("Debug", str);
        this.textView.setText(R.string.complete);
    }
}

