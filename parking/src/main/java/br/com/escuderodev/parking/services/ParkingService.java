package br.com.escuderodev.parking.services;

import br.com.escuderodev.parking.models.parking.ParkingListData;
import br.com.escuderodev.parking.models.parking.ParkingManagement;
import br.com.escuderodev.parking.models.parking.ParkingRegistrationData;
import br.com.escuderodev.parking.models.parking.ParkingRepository;
import br.com.escuderodev.parking.models.vehicle.Vehicle;
import br.com.escuderodev.parking.models.vehicle.VehicleRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ParkingService {
    private ParkingRepository parkingRepository;
    private VehicleRepository vehicleRepository;

    public ParkingService(ParkingRepository parkingRepository, VehicleRepository vehicleRepository) {
        this.parkingRepository = parkingRepository;
        this.vehicleRepository = vehicleRepository;
    }

    public Page<ParkingListData> findAll(@PageableDefault(size = 10, page = 0, sort = {"id"}) Pageable pagination) {
        return parkingRepository.findAll(pagination).map(ParkingListData::new);
    }

    public Optional<ParkingManagement> findById(Long id) {
        return parkingRepository.findById(id);
    }

    public ParkingManagement create(ParkingRegistrationData data, Long id) {
        var typedVehicle = vehicleRepository.getReferenceById(id);
        var parking = new ParkingManagement(typedVehicle, data);
        return parkingRepository.save(parking);
    }

    public ParkingManagement update(Long id) {
        var typedParking = parkingRepository.getReferenceById(id);
        typedParking.stopParking();
        return typedParking;
    }

    public void delete(Long id) {
        parkingRepository.deleteById(id);
    }
}
