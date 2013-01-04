package randombanking.model;

import java.util.EnumMap;
import java.util.LinkedList;
import randombanking.Casher;

/**
 *
 * @author ackiybolt
 */
public enum Bank {

    INSTANCE();
    
    public static Bank getInstance () {
        return INSTANCE;
    }

    public void addCasher(Casher casher) {
        cashers.add(casher);
    }

    public EnumMap<MoneyType, Double> getBabosesHolder() {
        return babosesHolder;
    }

    public LinkedList<Casher> getCashers() {
        return cashers;
    }
    
    private LinkedList<Casher> cashers;
    private EnumMap<MoneyType, Double> babosesHolder;
    
    private Bank () {
        drop();
    }
    
    public synchronized void drop () {
        cashers = new LinkedList<Casher>();
        babosesHolder = new EnumMap<MoneyType, Double>(MoneyType.class);
        babosesHolder.put(MoneyType.EURO, 0.0);
        babosesHolder.put(MoneyType.RUB, 0.0);
        babosesHolder.put(MoneyType.UAH, 0.0);
        babosesHolder.put(MoneyType.USD, 0.0);
    }

    public synchronized void addMoney(Money money) {
        
        Double value = babosesHolder.get(money.getType());
        value += money.getCount();
        babosesHolder.put(money.getType(), value);
        System.out.println("add money: " + money.getType() + " " + money.getCount() );
    }

    public synchronized void getMoney(Money money) {
        
        Double value = babosesHolder.get(money.getType());
        value -= money.getCount();
        babosesHolder.put(money.getType(), value);
        System.out.println("get money: " + money.getType() + " " + money.getCount() );
    }
}