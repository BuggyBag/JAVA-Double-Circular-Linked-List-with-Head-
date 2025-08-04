public class DoubleCircularHeadLinkedList {
  private char info;
  private DoubleCircularHeadLinkedList right;
  private DoubleCircularHeadLinkedList left;

  //public default constructor until another constructor is made, then it becomes private.
  //public DoubleCircularHeadLinkedList(){}

  public DoubleCircularHeadLinkedList (){
    this.info = '\0';
    right = left = this;
  }

  public char getInfo(){ return info; }

  public DoubleCircularHeadLinkedList getRightLink(){ return right; }

  public DoubleCircularHeadLinkedList geLeftLink(){ return left; }

  public DoubleCircularHeadLinkedList insertBeginning (char value){

    DoubleCircularHeadLinkedList node = new DoubleCircularHeadLinkedList(), next = this.right;
    
    node.info = value;

    node.right = next;
    this.right = node;

    node.left = this;
    next.left = node;    
      
    return node;
  }

  DoubleCircularHeadLinkedList insertEnd (char value){

    DoubleCircularHeadLinkedList node = new DoubleCircularHeadLinkedList(), prev = this.left;

    node.info = value;
    
    node.left = prev;
    this.left = node;
    
    prev.right = node;
    node.right = this;

    return node;
  }

  public DoubleCircularHeadLinkedList find (char value) {

    //Initialize the node find with info
    DoubleCircularHeadLinkedList node = this.right;

    //While the node is not equal to the head and the info is not the value, keep going
    while (node != this) {

      //Check if it is the node
      if (node.info == value)
        return node;
      //Go to the next node
      node = node.right;
    }
    // The node with info is not in the list
    System.out.println("\n There is no node with " + value + "\n");
    return null;
  }

  DoubleCircularHeadLinkedList get(int position) {

    // precondition validation
    if (position < 1){
      System.out.println("\n The position is not in the list. \n");
      return null;
    }

    // Initialize the node search
    DoubleCircularHeadLinkedList node = this.right;

    for(int i = 1; i < position; i++) {
      // Check if there are more nodes

      if (node.right == this){
        System.out.println(" The position is not in the list. \n");
        return null;
      }

      // Go to the next node
      node = node.right;
    }

    // Return node at position P
    return node;
  }

  public void displayRight(){

    DoubleCircularHeadLinkedList node = this.right;

    while (node != this){
      System.out.println(node.info + " ");
      node = node.right;
    }

    System.out.println("\n");
  }
 
  public void displayLeft(){

    DoubleCircularHeadLinkedList node = this.left;

    while (node != this){
      System.out.println(node.info + " ");
      node = node.left;
    }

    System.out.println("\n");
  }

  public void delete (DoubleCircularHeadLinkedList e) throws Exception{

    //validate node to be deleted
    if (e == null){
      throw new Exception("Invalid node. \n");
    }

    //initialize the search of the node e
    DoubleCircularHeadLinkedList node = this, pred = node.left, next = node.right;

    do {
      //go to the next node
      node = node.right;
      pred = node.left;
      next = node.right;
    } while (node != this && node != e);

    // node was found?
    if (node == this)
      throw new Exception("Node not found");

    //delete node
    pred.right = e.right;
    next.left = e.left;

  }

}