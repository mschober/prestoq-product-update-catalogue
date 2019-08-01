package com.mschober.catalogue.data;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RawUpdateRecordTest {

    @Test
    public void testHappyCreateUpdateEvent() {
        String[] exampleProductUpdate = {"80000001", "Kimchi-flavored white rice", "00000567", "00000000", "00000000", "00000000", "00000000", "00000000", "NNNNNNNNN", "18oz"};

        UpdateRecord event = new RawUpdateRecord(exampleProductUpdate);
        assertEquals("80000001", event.getProductId());
    }

}