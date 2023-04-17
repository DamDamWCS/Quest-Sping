package com.wildcodeschool.doctor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import com.wildcodeschool.doctor.model.Doctor;

@Controller
public class DoctorController {

    @GetMapping("/doctor/{number}")
    @ResponseBody

    public Doctor doctor(@PathVariable int number) {
        if (number >= 1 && number <= 12) {
            throw new ResponseStatusException(HttpStatus.SEE_OTHER);
        } else if (number == 13) {
            return new Doctor(13, "Jodie Whittaker");
        }

        else {
            String errorMessage = "Impossible de récupérer l'incarnation " + number + ".";
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, errorMessage);
        }

    }
}
