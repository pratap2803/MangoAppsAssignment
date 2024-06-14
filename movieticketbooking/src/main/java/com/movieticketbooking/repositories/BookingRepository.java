package com.movieticketbooking.repositories;

import com.movieticketbooking.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    // Add custom query methods if necessary
}

