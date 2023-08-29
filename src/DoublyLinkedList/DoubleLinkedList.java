package DoublyLinkedList;

public class DoubleLinkedList {
    Node head;
    Node tail;

    public DoubleLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void add(int data) {
        Node temp = new Node(data);

        if (head == null) {
            head = temp;
            tail = temp;
        } else {
            temp.next = head;
            head.previous = temp;
            head = temp;
        }
    }

    public void add(int data, int pos) {
        Node temp = new Node(data);

        if (pos == 1) {
            add(data);
        } else {
            Node current = head;
            int currentPosition = 1;
            while (current != null && currentPosition < pos) {
                current = current.next;
                currentPosition++;
            }

            if (current == null) {
                add(data);
            } else {
                temp.next = current;
                temp.previous = current.previous;
                current.previous.next = temp;
                current.previous = temp;
            }
        }
    }

    public int size() {
        Node temp = head;
        int counter = 0;

        while (temp != null) {
            counter++;
            temp = temp.next;
        }
        return counter;
    }

    public int get(DoubleLinkedList dList, int index) {
        int size = dList.size();
        int midIndex = size / 2;

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of range");
        } else if (index == head.data) {
            return head.data;
        } else if (index == size - 1) {
            return tail.data;
        }

        Node current = null;

        if (index <= midIndex) {
            //Start from the halfway point and traverse forward
            for (int i = 0; i <= size; i++) {
                current = head;
                current = current.next;
            }
        } else {
            //Start from the halfway point and traverse backwards
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.previous;
            }
        }
        return current.data;
    }

    public void remove(int index) {
        //free the memory allocated to the node to be deleted
        Node temp = head;

        for (int i = 0; i < index && temp != null; i++) {
            temp = temp.next;
        }

        //if list is empty, return *
        if (head == null) {
            return;
        }

        //if node to be deleted is the head node, then update the head node and point to the next node *
        if (temp == head) {
            head = temp.next;
        }

        //if the node to be deleted is the tail node then update the tail node to point to the previous node *
        if (temp == tail) {
            tail = temp.previous;
        }

        //if the node to be deleted is not the head or the tail node then update the previous nodes next pointer to the next node and update the
        // node nodes previous pointer to point to the previous node
        if (temp.previous != null) {
            temp.previous.next = temp.next;
        }

        if (temp.next != null) {
            temp.next.previous = temp.previous;
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Node current = head;

        if (current == null) {
            result.append("List is empty");
        } else {
            while (current != null) {
                result.append(current.data);
                if (current.next != null) {
                    result.append(" -> ");
                }
                current = current.next;
            }
        }

        return result.toString();
    }

    public String toStringReverse() {
        StringBuilder result = new StringBuilder();
        Node current = tail;

        if (current == null) {
            result.append("List is empty");
        } else {
            while (current != null) {
                result.append(current.data);
                if (current.previous != null) {
                    result.append(" -> ");
                }
                current = current.previous;
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        DoubleLinkedList dList = new DoubleLinkedList();

        dList.add(1);
        dList.add(2);
        dList.add(3);
        dList.add(4);
        dList.add(5);
        dList.add(5);

        System.out.println("\n" + "The list has " + dList.size() + " items");
        System.out.println("The value at this index is: " + dList.get(dList, 4));


        System.out.println("Print list");
        System.out.println(dList);

        System.out.println("-Reverse list-");
        System.out.println(dList.toStringReverse());
    }
}