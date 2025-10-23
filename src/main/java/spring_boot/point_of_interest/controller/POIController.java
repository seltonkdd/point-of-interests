package spring_boot.point_of_interest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import spring_boot.point_of_interest.dto.NearPOIRequest;
import spring_boot.point_of_interest.dto.PoiDTO;
import spring_boot.point_of_interest.model.POI;
import spring_boot.point_of_interest.service.POIService;
import org.springframework.web.bind.annotation.GetMapping;


@RequiredArgsConstructor
@RestController
@RequestMapping("/point-of-interests")
public class POIController {
    
    private final POIService poiService;

    @PostMapping
    public ResponseEntity<PoiDTO> create(@RequestBody @Valid PoiDTO request) {
        POI poi = poiService.create(request);
        PoiDTO poiResponse = new PoiDTO(poi.getName(), poi.getXCoord(), poi.getYCoord());
        return ResponseEntity.status(HttpStatus.CREATED).body(poiResponse);
    }

    @GetMapping
    public ResponseEntity<List<PoiDTO>> getAll() {
        List<POI> pois = poiService.getAll();
        List<PoiDTO> poisResponse = new ArrayList<>();

        pois.forEach(p -> poisResponse.add(new PoiDTO(p.getName(), p.getXCoord(), p.getYCoord())));
        return ResponseEntity.ok(poisResponse);
    }
    
    @PostMapping("/proximity")
    public ResponseEntity<List<PoiDTO>> getByProximity(@RequestBody @Valid NearPOIRequest request) {
        List<POI> pois = poiService.getByProximity(request);
        List<PoiDTO> poisResponse = new ArrayList<>();

        pois.forEach(p -> poisResponse.add(new PoiDTO(p.getName(), p.getXCoord(), p.getYCoord())));

        return ResponseEntity.ok(poisResponse);
    }
    

}
