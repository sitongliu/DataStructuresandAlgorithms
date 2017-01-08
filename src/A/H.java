package A;

import org.junit.Test;

/**
 * Created by LiuSitong on 2017/1/8.
 * 链式的双向队列
 */
public class H {
    private Node front;  //节点的头部
    private Node rear;   //节点的尾部
    public  class Node {
        String data;
        Node next;  //后继指针
        Node previous; //前驱指针

        Node(String data) {
            this.data = data;
        }

    }
        /**
         * 从头部开始插入
         */
        public void insertFront(String data){
            //创建一个新节点，（准备插入队列的）
            Node newNode = new Node(data);
            //判断队列里面有没有节点
            if (front == null){
                rear = newNode;   //没有就直接插入
            }else { //有节点就把新节点放在首节点还前面 ， 也就是前驱节点
                front.previous = newNode;
            }
            newNode.next = front; //首节点排老二了现在
            front = newNode; //现在 队列的首节点就是新的节点了
        }

        /**
         * 从队列的尾巴插进去 o~好邪恶
         * @param data
         */
        public  void insertRear(String data){
            //第一步同样创建一个新的节点
            Node newNode = new Node(data);
            //同样判断有没有节点
            if (front == null ){
                rear = newNode;
            }else {  //如果有节点的话 ，那就在尾巴插入
                rear.next = newNode;
            }
            //现在新的尾巴已经产生
            newNode.previous = rear;
            rear = newNode;
        }

        //从头部删除
        public String deleteFront(){
            Node node = front;
            front= node.next; // 头节点向后移一个

            if(front!=null){//至少有两个节点
                front.previous=null;
            }else{
                rear=null;
            }
            return node.data;
        }

        public String deleteRear(){
            Node node = rear;
            rear= rear.previous; // 尾节点向前移一个

            if(rear!=null){//至少有两个节点
                rear.next=null;
            }else{
                front=null;
            }
            return node.data;
        }


    @Test
        public void test(){
            insertFront("A");
            insertFront("B");
            insertRear("C");
            insertFront("D");
            //DABC
            System.out.print(deleteRear());
            System.out.print(deleteFront());
        }




    }


