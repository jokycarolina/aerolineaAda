package com.aerolinea.aerolinea.controller;


import com.aerolinea.aerolinea.model.*;
import com.aerolinea.aerolinea.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/aerolinea/ada/v1/")
public class MainController {

    @Autowired
    
    private BaseRepository baseRepository;

    @Autowired
    private AirplaneRepository airplaneRepository;

    @Autowired
    private PilotRepository pilotRepository;

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private CrewRepository crewRepository;

    @GetMapping(path = "base/all")
    @ResponseBody
    Iterable<Base> getAll(){
        return baseRepository.findAll();
    }

    @GetMapping(path= "airplane/all")
    @ResponseBody
    Iterable<Airplane> getAirplaneAll(){
        return airplaneRepository.findAll();
    }

    @GetMapping(path= "pilot/all")
    @ResponseBody
    Iterable<Pilot> getAllPilot(){
        return pilotRepository.findAll();
    }

    @GetMapping(path= "flight/all")
    @ResponseBody
    Iterable<Flight> getAllFlight(){
        return flightRepository.findAll();
    }

    @GetMapping(path= "crew/all")
    @ResponseBody
    Iterable<Crew> getAllCrew(){
        return crewRepository.findAll();
    }


    @GetMapping(path="base/{id}")
    @ResponseBody
    Optional<Base> getBase(@PathVariable("id") int id){
        Optional<Base> base = baseRepository.findById(id);
        return base;
    }

    @GetMapping(path="flight/{id}")
    @ResponseBody
    Optional<Flight> getFlight(@PathVariable("id") int id){
        Optional<Flight> flight = flightRepository.findById(id);
        return flight;
    }

    @GetMapping(path="airplane/{id}")
    @ResponseBody
    Optional<Airplane> getAirplane(@PathVariable("id") int id){
        Optional<Airplane> airplane = airplaneRepository.findById(id);
        return airplane;
    }

    @GetMapping(path="pilot/{id}")
    @ResponseBody
    Optional<Pilot> getPilot(@PathVariable("id") int id){
        Optional<Pilot> pilot = pilotRepository.findById(id);
        return pilot;
    }

    @GetMapping(path="crew/{id}")
    @ResponseBody
    Optional<Crew> getCrew(@PathVariable("id") int id){
        Optional<Crew> crew = crewRepository.findById(id);
        return crew;
    }

    @PostMapping(path ="base/create",consumes = "application/json", produces = "application/json")
    public Base createBase(@RequestBody Base base){
        return baseRepository.save(base);
    }

    @PostMapping(path ="airplane/create",consumes = "application/json", produces = "application/json")
    public Airplane createAirplane(@RequestBody Airplane airplane){
        return airplaneRepository.save(airplane);
    }

    @PostMapping(path ="pilot/create",consumes = "application/json", produces = "application/json")
    public Pilot createPilot(@RequestBody Pilot pilot){
        return pilotRepository.save(pilot);
    }

    @PostMapping(path ="flight/create",consumes = "application/json", produces = "application/json")
    public Flight createFlight(@RequestBody Flight flight){
        return flightRepository.save(flight);
    }

    @PostMapping(path ="crew/create",consumes = "application/json", produces = "application/json")
    public Crew createCrew(@RequestBody Crew crew){
        return crewRepository.save(crew);
    }

    @PutMapping(path ="base/update",consumes = "application/json", produces = "application/json")
    public Base updateBase(@RequestBody Base base){
        return baseRepository.save(base);
    }

    @PutMapping(path ="pilot/update",consumes = "application/json", produces = "application/json")
    public Pilot updatePilot(@RequestBody Pilot pilot){
        return pilotRepository.save(pilot);
    }

    @PutMapping(path ="flight/update",consumes = "application/json", produces = "application/json")
    public Flight updateFlight(@RequestBody Flight flight){
        return flightRepository.save(flight);
    }

    @PutMapping(path ="crew/update",consumes = "application/json", produces = "application/json")
    public Crew updateCrew(@RequestBody Crew crew){
        return crewRepository.save(crew);
    }

    @PutMapping(path ="airplane/update",consumes = "application/json", produces = "application/json")
    public Airplane updateAirplane(@RequestBody Airplane airplane){
        return airplaneRepository.save(airplane);
    }

