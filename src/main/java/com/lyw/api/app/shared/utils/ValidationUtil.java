package com.lyw.api.app.shared.utils;

import org.springframework.stereotype.Component;

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
    // private final AgencyRepository agencyRepository;
    // private final TouristRepository touristRepository;
    // private final ActivityRepository activityRepository;
    // private final DepartmentRepository departmentRepository;
    // private final DestinationRepository destinationRepository;
    // private final RegionRepository regionRepository;
    // private final ScheduleRepository scheduleRepository;
    // private final TourPackageRepository tourPackageRepository;
    // private final VehicleRepository vehicleRepository;

    public ValidationUtil(
            UserRepository userRepository,
            RoleRepository roleRepository,
            CardRepository cardRepository
    // AgencyRepository agencyRepository,
    // TouristRepository touristRepository,
    // ActivityRepository activityRepository,
    // DepartmentRepository departmentRepository,
    // DestinationRepository destinationRepository,
    // RegionRepository regionRepository,
    // ScheduleRepository scheduleRepository,
    // TourPackageRepository tourPackageRepository,
    // VehicleRepository vehicleRepository,
    ) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.cardRepository = cardRepository;
        // this.agencyRepository = agencyRepository;
        // this.touristRepository = touristRepository;
        // this.activityRepository = activityRepository;
        // this.departmentRepository = departmentRepository;
        // this.destinationRepository = destinationRepository;
        // this.regionRepository = regionRepository;
        // this.scheduleRepository = scheduleRepository;
        // this.tourPackageRepository = tourPackageRepository;
        // this.vehicleRepository = vehicleRepository;
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

    // public Vehicle findVehicleById(Long id) {
    // return vehicleRepository.findById(id)
    // .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found with id:
    // " + id));
    // }

    // public Agency findAgencyById(Long id) {
    // return agencyRepository.findById(id)
    // .orElseThrow(() -> new ResourceNotFoundException("Agency not found with id: "
    // + id));
    // }

    // public Tourist findTouristById(Long id) {
    // return touristRepository.findById(id)
    // .orElseThrow(() -> new ResourceNotFoundException("Tourist not found with id:
    // " + id));
    // }

    // public Agency findAgencyByUserId(String id) {
    // return agencyRepository.findByUserId(id)
    // .orElseThrow(() -> new ResourceNotFoundException("Agency not found with user
    // id: " + id));
    // }

    // public Tourist findTouristByUserId(String id) {
    // return touristRepository.findByUserId(id)
    // .orElseThrow(() -> new ResourceNotFoundException("Tourist not found with user
    // id: " + id));
    // }

    // public Activity findActivityById(Long id) {
    // return activityRepository.findById(id)
    // .orElseThrow(() -> new ResourceNotFoundException("Activity not found with id:
    // " + id));
    // }

    // public Department findDepartmentById(Long id) {
    // return departmentRepository.findById(id)
    // .orElseThrow(() -> new ResourceNotFoundException("Department not found with
    // id: " + id));
    // }

    // public Department findDepartmentByName(String name) {
    // return departmentRepository.findByName(name)
    // .orElseThrow(() -> new ResourceNotFoundException("Department not found with
    // name: " + name));
    // }

    // public Destination findDestinationById(Long id) {
    // return destinationRepository.findById(id).orElse(new Destination());
    // }

    // public Region findRegionById(Long id) {
    // return regionRepository.findById(id)
    // .orElseThrow(() -> new ResourceNotFoundException("Region not found with id: "
    // + id));
    // }

    // public Schedule findTourExperienceById(Long id) {
    // return scheduleRepository.findById(id)
    // .orElseThrow(() -> new ResourceNotFoundException("TourExperience not found
    // with id: " + id));
    // }

    // public TourPackage findTourPackageById(Long id) {
    // return tourPackageRepository.findById(id)
    // .orElseThrow(() -> new ResourceNotFoundException("TourPackage not found with
    // id: " + id));
    // }

}
