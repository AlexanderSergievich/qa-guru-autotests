package guru.qa.homework.tests;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import guru.qa.homework.javabasics.workwithfiles.WorkWitFIles;
import org.junit.jupiter.api.*;

import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class TestWorkWithFiles extends WorkWitFIles {
    private ClassLoader cl = TestWorkWithFiles.class.getClassLoader();
    private ClassLoader classLoader = WorkWitFIles.class.getClassLoader();
    private static final String FILE_XLSX = "minutes";
    private static final String FILE_PDF = "MEDICAL POLICY SCHEDULE";
    private static final String[][] FILE_CSV = new String[][]{
            {"date", "project", "task", "minutes", "startTime", "endTime"},
            {"20230424", "No Project", "свои задачи", "50", "10:21", "11:11"}};

    @Tag("Files")
    @DisplayName("Тест метода, который парсит pdf")
    @Test
    public void parsePdfFile() throws Exception {
        try (InputStream is = classLoader.getResourceAsStream("Archive.zip")) {
            ZipInputStream zis = new ZipInputStream(is);
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().contains("pdf") && !entry.getName().contains("MACOSX")) {
                    PDF pdf = new PDF(zis);
                    Assertions.assertTrue(pdf.text.contains(FILE_PDF));
                }
            }
        }
    }

    @Tag("Files")
    @DisplayName("Тест метода, который парсит xls")
    @Test
    void XlsParseTest() throws Exception {

        try (InputStream is = classLoader.getResourceAsStream("Archive.zip")) {
            ZipInputStream zis = new ZipInputStream(is);
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().contains("xlsx") && !entry.getName().contains("MACOSX")) {
                    XLS xls = new XLS(zis);
                    Assertions.assertEquals(FILE_XLSX,
                            xls.excel.getSheetAt(0)
                                    .getRow(0)
                                    .getCell(3)
                                    .getStringCellValue());
                }
            }
        }
    }

    @Tag("Files")
    @DisplayName("Тест метода, который парсит csv")
    @Test
    void CsvParseTest() throws Exception {
        try (InputStream is = classLoader.getResourceAsStream("Archive.zip")) {
            ZipInputStream zis = new ZipInputStream(is);
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().contains("csv") && !entry.getName().contains("MACOSX")) {
                    CSVReader csvReader = new CSVReader(new InputStreamReader(zis));
                    List<String[]> csv = csvReader.readAll();
                    Assertions.assertArrayEquals(FILE_CSV[1], csv.get(1));
                }
            }
        }
    }
}
