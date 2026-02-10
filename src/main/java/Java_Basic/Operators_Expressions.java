package Java_Basic;

public class Operators_Expressions {
    public static void main (String[] args) {
        //1. Arithmetic operators: + - * / %
        int a = 10; int b = 5;
       /* System.out.println("Sum: "+(a+b));
        System.out.println("Diff:"+(a-b));
        System.out.println("Multiplication:"+(a*b));
        System.out.println("Division: "+(a/b));
        System.out.println("Modulo of division: "+(a%b)); */

        //2. Comparison operators: > >= < <= != == ->> return boolean true/false
       /* System.out.println(a>b); //true
        System.out.println(a>=b); // true
        System.out.println(a<b); //false
        System.out.println(a<=b);// false
        System.out.println(a==b); //false
        System.out.println(a!=b); // true */

        //3. Logical operators: && || ! ->> return true/false
       /* boolean x=true; boolean y=false;
        System.out.println("AND: "+(x&&y));
        System.out.println("OR: "+(x||y));
        boolean c = 10 > 20 ;
        System.out.println("Not:"+(!c)); // tra ve ket qua ngc lai cua menh de boolean */

        //4. Increment - Decrement operators
       /* int a1=10; int post = a1++;
        System.out.println("Post-increment:"+post); // lay gia tri ban dau cua a1 gan cho post trc roi mang tang a1 ->> post=10
        int a2 = 10; int pre =++a2;
        System.out.println("Pre-increment:"+pre); // tang gia tri cua a2 roi moi gan a2 cho pre ->> pre=11

        int b1=8; int post1 = b1--;
        System.out.println("Post-decrement:"+post1);
        int b2=8; int pre1 = --b2;
        System.out.println("Pre-decrement:"+pre1); */

        //5.Assignment (Short-hand) operators = += -=  *= /= %=
        /*int a3 = 2; a3+=5; // a3=a3+5
        System.out.println("a3:"+a3);
        int a4= 2; a4-=5; //a4=a4-5
        System.out.println("a4:"+a4);
        int a5 =2; a5*=5; //a5=a5*5
        System.out.println("a5:"+a5);
        int a6=2; a6/=5; //a6=a6/5
        System.out.println("a6:"+a6);
        int a7=2; a7%=5; //a7=a7%5
        System.out.println("a7:"+a7);*/

        //6. Conditional,ternary operators ?:
            //example 1:
        int b2 =100; int b3=200;
        int x1=(b2>b3)? b2:b3; //ket qua cua mde là true thi lay gia tri b2, la false thi lay gia tri b3
        System.out.println("X sau khi so sanh ghi nhan gia tri la:"+x1);
            //example 2:
        int age=26;
        String verify=(age>18)? "Eligible":"Not eligible";
        System.out.println(verify);
    }
}
