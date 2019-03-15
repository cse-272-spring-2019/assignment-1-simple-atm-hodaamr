import java.util.ArrayList;

public class History {
	static ArrayList <String> history=new ArrayList <String> ();

    public History() {
	
    }
    public static ArrayList<String> getHistory() {
    	return history;	
    }
    public void setHistory(ArrayList<String> history) {
	   History.history = history;
}
}
