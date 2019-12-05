import java.util.ArrayList;
import java.util.Iterator;

public class Teashop implements Shop{
    ArrayList<Bubble> list_Bubble = new ArrayList<Bubble>();
    ArrayList<Coconut> list_Coconut = new ArrayList<Coconut>();
    public Teashop(){}
    public ArrayList<Bubble> getList_Bubble() {
        return list_Bubble;
    }

    public void setList_Bubble(ArrayList<Bubble> list_Bubble) {
        this.list_Bubble = list_Bubble;
    }

    public ArrayList<Coconut> getList_Coconut() {
        return list_Coconut;
    }

    public void setList_Coconut(ArrayList<Coconut> list_Coconut) {
        this.list_Coconut = list_Coconut;
    }

    public void purchase(Ingredient a)     //进货配料
    {
        if(a instanceof Bubble)
        {
            go_purchase((Bubble)a);
        }
        if(a instanceof Coconut)
        {
            go_purchase((Coconut)a);
        }

    }
    public void sale(String name,String Ingredientname)      //售卖奶茶
    {
        Ingredient outsale=null;
        MilkTea out = new MilkTea(name);
        Iterator it1 = list_Bubble.iterator();
        Iterator it2 = list_Coconut.iterator();
        if (Ingredientname.equals("Bubble")) {
            if(it1.hasNext()==false)
                throw new SoldOutException("配料不足");
        }
        if (Ingredientname.equals("Coconut")) {
            if(it2.hasNext()==false)
                throw new SoldOutException("配料不足");
        }
        if (Ingredientname.equals("Bubble")) {
            outsale = list_Bubble.get(0);
        }
        if (Ingredientname.equals("Coconut")) {
            outsale = list_Coconut.get(0);
        }
        try{outsale.exam();}
        catch (SoldOutException error) {
            if (outsale instanceof Bubble) {
                list_Coconut.remove(outsale);
            }
            if (outsale instanceof Coconut) {
                list_Coconut.remove(outsale);
            }
            System.out.println("请重新操作");
            return;
        }
        out.addIngredient(outsale);
        if(outsale instanceof Bubble)
            list_Bubble.remove(outsale);
        if(outsale instanceof Coconut)
            list_Coconut.remove(outsale);
        System.out.println("成功售出奶茶");
    }
    public void go_purchase(Bubble a){
        list_Bubble.add(a);
        System.out.println("成功进货椰果");
    }
    public void go_purchase(Coconut a){
        list_Coconut.add(a);
        System.out.println("成功进货珍珠");
    }
    public String toString(){
        return "西二奶茶店";
    }


}
