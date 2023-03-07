package com.furama.dto;

import com.furama.model.customer.CustomerType;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class CustomerDto {
    private int id;
    @NotEmpty(message = "Tên không được để trống")
    @Pattern(regexp = "^[A-Z][a-z]*([ ][A-Z][a-z]*)*$", message = "Tên không được chứa số và chữ cái đầu phải viết hoa")
    private String name;
    private String dateOfBirth;
    private boolean gender;
    @NotEmpty(message = "Căn cước không được để trống")
    //    (?:\d{9}|\d{12}): nhóm bao gồm 2 pattern: 9 số hoặc 12 số.
    @Pattern(regexp = "^(?:\\d{9}|\\d{12})$", message = "Căn cước không được ngắn và dài hơn 9 số hoặc 12 số")
    private String idCard;

    @NotEmpty(message = "Số điện thoại không được dể trống")
    @Pattern(regexp = "(((\\+|)84)|0)(3|5|7|8|9)+([0-9]{8})\\b", message = "Số điện thoại chưa đúng định dạng")
    private String phoneNumber;
    @NotEmpty(message = "Email không được để trống")
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Email chưa đúng định dạng")
    private String email;
    private String address;
    private CustomerType customerType;

    public CustomerDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

}
