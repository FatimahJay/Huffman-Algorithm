import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Filing {


//....................................................................................................... CREATE FILE

    public void createFile() {
        try {
            File myObj = new File("reconstructed.txt");
            if (myObj.createNewFile())  //createnewfile built in method: returns booleans for file creation
            {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

//........................................................................................................ WRITE TO FILE

    public void writeToFile(String s)
    {
        try {
            FileWriter myWriter = new FileWriter("reconstructed.txt");
            myWriter.write(s);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

//............................................................................................................READ FILE

    public String readFile(String fileName) {
        try {

            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                return data;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return "";
    }

//........................................................................................................... FILE SIZE

    public int fileSize(String filename) {
        File myObj = new File(filename);
        int filesize = Math.toIntExact(myObj.length()) * 7;
        return filesize;
    }

//......................................................................................... NUMBER OF UNIQUE CHARACTERS

    public int FindNumberOfUniqueCharacters(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        Set<Character> set = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            set.add(str.charAt(i));
        }

        return set.size();
    }

//...................................................................................... FREQUENCY OF UNIQUE CHARACTERS

    int[] freq;
    char [] data;
    public void findFrequency(String str)
    {
        freq = new int[str.length()];
        int i, j;

        //Converts given string into character array
        data= str.toCharArray();

        for (i = 0; i < str.length(); i++)
        {
            freq[i] = 1;
            for (j = i + 1; j < str.length(); j++)
            {
                if (data[i] == data[j])
                {
                    freq[i]++;
                    //Set string[j] to 0 to avoid printing visited character
                    data[j] = '0';
                }

            }

        }

    }

//................................................................................................... DISPLAY FREQUENCY
    void displayFreq()
    {
        System.out.println("CHARACTERS AND THEIR CORRESPONDING FREQUENCIES ARE DISPLAYED BELOW");
        for (int i = 0; i < freq.length; i++)
        {
            if (data[i] != '0')
            {
                System.out.println(data[i] + "-" + freq[i]);
            }
        }
    }

    int [] getFreq()
    {
        return freq;
    }

    char [] getData()
    {
     return data;
    }

//...............................................................................ENCODING...........CHAR ARRAY TO NODES

    Node [] charArrayToNodes(String FileData)
    {
      char [] charArray = FileData.toCharArray();
      Node charNodes [] = new Node[FileData.length()];

     for(int i =0; i<FileData.length(); i++)
     {
         Node newNode = new Node();
         newNode.data = charArray[i];
       charNodes[i] = newNode;
     }
     return charNodes;
    }

//............................................................................................................ ENCODING

    Node [] Encoding(Node [] charNodes, Node [] Huffmantable)
    {

         for(int i=0; i< charNodes.length ;i++)
         {
             for (int j = 0; j < Huffmantable.length; j++)
             {
                 if (charNodes[i].data == Huffmantable[j].data)
                 {
                     charNodes[i].binaryCode = Huffmantable[j].binaryCode;
                     break;
                 }
             }
         }
       return charNodes;
    }

//.......................................................................................ENCODING..... CONCATENATE CODE

    String concatenateCode(Node [] charNodes)
    {
        String s="";

     for(int i=0; i< charNodes.length; i++)
     {
                 s = s + charNodes[i].binaryCode;
     }
        return s;
    }

//........................................................................................ENCODING.........SPLIT STRING

    public String [] splitString(String s) //split string by whitespace
    {
        String splitArray[] = s.split("(?<=\\G.{" + 7 + "})");

        for(int i =0; i< splitArray.length; i++)
        {
         if(splitArray[i].length() < 7)
         {
          splitArray[i] = splitArray[i]+"00";
         }
        }
        return splitArray;
    }

    //...............................................................................ENCODING.........BINARY TO DECIMAL
    public int [] BinaryToDecimal(String splitArray [])
    {
        int [] decimalArray = new int[splitArray.length];

      for(int i=0; i<splitArray.length; i++)
         {
          int decimal = Integer.parseInt(splitArray[i], 2);
          decimalArray[i] = decimal;
         }
      return decimalArray;
    }

//.....................................................................................ENCODING.........DECIMAL TO CHAR

    public char [] DecimalToCharacter(int decimalArray [])
    {
        char [] encodedCharacterArray = new char[decimalArray.length];

        for(int i=0; i<decimalArray.length; i++)
        {
            char character = (char)decimalArray[i];
            encodedCharacterArray[i] = character;
        }
        return encodedCharacterArray;
    }

//.....................................................................................DECODING.........CHAR TO DECIMAL

    public int [] CharacterToDecimal(char readEncodedFile [])
    {
        int [] decodedDecimalArray = new int[readEncodedFile.length];

        for(int i=0; i<readEncodedFile.length; i++)
        {
            int decodedDecimal = (int)readEncodedFile[i];
            decodedDecimalArray[i] = decodedDecimal;
        }
        return decodedDecimalArray;
    }

//.....................................................................................DECODING.......DECIMAL TO BINARY

    public String [] DecimalToBinary (int decodedDecimalArray [])
    {
        String [] decodedBinaryArray = new String[decodedDecimalArray.length];

        for(int i=0; i<decodedDecimalArray.length; i++)
        {
            String decodedBinary = Integer.toBinaryString(decodedDecimalArray[i]);
            decodedBinaryArray[i] = decodedBinary;
        }
        return decodedBinaryArray;
    }

    //............................................................................DECODING.........ADD ADDITIONAL ZEROS
    public String [] checkLengthofDecodedBinaryArray(String [] decodedBinaryArray)
    {
        String s="";

     for(int i =0; i< decodedBinaryArray.length; i++)
        {
           int length = decodedBinaryArray[i].length();
            s="";
         if(length < 7)
           {
           for(int j=0; j< 7-length; j++) //total - actual = remaining length
           {
            s = s+"0";
           }
           s = s+decodedBinaryArray[i];
           decodedBinaryArray[i] =s;
           }
        }
     return decodedBinaryArray;
    }

}