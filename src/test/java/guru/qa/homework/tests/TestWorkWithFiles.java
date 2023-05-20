package guru.qa.homework.tests;

import com.codeborne.pdftest.PDF;
import guru.qa.homework.javabasics.workwithfiles.WorkWitFIles;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestWorkWithFiles extends WorkWitFIles {
    @DisplayName("Тест метода архивации для одного файла")
    @Test
    public void chooseFileAndArchiveIt() throws Exception {
        createZipArchive(xlsx);
    }
    @DisplayName("Тест метода архивации для нескольких файлов")
    @Test
    public void chooseFilesAndArchiveIt() throws Exception {
        createZipArchiveMultipleFiles(pdf,xlsx,csv);
    }

    @DisplayName("Тест метода, который парсит pdf")
    @Test
    public void parsePdfFile() throws Exception{
        File pdfFile = new File("src/test/resources/policy_P2301001392.pdf");
        PDF pdf = new PDF(pdfFile);
        System.out.println();
        assertEquals("", pdf.text);
    }

    @Test
    public void parseJsonFileTest() throws Exception {
        String result = parseJson(json);
        assertEquals("Mikhail Smirnov", result);
    }
    //метод, который позволяет выводить в Junit сообщение из вызываемого им метода
    @Test
    public void parseJsonArrayTest(TestInfo testInfo) {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        // Redirect System.out to the ByteArrayOutputStream
        System.setOut(new PrintStream(outContent));
        // Call the method that produces the System.out message
        parseJsonArray(json);
        // Restore the original System.out
        System.setOut(System.out);
        assertEquals("Expected output message", outContent.toString().trim());
    }
}
