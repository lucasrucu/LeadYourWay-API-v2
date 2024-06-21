package com.lyw.api.app.iam.identity.application.implementation;

import org.springframework.stereotype.Service;

import com.lyw.api.app.iam.identity.application.services.UserQueryService;
import com.lyw.api.app.iam.identity.domain.model.User;
import com.lyw.api.app.iam.identity.domain.queries.GetUserByIdQuery;
import com.lyw.api.app.iam.identity.domain.repositories.UserRepository;
import com.lyw.api.app.shared.exceptions.ResourceNotFoundException;

@Service
public class UserQueryServiceImpl implements UserQueryService {

    private final UserRepository userRepository;

    public UserQueryServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User handle(GetUserByIdQuery query) {
        return userRepository.findById(query.id())
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + query.id()));
    }
}
