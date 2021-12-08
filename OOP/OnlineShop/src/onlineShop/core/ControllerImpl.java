package onlineShop.core;

import onlineShop.core.interfaces.Controller;
import onlineShop.models.products.components.*;
import onlineShop.models.products.computers.Computer;
import onlineShop.models.products.computers.DesktopComputer;
import onlineShop.models.products.computers.Laptop;
import onlineShop.models.products.peripherals.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static onlineShop.common.constants.ExceptionMessages.*;
import static onlineShop.common.constants.OutputMessages.*;

public class ControllerImpl implements Controller {

    List<Computer> computerList = new ArrayList<>();
    List<Component> componentList = new ArrayList<>();
    List<Peripheral> peripheralList = new ArrayList<>();


    @Override
    public String addComputer(String computerType, int id, String manufacturer, String model, double price) {
        if (computerType.equals("Laptop")) {
            Laptop laptop = new Laptop(id, manufacturer, model, price);
            for (Computer computer : computerList) {
                if (computer.getId() == laptop.getId()) {
                    throw new IllegalArgumentException(EXISTING_COMPUTER_ID);
                }
            }
            this.computerList.add(laptop);
            return String.format(ADDED_COMPUTER, laptop.getId());
        } else if (computerType.equals("DesktopComputer")) {
            DesktopComputer desktopComputer = new DesktopComputer(id, manufacturer, model, price);
            this.computerList.add(desktopComputer);
            return String.format(ADDED_COMPUTER, desktopComputer.getId());
        } else {
            throw new IllegalArgumentException(INVALID_COMPUTER_TYPE);
        }
    }

    @Override
    public String addPeripheral(int computerId, int id, String peripheralType, String manufacturer, String model, double price, double overallPerformance, String connectionType) {
        boolean isTrue = false;
        for (Computer computer : computerList) {
            if (computer.getId() == computerId) {
                isTrue = true;
            }
        }
        if (!isTrue) {
            throw new IllegalArgumentException(NOT_EXISTING_COMPUTER_ID);
        }
        if (peripheralType.equals("Headset")) {
            Headset headset = new Headset(id, manufacturer, model, price, overallPerformance, connectionType);
            for (Peripheral peripheral : peripheralList) {
                if (peripheral.getId() == headset.getId()) {
                    throw new IllegalArgumentException(EXISTING_PERIPHERAL_ID);
                }
            }
            peripheralList.add(headset);
            for (Computer computer : computerList) {
                if (computer.getId() == computerId) {
                    computer.addPeripheral(headset);
                    return String.format(ADDED_PERIPHERAL, peripheralType, id, computer.getId());
                }
            }
        } else if (peripheralType.equals("Keyboard")) {
            Keyboard keyboard = new Keyboard(id, manufacturer, model, price, overallPerformance, connectionType);
            for (Peripheral peripheral : peripheralList) {
                if (peripheral.getId() == keyboard.getId()) {
                    throw new IllegalArgumentException(EXISTING_PERIPHERAL_ID);
                }
            }
            peripheralList.add(keyboard);
            for (Computer computer : computerList) {
                if (computer.getId() == computerId) {
                    computer.addPeripheral(keyboard);
                    return String.format(ADDED_PERIPHERAL, peripheralType, id, computer.getId());
                }
            }
        } else if (peripheralType.equals("Monitor")) {
            Monitor monitor = new Monitor(id, manufacturer, model, price, overallPerformance, connectionType);
            for (Peripheral peripheral : peripheralList) {
                if (peripheral.getId() == monitor.getId()) {
                    throw new IllegalArgumentException(EXISTING_PERIPHERAL_ID);
                }
            }
            peripheralList.add(monitor);
            for (Computer computer : computerList) {
                if (computer.getId() == computerId) {
                    computer.addPeripheral(monitor);
                    return String.format(ADDED_PERIPHERAL, peripheralType, id, computer.getId());
                }
            }
        } else if (peripheralType.equals("Mouse")) {
            Mouse mouse = new Mouse(id, manufacturer, model, price, overallPerformance, connectionType);
            for (Peripheral peripheral : peripheralList) {
                if (peripheral.getId() == mouse.getId()) {
                    throw new IllegalArgumentException(EXISTING_PERIPHERAL_ID);
                }
            }
            peripheralList.add(mouse);
            for (Computer computer : computerList) {
                if (computer.getId() == computerId) {
                    computer.addPeripheral(mouse);
                    return String.format(ADDED_PERIPHERAL, peripheralType, id, computer.getId());
                }
            }
        }
        throw new IllegalArgumentException(INVALID_PERIPHERAL_TYPE);


    }

    @Override
    public String removePeripheral(String peripheralType, int computerId) {
        boolean isTrue = false;
        for (Computer computer : computerList) {
            if (computer.getId() == computerId) {
                isTrue = true;
            }
        }
        if (!isTrue) {
            throw new IllegalArgumentException(NOT_EXISTING_COMPUTER_ID);
        }
        for (Computer computer : computerList) {
            if (computer.getId() == computerId) {
                Peripheral peripheral = computer.removePeripheral(peripheralType);
                return String.format(REMOVED_PERIPHERAL, peripheralType, peripheral.getId());
            }
        }
        return null;
    }

