package com.mschober.catalogue.data;

import org.junit.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

public class ProcessProductUpdateEventTest {

    @Test
    public void testHoldMultipleRecords() {
        List<String[]> expectedRows = new ArrayList<>(4);
        expectedRows.add(new String [] {"80000001", "Kimchi-flavored white rice", "00000567", "00000000", "00000000", "00000000", "00000000", "00000000", "NNNNNNNNN", "18oz"});
        expectedRows.add(new String [] {"14963801", "Generic Soda 12-pack",       "00000000", "00000549", "00001300", "00000000", "00000002", "00000000", "NNNNYNNNN", "12x12oz"});
        ProcessProductUpdateEvent processProductUpdateEvent = new ProcessProductUpdateEvent(expectedRows);

        UpdateRecord secondRow = processProductUpdateEvent.get(1);

        assertEquals(secondRow.getProductDescription(), "Generic Soda 12-pack");
        assertEquals(secondRow.getPromotionalSingularPrice(), new BigInteger("00000549"));

    }

}