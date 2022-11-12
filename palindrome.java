import java.util.Scanner;
public class Palindrome{
    public static void main(String[] args) {
        int reverse=0;
		Scanner sc=new Scanner(System.in);
        
        int original=sc.nextInt();
        int temp=original;

        while(temp>0){
            int digit=temp%10;
            temp=temp/10;
            reverse=reverse*10+digit;
        }
        if(reverse==original){
            System.out.println("Palindrome number");
        }
        else{
            System.out.println("Not a Palindrome number");
        }

        }
    } 