package sk.balaz.springbootmaster.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

// Jackson Fasterxml annotations
// https://www.geeksforgeeks.org/jackson-annotations-for-java-application/
public class Customer {
    private final Long id;
    private final  String name;
    private String password;

    public Customer(Long id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    @JsonProperty("customer_id")
    public Long getId() {
        return id;
    }

    public Long getCustomerId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }
    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
