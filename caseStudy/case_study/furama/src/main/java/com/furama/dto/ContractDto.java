package com.furama.dto;

import com.furama.model.contract.Contract;
import com.furama.model.customer.Customer;
import com.furama.model.employee.Employee;
import com.furama.model.facility.Facility;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Valid;
import javax.validation.Validator;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;

public class ContractDto {
    private int id;
    @NotEmpty(message = "Ngày đặt dịch vụ không được để trống")
    private String startDay;
    @NotEmpty(message = "Ngày trả không được để trống")
    private String endDay;
    @Positive(message = "Tiền  không được âm")
    private double deposit;
    private Employee employee;
    private Customer customer;
    private Facility facility;
    private double total;

    public ContractDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

//    @Override
//    public boolean isValid(ContractDto contractDto, ConstraintValidatorContext context) {
//        LocalDateTime startDay = LocalDateTime.parse(contractDto.getStartDay());
//        LocalDateTime endDay = LocalDateTime.parse(contractDto.getEndDay());
//        if (endDay == null) {
//            return true;
////            không cần kiểm tra nếu ngày trả phòng không có
//        }
//        boolean isAfter = endDay.isAfter(startDay);
//        if (!isAfter ) {
//            context.buildConstraintViolationWithTemplate("Ngày trả phòng phải lớn hơn ngày đặt phòng")
//                    .addPropertyNode("endDay")
//                    .addConstraintViolation();
//
//        }
//        return isAfter ;
//    }
}
