package com.scanimaniacs.com.scanigy;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by TekGeek88 on 10/18/15.
 */
public class NetworkThread {


    private InputStream downloadUrl(String newUrl) {
        HttpURLConnection con = null;
        URL myUrl;
        InputStream is=null;
        try {
            myUrl = new URL(newUrl);
            con = (HttpURLConnection) myUrl.openConnection();
            con.setReadTimeout(10000 /* milliseconds */);
            con.setConnectTimeout(15000 /* milliseconds */);
            con.setRequestMethod("GET");
            con.setDoInput(true);
            con.addRequestProperty("Referer", "http://blog.dahanne.net");
            // Start the query
            con.connect();
            is = con.getInputStream();
        }catch (IOException e) {
            //handle the exception !
            e.printStackTrace();
        }
        return is;

    }



    /*
    URL url = new URL("some url");


    public void onClick(View v) {
        new Thread(new Runnable() {
            public void run() {
                final URL myURL = new URL("http://api.upcdatabase.org/xml/8353cca56727d3bbb53d875e1f4d5692/611269991000");

                mImageView.post(new Runnable() {


                    public void run() {
                        mImageView.setImageBitmap(bitmap);
                    }
                });
            }
        }).start();
    }
*/

}
