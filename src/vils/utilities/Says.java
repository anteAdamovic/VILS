package vils.utilities;

public class Says {
    private String mName;

    public Says(String name){
        mName = name;
    }

    public String say(String message){
        return mName + " says: " + message; 
    }
}