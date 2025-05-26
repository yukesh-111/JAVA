 class calc
{
    public int add(int a,int b,int c)
    {
        int result= a+b+c;

        return result;
    }
    public int add(int a,int b){
        int result=a+b;
        return result;
//method overloading
       /* public double add(double a,int b){
            double result=a+b;
            return result;
*/


        }
}
public class method_Overloading_in_java{
    public static void main(String[] args) {

        calc obj=new calc();
        int r=obj.add(5,9);
        System.out.println(r);
    }
}
