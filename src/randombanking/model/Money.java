package randombanking.model;

/**
 *
 * @author ackiybolt
 */
public class Money {

    private Double count;
    private MoneyType type;

    public Money() {
    }

    public Money(Double count, MoneyType type) {
        this.count = count;
        this.type = type;
    }

    public Double getCount() {
        return count;
    }

    public void setCount(Double count) {
        this.count = count;
    }

    public MoneyType getType() {
        return type;
    }

    public void setType(MoneyType type) {
        this.type = type;
    }
}