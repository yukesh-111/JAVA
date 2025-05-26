
class computer{
    public void playMusic()
    {
        System.out.println("music playing.....");
    }

    public String getMeAPen(int cost)
    {
        if (cost>=10)
        return "pen";
        else
            return "nothing";
    }
}


public class demo {
    public static void main(String[] args) {
computer obj=new computer();
obj.playMusic();

 String str=obj.getMeAPen(1);
        System.out.println(str);
    }
}
