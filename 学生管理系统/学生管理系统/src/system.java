import java.util.Scanner;

public class system {
    public static void main(String[] args){
        ManagementSystem stuClassSystem = new StudentManagementSystem();
        System.out.println("                      学生管理系统");
        output();
        Scanner enter = new Scanner(System.in);
        int flag = enter.nextInt();
        while(flag != 0)
        {
            switch (flag){
                case 1 :
                    System.out.println("输入1按照学号查询，输入2按照班级查询");
                    int x = enter.nextInt();
                    stuClassSystem.selcetChoice(x);
                    break;
                case 2 :
                    stuClassSystem.inputStudent();
                    break;
                case 3 :
                    stuClassSystem.alterStudent();
                    break;
                case 4 :
                    stuClassSystem.remove();
                    break;
                case 5 :
                    stuClassSystem.inputClass();
                    break;
                case 6 :
                    stuClassSystem.alterClass();
                    break;
            }
            output();
            flag = enter.nextInt();
        }
        System.out.println("        成功退出系统");
    }
    public static void output(){
        System.out.println("        一、查询学生信息");
        System.out.println("        二、输入学生信息");
        System.out.println("        三、修改学生信息");
        System.out.println("        四、删除学生信息");
        System.out.println("        五、输入班级信息");
        System.out.println("        六、修改班级信息");
        System.out.println("            输入功能对应序号，使用功能，输入0退出系统");
    }
}
