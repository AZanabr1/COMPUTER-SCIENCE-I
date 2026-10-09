/* 

 * Class: CMSC203  

 * Instructor: Ahmed Tarek 

 * Description: In this program we are creating encryptions from the users input. 
				We prompt the user to input a plain text and input a key (if it's
				a Caesar encryption), it would be an int. Using the
				plain text and key create an encryption. Every
				type of encryption has a method of decryption by using
				the encryption and the key.

 * Due: 10/14/2026

 * Platform/compiler: ECLIPSE

 * I pledge that I have completed the programming  assignment independently.  

*  I have not copied the code from a student or any source.  

*  I have not given my code to any student. 

*  Print your Name here: Antonio Zanabria 

*/ 
public class CryptoManager { 

    private static final char LOWER_RANGE = ' ';
    private static final char UPPER_RANGE = '_';
    private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;    
    private static final String ALPHABET64 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 !\"#$%&'()*+,-./:;<=>?@[\\]^_";
    
    public static boolean isStringInBounds(String plainText) {
        for (int i = 0; i < plainText.length(); i++) {
            if (!(plainText.charAt(i) >= LOWER_RANGE && plainText.charAt(i) <= UPPER_RANGE)) {
                return false;
            }
        }
        return true;
    }

    public static String vigenereEncryption(String plainText, String key) {
         if(!isStringInBounds(plainText)) {
        	 return "The selected string is not in bounds, Try again.";
         }
         
         String encryptedText = ""; 
         int keyIndex = 0; 
         
         for(int i = 0; i < plainText.length(); i++) {
        	 char currentChar = plainText.charAt(i); 
        	 char keyChar = key.charAt(keyIndex);
        	 int shiftNumber = keyChar - LOWER_RANGE;
        	 int shiftedChar = currentChar + shiftNumber; 
        	 while(shiftedChar > UPPER_RANGE) {
        		 shiftedChar -= RANGE; 
        	 }
        	 
        	 encryptedText += (char) shiftedChar; 
        	 keyIndex++;
        	 
        	 //we use this if so the index resets to zero and 
        	 //we repeat the key word
        	 if(keyIndex == key.length()) {
        		 keyIndex = 0;
        	 }
         }
         return encryptedText; 
    }

 
    public static String vigenereDecryption(String encryptedText, String key) {
         String decryptedText = ""; 
         int keyIndex = 0; 
       
         for(int i = 0; i < encryptedText.length(); i++) {
        	 char currentChar = encryptedText.charAt(i); 
        	 char keyChar = key.charAt(keyIndex);
        	 int shiftNumber = keyChar - LOWER_RANGE; 
        	 int shiftedChar = currentChar - shiftNumber; 
        	 while(shiftedChar < LOWER_RANGE) {
        		 shiftedChar += RANGE; 
        	 }
        	 
        	 decryptedText += (char) shiftedChar;
        	 keyIndex++; 
        	 
        	 if(keyIndex == key.length()) {
        		 keyIndex = 0; 
        	 }
         }
         return decryptedText; 
    	
    } 

    public static String playfairEncryption(String plainText, String key) {
        String encryptedString ="";
        String keyChecked = ""; 
        int keyIndex = 0; 
        
    	if(!isStringInBounds(plainText)) {
        	 return "The selected string is not in bounds, Try again."; 
         }
    	char [][] playFairGrid = new char[8][8]; 
    	
    	for(int i = 0; i < key.length(); i++) {
    		char currentChar = key.charAt(i);
    		if(keyChecked.indexOf(currentChar) == -1) {
    			keyChecked += currentChar; 
    		}
    	}
    	
    	for(int j = 0; j < ALPHABET64.length(); j++) {
    		char currentChar = ALPHABET64.charAt(j);
    		if(keyChecked.indexOf(currentChar) == -1) {
    			keyChecked += currentChar; 
    		}
    	}
    	 
    	
    	for(int row = 0; row < 8; row++) {
    		for(int col = 0; col < 8; col++) {
    				playFairGrid [row][col] = keyChecked.charAt(keyIndex); 
    				keyIndex++; 
    		}
    	}
    	for(int i = 0; i < plainText.length(); i +=2) {
    	   char char1 = plainText.charAt(i); 
    	   char char2 = plainText.charAt(i +1);
    	   int c1 = 0, c2 =0, r1 = 0, r2 = 0; 
    	   
    	   for(int row = 0; row < 8; row++) {
	       	for(int col = 0; col < 8; col++) {
	       		if(playFairGrid [row][col] == char1) {
	       			r1 = row; 
	       			c1 = col; 
	       		}
	       		if(playFairGrid [row][col] == char2) {
	       			r2 = row; 
	       			c2 = col; 
	       		}
	       	}
    	}
	       		
	     if(r1 == r2) {
	       			if(c1 == 7) {
	       				encryptedString += playFairGrid[r1][0];
	       			}
	       			else {
	       				encryptedString += playFairGrid[r1][c1 + 1];
	       			}
	       			if(c2 == 7) {
	       				encryptedString += playFairGrid[r2][0];
	       			}
	       			else {
	       				encryptedString += playFairGrid[r2][c2 + 1];
	       			}
	       			
	       		}
	       		else if(c1 == c2){
	       			if(r1 == 7) {
	       				encryptedString += playFairGrid[0][c1]; 
	       			}
	       			else {
	       				encryptedString += playFairGrid[r1 + 1][c1];
	       			}
	       			
	       			if(r2 == 7) {
	       				encryptedString += playFairGrid[0][c2]; 
	       			}
	       			else {
	       				encryptedString += playFairGrid[r2 +1][c2]; 
	       			}
	       		}
	       		else {
	       			encryptedString += playFairGrid[r1][c2]; 
	       			encryptedString += playFairGrid[r2][c1];
	       		}		
	       	  } 		
    	  return encryptedString; 
       	  
    }

