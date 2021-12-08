package restaurant.repositories.interfaces;

import restaurant.entities.drinks.interfaces.Beverages;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class BeveragesRepositoryImpl implements BeverageRepository<Beverages> {


    private Collection<Beverages> entities;

    public BeveragesRepositoryImpl() {
        this.entities = new ArrayList<>();
    }

    @Override
    public Beverages beverageByName(String drinkName, String drinkBrand) {
        return this.entities
                .stream()
                .filter(d -> d.getName().equals(drinkName))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Collection<Beverages> getAllEntities() {
        return Collections.unmodifiableCollection(this.entities);
    }

    @Override
    public void add(Beverages entity) {
        entities.add(entity);
    }
}
