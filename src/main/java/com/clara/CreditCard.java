package com.clara;

import java.util.Scanner;

/**
 * Created by we4954cp on 8/31/2016.
 */
public class CreditCard {

    static Scanner stringScanner = new Scanner(System.in);

    public static void main(String[] args) {

        //Ask user for credit card number. store number as a String.
        System.out.println("Please enter the credit card number, digits only:");
        String ccNumber = stringScanner.nextLine();
        boolean isValid = isValidCreditCard(ccNumber);

        if (isValid) {
            System.out.println("This seems to be a valid credit card number");
        } else {
            System.out.println("This is **not** a valid credit card number.");
        }

        stringScanner.close();
    }

    public static boolean isValidCreditCard(String cc) {

        int[] n = new int[cc.length()];
        for(int i=0; i < cc.length(); i++) {
            n[i]= Character.getNumericValue(cc.charAt(i));

        }

        if(n[0] != 4){
            System.out.println("Does not start with a 4");
            return false;
        }

        int sum = 0;

        for(int i = 0; i < 16; i+=2){
            if(i == 6){
                int n6 = 1 + ((n[6]*2) % 10);
                sum = sum + n6;
            } else {
                sum = sum + n[i]*2;
            }
            if(i == 8){
                int n8 = 1 + ((n[8]*2) % 10);
                sum = sum + n8;
            } else {
                sum = sum + n[i]*2;
            }
            sum = sum + n[i]*2;
        }
        for(int i = 1; i < 16; i+=2){
            sum = sum + n[i];
        }

        if (sum % 10 == 0) {
            return true;
        }

        return false;

    }
}
