package com.itg.supplychainmanagment.entity;

import javax.persistence.*;

@Entity
@Table(name = "invoice")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoice_id", updatable = false, nullable = false)
    private Long invoiceId;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "total_amount")
    private Double totalAmount;

    @Column(name = "product_quantity")
    private Integer productQuantity;

    public Invoice(){}

    public Invoice(Long invoiceId, Product product, Double totalAmount, Integer productQuantity) {
        this.invoiceId = invoiceId;
        this.product = product;
        this.totalAmount = totalAmount;
        this.productQuantity = productQuantity;
    }

    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }

}