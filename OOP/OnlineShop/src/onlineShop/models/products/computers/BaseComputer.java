package onlineShop.models.products.computers;

import onlineShop.models.products.BaseProduct;
import onlineShop.models.products.components.Component;
import onlineShop.models.products.peripherals.Peripheral;

import java.util.ArrayList;
import java.util.List;

import static onlineShop.common.constants.ExceptionMessages.*;

public abstract class BaseComputer extends BaseProduct implements Computer {

    private List<Peripheral> peripherals;

    private List<Component> components;

    protected BaseComputer(int id, String manufacturer, String model, double price, double overallPerformance) {
        super(id, manufacturer, model, price, overallPerformance);
        this.components = new ArrayList<>();
        this.peripherals = new ArrayList<>();
    }

    @Override
    public List<Component> getComponents() {
        return this.components;
    }

    @Override
    public List<Peripheral> getPeripherals() {
        return this.peripherals;
    }

    @Override
    public void addComponent(Component component) {
        if (this.components.contains(component)) {
            throw new IllegalArgumentException(String.format(EXISTING_COMPONENT,
                    component.getClass().getSimpleName(),
                    getClass().getSimpleName(),
                    getId()));
        }
        this.components.add(component);
    }

    @Override
    public Component removeComponent(String componentType) {
        boolean isTrue = false;
        for (Component component : components) {
            if (component.getClass().getSimpleName().equals(componentType)) {
                isTrue = true;
            }
        }

        if (this.components.isEmpty() || !isTrue) {
            throw new IllegalArgumentException(String.format(NOT_EXISTING_COMPONENT,
                    componentType,
                    getClass().getSimpleName(),
                    getId()));
        }
        Component component2 = null;


        for (int i = 0; i < components.size(); i++) {
            if (components.get(i).getClass().getSimpleName().equals(componentType)) {
                component2 = components.get(i);
                this.components.remove(components.get(i));
                break;
            }
        }
        return component2;
    }

    @Override
    public void addPeripheral(Peripheral peripheral) {
        if (this.peripherals.contains(peripheral)) {
            throw new IllegalArgumentException(String.format(EXISTING_PERIPHERAL,
                    peripheral.getClass().getSimpleName(),
                    getClass().getSimpleName(),
                    getId()));
        }
        this.peripherals.add(peripheral);
    }

    @Override
    public Peripheral removePeripheral(String peripheralType) {
        boolean isTrue = false;
        for (Peripheral peripheral : peripherals) {
            if (peripheral.getClass().getSimpleName().equals(peripheralType)) {
                isTrue = true;
            }
        }
        if (this.peripherals.isEmpty() || !isTrue) {
            throw new IllegalArgumentException(String.format(NOT_EXISTING_PERIPHERAL,
                    peripheralType,
                    getClass().getSimpleName(),
                    getId()));

        }
        Peripheral peripheral2 = null;


        for (int i = 0; i < peripherals.size(); i++) {
            if (peripherals.get(i).getClass().getSimpleName().equals(peripheralType)) {
                peripheral2 = peripherals.get(i);
                this.peripherals.remove(peripherals.get(i));
                break;
            }
        }
        return peripheral2;
    }

    @Override
    public double getPrice() {
        double sum = 0;
        for (Peripheral peripheral : peripherals) {
            sum += peripheral.getPrice();
        }
        for (Component component : components) {
            sum += component.getPrice();
        }
        return super.getPrice() + sum;
    }

    @Override
    public double getOverallPerformance() {
        if (this.components.isEmpty()) {
            return super.getOverallPerformance();
        }
        double sum = 0;
        for (Component component : components) {
            sum += component.getOverallPerformance();
        }
        return super.getOverallPerformance() + (sum / components.size());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Overall Performance: %.2f. Price: %.2f - %s: %s %s (Id: %d)", getOverallPerformance()
                , getPrice()
                , getClass().getSimpleName()
                , getManufacturer()
                , getModel()
                , getId()));
        sb.append(System.lineSeparator());
        sb.append(String.format(" Components (%d):", components.size()));
        sb.append(System.lineSeparator());
        for (Component component : components) {
            sb.append("  ").append(component.toString()).append(System.lineSeparator());
        }
        sb.append(String.format(" Peripherals (%d); Average Overall Performance (%.2f):",
                peripherals.size(), peripherals.stream().mapToDouble(Peripheral::getOverallPerformance).average().orElse(0))).append(System.lineSeparator());
        for (Peripheral peripheral : peripherals) {
            sb.append("  ").append(peripheral.toString()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
