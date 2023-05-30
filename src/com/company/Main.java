package com.company;

public class Main {

    public static void main(String[] args) {
	CirculærDobbelLinkedList list= new CirculærDobbelLinkedList();
       list.create(1);
        list.insert(1,1);
        list.insert(3,0);
        list.insert(5,3);
        list.insert(4,2);





        list.traverse();
       list.reverse();
      list.clear();
      list.traverse();
        System.out.println(list.size);

    }
}
