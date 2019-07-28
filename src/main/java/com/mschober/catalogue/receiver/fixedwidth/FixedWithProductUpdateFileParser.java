package com.mschober.catalogue.receiver.fixedwidth;

import com.univocity.parsers.fixed.FixedWidthFields;
import com.univocity.parsers.fixed.FixedWidthParser;
import com.univocity.parsers.fixed.FixedWidthParserSettings;

import java.io.File;
import java.util.List;

public class FixedWithProductUpdateFileParser {
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

    public List<String[]> parse(File fileToParse) {
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

        return parser.parseAll(fileToParse);
    }
}
