package spaceStation.models.mission;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.planets.Planet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MissionImpl implements Mission {


    @Override
    public void explore(Planet planet, Collection<Astronaut> astronauts) {
        List<String> items = new ArrayList<>(planet.getItems());
        if (astronauts.stream().allMatch(a -> a.getOxygen() > 0)) {
            for (Astronaut astronaut : astronauts) {
                if (planet.getItems().isEmpty()) {
                    return;
                }
                for (int i = 0; i < items.size(); i++) {
                    astronaut.getBag().getItems().add(items.get(i));
                    planet.getItems().remove(items.get(i));
                    astronaut.breath();
                    items.remove(items.get(i));
                    i--;
                    if (!astronaut.canBreath()) {
                        break;
                    }
                    if (planet.getItems().isEmpty()) {
                        break;
                    }
                }
            }
        }

    }
}
