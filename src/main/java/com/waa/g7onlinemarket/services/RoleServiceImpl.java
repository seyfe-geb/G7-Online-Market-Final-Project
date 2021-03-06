package com.waa.g7onlinemarket.services;


import com.waa.g7onlinemarket.models.Role;
import com.waa.g7onlinemarket.models.dto.RoleDto;
import com.waa.g7onlinemarket.repositories.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ValidationException;
import java.util.List;
import java.util.stream.Collectors;

@Service @RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository repository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<RoleDto> findAll() {
        return repository.findAll().stream()
                .map(u -> modelMapper.map(u, RoleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public RoleDto findById(long id) {
        return modelMapper.map(repository.findById(id).orElse(null), RoleDto.class);
    }

    @Transactional
    @Override
    public RoleDto add(RoleDto dto) {
        if (repository.existsByAuthority(dto.getAuthority()))
            throw new ValidationException("Role exists!");

        Role role = repository.save(modelMapper.map(dto, Role.class));
        role = repository.save(role);

        return  modelMapper.map(role, RoleDto.class);
    }

    @Override
    public RoleDto updateById(long id, RoleDto dto) {
        dto.setId(id);
        return modelMapper.map(repository.save(modelMapper.map(dto, Role.class)), RoleDto.class);
    }

    @Override
    public void deleteById(long id) { repository.deleteById(id); }

    @Override
    public boolean existsByAuthority(String name) {
        return repository.existsByAuthority(name);
    }
}
