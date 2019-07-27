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

    public static final int PRODUCT_ID = 8;
    public static final int PRODUCT_DESCRIPTION = 59;
    public static final int REGULAR_SINGULAR_PRICE = 8;
    public static final int PROMOTIONAL_SINGULAR_PRICE = 8;
    public static final int REGULAR_SPLIT_PRICE = 8;
    public static final int PROMOTIONAL_SPLIT_PRICE = 8;
    public static final int REGULAR_FOR_X = 8;
    public static final int PROMOTIONAL_FOR_X = 8;
    public static final int FLAGS = 9;
    public static final int PRODUCT_SIZE = 9;
    public static final int WIDTH = 1;

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

        FixedWidthFields fields = new FixedWidthFields(
                PRODUCT_ID + WIDTH,
                PRODUCT_DESCRIPTION + WIDTH,
                REGULAR_SINGULAR_PRICE + WIDTH,
                PROMOTIONAL_SINGULAR_PRICE + WIDTH,
                REGULAR_SPLIT_PRICE + WIDTH,
                PROMOTIONAL_SPLIT_PRICE + WIDTH,
                REGULAR_FOR_X + WIDTH,
                PROMOTIONAL_FOR_X + WIDTH,
                FLAGS + WIDTH,
                PRODUCT_SIZE);

        FixedWidthParserSettings settings = new FixedWidthParserSettings(fields); // many settings here, check the tutorial.
        settings.getFormat().setLineSeparator("\n");
        settings.setRecordEndsOnNewline(true);
//        settings.getFormat().setPadding(' ');
//        RowListProcessor rowProcessor = new RowListProcessor();
//        settings.setProcessor(rowProcessor);
        FixedWidthParser parser = new FixedWidthParser(settings);

        List<String[]> allRows = parser.parseAll(testFile);
        for (String[] s : allRows) {
            System.out.println("row is: " + Arrays.toString(s));
        }

    }
}
