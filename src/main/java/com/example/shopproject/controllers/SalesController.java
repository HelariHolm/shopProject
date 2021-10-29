package com.example.shopproject.controllers;


import com.example.shopproject.entities.Product;
import com.example.shopproject.entities.Sale;
import com.example.shopproject.repository.SalesRepository;
import com.example.shopproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
@ResponseBody
public class SalesController {

    @Autowired
    public SalesRepository salesRepository;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/sale")
    public Sale createProduct(@Validated @RequestBody Sale sale) {
        Sale createSale = new Sale();
        createSale.setDate(sale.getDate());
        createSale.setUserId(sale.getUserId());
        createSale.setProductBought(sale.getProductBought());
        createSale.setPriceBought(sale.getPriceBought());
        createSale.setQuantityBought(sale.getQuantityBought());

        return salesRepository.save(createSale);
    }

    @GetMapping("/sale/{id}")
    public Sale getSale(@PathVariable Long saleId) {
        return salesRepository.findById(saleId).orElseThrow();
    }

    @GetMapping("/sales")
    public List<Sale> getSales() {
        return salesRepository.findAll();
    }

    @PutMapping("/sale/{id}")
    public Sale updateSale(@PathVariable Long saleId, @RequestBody Sale saleToUpdate)  {
        Sale foundSale = salesRepository.findById(saleId).orElseThrow();
        foundSale.setDate(saleToUpdate.getDate());
        foundSale.setUserId(saleToUpdate.getUserId());
        foundSale.setProductBought(saleToUpdate.getProductBought());
        foundSale.setPriceBought(saleToUpdate.getPriceBought());
        foundSale.setQuantityBought(saleToUpdate.getQuantityBought());

        return salesRepository.save(foundSale);
    }

}
