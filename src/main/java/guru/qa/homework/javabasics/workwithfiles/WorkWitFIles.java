package guru.qa.homework.javabasics.workwithfiles;

import java.io.*;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.zip.*;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
public class WorkWitFIles {

    public String pdf = new String("policy_P2301001392.pdf");
    public String xlsx = new String("report.xlsx");
    public String csv = new String("report_24-30_april.csv");
    public String json = new String("RehersalStudio.json");
    public String jsonChatGPT = new String("chatGPTJson.json");

    //Для архивации 1-го файла
    public void createZipArchive(String fileName) throws Exception {
        File file = new File(getClass().getResource("/" + fileName).getFile());
        File zipArchiveDir = new File("src/test/resources");
        File zipArchiveFile = new File(zipArchiveDir, "compressed.zip");
        FileOutputStream fos = new FileOutputStream(zipArchiveFile);
        ZipOutputStream zipOut = new ZipOutputStream(fos);
        ZipOutputStream zipReady = new ZipOutputStream(fos);
        FileInputStream zip = new FileInputStream(file);
        ZipEntry zipEntry = new ZipEntry(file.getName());
        zipOut.putNextEntry(zipEntry);

        byte[] bytes = new byte[1024];
        int length;
        while ((length = zip.read(bytes)) >= 0) {
            zipOut.write(bytes, 0, length);
        }
        zipOut.close();
        zip.close();
        fos.close();
    }
    //для архивации нескольких файлов:
    public void createZipArchiveMultipleFiles(String fileName, String fileName2, String fileName3) throws Exception {
        String file = fileName;
        String file2 = fileName2;
        String file3 = fileName3;
        final List<String> srcFiles = Arrays.asList(file, file2, file3);
        String zipArchiveDir = "compressed.zip";

        final FileOutputStream fos = new FileOutputStream(zipArchiveDir);
        ZipOutputStream zipOut = new ZipOutputStream(fos);

        for (String srcFile : srcFiles) {
            InputStream is = getClass().getClassLoader().getResourceAsStream(srcFile);
            ZipEntry zipEntry = new ZipEntry(srcFile);
            zipOut.putNextEntry(zipEntry);

            byte[] bytes = new byte[1024];
            int length;
            while((length = is.read(bytes)) >= 0) {
                zipOut.write(bytes, 0, length);
            }
            is.close();
        }

        zipOut.close();
        fos.close();
    }
    //парсит значения json по ключуб но не глубоко
    public String parseJson(String fileName) throws Exception {
        File jsonFile = new File(getClass().getResource("/" + fileName).getFile());
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(jsonFile);
        String content = jsonNode.get("name").asText();
        return content;
    }
}
