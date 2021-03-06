package com.clients.pharmacy.service;

import com.clients.pharmacy.entity.Family;
import com.clients.pharmacy.entity.User;
import com.clients.pharmacy.entity.dto.UserRequestDto;
import com.clients.pharmacy.entity.dto.UserResponseDto;
import com.clients.pharmacy.repository.FamilyRepository;
import com.clients.pharmacy.repository.UserRepository;
import com.clients.pharmacy.service.mapper.UserMapper;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final FamilyRepository familyRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           FamilyRepository familyRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.familyRepository = familyRepository;
        this.userMapper = userMapper;
    }

    @Override
    @Transactional
    public User add(UserRequestDto userRequestDto) {
        User user = userMapper.mapToModel(userRequestDto);
        Optional<Family> familyFromDB = Optional
                .ofNullable(familyRepository.findBySurname(user.getLastName()));
        if (user.isMarried()) {
            if (familyFromDB.isPresent()
                    && familyFromDB.get().getSurname().equals(user.getLastName())) {
                user.setFamily(familyFromDB.get());
            } else {
                Family family = new Family();
                family.setSurname(user.getLastName());
                user.setFamily(family);
                family.setMembers(List.of(user));
                familyRepository.save(family);
            }
        }
        return userRepository.save(user);
    }

    @Override
    public List<UserResponseDto> getAll() {
        return userRepository.findAll().stream()
                .map(userMapper::mapToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponseDto get(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Can't find user by id: " + id));
        return userMapper.mapToResponseDto(user);
    }

    @Override
    public void update(Long id, UserRequestDto userRequestDto) {
        User userById = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Can't find user by id: " + id));
        User userFromDto = userMapper.mapToModel(userRequestDto);
        userFromDto.setId(userById.getId());
        userRepository.save(userFromDto);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<UserResponseDto> findByName(String name) {
        return userRepository.findByFirstName(name).stream()
                .map(userMapper::mapToResponseDto)
                .collect(Collectors.toList());
    }
}
