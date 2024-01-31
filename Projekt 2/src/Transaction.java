import java.time.LocalTime;

public class Transaction  extends Thread{
    private Client client;
    private Product product;
    private int quantity;
    private String result;
    private Double amount;
    private LocalTime time;

    public Transaction(Client client, Product product, int quantity, LocalTime time) {
        this.client = client;
        this.product = product;
        this.quantity = quantity;
        this.time = time;
    }

    @Override
    public void run() {
        synchronized (product) {
            if (product.getQuantity() - quantity >= 0) {
                this.result = "Transakcja udana";
                this.amount = product.getPrice() * quantity;
                product.setQuantity(product.getQuantity() - quantity);
            } else {
                this.result = "Transakcja nieudana";
                this.amount = 0.0;
            }
            Shop.addTransaction(this);
        }
    }

    @Override
    public String toString() {
        return client.getName() + ";" + client.getNumber() + ';' +
                time + ";" + product.getName() + ";" + quantity + ";"
                + result + ";" + String.format("%.2f",amount).replace('.', ',') + " zł";
    }

    public Client getClient() {
        return client;
    }

    public String getResult() {
        return result;
    }

    public Double getAmount() {
        return amount;
    }

    public LocalTime getTime() {
        return time;
    }
}
