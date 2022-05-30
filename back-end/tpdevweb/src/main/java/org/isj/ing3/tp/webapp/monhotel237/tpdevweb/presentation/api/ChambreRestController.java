package org.isj.ing3.tp.webapp.monhotel237.tpdevweb.presentation.api;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.HotelException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.exception.ResourceNotFoundException;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.model.dto.ChambreDto;
import org.isj.ing3.tp.webapp.monhotel237.tpdevweb.service.IChambre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/chambre")
@RestController
@Slf4j
@Api("chambre")
public class ChambreRestController {

    @Autowired
    private IChambre iChambre;

    @PostMapping("/saveroom")
    public ResponseEntity<Void> save(@RequestBody ChambreDto chambreDto) throws HotelException {
        iChambre.addData(chambreDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/findroom/{numero}")
    public ResponseEntity<ChambreDto> findByNumber(@PathVariable("numero") Integer numero) throws HotelException {
        ChambreDto chambre = iChambre.searchChambreByNumberDto(numero);
        return ResponseEntity.ok(chambre);
    }

    @DeleteMapping("/deleteroom/{numero}")
    public ResponseEntity<Void> delete(@PathVariable("numero") Integer numero) throws HotelException {
        Optional.ofNullable(iChambre.searchChambreByNumber(numero)).orElseThrow(() -> {
            log.error("Unable to delete non-existent data！");
            return new ResourceNotFoundException("Unable to delete non-existent data！");
        });
        iChambre.deleteByNumber(numero);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/updateroom")
    public ResponseEntity<Void> update(@RequestBody ChambreDto chambreDto) throws HotelException {
        iChambre.update(chambreDto);
        return ResponseEntity.ok().build();
    }

   /* @PostMapping("/rechercherroom/{keyword}")
    public ResponseEntity<ChambreDto> findChambreByKeyword(@PathVariable("keyword") String keyword) {
        List<ChambreDto> chambre = iChambre.searchChambresByKeyword(keyword);
        return ResponseEntity.ok(chambre);
    }*/

}