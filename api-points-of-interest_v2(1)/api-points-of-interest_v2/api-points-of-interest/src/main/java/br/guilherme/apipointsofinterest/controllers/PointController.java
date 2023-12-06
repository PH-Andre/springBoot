package br.guilherme.apipointsofinterest.controllers;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import br.guilherme.apipointsofinterest.DTOs.PointDTO;


import br.guilherme.apipointsofinterest.DTOs.ReferecePointDTO;
//import br.guilherme.apipointsofinterest.entities.Point;
//import br.guilherme.apipointsofinterest.services.PointService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

@RestController
@RequestMapping("api/v1/point")
@Validated
public class PointController {

    // Logger logger = Logger.getLogger(PointController.class.getName());

    // @Autowired
    // private PointService pointService;

    // @GetMapping("")
    // public ResponseEntity<List<Point>> getPoints() {
    //     logger.info("Getting points");

    //     var points = pointService.findAll();

    //     return ResponseEntity.ok().body(points);
    // }

    // @GetMapping("/{id}")
    // public ResponseEntity<Point> findById(@PathVariable("id") @Min(1) Long id) {
    //     logger.info("Getting point");

    //     var point = pointService.findById(id);

    //     return ResponseEntity.ok().body(point);
    // }

    // @GetMapping("/neighbors")
    // public ResponseEntity<List<Point>> findPointsWithinDistance(@RequestBody ReferecePointDTO referecePointDTO) {

    //     logger.info("Getting neighbors");

    //     return ResponseEntity.ok().body(pointService.findPointsWithinDistance(referecePointDTO));
    // }

    // @PostMapping("/")
    // public ResponseEntity<Point> createPoint(@Valid @RequestBody PointDTO pointDTO) {
    //     logger.info("Creating point");
    //     logger.info(pointDTO.toString());

    //     var createdPoint = pointService.create(Point.convert(pointDTO));

    //     return ResponseEntity.created(null).body(createdPoint);
    // }

    // @ResponseStatus(HttpStatus.BAD_REQUEST)
    // @ExceptionHandler(MethodArgumentNotValidException.class)
    // public Map<String, String> handleValidationExceptions(
    //         MethodArgumentNotValidException ex) {
    //     Map<String, String> errors = new HashMap<>();
    //     ex.getBindingResult().getAllErrors().forEach((error) -> {
    //         String fieldName = ((FieldError) error).getField();
    //         String errorMessage = error.getDefaultMessage();
    //         errors.put(fieldName, errorMessage);
    //     });
    //     return errors;
    // }
}
