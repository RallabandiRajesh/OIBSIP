//Login Form – To access this Online Reservation System, each user should have a valid login id and
//password. After providing the correct login id and password, users will able to access the main
//system.
//login id
//password
//Reservation System – Under reservation form users will have to fill the necessary details such as
//their basic details, train number, train name will automatically come in the box, class type, date of
//journey, from (place) to destination and after that, users will have to press insert button.

import java.util.*;
public class Reservation{
    public static void main (String[] args){
       HashMap<Integer,String>bookings = new HashMap<>(); 
        HashMap<String, Integer> users = new HashMap<>(); 
        Random rand=new Random();
        boolean loggedIn = false;
        int option;
        
        
        
        do{
        System.out.println("-----------OPTIONS----------");
        System.out.println("1.sign up");
        System.out.println("2.login");
        System.out.println("3.Reservation System");
        System.out.println("4.Cancellation Form");
        System.out.println("5.Exit");
        Scanner input =new Scanner(System.in);
        System.out.println("enter the option:");
        option= input.nextInt();
        input.nextLine();
        switch (option) {
            case 1:
            System.out.println("Create user name :");
            String user = input.nextLine();
            System.out.println("create password:");
            int password =input.nextInt();
            input.nextLine();
            users.put(user,password);
            break;
            case 2:
            System.out.println("enter user name:");
            String loginuser=input.nextLine();
           
            System.out.println("enter password:");
            int loginpassword=input.nextInt();
            
            if (users.containsKey(loginuser) && users.get(loginuser) == loginpassword) {
                loggedIn=true;
                System.out.println("login successfull");
            }
            else{
                System.out.println("login failed");
            } 
            break;
            case 3:
            if(loggedIn){
            HashMap<Integer, String> trains = new HashMap<>();
            trains.put(101, "Rajdhani Express");
            trains.put(102, "Shatabdi Express");
            trains.put(103, "Duronto Express");
            trains.put(104, "Chenai Express");

            System.out.println("----Reservation----");
            System.out.println("Enter name:");
            String name=input.nextLine();
             
            

            System.out.println("Enter age:");
             int age=input.nextInt();
             

            System.out.println("Enter train number:");
            int trainnumber=input.nextInt();
           
            input.nextLine();
            if(trains.containsKey(trainnumber)){
                System.out.println("Train name: " +trains.get(trainnumber));
             }
             else{
                System.out.println("INVALID TRAIN NUMBER");

             }

             

            System.out.println("Enter from place:");
            String place=input.nextLine();
            

            System.out.println("Enter destiny:");
            String destiny=input.nextLine();

            int pnr = 10000 + rand.nextInt(90000); 
            System.out.println(pnr);
String details = "Name: " + name + " | Age: " + age + " | Train No: " + trainnumber +
                 " | From: " + place + " | To: " + destiny;
            bookings.put(pnr,details );
            
            }
            else{
                System.out.println("Login First to access");
            }
            
            break;
            case 4:
            System.out.println("enter pnr");
            int cancelpnr = input.nextInt();
            if(bookings.containsKey(cancelpnr)){
                System.out.println(bookings.get(cancelpnr));
               System.out.print("Confirm cancellation (yes/no): ");
                        String confirm = input.nextLine();
                        if (confirm.equalsIgnoreCase("yes")) {
                            bookings.remove(cancelpnr);
                System.out.println("Cancelled");}
                else{
                    System.out.println("cancellation aborted");
                }
            }
            else{
                System.out.println("Pnr not found");
            }
            
        }

        }while(option!=5);
System.out.println("Exited");

    }

}