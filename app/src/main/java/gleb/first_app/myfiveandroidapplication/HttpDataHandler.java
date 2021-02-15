package gleb.first_app.myfiveandroidapplication;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class HttpDataHandler {
    static String stream=null;
    public HttpDataHandler(){

    }
    public String getHttp_Response(String urlAdress){
        try {
            URL url= new URL(urlAdress);
            HttpURLConnection urlConnection = (URLConnection)url.openConnection();
            if(urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK){
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                BufferedReader br = new BufferedReader(new InputStreamReader());
                StringBuilder sb = new StringBuilder();
                String line;
                while((line = br.readline()) != null){
                    sb.append(line);
                }
                stream = sb.toString();
            }
        }catch(MalformedURLException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
        return stream;
    }
}
