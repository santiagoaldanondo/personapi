package santiagoaldanondo.personapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.io.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "persons")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String dni;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName1;

    private String lastName2;

    private short age;

    private Date birthDate;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

    // Getters

    public long getId() {
        return id;
    }

    public String getDni() {
        return dni;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName1() {
        return lastName1;
    }

    public String getLastName2() {
        return lastName2;
    }

    public short getAge() {
        return age;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date updatedAt() {
        return updatedAt;
    }

    // Setters

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName1(String lastName1) {
        this.lastName1 = lastName1;
    }

    public void setLastName2(String lastName2) {
        this.lastName2 = lastName2;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

}