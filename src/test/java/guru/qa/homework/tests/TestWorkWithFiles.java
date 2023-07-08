package guru.qa.homework.tests;

import com.codeborne.pdftest.PDF;
import com.fasterxml.jackson.databind.ObjectMapper;
import guru.qa.homework.javabasics.workwithfiles.WorkWitFIles;
import guru.qa.homework.models.JohnModel;
import org.junit.jupiter.api.*;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestWorkWithFiles extends WorkWitFIles {
    private ClassLoader cl = TestWorkWithFiles.class.getClassLoader();
    @DisplayName("Тест метода архивации для одного файла")
    @Test
    public void chooseFileAndArchiveIt() throws Exception {
        createZipArchive(xlsx);
    }
    @Tag("Files")
    @DisplayName("Тест метода архивации для нескольких файлов")
    @Test
    public void chooseFilesAndArchiveIt() throws Exception {
        createZipArchiveMultipleFiles(pdf,xlsx,csv);
    }
    @Tag("Files")
    @DisplayName("Тест метода, который парсит pdf")
    @Test
    public void parsePdfFile() throws Exception{
        File pdfFile = new File("src/test/resources/policy_P2301001392.pdf");
        PDF pdf = new PDF(pdfFile);
        assertEquals("MEDICAL POLICY SCHEDULE\n" +
                "  Date:   04/05/2023 09:36\n" +
                "  Policy No:   P2301001392\n" +
                "  Policy Holder Name:   sdfsd safds\n" +
                "  Civil ID/Passport No:   11232312312\n" +
                "  Address:   PO Box ,\n" +
                "  Issue Date:   21/05/2023 00:00\n" +
                "  Duration:   From 21-MAY-2023 To 16-NOV-2023\n" +
                "  Plan:   Visitor - Emergency Only\n" +
                "  Area of Cover:   STATE OF QATAR ONLY\n" +
                "  Annual Limit:   150000\n" +
                "  Limit Currency:   QAR\n" +
                " Insured Member & Dependents  Relation  Civil ID/Passport No  DOB\n" +
                " Member ID\n" +
                " sdfsd safds  SELF  11232312312  17/01/1991  MEM2301008475\n" +
                "  Total Premium:   300\n" +
                "  Issued By:   Online\n", pdf.text);
    }
    @Tag("Files")
    @DisplayName("Тест метода, который парсит json")
    @Test
    void jsonParseTest() throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();

        try (
                InputStream resource = cl.getResourceAsStream("NamedJohn.json");
                InputStreamReader reader = new InputStreamReader(resource);
        ) {

            JohnModel johnModel = objectMapper.readValue(reader, JohnModel.class);

            assertEquals("John Doe", johnModel.getName());
            assertEquals(30, johnModel.getAge());
            assertEquals("123 Main St", johnModel.getAddress().getStreet());
            assertEquals("New York", johnModel.getAddress().getCity());
            assertEquals("johndoe@example.com", johnModel.getEmail());
            assertEquals("reading", johnModel.getHobbies().get(0));
            assertEquals("traveling", johnModel.getHobbies().get(1));
        }
    }
}
