package queue;

/**
 * This program demonstrates the queue structure and operations.
 * @version 1.0 2020-07-20
 * @author Wilson Cheung
*/

import java.util.Arrays;
import java.util.Scanner;

public class QueueDemo {
  public static void main(String[] args) {
    int[] array = {1, 3, 5, 7, 9, 10};
    MyQueue myQueue = new MyQueue(array);
    myQueue.trip();
    System.out.println("当前队列是否为空：" + myQueue.isEmpty());
    System.out.println("当前队列是否为满：" + myQueue.isFull());

    //出队
    int element1 = myQueue.remove();
    int element2 = myQueue.remove();
    System.out.println("出队的元素：" + element1 + "------" + element2);
    myQueue.trip();
    myQueue.reverseTrip();
    System.out.println("当前队列是否为满：" + myQueue.isFull());

    //入队
    myQueue.add(3);
    myQueue.add(9);
    myQueue.trip();
    System.out.println("当前队列是否为满：" + myQueue.isFull());
  }
}

class MyQueue {
  private int[] queue;
  private int front;  //队首
  private int rear;   //队尾

  //创建空队列
  public MyQueue() {
    queue = new int[0];
    front = 0;
    rear = 0;
  }

  //创建队列，将数组中包含的元素存储至该队列
  public MyQueue(int[] array) {
    queue = Arrays.copyOf(array, array.length + 1);
    front = 0;
    rear = array.length;
  }

  //创建队列，并初始化其容量
  public MyQueue(int n) {
    queue = new int[n];
    Scanner sc = new Scanner(System.in);
    for (int i = 0; i < n - 1; i++) {
      System.out.print("请输入第" + (i + 1) + "个元素：");
      queue[i] = sc.nextInt();
    }
    front = 0;
    rear = n - 1;
  }

  //判断队空
  public boolean isEmpty() {
    if (queue.length == 0) {
      return true;  //表示队空
    }
    return false; //表示队非空
  }

  //判断队满
  public boolean isFull() {
    if ((rear + 1) % queue.length == front) {
      return true;
    }
    return false;
  }

  //入队
  public void add(int element) {
    rear = (rear + 1) % queue.length; //调整队尾
    if (isFull()) { //若调整后队列即满，则需要将队尾还原
      if (rear == 0) {  //若调整后的队列即满，而且队尾此时为数组的第一个位置，则需要将队尾还原为数组的最后一个位置
        rear = queue.length - 1;
      } else {
        rear = (rear - 1) % queue.length;
      }
      return;
    }
    //当调整队尾后队列非满，即可执行入队，由于当前队尾为调整后的队尾，所以入队的位置为当前队尾位置的前一位
    if (rear == 0) {  //将队列想象成首尾相接的圆环，如果新队尾为数组的第一个位置，则入队的位置为数组的最后一位
      queue[queue.length - 1] = element;
      return;
    }
    queue[rear - 1] = element;  //否则直接令当前队尾的前一位为入队位置
  }

  //出队
  public int remove() {
    if (isEmpty()) {
      System.out.println("当前队列为空");
      return -1;
    }
    int element = queue[front];
    queue[front] = 0;
    front = (front + 1) % queue.length;
    return element;
  }

  //从队首至队尾遍历队列中的元素
  public void trip() {
    System.out.print("从队首至队尾：");
    for (int i = 0; i < queue.length; i++) {
      System.out.print(queue[i] + "\t");
    }
    System.out.println();
  }

  //从队尾至队首遍历队列中的元素
  public void reverseTrip() {
    System.out.print("从队尾至队首：");
    for (int i = queue.length - 1; i >= 0; i--) {
      System.out.print(queue[i] + "\t");
    }
    System.out.println();
  }
}
