package com.lti.flipfit.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.lti.flipfit.beans.Booking;
import com.lti.flipfit.services.GymCustomerService;
/**
 * @author Mayuresh Arvind Gujar
 */
@RestController
@RequestMapping("/api/v1")
public class GymCustomerController {

    private final GymCustomerService gymCustomerService;

    public GymCustomerController(GymCustomerService gymCustomerService) {
        this.gymCustomerService = gymCustomerService;
    }

    @GetMapping("/bookings")
    public ResponseEntity<List<Booking>> viewBookings() {
        return ResponseEntity.ok(gymCustomerService.viewBookings());
    }

    @PostMapping("/cancel/{bookingId}")
    public ResponseEntity<Booking> cancelBooking(@PathVariable Long bookingId) {
        return ResponseEntity.ok(gymCustomerService.cancelBooking(bookingId));
    }

    @GetMapping("/booking/{bookingId}")
    public ResponseEntity<Booking> getBookingDetails(@PathVariable Long bookingId) {
        return ResponseEntity.ok(gymCustomerService.getBookingDetails(bookingId));
    }

    @PostMapping("/book/slot")
    public ResponseEntity<Booking> bookSlot(@RequestBody Booking booking) {
        return ResponseEntity.ok(gymCustomerService.bookSlot(booking));
    }
}