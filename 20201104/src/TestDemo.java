import java.util.Stack;

public class TestDemo {
    
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            //左括号进行入栈
            char tmp = s.charAt(i);
            if (tmp == '(' || tmp == '[' || tmp == '{') {
                stack.push(tmp);
            }else {
                //2.判断栈是否为空
                if(stack.empty()) {
                    System.out.println("右括号多！");
                    return false;
                }else {
                    //3.判断栈顶元素的字符左括号和当前的字符 右括号是否匹配
                    char cur = s.charAt(i);
                    char topChar = stack.peek();//栈内字符
                    if(cur == ')' && topChar == '(' || cur == ']' && topChar == '['
                            || cur == '}' && topChar == '{' ) {
                        //匹配的
                        stack.pop();
                    }else {
                        System.out.println("右括号不匹配左括号");
                        return false;
                    }
                }
            }
        }
        //4.判断栈是否为空
        if(!stack.empty()) {
            System.out.println("左括号多！");
            return false;
        }
        System.out.println("括号匹配");
        return true;
    }

    public static void main(String[] args) {

    }
}
