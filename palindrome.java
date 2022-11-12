import java.util.Scanner;
public class Palindrome{
    public static void main(String[] args) {
        int reverse=0;
		Scanner sc=new Scanner(System.in);
        System.out.println("Enter number: ");
        int original=sc.nextInt();
        int temp=original;
        if (original % 2 == 0) {
            System.out.println("Entered Number is Even");
            while(temp>0){
                int digit=temp%10;
                temp=temp/10;
                reverse=reverse*10+digit;
             }
            if(reverse == original){
                System.out.println("Palindrome number");
            }
            else{
                System.out.println("Not a Palindrome number");
            }
        }
        else{System.out.println("Entered Number is Odd");
        }    
        }
    } 