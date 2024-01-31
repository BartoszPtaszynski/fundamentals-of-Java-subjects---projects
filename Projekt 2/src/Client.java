import java.util.Objects;

public class Client {
    private String name;
    private String number;
    private String address;
    private String city;
    private String postalCode;
    public Client(String name, String number, String address, String postalCode, String city) {
        this.name = name;
        this.number = number;
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
    }
    @Override
    public int hashCode() {
        return Objects.hash(name,number,address,postalCode,city);
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }



    @Override
    public boolean equals(Object obj) {
        Client client2 = (Client) obj;
         return client2.name.equals(name) && client2.address.equals(address) && client2.number.equals(number)
                 && client2.postalCode.equals(postalCode) && client2.city.equals(city);
    }

    @Override
    public String toString() {
        return
                String.format("name: %s, number: %s, address: %s, postal code: %s, city: %s",name,number,address,postalCode,city);
    }
}
