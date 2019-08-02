package com.mschober.catalogue.updater;

import com.mschober.catalogue.data.event.record.SaveRecord;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class FlagUpdateRuleTests {

    @Test
    public void testUpdatesUnitOfMeasure() {
        UpdateRule unitOfM = new UnitOfMeasureRule();
        SaveRecord mock = mock(SaveRecord.class);
        when(mock.getFlags()).thenReturn("NNYNNNNNN");
        unitOfM.applyRule(mock);
        verify(mock, times(1)).setUnitOfMeasure("Pound");
    }

    @Test
    public void testDoesNotUpdateUnitOfMeasure() {
        UpdateRule unitOfM = new UnitOfMeasureRule();
        SaveRecord mock = mock(SaveRecord.class);
        when(mock.getFlags()).thenReturn("NNNNNNNNN");
        unitOfM.applyRule(mock);
        verify(mock, times(0)).setUnitOfMeasure("Pound");
    }

    @Test
    public void testUpdatesTaxRate() {
        UpdateRule taxRule = new TaxRateRule();
        SaveRecord mock = mock(SaveRecord.class);
        when(mock.getFlags()).thenReturn("NNNNYNNNN");
        taxRule.applyRule(mock);
        verify(mock, times(1)).setTaxRate(.07775);
    }

    @Test
    public void testDoesNotUpdateTaxRate() {
        UpdateRule taxRule = new TaxRateRule();
        SaveRecord mock = mock(SaveRecord.class);
        when(mock.getFlags()).thenReturn("NNNNNNNNN");
        taxRule.applyRule(mock);
        verify(mock, times(0)).setTaxRate(.03);
    }

}