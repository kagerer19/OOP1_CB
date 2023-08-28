package DoublyLinkedList;

public class doubleList {

    /*@Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        node<T> current = head;

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
    }*/

    class Main {
        static node head = null;
        static node first = null;
        static node tail = null;
        static node temp = null;
        static int i = 0;
        /*doubleList<Integer> list = new doubleList<>();*/

        static void add(int k) {
            //Allocate memory to the pointer node
            node pointer = new node();

            //assign key to value k
            pointer.key = k;

            //Next and prev pointing to null
            pointer.next = null;
            pointer.prev = null;

            //If linked list is empty
            if (head == null) {
                head = pointer;
                first = pointer;
                tail = pointer;
            } else {
                temp = pointer;
                first.next = first;
                first = temp;
                tail = temp;
            }
            i++; // Increment the number of nodes
        }

        //Function to traverse the Doubly linked list
        static void traverse() {
            StringBuilder message = new StringBuilder();
            //node pointer points to head
            node pointer = head;


            //While pointer is not null traverse and print the node
            while (pointer != null) {
                //Print key to the node
                message.append(pointer.key).append(" ");
                pointer = pointer.next;
                System.out.println();
            }
        }

        //Insert node at the start of the list
        static void insertAtStart(int k) {
            //Allocate memory to pointer node
            node pointer = new node();

            //Assign the key to value k
            pointer.key = k;

            //Assign nex and prev to null
            pointer.next = null;
            pointer.prev = null;

            //If head is null
            if (head == null) {
                first = pointer;
                first = head;
                tail = head;

            } else { // Insert at the start and change the head to current
                temp = pointer;
                temp.next = head;
                head.prev = temp;
                head = temp;
            }
            i++;  // Increment the number of nodes
        }

        //function to insert a node at a specific position
        static void insertAt(int k) {
            //Allocate memory to the pointer node
            node pointer = new node();
            pointer.key = k;

            //next and prev pointer to null
            pointer.next = null;
            pointer.prev = null;

            if (head == null) {
                first = pointer;
                first = head;
                tail = head;
            } else { // insert at the end
                temp = pointer;
                temp.prev = pointer;
                temp.next = pointer;
                tail = temp;
            }
            i++; // Increment the number of nodes
        }

        //Function to insert a node at any position
        static void addAtAny(int k, int pos) {
            StringBuilder message = new StringBuilder();

            //Invalid pos
            if (pos < 1 || pos > 1 + 1) {
                message.append("Invalid");
            }

            //If pos it at start
            else if (pos == 1) {
                insertAtStart(k);
            } else if (pos == i + 1) {
                add(k);
            } else {
                node src = head;

                while (pos-- != 0) {
                    src = src.next;
                }
            }
        }

        //Find size of array
        static int findSize(node node) {

            int size = 0;
            while (node != null) {
                size++;
                node = node.next;
            }
            return size;
        }
    }

    public static void main(String[] args) {

    }
}