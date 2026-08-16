import java.util.Scanner;
public class QuestionNo28 {
    private String name;
    private int customerId;
    private int consumedUnits;
    public static final int GST = 180;
    public static final int TV_FEE = 35;
    public static final int METER_RENT = 200;
    public QuestionNo28() {
    }
    public QuestionNo28(String name, int customerId, int consumedUnits) {
        this.name = name;
        this.customerId = customerId;
        this.consumedUnits = consumedUnits;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getCustomerId() {
        return customerId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public int getConsumedUnits() {
        return consumedUnits;
    }
    public void setConsumedUnits(int consumedUnits) {
        this.consumedUnits = consumedUnits;
    }
    public void getDetail(){
        System.out.print("Enter Your Name : ");
        setName(new Scanner(System.in).nextLine());
        System.out.print("Enter Your Customer ID : ");
        setCustomerId(new Scanner(System.in).nextInt());
        System.out.print("How Much Units You Consume In Last 30-Days : ");
        setConsumedUnits(new Scanner(System.in).nextInt());
    }
    public void setUnits(){
        int bill1 =  getConsumedUnits()*13+METER_RENT+TV_FEE+GST;
        int outStandingUnits = getConsumedUnits()/30;
        if (getConsumedUnits()>199){
            System.out.println("Your Bill ("+bill1+") On This Month & " +
                    "Your OutStanding Units Is : ("+outStandingUnits+")");
        }else
            if (getConsumedUnits() > 200 && getConsumedUnits() <= 300){
                int bill2 = getConsumedUnits()*19+METER_RENT+TV_FEE+GST;
                System.out.println("Your Bill ("+bill2+") On This Month & " +
                        "Your OutStanding Units Is : ("+outStandingUnits+")");
            }else
                if (getConsumedUnits()> 301 && getConsumedUnits() <= 699){
                    int bill3 = getConsumedUnits()*27+METER_RENT+TV_FEE+GST;
                    System.out.println("Your Bill ("+bill3+") On This Month & " +
                            "Your OutStanding Units Is : ("+outStandingUnits+")");
                }else
                    if (getConsumedUnits() >= 700){
                        int bill4 = getConsumedUnits()*36+METER_RENT+TV_FEE+GST;
                        System.out.println("Your Bill ("+bill4+") On This Month & " +
                                "Your OutStanding Units Is : ("+outStandingUnits+")");
                    }else {
                        System.out.println("( INVALID UNITS ! )");
                    }
    }
}