    public static String playfairDecryption(String encryptedText, String key) {
    	String decryptedString ="";
        String keyChecked = ""; 
        int keyIndex = 0; 
        
    	if(!isStringInBounds(encryptedText)) {
        	 return "The selected string is not in bounds, Try again."; 
         }
    	char [][] playFairGrid = new char[8][8]; 
    	
    	for(int i = 0; i < key.length(); i++) {
    		char currenctChar = key.charAt(i);
    		if(keyChecked.indexOf(currenctChar) == -1) {
    			keyChecked += currenctChar; 
    		}
    	}
    	
    	for(int j = 0; j < ALPHABET64.length(); j++) {
    		char currenctChar = ALPHABET64.charAt(j);
    		if(keyChecked.indexOf(currenctChar) == -1) {
    			keyChecked += currenctChar; 
    		}
    	}
    	 
    	
    	for(int row = 0; row < 8; row++) {
    		for(int col = 0; col < 8; col++) {
    				playFairGrid [row][col] = keyChecked.charAt(keyIndex); 
    				keyIndex++; 
    		}
    	}
    	for(int i = 0; i < encryptedText.length(); i +=2) {
    	   char char1 = encryptedText.charAt(i); 
    	   char char2 = encryptedText.charAt(i +1);
    	   int c1 = 0, c2 =0, r1 = 0, r2 = 0; 
    	   
    	   for(int row = 0; row < 8; row++) {
	       	for(int col = 0; col < 8; col++) {
	       		if(playFairGrid [row][col] == char1) {
	       			r1 = row; 
	       			c1 = col; 
	       		}
	       		if(playFairGrid [row][col] == char2) {
	       			r2 = row; 
	       			c2 = col; 
	       		}
	       			
	       	}
       	  }
    	   if(r1 == r2) {
      			if(c1 == 0) {
      				decryptedString += playFairGrid[r1][7];
      			}
      			else {
      				decryptedString += playFairGrid[r1][c1 - 1];
      			}
      			if(c2 == 0) {
      				decryptedString += playFairGrid[r2][7];
      			}
      			else {
      				decryptedString += playFairGrid[r2][c2 - 1];
      			}
      			
      		}
      		else if(c1 == c2){
      			if(r1 == 0) {
      				decryptedString += playFairGrid[7][c1]; 
      			}
      			else {
      				decryptedString += playFairGrid[r1 - 1][c1];
      			}
      			
      			if(r2 == 0) {
      				decryptedString += playFairGrid[7][c2]; 
      			}
      			else {
      				decryptedString += playFairGrid[r2 - 1][c2]; 
      			}
      		}
      		else {
      			decryptedString += playFairGrid[r1][c2]; 
      			decryptedString += playFairGrid[r2][c1];
      		}		
      	  } 		
    	
         return decryptedString; 
    }
    
 
    public static String caesarEncryption(String plainText, int key) {
    	if(!isStringInBounds(plainText)) {
       	 return "The selected string is not in bounds, Try again.";
        }
    	
    	String encryptedText = ""; 
    	
    	for(int i = 0; i < plainText.length(); i++) {
    		int currentChar = plainText.charAt(i); 
    		int shift = currentChar + key; 
    		while(shift > UPPER_RANGE) {
    			shift -= RANGE; 
    		}
    		encryptedText += (char) shift;
    	}
    	return encryptedText; 
    	
    }
    
    public static String caesarDecryption(String encryptedText, int key) {
    	if(!isStringInBounds(encryptedText)) {
       	 return "The selected string is not in bounds, Try again.";
        }
    	
    	String decryptedText = ""; 
    	
    	for(int i = 0; i < encryptedText.length(); i++) {
    		int currentChar = encryptedText.charAt(i); 
    		int shift = currentChar - key; 
    		while(shift < LOWER_RANGE) {
    			shift += RANGE; 
    		}
    		decryptedText += (char) shift; 
    	}
    	return decryptedText; 
    }    

}
