package HandlingException;

import java.util.Scanner;

public class Try_Catch {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in); /// lay gia tri nhap tu ban phim
        System.out.println("Enter a number: ");
        int num = sc.nextInt();/// Luu gia tri vao bien num

        try {
            System.out.println("Phep chia 100 voi so chia vua nhap: ");
            System.out.println(100/num);
        }
        catch (ArithmeticException e) {
            System.out.println("Invalid output");
        }


    }
}
