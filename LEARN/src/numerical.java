import java.util.Scanner;

public class numerical {
    public static void main(String[] args) {


dowhileodd.dowhileodd();
        do_while.do_while();
odd.odd();
even.even();
        whileloop.whileloop();
        sum.sum();
        day.daystart();
        Scanner b=new Scanner(System.in);
        System.out.println("Enter your marks:");
        int marks=b.nextInt();
        if(marks>=90)
            System.out.println("You are Excellent");
        else if(marks>=70)
            System.out.println("You are Good");
        else if(marks>=50)
            System.out.println("You are Average");
        else if(marks<50)
            System.out.println("You are Fail");

        b.close();
    }
}
class day{
    static void daystart(){
        Scanner c=new Scanner(System.in);
        System.out.println("Enter number from 1 to 7:");
        int day=c.nextInt();
        switch(day) {
            case 1:
                System.out.println("Sunday");
                break;
            case 2:
                System.out.println("Monday");
                break;
            case 3:
                System.out.println("Tuesday");
                break;
            case 4:
                System.out.println("Wednesday");
                break;
            case 5:
                System.out.println("Thursday");
                break;
            case 6:
                System.out.println("Friday");
                break;
            case 7:
                System.out.println("Saturday");
                break;
            default:
                System.out.println("Invalid day number");
        }
        }
}
class sum{
    static void sum(){
        Scanner d=new Scanner(System.in);
        System.out.println("Enter a number to find its sum:");

        int num=d.nextInt();
        System.out.println("The entered num is:");
        for(int i=1;i<=num;i++)
        {
            System.out.println(i);
        }
        int sum=0;
        for(int i=0;i<=num;i++)
        {
           sum=sum+i;
        }
        System.out.println("The sum of n numbers is:"+sum);
        d.close();
    }
}

        class whileloop{
            static void whileloop(){
                Scanner e=new Scanner(System.in);
                System.out.println("Enter a number to find its sum:");
                int num=e.nextInt();
                int sum=0;
                int i =1;
                while(i<=num) {
                    sum += i;
                    i++;
                    System.out.println(i);
                }
                System.out.println("The sum of entered num is:" + sum);

                e.close();
            }

        }
//check even
class even{
    static void even(){
        Scanner f=new Scanner(System.in);
        System.out.println("Enter any number");
        int num=f.nextInt();
        int i=1;
        System.out.println("Enen numbers are 1 to "+num+ " is:");

        while(i<=num){
            if(i%2==0){
                System.out.println(i);
            }
             i++;
        }
      //  System.out.println("the even num is:"+i);
    }
}
class odd{
    static void odd(){
       Scanner g=new Scanner(System.in);
        System.out.println("Enter nth term:");
        int num=g.nextInt();
        int i=1;
        System.out.println("The odd numbers 1 to " +num +" are:");
        while(i<=num){
            if(i%2!=0){
                System.out.println(i);
            }
            i++;

        }

    }
}
class do_while{
    static void do_while(){
        Scanner h=new Scanner(System.in);
        System.out.println("Enter nth term:");
        int num=h.nextInt();
        int i=1;
        System.out.println("The even 1 to "+ num +" are:");
        do{
            if(i%2==0) {
                System.out.println(i);
            }
            i++;

        }while(i<=num);
    }
}
class dowhileodd{
    static void dowhileodd(){
        Scanner i=new Scanner(System.in);
        System.out.println("Enter nth term:");
        int num=i.nextInt();
        System.out.println("The odd numbers 1 to " + num+ " are:");
        int j=0;
        do{
            if(j%2!=0){
                System.out.println(j);
            }
            j++;
        }while(j<=num);
        i.close();
    }
}