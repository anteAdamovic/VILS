package vils.network;

import java.net.MalformedURLException;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class HttpConnection {
    private String mDomain;
    private String mPath = "";
    private URL mUrl;
    private URLConnection mConnection;

    public HttpConnection(String domain, String path){
        mDomain = domain;
        setPath(path);

        constructUrl();
        connect();
    }

    public HttpConnection(String domain){
        mDomain = domain;

        constructUrl();
        connect();
    }

    public void goTo(String path){
        setPath(path);

        constructUrl();
        connect();
    }

    public void goBack(){
        if(mPath == "")
            return;
        else if(!mPath.contains("/"))
            mPath = "";
        else if(mPath.contains("/")){
            mPath = mPath.substring(0, mPath.lastIndexOf("/"));
        }

        constructUrl();
        connect();
    }

    public String getContent(){
      try {
        mConnection.connect();

        String content = "", line;
        BufferedReader br = new BufferedReader(new InputStreamReader(mConnection.getInputStream()));
        do {
          line = br.readLine();
          if(line != null)
            content += line + "\n";
        } while(line != null);

        return content;
      } catch(IOException e){
        e.printStackTrace();
      }

      return "Exception occured while reading the page.";
    }

    private void setPath(String path){
        if(mPath == "" && !path.startsWith("/"))
            mPath = "/" + path;
        else if(mPath == "" && path.startsWith("/"))
            mPath = path;
        else if(mPath != "" && mPath.endsWith("/") && !path.startsWith("/"))
            mPath += path;
        else if(mPath != "" && mPath.endsWith("/") && path.startsWith("/"))
            mPath += path.substring(1, path.length());
        else if(mPath != "" && !mPath.endsWith("/") && !path.startsWith("/"))
            mPath += "/" + path;
        else if(mPath != "" && !mPath.endsWith("/") && path.startsWith("/"))
            mPath += path;
    }

    private void constructUrl(){
        try {
            mUrl = new URL(mDomain + mPath);
        } catch(MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private void connect(){
        try {
            mConnection = mUrl.openConnection();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public String getUrl(){
        return mUrl.toString();
    }
}
