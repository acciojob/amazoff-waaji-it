package com.driver;


import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Base64;

@Service
public class DeliveryPartnerManagementService {
    private final Order orderRepository;
    private final DeliveryPartner deliveryPartnerRepository;

    public DeliveryPartnerManagementService(Order orderRepository, DeliveryPartner deliveryPartnerRepository) {
        this.orderRepository = orderRepository;
        this.deliveryPartnerRepository = deliveryPartnerRepository;
    }

    public static LocalDateTime getLastDeliveryTimeByPartnerId(String partnerId) {
        String encodedTime = DeliveryPartnerManagementService.getEncodedLastDeliveryTime(partnerId);
        // retrieve the encoded time from the DeliveryPartnerManagementService

        byte[] decodedBytes = Base64.getDecoder().decode(encodedTime);
        String decodedString = new String(decodedBytes, StandardCharsets.UTF_8);

        return LocalDateTime.parse(decodedString);
    }

    private static String getEncodedLastDeliveryTime(String partnerId) {
        LocalDateTime lastDeliveryTime = DeliveryPartnerManagementService.getLastDeliveryTimeByPartnerId(partnerId);

        // Encode the last delivery time using Base64 encoding
        String encodedTime = Base64.getEncoder().encodeToString(lastDeliveryTime.toString().getBytes());

        return encodedTime;
    }
}
