/* DList.java */

package list;

/**
 *  A DList is a mutable doubly-linked list ADT.  Its implementation is
 *  circularly-linked and employs a sentinel (dummy) node at the head
 *  of the list.
 *
 *  DO NOT CHANGE ANY METHOD PROTOTYPES IN THIS FILE.
 */

public class DList {

  public static void main(String[] args) {
    System.out.println("*Create an empty list");
    DList a = new DList();
    System.out.println("Check if it is empty? "+ a.isEmpty());
    System.out.println("Check the size of list: " + a.length());
    System.out.println("Get the head address: " + a.head);    
    System.out.println("****************************************************");
    a.insertFront(3);
    System.out.println("*Insert 3 to the front");
    System.out.println("Check if it is empty? " + a.isEmpty());
    System.out.println("Check the size of list: " + a.length());
    System.out.println("Get the head address: " + a.head);
    System.out.println("Check head's prev item: " + a.head.prev.item);
    System.out.println("Check head's next item: " + a.head.next.item);
    a.insertFront(2);
    a.insertFront(1);
    System.out.println("****************************************************");
    System.out.println(a.head.next.item);
    System.out.println(a.head.next.next.item);
    System.out.println(a.head.next.next.next.item);
    System.out.println(a.head.next.next.next.next.item);
    System.out.println(a.head.next.next.next.next.next.item);
    System.out.println(a.head.prev.item);
    System.out.println(a.head.prev.prev.item);
    System.out.println(a.head.prev.prev.prev.item);
    System.out.println(a.head.prev.prev.prev.prev.item);
    System.out.println(a.head.prev.prev.prev.prev.prev.item);
    System.out.println("Size is: " + a.length());
    System.out.println("****************************************************");
    a.insertBack(4);
    a.insertBack(5);
    System.out.println(a.head.next.item);
    System.out.println(a.head.next.next.item);
    System.out.println(a.head.next.next.next.item);
    System.out.println(a.head.next.next.next.next.item);
    System.out.println(a.head.next.next.next.next.next.item);
    System.out.println(a.head.next.next.next.next.next.next.item);
    System.out.println(a.head.prev.item);
    System.out.println(a.head.prev.prev.item);
    System.out.println(a.head.prev.prev.prev.item);
    System.out.println(a.head.prev.prev.prev.prev.item);
    System.out.println(a.head.prev.prev.prev.prev.prev.item);
    System.out.println(a.head.prev.prev.prev.prev.prev.prev.item);
    System.out.println("Size is: " + a.length());
    System.out.println("****************************************************");
    a.insertBefore(0, a.head.next);
    System.out.println(a.toString());
    a.insertBefore(1.5, a.head.next.next.next);
    System.out.println(a.toString());
    a.insertAfter(6, a.head.prev);
    System.out.println(a.toString());
    a.insertAfter(4.5, a.head.prev.prev.prev);
    System.out.println(a.toString());
    a.remove(a.head.next);
    System.out.println(a.toString());
    a.remove(a.head.prev);
    System.out.println(a.toString());
    System.out.println("****************************************************");
    a.remove(a.head.prev);
    System.out.println(a.toString());
    a.remove(a.head.prev);
    System.out.println("Size is: " + a.length());
    System.out.println(a.toString());
    a.remove(a.head.prev.prev.prev);
    System.out.println("Size is: " + a.length());
    System.out.println(a.toString());
    DList b = new DList();
    b.insertBack(10);
    b.insertBack(11);
    b.insertBack(12);
    b.insertBack(13);
    b.insertBack(14);
    b.insertBack(15);
    System.out.println("Size is: " + b.length());
    System.out.println(b.toString());
    b.remove(b.head.next.next.next);
    System.out.println("Size is: " + b.length());
    System.out.println(b.toString());
    b.remove(b.head.next);
    System.out.println("Size is: " + b.length());
    System.out.println(b.toString());
    b.remove(b.head.prev);
    System.out.println("Size is: " + b.length());
    System.out.println(b.toString());
    System.out.println("****************************************************");
    LockDList c = new LockDList();
    c.insertBack(1);
    c.insertBack(2);
    c.insertBack(3);
    System.out.println(c.toString());
    c.lockNode(c.head.next.next);
    c.remove(c.head.next.next);
    System.out.println(c.toString());
    c.remove(c.head.next);
    System.out.println(c.toString());
    
}
    

  /**
   *  head references the sentinel node.
   *  size is the number of items in the list.  (The sentinel node does not
   *       store an item.)
   *
   *  DO NOT CHANGE THE FOLLOWING FIELD DECLARATIONS.
   */

  protected DListNode head;
  protected int size;

  /* DList invariants:
   *  1)  head != null.
   *  2)  For any DListNode x in a DList, x.next != null.
   *  3)  For any DListNode x in a DList, x.prev != null.
   *  4)  For any DListNode x in a DList, if x.next == y, then y.prev == x.
   *  5)  For any DListNode x in a DList, if x.prev == y, then y.next == x.
   *  6)  size is the number of DListNodes, NOT COUNTING the sentinel,
   *      that can be accessed from the sentinel (head) by a sequence of
   *      "next" references.
   */

  /**
   *  newNode() calls the DListNode constructor.  Use this class to allocate
   *  new DListNodes rather than calling the DListNode constructor directly.
   *  That way, only this method needs to be overridden if a subclass of DList
   *  wants to use a different kind of node.
   *  @param item the item to store in the node.
   *  @param prev the node previous to this node.
   *  @param next the node following this node.
   */
  protected DListNode newNode(Object item, DListNode prev, DListNode next) {
    return new DListNode(item, prev, next);
  }

