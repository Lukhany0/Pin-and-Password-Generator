
import java.lang.Math;

//parent class for generating random 
public class Generate {

	protected int min;
	protected int max;
	private String output = "";
	
	public Generate(int min, int max) {
		
		this.min = min;
		this.max = max;
	}
	
	public char [] generate(int length) {
		
		char [] generated = new char[length];
		
		return generated;
	}
	
	public void setOutput(char [] chars) {
		
		for(int i=0; i<chars.length; i++) {
			output +=chars[i];
		}
	}
	public String getOutput() {
		return output;
	}
}
