//child class of Generate
public class Password extends Generate {
	
	//constructor
	public Password(int min, int max) {
		super(min, max);
	}

	@Override
	public char [] generate(int len) { //generate password of set length
		
		String digits = "0123456789";
		String symbols = "~!@#$%&*()={[}]?+-/<>";
		String alphLower = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String alphCap = "abcdefghijklmnopqrstuvwxyz";
		String comboChars = digits + symbols + alphLower + alphCap;
		
		int tot = comboChars.length()-1;
		char [] combinedChars = comboChars.toCharArray();
		char [] generated = new char[len];
		
		int m=0;
		int mx = digits.length()-1;
		int temp = (int)Math.floor(Math.random()*(mx - m) + 1) + m; //random index
		generated[0] = alphCap.charAt(temp);
		temp = (int)Math.floor(Math.random()*(mx - m) + 1) + m;
		generated[1] = alphLower.charAt(temp);
		temp = (int)Math.floor(Math.random()*(mx - m) + 1) + m;
		generated[2] = digits.charAt(temp);
		temp = (int)Math.floor(Math.random()*(mx - m) + 1) + m;
		generated[3] = symbols.charAt(temp); //first element
		
		int count = 4; //total added characters
		while(count < len) {
			
			temp = (int)Math.floor(Math.random()*(tot - m) + 1) + m;
			if(!searchElement(generated, combinedChars[temp])) {
				generated[count] = combinedChars[temp];
				count +=1;
			}
		}
		return generated;
	}
	boolean searchElement(char [] chars, char c) {
		
		for(int i=0; i<chars.length; i++) {
			if(chars[i] == c) {
				return true;
			}
		}
		return false;
	}
}
