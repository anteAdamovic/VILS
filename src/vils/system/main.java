package vils.system;

import vils.utilities.Says;

public class main {
    public static void main(String[] args) {
        Says vils = new Says("VILS");
        System.out.println(vils.say("Hello my name is VILS."));
        System.out.println(vils.say("I am sorry that this is the only thing I can say right now."));
    }
}