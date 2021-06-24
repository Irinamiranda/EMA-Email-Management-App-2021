package com.company;

public class StudentEmail extends Email {

    private int batchNo;

    public int getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(int batchNo) {
        this.batchNo = batchNo;
    }

    public StudentEmail(String firstName, String lastName, int batchNo) {
        super(firstName, lastName);
        this.batchNo = batchNo;
        this.setEmailAddress(generateEmail());
        this.setPassword(generatePassword());
        this.setCapacity(25);
        this.setMaxAttachmentSize(50);
    }

    public String generateEmail(){
        return getFirstName() + "." + getLastName() + "_b" + batchNo + "@student." + getDomainName();
    }
    public String generatePassword(){

        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder password = new StringBuilder(8);
        while (password.length() < 8
                && !(password.toString().matches("(?:[a-z])")
                && password.toString().matches("(?:[A-Z])")
                && password.toString().matches("(?:[0-9])"))
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
        return "TYPE: STUDENT \n" +
                "BATCH NO: " + batchNo +"\n" + super.toString();
    }
}
