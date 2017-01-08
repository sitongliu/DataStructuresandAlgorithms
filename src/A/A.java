package A;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.junit.Test;

import java.util.Enumeration;
import java.util.Stack;

/**
 * Created by LiuSitong on 2017/1/8.
 *使用JDK版的Stack
 */
public class A {
    @Test
    public void test(){
        Stack stack  = new Stack();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");

        System.out.println(stack.pop());
        System.out.print(stack.peek());
        Enumeration e = stack.elements();
        while (e.hasMoreElements()){
            System.out.println(e.nextElement());
        }

    }

}
