import java.lang.Math;

//child class of Generate
public class Pin extends Generate {
	
	//constructor
	public Pin(int min, int max) {
		super(min, max);

	}

	@Override
	public char [] generate(int len) { //generate pin of set length
		char [] generated = new char[len];
		
		char [] digits = new char[] {'0','1','2','3','4','5','6','7','8','9'};
		int mx = digits.length-1;
		int m = 0;
		int temp = (int)Math.floor(Math.random()*(mx - m) + 1) + m;
		
		generated[0] = digits[temp];
		int count = 1;
		
		while(count < len) {
			
			temp = (int)Math.floor(Math.random()*(mx - m) + 1) + m;
			if(digits[temp] != generated[count-1]) {
				generated[count] = digits[temp];
				count +=1;
			}
		}
		return generated;
	}
}
