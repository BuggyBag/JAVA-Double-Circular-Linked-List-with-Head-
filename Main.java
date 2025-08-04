class Main {
  public static void main(String[] args) throws Exception {

    System.out.println("\n\n\t Double Linked List \n");

    DoubleCircularHeadLinkedList list = new DoubleCircularHeadLinkedList();

    //insert in the list at the beginning
    //it is possible to: DoubleCircularHeadLinkedList list_2 = list.insert(char);
    
    list.insertBeginning('e');
    list.insertBeginning('f');
    list.insertBeginning('g');

    //insert in the list at the end
    
    list.insertEnd('v');
    list.insertEnd('h');
    list.insertEnd('l');

    //display list in both directions to make sure the double link is working.
    System.out.println("List in forward direction: ");
    list.displayRight();
    System.out.println("List in backward direction: ");
    list.displayLeft();

    DoubleCircularHeadLinkedList c_node;

// Testing FIND method

    //search in the list
    c_node = list.find('h');
    if (c_node != list)
      System.out.println("Search for h: " + c_node.getInfo() + "\n");


// Testing GET method

    //access the list
    c_node = list.get(3);
    System.out.println("Third node in list: " + c_node.getInfo() + "\n");

    c_node = list.get(7);
    if (c_node != null)
      System.out.println("Seventh node in list: " + c_node.getInfo() + "\n");

    c_node = list.get(-10);
    if (c_node != null)
      System.out.println("Node in list: " + c_node.getInfo() + "\n");


// Testing delete method

    list.delete(list.get(3)); //deletes the mid value
    System.out.println("After deleting the mid value: ");
    list.displayRight();
    
    list.delete(list.get(5)); //deletes last value
    System.out.println("After deleting the last value: ");
    list.displayRight();
    
    list.delete(list.get(1)); //deletes first value
    System.out.println("After deleting the first value: ");
    list.displayRight();

    list.delete(list.find('a')); //tries to delete a non existing node
    
  }
}
