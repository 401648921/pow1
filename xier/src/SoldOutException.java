public class SoldOutException extends RuntimeException {
    public SoldOutException(){
    }
    public SoldOutException(String msg){
        if(msg.equals("配料不足"))
            System.out.println("配料不足");
        if(msg.equals("配料过期"))
            System.out.println("配料过期");
        if(msg.equals("时间异常"))
            System.out.println("时间异常，程序异常，请重启");
    }
}
