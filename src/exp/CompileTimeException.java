package exp;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class CompileTimeException {
    public static void main(String[] args) throws IOException {
        checkAge(10);
        try {
            FileReader fileReader = new FileReader("myfile.txt");
        } catch (IOException e) {
            // Handle the exception here.
        } finally {

        }
    }

    // custom compile time exception
    public int checkFunds(int amount) throws InsufficientFundsException{
        if(amount < 0){
            throw new InsufficientFundsException("No balance");
        }
        return amount;
    }

    // custom runtime time exception
    public static void checkAge(int age) throws AgeNotValidException{
        try {
            // Check if the age is valid
            if (age < 0 || age > 120) {
                // Throw the exception
                throw new AgeNotValidException("Invalid age.");
            }
            // The age is valid, so do something with it
            System.out.println("Your age is " + age);
        } catch (AgeNotValidException e) {
            // Handle the exception
            System.out.println(e.getMessage());
        }
    }

    public void writeList() {
        PrintWriter out = null;

        try {
            System.out.println("Entering" + " try statement");

            out = new PrintWriter(new FileWriter("OutFile.txt"));
            for (int i = 0; i < 10; i++) {
                out.println("Value at: " + i);
            }
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Caught IndexOutOfBoundsException: "
                    +  e.getMessage());

        } catch (IOException | NullPointerException e) {
            System.err.println("Caught IOException: " +  e.getMessage());

        } finally {
            if (out != null) {
                System.out.println("Closing PrintWriter");
                out.close();
            }
            else {
                System.out.println("PrintWriter not open");
            }
        }
    }

    // https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html
    // The try-with-resources Statement
    public static void writeToFileZipFileContents(String zipFileName,
                                                  String outputFileName)
            throws java.io.IOException {

        java.nio.charset.Charset charset =
                java.nio.charset.StandardCharsets.US_ASCII;
        java.nio.file.Path outputFilePath =
                java.nio.file.Paths.get(outputFileName);

        // Open zip file and create output file with
        // try-with-resources statement

        try (
                java.util.zip.ZipFile zf =
                        new java.util.zip.ZipFile(zipFileName);
                java.io.BufferedWriter writer =
                        java.nio.file.Files.newBufferedWriter(outputFilePath, charset)
        ) {
            // Enumerate each entry
            for (java.util.Enumeration entries =
                 zf.entries(); entries.hasMoreElements();) {
                // Get the entry name and write it to the output file
                String newLine = System.getProperty("line.separator");
                String zipEntryName =
                        ((java.util.zip.ZipEntry)entries.nextElement()).getName() +
                                newLine;
                writer.write(zipEntryName, 0, zipEntryName.length());
            }
        }
    }

}

