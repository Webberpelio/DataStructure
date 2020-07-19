package sequence;

import java.util.Arrays;
import java.util.Scanner;

public class SequenceDemo {
  public static void main(String[] args) {
    int[] array = {1, 2, 3, 4, 5};
    MySequence mySequence = new MySequence(array);
    //遍历线性表
    mySequence.trip();
    //在指定索引位置插入指定元素
    mySequence.insert(2, 10);
    mySequence.trip();

    //删除指定索引位置的元素
    mySequence.delete(4);
    mySequence.trip();

    //查询指定索引位置的元素
    int search1 = mySequence.search(6);
    System.out.println("查询所得元素为：" + search1);
  }
}

class MySequence {
  private int[] sequence;

  //创建空线性表
  public MySequence() {
    sequence = new int[0];
  }

  //创建指定容量的线性表，并赋初始值
  public MySequence(int n) {
    sequence = new int[n];
    Scanner sc = new Scanner(System.in);
    for (int i = 0; i < n; i++) {
      System.out.print("顺序存储结构的线性表的第" + (i + 1) + "个元素：");
      sequence[i] = sc.nextInt();
    }
  }

  //创建线性表，并使用数组对其进行初始化
  public MySequence(int[] array) {
    sequence = array;
  }

  //插入元素
  public void insert(int loc, int element) {
    if (sequence.length == 0) {
      System.out.println("当前线性表无存储空间");
      return;
    }
    if (loc < 0 || loc > sequence.length) {
      System.out.println("插入位置无效");
      return;
    }
    int[] newSequence = Arrays.copyOf(sequence, sequence.length + 1);
    newSequence[loc] = element;
    for (int i = loc; i < sequence.length; i++) {
      newSequence[i + 1] = sequence[i];
    }
    sequence = newSequence;
  }

  //删除元素
  public void delete(int loc) {
    if (sequence.length == 0) {
      System.out.println("当前线性表为空");
      return;
    }
    if (loc < 0 || loc >= sequence.length) {
      System.out.println("删除位置无效");
      return;
    }
    int element = sequence[loc];
    int[] newSequence = Arrays.copyOf(sequence, sequence.length - 1);
    for (int i = loc; i < newSequence.length; i++) {
      newSequence[i] = sequence[i + 1];
    }
    sequence = newSequence;
    System.out.println("被删除的元素是：" + element);
  }

  //查询线性表中指定索引位置的元素
  public int search(int loc) {
    if (sequence.length == 0) {
      System.out.println("当前线性表为空");
      return -1;
    }
    if (loc < 0 || loc >= sequence.length) {
      System.out.println("检索位置无效");
      return -1;
    }
    return sequence[loc];
  }
  //遍历线性表中的元素
  public void trip() {
    if (sequence.length == 0) {
      System.out.println("当前线性表为空");
      return;
    }
    System.out.print("当前线性表的元素：");
    for (int element : sequence) {
      System.out.print(element + "\t");
    }
    System.out.println();
  }
}
