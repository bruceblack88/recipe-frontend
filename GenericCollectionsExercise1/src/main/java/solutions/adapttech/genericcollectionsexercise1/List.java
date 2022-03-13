/*
Bruce Black
CSIS 505
Software Development
GENERIC COLLECTIONS, LAMBDAS, AND STREAMS ASSIGNMENT 
July 4, 2021
 */
package solutions.adapttech.genericcollectionsexercise1;

// class List definition
public class List<T> {

    private ListNode<T> firstNode;

    private ListNode<T> lastNode;

    private String name; // string like "list" used in printing

    //constructor creates empty List with "list" as the name
    public List() {

        this("list");

    }

    //constructor creates an empty List with a name
    public List(String listName) {

        name = listName;

        firstNode = lastNode = null;

    }

    //insert item at front of List
    public void insertAtFront(T insertItem) {

        if (isEmpty()) // firstNode and lastNode refer to same object
        {
            firstNode = lastNode = new ListNode<T>(insertItem);
        } else // firstNode refers to new node
        {
            firstNode = new ListNode<T>(insertItem, firstNode);
        }

    }

    //insert item at end of List
    public void insertAtBack(T insertItem) {

        if (isEmpty()) // firstNode and lastNode refer to same object
        {
            firstNode = lastNode = new ListNode<T>(insertItem);
        } else // lastNode's nextNode refers to new node
        {
            lastNode = lastNode.nextNode = new ListNode<T>(insertItem);
        }

    }

    //remove first node from List
    public T removeFromFront() throws EmptyListException {

        if (isEmpty()) // throw exception if List is empty
        {
            throw new EmptyListException(name);
        }

        T removedItem = firstNode.data; // retrieve data being removed

        //update references firstNode and lastNode
        if (firstNode == lastNode) {
            firstNode = lastNode = null;
        } else {
            firstNode = firstNode.nextNode;
        }

        return removedItem; // return removed node data

    } // end method removeFromFront

    //remove last node from List
    public T removeFromBack() throws EmptyListException {

        if (isEmpty()) // throw exception if List is empty
        {
            throw new EmptyListException(name);
        }

        T removedItem = lastNode.data; // retrieve data being removed

        //update references firstNode and lastNode
        if (firstNode == lastNode) {
            firstNode = lastNode = null;
        } else // locate new last node
        {

            ListNode<T> current = firstNode;

            //loop while current node does not refer to lastNode
            while (current.nextNode != lastNode) {
                current = current.nextNode;
            }

            lastNode = current; // current is new lastNode

            current.nextNode = null;

        }

        return removedItem; // return removed node data

    }

    //determine whether list is empty
    public boolean isEmpty() {

        return firstNode == null; // return true if list is empty

    }

    //output list contents
    public void print() {

        if (isEmpty()) {

            System.out.printf("Empty %s%n", name);

            return;

        }

        System.out.printf("The %s is: ", name);

        ListNode<T> current = firstNode;

        //while not at end of list, output current node's data
        while (current != null) {

            System.out.printf("%s ", current.data);

            current = current.nextNode;

        }

        System.out.println();

    }

    public ListNode<T> searchRecursiveBlack(T item) {

        return searchRecursiveUtilBlack(firstNode, item);

    }

    private ListNode<T> searchRecursiveUtilBlack(ListNode<T> node, T item) {

        if (node == null) {
            return null;
        }

        if (node.data == item) {
            return node;
        }

        return searchRecursiveUtilBlack(node.nextNode, item);

    }

} // end class List<T>
