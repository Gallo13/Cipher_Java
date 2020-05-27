// Created by: Jessica Gallo
// Created: 5/26/2020
// Last modified: 5/27/2020
// Java program to select either a Caesar Cipher or a Vigenere Cipher for encryption and decryption.
// Caesar cipher that shifts n places to the right during encryption and shifts n places to the left for decryption.
// Uses nested switch statements

// need to change math for better readability

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
			// ENCRYPTION/////////////////////////////////////////////////////////////////////////////////////////////////////
			case 1:
				System.out.println("You chose encryption.");
				System.out.print("\nPlease enter 1 for Caesar Cipher or 2 for Vigenere Cipher: ");
				int encCipher = myscan.nextInt();
				
				switch(encCipher)
				{
					// CAESAR CIPHER =================================================================================
					case 1:
						System.out.println("You chose Caesar Cipher.");
						
						System.out.print("\nPlease enter the plaintext you want to encrypt: ");
						String encCaesarPt = myscan.next();
						
						System.out.print("Please enter the shift value: ");
						int encCaesarShift = myscan.nextInt();
						
						String encCaesarCt = "";
						char alphabet;
						
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
								}
							else
							{
								encCaesarCt = encCaesarCt + alphabet;
							}
						}
						System.out.println("\nYour encrypted Caesar ciphertext is: " + encCaesarCt);
						break;

					// VIGENERE CIPHER ==================================================================================
					case 2:
						System.out.println("You chose the Vigenere Cipher.");
						
						System.out.print("\nPlease enter the plaintext you want to encrypt: ");
						String encVigPt = myscan.next();
						
						System.out.print("Please enter the keyword: ");
						String encKeyword = myscan.next();
						
						// Converting plaintext to char array
						char msg[] = encVigPt.toCharArray();
						int encMsgLen = msg.length;
						int i, j;
	
						// Creating new char arrays
						char encKey[] = new char[encMsgLen];
						char encMsg[] = new char[encMsgLen];

						/* generate key using keyword in cyclic manner equal 
						to the length of original message i.e. plaintext */
						for(i=0, j=0; i<encMsgLen; ++i, ++j)
						{
							if(j == encKeyword.length())
							{
								j=0;
							}
							encKey[i] = encKeyword.charAt(j);
						}

						for(i=0; i<encMsgLen; ++i)
						{
							encMsg[i] = (char)(((msg[i] + encKey[i]) % 26) + 'A');
						}

						System.out.println("\nOriginal Message: " + encVigPt);
						System.out.println("Keyword: " + encKeyword);
						// String.valueOf() method converts char[] to String
						System.out.println("Key: " + String.valueOf(encKey));
						System.out.println("\nEncrypted Message: " + String.valueOf(encMsg));
						break;				
				}
				break;
			// DECRYPTION ////////////////////////////////////////////////////////////////////////////////////////////////////
			case 2:
				System.out.println("You chose decryption.");
				System.out.print("\nPlease enter 1 for Caesar Cipher or 2 for Vigenere Cipher: ");
				int decCipher = myscan.nextInt();
				switch(decCipher)
				{
					// CAESAR CIPHER ==================================================================================
					case 1:
						System.out.println("You chose Caesar Cipher.");
						
						System.out.print("\nPlease enter the ciphertext you want to decrypt: ");
						String decCaesarCt = myscan.next();
						
						System.out.print("Please enter the shift value: ");
						int decCaesarShift = myscan.nextInt();

						String decCaesarPt = "";

						for(int i=0; i<decCaesarCt.length(); i++)
						{
							// Shifts 1 character at a time
							char alphabet = decCaesarCt.charAt(i);

							// if alphabet lies between a and z
							if(alphabet >= 'a' && alphabet <= 'z')
							{
								// shift alphabet
								alphabet = (char)(alphabet - decCaesarShift);

								// shift alphabet lesser than 'a'
								if(alphabet < 'a')
								{
									// reshift to starting poition
									alphabet = (char)(alphabet-'a'+'z'+1);
								}
								decCaesarPt = decCaesarPt + alphabet;
							}
					
							else if(alphabet >= 'A' && alphabet <= 'Z')
							{
								// shift alphabet
								alphabet = (char)(alphabet - decCaesarShift);

								// shift alphabet lesser than 'A'
								if(alphabet < 'A')
								{
									// reshift to starting position
									alphabet = (char)(alphabet-'A'+'Z'+1);
								}
								decCaesarPt = decCaesarPt + alphabet;
							}
							else
							{
								decCaesarPt = decCaesarPt + alphabet;
							}
						}
						System.out.println("\nDecrypted Message: " + decCaesarPt);
						break;
					// VIGENERE CIPHER ==================================================================================
					case 2:
						System.out.println("You chose Vigenere Cipher.");
						
						System.out.print("\nPlease enter the ciphertext you want to decrypt: ");
						String decVigCt = myscan.next();
						
						String decKeyword = "";

						char msg[] = decVigCt.toCharArray();
						int decMsgLen = msg.length;
						int i, j;

						// Creating new char arrays
						char decKey[] = new char[decMsgLen];
						char decMsg[] = new char[decMsgLen];

						for(i=0; i<decMsgLen; ++i)
						{
							decMsg[i] = (char)((((decVigCt[i] - decKey[i]) + 26) % 26) + 'A');
						}
						System.out.println("Decrypted Message: " + decMsg);
						break;
				}
				break;
			default:
				System.out.println("Please choose encryption or decryption.");
		}
	}
}