package com.scanimaniacs.com.scanigy;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by TekGeek88 on 10/18/15.
 */


// This code prints the contents of an html file on a server



    public class FetchUpcDataTask2 extends AsyncTask<URL, Integer, String> {

        protected String doInBackground(URL... urls) {
            String result = null;
            if (urls.length != 1) {
                throw new IllegalArgumentException("only one supported at a time");
            }
            try {
                InputStream in = urls[0].openStream();

                // read the stream:
                int ch = 0;
                ByteArrayOutputStream baos = new ByteArrayOutputStream(1024);
                while (-1 != (ch = in.read())) {
                    baos.write(ch);
                }

                result = new String(baos.toByteArray(), "UTF-8");
            }
            catch (Exception e){
                e.printStackTrace();
            }

            return result;
        }

        protected void onProgressUpdate(Integer... progress) {
            // NoOp.
        }

        protected void onPostExecute(String result) {

        }




    }

/*

            // Load a URL into the url variable
            url = new URL(
                    "http://api.upcdatabase.org/xml/8353cca56727d3bbb53d875e1f4d5692/"
                            + upc);

            // Print the information about the loaded url to standard output

            // Open a buffered reader to read the incoming data
            BufferedReader bin = new BufferedReader(new InputStreamReader(
                    url.openStream()));

            String[] itemDetails = new String[10];

            int lineNumber = 0;
            while ((line = bin.readLine()) != null) {

                    int startingChar = line.indexOf('>') + 1;
                    int endingChar = line.indexOf('<', startingChar);
                    if (lineNumber == 3) {
                        upc = (line.substring(startingChar, endingChar));
                    }
                    if (lineNumber == 6) {
                        description = line.substring(startingChar, endingChar);
                    }
                    lineNumber++;

            } // end of while loop




        itemDetailsRefined[0] = upc;
        itemDetailsRefined[1] = description;


        return itemDetailsRefined;


                    */



