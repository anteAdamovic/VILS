public class VeryIntelligentLanguageSystem {
    private String fullName = "Very Intelligent Language System";
    private String name = "V.I.C.S";
    private String shortName = "VICS";
    
    public VeryIntelligentLanguageSystem(){
	
    }
    
    public int start(){
	System.out.println("My name is " + name + ".");
	System.out.println("Which stands for " + fullName + ".");
	System.out.println("But you can just call me " + shortName + ".");
	return 1;
    }
}