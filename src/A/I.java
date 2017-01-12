package A;

import org.junit.Test;

/**
 * Created by LiuSitong on 2017/1/12.
 * 单向链表的插入 删除
 */
public class I {
    public  class  Node{
        public String data;
        private Node  next;
        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
    private Node header;
    private Node tail;
    private int size=0;
    /**
     * 在头部插入数据
     * @param data
     */
    public void insertHeader(String data){
        Node newNode = new Node(data,header);
        this.header = newNode;
        if (tail == null){  //如果在没有节点的情况下;
            tail = newNode;
        }
        size++;
    }

    /**
     * 在链表的尾部插入数据
     * @param data
     */
    public  void  insertTail(String data){
        Node newNode = new Node(data,null);  // null 代表下一个节点是空
        if (header == null){
            header = newNode;
        }else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    /**
     * 链表的特性 可以在任何地方进行插入
     * @param data
     * @param index  想要插入数据位置的索引号
     */
    public void insertAnyWhere(String data,int index){
        if (index<0 || index >= size){
            System.out.println("超出范围");
        }
        if (index==0){   //索引号是0的话那就是在头部插入
            insertHeader(data);
        }
        if (index == size-1){  //在尾部插入
            insertTail(data);
        }
        //找到想要插入的索引的前一个索引
        Node prev = findprev(index-1);
        prev.next = new Node(data,prev.next);  //插入
        size++;
    }

    /**
     * 查找当前要插入节点的前一个节点
     * @param index
     * @return 返回当前节点
     */
    public Node findprev(int index) {
        Node currentNode = header;  //最开始当前节点是头部

        for (int i=0 ;i<size;i++){
            if (i == index){
                return  currentNode;
            }
            currentNode = currentNode.next; //如果不满足 i == index 的情况那就接着查找下一个节点
        }
        return  currentNode;
    }

    /**
     *
     * @param index 想要删除节点的索引号
     * @return 要删除的节点
     */
    public String deleteNode(int index){
        Node del = null;
        if (index == 0 ){ //删除首节点
            del = header;   //？
            header.next = header;
        }

        Node pre = findprev(index-1);
        del = pre.next;
        pre.next = del.next;

        del.next = null;
        return  del.data;
    }

    @Override
    public String toString() {
        StringBuffer sb=new StringBuffer();
        for(Node current=header;current!=null;current=current.next){

            sb.append(current.data);
        }


        return sb.toString();
    }

    @Test
    public void test(){
        this.insertHeader("a");
        this.insertHeader("b");
        this.insertHeader("c");
        this.insertTail("d");
        this.insertAnyWhere("f",1);
        System.out.println(this.toString());

        System.out.println(deleteNode(1).toString());

    }


}
