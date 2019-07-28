package com.mschober.catalogue.receiver.fixedwidth;

import com.google.common.io.Files;
import com.univocity.parsers.common.processor.RowListProcessor;
import org.junit.Test;
import com.univocity.parsers.fixed.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class TestFixedWithProductReader {

    @Test
    public void testReadFile() throws IOException {
        File tempDir = Files.createTempDir();
                        // productId productDescription                                         RegSingP PromoP   RegSplP  PromoSP  RegForX  PromoFX  Flags     ProductSize
        String testData = "80000001 Kimchi-flavored white rice                                  00000567 00000000 00000000 00000000 00000000 00000000 NNNNNNNNN      18oz\n" +
                          "14963801 Generic Soda 12-pack                                        00000000 00000549 00001300 00000000 00000002 00000000 NNNNYNNNN   12x12oz\n" +
                          "40123401 Marlboro Cigarettes                                         00001000 00000549 00000000 00000000 00000000 00000000 YNNNNNNNN          \n" +
                          "50133333 Fuji Apples (Organic)                                       00000349 00000000 00000000 00000000 00000000 00000000 NNYNNNNNN        lb";


        Path testPath = Paths.get(tempDir.getAbsolutePath() + "/testfile");
        byte[] bytes = testData.getBytes();
        File testFile = new File(String.valueOf(testPath));
        Files.write(bytes, testFile);

        FixedWithProductUpdateFileParser fixedWithProductUpdateFileParser = new FixedWithProductUpdateFileParser();

        List<String[]> allRows = fixedWithProductUpdateFileParser.parse(testFile);
        List<String[]> expectedRows = new ArrayList<>(4);
        expectedRows.add(new String [] {"80000001", "Kimchi-flavored white rice", "00000567", "00000000", "00000000", "00000000", "00000000", "00000000", "NNNNNNNNN", "18oz"});
        expectedRows.add(new String [] {"14963801", "Generic Soda 12-pack",       "00000000", "00000549", "00001300", "00000000", "00000002", "00000000", "NNNNYNNNN", "12x12oz"});
        expectedRows.add(new String [] {"40123401", "Marlboro Cigarettes",        "00001000", "00000549", "00000000", "00000000", "00000000", "00000000", "YNNNNNNNN", null});
        expectedRows.add(new String [] {"50133333", "Fuji Apples (Organic)",      "00000349", "00000000", "00000000", "00000000", "00000000", "00000000", "NNYNNNNNN", "lb"});
        for (int i = 0; i < allRows.size(); i++) {
            System.out.println("row is: " + Arrays.toString(allRows.get(i)));
            assertEquals(Arrays.toString(allRows.get(i)), Arrays.toString(expectedRows.get(i)));
        }
    }
}
