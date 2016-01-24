package test.java.bignumbers;

import main.java.bignumbers.BigNumber;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Map;

/**
 * Copyright (C) Coderion sp. z o.o
 */
public class BigNumberTest extends Assert{

    private BigNumber bigNumber;
    private BigNumber bigNumber2;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void rangeTest_TC01() {
        bigNumber = new BigNumber("700");

        assertEquals(192, bigNumber.getDigitsLength());
    }

    @Test
    public void rangeTest_TC02() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= 20; i++) {
            stringBuilder.append("1234567890");
        }
        bigNumber = new BigNumber(stringBuilder.toString());

        assertEquals(192, bigNumber.getDigitsLength());
    }

    @Test
    public void addTest_TC01() {
        bigNumber = new BigNumber("300");
        bigNumber2 = new BigNumber("400");

        assertEquals("700", bigNumber.add(bigNumber2).getValue());
    }

    @Test
    public void addTest_TC02() {
        bigNumber = new BigNumber("700");
        bigNumber2 = new BigNumber("700");

        assertEquals("1400", this.bigNumber.add(bigNumber2).getValue());
    }

    @Test
    public void addTest_TC03() {
        bigNumber = new BigNumber("700");
        bigNumber2 = new BigNumber("300");

        assertEquals("1000", this.bigNumber.add(bigNumber2).getValue());
    }

    @Test
    public void addTest_TC04() {
        bigNumber = new BigNumber("7000000000000");
        bigNumber2 = new BigNumber("30773730000000");

        assertEquals("37773730000000", this.bigNumber.add(bigNumber2).getValue());
    }

    @Test
    public void addTest_TC05() {
        bigNumber = new BigNumber("70002400000000");
        bigNumber2 = new BigNumber("30773730000000");

        assertEquals("100776130000000", this.bigNumber.add(bigNumber2).getValue());
    }

    @Test
    public void substractTest_TC01() {
        bigNumber = new BigNumber("700");
        bigNumber2 = new BigNumber("100");

        assertEquals("600", this.bigNumber.substract(bigNumber2).getValue());
    }

    @Test
    public void substractTest_TC02() {
        bigNumber = new BigNumber("720");
        bigNumber2 = new BigNumber("100");

        assertEquals("620", this.bigNumber.substract(bigNumber2).getValue());
    }

    @Test
    public void substractTest_TC03() {
        bigNumber = new BigNumber("37773730000000");
        bigNumber2 = new BigNumber("7000000000000");

        assertEquals("30773730000000", this.bigNumber.substract(bigNumber2).getValue());
    }

    @Test
    @Ignore
    public void substractTest_TC04() {
        bigNumber = new BigNumber("100");
        bigNumber2 = new BigNumber("90");

        assertEquals("10", this.bigNumber.substract(bigNumber2).getValue());
    }

    @Test
    public void addDigitsTest_TC01() {
        bigNumber = new BigNumber("100");
        bigNumber2 = new BigNumber("90");

        Map.Entry<Byte, Byte> entry = bigNumber.addDigits((byte) 3, (byte) 5);
        assertEquals(8, entry.getKey().byteValue());
    }

    @Test
    public void substractDigitsTest_TC01() {
        bigNumber = new BigNumber("100");
        bigNumber2 = new BigNumber("90");

        Map.Entry<Byte, Byte> entry = bigNumber.substractDigits((byte) 3, (byte) 5, (byte) 0);
        assertEquals(2, entry.getKey().byteValue());
        assertEquals(1, entry.getValue().byteValue());
    }

    @Test
    public void multiplyDigitsTest_TC01() {
        bigNumber = new BigNumber();

        Map.Entry<Byte,Byte> res=bigNumber.multiplyDigits((byte) 3, (byte) 5, (byte) 0);

        assertEquals((byte) 5, res.getKey().byteValue());
        assertEquals((byte) 1, res.getValue().byteValue());
    }

    @Test
    public void multiplyTest_TC01() {
        bigNumber = new BigNumber("10");
        bigNumber2 = new BigNumber("11");

        assertEquals("110", this.bigNumber.multiply(bigNumber2).getValue());
    }

    @Test
    public void multiplyTest_TC02() {
        bigNumber = new BigNumber("100");
        bigNumber2 = new BigNumber("100");

        assertEquals("10000", this.bigNumber.multiply(bigNumber2).getValue());
    }

    @Test
    public void multiplyTest_TC03() {
        bigNumber = new BigNumber("3384938493489");
        bigNumber2 = new BigNumber("0");

        assertEquals("0", this.bigNumber.multiply(bigNumber2).getValue());
    }

    @Test
    @Ignore
    public void multiplyTest_TC04() {
        bigNumber = new BigNumber("1");
        bigNumber2 = new BigNumber("3001");

        assertEquals("3001", this.bigNumber.multiply(bigNumber2).getValue());
    }

    @Test
    public void multiplyTest_TC05() {
        bigNumber = new BigNumber("0");
        bigNumber2 = new BigNumber("0");

        assertEquals("0", this.bigNumber.multiply(bigNumber2).getValue());
    }
}
