
class calculator{
int a=6;
    public int add(int n1,int n2){
        System.out.println("Addition");
       int r= n1+n2;
        return r;
    }
}


public class object {
    public static void main(String[] args) {

        int num1=4;
        int num2=5;
        //int sum=num1+num2;
       // System.out.println("THe sum is"+(num1+num2));


        calculator calc=new calculator(); //object define
        int result=calc.add(num1,num2);
      System.out.println(result);





    }
}
