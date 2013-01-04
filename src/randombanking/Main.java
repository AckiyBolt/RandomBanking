package randombanking;

import java.util.Calendar;
import java.util.EnumMap;
import java.util.LinkedList;
import java.util.Random;
import randombanking.model.Bank;
import randombanking.model.Client;
import randombanking.model.MoneyType;

/**
 *
 * @author ackiybolt
 */
public class Main {

    private static LinkedList<Casher> cashers = new LinkedList<Casher>();
    private static EnumMap<MoneyType, Double> babosesHolder;

    static {
        babosesHolder = new EnumMap<MoneyType, Double>(MoneyType.class);
        babosesHolder.put(MoneyType.EURO, 0.0);
        babosesHolder.put(MoneyType.RUB, 0.0);
        babosesHolder.put(MoneyType.UAH, 0.0);
        babosesHolder.put(MoneyType.USD, 0.0);
    }

    public static void main(String[] args) throws InterruptedException {
        
        Bank bank = Bank.getInstance();
        cashers = bank.getCashers();

        for (int i = 0; i < 8; i++) {
            ClientThread cThread = new ClientThread();
            Thread thread = new Thread(cThread);
            thread.setDaemon(true);
            thread.start();
        }

        // time step = 1 min = 10 mils
        // 1 min * 60 min * 8 hours * 10 mils = 480 min * 10 mils
        Thread.sleep(4800);

        EnumMap<MoneyType, Double> baboses = bank.getBabosesHolder();

        for (MoneyType type : MoneyType.values()) {

            Double current = babosesHolder.get(type);
            current += baboses.get(type);
            babosesHolder.put(type, current);
        }

        bank.drop();

        createStatictic();
    }

    private static void createStatictic() {
        printCaherStatistic();
        printMoneyCount();
    }

    private static void printCaherStatistic() {

        String result = "";

        for (Casher casher : cashers) {
            result += "Casher [" + casher.getId()
                    + "]"
                    + ": " + casher.getClientsCount() + "\n";
        }

        System.out.println(result + "\n");
    }

    private static void printMoneyCount() {

        String result = "Balanse:\n";

        for (MoneyType type : babosesHolder.keySet()) {

            Long count = Math.round(babosesHolder.get(type));

            result += type
                    + ": " + count + "\n";
        }

        System.out.println(result + "\n");
    }
}
