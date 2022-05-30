package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.presentation.api;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.HotelDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.entities.Hotel;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.service.IHotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/hotel")
@RestController
@Slf4j
@Api("hotel")
public class HotelRestController {
    @Autowired
    private IHotel iHotel;

    @PostMapping("/savehotel")
    public ResponseEntity<Void> save(@RequestBody HotelDto hotelDto) throws HotelException {
        iHotel.addData(hotelDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/gethotel/{email}")
    public ResponseEntity<Hotel> findByEmail(@PathVariable("email") String email) throws HotelException {
        Hotel hotel = iHotel.searchByEmail(email);
        return ResponseEntity.ok(hotel);
    }

    @DeleteMapping("/deletehotel/{email}")
    public ResponseEntity<Void> delete(@PathVariable("email") String email) throws HotelException {
        iHotel.deleteByEmail(email);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/updatehotel")
    public ResponseEntity<Void> update(@RequestBody HotelDto hotelDto) throws HotelException {
        iHotel.update(hotelDto);
        return ResponseEntity.ok().build();
    }
}