package spring_boot.point_of_interest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import spring_boot.point_of_interest.dto.NearPOIRequest;
import spring_boot.point_of_interest.dto.PoiDTO;
import spring_boot.point_of_interest.model.POI;
import spring_boot.point_of_interest.repository.POIRepository;

@Service
@RequiredArgsConstructor
public class POIService {
    
    private final POIRepository poiRepository;

    public POI create(PoiDTO request) {
        POI newPOI = new POI();
        newPOI.setName(request.name());
        newPOI.setXCoord(request.xCoord());
        newPOI.setYCoord(request.yCoord());
        return poiRepository.save(newPOI);
    }

    public List<POI> getAll() {
        return poiRepository.findAll();
    }

    public List<POI> getByProximity(NearPOIRequest request) {
        List<POI> pois = getAll();
        List<POI> nearPois = new ArrayList<>();

        for (POI p : pois) {
            double x = p.getXCoord();
            double y = p.getYCoord();

            double distance = Math.hypot(x - request.xCoord(), y - request.yCoord());

            if (distance <= request.maxDistance()) {
                nearPois.add(p);
            }
        }

        return nearPois;
    }
}
