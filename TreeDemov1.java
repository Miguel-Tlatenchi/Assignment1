class Node{
	   int value;
	   Node left, right;
	   
	   public Node(int value){
	      this.value = value;
	      left = null;
	      right = null;
	   }

	}

	class BinarySearchTree{

	   Node root;
	  
	   
	   /*
	   recursive insert method
		
	   */
	   /*
	   inserts a node into the tree
	   */
	   public void insert(int value){
	      //tree is empty
	      if(root == null){
	         root = new Node(value);
	         return;
	      }else{
	         Node current = root;
	         Node parent = null;
	         
	         while(true){
	            parent = current;
	            
	            if(value < current.value){
	               current = current.left;
	               if(current == null){
	                  parent.left = new Node(value);
	                  return;
	               }
	            }else{
	               current = current.right;
	               if(current == null){
	                  parent.right = new Node(value);
	                  return;
	               }
	            }
	           
	         }//closing while
	      
	      }//closing main if-else 
	   }
	   
	   /*
	   pre-order traversal
	   Prints the value of every node preorder
	   */
	   public void preOrderTraversal(Node root){
		//implement in here
		   
	   }

	   
	   
	   /*
	   in-order traversal
	   */
	   public void inOrderTraversal(Node root){
	      //implement in here
	   }
	   
	   
	   
	   /*
	   a method to print post-order traversal
      @param root root of binary search tree
	   */
	  
	   public void postOrderTraversal(Node root){
         //recursively print post order
         if (root == null)
         {
            return;
         }
         
         postOrderTraversal(root.left);
         postOrderTraversal(root.right);
         System.out.println(root.value + ", ");
		   
	   }
	   
	   
	   
	   /*
	   a method to find the node in the tree
	   with a specific value
      @param root root of the binary search tree
      @param key key that will be searched for
      @return True if found and false if it isn't
	   */
	   public boolean find(Node root, int key){
		   //check if root is key
         if (root == null)
         {
            return false;
         }
         if (root.value == key)
         {
            return true;
         }
         
         //recursivly go through left subtree
         boolean left = find(root.left, key);
         
         //check if it was found
         if (left)
         {
            return true;
         }
         
         //go through right subtree
         boolean right = find(root.right,key);
         
         return right;
	   }
	   
	   
	   
	   /*
	   a method to find the node in the tree
	   with a smallest key
      @param root root of the binary search tree
      @return The min value in the binary search tree
	   */
	   public int getMin(Node root){
         //go to leftmost value in the binarysearch tree
         Node current = root;
         while (current.left != null)
         {
            current = current.left;
         }
	      
         return current.value;
	   }
	  
	  
	  
	   /*
	   a method to find the node in the tree
	   with a largest key
      @param root root of the binary search tree
      @return The max value in the binary search tree
	   */
	   public int getMax(Node root){
         //go to rightmost value on the tree
         Node current = root;
         while (current.right != null)
         {
            current = current.right;
         }
         
         return current.value;
	   }
	   
	   
	   
	   /*
	   this method will not compile until getMax
	   is implemented
	   */
	   public Node delete(Node root, int key){
	      
	      if(root == null){
	         return root;
	      }else if(key < root.value){
	         root.left = delete(root.left, key);
	      }else if(key > root.value){
	         root.right = delete(root.right, key);
	      }else{
	         //node has been found
	         if(root.left==null && root.right==null){
	            //case #1: leaf node
	            root = null;
	         }else if(root.right == null){
	            //case #2 : only left child
	            root = root.left;
	         }else if(root.left == null){
	            //case #2 : only right child
	            root = root.right;
	         }else{
	            //case #3 : 2 children
	            root.value = getMax(root.left);
	            root.left = delete(root.left, root.value);
	         }
	      }
	      return root;  
	   }
	   
	   
	   
	}



	public class TreeDemov1{
	   public static void main(String[] args){
	      BinarySearchTree t1  = new BinarySearchTree();
	      t1.insert( 24);
	      t1.insert(80);
	      t1.insert(18);
	      t1.insert(9);
	      t1.insert(90);
	      t1.insert(22);
	            
	      System.out.print("in-order :   ");
	      t1.inOrderTraversal(t1.root);
	      System.out.println();
	           
	      
	   }  
	}
