package com.itg.supplychainmanagment.service;

import com.itg.supplychainmanagment.entity.Invoice;
import com.itg.supplychainmanagment.entity.Product;
import com.itg.supplychainmanagment.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private ProductService productService;


    // Update product quantity when any product sold

    public Invoice createInvoice(Invoice invoice) {
        // check if any amount null or negative
        if(invoice.getProductQuantity() == null || invoice.getProductQuantity() <= 0){
            throw new IllegalArgumentException("productQuantity can not be null or negative");
        }

        if(invoice.getTotalAmount() == null){
            throw new IllegalArgumentException("totalAmount can not be null");
        }
        // update product quantity if sold
        Product product = invoice.getProduct();
        int newQuantity = product.getQuantity() - invoice.getProductQuantity();
        // check if stocks are enough
        if(newQuantity < 0){
            throw new IllegalArgumentException("Quantity can not be negative");
        }
        product.setQuantity(newQuantity);
        productService.updateProduct(product.getProductId(), product);
        return invoiceRepository.save(invoice);
    }


    // TODO: can be removed at the end if no time or no req
    public Invoice viewInvoiceDetails(Long invoiceId) {
        return invoiceRepository.findById(invoiceId).get();
    }

    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }
    public Invoice getInvoiceById(Long invoiceId) {
        return invoiceRepository.findById(invoiceId).orElse(null);
    }

    public Invoice updateInvoice(Long invoiceId, Invoice invoice) {
        Invoice existingInvoice = invoiceRepository.findById(invoiceId).orElse(null);
        if(existingInvoice != null) {
            existingInvoice.setProduct(invoice.getProduct());
            existingInvoice.setTotalAmount(invoice.getTotalAmount());
            existingInvoice.setProductQuantity(invoice.getProductQuantity());
            return invoiceRepository.save(existingInvoice);
        }
        return null;
    }

    public void deleteInvoice(Long invoiceId) {
        invoiceRepository.deleteById(invoiceId);
    }

}