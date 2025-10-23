package spring_boot.point_of_interest.dto;

import jakarta.validation.constraints.Positive;

public record NearPOIRequest(Double maxDistance, @Positive Double xCoord, @Positive Double yCoord) {
    
}
