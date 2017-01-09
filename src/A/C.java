package A;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by LiuSitong on 2017/1/9.
 * 获取最小栈
 * 失恋好痛苦 让我沉浸在代码中不能自拔吧~
 */
public class C {
    /**
     * dataStack 数据栈
     * stackMin 最小栈
     * 思路：将数据和最小栈的栈顶相比较 如果要压入的数据大于栈顶那就不压入，小于等于就压入 最小栈的栈顶就是最小的数据
     */
    private Stack<Integer> dataStack=new Stack<>();
    private Stack<Integer> stackMin=new Stack<>();

@Test
    public void test(){
    push(1);
    push(2);
    push(3);
    push(0);
    System.out.println(stackMin.peek());
    }
    public void push(Integer data) {
        if (stackMin.isEmpty()){
            stackMin.push(data);
        }else {
            if (data<=stackMin.peek()){
                stackMin.push(data);
            }
        }

        dataStack.push(data);
    }
}
