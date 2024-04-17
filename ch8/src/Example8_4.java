public class Example8_4 {
    public static void main(String[] args) {
        int m=7;
        String binaryString=Integer.toBinaryString(m);
        System.out.println(m + "的二进制：");
        System.out.println(binaryString);
        m=-8;
        binaryString=Integer.toBinaryString(m);
        System.out.println(m + "的二进制（补码）");
        System.out.println(binaryString);
        double sum=0,item=0;
        boolean computable=true;
        for (String s : args) {
            try{
                item=Double.parseDouble(s);
                sum+=item;
            }catch (NumberFormatException e){
                System.out.println("您输入了非数字字符：" + e);
                computable=false;
            }
        }
        if(computable){
            System.out.println("sum=" + sum);
            String numberStr=String.valueOf(sum);
            int dotPosition=numberStr.indexOf(".");
            String integerPart=numberStr.substring(0,dotPosition);
            String decimalPart =numberStr.substring(dotPosition+1);
            System.out.println("整数部分是：" + integerPart);
            System.out.println("小数部分是："+decimalPart);
        }
    }
}
