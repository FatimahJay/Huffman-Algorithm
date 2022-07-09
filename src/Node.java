public class Node
{
    Node left, right;
    char data;
    int  freq;
String binaryCode;
    public Node(char data, int freq) //for leaf nodes
    {
     this.data = data;
     this.freq = freq;
     left = right =null;
    }

    public Node()
    {
        this.freq = freq;
        left = right =null;
    }

}

