import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Scanner;

/**
 * Chương trình DummyTel tính tổng chi phí cho các cuộc gọi đường dài.
 */
public class DummyTel {
    int startTime;
    int duration;
    double totalPrice;
    private double baseRate = 0.50;
    private static final double tax = 0.05;


    /**
     * Default constructor cho DummyTel
     */
    public DummyTel() {
        this.startTime = 0;
        this.duration = 0;
    }

    /**
     * Constructor 1 param startTime cho dummyTel
     *
     * @param startTime Thời gian bắt đầu cuộc gọi (24 giờ).
     */
    public DummyTel(int startTime) {
        this.startTime = startTime;
        this.duration = 0;
    }

    /**
     * Constructor 2 param startTime cho dummyTel
     *
     * @param startTime Thời gian bắt đầu cuộc gọi (24 giờ).
     * @param duration Thời lượng của cuộc gọi (phút).
     */
    public DummyTel(int startTime, int duration) {
        this.startTime = startTime;
        this.duration = duration;
    }

    /**
     * Hàm trả tỷ lệ cho cuộc gọi
     *
     * @return Tỷ lệ cho cuộc gọi
     */
    public double getBaseRate() {
        return baseRate;
    }

    /**
     * Hàm trả về giá trị tổng chi phí cho cuộc gọi
     *
     * @return Giá trị tổng chi phí cho cuộc gọi
     */
    public double getTotalPrice() {
        return totalPrice;
    }

    /**
     * Hàm đặt giá trị tổng chi phí cho cuộc gọi
     *
     * @param totalPrice Giá trị tổng chi phí cho cuộc gọi
     */
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * Hàm tính chiết khấu dựa trên thời gian bắt đầu cuộc gọi
     *
     */
    public void startTimeDiscount() {
        int startDiscount = 18;
        int endDiscount = 8;
        if ((this.startTime - startDiscount) >= 0 || (this.startTime - endDiscount) < 0) {
            this.baseRate /= 2;
        }
    }

    /**
     * Hàm tính chiết khấu dựa trên thời lượng cuộc gọi
     *
     */
    public void durationDiscount() {
        if (this.duration > 1) {
            this.totalPrice -= 0.15 * totalPrice;
        }
    }

    /**
     * Hàm cộng thuế vào giá cuộc gọi
     */
    public void addTax() {
        this.totalPrice += tax * totalPrice;
    }

    /**
     * Hàm tính tổng chi phí ròng cho cuộc gọi
     *
     * @return Tổng chi phí ròng cho cuộc gọi
     */
    public String calculateTotalPrice() {
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);
        this.startTimeDiscount();

        totalPrice = baseRate * duration * 60;

        this.durationDiscount();

        this.addTax();

        return df.format(totalPrice);
    }

    /**
     * Giao diện người dùng
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int startTime = scan.nextInt();
        int duration = scan.nextInt();
        var dummyTel = new DummyTel(startTime, duration);

        System.out.println(dummyTel.calculateTotalPrice());
    }
}
