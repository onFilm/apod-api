package com.apod.apod_api.controller;

import com.apod.apod_api.dto.APODItem;
import com.apod.apod_api.service.APODService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/apod")
public class APODController {

    private final APODService apodService;

    @Autowired
    public APODController(APODService apodService) {
        this.apodService = apodService;
    }

    @GetMapping("/{date}")
    public APODItem getItemByDate(@PathVariable("date") String date) {
        return apodService.getItemByDate(date);
    }
}
