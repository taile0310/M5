package com.furama.dto;

import com.furama.model.employee.Division;
import com.furama.model.employee.EducationDegree;
import com.furama.model.employee.Position;
import com.furama.model.login.User;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class EmployeeDto {
    private int id;
    @NotEmpty(message = "Tên nhân viên không được để trống")
    @Pattern(regexp = "^[A-Z][a-z]*([ ][A-Z][a-z]*)*$", message = "Tên không được chứa số và chữ cái đầu phải viết hoa")
    private String name;
    private String dateOfBirth;
    @NotEmpty(message = "Căn cước không được để trống")
//    (?:\d{9}|\d{12}): nhóm bao gồm 2 pattern: 9 số hoặc 12 số.
    @Pattern(regexp = "^(?:\\d{9}|\\d{12})$", message = "Căn cước không được ngắn và dài hơn 9 số hoặc 12 số")
    private String idCard;
    @Positive(message = "Lương không được âm")
    private double salary;
    @NotEmpty(message = "Số điện thoại không được để trống")
    @Pattern(regexp = "(((\\+|)84)|0)(3|5|7|8|9)+([0-9]{8})\\b", message = "Số điện thoại chưa đúng định dạng")
    private String phoneNumber;
    @NotEmpty(message = "Email không được để trống")
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Email chưa đúng định dạng")
    private String email;
    private String address;
    private User username;
    private Position position;
    private EducationDegree educationDegree;
    private Division division;

    public EmployeeDto() {

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

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
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

    public User getUsername() {
        return username;
    }

    public void setUsername(User username) {
        this.username = username;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }
}
