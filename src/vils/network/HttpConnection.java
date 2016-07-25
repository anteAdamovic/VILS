package vils.network;

import java.net.MalformedURLException;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

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