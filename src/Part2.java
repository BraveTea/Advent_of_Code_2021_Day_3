import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Part2 {
//
//    BitCounter bcPos0 = new BitCounter();
//    BitCounter bcPos1 = new BitCounter();
//    BitCounter bcPos2 = new BitCounter();
//    BitCounter bcPos3 = new BitCounter();
//    BitCounter bcPos4 = new BitCounter();
//    BitCounter bcPos5 = new BitCounter();
//    BitCounter bcPos6 = new BitCounter();
//    BitCounter bcPos7 = new BitCounter();
//    BitCounter bcPos8 = new BitCounter();
//    BitCounter bcPos9 = new BitCounter();
//    BitCounter bcPos10 = new BitCounter();
//    BitCounter bcPos11 = new BitCounter();




    Part2() throws FileNotFoundException {
//
//        File co2ScrubberResults = new File("src/co2ScrubberResults.txt");
//        try {
//            if (co2ScrubberResults.createNewFile()) {
//                System.out.println("File created: " + co2ScrubberResults.getName());
//            } else {
//                System.out.println("File already exists.");
//            }
//
//        } catch (IOException e) {
//            System.out.println("An error occurred.");
//            e.printStackTrace();
//        }
    }

    public void runThisFucker(){
        System.out.println(mostCommonBitOnPosition(0));

        onlyKeepBitBinaries(0);

        MyUsefulFunctions func = new MyUsefulFunctions();

        int oxygenGeneratorRating = func.returnIntegerDecimalFromBinaryString("011111101111");
        int co2ScrubberRating = func.returnIntegerDecimalFromBinaryString("100011110000");
        int resultPart2 = oxygenGeneratorRating * co2ScrubberRating;
        System.out.println(resultPart2);


    }


    File diagnosticReport = new File("src/diagnosticReport.txt");
    DiagnosticFileInterpreter dfi = new DiagnosticFileInterpreter();
    ArrayList<String> dataList = read(diagnosticReport);


    public ArrayList<String> read(File file) throws FileNotFoundException {

        ArrayList<String> stringList = new ArrayList<>();
        Scanner fileScan = new Scanner(file);

        while (fileScan.hasNext()) {
            stringList.add(fileScan.next());
        }
        return stringList;
    }


    //All of this works. But used to run into issue on position 5 it runs into an issue. Probably the problem with count for 1/0s being equal
    public void onlyKeepBitBinaries(int position) {
        ArrayList<String> list1 = dataList;


        for (int j = 0; j < 12; j++) {
            ArrayList<String> list2 = new ArrayList<>();
            for (int i = 0; i < list1.size(); i++) {
                if (list1.get(i).charAt(j) == Character.forDigit(mostCommonBitOnPosition(j), 10) /*or actually mostCommonBitOnPosition*/) { //I know, terrible commenting form here
                    list2.add(list1.get(i));
                }
            }
            System.out.println(list2);
            list1.clear();
            list1.addAll(list2);
        }

    }



    private int mostCommonBitOnPosition(int position){
        BitCounter bitCounterOnes = new BitCounter();
        BitCounter bitCounterZeroes = new BitCounter();
        char bit;

        for (int i = 0; i < dataList.size(); i++){
            bit = dataList.get(i).charAt(position);
            if (bit == '1'){
                bitCounterOnes.increase();
            }
            if (bit == '0'){
                bitCounterZeroes.increase();
            }
        }

        if (bitCounterOnes.getCount() >= dataList.size()/2){
//            System.out.printf("dataList.size()/2 = %d %n", dataList.size()/2); // Testline
//            System.out.printf("The current ONES count = %d %n", bitCounterOnes.getCount()); // Testline
            return 1;
        }
        if (bitCounterZeroes.getCount() >= dataList.size()/2){
//            System.out.printf("dataList.size()/2 = %d %n", dataList.size()/2); // Testline
//            System.out.printf("The current ZEROES count = %d %n", bitCounterZeroes.getCount()); // Testline
            return 0;
        }
        if (bitCounterZeroes.getCount() == dataList.size()/2){
//            System.out.printf("dataList.size()/2 = %d %n", dataList.size()/2); // Testline
//            System.out.printf("The current ONES count = %d %n", bitCounterOnes.getCount()); // Testline
            return 1;
        }
        else {
            System.out.println("Problem");
            return 9;
        }
    }

//    public String oxygenGeneratorRating(File initialFile) throws IOException {
//
//
////        String oxygenGeneratorRating;
//        String filename = "testFile";
//        File testFile = new File("src/"+filename+".txt");
//        testFile.createNewFile();
//        FileWriter myWriter = new FileWriter(testFile);
//        Scanner fileScanner = new Scanner(initialFile);
//
//        while (fileScanner.hasNext()){
//            myWriter.write(fileScanner.next());
//            myWriter.write(String.format("%n")); //My solution
////            myWriter.write(System.getProperty( "line.separator" )); //Stackoverflow solution
//        }
//        myWriter.close();
//
//        for (int i = 0; i < 12; i++){
//            String fileName = "testFile"+ i + ".txt";
//            File someFile = new File("src/" + fileName);
//            someFile.createNewFile();
//            FileWriter myWriter = new FileWriter(someFile);
//
//        }
//
//
//
////        for (int i = 0; i < 12; i++){
////            if (i == 0){
////                BitCounter bc = new BitCounter();
////                Scanner fileScanner = new Scanner(initialFile);
////                int mostCommonBit = mostCommonBitOnPosition(bc, initialFile, i);
////                File oxygenGeneratorResults = new File("src/oxygenGeneratorResults.txt");
////
////                FileWriter myWriter = new FileWriter(oxygenGeneratorResults);
////                oxygenGeneratorResults.createNewFile();
////
////                while (fileScanner.hasNext()){
////                    if (mostCommonBit == 1 || mostCommonBit == 2){
////                        char bit = fileScanner.next().charAt(i);
////                        if (bit == '1'){
////                            myWriter.write(fileScanner.next());
////
////                        }
////
////                    }
////                }
////            myWriter.close();}
////        }
//
//
//        return "Success?";
//    }



//
//    public int mostCommonBitOnPosition(BitCounter bitCounter, File file, int position) throws FileNotFoundException {
//        FileSizeInLines fileSize = new FileSizeInLines(file);
//        int numberOfLines = fileSize.getFileSize();
//
//        Scanner fileScanner = new Scanner(file);
//        char bit;
//
//        while (fileScanner.hasNext()) {
//            bit = fileScanner.next().charAt(position);
//            if (bit == '1') {
//                bitCounter.increase();
//            }
//        }
//
//        if (fileSize.getFileSize() / 2 < bitCounter.getCount()) {
//            return 1;
//        }
//        if (fileSize.getFileSize() / 2 > bitCounter.getCount()) {
//            return 0;
//        }
//        //This is the exception. I was thinking of throwing an exception, but I need some sort of return to check
//        //Plus I have a very poor understanding of Exceptions and stuff.
//        if (fileSize.getFileSize() / 2 == bitCounter.getCount()) {
//            return 2;
//        }
//        else{
//            return 9;
//        }
//    }



}
