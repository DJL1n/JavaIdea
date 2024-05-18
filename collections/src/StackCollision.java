public class StackCollision {
    public static void main(String[] args) {
        Stack<String> stack=new Stack<>();
        for (String s : "my dog has fleas".split(" ")) {
            stack.push(s);
        }
        while (!stack.isEmpty())
            System.out.println(stack.pop() + " ");

        java.util.Stack<String> stack2=new java.util.Stack<>();
        for (String s : "my dog has fleas".split(" ")) {
            stack2.push(s);
        }
        while (!stack2.isEmpty())
            System.out.println(stack2.pop() + " ");
    }
}
