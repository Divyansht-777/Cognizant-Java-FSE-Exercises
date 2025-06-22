public class ComputerBuilderDemo {

    static class Computer {
        private String cpu;
        private String ram;
        private String storage;
        private String gpu;
        private boolean isWifiEnabled;
        private boolean isBluetoothEnabled;

        private Computer(Builder builder) {
            this.cpu = builder.cpu;
            this.ram = builder.ram;
            this.storage = builder.storage;
            this.gpu = builder.gpu;
            this.isWifiEnabled = builder.isWifiEnabled;
            this.isBluetoothEnabled = builder.isBluetoothEnabled;
        }

        public String toString() {
            return "Computer [CPU=" + cpu + ", RAM=" + ram + ", Storage=" + storage + ", GPU=" + gpu +
                   ", WiFi=" + isWifiEnabled + ", Bluetooth=" + isBluetoothEnabled + "]";
        }

        static class Builder {
            private String cpu;
            private String ram;
            private String storage;
            private String gpu;
            private boolean isWifiEnabled;
            private boolean isBluetoothEnabled;

            public Builder setCPU(String cpu) {
                this.cpu = cpu;
                return this;
            }

            public Builder setRAM(String ram) {
                this.ram = ram;
                return this;
            }

            public Builder setStorage(String storage) {
                this.storage = storage;
                return this;
            }

            public Builder setGPU(String gpu) {
                this.gpu = gpu;
                return this;
            }

            public Builder enableWiFi(boolean enable) {
                this.isWifiEnabled = enable;
                return this;
            }

            public Builder enableBluetooth(boolean enable) {
                this.isBluetoothEnabled = enable;
                return this;
            }

            public Computer build() {
                return new Computer(this);
            }
        }
    }

    public static void main(String[] args) {
        Computer gamingPC = new Computer.Builder()
                .setCPU("Intel i9")
                .setRAM("32GB")
                .setStorage("1TB SSD")
                .setGPU("NVIDIA RTX 4080")
                .enableWiFi(true)
                .enableBluetooth(true)
                .build();

        Computer officePC = new Computer.Builder()
                .setCPU("Intel i5")
                .setRAM("16GB")
                .setStorage("512GB SSD")
                .enableWiFi(true)
                .enableBluetooth(false)
                .build();

        System.out.println("Gaming PC: " + gamingPC);
        System.out.println("Office PC: " + officePC);
    }
}
