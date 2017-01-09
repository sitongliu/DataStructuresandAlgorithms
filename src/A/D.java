package A;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by LiuSitong on 2017/1/9.
 *  Dijkstra 双栈算法表达式
 *  缺点就是每个表达式都要有完整的括号包着才可
 *  遇见右括号就开始进行运算
 *  同样是有两个栈  一个用来保存数 一个用来保存符号
 */
public class D {
    //(((1+3)*2)-5)

    private Stack<Integer> numStack  = new Stack<>();
    private Stack<Character> charStack = new Stack<>();

    @Test
    public  void  push(){
        String a ="(((1+3)*2)-5)";
        char []c = a.toCharArray();
        for (int i=0;i<c.length;i++){
            if (c[i]=='('){
                //什么也不做 ... 就这样放空自己
            }else  if (c[i]=='+'){
                charStack.push(c[i]);
            } else  if (c[i]=='-'){
                charStack.push(c[i]);
            }else  if (c[i]=='*'){
                charStack.push(c[i]);
            } else  if (c[i]=='/'){
                charStack.push(c[i]);
            }else  if (c[i]==')'){ //现在遇见左括号 开始进行运算
                Integer n =numStack.pop();//操作数弹出
                char c1 =charStack.pop();//操作符弹出
                if(c1=='+'){
                    n=n+numStack.pop();
                }else if(c1=='*'){
                    n=n*numStack.pop();
                }else if(c1=='-'){
                    n=numStack.pop()-n;
                }else if(c1=='/'){
                    n=numStack.pop()/n;
                }
                numStack.push(n);
            }else {  //当是数字不是符号的情况 ，压入numStack
                numStack.push(Integer.parseInt(c[i]+""));
            }
        }
        System.out.println(numStack.peek());
    }



}
