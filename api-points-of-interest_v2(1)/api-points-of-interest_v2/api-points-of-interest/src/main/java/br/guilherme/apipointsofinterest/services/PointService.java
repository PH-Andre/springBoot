// package br.guilherme.apipointsofinterest.services;

// import java.util.logging.Logger;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import br.guilherme.apipointsofinterest.DTOs.ReferecePointDTO;
// import br.guilherme.apipointsofinterest.controllers.PointController;
// import br.guilherme.apipointsofinterest.entities.Point;
// import br.guilherme.apipointsofinterest.exceptions.PointNotFoundException;
// import br.guilherme.apipointsofinterest.repository.PointRepository;
// import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

// import java.util.ArrayList;
// import java.util.List;

// @Service
// public class PointService {

//     @Autowired
//     private PointRepository pointRepository;

//     Logger logger = Logger.getLogger(PointService.class.getName());

//     public List<Point> findAll() {

//         var points = pointRepository.findAll();

//         points.stream().forEach(p -> p.add(linkTo(methodOn(PointController.class).findById(p.getId())).withSelfRel()));

//         return points;
//     }

//     public Point findById(Long id) {
//         var point = pointRepository.findById(id).orElseThrow(
//                 () -> new PointNotFoundException());

//         point.add(linkTo(methodOn(PointController.class).findById(id)).withSelfRel());

//         return point;
//     }

//     public Point create(Point point) {

//         return pointRepository.save(point);
//     }

//     public List<Point> findPointsWithinDistance(ReferecePointDTO referecePointDTO) {

//         logger.info(referecePointDTO.toString());

//         var neighbors = new ArrayList<Point>();

//         var allPoints = this.findAll();

//         for (Point point : allPoints) {
//             if (calculateDistanceBetweenPoints(referecePointDTO.getX(), point.getX(), referecePointDTO.getY(),
//                     point.getY()) <= referecePointDTO.getDMax()) {
//                 neighbors.add(point);
//             }
//         }
//         return neighbors;
//     }

//     private double calculateDistanceBetweenPoints(double x1, double x2, double y1, double y2) {
//         double deltaX = x1 - x2;
//         double deltaY = y1 - y2;
//         return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
//     }

// }
