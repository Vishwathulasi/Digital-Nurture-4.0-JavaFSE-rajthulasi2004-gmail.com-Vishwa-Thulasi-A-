package Exercise_3_Implementing_The_Builder_Pattern;


class Computer {
    private String CPU;
    private String RAM;

    private String storage;
    private String graphicsCard;
    private String operatingSystem;

    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.graphicsCard = builder.graphicsCard;
        this.operatingSystem = builder.operatingSystem;
    }

    public static class Builder {
        private String CPU;
        private String RAM;

        private String storage;
        private String graphicsCard;
        private String operatingSystem;

        public Builder(String CPU, String RAM) {
            this.CPU = CPU;
            this.RAM = RAM;
        }

        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder setGraphicsCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }

        public Builder setOperatingSystem(String os) {
            this.operatingSystem = os;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }

    public void showConfig() {
        System.out.println("Computer Configuration:");
        System.out.println("CPU: " + CPU);
        System.out.println("RAM: " + RAM);
        System.out.println("Storage: " + (storage != null ? storage : "Not Included"));
        System.out.println("Graphics Card: " + (graphicsCard != null ? graphicsCard : "Not Included"));
        System.out.println("Operating System: " + (operatingSystem != null ? operatingSystem : "Not Installed"));
    }
}

public class Exercise3 {
     public static void main(String[] args) {
        Computer basicComputer = new Computer.Builder("Intel i3", "4GB").build();
        basicComputer.showConfig();

        System.out.println();

        Computer gamingComputer = new Computer.Builder("Intel i9", "32GB")
            .setStorage("1TB SSD")
            .setGraphicsCard("NVIDIA RTX 4080")
            .setOperatingSystem("Windows 11 Pro")
            .build();
        gamingComputer.showConfig();

        System.out.println();

        Computer officeComputer = new Computer.Builder("AMD Ryzen 5", "16GB")
            .setStorage("512GB SSD")
            .setOperatingSystem("Ubuntu Linux")
            .build();
        officeComputer.showConfig();
    }
}
