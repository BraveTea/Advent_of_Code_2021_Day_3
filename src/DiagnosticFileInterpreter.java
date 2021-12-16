import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DiagnosticFileInterpreter {


    private final Scanner fileReader;
    private int zeroesCount = 0;
    private int onesCount = 0;
    private String binaryString = "";


    DiagnosticFileInterpreter(File file) throws FileNotFoundException {
        fileReader = new Scanner(file);
    }

    void testMethod() {
        System.out.println(fileReader.next());
    }

    void addBitToBinaryString(int bit){
        binaryString += bit;
    }

    //TODO why doesn't the for-loop work here. Why do the resets don't work?? Maybe because once opened and run
    // till the end with next it doesn't return to the start so it keeps the old calculations?

    void fillBinaryString() {
        for (int i = 0; i < 12; i++) {

            addBitToBinaryString(returnBit(i));
            System.out.println(zeroesCount);
            System.out.println(onesCount);
            resetCounts();


        }
    }


    int returnBit(int index){
        int bit;
        updateCountsPerBit(index);
        if (zeroesCount > onesCount) bit = 0;
        else bit = 1;
//        resetCounts(); //this shouldn't be here because returnBit should do 1 thing, not 2
        return bit;
    }

    void updateCountsPerBit(int index){
        resetCounts(); //I think this can be here. In order for the method to do its thing the counters must be reset.
        char bit;
        while (fileReader.hasNext()){
            bit = fileReader.next().charAt(index);
            switch (bit){
                case '0':
                    zeroesCount += 1;
                    break;
                case '1':
                    onesCount += 1;
                    break;
            }
        }

    }

    void resetCounts(){
        zeroesCount = 0;
        onesCount = 0;
    }

    public String getBinaryString() {
        return binaryString;
    }
}


    /*
    int onesCount = 0;
        int zeroesCount = 0;
        int loopCounter = 0;
        char firstBit;

        //I am quite sure that you can write a class which does all the work in one go
        //including building the binary code in an empty String and translating it to an actual number
        //Put the while loop in a for loop which increases the charAt(i) position
        //Don't forget to close the file in otherwise I don't think the while loop will keep working.

        while (fileReader.hasNext()) {
            firstBit = fileReader.next().charAt(0);
            switch (firstBit){
                case '0':
                    zeroesCount += 1;
                    break;
                case '1':
                    onesCount += 1;
            }
        }
        if (zeroesCount > onesCount){
            System.out.println("0");
        }
        else System.out.println("1");


        System.out.println(zeroesCount);
        System.out.println(onesCount);

     */



