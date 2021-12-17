import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Programme {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Initialising...");

        File diagnosticReport = new File("src/diagnosticReport.txt");
        DiagnosticFileInterpreter dfi = new DiagnosticFileInterpreter();


        dfi.fillBinaryString(diagnosticReport);
        System.out.println(dfi.getBinaryString());

        // 011100011000   100011100111
        //     1816    *      2279      = 4138664
//        String binaryString = "";
//
//        for (int i = 0; i < 12; i++){
//            binaryString += dfi.returnBit(i);
//        }
//
//        System.out.println(binaryString);
    }
}
