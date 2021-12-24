import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DiagnosticFileInterpreter {


    private Scanner fileReader;
    private int zeroesCount = 0;
    private int onesCount = 0;
    private String binaryString = "";


    DiagnosticFileInterpreter()  {
    }


    void addBitToBinaryString(int bit){
        binaryString += bit;
    }


    void fillBinaryString(File file) throws FileNotFoundException {
        for (int i = 0; i < 12; i++) {
            fileReader = new Scanner(file);
            addBitToBinaryString(returnBit(i));
//            System.out.println(zeroesCount);  //Test line
//            System.out.println(onesCount);    //Test line
            fileReader.close();

        }
    }

    String invertBinaryString(String binString){
        StringBuilder invertedBinaryString = new StringBuilder(); //used to concat in the if/else, IDEA started to grumble
        for (int i = 0; i < binString.length(); i++){
            if (binString.charAt(i) == '1'){
                invertedBinaryString.append('0');
            }
            else invertedBinaryString.append('1');
        }
        return invertedBinaryString.toString();
    }

    int returnIntegerDecimalFromBinaryString(String binString){
        return Integer.parseInt(binString, 2);
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


    public void resetCounts(){
        zeroesCount = 0;
        onesCount = 0;
    }

    public String getBinaryString() {
        return binaryString;
    }
}