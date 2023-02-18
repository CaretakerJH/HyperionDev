import java.util.Map;
import java.util.HashMap;

public class ISBNValidator {
    /** Written by J.Herr
     * Validates an ISBN-13 number and returns the corrected version if possible.
     * @param isbn The ISBN number to validate.
     * @return The corrected version of the ISBN number if valid, "Invalid" otherwise.
     */
    public static String ISBNCheck(String isbn) {
        //Input validation regarding characters that are not allowed.
        if (isbn.contains("ABCDEFGHIJKLMNOPQRSTUVWXYabcdefghijklmnopqrstuvwx!@#$%^&*()_+~./*-")){
            return "Invalid";
        }
        Integer totalSum = 0;
        Integer partialSum = 0;
        //ISBN-10 checker and if it is valid it will manipulate the ISBN-10 to be an ISBN-13
        if (isbn.length() == 10)  
        {   //Checking for a previous X before the last digit (niche-case)
            if (isbn.substring(0,8).contains("X")){
            return "Invalid";
        }
            //Create the map variable
            Map<Integer,Integer> data = new HashMap<Integer,Integer>();
            //Mapping the data to allow for data manipulation to check if the sum is of the components is valid
            data.put(10, Character.getNumericValue(isbn.charAt(0)));
            data.put(9, Character.getNumericValue(isbn.charAt(1)));
            data.put(8, Character.getNumericValue(isbn.charAt(2)));
            data.put(7, Character.getNumericValue(isbn.charAt(3)));
            data.put(6, Character.getNumericValue(isbn.charAt(4)));
            data.put(5, Character.getNumericValue(isbn.charAt(5)));
            data.put(4, Character.getNumericValue(isbn.charAt(6)));
            data.put(3, Character.getNumericValue(isbn.charAt(7)));
            data.put(2, Character.getNumericValue(isbn.charAt(8)));

            //Case for the last number being X - replace it with a 10.
            if (isbn.charAt(9) == 'X'){
                data.put(1, 10);
            }
            else{
                data.put(1, Character.getNumericValue(isbn.charAt(9)));
            }          
            //Totalling the sum of each multiplication
            for (Map.Entry<Integer,Integer> entry : data.entrySet()) {
            partialSum = (entry.getKey() * entry.getValue());
            totalSum += partialSum;
            }
            //Validation check & if it passes, the string is manipulated
            if(totalSum % 11 == 0){
                //String manipulation
                isbn = "978" + isbn.substring(0, 9);
                //ISBN-13 check for the manipulated string
                totalSum = 0;
                for (int i = 0; i < 12; i++) {
                    int digit = Character.getNumericValue(isbn.charAt(i));
                    totalSum += (i % 2 == 0) ? digit : digit * 3; // multiply by 1 or 3 alternately
                }
                //Finding the correct last digit to make the be ISBN-13 string valid.
                Integer lastDigit = (10 - (totalSum % 10)) % 10;
                //Remove the last number & append it to the string 
                isbn = isbn.substring(0,12) + lastDigit;
                return isbn;
            }
            else{
                return "Invalid";
            }
        }

        //ISBN-13 Checker 
        if (isbn.length() == 13)  
        {
            //Totalling of the numerical sequence for ISBN-13.
            for (int i = 0; i < isbn.length(); i++) {
                int digit = Character.getNumericValue(isbn.charAt(i));
                int multiplier = (i % 2 == 0) ? 1 : 3;
                totalSum += digit * multiplier;
            }
            //Final validation of the total.
            if (totalSum % 10 == 0){
                return "Valid";
            }
        }
        //Returning the result of the validation checks.
        else  {
            return "Invalid";
        }
        return "Invalid";

    }
    public static void main(String[] args) {
        //Testing & Running the function.
        System.out.println("ISBN-Validator - Created by Julian Herr");
        System.out.println(ISBNCheck("9780316066525") + "  [ISBN-13 Checked: 9780316066525]"); //Valid 
        System.out.println(ISBNCheck("9789295055025") + "  [ISBN-13 Checked: 9789295055025]"); //Valid 
        System.out.println(ISBNCheck("9781566199094") + "  [ISBN-13 Checked: 9781566199094]"); //Valid
        System.out.println(ISBNCheck("097522980X") + "  [ISBN-10 Checked: 097522980X]"); //Valid 
        System.out.println(ISBNCheck("080442957X") + "  [ISBN-10 Checked: 080442957X]"); //Valid   
        System.out.println(ISBNCheck("0316066524") + "  [ISBN-10 Checked: 0316066524] \n");  //Valid 
        System.out.println("Running some input checks [these should all be invalid.]");
        System.out.println(ISBNCheck("0330301824") + "  [ISBN Checked: 0330301824]");  //Invalid
        System.out.println(ISBNCheck("0~30301824") + "  [ISBN Checked: 0~30301824]");  //Invalid
        System.out.println(ISBNCheck("56709") + "  [ISBN Checked: 56709]");
        System.out.println(ISBNCheck("0133030182454") + "  [ISBN Checked: 0133030182454]");  //Invalid
        System.out.println(ISBNCheck("03356Y182x") + "  [ISBN Checked: 03356Y182x]"); //Invalid
        System.out.println(ISBNCheck("034356182Y") + "  [ISBN Checked: 034356182Y]"); //Invalid
    }

}


