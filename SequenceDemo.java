package sequence;

import java.util.Arrays;
import java.util.Scanner;

public class SequenceDemo {
  public static void main(String[] args) {
    int[] array = {1, 2, 3, 4, 5};
    MySequence mySequence = new MySequence(array);
    //�������Ա�
    mySequence.trip();
    //��ָ������λ�ò���ָ��Ԫ��
    mySequence.insert(2, 10);
    mySequence.trip();

    //ɾ��ָ������λ�õ�Ԫ��
    mySequence.delete(4);
    mySequence.trip();

    //��ѯָ������λ�õ�Ԫ��
    int search1 = mySequence.search(6);
    System.out.println("��ѯ����Ԫ��Ϊ��" + search1);
  }
}

class MySequence {
  private int[] sequence;

  //���������Ա�
  public MySequence() {
    sequence = new int[0];
  }

  //����ָ�����������Ա�������ʼֵ
  public MySequence(int n) {
    sequence = new int[n];
    Scanner sc = new Scanner(System.in);
    for (int i = 0; i < n; i++) {
      System.out.print("˳��洢�ṹ�����Ա�ĵ�" + (i + 1) + "��Ԫ�أ�");
      sequence[i] = sc.nextInt();
    }
  }

  //�������Ա���ʹ�����������г�ʼ��
  public MySequence(int[] array) {
    sequence = array;
  }

  //����Ԫ��
  public void insert(int loc, int element) {
    if (sequence.length == 0) {
      System.out.println("��ǰ���Ա��޴洢�ռ�");
      return;
    }
    if (loc < 0 || loc > sequence.length) {
      System.out.println("����λ����Ч");
      return;
    }
    int[] newSequence = Arrays.copyOf(sequence, sequence.length + 1);
    newSequence[loc] = element;
    for (int i = loc; i < sequence.length; i++) {
      newSequence[i + 1] = sequence[i];
    }
    sequence = newSequence;
  }

  //ɾ��Ԫ��
  public void delete(int loc) {
    if (sequence.length == 0) {
      System.out.println("��ǰ���Ա�Ϊ��");
      return;
    }
    if (loc < 0 || loc >= sequence.length) {
      System.out.println("ɾ��λ����Ч");
      return;
    }
    int element = sequence[loc];
    int[] newSequence = Arrays.copyOf(sequence, sequence.length - 1);
    for (int i = loc; i < newSequence.length; i++) {
      newSequence[i] = sequence[i + 1];
    }
    sequence = newSequence;
    System.out.println("��ɾ����Ԫ���ǣ�" + element);
  }

  //��ѯ���Ա���ָ������λ�õ�Ԫ��
  public int search(int loc) {
    if (sequence.length == 0) {
      System.out.println("��ǰ���Ա�Ϊ��");
      return -1;
    }
    if (loc < 0 || loc >= sequence.length) {
      System.out.println("����λ����Ч");
      return -1;
    }
    return sequence[loc];
  }
  //�������Ա��е�Ԫ��
  public void trip() {
    if (sequence.length == 0) {
      System.out.println("��ǰ���Ա�Ϊ��");
      return;
    }
    System.out.print("��ǰ���Ա��Ԫ�أ�");
    for (int element : sequence) {
      System.out.print(element + "\t");
    }
    System.out.println();
  }
}
