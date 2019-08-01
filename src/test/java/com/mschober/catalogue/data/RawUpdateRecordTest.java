package com.mschober.catalogue.data;

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;

public class RawUpdateRecordTest {

    @Test
    public void testHappyCreateUpdateEvent() {
        String[] exampleProductUpdate = {"80000001", "Kimchi-flavored white rice", "00000567", "00000000", "00000000", "00000000", "00000000", "00000000", "NNNNNNNNN", "18oz"};

        UpdateRecord event = new RawUpdateRecord(exampleProductUpdate);
        assertEquals("80000001", event.getProductId());
        assertEquals("Kimchi-flavored white rice", event.getProductDescription());
        assertEquals(new BigInteger("00000567"), event.getRegularSingularPrice());
        assertEquals(new BigInteger("0"), event.getPromotionalSingularPrice());
        assertEquals(new BigInteger("0"), event.getRegularSplitPrice());
        assertEquals(new BigInteger("0"), event.getPromotionalSplitPrice());
        assertEquals(new BigInteger("0"), event.getRegularForX());
        assertEquals(new BigInteger("0"), event.getPromotionalForX());
        assertEquals("NNNNNNNNN", event.getFlags());
        assertEquals("18oz", event.getProductSize());

    }

    @Test
    public void testOtherValues() {
        String[] exampleProductUpdate = {"900420001", "Some wild and crazy thing", "29", "32", "45", "100", "66", "99", "YYNNNYNNN", "6lbs"};
        UpdateRecord event = new RawUpdateRecord(exampleProductUpdate);
        assertEquals("900420001", event.getProductId());
        assertEquals("Some wild and crazy thing", event.getProductDescription());
        assertEquals(new BigInteger("29"), event.getRegularSingularPrice());
        assertEquals(new BigInteger("32"), event.getPromotionalSingularPrice());
        assertEquals(new BigInteger("45"), event.getRegularSplitPrice());
        assertEquals(new BigInteger("100"), event.getPromotionalSplitPrice());
        assertEquals(new BigInteger("66"), event.getRegularForX());
        assertEquals(new BigInteger("99"), event.getPromotionalForX());
        assertEquals("YYNNNYNNN", event.getFlags());
        assertEquals("6lbs", event.getProductSize());
    }

}