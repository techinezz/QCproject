public class Appliance implements Comparable<Appliance> {
    private String serialNumber;

    public Appliance(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    @Override
    public String toString() {
        char type = serialNumber.charAt(0);
        String applianceType = "";
        switch (type) {
            case 'R':
                applianceType = "Refrigerator";
                break;
            case 'D':
                applianceType = "Dishwasher";
                break;
            case 'M':
                applianceType = "Microwave";
                break;
        }
        return applianceType + " - " + serialNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appliance appliance = (Appliance) o;
        return serialNumber.equals(appliance.serialNumber);
    }

    @Override
    public int compareTo(Appliance other) {
        return this.serialNumber.compareTo(other.serialNumber);
    }
}
