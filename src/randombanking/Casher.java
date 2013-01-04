package randombanking;

import randombanking.model.Bank;
import randombanking.model.Client;
import randombanking.model.Money;
import randombanking.model.MoneyType;

/**
 *
 * @author ackiybolt
 */
public class Casher {
    
    private Bank bank = Bank.getInstance();
    private Integer id;
    private Integer clientsCount;
    private static volatile int count;

    public Casher() {
        bank.addCasher(this);
        clientsCount = 0;
        id = ++count;
    }
    
    public void process (Client client) {
        
        clientsCount++;
        
        switch (client.getOperationType()) {
            
            case BUY_MONEY :
                bank.addMoney(client.getMoney());
                bank.getMoney(
                        new Money(
                            MoneyType.convertMoney(
                                client.getWantedMoneyType(),
                                client.getMoney()
                            ),
                            client.getWantedMoneyType()
                        )
                        );
                break;
                
            case SELL_MONEY :
                bank.getMoney(client.getMoney());
                bank.addMoney(
                        new Money(
                            MoneyType.convertMoney(
                                client.getWantedMoneyType(),
                                client.getMoney()
                            ),
                            client.getWantedMoneyType()
                        )
                        );
                
            case RETURN_MONEY :
                bank.getMoney(client.getMoney());
                break;
                
            default: // sand & payment
                bank.addMoney(client.getMoney());
                break;
                
        }
    }

    public Integer getId() {
        return id;
    }

    public Integer getClientsCount() {
        return clientsCount;
    }
}