package com.waa.g7onlinemarket.controllers;


import com.waa.g7onlinemarket.models.Role;
import com.waa.g7onlinemarket.models.dto.ProductDto;
import com.waa.g7onlinemarket.models.dto.SaveProductDto;
import com.waa.g7onlinemarket.services.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.util.List;

@Tag(name = "Products")
@RestController
@RequestMapping("/products")
public class ProductController {

    ProductService service;

    public ProductController(ProductService productService){
        this.service = productService;
    }

    @GetMapping
    public List<ProductDto> getAll(){
        return service.findAll();
    }

    @GetMapping("/my-products")
    @PreAuthorize("hasRole('" + Role.SELLER + "')")
    public List<ProductDto> getMyProducts(){
        return service.findAllByUserId();
    }

    @GetMapping("/{id}")
    public ProductDto get(@PathVariable("id") long id){
        return service.findById(id);
    }

    @PostMapping
    public ProductDto add(@RequestBody SaveProductDto dto) throws ValidationException{
        return service.add(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id) throws ValidationException {
        service.deleteById(id);
    }

    @PutMapping("/{id}")
    public ProductDto update(@PathVariable("id") long id, @RequestBody SaveProductDto dto){
        return service.updateById(id, dto);
    }
}
