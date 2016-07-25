package vils.system;

import vils.utilities.Says;
import vils.network.HttpConnection;

public class main {
    public static void main(String[] args) {
        Says vils = new Says("VILS");
        System.out.println(vils.say("Hello my name is VILS."));
        System.out.println(vils.say("I am sorry that this is the only thing I can say right now."));

        HttpConnection con = new HttpConnection("http://nfcreative.net");
        System.out.println(vils.say("Managed to connect to " + con.getUrl()));
        con.goTo("folder1");        
        System.out.println(vils.say("Moved to " + con.getUrl()));
        con.goTo("folder2");        
        System.out.println(vils.say("Moved to " + con.getUrl()));
        con.goTo("index.html");        
        System.out.println(vils.say("Moved to " + con.getUrl()));
        con.goBack();        
        System.out.println(vils.say("Moved to " + con.getUrl()));
        con.goBack();        
        System.out.println(vils.say("Moved to " + con.getUrl()));
        con.goBack();        
        System.out.println(vils.say("Moved to " + con.getUrl()));
    }
}