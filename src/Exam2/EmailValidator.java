//Description
//Create a program that manipulates a string and makes it suitable for an Email.
//First, you are going to receive the email that the user wants to use, then you will receive commands.
//You will be receiving commands until the "Complete" command.
//There are six possible commands:
//"Make Upper"
//Replace all letters with upper case, then print the result.
//"Make Lower"
//Replace all letters with lower case, then print the result.
//"GetDomain {count}"
//Print the last {count} characters of the Email.
//"GetUsername"
//Print the substring from the start of the Email until the @ symbol.
//If the Email doesn't contain the @ symbol, print:
//"The email {email} doesn't contain the @ symbol."
//"Replace {char}"
//Replace all occurences of the {char} with a dash "-" and print the result.
//"Encrypt"
//Get the ASCII value of each symbol. Print the result on a single line separated by a single space
//Input
//On the 1st line you are going to receive the Email in the form of a string.
//On the next lines, until the "Complete" command is received, you will be receiving commands.
//Output
//Print the output of every command in the format described above.
//Example
//Input                                                         	Output
//Mike123@somemail.com                                              MIKE123@SOMEMAIL.COM
//Make Upper                                                        COM
//GetDomain 3                                                       MIKE123
//GetUsername                                                       77 73 75 69 49 50 51 64 83 79 77 69 77 65 73 76 46 67 79 77
//Encrypt
//Complete

//Exemple
//Input                                                             Output
//AnotherMail.com                                                   anothermail.com
//Make Lower                                                        The email anothermail.com doesn't contain the @ symbol.
//GetUsername                                                       -notherm-il.com
//Replace a
//Complete


package Exam2;

import java.util.Scanner;

public class EmailValidator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String email = scanner.nextLine();

        String line = scanner.nextLine();

        while(!line.equals("Complete")){
            String[] tockens = line.split("\\s+");
            String command = tockens[0];

            switch (command){
                case "Make":
                    if(tockens[1].equals("Upper")) {
                        email = email.toUpperCase();
                        System.out.println(email);
                    }else if(tockens[1].equals("Lower")){
                        email = email.toLowerCase();
                        System.out.println(email);
                    }
                    break;

                case "GetDomain":
                    int count = Integer.parseInt(tockens[1]);
                    int j = 0;
                    StringBuilder sb = new StringBuilder();
                    for (int i = email.length()-1; i >=0 ; i--,j++) {
                        if(j!=count){
                            sb.append(email.charAt(i));
                        }else {
                            break;
                        }
                    }
                    sb = sb.reverse();
                    System.out.println(sb.toString());
                    break;

                case "GetUsername":

                    int poz = -1;
                    for (int i = 0; i <=email.length()-1; i++) {
                        if(email.charAt(i) == '@'){
                            poz = i;
                        }
                    }
                    if(poz>-1){
                        String textPrint = email.substring(0,poz);
                        System.out.println(textPrint);
                    }else{
                        System.out.printf("The email %s doesn't contain the @ symbol.%n", email);
                    }
                break;

                //"Replace {char}"
                //Replace all occurences of the {char} with a dash "-" and print the result.

                case "Replace":
                    char ch = tockens[1].charAt(0);
                    String repl = String.valueOf(ch);

                    email = email.replace(repl, "-");
                    System.out.println(email);
                    break;

                //"Encrypt"
                //Get the ASCII value of each symbol. Print the result on a single line separated by a single space


                case "Encrypt":
                    for (int i = 0; i <=email.length()-1; i++) {
                        System.out.print((int)email.charAt(i) + " ");
                    }

                    break;



            }




            line = scanner.nextLine();
        }
    }
}
