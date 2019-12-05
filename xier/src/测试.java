import java.util.Calendar;

public class 测试 {
    public static void main(String[] args){
        Shop xier = new Teashop();
        Ingredient bubble = new Bubble();
        xier.purchase(bubble);
        bubble.time.set(2019,9,5);   //过期(2019年10月5日）
        Ingredient coconut = new Coconut();
        xier.purchase(coconut);
        System.out.println(xier);
        System.out.println(bubble);
        System.out.println(coconut);

        xier.sale("奶茶1","Bubble");
        xier.sale("奶茶2","Coconut");
        xier.sale("奶茶3","Coconut");   //没货


    }
}
