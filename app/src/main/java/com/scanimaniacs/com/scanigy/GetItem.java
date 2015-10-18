package com.scanimaniacs.com.scanigy;

import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by TekGeek88 on 10/18/15.
 */
public class GetItem implements Runnable{
    private static String[] itemDetailsRefined = new String[2];

    static String[] getItem(String newUpc){


        String upc = "";
        String description = "";
        String line;
        final URL url;



// This code prints the contents of an html file on a server
        try {
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

    }
    catch (Exception e){
        e.printStackTrace();
    }


        itemDetailsRefined[0] = upc;
        itemDetailsRefined[1] = description;


        return itemDetailsRefined;

    }


    @Override
    public void run() {

        getItem(MainActivity.getContents());
    }
}
