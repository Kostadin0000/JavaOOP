package restaurant;

import restaurant.core.ControllerImpl;
import restaurant.core.EngineImpl;
import restaurant.core.interfaces.Controller;
import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.entities.tables.interfaces.Indoors;
import restaurant.entities.tables.interfaces.Table;

import restaurant.io.ConsoleReader;
import restaurant.io.ConsoleWriter;
import restaurant.repositories.interfaces.*;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // TODO: Optional - Create new instances for all repositories to test your code locally.

        HealthFoodRepository<HealthyFood> healthFoodRepository = new HealthFoodRepositoryImpl();
        BeverageRepository<Beverages> beverageRepository = new BeveragesRepositoryImpl();
        TableRepository<Table> tableRepository = new TableRepositoryImpl();


        Controller controller = new ControllerImpl(healthFoodRepository, beverageRepository, tableRepository);

        ConsoleReader reader = new ConsoleReader();
        ConsoleWriter writer = new ConsoleWriter();
        EngineImpl engine = new EngineImpl(reader, writer, controller);
        engine.run();





    }
}
