package randombanking.model;

/**
 *
 * @author ackiybolt
 */
public enum MoneyType {

    USD(7.99),
    EURO(10.5),
    RUB(0.25),
    UAH(1.0);
    private Double uahCourse;
    
    public static Double convertMoney (MoneyType type, Money money) {
        switch (type) {
            case EURO : return getAsEURO(money);
            case RUB  : return getAsRUB (money);
            case USD  : return getAsRUB (money);
            default   : return getAsUAH (money);
        }
    }

    private MoneyType(Double grnCourse) {
        this.uahCourse = grnCourse;
    }

    private static Double getAsUSD(Money money) {
        return getInUAH(money) / MoneyType.USD.uahCourse;
    }

    private static Double getAsEURO(Money money) {
        return getInUAH(money) / MoneyType.EURO.uahCourse;
    }

    private static Double getAsRUB(Money money) {
        return getInUAH(money) / MoneyType.RUB.uahCourse;
    }

    private static Double getAsUAH(Money money) {
        return getInUAH(money) / MoneyType.UAH.uahCourse;
    }

    private static Double getInUAH(Money money) {
        return money.getType().uahCourse * money.getCount();
    }
}
