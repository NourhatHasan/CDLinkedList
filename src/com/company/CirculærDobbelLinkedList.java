package com.company;

public class CirculærDobbelLinkedList {
    public Node head;
    public Node tail;
    public int size;

    public void create(int value){
        Node node= new Node();
        node.value=value;
        head=tail= node;
        size+=1;
       /* head.next=tail;
        tail.next=head;
        head.prev=tail;
        tail.prev=head;*/
        node.next=node;
        node.prev=node;
    }


    public void insert(int value, int index){
        if(size==0){
            create(value);
        }
        else{
            Node node= new Node();
            node.value=value;

            if(index==0){
                Node temp=head;
                head=node;
                node.next=temp;
                temp.prev=node;
                node.prev=tail;
                tail.next=node;
                size++;

            }
            else if(index>=size){
                Node temp=tail;
                tail=node;
                node.prev=temp;
                temp.next=node;
                node.next=head;
                head.prev=node;
                size++;
            }
            else{
                int l=0;
                Node temp=head;
                while (l<index-1){
                   temp=temp.next;
                   l++;
                }
                Node beforNext= temp.next;
                temp.next= node;
                node.next=beforNext;
                beforNext.prev=node;
                node.prev=temp;
                size++;
            }
        }
    }
    public void traverse(){
        for(int i=0;i<size;i++){
            System.out.print(head.value);
            if(i<size-1){
                System.out.print("->");
            }

            head=head.next;
        }
        System.out.println();
    }

    public void reverse(){
        for (int i=size-1;i>=0;i--){
            System.out.print(tail.value);
            if(i>0){
                System.out.print("<-");
            }

            tail=tail.prev;
        }
        System.out.println();
    }

    public void search(int value){
       boolean funnet=false;
        Node current = head;
        for (int i=0;i<size;i++){
            if(current.value==value){
                System.out.println("Value found at index: " + i);

                funnet=true;
                break;
            }
            else{
                current=current.next;
            }

        }
        if(funnet==false){
            System.out.println("valuesn ble ikke funnet");
        }

    }

    public void delete( int index){
        if(index==0 && size==1){


           head.prev=null;
           head.next=null;
            head=tail=null;
            size--;
        }
        else if(index==0 && size!=1){
            Node temp=head.next;
            head=temp;
            tail.next=temp;
            temp.prev=temp;
            size--;
        }
        else if(index>=size-1){
            Node temp=tail.prev;
            tail=temp;
            head.prev=temp;
            temp.next=head;
            size--;
        }
        else{
            Node temp= head;
            int l=0;
            while (l<index-1){
                l++;
                temp=temp.next;
            }
            Node n= temp.next.next;
            temp.next=n;
            n.prev=temp;
            size--;
        }
    }

    public void clear(){
       for(int i=0;i<size;i++){
          Node temp=head;
           head=head.next;

           temp.next=null;
           temp.prev=null;
           temp=null;

       }
        tail= head= null;
       size=0;
    }
}
