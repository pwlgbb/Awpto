package main.java.test;

import main.java.bignumbers.BigNumber;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Copyright (C) Coderion sp. z o.o
 */
public class BigNumberTest extends Assert{

    private BigNumber bigNumber;
    private BigNumber bigNumber2;

    @Before
    public void setUp() throws Exception {
        bigNumber = new BigNumber("300");
        bigNumber2 = new BigNumber("400");
    }

    @Test
    public void addTest_TC01() {
        bigNumber = new BigNumber("300");
        bigNumber2 = new BigNumber("400");

        assertEquals(bigNumber.add(bigNumber2).getValue(), new BigNumber("700").getValue());
    }

    @Test
    public void addTest_TC02() {
        bigNumber = new BigNumber("700");
        bigNumber2 = new BigNumber("700");

        assertEquals(this.bigNumber.add(bigNumber2).getValue().substring(0, 6), "004100");
    }

}
