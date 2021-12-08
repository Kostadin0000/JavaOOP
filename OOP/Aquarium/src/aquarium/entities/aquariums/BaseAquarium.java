package aquarium.entities.aquariums;

import aquarium.common.ConstantMessages;
import aquarium.entities.decorations.Decoration;
import aquarium.entities.fish.Fish;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static aquarium.common.ConstantMessages.*;
import static aquarium.common.ExceptionMessages.*;

public abstract class BaseAquarium implements Aquarium {
    private String name;
    private int capacity;
    private Collection<Decoration> decorations;
    private Collection<Fish> fish;


    protected BaseAquarium(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        decorations = new ArrayList<>();
        fish = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(AQUARIUM_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    protected int getCapacity() {
        return capacity;
    }

    @Override
    public int calculateComfort() {
        int sum = 0;
        sum = this.decorations.stream().mapToInt(Decoration::getComfort).sum();
        return sum;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void addFish(Fish fish) {
        if (this.fish.size() >= this.capacity) {
            throw new IllegalStateException(ConstantMessages.NOT_ENOUGH_CAPACITY);
        }
        this.fish.add(fish);
    }

    @Override
    public void removeFish(Fish fish) {
        this.fish.remove(fish);
    }

    @Override
    public void addDecoration(Decoration decoration) {
        decorations.add(decoration);
    }

    @Override
    public void feed() {
        this.fish.forEach(Fish::eat);
    }

    @Override
    public String getInfo() {

        StringBuilder perPrint = new StringBuilder();
        if (this.getFish().isEmpty()) {
            perPrint.append("none");
        } else {
            perPrint.append("Fish: ");
            List<String> collect = this.getFish().stream().map(Fish::getName).collect(Collectors.toList());
            perPrint.append(String.join(" ", collect));

            perPrint
                    .append(System.lineSeparator())
                    .append("Decorations: ").append(this.getDecorations().size())
                    .append(System.lineSeparator())
                    .append("Comfort: ")
                    .append(this.calculateComfort());
        }
        return perPrint.toString();
    }

    @Override
    public Collection<Fish> getFish() {
        return (this.fish);
    }

    @Override
    public Collection<Decoration> getDecorations() {
        return (this.decorations);
    }
}
