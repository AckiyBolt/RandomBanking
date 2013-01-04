package randombanking.model;

import java.util.Calendar;
import java.util.Random;

/**
 *
 * @author ackiybolt
 */
public enum OperationType {
        BUY_MONEY (10, 30),      // покупка валюты
        SELL_MONEY (10, 30),     // продажа валюты
        RETURN_MONEY (30, 70),   // выдача вкладов
        SEND_MONEY (20, 60),     // перевод валюты
        PAYMENT (20, 50);        // прием платежей
        
        private Integer periodFrom;
        private Integer periodTo;
        
        private OperationType (Integer from, Integer to) {
            this.periodFrom = from;
            this.periodTo = to;
        }

        public Integer getPeriod() {
            Random random = new Random(Calendar.getInstance().getTimeInMillis());
            int val = random.nextInt(periodTo);
            return val > periodFrom ? val : getPeriod();
        }
    }
