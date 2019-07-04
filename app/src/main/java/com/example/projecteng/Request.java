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

    TextView Meaning, example; /**< tworzymy dwa properties: Meaning oraz example typu TextView */


    final String app_id = "9c7021c1"; /**< deklarujemy stałą zmienną app_id typu String, do której przypisujemy ID naszego konta */
    final String app_key = "3e3ef41306c2c892f29815fc6b144cfc"; /**< deklarujemy stałą zmienną app_key typu String, do której przypisujemy klucz naszego konta */
    String myurl; /**<  deklarujemy zmienną myurl */
    Context context; /**<  tworzymy property context typu Context, który pierwotnie był wykorzystywany w Toast.makeText, jednak ostatecznie odeszliśmy od tego rozwiązania*/

    /** \brief konstruktor przyjmujący 3 argumenty z properties: context, tV oraz xS*/
    Request(Context context, TextView tV, TextView xS)
    {
        this.context = context; /**< do property context naszego konstruktora przypisujemy property context*/
        Meaning = tV; /**< do property Meaning naszego konstruktora przypisujemy property tV typu TextView*/
        example = xS; /**< do property example naszego konstruktora przypisujemy property xS typu */
    }
    /** \brief część kodu udostępnionego przez Oxford API Dictionaries: https://developer.oxforddictionaries.com/documentation, w którym wykorzystujemy klasę urlConnection umożliwiają komunikację z adresem URL poprzez zastosowanie jej metod  */
    @Override
    protected String doInBackground(String... params) {

        myurl = params[0];
        try {
            URL url = new URL(myurl); /**< tworzymy nowy obiekt klasy URL z wywołanym parametrem myurl*/
            HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection(); /**< tworzymy property urlConnection typu HttpsURLConnection, a następnie przypisujemy do niego wartość zwracaną przez metodę openConnection() property url */
            urlConnection.setRequestProperty("Accept", "application/json"); /**< wywołujemy metodę setRequestProperty z parametrami Accept oraz application/json, wykorzystując json */
            urlConnection.setRequestProperty("app_id", app_id); /**< wywołujemy metodę setRequestProperty z parametrem naszego ID Oxford Dictionaries API*/
            urlConnection.setRequestProperty("app_key", app_key); /**< wywołujemy metodę setRequestProperty z parametrem naszego klucza konta */

            /** \brief  odczytywanie danych wyjściowych z serwera*/
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream())); /**< tworzymy nowy obiekt reader klasy BufferedRead z podanym parametrem*/
            StringBuilder stringBuilder = new StringBuilder(); /**< tworzymy nowy obiekt stringBuilder klasy StringBuilder*/

            String line = null;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line + "\n"); /**< dla każdej nowej linii dodajemy odstęp */
            }

            return stringBuilder.toString();

        } catch (Exception e) { /**< blok catch{ }, w którym zadeklarowano wyjątek */
            e.printStackTrace();
            return e.toString();
        }
    }

    @Override
    protected void onPostExecute(String s) {/** \brief funkcja onPostExecute wywołana
     * @param s odpowiedzialna za wyświetlenie definicji danego słowa oraz użycie go w przykładowym zdaniu*
     * /

        super.onPostExecute(s);/** \brief konstrukcja z wykorzystaniem super, która służy do wywołania konstruktora klasy nadrzędnej o parametrze zmiennej s*/



        String def, exs; /**< deklaracja zmiennej def, do której będzie przekazana ostateczna definicja wyrazu oraz zmiennej exs, do której będzie przekazane ostatecznie przykładowe użycie w zdaniu */


        try
        {
            JSONObject js = new JSONObject(s); /**< tworzymy obiekt js klasy JSONObject z wywołanym parametrem s */
            JSONArray results = js.getJSONArray("results"); /**< tworzymy property results typu JSONArray, do results przypisujemy wartość zwracanej metody getJSONArray obiektu js z parametrem "results", sama metoda getJSONArray pobiera JSONArray z powiązaną wartością indeksu*/

            JSONObject lEntries = results.getJSONObject(0);
            JSONArray laArray = lEntries.getJSONArray("lexicalEntries"); /**< tworzymy property laArray typu JSONArray, do laArray przypisujemy wartość zwracanej metody getJSONArray property lEntries z parametrem "lexicalEntries", sama metoda getJSONArray pobiera JSONArray z powiązaną wartością indeksu*/

            JSONObject entries = laArray.getJSONObject(0);
            JSONArray e = entries.getJSONArray("entries"); /**< tworzymy property e typu JSONArray, do e przypisujemy wartość zwracanej metody getJSONArray property entries z parametrem "entries", sama metoda getJSONArray pobiera JSONArray z powiązaną wartością indeksu*/

            JSONObject jsonObject = e.getJSONObject(0);
            JSONArray sensesArray = jsonObject.getJSONArray("senses"); /**< tworzymy property sensesArray typu JSONArray, do sensesArray przypisujemy wartość zwracanej metody getJSONArray property jsonObject z parametrem "senses", sama metoda getJSONArray pobiera JSONArray z powiązaną wartością indeksu*/


            JSONObject d = sensesArray.getJSONObject(0);
            JSONArray de = d.getJSONArray("definitions"); /**< tworzymy property de typu JSONArray, do de przypisujemy wartość zwracanej metody getJSONArray property d z parametrem "definitions", sama metoda getJSONArray pobiera JSONArray z powiązaną wartością indeksu*/
            def = de.getString(0); /**< w końcu przypisujemy do zmiennej def definicję wyrazu */
            Meaning.setText("Definition:"+ "\n" + def); /**< Wyświetlam definicję/znaczenie danego wyrazu za pomocą metody setText property Meaning*/


/** \brief część kodu odpowiedzialna za tworzenie przykładowych zdań z danym wyrazem*/
            //PRZYKLADOWE ZDANIA:
            JSONArray ex = d.getJSONArray("examples");
            exs = ex.getString(0);

/** \brief  usuwam początkowych 9 znaków, gdyż Oxford API Dictionaries daje zbędne znaki typu nawias, myślnik itp.*/
            StringBuilder str = new StringBuilder(exs);
            for (int i=0; i<9; i++){
                str.deleteCharAt(0);

            }

/** \brief  pozbywam się dwóch ostatnich znaków z tekstu przykładowego zdania z danym słowem z powodu opisanego powyżej */
            str.deleteCharAt(str.length() - 1);
            str.deleteCharAt(str.length() - 1);
            example.setText("Example:" + "\n" + str);  /**< Wyświetlam przykładowe zdanie za pomocą metody setText property example*/

        }catch(JSONException e)  /**< blok catch{ }, w którym zadeklarowano wyjątek */
        {
            e.printStackTrace();
        }
    }
}
