package com.mschober.catalogue.data;

import java.math.BigInteger;

public interface UpdateRecord extends ProductEvent {
    String getProductId();

    String getProductDescription();

//    http://www.javapractices.com/topic/TopicAction.do?Id=13
    BigInteger getRegularSingularPrice();

    BigInteger getPromotionalSingularPrice();

    BigInteger getRegularSplitPrice();

    BigInteger getPromotionalSplitPrice();

    BigInteger getRegularForX();

    BigInteger getPromotionalForX();

    String getFlags();

    String getProductSize();
}
