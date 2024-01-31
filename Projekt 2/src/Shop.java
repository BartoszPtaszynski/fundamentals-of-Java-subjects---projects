import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class Shop {
    private static final Shop INSTANCE = new Shop();
    private   static List<Client> clients;
    private   static List<Product> products;
    private   static List<Transaction> transactions;

    private Shop() {
        clients = new ArrayList<>();
        products = new ArrayList<>();
        transactions = new ArrayList<>();
    }

    public static Shop getInstance() {
        return INSTANCE;
    }
    public static List<Client> getClients() {
        return clients;
    }


    public static void loadClients()  {
        try (BufferedReader reader = new BufferedReader(new FileReader("clients.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");
                String name = data[0];
                String number = data[1];
                String address = data[2];
                String postalCode = data[3];
                String city = data[4];
                clients.add(new Client (name, number,address,postalCode,city));
            }
        }
        catch (IOException e)
        {
            System.err.println("cannot read file with clients");
        }
    }

    public static void loadProduct()  {
        try (BufferedReader reader = new BufferedReader(new FileReader("products.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");
                String name = data[0];
                Double price = Double.parseDouble(data[1].substring(0,data[1].length()-2).replace(',','.'));
                int quantity = Integer.parseInt(data[2]);
                products.add(new Product (name, price, quantity));
            }
        }
        catch (IOException e)
        {
            System.err.println("cannot read file with products");
        }
    }

    public static List<Product> getProducts() {
        return products;
    }

    public static List<Transaction> getTransactions() {
        return transactions;
    }
    public static void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public static void updateFiles() {
        Path file = Paths.get("products.txt");
        Charset charset = StandardCharsets.UTF_8;
            try (BufferedWriter writer = Files.newBufferedWriter(file,
                    charset, StandardOpenOption.TRUNCATE_EXISTING)) {
                for(Product product: products) {
                    String productText = product.toString();
                    writer.write(productText.toString()+"\n");
                }
            } catch (IOException x) {
                System.err.format("IOException: %s%n", x);
            }

        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get("raport.txt"),
                charset, StandardOpenOption.TRUNCATE_EXISTING)) {
            for(Transaction transaction: transactions) {
                String transactionText = transaction.toString();
                writer.write(transactionText.toString()+"\n");
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }

    }
}
