package Exercise3;

class Computer {
    String CPU;
    String RAM;
    String storage;
    String GPU;

    // Private constructor: only the builder can create instances
    public Computer(String CPU, String RAM, String storage, String GPU) {
        this.CPU = CPU;
        this.RAM = RAM;
        this.storage = storage;
        this.GPU = GPU;
    }

    @Override
    public String toString() {
        return "Computer [CPU=" + CPU + ", RAM=" + RAM + ", Storage=" + storage + ", GPU=" + GPU + "]";
    }

    // Getters if needed
    public String getCPU() { return CPU; }
    public String getRAM() { return RAM; }
    public String getStorage() { return storage; }
    public String getGPU() { return GPU; }
}

class ComputerBuilder {
    String CPU;
    String RAM;
    String storage;
    String GPU;

    public ComputerBuilder setCPU(String CPU) {
        this.CPU = CPU;
        return this;
    }

    public ComputerBuilder setRAM(String RAM) {
        this.RAM = RAM;
        return this;
    }

    public ComputerBuilder setStorage(String storage) {
        this.storage = storage;
        return this;
    }

    public ComputerBuilder setGPU(String GPU) {
        this.GPU = GPU;
        return this;
    }

    public Computer build() {
        return new Computer(CPU, RAM, storage, GPU);
    }
}

public class BuilderPatternExample {
    public static void main(String[] args) {
        Computer officePC = new ComputerBuilder().setCPU("Intel i5").setRAM("8GB").setStorage("512GB SSD").build();
        Computer gamingPC = new ComputerBuilder().setCPU("AMD Ryzen 9").setRAM("32GB").setStorage("2TB SSD").setGPU("NVIDIA RTX 4080").build();

        System.out.println("Office PC:\n" + officePC);
        System.out.println("\nGaming PC:\n" + gamingPC);
    }
}
