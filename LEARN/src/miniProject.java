import java.util.Scanner;

public class miniProject {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Hey there, Please Enter your Name:");
        String name=sc.nextLine();

        System.out.println("Welcome "+name+ "!! Now, Enter your Age:");
        int age=sc.nextInt();

        System.out.println(name +" , Enter your roll number:");
        int r_num=sc.nextInt();

        System.out.println("About yourself:\n Name: "+name+"\n Age: "+age+"\nRoll Number: "+r_num);

        System.out.println("Let's move towards your result,shall we?(true/false)");
        boolean z=sc.nextBoolean();
        if(z==true) {
            System.out.println("Thank you " + name);

            System.out.println("Please enter your latest exam score:");
            float marks=sc.nextFloat();
            if(marks>=40 && marks<=100)
                System.out.println("Congratulations "+name+"!!! You passed the exam.keep going on.");
            else {
                System.out.println("OOPs! " + name + " So sad. You failed the exam.\nupgrade yourself with concentration and consistency." +
                        "One exam doesn't define you.\n You've got the potential-this is just a setback,not the end." +
                        "I believe in you. \nYou only fail when you accept failure and give up. Try your best next time. God bless you.");

            }

        }
        else
            System.out.println("Ok! Bye "+name+". Have a nice Day.");

        student x = new student();
        x.inputDetails();
        x.desplayDetails();
    }
}

class student {
    int num;
    String  name;
    int age;
    int roll_num;
    double marks;

    public void inputDetails(){


Scanner sc=new Scanner(System.in);
        System.out.println("It is next class & you have to enter you Details again:");


        System.out.println("Enter the number of students:");
         num=sc.nextInt();

       for(int i=0;i<num;i++) {
           System.out.println("Enter your name:");
           name = sc.nextLine();

           System.out.println("Enter your age:");
           age = sc.nextInt();

           System.out.println("Enter your Roll number:");
           roll_num = sc.nextInt();

           System.out.println("Enter your marks:");
           marks = sc.nextFloat();
       }

    }
 public void desplayDetails()
      {
          System.out.println("Student Details:\n");
        for(int i=0;i<num;i++)
        {
            System.out.println(" Name: " + name + " \n Age: " + age + " \n Roll num: " + roll_num + "\n marks: " + marks);
        }
      }
   }
