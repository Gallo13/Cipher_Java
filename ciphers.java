// Created by: Jessica Gallo
// Created: 5/26/2020
// Last modified: 5/25/2020
// Java program to select either a Caesar Cipher or a Vigenere Cipher for encryption and decryption.
// Caesar cipher that shifts n places to the right during encryption and shifts n places to the left for decryption.


import java.util.Scanner;

public class ciphers
{
	public static void main (String[] argv)
	{
		Scanner myscan = new Scanner(System.in);

		System.out.println("---------------------------------------------------------");
		System.out.println("CAESAR and VIGENERE CIPHERS FOR ENCRYPTION AND DECRYPTION");
		System.out.println("---------------------------------------------------------");

		System.out.print("Please enter 1 for encryption and 2 for decryption: ");
		int cryption= myscan.nextInt();

		switch(cryption)
		{
			// ENCRYPTION
			case 1:
				System.out.println("You chose encryption.");
				System.out.print("\nPlease enter 1 for Caesar Cipher or 2 for Vigenere Cipher: ");
				int encCipher = myscan.nextInt();
				
				switch(encCipher)
				{
					// CAESAR CIPHER
					case 1:
						System.out.println("You chose Caesar Cipher.");
						
						System.out.print("\nPlease enter the plaintext you want to encrypt: ");
						String encCaesarPt = myscan.next();
						
						System.out.print("Please enter the shift value: ");
						int encCaesarShift = myscan.nextInt();
						
						String encCaesarCt = "";
						char alphabet;
						
						caesarEnc();
						
						break;
					// VIGENERE CIPHER
					case 2:
						System.out.println("");
						break;					
				}
				break;
			// DECRYPTION
			case 2:
				System.out.print("You chose decryption.");
				System.out.println("Please enter 1 for Caesar Cipher or 2 for Vigenere Cipher: ");
				int decCipher = myscan.nextInt();
				switch(decCipher)
				{
					case 1:
						System.out.print("You chose Caesar Cipher.");
						
						System.out.print("\nPlease enter the ciphertext you want to decrypt: ");
						String decCaesarCt = myscan.next();
						
						System.out.print("\nPlease enter the shift value: ");
						int decCasesarShift = myscan.nextInt();

						String decCeasarPt = "";
						
				}
				break;
			default:
				System.out.println("Please choose encryption or decryption.");
		}
	}

	public static void caesarEnc(encCaesarPt, encCaesarShift, encCaesarCt)
	{
		for(int i=0; i < encCaesarPt.length(); i++)
		{
			// Shift one character at a time
			alphabet = encCaesarPt.charAt(i);
					
			// If alphabet lies between a and z
			if(alphabet>='a' && alphabet<='z')
			{
				// Shift alphabet
				alphabet = (char)(alphabet + encCaesarShift);
					
				// If shift alphabet is greater than 'z'
				if(alphabet > 'z')
				{
					// Reshift to starting position
					alphabet = (char)(alphabet+'a'-'z'-1);
				}
				encCaesarCt = encCaesarCt + alphabet;
				System.out.println("Your encrypted Caesar ciphertext is: " + encCaesarCt);
			}
				
			// If alphabet lies between 'A' and 'Z'
			else if(alphabet>='A' && alphabet<='Z')
			{
				// shift alphabet
				alphabet = (char)(alphabet + encCaesarShift);
							
				// if shift alphabet is greater than 'Z'
				if(alphabet>'Z')
				{
					// reshift to starting position
					alphabet = (char)(alphabet+'A'-'Z'-1);
				}
				encCaesarCt = encCaesarCt + alphabet;
				System.out.println("Your encrypted Caesar ciphertext is: " + encCaesarCt);
			}
			else
			{
				encCaesarCt = encCaesarCt + alphabet;
				System.out.println("Your encrypted Caesar ciphertext is: " + encCaesarCt);
			}
		}
	}
}