    @Override
    public String addComponent(int computerId
            , int id, String componentType
            , String manufacturer
            , String model, double price
            , double overallPerformance, int generation) {

        boolean isTrue = false;
        for (Computer computer : computerList) {
            if (computer.getId() == computerId) {
                isTrue = true;
            }
        }


        if (!isTrue) {
            throw new IllegalArgumentException(NOT_EXISTING_COMPUTER_ID);
        }


        if (componentType.equals("CentralProcessingUnit")) {
            CentralProcessingUnit processingUnit = new CentralProcessingUnit(id
                    , manufacturer
                    , model, price, overallPerformance, generation);

            for (Component component : componentList) {
                if (component.getId() == processingUnit.getId()) {
                    throw new IllegalArgumentException(EXISTING_COMPONENT_ID);
                }
            }
            componentList.add(processingUnit);
            for (Computer computer : computerList) {
                if (computer.getId() == computerId) {
                    computer.addComponent(processingUnit);
                    return String.format(ADDED_COMPONENT, componentType, id, computer.getId());
                }
            }


        } else if (componentType.equals("Motherboard")) {
            Motherboard motherboard = new Motherboard(id, manufacturer, model, price, overallPerformance, generation);

            for (Component component : componentList) {
                if (component.getId() == motherboard.getId()) {
                    throw new IllegalArgumentException(EXISTING_COMPONENT_ID);
                }
            }
            componentList.add(motherboard);
            for (Computer computer : computerList) {
                if (computer.getId() == computerId) {
                    computer.addComponent(motherboard);
                    return String.format(ADDED_COMPONENT, componentType, id, computer.getId());
                }
            }
        } else if (componentType.equals("PowerSupply")) {
            PowerSupply powerSupply = new PowerSupply(id
                    , manufacturer
                    , model, price, overallPerformance, generation);

            for (Component component : componentList) {
                if (component.getId() == powerSupply.getId()) {
                    throw new IllegalArgumentException(EXISTING_COMPONENT_ID);
                }
            }
            componentList.add(powerSupply);
            for (Computer computer : computerList) {
                if (computer.getId() == computerId) {
                    computer.addComponent(powerSupply);
                    return String.format(ADDED_COMPONENT, componentType, id, computer.getId());
                }
            }
        } else if (componentType.equals("VideoCard")) {
            VideoCard videoCard = new VideoCard(id
                    , manufacturer
                    , model, price, overallPerformance, generation);

            for (Component component : componentList) {
                if (component.getId() == videoCard.getId()) {
                    throw new IllegalArgumentException(EXISTING_COMPONENT_ID);
                }
            }
            componentList.add(videoCard);
            for (Computer computer : computerList) {
                if (computer.getId() == computerId) {
                    computer.addComponent(videoCard);
                    return String.format(ADDED_COMPONENT, componentType, id, computer.getId());
                }
            }
        } else if (componentType.equals("SolidStateDrive")) {
            SolidStateDrive solidStateDrive = new SolidStateDrive(id
                    , manufacturer
                    , model, price, overallPerformance, generation);

            for (Component component : componentList) {
                if (component.getId() == solidStateDrive.getId()) {
                    throw new IllegalArgumentException(EXISTING_COMPONENT_ID);
                }
            }
            componentList.add(solidStateDrive);
            for (Computer computer : computerList) {
                if (computer.getId() == computerId) {
                    computer.addComponent(solidStateDrive);
                    return String.format(ADDED_COMPONENT, componentType, id, computer.getId());
                }
            }
        } else if (componentType.equals("RandomAccessMemory")) {
            RandomAccessMemory randomAccessMemory = new RandomAccessMemory(id
                    , manufacturer
                    , model, price, overallPerformance, generation);

            for (Component component : componentList) {
                if (component.getId() == randomAccessMemory.getId()) {
                    throw new IllegalArgumentException(EXISTING_COMPONENT_ID);
                }
            }
            componentList.add(randomAccessMemory);
            for (Computer computer : computerList) {
                if (computer.getId() == computerId) {
                    computer.addComponent(randomAccessMemory);
                    return String.format(ADDED_COMPONENT, componentType, id, computer.getId());
                }
            }
        }
        throw new IllegalArgumentException(INVALID_COMPONENT_TYPE);


    }

    @Override
    public String removeComponent(String componentType, int computerId) {
        boolean isTrue = false;
        for (Computer computer : computerList) {
            if (computer.getId() == computerId) {
                isTrue = true;
            }
        }
        if (!isTrue) {
            throw new IllegalArgumentException(NOT_EXISTING_COMPUTER_ID);
        }
        for (Computer computer : computerList) {
            if (computer.getId() == computerId) {
                Component component = computer.removeComponent(componentType);
                return String.format(REMOVED_COMPONENT, componentType, component.getId());
            }
        }
        return null;
    }

    @Override
    public String buyComputer(int id) {
        boolean isTrue = false;
        for (Computer computer : computerList) {
            if (computer.getId() == id) {
                isTrue = true;
            }
        }
        if (!isTrue) {
            throw new IllegalArgumentException(NOT_EXISTING_COMPUTER_ID);
        }
        Computer computer1 = null;
        for (Computer computer : computerList) {
            if (computer.getId() == id) {
                computer1 = computer;
                computerList.remove(computer);
                break;
            }
        }
        return computer1.toString();

    }

    @Override
    public String BuyBestComputer(double budget) {
        List<Computer> collect = computerList.stream()
                .filter(c -> c.getPrice() <= budget)
                .sorted(Comparator.comparing(Computer::getPrice).reversed())
                .collect(Collectors.toList());
        if (collect.isEmpty()) {
            throw new IllegalArgumentException(String.format(CAN_NOT_BUY_COMPUTER, budget));
        }
        Computer computer = collect.get(0);
        computerList.remove(computer);
        return computer.toString();
    }

    @Override
    public String getComputerData(int id) {
        boolean isTrue = false;
        for (Computer computer : computerList) {
            if (computer.getId() == id) {
                isTrue = true;
            }
        }
        if (!isTrue) {
            throw new IllegalArgumentException(NOT_EXISTING_COMPUTER_ID);
        }
        for (Computer computer : computerList) {
            if (computer.getId() == id) {
                return computer.toString();
            }
        }
        return null;
    }
}