    @PutMapping(path ="pilot/{id}/update/base/{id_base}",consumes = "application/json", produces = "application/json")
    public Pilot updateBasePilot(@PathVariable("id") int id,@PathVariable("id_base") int idBase){
        Pilot pilot = pilotRepository.findById(id).get();
        Base base = baseRepository.findById(idBase).get();

        pilot.setBase_code(base);
        pilotRepository.save(pilot);
        return pilot ;
    }

    @PutMapping(path ="airplane/{id}/update/base/{id_base}",consumes = "application/json", produces = "application/json")
    public Airplane updateBaseAirplane(@PathVariable("id") int id,@PathVariable("id_base") int idBase){
        Airplane airplane = airplaneRepository.findById(id).get();
        Base base = baseRepository.findById(idBase).get();

        airplane.setBase_code(base);
        airplaneRepository.save(airplane);
        return airplane ;
    }

    @PutMapping(path ="flight/{id}/update/pilot/{id_pilot}",consumes = "application/json", produces = "application/json")
    public Flight updatePilotFlight(@PathVariable("id") int id,@PathVariable("id_pilot") int idPilot){

        Flight flight = flightRepository.findById(id).get();
        Pilot pilot = pilotRepository.findById(idPilot).get();

        flight.setPilot(pilot);
        flightRepository.save(flight);
        return flight ;
    }

    @PutMapping(path ="flight/{id}/update/airplane/{id_airplane}",consumes = "application/json", produces = "application/json")
    public Flight updateAirplaneFlight(@PathVariable("id") int id,@PathVariable("id_airplane") int idAirplane){

        Flight flight = flightRepository.findById(id).get();
        Airplane airplane = airplaneRepository.findById(idAirplane).get();

        flight.setAirplane(airplane);
        flightRepository.save(flight);
        return flight ;
    }

    @PutMapping(path ="crew/{id}/update/base/{id_base}",consumes = "application/json", produces = "application/json")
    public Crew updateBaseCrew(@PathVariable("id") int id,@PathVariable("id_base") int idBase){
        Crew crew = crewRepository.findById(id).get();
        Base base = baseRepository.findById(idBase).get();

        crew.setBase_code(base);
        crewRepository.save(crew);
        return crew;
    }

    @DeleteMapping(path="base/delete/{id}")
    @ResponseBody
    Iterable<Base> deleteBaseById(@PathVariable("id") int id){
        baseRepository.deleteById(id);
        return baseRepository.findAll();
    }

    @DeleteMapping(path="airplane/delete/{id}")
    @ResponseBody
    Iterable<Airplane> deleteAirplaneById(@PathVariable("id") int id){
        airplaneRepository.deleteById(id);
        return airplaneRepository.findAll();
    }

    @DeleteMapping(path="pilot/delete/{id}")
    @ResponseBody
    Iterable<Pilot> deletePilotById(@PathVariable("id") int id){
        pilotRepository.deleteById(id);
        return pilotRepository.findAll();
    }

    @DeleteMapping(path="flight/delete/{id}")
    @ResponseBody
    Iterable<Flight> deleteFlightById(@PathVariable("id") int id){
        flightRepository.deleteById(id);
        return flightRepository.findAll();
    }

    @DeleteMapping(path="crew/delete/{id}")
    @ResponseBody
    Iterable<Crew> deleteCrewById(@PathVariable("id") int id){
        crewRepository.deleteById(id);
        return crewRepository.findAll();
    }

     ///custom queries///

    @GetMapping(path="base/city/like/{city}")
    @ResponseBody
    Iterable<Base> getBaseByCityLike(@PathVariable("city") String city){
        return baseRepository.getBaseByCityLike(city);
    }

    @GetMapping(path="crew/name/like/{name}")
    @ResponseBody
    Iterable<Crew> getCrewByNameLike(@PathVariable("name") String name){
        return crewRepository.getCrewByNameLike(name);    }

    @GetMapping(path="crew/name/basecode/{id}")
    @ResponseBody
    Iterable<Crew> getCrewByBasecode(@PathVariable("id") int idBase_code){
        return crewRepository.getCrewByBaseCode(idBase_code);    }
}