  /**
   *  DList() constructor for an empty DList.
   */
  public DList() {
    head = newNode(null, this.head, this.head);
    size = 0;
    //  Your solution here.
  }

  /**
   *  isEmpty() returns true if this DList is empty, false otherwise.
   *  @return true if this DList is empty, false otherwise. 
   *  Performance:  runs in O(1) time.
   */
  public boolean isEmpty() {
    return size == 0;
  }

  /** 
   *  length() returns the length of this DList. 
   *  @return the length of this DList.
   *  Performance:  runs in O(1) time.
   */
  public int length() {
    return size;
  }

  /**
   *  insertFront() inserts an item at the front of this DList.
   *  @param item is the item to be inserted.
   *  Performance:  runs in O(1) time.
   */
  public void insertFront(Object item) {
    if (isEmpty()){
      DListNode frontNode = newNode(item, head, head);
      head.prev = frontNode;
      head.next = frontNode;
    } else {
      DListNode frontNode = newNode(item, head, front());
      front().prev = frontNode;
      head.next = frontNode;
    }
    size++;
    // Your solution here.
  }

  /**
   *  insertBack() inserts an item at the back of this DList.
   *  @param item is the item to be inserted.
   *  Performance:  runs in O(1) time.
   */
  public void insertBack(Object item) {
    if (isEmpty()){
      DListNode backNode = newNode(item, head, head);
      head.prev = backNode;
      head.next = backNode;
    } else {
      DListNode backNode = newNode(item, back(), head);
      back().next = backNode;
      head.prev = backNode;
    }
    size++;
    // Your solution here.
  }

  /**
   *  front() returns the node at the front of this DList.  If the DList is
   *  empty, return null.
   *
   *  Do NOT return the sentinel under any circumstances!
   *
   *  @return the node at the front of this DList.
   *  Performance:  runs in O(1) time.
   */
  public DListNode front() {
    if (isEmpty()){
      return null;
    } else {
      return next(head);
    }
    // Your solution here.
  }

  /**
   *  back() returns the node at the back of this DList.  If the DList is
   *  empty, return null.
   *
   *  Do NOT return the sentinel under any circumstances!
   *
   *  @return the node at the back of this DList.
   *  Performance:  runs in O(1) time.
   */
  public DListNode back() {
    if (isEmpty()){
      return null;
    } else {
      return prev(head);
    }
    // Your solution here.
  }

  /**
   *  next() returns the node following "node" in this DList.  If "node" is
   *  null, or "node" is the last node in this DList, return null.
   *
   *  Do NOT return the sentinel under any circumstances!
   *
   *  @param node the node whose successor is sought.
   *  @return the node following "node".
   *  Performance:  runs in O(1) time.
   */
  public DListNode next(DListNode node) {
    if (node == null || node.next == head){
      return null;
    } else {
      return node.next;
    }
    // Your solution here.
  }

  /**
   *  prev() returns the node prior to "node" in this DList.  If "node" is
   *  null, or "node" is the first node in this DList, return null.
   *
   *  Do NOT return the sentinel under any circumstances!
   *
   *  @param node the node whose predecessor is sought.
   *  @return the node prior to "node".
   *  Performance:  runs in O(1) time.
   */
  public DListNode prev(DListNode node) {
    if (node == null || node.prev == head){
      return null;
    } else {
      return node.prev;
    }
    // Your solution here.
  }

  /**
   *  insertAfter() inserts an item in this DList immediately following "node".
   *  If "node" is null, do nothing.
   *  @param item the item to be inserted.
   *  @param node the node to insert the item after.
   *  Performance:  runs in O(1) time.
   */
  public void insertAfter(Object item, DListNode node) {
    if (node == null){
      return;
    } else if (node == back()){
      insertBack(item);
      return;
    } else {
      DListNode afterNode = newNode(item, node, next(node));
      node.next = afterNode;
      next(node).prev = afterNode;
      size++;
      return;
    }
    // Your solution here.
  }

  /**
   *  insertBefore() inserts an item in this DList immediately before "node".
   *  If "node" is null, do nothing.
   *  @param item the item to be inserted.
   *  @param node the node to insert the item before.
   *  Performance:  runs in O(1) time.
   */
  public void insertBefore(Object item, DListNode node) {
    if (node == null){
      return;
    } else if (node == front()){
      insertFront(item);
      return;
    } else {
      DListNode beforeNode = newNode(item, prev(node), node);
      prev(node).next = beforeNode;
      node.prev = beforeNode;
      size++;
      return;
    }
    // Your solution here.
  }

  /**
   *  remove() removes "node" from this DList.  If "node" is null, do nothing.
   *  Performance:  runs in O(1) time.
   */
  public void remove(DListNode node) {
    if (node == null){
      return;
    } else if (node == front()){      //remove front
      next(node).prev = head;
      head.next = next(node);
      size--;
      return;
    } else if (node == back()){       //remove back
      prev(node).next = head;
      head.prev = prev(node);
      size--;
      return;
    } else {
      next(node).prev = prev(node);
      prev(node).next = next(node);
      size--;
      return;
    }        
    // Your solution here.
  }

  /**
   *  toString() returns a String representation of this DList.
   *
   *  DO NOT CHANGE THIS METHOD.
   *
   *  @return a String representation of this DList.
   *  Performance:  runs in O(n) time, where n is the length of the list.
   */
  public String toString() {
    String result = "[  ";
    DListNode current = head.next;
    while (current != head) {
      result = result + current.item + "  ";
      current = current.next;
    }
    return result + "]";
  }
}
