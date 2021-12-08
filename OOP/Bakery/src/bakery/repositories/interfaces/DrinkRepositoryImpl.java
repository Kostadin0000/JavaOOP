package bakery.repositories.interfaces;

import bakery.entities.drinks.interfaces.Drink;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
public class DrinkRepositoryImpl implements DrinkRepository<Drink> {

    private Collection<Drink> models;

    public DrinkRepositoryImpl() {
        this.models = new ArrayList<>();
    }

    @Override
    public Drink getByNameAndBrand(String drinkName, String drinkBrand) {
        Drink drink = this.models.stream()
                .filter(d -> d.getBrand().equals(drinkBrand) && d.getName().equals(drinkName)).findFirst().orElse(null);
        return drink;
    }

    @Override
    public Collection<Drink> getAll() {
        return Collections.unmodifiableCollection(this.models);
    }

    @Override
    public void add(Drink drink) {
        this.models.add(drink);
    }
}
