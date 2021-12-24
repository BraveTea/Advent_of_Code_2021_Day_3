import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Programme {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Initialising...");

        File diagnosticReport = new File("src/diagnosticReport.txt");
        DiagnosticFileInterpreter dfi = new DiagnosticFileInterpreter();


        dfi.fillBinaryString(diagnosticReport);
//        System.out.println(dfi.getBinaryString());
//        System.out.println(dfi.invertBinaryString(dfi.getBinaryString()));
//        System.out.println(dfi.returnIntegerDecimalFromBinaryString(dfi.getBinaryString()));
//        System.out.println(dfi.returnIntegerDecimalFromBinaryString(dfi.invertBinaryString(dfi.getBinaryString())));
//        System.out.println(1816*2279);

        int gammaRate = dfi.returnIntegerDecimalFromBinaryString(dfi.getBinaryString());
        int epsilonRate = dfi.returnIntegerDecimalFromBinaryString(dfi.invertBinaryString(dfi.getBinaryString()));
        int puzzleSolution = gammaRate * epsilonRate;

        System.out.println(puzzleSolution);


    }
}
