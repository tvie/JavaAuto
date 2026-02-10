package Java_Basic;

public class String_Methods {
    public static void main (String [] arg) {
        String s = new String("Welcome"); /// String is a pre-defined class so s inherits all String methods
        /// Return length of a string
     /*   System.out.println(s.length());
        System.out.println("Welcome".length()); */

        /// Concat - join strings together
    /*    String s1 = "Welcome";
        String s2 ="Foxify tester";
        String s3 = "!";
        /// concat 2 strings
        System.out.println(s1.concat(s2));
        ///  concat 3 strings
        System.out.println(s1.concat(s2).concat(s3));
        /// / Another way
        System.out.println(s1+s2+s3); */

        /// Trim - remove right and left spaces, skip the spaces between the characters
        /// //// - space still count in length()
     /*   String s4="   QA engineer ";
        System.out.println(s4);
        System.out.println(s4.trim()); */

        /// charAt() - return a character of string from index; index start from zero, including spaces
    /*    String s5 = " Automation"; /// có cách ơ đầu từ này
        System.out.println(s5.charAt(2)); */

        /// contain() - check string is a part of main string or not, check upper/lower case
     /*   String s6="Hello";
        System.out.println(s6.contains("Hel"));
        System.out.println(s6.contains("hel")); */

        ///  equalsIgnoreCase - compare strings without uppper/lower case
     /*   String s7 = "Foxecom";
        System.out.println(s7.equals("foxecom"));
        System.out.println(s7.equalsIgnoreCase("foxecom")); */

        /// replace() - replace single/multiple character (sequence) in a string
        String s8 = "Selenium Java framework";
        /// Single
    /*    String single = s8.replace('e','X'); // ngoặc đơn
        System.out.println(single);
        /// Multiple
        String multiple = s8.replace("framework","testng");
        System.out.println(multiple); */

        /// substring - extract substring from main string
        String s9 = "Black friday";
      /*  String sub = s9.substring(0,5); /// index to start, index to end (should plus one with ending index)
        System.out.println(sub);
        System.out.println(s9.substring(4,7)); */

        // toUpperCase, toLowerCase
    /*    System.out.println(s9.toUpperCase());
        System.out.println(s9.toLowerCase()); */

        // Split - split string into multiple parts based on delimiter
       /* String s10 = "abc@example.com";
        String [] split = s10.split("@"); // sau khi split tao ra nhieu substring -> tao array de luu cac substring nay
        /// C1: Dung array de in ra cac gia tri
        System.out.println(Arrays.toString(split));
        /// C2: Dung enhance for loop
        for (String x:split){
            System.out.println(x);
         } */
        ///  Lưu ý : // * ^ &  ( ) - can not use as delimiter

        // Reverse string - not using string method
        String s11 ="Java";
        String rev = "";
        char convert[] = s11.toCharArray(); // chuyen doi cac chu cai trong chuoi string thanh ky tu trong 1 mang
        for (int j=s11.length()-1;j>=0;j--){
            rev= rev + convert[j];
        }
        System.out.println("Reverse string: "+rev);







    }

}
