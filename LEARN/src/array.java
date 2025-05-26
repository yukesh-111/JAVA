import java.util.Scanner;

public class array {
    public static void main(String[] args) {
n_number.n_number();
practice.practice();
        Scanner a=new Scanner(System.in);
        System.out.println("Enter the size of array:");
    int size=a.nextInt();
    int[] num=new int[size];

   for(int i=0;i<size;i++)
   {
       System.out.println("Enter the value of array");
       num[i]=a.nextInt();

   }
        System.out.println("You entered the value \n");

        for(int i=0;i<size;i++){
       System.out.println(num[i]);
        }


        a.close();

    }
}
class practice{
    static void practice(){
        Scanner a=new Scanner(System.in);

        int[] num=new int[4];

        System.out.println("Enter the value for array:");
        for(int i=0;i<4;i++)
        {
            num[i]=a.nextInt();
        }
        System.out.println("you entered:");
        for(int i=0;i<4;i++)
            System.out.println(num[i]);
        a.close();

    }
}
//n number
class n_number {
    static void n_number() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array:");
        int size = sc.nextInt();
        int[] num = new int[size];
        System.out.println("Enter the value for the array:");
        for (int i = 0; i < size; i++) {
            System.out.println("value" + (i + 1) + ":");
            int value = sc.nextInt();
        }
        System.out.println("You entered value is:");
        for (int i = 0; i < size; i++)
            {
                System.out.println(num[i]);
            }
for(int i=0;i<size;i++)
        if(num[i]%2==0)
            System.out.println("Even num is"+num[i]);

        sc.close();
        }
    }
