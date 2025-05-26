public class jagged_array {
    public static void main(String[] args) {

        int num[][]=new int[3][];
//jagged array which means array having different size in array
        num[0]= new int[3];
        num[1]= new int[4];
        num[2]= new int[2];



        for (int i=0;i<num.length;i++)
        {
            for (int j=0;j< num[i].length;j++)
            {
                num[i][j]= (int)(Math.random()*10);
            }
        }



        DDD_array obb=new DDD_array();
        obb.arr();
//enhanced for loop

        for (int n[] : num)
        {
            for ( int j : n)
            {
                System.out.print(j +" ");
            }
            System.out.println();
        }

    }
}
//3D Array

  class DDD_array{
    public void arr(){
        int num[][][]=new int[3][4][5];

        for (int i=0;i<3;i++)
        {
            for (int j=0;j<4;j++)
            {
                for (int k=0;k<5;k++)
                {
                    num[i][j][k]=(int)(Math.random()*10);
                }
            }
        }

        for(int i=0;i<3;i++)
        {
            for (int j=0;j<4;j++)
            {
                for (int k=0;k<5;k++)
                {
                    System.out.print(num[i][j][k]+" ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}