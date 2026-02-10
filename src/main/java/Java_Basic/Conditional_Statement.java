package Java_Basic;

public class Conditional_Statement {
    public static void main (String[] args)
        {
            //1.Single condition - If-else
            /* int age_person =15;
            if (age_person >= 18)
                System.out.println("Eligible for vote"); // neu chi co 1 statement co the bo {} -> tu 2 statement bat buoc phai co

            else {
                System.out.println("Not eligible for vote"); // khuyen khich de trong ngoac
            }*/

            //2. Multiple condition (tu 3 thop tro len) - If else
            /* int num = 0;
            if(num > 0) {
                System.out.println("Positive number");
            }
            else if (num<0) {
                System.out.println("Negative number");
            }
            else {
                System.out.println("Zero");
            } */

            //3. Boolean value condition
         /*   if(false){
                System.out.println(1); // statement nay duoc thuc hien khi tren if viet true
            }
            else{
                System.out.println(2); // statement nay dc thuc hien khi tren if viet false
            } */

            //4. Nested if -else
          /*  if (true){
                if(true){
                    System.out.println("abc");
                }
                else{
                    System.out.println("xyz");
                }
            }
            else{
                System.out.println("123");
            } */

            //5. Switch-case - reduce if-else statement
            int weekno=2;
            switch (weekno){
                case 2 : System.out.println("Monday"); break; // thieu break thi se execute ngay case tiep ma ko thoat ra khi da tim dc kqua dung
                case 3: System.out.println("Tuesday"); break;
                case 4 : System.out.println("Wednesday"); break;
                case 5: System.out.println("Thursday"); break;
                case 6: System.out.println("Friday"); break;
                case 7: System.out.println("Saturday"); break;
                case 1: System.out.println("Sunday"); break;
                default: System.out.println("Invalid week number"); // dong cuoi ko can break
            }



        }
}
