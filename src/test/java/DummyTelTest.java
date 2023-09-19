import org.junit.jupiter.api.Test;

import java.math.RoundingMode;
import java.text.DecimalFormat;


import static org.junit.jupiter.api.Assertions.*;

/**
 * TestSuite cho DummyTel
 */
class DummyTelTest {
    /**
     * Test case cho hàm khởi tạo cơ bản
     */
    @Test
    void normalDefaultConstructorTest() {
        var dummyTel = new DummyTel();
        assertTrue(dummyTel.startTime == 0 && dummyTel.duration == 0);
    }

    /**
     * Test case cho hàm khởi tạo 2 param
     */
    @Test
    void normalConstructorTest() {
        var startTime = 18;
        var duration = 3;
        var dummyTel = new DummyTel(startTime, duration);
        assertTrue(dummyTel.startTime == startTime && dummyTel.duration == duration);
    }

    /**
     * Test case cho hàm chiết khấu theo thời điểm gọi (Trường hợp có giảm giá)
     * t = 0
     */
    @Test
    void normalStarTimeDiscountTest1() {
        var startTime = 0;
        var dummyTel = new DummyTel(startTime);
        var baseRateBeforeDiscount = dummyTel.getBaseRate();

        dummyTel.startTimeDiscount();

        assertEquals(dummyTel.getBaseRate(), baseRateBeforeDiscount / 2);
    }

    /**
     * Test case cho hàm chiết khấu theo thời điểm gọi (Trường hợp có giảm giá)
     * t = 23
     */
    @Test
    void normalStarTimeDiscountTest2() {
        var startTime = 23;
        var dummyTel = new DummyTel(startTime);
        var baseRateBeforeDiscount = dummyTel.getBaseRate();

        dummyTel.startTimeDiscount();

        assertEquals(dummyTel.getBaseRate(), baseRateBeforeDiscount / 2);
    }

    /**
     * Test case cho hàm chiết khấu theo thời điểm gọi (Trường hợp có giảm giá)
     * t = 18
     */
    @Test
    void normalStarTimeDiscountTest3() {
        var startTime = 18;
        var dummyTel = new DummyTel(startTime);
        var baseRateBeforeDiscount = dummyTel.getBaseRate();

        dummyTel.startTimeDiscount();

        assertEquals(dummyTel.getBaseRate(), baseRateBeforeDiscount / 2);
    }

    /**
     * Test case cho hàm chiết khấu theo thời điểm gọi (Trường hợp có giảm giá)
     * t = 7
     */
    @Test
    void normalStarTimeDiscountTest4() {
        var startTime = 7;
        var dummyTel = new DummyTel(startTime);
        var baseRateBeforeDiscount = dummyTel.getBaseRate();

        dummyTel.startTimeDiscount();

        assertEquals(dummyTel.getBaseRate(), baseRateBeforeDiscount / 2);
    }

    /**
     * Test case cho hàm chiết khấu theo thời điểm gọi (Trường hợp không giảm giá)
     * t = 8
     */
    @Test
    void normalStarTimeDiscountTest5() {
        var startTime = 8;
        var dummyTel = new DummyTel(startTime);
        var baseRateBeforeDiscount = dummyTel.getBaseRate();

        dummyTel.startTimeDiscount();

        assertEquals(dummyTel.getBaseRate(), baseRateBeforeDiscount);
    }

    /**
     * Test case cho hàm chiết khấu theo thời điểm gọi (Trường hợp không giảm giá)
     * t = 17
     */
    @Test
    void normalStarTimeDiscountTest6() {
        var startTime = 17;
        var dummyTel = new DummyTel(startTime);
        var baseRateBeforeDiscount = dummyTel.getBaseRate();

        dummyTel.startTimeDiscount();

        assertEquals(dummyTel.getBaseRate(), baseRateBeforeDiscount);
    }

    /**
     * Test case cho hàm chiết khấu theo thời lượng gọi (Trường hợp có chiết khấu)
     * T = 2
     */
    @Test
    void normalDurationDiscountTest1() {
        var startTime1 = 0;
        var dummyTel = new DummyTel(startTime1, 2);
        var totalPriceBeforeDurationDiscount = 100;

        dummyTel.setTotalPrice(totalPriceBeforeDurationDiscount);

        dummyTel.durationDiscount();

        assertEquals(dummyTel.getTotalPrice(), totalPriceBeforeDurationDiscount * 0.85);
    }

