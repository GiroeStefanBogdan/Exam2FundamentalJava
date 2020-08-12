//Description
//Create a program, that checks if registrations are valid.
//A registration consists of a Username and a Password.
//On the first line you will receive a number that indicates how many inputs you will receive on the next lines.
//A registration is valid when:
//The username is surrounded by "U$"
//The username needs to be minimum 3 characters long, start with an uppercase letter, followed only by lowercase letters
//The password is surrounded by "P@$"
//The password needs to start with minimum 5 alphabetical letters (not including digits) and must end with a digit
//Example for a valid registration:
//"U$MichaelU$P@$asdqwe123P@$"
//You must check if the registration is valid and if it is print:
//"Registration was successful"
//"Username: {Username}, Password: {Password}"
//If it isn't - print the following message:
//"Invalid username or password"
//In the end print the count of successful registrations:
//"Successful registrations: {successfulRegistrationsCount}"

//Input
//On the first line - n - the count of inputs.
//On the next n lines - input that you have to check if it has a valid registration.

//Output
//Print all results from each input, each on a new line.
//In the end print the count of successful registrations

//Example
//Input                                         	Output
//3                                                 Registration was successful
//U$MichaelU$P@$asdqwe123P@$                        Username: Michael, Password: asdqwe123
//U$NameU$P@$PasswordP@$                            Invalid username or password
//U$UserU$P@$ad2P@$                                 Invalid username or password
//                                                  Successful registrations: 1

//Comment
//We have 3 input lines to check.
//The first one follows the rules and is valid.
//The second one doesn't because the password doesn’t end with a digit.
//The third one is not valid because the password is too short.
//Example
//Input	                                            Output
//2                                                 Registration was successful
//U$TommyU$P@$asdqwe123P@$                          Username: Tommy, Password: asdqwe123
//Sara 1232412                                      Invalid username or password
//                                                  Successful registrations: 1
package Exam2;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Registration {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String  regex = "(U\\$)(?<userName>[A-Z][a-z]{2,})\\1(P@\\$)(?<password>[A-Za-z]{5,}[0-9]+)\\3";
        Pattern pattern = Pattern.compile(regex);

        int n = Integer.parseInt(scanner.nextLine());
        int succesfulRegistration = 0;

        for (int i = 0; i <=n-1; i++) {
            String line = scanner.nextLine();

            Matcher matcher = pattern.matcher(line);

            if(matcher.find()){
                String user = matcher.group("userName");
                String password = matcher.group("password");
                System.out.println("Registration was successful");
                System.out.printf("Username: %s, Password: %s%n",user, password);
                succesfulRegistration ++;
            }else{
                System.out.println("Invalid username or password");
            }
        }

        System.out.printf("Successful registrations: %d%n",succesfulRegistration);

    }
}
