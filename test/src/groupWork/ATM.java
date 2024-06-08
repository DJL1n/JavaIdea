package src.groupWork;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class ATM
{
    private ArrayList<Account> accounts=new ArrayList<>();
    private Scanner sc=new Scanner(System.in);
    private Account loginacc;
    //欢迎的页面
    public void start()
    {
        while (true)
        {
            System.out.println("---------欢迎来到xu的银行---------");
            System.out.println("1:用户登录");
            System.out.println("2:用户开户");
            System.out.println("请选择您的操作");
            int command=sc.nextInt();
            switch (command)
            {
                case 1:
                    //用户登陆
                    login();
                    break;
                case 2:
                    //用户开户
                    creatAccount();
                    break;
                default:
                    System.out.println("没有该操作");
            }
        }
    }
    //开户操作
    public void creatAccount()
    {
        System.out.println("-----开户页面-------");
        //创造一个账户对象，用于封装用户的开户信息
        Account acc=new Account();
        //用户输入开户信息，赋值给账户对象
        System.out.println("请输入您的用户名");
        String name=sc.next();
        acc.setUsername(name);

        //设置用户的性别
        while(true)
        {
            System.out.println("请输入您的性别");
            char sex=sc.next().charAt(0);
            if(sex=='男'||sex=='女')
            {
                acc.setSex(sex);
                break;
            }
            else{
                System.out.println("您输入的性别有误，只能输入 男 ，女");
            }
        }

        //设置用户的密码
        while(true)
        {
            System.out.println("请输入您的密码");
            String password1=sc.next();
            System.out.println("请确认您的密码");
            String password2=sc.next();
            if(password1.equals(password2))
            {
                acc.setPassword(password1);
                break;
            }
            else {
                System.out.println("您第2次输入的密码有误，请重新输入");
            }
        }

        //设置账号的限制余额
        System.out.println("请输入您的限制额度");
        double limit=sc.nextDouble();
        acc.setLimit(limit);

        //生成卡号
        String newid=carId();
        acc.setCarid(newid);

        //把账户对象填加到集合中去
        accounts.add(acc);
        System.out.println("恭喜您"+acc.getUsername()+"开户成功，您的卡号是"+acc.getCarid());

    }
    //随机生成一个卡号8位数
    private String carId()
    {
        while(true)
        {
            String carid="";
            Random r=new Random();
            for(int i=0;i<8;i++)
            {
                int date=r.nextInt(10);//0-9
                carid+=date;
            }
            //判断是否有相同的卡号，没有就返回当前卡号，有就继续创造新的卡号
            Account acc=getid(carid);
            if(acc==null)
            {
                //没有相同账户的卡号
                return carid;
            }
        }
    }
    //判断ATM中是否有相同的卡号
    private Account getid(String carid)
    {
        for(int i=0;i<accounts.size();i++)
        {
            Account acc=accounts.get(i);
            if(acc.getCarid().equals(carid))
            {
                return acc;
            }
        }
        //如果没有相同的卡号就返回空
        return null;
    }

}
