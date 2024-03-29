package com.api.server.modules.user;

import com.api.server.configs.handlers.badrequest.BadRequestException;
import com.api.server.configs.handlers.notfound.NotFoundException;
import com.api.server.modules.movies.MoviesDto;
import com.api.server.modules.movies.MoviesMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    final
    UserRepository userRepository;

    final
    UserMapper userMapper;

    final
    MoviesMapper moviesMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper, MoviesMapper moviesMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.moviesMapper = moviesMapper;
    }

    @Transactional
    public UserDto createUser(UserDto userDto) {
        return userMapper.toUserDto(userRepository
                .save(userMapper.toUserModel(userDto)));
    }

    @Transactional(readOnly = true)
    public UserDto getUserByEmail(String email) {

        final Optional<User> user = userRepository.findUserByEmail(email);

        if (user.isEmpty()) {
            throw new NotFoundException(String.format("User with email: %s not found!", email));
        }

        return userMapper.toUserDto(user.get());
    }

    @Transactional(readOnly = true)
    public Set<MoviesDto> getMovies(String email) {
        return getUserByEmail(email).getMovies();
    }

    @Transactional(readOnly = true)
    public UserDto getById(Long id) {
        return userMapper.toUserDto(userRepository.findById(id).get());
    }

    @Transactional(readOnly = true)
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::toUserDto)
                .toList();
    }

    @Transactional
    public boolean deleteUser(String email) {
        UserDto user = getUserByEmail(email);

        try {
            userRepository.deleteById(user.getId());
        } catch (Exception e) {
            throw new BadRequestException(e.getMessage());
        }

        return true;
    }

    @Transactional
    public UserDto updateUser(Long id, UserDto userDto) {
        final Optional<User> user = userRepository.findById(id);

        if (user.isEmpty()) {
            throw new NotFoundException(String.format("User with email: %s not found!", id));
        }

        User savedUser = userRepository.save(User.builder()
                .id(id)
                .name(userDto.getName())
                .email(userDto.getEmail())
                .movies(user.get().getMovies())
                .build());

        return userMapper.toUserDto(savedUser);

    }
}
