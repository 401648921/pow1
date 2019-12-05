import java.util.Calendar;
import java.util.Date ;
public abstract class Ingredient {
    protected String name;
    protected Calendar time;
    protected int period;

    public Ingredient() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getTime() {
        return time;
    }

    public void setTime(Calendar time) {
        this.time = time;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }
    public String  toString()                                           //重写toString方法
    {
        int year=time.get(Calendar.YEAR);
        int month=time.get(Calendar.MONTH);
        int day=time.get(Calendar.DATE);
        return "["+name+"；生产日期:"+year+","+month+","+day+";保质期："+period+"]";
    }
    public int exam()throws SoldOutException                       //检查是否过期
    {
        Calendar TIME = Calendar.getInstance();
        int day = TIME.get(Calendar.DAY_OF_YEAR);
        int Ingredient_day = time.get(Calendar.DAY_OF_YEAR);
        int year = TIME.get(Calendar.YEAR);
        int Ingredient_year = time.get(Calendar.YEAR);
        if(year-Ingredient_year>1)
        {
            throw new SoldOutException("配料过期");
        }
        else if(Ingredient_year>year)                                         //时间异常，报错
        {
            throw new SoldOutException("时间异常");                          //配料生产时间在将来的情况
        }
        else if(Ingredient_year!=year)                                    //在年和年的交接处
        {
            if(Ingredient_year%4==0&&Ingredient_year%100!=0||year%400==0)   //闰年
            {
                if((day+366)-Ingredient_day>this.period)
                {
                    throw new SoldOutException("配料过期");
                }
            }
            else                                                    //非闰年
            {
                if((day+365)-Ingredient_day>this.period)
                {
                    throw new SoldOutException("配料过期");
                }
            }
        }
            else                                                     //同一年
             {
             if((day-Ingredient_day>this.period))
            {
                throw new SoldOutException("配料过期");
            }
        }
        return 1;

    }
}
