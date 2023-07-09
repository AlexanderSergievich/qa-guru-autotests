package guru.qa.homework.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import guru.qa.homework.models.JohnModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonParseTest {
    private ClassLoader cl = TestWorkWithFiles.class.getClassLoader();

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
