package randombanking;

import java.util.Calendar;
import java.util.Random;
import randombanking.model.Client;

/**
 *
 * @author ackiybolt
 */
public class ClientThread implements Runnable{

    private Casher casher = new Casher();
    
    @Override
    public void run() {
        
        while (true) {
            
            Client client = ClientBuilder.getInstance().build();
            
            try {
                
                Thread.sleep(client.getOperationType().getPeriod());
                
                casher.process(client);
                
                Thread.sleep(getClientWaitTime());
                
            } catch (InterruptedException ex) {}
        }
    }
    
    private Integer getClientWaitTime () {
        Integer maxWaitTime = 50;
        Integer minWaitTime = 5;
        
        Random random = new Random(Calendar.getInstance().getTimeInMillis());
        int val = random.nextInt(maxWaitTime);
        return val > minWaitTime ? val : getClientWaitTime();
    }

}
