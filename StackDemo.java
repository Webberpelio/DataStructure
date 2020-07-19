package stack;

import java.util.Arrays;
import java.util.Scanner;

public class StackDemo {
  public static void main(String[] args) {
    //创建自定义栈
    //MyStack myStack = new MyStack(10);

    int[] array = {1, 3, 5, 7, 9, 10};
    MyStack myStack = new MyStack(array);


    //MyStack myStack = new MyStack();

    System.out.println("当前栈是否为空：" + myStack.isEmpty());
    //遍历栈中的元素，自栈顶向栈底
    myStack.stackBotToTop();

    //进栈
    myStack.push(2);
    //自栈底向栈顶遍历栈中的元素
    myStack.stackTopToBot();

    //出栈
    int pop1 = myStack.pop();
    int pop2 = myStack.pop();
    System.out.println("出栈的元素为：" + pop1 + ", " + pop2);
    myStack.stackTopToBot();

    //取栈顶元素，但并不出栈
    System.out.println("当前的栈顶元素：" + myStack.peak());
  }
}

//定义数据结构中的线性表---栈
class MyStack {
  private int[] stackArray;

  //创建空栈
  public MyStack() {
    stackArray = new int[0];
  }

  //创建包含初始值的非空自定义栈
  public MyStack(int n) {
    stackArray = new int[n];  //创建一个指定长度的数组，表示栈的存储空间
    Scanner sc = new Scanner(System.in);
    for (int i = 0; i < n; i++) {
      System.out.println("请输入第" + (i + 1) + "个元素进栈：");
      stackArray[i] = sc.nextInt();
    }
  }

  //创建非空自定义栈
  public MyStack(int[] array) {
    stackArray = array;
  }

  //判栈空
  public boolean isEmpty() {
    if (stackArray.length == 0) {
      return true;  //代表栈空
    }
    return false;   //代表栈满
  }
  //进栈
  public void push(int element) {
    stackArray = Arrays.copyOf(stackArray, stackArray.length + 1);   //将现有栈的存储空间增大
    stackArray[stackArray.length - 1] = element;  //在栈顶添加元素
  }

  //出栈
  public int pop() {
    if (!isEmpty()) {
      int element = stackArray[stackArray.length - 1];  //取栈顶元素
      stackArray = Arrays.copyOf(stackArray, stackArray.length - 1);
      return element;
    }
    return -1;
  }

  //查看当前的栈顶元素
  public int peak() {
    if (!isEmpty()) {
      return stackArray[stackArray.length - 1];
    }
    return -1;
  }

  //遍历栈中的元素，由栈底到栈顶
  public void stackTopToBot() {
    if (isEmpty()) {
      System.out.println("当前栈为空栈");
      return;
    }
    System.out.print("从栈顶到栈底依次为：");
    for (int i = 0; i < stackArray.length; i++) {
      System.out.print(stackArray[i] + "\t");
    }
    System.out.println();
  }

  //遍历栈中的元素，由栈顶到栈底
  public void stackBotToTop() {
    if (isEmpty()) {
      System.out.println("当前栈为空栈");
      return;
    }
    System.out.print("从栈底到栈顶依次为：");
    for (int i = stackArray.length - 1; i >= 0; i--) {
      System.out.print(stackArray[i] + "\t");
    }
    System.out.println();
  }
}
