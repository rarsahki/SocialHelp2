package com.example.android.socialhelp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 07-07-2017.
 */

public final class QueryUtils {
    public static List<NewsRequests> fetchData(String mURL){
        URL url = createUrl(mURL);
        String jsonResponse = null;
        try {
            jsonResponse = makeHTTPRequest(url);
        }catch (IOException e) {
            e.printStackTrace();
        }
        List<NewsRequests> requestsList = extractData(jsonResponse);
        return requestsList;
    }

    public static URL createUrl(String murl){
        URL url = null;
        try {
            url = new URL(murl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }

    private static String makeHTTPRequest(URL url) throws IOException{
        String jsonResponse = null;
        if(url == null)
            return jsonResponse;

        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(1000);
            urlConnection.setConnectTimeout(1500);
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            if(urlConnection.getResponseCode() == 200){
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromInput(inputStream);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(urlConnection != null)
                urlConnection.disconnect();
            if(inputStream != null)
                inputStream.close();
        }
        return jsonResponse;
    }

    private static String readFromInput(InputStream inputStream) throws IOException{
        StringBuilder output = new StringBuilder();
        if(inputStream != null){
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line = bufferedReader.readLine();
            while (line != null){
                output.append(line);
                line = bufferedReader.readLine();
            }
        }
        return output.toString();
    }

    private static List<NewsRequests> extractData(String jsonResponse){
        List<NewsRequests> requestsList = new ArrayList<>();
        try {
            JSONObject jsonObject1 = new JSONObject(jsonResponse);
            JSONArray jsonArray1 = jsonObject1.getJSONArray("articles");
            for (int i = 0;i<jsonArray1.length();i++){
                JSONObject jsonObject2 = jsonArray1.getJSONObject(i);
                String title = jsonObject2.getString("title");
                String description = jsonObject2.getString("description");
                String url = jsonObject2.getString("url");
                String urlToImage = jsonObject2.getString("urlToImage");
                Bitmap bitmap = BitmapFactory.decodeStream(createUrl(urlToImage).openConnection().getInputStream());
                requestsList.add(new NewsRequests(title,description,url,urlToImage,bitmap));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return requestsList;
    }

}
