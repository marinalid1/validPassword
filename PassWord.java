import java.util.Scanner;
import java.util.Matcher;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class PassWord {

    // isValid helper method
    public static boolean isValid(String input) {
        // password pattern using regex, must have at least one upper, one lower, a digit and a special character
        String pattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&+=]).*$";
        // regex Pattern
        Pattern regex = Pattern.compile(pattern);
        // matcher compares input to pattern
        Matcher matcher = regex.matcher(input);
        // return true or false based on if input matches pattern
        return matcher.matches();
    }
    public static void main(String[] args) {
        // get input
        Scanner input = new Scanner(System.in);
        // 
        System.out.println("Please enter a password that is between 8 and 15 characters long, and has at least one upper case and one lwoer case letter, a number and a symbol: ");
        String passWord = input.next();
        
        // while loop
        while (true) {
            // if password is too short or too long
            if (passWord.length() < 8 || passWord.length() > 15) {
                System.out.println("Password is not correct length, please enter a password between 8 and 15 characters long: ");
                passWord = input.next();
            } 
            // if password does not meet character requirements
            else if (!isValid(passWord)) {
                System.out.println("Password must have one upper case, one lower case, a digit and a special character !@#$%^&+=, please enter again: ");
                passWord = input.next();
            }
            // else password is valid
            else {
                System.out.println("Password is valid");
                break;
            }
        }
        // close input
        input.close();
    }
}
