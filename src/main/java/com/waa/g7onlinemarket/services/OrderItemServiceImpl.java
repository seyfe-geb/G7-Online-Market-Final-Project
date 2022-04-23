package com.waa.g7onlinemarket.services;


import com.waa.g7onlinemarket.models.OrderItem;
import com.waa.g7onlinemarket.models.Product;
import com.waa.g7onlinemarket.models.dto.OrderItemDto;
import com.waa.g7onlinemarket.models.dto.SaveOrderItemDto;
import com.waa.g7onlinemarket.repositories.OrderItemRepository;
import com.waa.g7onlinemarket.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ValidationException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderItemServiceImpl implements OrderItemService{

    private final OrderItemRepository repository;
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<OrderItemDto> findAll() {
        return repository.findAll().stream()
                .map(o -> modelMapper.map(o, OrderItemDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public OrderItemDto findById(long id) {
        return modelMapper.map(repository.findById(id).orElse(null), OrderItemDto.class);
    }

    @Override
    @Transactional
    public SaveOrderItemDto add(SaveOrderItemDto dto) {
        OrderItem orderItem = modelMapper.map(dto, OrderItem.class);
        Product product = productRepository.getById(dto.getProductId());

        if(dto.getQuantity() == 0)
            dto.setQuantity(1);

        if(dto.getQuantity() > product.getQuantity())
            throw new ValidationException("Out of stock item ' " + product.getName() + "" +
                    "' avaliable quantity: '" + product.getQuantity()
                    + "' required quantity: '" + dto.getQuantity() + "'");

        orderItem.setPrice(product.getPrice() * dto.getQuantity());
        product.setQuantity(product.getQuantity() - dto.getQuantity());

        orderItem = repository.save(orderItem);
        productRepository.save(product);

        return modelMapper.map(orderItem , SaveOrderItemDto.class);
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }
}
