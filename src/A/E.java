package A;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by LiuSitong on 2017/1/9.
 * 顺序队列
 * 先进先出
 */
public class E {

    private int capacity; //队列的容量

    private String []elementData;   //定义一个数组用于保存顺序队列的元素
    //保存顺序队列中元素的当前个数
    private int front = 0;//出
    private int rear = 0;//进

    @Before
    public void init(){
        elementData=new String[10];
        capacity=elementData.length;
    }
    public String remove() {//删除
        String s=elementData[front];
        elementData[front++]=null;   //首先把现在的头部变为空 front向后移动
        return s;
    }
    public void add(String data) {
        if(rear>capacity){
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        elementData[rear++]=data;//因为是从队列的尾部开始添加的 所以先给尾部赋值再将尾部加1
    }

    @Test
    public void test(){
        add("A");
        add("B");
        add("C");

        System.out.print(remove());
        System.out.print(remove());

    }
}
