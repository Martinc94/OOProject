# OOProject
##Third year Objected Oriented Project 

This program reads in encrypted text from the user and attempts to decrypt it by decrypting with many keys and seeing how english it is.
The purpose of this program is to break already encrypted text not to encrypt text.
Program returns the key used to encrypt it and the plaintext it thinks sounds the most english.

Text is read in from user input or a file.
Worker threads are created and they decrypt and score text.
The score is added to a blockingQueue.
Consumer pulls results off queue and displays best score and plaintext at end.

I have tried to keep the users work to a minimum by using simple to follow on screen instructions
I have given the user the option of entering the encrypted text by keyboard on the command line or from a file.

The program an be run on the command line as follows:
java –cp ./railfence.jar ie.gmit.sw.Runner

Instructions:
When the program starts you will be given two options:
Option 1 - Enter cyphertext by keyboard:
Option 2 - Enter cyphertext from file:
Enter your choice

Option 1 - Enter cyphertext by keyboard:
if you pick this option you will have to enter the encrypted text into the command line 
eg. SATTMTSLSOETAEEPHHCGTTEA

Option 2 - Enter cyphertext from file:
if you pick this option you will have to enter the file directory with encrypted text into the command line 
eg. C:/myFolder/cyphertext.txt

Program will then try to break the encryption and return the results(plaintext, key, score) to you on-screen.
