package com.apod.apod_api.service;

import com.apod.apod_api.dto.APOD;
import com.apod.apod_api.dto.APODItem;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class APODService {

    private List<APODItem> items;

    public APODService() {
        try {
            // Read JSON data from the file and map it to a list of Item objects
            ObjectMapper objectMapper = new ObjectMapper();
            APOD apod = objectMapper.readValue(new File("service/src/main/resources/consolidated.json"),
                    objectMapper.getTypeFactory().constructType(APOD.class));
            items = new ArrayList<>();
            items.addAll(apod.getApod());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public APODItem getItemByDate(String date) {
        for (APODItem apodItem : items) {
            if (apodItem.getDate().equals(date)) {
                return apodItem;
            }
        }
        return null;
    }
}
