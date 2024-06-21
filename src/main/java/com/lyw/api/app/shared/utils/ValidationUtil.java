package com.lyw.api.app.shared.utils;

import org.springframework.stereotype.Component;

import com.lyw.api.app.core.bicycle.domain.model.Availability;
import com.lyw.api.app.core.bicycle.domain.model.Bicycle;
import com.lyw.api.app.core.bicycle.domain.repositories.AvailabilityRepository;
import com.lyw.api.app.core.bicycle.domain.repositories.BicycleRepository;
import com.lyw.api.app.core.card.domain.model.Card;
import com.lyw.api.app.core.card.domain.repositories.CardRepository;
import com.lyw.api.app.iam.identity.domain.model.Role;
import com.lyw.api.app.iam.identity.domain.model.User;
import com.lyw.api.app.iam.identity.domain.repositories.RoleRepository;
import com.lyw.api.app.iam.identity.domain.repositories.UserRepository;
import com.lyw.api.app.shared.exceptions.ResourceNotFoundException;

import static com.lyw.api.app.shared.constants.CoreConstants.BIKER_ROLE_NAME;
import static com.lyw.api.app.shared.constants.CoreConstants.RENTER_ROLE_NAME;

@Component
public class ValidationUtil {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final CardRepository cardRepository;
    private final BicycleRepository bicycleRepository;
    private final AvailabilityRepository availabilityRepository;

    public ValidationUtil(
            UserRepository userRepository,
            RoleRepository roleRepository,
            CardRepository cardRepository,
            BicycleRepository bicycleRepository,
            AvailabilityRepository availabilityRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.cardRepository = cardRepository;
        this.bicycleRepository = bicycleRepository;
        this.availabilityRepository = availabilityRepository;
    }

    public User findUserById(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
    }

    public Role getBikerRole() {
        return roleRepository.findByName(BIKER_ROLE_NAME)
                .orElseThrow(() -> new ResourceNotFoundException("Role not found for biker"));
    }

    public Role getRenterRole() {
        return roleRepository.findByName(RENTER_ROLE_NAME)
                .orElseThrow(() -> new ResourceNotFoundException("Role not found for renter"));
    }

    public Card findCardById(Long id) {
        return cardRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Card not found with id: " + id));
    }

    public Bicycle findBicycleById(Long id) {
        return bicycleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Bicycle not found with id: " + id));
    }

    public Availability findAvailabilityById(Long id) {
        return availabilityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Availability not found with id: " + id));
    }

}
