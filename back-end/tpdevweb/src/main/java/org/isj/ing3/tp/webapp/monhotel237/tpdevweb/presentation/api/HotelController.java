package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.presentation.api;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.HotelDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities.Hotel;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.servicesImpl.HotelService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/api/hotel")
@RestController
@Slf4j
@Api("hotel")
public class HotelController {
    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping("/savehotel")
    public ResponseEntity<Void> save(@RequestBody HotelDto hotelDto) throws HotelException {
        hotelService.addData(hotelDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/gethotel/{email}")
    public ResponseEntity<Hotel> findByEmail(@PathVariable("email") String email) throws HotelException {
        Hotel hotel = hotelService.searchByEmail(email);
        return ResponseEntity.ok(hotel);
    }

    @DeleteMapping("/deletehotel/{email}")
    public ResponseEntity<Void> delete(@PathVariable("email") String email) throws HotelException {
        hotelService.deleteByEmail(email);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/updatehotel")
    public ResponseEntity<Void> update(@RequestBody HotelDto hotelDto) throws HotelException {
        hotelService.update(hotelDto);
        return ResponseEntity.ok().build();
    }
}