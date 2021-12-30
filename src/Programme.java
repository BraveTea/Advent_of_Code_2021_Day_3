import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Programme {

    public static void main(String[] args) throws IOException {
        System.out.println("Initialising...");

        File diagnosticReport = new File("src/diagnosticReport.txt");
        DiagnosticFileInterpreter dfi = new DiagnosticFileInterpreter();

        Part2 p2 = new Part2();


        p2.runThisFucker();

//        String filename = "testFile";
//        File testFile = new File("src/"+filename+".txt");
//        testFile.createNewFile();
//        FileWriter myWriter = new FileWriter(testFile);
//        myWriter.write("Test");
//        myWriter.close();


//        p2.oxygenGeneratorRating(diagnosticReport);

        System.out.printf("---------------------------------------------------------%n%n");

//        dfi.fillBinaryString(diagnosticReport);
//        System.out.println(dfi.getBinaryString());
//        System.out.println(dfi.invertBinaryString(dfi.getBinaryString()));
//        System.out.println(dfi.returnIntegerDecimalFromBinaryString(dfi.getBinaryString()));
//        System.out.println(dfi.returnIntegerDecimalFromBinaryString(dfi.invertBinaryString(dfi.getBinaryString())));
//        System.out.println(1816*2279);

//        int gammaRate = dfi.returnIntegerDecimalFromBinaryString(dfi.getBinaryString());
//        int epsilonRate = dfi.returnIntegerDecimalFromBinaryString(dfi.invertBinaryString(dfi.getBinaryString()));
//        int puzzleSolution = gammaRate * epsilonRate;
//
//
//        System.out.println(puzzleSolution);
//

    }
}

/*
The binary code of the gamma rate is 011100011000 (inverted for epsilon)
 */