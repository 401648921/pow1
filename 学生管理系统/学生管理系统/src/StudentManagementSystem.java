import java.sql.*;
import java.util.Scanner;

public class StudentManagementSystem implements ManagementSystem
{

    @Override
    public void selcetChoice(int flag) {
        if(flag == 1)
        {
            selectId();
        }
        else if(flag == 2)
        {
            selectClass();
        }
        else
        {
            System.out.println("输入错误");
        }
    }

    @Override
    public void inputStudent() {
        Connection conn = null;
        Statement stmt = null;
        try{
            Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.deregisterDriver(driver);
            String url = "jdbc:mysql://localhost:3306/stu_classes";
            String user = "root";
            String password = "zhen415322";
            conn = DriverManager.getConnection(url,user,password);
            stmt = conn.createStatement();
            Scanner enter = new Scanner(System.in);
            System.out.println("请输入学号");
            String studentId = enter.nextLine();
            System.out.println("请输入姓名");
            String studentName = enter.nextLine();
            System.out.println("请输入班级编号");
            String studentClassNo = enter.nextLine();
            String sql = "insert into student(id,stu_name,stu_class_no) value('"+studentId+"','"+studentName+"','"+studentClassNo+"')";
            int count = stmt.executeUpdate(sql);
            System.out.println(count == 1?"保存成功" : "保存失败");
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(stmt != null){
                    stmt.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
            try{
                if(conn != null){
                    stmt.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }

        }

    }

    @Override
    public void selectClass() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try{
            Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.deregisterDriver(driver);
            String url = "jdbc:mysql://localhost:3306/stu_classes";
            String user = "root";
            String password = "zhen415322";
            conn = DriverManager.getConnection(url,user,password);
            stmt = conn.createStatement();
            Scanner enter = new Scanner(System.in);
            System.out.println("请输入待查询学生的班级");
            String stuClass = enter.nextLine();
            String sql = "select d.id '学号',d.stu_name '学生姓名',d.stu_class_no '班级编号',e.class_name '班级名称' from classes e right join student d on e.number = d.stu_class_no where d.stu_class_no ='"+stuClass+"'";
            rs = stmt.executeQuery(sql);
            int i = 0;
            while(rs.next())
            {
                i = 1;
                String id = rs.getString("学号");
                String name = rs.getString("学生姓名");
                String class1 = rs.getString("班级编号");
                String classIn = rs.getString("班级名称");
                System.out.println("学号："+id+" 学生姓名："+name+" 班级编号："+class1+" 班级名称："+classIn);
            }
            if(i == 0){
                System.out.println("不存在该记录");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(rs != null){
                    rs.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
            try{
                if(stmt != null){
                    stmt.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
            try{
                if(conn != null){
                    stmt.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }

        }
    }

    @Override
    public void inputClass() {
        Connection conn = null;
        Statement stmt = null;
        try{
            Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.deregisterDriver(driver);
            String url = "jdbc:mysql://localhost:3306/stu_classes";
            String user = "root";
            String password = "zhen415322";
            conn = DriverManager.getConnection(url,user,password);
            stmt = conn.createStatement();
            Scanner enter = new Scanner(System.in);
            System.out.println("请输入班级编号");
            String classNumber = enter.nextLine();
            System.out.println("请输入班级名称");
            String className = enter.nextLine();
            String sql = "insert into classes(number,class_name) value('"+classNumber+"','"+className+"')";
            int count = stmt.executeUpdate(sql);
            System.out.println(count == 1?"保存成功" : "保存失败");
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(stmt != null){
                    stmt.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
            try{
                if(conn != null){
                    stmt.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }

        }
    }

    @Override
    public void selectId() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try{
            Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.deregisterDriver(driver);
            String url = "jdbc:mysql://localhost:3306/stu_classes";
            String user = "root";
            String password = "zhen415322";
            conn = DriverManager.getConnection(url,user,password);
            stmt = conn.createStatement();
            Scanner enter = new Scanner(System.in);
            System.out.println("请输入待查询学生的学号");
            String stuId = enter.nextLine();
            String sql = "select d.id '学号',d.stu_name '学生姓名',d.stu_class_no '班级编号',e.class_name '班级名称' from classes e right join student d on e.number = d.stu_class_no where d.id ='"+stuId+"'";
            rs = stmt.executeQuery(sql);
            if(rs.next())
            {
                String id = rs.getString("学号");
                String name = rs.getString("学生姓名");
                String class1 = rs.getString("班级编号");
                String classIn = rs.getString("班级名称");
                System.out.println("学号："+id+" 学生姓名："+name+" 班级编号："+class1+" 班级名称："+classIn);
            }
            else{
                System.out.println("不存在该记录");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(rs != null){
                    rs.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
            try{
                if(stmt != null){
                    stmt.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
            try{
                if(conn != null){
                    stmt.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }

        }
    }

    @Override
    public void alterStudent() {
        Connection conn = null;
        Statement stmt = null;
        try{
            Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.deregisterDriver(driver);
            String url = "jdbc:mysql://localhost:3306/stu_classes";
            String user = "root";
            String password = "zhen415322";
            conn = DriverManager.getConnection(url,user,password);
            stmt = conn.createStatement();
            Scanner enter = new Scanner(System.in);
            System.out.println("请输入待修改学生的学号");
            String stuId = enter.nextLine();
            System.out.println("请输入修改后学生的学号");
            String stuId1 = enter.nextLine();
            System.out.println("请输入修改后学生的姓名");
            String stuName = enter.nextLine();
            System.out.println("请输入待修改学生的班级编号");
            String stuClass = enter.nextLine();
            String sql = "update student set id = '"+stuId1+"',stu_name = '"+stuName+"',stu_class_no = '"+stuClass+"' where id = '"+stuId+"'";
            int count = stmt.executeUpdate(sql);
            System.out.println(count == 1?"保存成功" : "保存失败");
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(stmt != null){
                    stmt.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
            try{
                if(conn != null){
                    stmt.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }

        }
    }

    @Override
    public void alterClass() {
        Connection conn = null;
        Statement stmt = null;
        try{
            Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.deregisterDriver(driver);
            String url = "jdbc:mysql://localhost:3306/stu_classes";
            String user = "root";
            String password = "zhen415322";
            conn = DriverManager.getConnection(url,user,password);
            stmt = conn.createStatement();
            Scanner enter = new Scanner(System.in);
            System.out.println("请输入待修改班级的编号");
            String classNumber = enter.nextLine();
            System.out.println("请输入修改后班级的编号");
            String classNumber1 = enter.nextLine();
            System.out.println("请输入修改后班级的名称");
            String className = enter.nextLine();
            String sql = "update classes set number = '"+className+"',class_name = '"+className+"' where number = '"+classNumber+"'";
            int count = stmt.executeUpdate(sql);
            System.out.println(count == 1?"保存成功" : "保存失败");
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(stmt != null){
                    stmt.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
            try{
                if(conn != null){
                    stmt.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }

        }
    }

    @Override
    public void remove() {
        Connection conn = null;
        Statement stmt = null;
        try{
            Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.deregisterDriver(driver);
            String url = "jdbc:mysql://localhost:3306/stu_classes";
            String user = "root";
            String password = "zhen415322";
            conn = DriverManager.getConnection(url,user,password);
            stmt = conn.createStatement();
            Scanner enter = new Scanner(System.in);
            System.out.println("请输入待删除学生的学号");
            String stuId = enter.nextLine();
            String sql = "delete from student where id = '"+stuId+"'";
            int count = stmt.executeUpdate(sql);
            System.out.println(count == 1?"保存成功" : "保存失败");
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(stmt != null){
                    stmt.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
            try{
                if(conn != null){
                    stmt.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }

        }
    }
}
