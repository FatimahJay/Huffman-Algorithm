public class Tree {
    Node root;

//    int [] freq = Main.fileobj.getFreq();
//    int size = freq.length;
     Node [] Huffmantable =new Node [Main.fileobj.readFile("sample.txt").length()];

    Tree()
    {
    }

//.......................................................................................................... INSERTION
    public void insert()
    {
            if (root == null)
            {
                Node newNode = new Node();
                Node n=Main.ob.deQueue();

                Node n2=Main.ob.deQueue();

                newNode.left =n;
                newNode.right = n2;
                newNode.freq = newNode.left.freq + newNode.right.freq;
                newNode.data = '*';

                root = newNode;
                Main.ob.addToQueue(root);
                //return root;
            }
            else
            {
            Node newNode = new Node();

                Node x=Main.ob.deQueue();

                Node y=Main.ob.deQueue();

                newNode.left =x;
                newNode.right = y;
                newNode.freq = newNode.left.freq + newNode.right.freq;
                newNode.data = '*';


                root = newNode;
                Main.ob.addToQueue(root);
            }
    }

//....................................................................................................... HUFFMAN TABLE

    Node[] print()
    {
        System.out.println("-----------------------");
        System.out.println("Character |  Code ");
        System.out.println("-----------------------");
     printCode(root,"");
     return Huffmantable;
    }

    public void printCode(Node root, String s)
    {
        if (root.left == null && root.right == null && (Character.isLetter(root.data) || (root.data == ' ') || (root.data == '!'))  )//if leaf node reached
        {
            root.binaryCode=s;  //assign the whole string (which will be the traversal path used to reach leaf node) to root ka binary code

            for(int i =0; i< Huffmantable.length; i++)
            {
                if(Huffmantable[i] == null)
                {
                    Huffmantable[i] = root;
                    break;
                }
            }

            System.out.println(root.data + "   |  " + s);
            return;
        }
        printCode(root.left, s + "0"); //traversal path is being added to string s, which is ""
        printCode(root.right, s + "1"); //traversal path is being added to string s, which is ""
    }

//.................................................................................. TRAVERSING FOR CHAR DURING DECODING (LAST PART OF ASSIGNMENT)

    String[] decodedTraversal(String binaryCodeArray [])
    {
        String [] traversdLeaf = decodeTraversal(root, binaryCodeArray); //returns root.data
        return traversdLeaf;
    }

    public String [] decodeTraversal(Node root, String binaryCodeArray [])//String s)
    {
        String [] traversedLeaf = new String[binaryCodeArray.length];

        Node temp = root;

        for (int i = 0; i < binaryCodeArray.length; i++)
        {
            String s=""; //will be used to concatenate decoded chars

            for (int j = 0; j < binaryCodeArray[i].length(); j++)
            {

                if (binaryCodeArray[i].charAt(j) == '0')
                {
                    root = root.left;
                    //move to left
                } else if (binaryCodeArray[i].charAt(j) == '1')
                {
                    root = root.right;
                    //move to right
                }

                if (root.left == null && root.right == null)
                {
                    s = s+root.data; //concatenation
                    traversedLeaf[i] = s; //leaf found

                    if(root.data == '!')
                    {
                      return traversedLeaf; //so doesnt print 'b' from last 00 code of last binary index
                    }

                    root = temp; //reset so searches again instead of traversing onward from the leaf node otherwise gives null

                }

            }
        }
        return traversedLeaf;
    }

//.......................................................................................................... PRINT TREE

    void printTree(Node currPtr, String indent, boolean last)
    {
        if (currPtr != null)
        {
            System.out.print(indent);
            if (last)
            {
                System.out.print("R----");
                indent += "   ";
            } else
            {
                System.out.print("L----");
                indent += "|  ";
            }
            System.out.println(currPtr.data);
            printTree(currPtr.left, indent, false);
            printTree(currPtr.right, indent, true);
        }
    }

}