package dev.Zerphyis.monitoramento.Entity.Provider;

import dev.Zerphyis.monitoramento.Entity.Data.DataProvider;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name ="fornecedor")
public class Provider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String phone;

    @NotBlank
    @Email
    @Column(unique = true)
    private String email;

    public Provider(){

    }
    public Provider(DataProvider data ){
        this.name= data.name();
        this.phone= data.phone();
        this.email= data.email();

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }
}
