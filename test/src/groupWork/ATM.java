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

    public  void login()
    {
        System.out.println("-----登录页面------");
        if(accounts.size()==0)
        {
            System.out.println("账户上没有用户，请先开户");
            return;
        }
        while (true)
        {
            System.out.println("请输入您的登录卡号");
            String carid=sc.next();
            Account acc=getid(carid);
            if(acc==null)
            {
                System.out.println("您输入的卡号不存在，请重新输入");
            }
            else {
                while(true)
                {
                    System.out.println("请输入您的密码");
                    String password=sc.next();
                    //判断是否正常
                    if(acc.getPassword().equals(password))
                    {
                        loginacc=acc;
                        System.out.println("恭喜您"+acc.getUsername()+"登录成功，您的卡号："+acc.getCarid());
                        //登录后的页面展示
                        showusercommand();
                        return;
                    }
                    else{
                        System.out.println("您输入的密码有误");
                    }
                }
            }
        }

    }
    //登录后的页面展示
    private void showusercommand()
    {
        while(true)
        {
            System.out.println(loginacc.getUsername()+"您可以选择如下功能对账户进行处理：");
            System.out.println("1:查询账户");
            System.out.println("2:存款");
            System.out.println("3:取款");
            System.out.println("4:转账");
            System.out.println("5:密码修改");
            System.out.println("6:退出");
            System.out.println("7:注销当前账户");
            System.out.println("请选择您的操作");
            int command=sc.nextInt();
            switch (command)
            {
                case 1:
                    //查询账户
                    showloginacc();
                    break;
                case 2:
                    //存款
                    depositmoney();
                    break;
                case 3:
                    //取款
                    drawmoney();
                    break;
                case 4:
                    //转账
                    transfermoney();
                    break;
                case 5:
                    //密码修改
                    updatepassword();
                    return;//返回欢迎界面
                case 6:
                    //退出
                    System.out.println(loginacc.getUsername()+"恭喜您退出成功");
                    return;
                case 7:
                    //注销当前账户
                    if(deleteaccount())
                    {
                        //销户成功了,返回欢迎页面
                        return;
                    }
                    break;
                default:
                    System.out.println("当前命令不存在");
            }
        }
    }
    //查询账户
    private  void showloginacc()
    {
        System.out.println("-----当前您的账户信息如下------");
        System.out.println("卡号:"+loginacc.getCarid());
        System.out.println("户主："+loginacc.getUsername());
        System.out.println("余额:"+loginacc.getMoney());
        System.out.println("限制额度:"+loginacc.getLimit());

    }
    //存款功能
    private  void depositmoney()
    {
        System.out.println("----存款操作---");
        System.out.println("请输入您的存款金额");
        double money=sc.nextDouble();
        loginacc.setMoney(loginacc.getMoney()+money);
        System.out.println("恭喜您成功存款"+money+"您的当前余额为"+loginacc.getMoney());
    }
    //取款功能
    private void drawmoney()
    {
        System.out.println("------取款操作------");
        if(loginacc.getMoney()<100)
        {
            System.out.println("您的账户余额不足，当前余额为"+loginacc.getMoney());
            return;
        }
        System.out.println("请输入您要取款的金额");
        double money=sc.nextDouble();
        while (true)
        {
            if(loginacc.getMoney()>=money)
            {
                if(money> loginacc.getLimit())
                {
                    System.out.println("您的取款金额超出了最高限制"+loginacc.getLimit());
                    break;
                }
                else {
                    loginacc.setMoney(loginacc.getMoney()-money);
                    System.out.println("恭喜您成功取款"+money+"您的当前账户余额为"+loginacc.getMoney());
                    break;
                }
            }
            else {
                System.out.println("您的余额不足，您当前余额为"+loginacc.getMoney());
                break;
            }


        }

    }
    //转账功能
    private void transfermoney() {
        System.out.println("-----转账操作-------");
        //判断账号个数
        if (accounts.size() < 2) {
            System.out.println("当前账户上只有您一个账号，无法转账请开户");
            return;
        }
        //判断有没有钱
        if (loginacc.getMoney() == 0) {
            System.out.println("余额不足无法转账");
            return;
        }
        //转账开始
        while (true) {
            System.out.println("请输入要转入的卡号");
            String carid = sc.next();
            //判断卡号是否正正确
            Account acc = getid(carid);
            if (acc == null) {
                System.out.println("您输入的卡号不存在，请重新输入");
            } else {
                //卡号正确开始转账
                String name = "*" + acc.getUsername().substring(1);//*三
                System.out.println("请您输入" + name + "的姓");
                String putname = sc.next();
                //判断是否正确


                if (acc.getUsername().startsWith(putname)) {
                    //认证通过
                    while (true) {
                        System.out.println("请输入您要转账的金额");
                        double money = sc.nextDouble();
                        if (loginacc.getMoney() >= money) {
                            //转账给对方
                            loginacc.setMoney(loginacc.getMoney() - money);//自己扣钱
                            acc.setMoney(acc.getMoney() + money);//对方加钱
                            System.out.println("转账成功："+money);
                            return;
                        } else {
                            System.out.println("您的账户余额不足，您的当前余额为" + loginacc.getMoney());
                        }
                    }
                }
                else {
                    System.out.println("认证失败，请重新输入");
                }
            }

        }
    }

}
