package com.yesidl.hotel.services;
import org.springframework.stereotype.Service;

import com.yesidl.hotel.repositories.HuespedesRepostory;
import com.yesidl.hotel.repositories.HabitacionesRepository;
import com.yesidl.hotel.repositories.ReservasRepository;

@Service
public class CheckInServices {
    private final ReservasRepository reservasRepository;
    private final HuespedesRepostory huespedesRepostory;
    private final HabitacionesRepository habitacionesRepository;
    
    public CheckInServices(ReservasRepository reservasRepository, HuespedesRepostory huespedesRepostory, HabitacionesRepository habitacionesRepository) {
        this.reservasRepository = reservasRepository;
        this.huespedesRepostory = huespedesRepostory;
        this.habitacionesRepository = habitacionesRepository;
    }
    
    public void checkIn() {
        // Crear el usuario
        // Asignar la habitacion
        // Actualizar el estado de la habitacion
        // Establecer fecha de check-in

    }
}
