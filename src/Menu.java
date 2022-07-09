import java.util.Scanner;

public class Menu
{

    int numOfSectors, sizeOfSector, arraySize, fileSize;
    String fileName, fileData;  //variables for array functions

    Scanner sc = new Scanner(System.in);

    //------------------------------------------------------------------------------------------ //function to get size for 1d array

    public int 	getArraySize()
    {
        System.out.println("Enter number of sectors: ");
        numOfSectors = sc.nextInt();

        System.out.println("Enter number of characters that can be stored in one sector: ");
        sizeOfSector = sc.nextInt();

        arraySize = numOfSectors * sizeOfSector;

        return arraySize;
    }

    public int getarrSize()
    {
        return arraySize;
    }



    //-------------------------------------------------------------------------------------------------- //getter for sector size

    public int getSectorSize()
    {
        return sizeOfSector;
    }

    //----------------------------------------------------------------------------------------------------// getter for no of sectors
    public int getnumOfSectors()
    {
        return numOfSectors;
    }

    //-------------------------------------------------------------------------------------------------- //getter for file size

    public int getFileSize()
    {
        return fileData.length();
    }

    //-------------------------------------------------------------------------------------------------- //getter for file size

    public String getFileName()
    {
        return fileName;
    }

    //-------------------------------------------------------------------------------------------------- //getter for file size

    public String getFileData()
    {
        return fileData;
    }

    //-------------------------------------------------------------------------------------------------- //enter file data

    public void getFileInput()
    {
        System.out.println("Enter name of file: ");
        fileName = sc.next();
        System.out.println("file name is: "+fileName);
        System.out.println("enter data for file: ");
        fileData = sc.next();
        System.out.println("file data is: "+fileData);
    }

    //-------------------------------------------------------------------------------------------------- //returns needed sectors

    public int getSectorsNeeded()
    {
        double sectorNeeded = (double)getFileSize()/(double)getSectorSize(); //2.5
        int Requiredsectors = (int)(sectorNeeded); //2 (downcasted)
        double sectors = sectorNeeded - Requiredsectors;
        if(sectors == 0)
        {
            return Requiredsectors;
        }
        else
        {
            return Requiredsectors+1;
        }

    }

    //------------------------------------------------------------------------------------------------- //function to print UI

    public void printMenu()
    {
        System.out.println("_____________________________________________________________________");
        System.out.println("______________________________HUFFMAN________________________________");
        System.out.println("|___________________________________________________________________|");
        System.out.println("|1| Calculate File Size                                             |");
        System.out.println("|-------------------------------------------------------------------|");
        System.out.println("|2| Find Number of Unique Characters and their Frequency in the File|");
        System.out.println("|-------------------------------------------------------------------|");
        System.out.println("|3| Build Huffman Tree                                              |");  //enqueue and insert to tree
        System.out.println("|-------------------------------------------------------------------|");
        System.out.println("|4| Display Queue                                                   |");  //queue with single tree post huffman
        System.out.println("|-------------------------------------------------------------------|");
        System.out.println("|5| Build Huffman Table                                             |");
        System.out.println("|-------------------------------------------------------------------|");
        System.out.println("|6| Encoded String                                                  |"); //print split string, decimal and char array
        System.out.println("|-------------------------------------------------------------------|");
        System.out.println("|7| Decode String                                                   |"); //read encoded file, print deocded decimal & binary array including additional zeros
        System.out.println("|-------------------------------------------------------------------|");
        System.out.println("|8| Print Decoded String                                            |"); //prints traversed leaf array //decoded string already written to file while coding
        System.out.println("|-------------------------------------------------------------------|");
        System.out.println("|9| Print Size of All Three .txt Files (Bonus)                      |");
        System.out.println("|-------------------------------------------------------------------|");
        System.out.println("|0| Exit                                                            |");
        System.out.println("|___________________________________________________________________|");
    }


    //--------------------------------------------------------------------  //function to get user choice along with checking validity

    public int getUserChoice(int validChoices)
    {
        int userChoice;

        do
        {
            System.out.println("Enter your choice: ");
            userChoice = sc.nextInt();
        }
        while(userChoice <0 || userChoice >validChoices);

        return userChoice;
    }

    //-------------------------------------------------------------------------------------------------

}




