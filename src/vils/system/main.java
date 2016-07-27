package vils.system;

import vils.utilities.Says;
import vils.network.HttpConnection;
import vils.network.HTMLObject;

public class main {
    public static void main(String[] args) {
        Says vils = new Says("VILS");
        System.out.println(vils.say("Hello my name is VILS."));
        System.out.println(vils.say("I am sorry that this is the only thing I can say right now."));

        HttpConnection nfcServices = new HttpConnection("http://services.nfcreative.net");
        nfcServices.goTo("showcase/scripts");
        HttpConnection nfcDevelop = new HttpConnection("http://develop.nfcreative.net");

        System.out.println(vils.say("I found this on nfc services: "));
        HTMLObject n = new HTMLObject(nfcServices.getContent());
      }
}
