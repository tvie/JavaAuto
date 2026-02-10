package Java_Basic;

public class Loop_Jump_Statement {
    public static void main (String[] args) {
        int i = 1;
        //1. White
       /* while ((i <= 10)){
            if((i%2==0))
            {
            System.out.println(i);
            }
            i++;

        } */

        //2. Do - white ->> cac cau lenh trong do - while it nhat se dc thuc hien 1 lan, con trong while se kiem tra condition trc
        /*  do {
              System.out.println(i); // 1 2...10
              i++; // 2 3 ....11
          }while (i<=10); // 11 > 10 nên break vong while */

        //3. For
      /*  for (int k=1; k <=10; k++) {
            if(k%2==0){
                System.out.println(k+ " Even");
            }
            else{
                System.out.println(k + " Odd");

            }
        } */

        //4. Jumping statement - break; continue
      /*  for(int j=10; j >=1; j--){
            if(j==5){
                break; // lenh break se ket thuc vong lap for ngay khi j moi chi bang 5, cac cau lenh viet sau break trg for ko dc execute
            }
            System.out.println(j);
        } */

        for(int j=10; j >=1; j--) {
            if (j == 5) {
                continue; // continue se skip dong lenh ben duoi no khi j = 5 nhg tiep tuc thuc hien het vong for
            }
            System.out.println(j);
        }
    }
}
