package spaceStation.core;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.astronauts.Biologist;
import spaceStation.models.astronauts.Geodesist;
import spaceStation.models.astronauts.Meteorologist;
import spaceStation.models.mission.Mission;
import spaceStation.models.mission.MissionImpl;
import spaceStation.models.planets.Planet;
import spaceStation.models.planets.PlanetImpl;
import spaceStation.repositories.AstronautRepository;
import spaceStation.repositories.PlanetRepository;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static spaceStation.common.ConstantMessages.*;
import static spaceStation.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {


    private AstronautRepository astronautList;
    private PlanetRepository planetRepository;
    private Mission mission;
    private int count;


    public ControllerImpl() {
        this.astronautList = new AstronautRepository();
        this.planetRepository = new PlanetRepository();
        this.mission = new MissionImpl();
    }

    @Override
    public String addAstronaut(String type, String astronautName) {
        Astronaut astronaut;
        switch (type) {
            case "Biologist":
                astronaut = new Biologist(astronautName);
                break;
            case "Geodesist":
                astronaut = new Geodesist(astronautName);
                break;
            case "Meteorologist":
                astronaut = new Meteorologist(astronautName);
                break;
            default:
                throw new IllegalArgumentException(ASTRONAUT_INVALID_TYPE);
        }
        astronautList.add(astronaut);
        return String.format(ASTRONAUT_ADDED, type, astronautName);
    }

    @Override
    public String addPlanet(String planetName, String... items) {
        Planet planet = new PlanetImpl(planetName);
        for (String item : items) {
            if (!item.equals(planetName)) {

                planet.getItems().add(item);
            }
        }
        planetRepository.add(planet);
        return String.format(PLANET_ADDED, planetName);
    }

    @Override
    public String retireAstronaut(String astronautName) {
        Astronaut astronaut = null;
        for (Astronaut astronaut1 : astronautList.getModels()) {
            if (astronaut1.getName().equals(astronautName)) {
                astronaut = astronaut1;
            }
        }
        if (astronaut == null) {
            throw new IllegalArgumentException(String.format(ASTRONAUT_DOES_NOT_EXIST, astronautName));
        }
        String name = astronaut.getName();
        astronautList.remove(astronaut);
        return String.format(ASTRONAUT_RETIRED, name);
    }

    @Override
    public String explorePlanet(String planetName) {
        Planet byName = planetRepository.findByName(planetName);
        List<Astronaut> collect = astronautList.getModels()
                .stream()
                .filter(a -> a.getOxygen() > 60)
                .collect(Collectors.toList());
        if (collect.isEmpty()) {
            throw new IllegalArgumentException(PLANET_ASTRONAUTS_DOES_NOT_EXISTS);
        }
        mission.explore(byName, collect);
        count++;
        List<Astronaut> collect1 = astronautList.getModels()
                .stream()
                .filter(a -> !a.canBreath())
                .collect(Collectors.toList());
        return String.format(PLANET_EXPLORED, planetName, collect1.size());
    }

    @Override
    public String report() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format(REPORT_PLANET_EXPLORED, count)).append(System.lineSeparator());
        stringBuilder.append(REPORT_ASTRONAUT_INFO).append(System.lineSeparator());
        for (Astronaut model : astronautList.getModels()) {
            stringBuilder.append(String.format(REPORT_ASTRONAUT_NAME, model.getName()))
                    .append(System.lineSeparator());
            stringBuilder.append(String.format(REPORT_ASTRONAUT_OXYGEN, model.getOxygen()))
                    .append(System.lineSeparator());
            if (model.getBag().getItems().isEmpty()) {
                stringBuilder.append(String.format(REPORT_ASTRONAUT_BAG_ITEMS, "none")).append(System.lineSeparator());
                continue;
            } else {

                stringBuilder.append(String.format(REPORT_ASTRONAUT_BAG_ITEMS,
                                model.getBag().getItems().stream().collect(Collectors.joining(REPORT_ASTRONAUT_BAG_ITEMS_DELIMITER))))
                        .append(System.lineSeparator());

            }
        }


        return stringBuilder.toString().trim();
    }
}
