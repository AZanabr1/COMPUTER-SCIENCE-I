/* 

 * Class: CMSC203  

 * Instructor: Ahmed Tarek

 * Description: In this program we are creating encryptions from the users input. 
				We prompt the user to input a plain text and input a key (if it's
				a Caesar encryption), it would be an int. Using the
				plain text and key create an encryption. Every
				type of encryption has a method of decryption by using
				the encryption and the key.In this file we are testing the methods 
				that we wrote previously. 
 

 * Due: 10/14/2026 

 * Platform/compiler: 

 * I pledge that I have completed the programming  assignment independently.  

*  I have not copied the code from a student or any source.  

*  I have not given my code to any student. 

*  Print your Name here: Antonio Zanabria 

*/ 


import static org.junit.Assert.*; 
import org.junit.Test; 

public class CryptoManagerTestStudent {
	
	@Test 
	public void testIsStringInBounds() {
		assertTrue(CryptoManager.isStringInBounds("CMSC 203")); 
		assertFalse(CryptoManager.isStringInBounds("Cmsc 203")); 
	}
	
	@Test
	public void testVigenereEncryption() {
		String  encrypted = CryptoManager.vigenereEncryption("JAVA101", "KEY"); 
		assertNotEquals("JAVA101", encrypted);
		assertEquals("The selected string is not in bounds, Try again.", 
					 CryptoManager.vigenereEncryption("java101", "KEY")); 
		
	}
	
	@Test
	public void testVigenereDecryption() {
		String encrypted = CryptoManager.vigenereEncryption("JAVA101", "KEY"); 
		String decrypted = CryptoManager.vigenereDecryption(encrypted,"KEY");
		assertEquals("JAVA101",decrypted); 
		String encryptedV2 = CryptoManager.vigenereEncryption("ECLIPSE","PAPER");
		String decryptedV2 = CryptoManager.vigenereDecryption(encryptedV2, "PAPER");
		assertEquals("ECLIPSE",decryptedV2); 
	}
	
	@Test
	public void testPlayfairEncryption() {
		String encrypted = CryptoManager.playfairEncryption("PROGRAMMING!", "PLAY"); 
		assertNotEquals("PROGRAMMING!",encrypted); 
		assertEquals("The selected string is not in bounds, Try again.", 
				CryptoManager.playfairEncryption("programming", "PLAY")); 
	}
	
	@Test
	public void testPlayfairDecryption() {
		String encrypted = CryptoManager.playfairEncryption("PROGRAMMING!", "PLAY"); 
		String decrypted = CryptoManager.playfairDecryption(encrypted,"PLAY");
		assertEquals("PROGRAMMING!",decrypted); 
		String encryptedV2 = CryptoManager.playfairEncryption("PYTHON","SHIFT");
		String decryptedV2 = CryptoManager.playfairDecryption(encryptedV2, "SHIFT");
		assertEquals("PYTHON",decryptedV2); 
	}
	
	@Test
	public void testCaesarEncryption() {
		String encrypted = CryptoManager.caesarEncryption("MICROSOFT!", 7);
		assertNotEquals("MICROSOFT!", encrypted); 
		assertEquals("The selected string is not in bounds, Try again.", 
				CryptoManager.caesarEncryption("microsoft", 7));
	}
	
	@Test
	public void testCaesarDecryption() {
		String encrypted  = CryptoManager.caesarEncryption("MICROSOFT!", 7);
		String decrypted = CryptoManager.caesarDecryption(encrypted, 7); 
		assertEquals("MICROSOFT!", decrypted);
		String encryptedV2 = CryptoManager.caesarEncryption("APPLE!", 6); 
		String decryptedV2 = CryptoManager.caesarDecryption(encryptedV2, 6);
		assertEquals("APPLE!", decryptedV2);
		
	}
	
	
}