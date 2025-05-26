import java.util.Scanner;
public class input{
    public static void main(String[] args) {
        Integer.INT();

quotes.quote();
Scanner a=new Scanner(System.in);
        System.out.println("Enter your Name:");
        String name=a.nextLine();
        System.out.println("Enter your age:");
        int age=a.nextInt();
        System.out.println("Enter your Height in meter:");
                float height=a.nextFloat();
        System.out.println("Are you a student or not?");
        boolean isStudent=a.nextBoolean();
        System.out.println("Your Name is:"+name);
        System.out.println("Your age is:"+age);
        System.out.println("Your Height is:"+height+"m");
        System.out.println("Are you a student or not?"+isStudent);

    }
}

class quotes {
     static void quote() {
       Scanner a=new Scanner(System.in);
        System.out.println("Enter your Name:");
        String name=a.nextLine();
        System.out.println("Enter your Age:");
        int age=a.nextInt();
        a.nextLine();
        System.out.println("Enter your Favorite quote:");
        String quote=a.nextLine();
        System.out.print("Hello, "+name) ;
        System.out.print(" (Age"+age);
        System.out.print("Says:"+quote);
    }
}

class Integer {
    static void INT(){
        Scanner z=new Scanner(System.in);
        System.out.println("Enter first number:");
        int num1=z.nextInt();
        z.nextLine();
        System.out.println("Enter second number:");
int num2=z.nextInt();

int sum=num1+num2;
int sub=num1-num2;
int mul=num1*num2;
float div=num1/num2;
int mod=num1%num2;

System.out.println("Sum of two numbers is:"+sum);
        System.out.println("Subtraction of two numbers is:"+sub);
        System.out.println("multiplication of two numbers is:"+mul);
        System.out.println("division of two numbers is:"+div);
        System.out.println("remainder of two numbers is:"+mod);
        z.close();
        if(num1==num2)
            System.out.println("Both numbers are equal");
        else
            System.out.println("Both numbers are not equal");
        if(num1>num2)
            System.out.println("First number is greater than second number");
        else if(num1<num2)
            System.out.println("First number is less than second number");
     if (num1>0&& num2>=0) {
         System.out.println("Both numbers are positive");

     }
z.close();
    }
}