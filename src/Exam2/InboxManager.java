//Description
//Create a program that manages users and emails sent by users.
//You need to keep information about their username and their sent emails.
//The emails are represented as strings.
//You will be receiving lines with commands separated by "->" until you receive the "Statistics" command.
//There are three possible commands:
//"Add->{username}"
//Check if the username exists and if it does print - "{username} is already registered"
//If it doesn't exist, then add the user to the collection of users.
//"Send->{username}->{Email}"
//Add the {Email} to the {username}'s collection of sent emails.
//"Delete->{username}"
//Delete the given user, if he exists.
//If the user doesn’t exist, print "{username} not found!"
//In the end, you have to print the count of users, each user with his/her emails.
//Users need to be sorted in descending order by the count of sent еmails and then by their username in ascending order in the following format:
//Users count: {count}
//{username}
//{Email1}
//{Email2}
//{EmailN}
//Input
//You will be receiving lines until you receive the "Statistics" command.
//The commands will be in the format described above.
//Output
//Print the collection in the format described above after the "Statistics" command.
//
//Example
//Input	                                                     Output
//Add->Mike                                                   Users count: 2
//Add->George                                                George
//Send->George->Hello World                                  - Hello World
//Send->George->Some random test mail                        - Some random test mail
//Send->Mike->Hello, do you want to meet up tomorrow?        - It would be a pleasure
//Send->George->It would be a pleasure                      Mike
//Send->Mike->Another random test mail                       - Hello, do you want to meet up tomorrow?
//Statistics                                                    - Another random test mail

//Comment
//First we receive our users.
//Since they are not already in our collection, we add them.
//Then they start sending emails and in the end we print the output in the described format.
//Example
//Input                                                                 	Output
//Add->Mike                                                                 Mike is already registered
//Add->George                                                               Peter not found!
//Send->George->Hello World                                                 Users count: 1
//Send->George->Your loan is overdue                                        Mike
//Add->Mike                                                                 - Hello, do you want to meet up tomorrow?
//Send->Mike->Hello, do you want to meet up tomorrow?                       - Another random test mail
//Delete->Peter
//Send->George->I'm busy
//Send->Mike->Another random test mail
//Delete->George
//Statistics
package Exam2;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class InboxManager {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, ArrayList<String>> inboxMap = new LinkedHashMap<>();

        String command = scanner.nextLine();

        while(!command.equals("Statistics")){
            String[] tockens = command.split("->");
            //"Add->{username}"
            //Check if the username exists and if it does print - "{username} is already registered"
            //If it doesn't exist, then add the user to the collection of users.
            if(tockens[0].equals("Add")){
                String userName = tockens[1];

                if(inboxMap.containsKey(userName)){
                    System.out.printf("%s is already registered%n", userName);
                }else{
                    inboxMap.put(userName, new ArrayList<>());
                }
            }
            //"Send->{username}->{Email}"
            //Add the {Email} to the {username}'s collection of sent emails.
            if(tockens[0].equals("Send")){
                String userName = tockens[1];
                String email = tockens[2];

                ArrayList<String> emailList = inboxMap.get(userName);

                emailList.add(email);

                inboxMap.put(userName, emailList);
            }

            //"Delete->{username}"
            //Delete the given user, if he exists.
            //If the user doesn’t exist, print "{username} not found!"
            if(tockens[0].equals("Delete")){
                String userName = tockens[1];

                if(inboxMap.containsKey(userName)){
                    inboxMap.remove(userName);
                }else{
                    System.out.printf("%s not found!%n", userName);
                }
            }

            command = scanner.nextLine();
        }

        System.out.printf("Users count: %d%n",inboxMap.size());

        inboxMap
                .entrySet()
                .stream()
                .sorted((a,b) ->{
                    int rezult = Integer.compare(b.getValue().size(), a.getValue().size());
                    if(rezult == 0){
                        rezult = a.getKey().compareTo(b.getKey());
                    }
                    return rezult;
                })
                .forEach(e -> {
                    System.out.println(e.getKey());
                    e.getValue().forEach(email -> {
                        System.out.println(" - " + email);
                    });
                });

    }
}
