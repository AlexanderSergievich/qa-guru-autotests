package guru.qa.homework.javabasics.part1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {
        public static void main(String[] args) {
                byte byteValue = 126;
                byte byteValue1 = 0;
                short shortValue = -32678;
                int intValue = 250856820;
                long longValue = 891538975;
                float floatValue = 1.4546456f;
                double doubleValue = 22564256.34356345675632;
                char charValue = 0000;
                int summ = byteValue + shortValue;
                boolean moreThan = shortValue > floatValue; //false
                boolean lesThan = byteValue < doubleValue; //true
                boolean andOperator = moreThan && lesThan;
                int reminder = shortValue % byteValue;
                boolean orOperator = moreThan || !moreThan;

                //int over = 250856820 * intValue * 500 * intValue * intValue * intValue *5000000000;
                System.out.println(summ);
                System.out.println(moreThan);
                System.out.println(lesThan);
                System.out.println(andOperator);
                System.out.println(reminder);
                System.out.println(orOperator);
                //System.out.println(over);

        }
}
