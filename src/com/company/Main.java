package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Please enter the number of emails you are going to create");
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();

        Email[] emails = new Email[number];

        for (int i = 0; i < number; i++){
            System.out.println("Choose the type: Student/Staff");
            String type = scan.next();

            if (type.equalsIgnoreCase("Student")){
                System.out.println("Enter first name");
                String fname = scan.next();
                System.out.println("Enter last name");
                String lname = scan.next();
                System.out.println("Enter Batch No");
                int batchNo = scan.nextInt();
                Email email = new StudentEmail(fname, lname, batchNo);
                emails[i] = email;

            }else{
                System.out.println("Enter first name");
                String fname = scan.next();
                System.out.println("Enter last name");
                String lname = scan.next();
                System.out.println("Enter Department number");
                System.out.println("1 - Accounting, \n" + "2 - Sales, \n" + "3 - Marketing, \n" + "4 - Instructors");
                int depNo = scan.nextInt();
                Email email = new StaffEmail(fname, lname, depNo);
                emails[i] = email;
            }

        }
        for (Email each : emails){
            System.out.println(each);
        }
        System.out.println();


    }
}
