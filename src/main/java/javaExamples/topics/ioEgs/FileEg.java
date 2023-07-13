package javaExamples.topics.ioEgs;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class FileEg {
    File readFile, writeFile;

    public static void main(String[] args) {

    }

    public void readFileNamesFromConsole() throws IOException {
        System.out.println("Enter the file to read");
        Reader consoleReader = new InputStreamReader(System.in);
        String fileName="";
        consoleReader.read();
    }

    public void readUsingInputStream() {

    }
}
