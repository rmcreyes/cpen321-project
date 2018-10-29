package com.example.johnnyma.testbench;

import android.os.AsyncTask;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * AsyncTask used for sending HTTP request parallel to main UI thread
 */
public class OkHttpTask extends AsyncTask<String, Void, String> {

    // set of constants used for arguments to .execute() to identify
    // the intended HTTP request to use
    public static final String GET_USER_DETAILS = "GET_USER_DETAILS";


    @Override
    protected String doInBackground(String... strings) {
        OkHttpClient client = new OkHttpClient();
        Request request = createRequest(strings);
        try {
            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            return null;
        }
    }

    private Request createRequest(String... strings) {
        Request.Builder builder = new Request.Builder();
        String request_type = strings[0];

        // build the request differently depending on the request type
        switch(request_type) {
            case GET_USER_DETAILS :
                builder.url("http://104.42.209.62:3300/api/user/email/" + strings[1]);
        }

        return builder.build();
    }
}
