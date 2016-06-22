

public class VILSMain {

    public static void main(String[] args){
	VeryIntelligentLanguageSystem VILS = new VeryIntelligentLanguageSystem();
	int VILSReturn = VILS.start();
	System.out.println("VILS exited with code (" + VILSReturn + ").");
    }
}