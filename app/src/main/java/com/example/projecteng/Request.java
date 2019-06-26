package com.example.projecteng;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**Klasa pomocnicza slownika jezyka angielskiego
 * wykorzystuje REST API brytyjskiej uczelni Oxford*/

public class Request extends AsyncTask<String, Integer, String> {

    TextView Meaning, example;


    //id klucza
    final String app_id = "9c7021c1";
    //klucz do REST API
    final String app_key = "3e3ef41306c2c892f29815fc6b144cfc";
    //adres url
    String myurl;
    Context context;

    Request(Context context, TextView tV, TextView xS)
    {
        this.context = context;
        Meaning = tV;
        example = xS;
    }

    @Override
    protected String doInBackground(String... params) {

        myurl = params[0];
        try {
            URL url = new URL(myurl);
            //nawiazywanie polaczenia z serwerem
            HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
            urlConnection.setRequestProperty("Accept", "application/json");
            urlConnection.setRequestProperty("app_id", app_id);
            urlConnection.setRequestProperty("app_key", app_key);

            // read the output from the server
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            StringBuilder stringBuilder = new StringBuilder();

            String line = null;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line + "\n");
            }

            return stringBuilder.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return e.toString();
        }
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);


        String def, exs;

        try
        {
            JSONObject js = new JSONObject(s);
            JSONArray results = js.getJSONArray("results");

            JSONObject lEntries = results.getJSONObject(0);
            JSONArray laArray = lEntries.getJSONArray("lexicalEntries");

            JSONObject entries = laArray.getJSONObject(0);
            JSONArray e = entries.getJSONArray("entries");

            JSONObject jsonObject = e.getJSONObject(0);
            JSONArray sensesArray = jsonObject.getJSONArray("senses");


            JSONObject d = sensesArray.getJSONObject(0);
            JSONArray de = d.getJSONArray("definitions");
            def = de.getString(0);
            Meaning.setText("Definition:"+ "\n" + def);


            //PRZYKLADOWE ZDANIA:
            JSONArray ex = d.getJSONArray("examples");
            exs = ex.getString(0);


            StringBuilder str = new StringBuilder(exs);
            for (int i=0; i<9; i++){
                str.deleteCharAt(0);

            }

            str.deleteCharAt(str.length() - 1);
            str.deleteCharAt(str.length() - 1);
            example.setText("Example:" + "\n" + str);

            //Toast.makeText(context,def,Toast.LENGTH_SHORT).show();

        }catch(JSONException e)
        {
            e.printStackTrace();
        }
    }
}
