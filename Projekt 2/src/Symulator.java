
import java.lang.management.ManagementFactory;
import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;

public class Symulator {
    public static void main(String[] args) {
            Shop shop = Shop.getInstance();
            shop.loadClients();
            shop.loadProduct();

        Random rand=new Random();
        for(int i=0;i<60;i++) {
        List<Client> currentClients = new ArrayList<>();
        List<Thread> allThreads = new ArrayList<>();
        int numberOfClients = rand.nextInt(14)+2;
        for(int j=0;j<numberOfClients;j++) {

            Client client = Shop.getClients().get(rand.nextInt(Shop.getClients().size()));
            if(currentClients.contains(client)) {
                j--;
                continue;
            }
            currentClients.add(client);

            Transaction transaction = new Transaction(currentClients.get(j),
                    Shop.getProducts().get(rand.nextInt(Shop.getProducts().size())),
                    rand.nextInt(10)+1,
                    LocalTime.of(12,i));

            Thread thread = new Thread(transaction);
            allThreads.add(thread);
            thread.start();
        }
            try {
                for (Thread thread : allThreads) {
                    thread.join();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        Shop.updateFiles();

        System.out.println("Wszystkie udane transakcje dokonane w drugiej połowie godziny: ");
        Shop.getTransactions()
                .stream()
                .filter(t->t.getResult().equals("Transakcja udana"))
                .filter(t->t.getTime().getMinute()>30)
                .forEach(System.out::println);

        long notPass=Shop.getTransactions().stream()
                .filter(r->r.getResult().equals("Transakcja nieudana"))
                .count();
        System.out.println("\nProcent nieudanych transakcji: "+(double)notPass/Shop.getTransactions().size()*100+"%.\n");

        System.out.println("Klient, który wydał najwięcej w jednej transakcji:");
        Shop.getTransactions().stream()
                .sorted(Comparator.comparingDouble(Transaction::getAmount).reversed())
                .findFirst().ifPresent(transaction -> System.out.println(transaction.getClient()));

        System.out.println("\nKlient, który wydał najwięcej we wszystkich tranzakcjach:");
        Shop.getTransactions().stream()
                .collect(Collectors.groupingBy(Transaction::getClient,
                        Collectors.summingDouble(Transaction::getAmount)))
                .entrySet().stream()
                .max(Comparator.comparingDouble(m->m.getValue()))
                .ifPresent(client -> System.out.println(client.getKey()));



    }

}
