package Java_Basic;

public class Arrays { // allow to store multiple values of same datatype into a single variable
    public static void main (String[] args ){
        ///  maximum size : n -> maximum index: n-1

        /// 1. Single dimensional
        int[] a = new int[5]; // declaring an array - the size is fixed, so using when don't need to store more values in the future
           a[0]=100;
           a[1]=200;
           a[2]=300;
           a[3]=400;
           // Cách 2:
            /* int b[]={100,200,300,400}; // you don;t know how many values you want to store - more dynamic, not exceed position */
        System.out.println("Length of array: "+a.length); // find length of array
            //Normal loop
       /* for (int i =0;i <= a.length - 1; i++){
            System.out.println("Value at index " +i +" is: "+a[i]);
        } */
            //Enhanced for loop/ for ...each loop
        for (int x:a) {
            System.out.println(x);
        }


        /// 2. Two dimensional
       // int c[][] = new int [3][2]; /// 3 rows 2 columns
        int c[][] ={{100,200}, {300,400},{300,500}};
        //Find size of array
        System.out.println("Rows of array: "+c.length); //
        System.out.println(("Column of arrays: " +c[0].length)); // so cot = length cua 1 dong
        // Read multiple values of arrays
        //// Normal loop
       /* for(int i =0; i<=c.length-1; i++){
            for(int k=0; k<=c[0].length-1; k++){
                System.out.println("Value at: "+i+" "+k+" is: "+c[i][k]);
            }
        } */
       //// Enhanced loop
        for (int arr[]:c){ // Capture each row in array - each row becomes single dimensional
            for(int y :arr){ // capture each value in arr - single dimensional
                System.out.println(y);
            }
        }

       //// Store multiple values that have different datatype - array should be an object
        Object o[] = {true, 10, "Vy"};
        System.out.println(o[0]);
      // Test Git - subbranch
    }

}
