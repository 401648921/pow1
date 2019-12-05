
public class MilkTea {
    public Ingredient ingredient;
    public String name;
    public MilkTea(String name1)
    {
        this.name = name1;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addIngredient(Ingredient a)        //向奶茶内部添加配料
    {
        if(a instanceof Bubble)
        {
            this.ingredient=(Bubble)a;
            System.out.println("成功添加配料珍珠");
        }
        if(a instanceof Coconut)
        {
            this.ingredient=(Coconut)a;
            System.out.println("成功添加配料椰果");
        }
    }
    public String toString()
    {
        return "奶茶："+name+" 配料："+ingredient;
    }

}
