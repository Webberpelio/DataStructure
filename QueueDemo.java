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
    System.out.println("��ǰ�����Ƿ�Ϊ�գ�" + myQueue.isEmpty());
    System.out.println("��ǰ�����Ƿ�Ϊ����" + myQueue.isFull());

    //����
    int element1 = myQueue.remove();
    int element2 = myQueue.remove();
    System.out.println("���ӵ�Ԫ�أ�" + element1 + "------" + element2);
    myQueue.trip();
    myQueue.reverseTrip();
    System.out.println("��ǰ�����Ƿ�Ϊ����" + myQueue.isFull());

    //���
    myQueue.add(3);
    myQueue.add(9);
    myQueue.trip();
    System.out.println("��ǰ�����Ƿ�Ϊ����" + myQueue.isFull());
  }
}

class MyQueue {
  private int[] queue;
  private int front;  //����
  private int rear;   //��β

  //�����ն���
  public MyQueue() {
    queue = new int[0];
    front = 0;
    rear = 0;
  }

  //�������У��������а�����Ԫ�ش洢���ö���
  public MyQueue(int[] array) {
    queue = Arrays.copyOf(array, array.length + 1);
    front = 0;
    rear = array.length;
  }

  //�������У�����ʼ��������
  public MyQueue(int n) {
    queue = new int[n];
    Scanner sc = new Scanner(System.in);
    for (int i = 0; i < n - 1; i++) {
      System.out.print("�������" + (i + 1) + "��Ԫ�أ�");
      queue[i] = sc.nextInt();
    }
    front = 0;
    rear = n - 1;
  }

  //�ж϶ӿ�
  public boolean isEmpty() {
    if (queue.length == 0) {
      return true;  //��ʾ�ӿ�
    }
    return false; //��ʾ�ӷǿ�
  }

  //�ж϶���
  public boolean isFull() {
    if ((rear + 1) % queue.length == front) {
      return true;
    }
    return false;
  }

  //���
  public void add(int element) {
    rear = (rear + 1) % queue.length; //������β
    if (isFull()) { //����������м���������Ҫ����β��ԭ
      if (rear == 0) {  //��������Ķ��м��������Ҷ�β��ʱΪ����ĵ�һ��λ�ã�����Ҫ����β��ԭΪ��������һ��λ��
        rear = queue.length - 1;
      } else {
        rear = (rear - 1) % queue.length;
      }
      return;
    }
    //��������β����з���������ִ����ӣ����ڵ�ǰ��βΪ������Ķ�β��������ӵ�λ��Ϊ��ǰ��βλ�õ�ǰһλ
    if (rear == 0) {  //�������������β��ӵ�Բ��������¶�βΪ����ĵ�һ��λ�ã�����ӵ�λ��Ϊ��������һλ
      queue[queue.length - 1] = element;
      return;
    }
    queue[rear - 1] = element;  //����ֱ���ǰ��β��ǰһλΪ���λ��
  }

  //����
  public int remove() {
    if (isEmpty()) {
      System.out.println("��ǰ����Ϊ��");
      return -1;
    }
    int element = queue[front];
    queue[front] = 0;
    front = (front + 1) % queue.length;
    return element;
  }

  //�Ӷ�������β���������е�Ԫ��
  public void trip() {
    System.out.print("�Ӷ�������β��");
    for (int i = 0; i < queue.length; i++) {
      System.out.print(queue[i] + "\t");
    }
    System.out.println();
  }

  //�Ӷ�β�����ױ��������е�Ԫ��
  public void reverseTrip() {
    System.out.print("�Ӷ�β�����ף�");
    for (int i = queue.length - 1; i >= 0; i--) {
      System.out.print(queue[i] + "\t");
    }
    System.out.println();
  }
}
