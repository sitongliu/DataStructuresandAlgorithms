package A;

import org.junit.Test;

/**
 * Created by LiuSitong on 2017/1/8.
 * 自己手写版Stack  利用对象数组
 */
public class B {
    //确定对象数组大小
    private   Object []obj = new Object[3];
    //跟踪对象数组的大小
    private int size = 0;

    @Test
    public void  test(){
        push("a");
        push("b");
        push("c");
        push("d");

        System.out.println(pop()+ " "+peek());
    }

    public void push(Object data){
        //判断栈的大小是否够用，不够就扩充
        if (size>=obj.length){
            resize();
        }
        obj[size++]= data;  //将数据压进栈中 让后size+1

    }

    public  Object pop (){
        if (size == 0){
            System.out.println("size =  0");
        }
        Object a = obj[size-1];  //栈中的最后一个进入的数据
        obj[--size] = null;//原来的最后一个数据变成空
        return a;
    }
    public Object peek(){
        Object o=obj[size-1];//因为数组是从0开始，
        return o;
    }

    public void resize() {
        Object []object =  new Object[obj.length*3];
        for (int i= 0; i<obj.length;i++){
            object[i] = obj[i];
            obj[i]= null;
        }
        obj  = object;
    }


}
