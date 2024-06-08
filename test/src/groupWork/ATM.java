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
