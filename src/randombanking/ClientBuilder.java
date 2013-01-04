package randombanking;

import randombanking.model.*;
import java.lang.Math;
import java.math.MathContext;
import java.util.Calendar;
import java.util.Random;

/**
 *
 * @author ackiybolt
 */
public enum ClientBuilder {
    
    INSTANCE;
    
    public static ClientBuilder getInstance() {
        return INSTANCE;
    }
    
    private Integer clientCounter;
    
    public void dropCounter () {
        clientCounter = 0;
    }
    
    public synchronized Client build () {
        
        if (clientCounter == null)
            dropCounter();
        
        Client client = new Client();
        client.setId(clientCounter++);
        client.setOperationType(buildOperationType());
        client.setMoney(buildMoney());
        client.setWantedMoneyType(buildWantedMoneyType());
        return client;
    }
    
    private OperationType buildOperationType () {
        int count = OperationType.values().length;
        return OperationType.values()[getRandom().nextInt(count)];
    }
    
    private Money buildMoney () {
        Money money = new Money();
        money.setType(buildMoneyType());
        money.setCount(buildMoneyCount());
                
        return money;
    }
    
    private MoneyType buildMoneyType () {
        int count = MoneyType.values().length;
        return MoneyType.values()[getRandom().nextInt(count)];
    }
    
    private MoneyType buildWantedMoneyType () {
        int count = MoneyType.values().length;
        return MoneyType.values()[getRandom().nextInt(count)];
    }
    
    private Double buildMoneyCount () {
        Double val = Double.parseDouble( Integer.toString(getRandom().nextInt(50000)) );
        
        return val > 5.0 ? val : buildMoneyCount();
    }
    
    private Random getRandom () {
        return new Random(Calendar.getInstance().getTimeInMillis());
    }
}
