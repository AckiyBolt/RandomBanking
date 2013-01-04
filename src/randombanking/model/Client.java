package randombanking.model;

/**
 *
 * @author ackiybolt
 */
public class Client {
    
    private Integer id;
    private OperationType operationType;
    private Money money;
    private MoneyType wantedMoneyType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Money getMoney() {
        return money;
    }

    public void setMoney(Money money) {
        this.money = money;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }

    public MoneyType getWantedMoneyType() {
        return wantedMoneyType;
    }

    public void setWantedMoneyType(MoneyType wantedMoney) {
        this.wantedMoneyType = wantedMoney;
    }
}
