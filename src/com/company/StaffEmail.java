package com.company;

public class StaffEmail extends Email {

    private int departmentID;

    private static final String[] DEPARTMENTS = {"Accounting", "Sales", "Marketing", "Instructors"};


    public StaffEmail(String firstName, String lastName, int departmentID) {
        super(firstName,lastName);
        this.departmentID = departmentID;
        this.setEmailAddress(generateEmail());
        this.setPassword(generatePassword());
        this.setCapacity(50);
        this.setMaxAttachmentSize(100);
    }

    public String generateEmail(){
        return getFirstName() + "." + getLastName() + "_b" + departmentID + "@" + DEPARTMENTS[departmentID - 1] + "." + getDomainName();
    }
    public String generatePassword(){
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()";
        StringBuilder password = new StringBuilder(8);
        while (password.length() < 8
                && !(password.toString().matches("(?:[a-z])")
                && password.toString().matches("(?:[A-Z])")
                && password.toString().matches("(?:[0-9])")
                && password.toString().matches("(?:[!@#$%^&*()])"))
        ){
            password.setLength(0);
            for (int i = 0; i < 8; i++){
                password.append(str.charAt((int)(Math.random() * str.length())));
            }
        }

        return password.toString();
    }

    @Override
    public String toString() {
        return "TYPE: Staff \n" +
                "DEPARTMENT: " + DEPARTMENTS[departmentID - 1] + "\n" +
                super.toString()
                ;
    }
}
