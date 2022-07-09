import java.util.Arrays;

class Main {
    static Filing fileobj = new Filing();
    static Queue ob = new Queue();
    static Tree tree = new Tree();

    static Menu menuobj = new Menu();
    static Node HuffmanTable[], charNodes[], charNodesInitial[];

    static char charArray[], encodedCharacterArray[], readEncodedFile[];
    static String s, splitString[], decodedBinaryArray[], traversedLeaf[];
    static int decimalArray[], decodedDecimalArray[];


    public static void main(String[] args) {
        while (true) {
            menuobj.printMenu();
            int userChoice = menuobj.getUserChoice(91);

            switch (userChoice) {
                case 1:
                    System.out.println("File size is: ");
                    System.out.println(fileobj.fileSize("sample.txt") + "\n");
                    break;
                case 2:
                    System.out.println("Num of unique characters in file: " + fileobj.FindNumberOfUniqueCharacters(fileobj.readFile("sample.txt")));
                    System.out.println("Frequency of characters: ");
                    fileobj.findFrequency(fileobj.readFile("sample.txt"));
                    fileobj.displayFreq();
                    break;
                case 3:
                    ob.enqueue();
                    //tree insertion
                    while (!ob.isEmpty()) {
                        tree.insert();
                    }
                    tree.printTree(tree.root, "", true);
                    System.out.println();
                    break;
                case 4:
                    ob.queueDisplay();
                    System.out.println();
                    break;
                case 5:
                    HuffmanTable = tree.print();
                    System.out.println();
                    break;
                case 6:
                    charNodesInitial = fileobj.charArrayToNodes(fileobj.readFile("sample.txt"));
                    charNodes = fileobj.Encoding(charNodesInitial, HuffmanTable);
                    s = fileobj.concatenateCode(charNodes);
                    splitString = fileobj.splitString(s);
                    System.out.println("ENCODED STRING :");
                    System.out.println(Arrays.toString(splitString) + "\n");
                    decimalArray = fileobj.BinaryToDecimal(splitString);
                    System.out.println(Arrays.toString(decimalArray) + "\n");
                    encodedCharacterArray = fileobj.DecimalToCharacter(decimalArray);
                    System.out.println(Arrays.toString(encodedCharacterArray) + "\n");
                    break;
                case 7:
                    readEncodedFile = fileobj.readFile("encoded.txt").toCharArray();
                    decodedDecimalArray = fileobj.CharacterToDecimal(readEncodedFile);
                    System.out.println(Arrays.toString(decodedDecimalArray) + "\n");
                    //w/o additional zeros
                    decodedBinaryArray = fileobj.DecimalToBinary(decodedDecimalArray);
                    //after check length
                    decodedBinaryArray = fileobj.checkLengthofDecodedBinaryArray(decodedBinaryArray);
                    System.out.println(Arrays.toString(decodedBinaryArray) + "\n");
                    break;
                case 8:
                    traversedLeaf = tree.decodedTraversal(decodedBinaryArray);
                    System.out.println(Arrays.toString(traversedLeaf) + "\n");
                    break;
//                       String s = "";
//                       for(int i =0; i< traversedLeaf.length; i++)
//                          {
//                          s = s+traversedLeaf[i];
//                          }
//                          fileobj.createFile();
//                          fileobj.writeToFile(s);
                case 9:
                    System.out.println("Size of sample.txt");
                    System.out.println(fileobj.fileSize("sample.txt")+"\n");

                    System.out.println("Size of encoded.txt");
                    System.out.println(fileobj.fileSize("encoded.txt")+"\n");

                    System.out.println("Size of reconstructed.txt");
                    System.out.println(fileobj.fileSize("reconstructed.txt")+"\n");
                case 0:
                    System.exit(0);
            }
        }
    }
}