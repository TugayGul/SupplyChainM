package com.itg.supplychainmanagment.controller;

import com.itg.supplychainmanagment.entity.Invoice;
import com.itg.supplychainmanagment.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invoice")
public class InvoiceController {


    @Autowired
    private InvoiceService invoiceService;


    @PreAuthorize(value = "hasRole('ROLE_RETAILER')")
    @PostMapping
    public Invoice createInvoice(@RequestBody Invoice invoice) {
        return invoiceService.createInvoice(invoice);
    }


    // Can be used if supplier and retailer id added to db tables
    @PreAuthorize(value = "hasRole('ROLE_SUPPLIER')")
    @GetMapping
    public List<Invoice> getAllInvoices() {
        return invoiceService.getAllInvoices();
    }


    // Can be used if supplier and retailer id added to db tables
    @PreAuthorize(value = "hasRole('ROLE_SUPPLIER')")
    @GetMapping("/{id}")
    public Invoice getInvoiceById(@PathVariable Long id) {
        return invoiceService.getInvoiceById(id);
    }


    // TODO: remove these two at the end if not required, most probably not
    @PutMapping("/{id}")
    public Invoice updateInvoice(@PathVariable Long id, @RequestBody Invoice invoice) {
        return invoiceService.updateInvoice(id, invoice);
    }



    @DeleteMapping("/{id}")
    public void deleteInvoice(@PathVariable Long id) {
        invoiceService.deleteInvoice(id);
    }
}