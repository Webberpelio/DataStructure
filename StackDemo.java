package stack;

import java.util.Arrays;
import java.util.Scanner;

public class StackDemo {
  public static void main(String[] args) {
    //�����Զ���ջ
    //MyStack myStack = new MyStack(10);

    int[] array = {1, 3, 5, 7, 9, 10};
    MyStack myStack = new MyStack(array);


    //MyStack myStack = new MyStack();

    System.out.println("��ǰջ�Ƿ�Ϊ�գ�" + myStack.isEmpty());
    //����ջ�е�Ԫ�أ���ջ����ջ��
    myStack.stackBotToTop();

    //��ջ
    myStack.push(2);
    //��ջ����ջ������ջ�е�Ԫ��
    myStack.stackTopToBot();

    //��ջ
    int pop1 = myStack.pop();
    int pop2 = myStack.pop();
    System.out.println("��ջ��Ԫ��Ϊ��" + pop1 + ", " + pop2);
    myStack.stackTopToBot();

    //ȡջ��Ԫ�أ���������ջ
    System.out.println("��ǰ��ջ��Ԫ�أ�" + myStack.peak());
  }
}

//�������ݽṹ�е����Ա�---ջ
class MyStack {
  private int[] stackArray;

  //������ջ
  public MyStack() {
    stackArray = new int[0];
  }

  //����������ʼֵ�ķǿ��Զ���ջ
  public MyStack(int n) {
    stackArray = new int[n];  //����һ��ָ�����ȵ����飬��ʾջ�Ĵ洢�ռ�
    Scanner sc = new Scanner(System.in);
    for (int i = 0; i < n; i++) {
      System.out.println("�������" + (i + 1) + "��Ԫ�ؽ�ջ��");
      stackArray[i] = sc.nextInt();
    }
  }

  //�����ǿ��Զ���ջ
  public MyStack(int[] array) {
    stackArray = array;
  }

  //��ջ��
  public boolean isEmpty() {
    if (stackArray.length == 0) {
      return true;  //����ջ��
    }
    return false;   //����ջ��
  }
  //��ջ
  public void push(int element) {
    stackArray = Arrays.copyOf(stackArray, stackArray.length + 1);   //������ջ�Ĵ洢�ռ�����
    stackArray[stackArray.length - 1] = element;  //��ջ�����Ԫ��
  }

  //��ջ
  public int pop() {
    if (!isEmpty()) {
      int element = stackArray[stackArray.length - 1];  //ȡջ��Ԫ��
      stackArray = Arrays.copyOf(stackArray, stackArray.length - 1);
      return element;
    }
    return -1;
  }

  //�鿴��ǰ��ջ��Ԫ��
  public int peak() {
    if (!isEmpty()) {
      return stackArray[stackArray.length - 1];
    }
    return -1;
  }

  //����ջ�е�Ԫ�أ���ջ�׵�ջ��
  public void stackTopToBot() {
    if (isEmpty()) {
      System.out.println("��ǰջΪ��ջ");
      return;
    }
    System.out.print("��ջ����ջ������Ϊ��");
    for (int i = 0; i < stackArray.length; i++) {
      System.out.print(stackArray[i] + "\t");
    }
    System.out.println();
  }

  //����ջ�е�Ԫ�أ���ջ����ջ��
  public void stackBotToTop() {
    if (isEmpty()) {
      System.out.println("��ǰջΪ��ջ");
      return;
    }
    System.out.print("��ջ�׵�ջ������Ϊ��");
    for (int i = stackArray.length - 1; i >= 0; i--) {
      System.out.print(stackArray[i] + "\t");
    }
    System.out.println();
  }
}
