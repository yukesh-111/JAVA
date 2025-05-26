import java.util.Scanner;

public class arrayeg {
    public static void main(String[] args) {


        siti.siti();
        eg.eg();

        int[] marks=new int[5];
         marks[0]=28;
         marks[1]=34;
         marks[2]=98;
         marks[3]=98;
         marks[4]=78;
        System.out.println("The array :");
         for(int i=0;i<marks.length;i++){
             System.out.println(marks[i]);
         }

    }
}
class eg{
    static void eg(){
        Scanner sc=new Scanner(System.in);
        int[] aa=new int[3];
        System.out.println("Enter the value of array:");
        int asd=sc.nextInt();

        for(int i=0;i<aa.length;i++){
            System.out.println("value"+aa[i]);
        }
        //.close();

    }
}
class siti{
    static void siti(){
        Scanner sc=new Scanner(System.in);
        int[] tauke=new int[5];

        System.out.println("Enter 5 values of Tauke:");
        int tauki=sc.nextInt();
        for(int i=0;i<tauke.length;i++){
            tauke[i]=tauki;
        }
        for(int i=0;i<tauke.length;i++){
            System.out.println(tauke[i]);
        }

    }
}