    /**
     * Test case cho hàm chiết khấu theo thời lượng gọi (Trường hợp không chiết khấu)
     */
    @Test
    void normalDurationDiscountTest2() {
        var startTime1 = 0;
        var dummyTel = new DummyTel(startTime1, 1);
        var totalPriceBeforeDurationDiscount = 100;

        dummyTel.setTotalPrice(totalPriceBeforeDurationDiscount);

        dummyTel.durationDiscount();

        assertEquals(dummyTel.getTotalPrice(), totalPriceBeforeDurationDiscount);
    }

    /**
     * Test case cho hàm chiết khấu theo thời lượng gọi (Trường hợp không chiết khấu)
     */
    @Test
    void normalDurationDiscountTest3() {
        var startTime1 = 0;
        var dummyTel = new DummyTel(startTime1, 0);
        var totalPriceBeforeDurationDiscount = 100;

        dummyTel.setTotalPrice(totalPriceBeforeDurationDiscount);

        dummyTel.durationDiscount();

        assertEquals(dummyTel.getTotalPrice(), totalPriceBeforeDurationDiscount);
    }

    /**
     * Test case cho hàm cộng thuế
     */
    @Test
    void normalAddTaxTest() {
        var dummyTel = new DummyTel();
        var totalPriceBeforeAddTax = 100;

        dummyTel.setTotalPrice(totalPriceBeforeAddTax);

        dummyTel.addTax();

        assertEquals(dummyTel.getTotalPrice(), totalPriceBeforeAddTax * 1.05);
    }

    /**
     * Test case 1 cho hàm tính giá trị ròng của cuộc gọi
     */
    @Test
    void normalCalculateTotalPriceTest1() {
        var startTime = 0;
        var duration = 2;
        var dummyTel1 = new DummyTel(startTime, duration);
        var dummyTel2 = new DummyTel(startTime, duration);

        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);
        dummyTel2.startTimeDiscount();
        dummyTel2.setTotalPrice(dummyTel2.getBaseRate() * duration * 60);
        dummyTel2.durationDiscount();
        dummyTel2.addTax();

        assertEquals(dummyTel1.calculateTotalPrice(), df.format(dummyTel2.getTotalPrice()));
    }

    /**
     * Test case 2 cho hàm tính giá trị ròng của cuộc gọi
     */
    @Test
    void normalCalculateTotalPriceTest2() {
        var startTime = 10;
        var duration = 1;
        var dummyTel1 = new DummyTel(startTime, duration);
        var dummyTel2 = new DummyTel(startTime, duration);

        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);
        dummyTel2.startTimeDiscount();
        dummyTel2.setTotalPrice(dummyTel2.getBaseRate() * duration * 60);
        dummyTel2.durationDiscount();
        dummyTel2.addTax();

        assertEquals(dummyTel1.calculateTotalPrice(), df.format(dummyTel2.getTotalPrice()));
    }

    /**
     * Test case 3 cho hàm tính giá trị ròng của cuộc gọi
     */
    @Test
    void normalCalculateTotalPriceTest3() {
        var startTime = 7;
        var duration = 1;
        var dummyTel1 = new DummyTel(startTime, duration);
        var dummyTel2 = new DummyTel(startTime, duration);

        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);
        dummyTel2.startTimeDiscount();
        dummyTel2.setTotalPrice(dummyTel2.getBaseRate() * duration * 60);
        dummyTel2.durationDiscount();
        dummyTel2.addTax();

        assertEquals(dummyTel1.calculateTotalPrice(), df.format(dummyTel2.getTotalPrice()));
    }

    /**
     * Test case 4 cho hàm tính giá trị ròng của cuộc gọi
     */
    @Test
    void normalCalculateTotalPriceTest4() {
        var startTime = 16;
        var duration = 3;
        var dummyTel1 = new DummyTel(startTime, duration);
        var dummyTel2 = new DummyTel(startTime, duration);

        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);
        dummyTel2.startTimeDiscount();
        dummyTel2.setTotalPrice(dummyTel2.getBaseRate() * duration * 60);
        dummyTel2.durationDiscount();
        dummyTel2.addTax();

        assertEquals(dummyTel1.calculateTotalPrice(), df.format(dummyTel2.getTotalPrice()));
    }
}