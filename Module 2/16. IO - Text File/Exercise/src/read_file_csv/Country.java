package read_file_csv;

/**
 * Project: Exercise
 * Package: read_file_csv
 * User: lomahs
 * Date time: 16/06/2021 19:28
 * Created with IntelliJ IDEA
 */
public class Country {

    private String startIP;
    private String endIP;
    private String startPort;
    private String endPort;
    private String countryCode;
    private String countryName;

    public Country(String startIP, String endIP, String startPort, String endPort, String countryCode, String countryName) {
        this.startIP = startIP;
        this.endIP = endIP;
        this.startPort = startPort;
        this.endPort = endPort;
        this.countryCode = countryCode;
        this.countryName = countryName;
    }

    public String getStartIP() {
        return startIP;
    }

    public void setStartIP(String startIP) {
        this.startIP = startIP;
    }

    public String getEndIP() {
        return endIP;
    }

    public void setEndIP(String endIP) {
        this.endIP = endIP;
    }

    public String getStartPort() {
        return startPort;
    }

    public void setStartPort(String startPort) {
        this.startPort = startPort;
    }

    public String getEndPort() {
        return endPort;
    }

    public void setEndPort(String endPort) {
        this.endPort = endPort;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Override
    public String toString() {
        return "Country{" +
                "startIP='" + startIP + '\'' +
                ", endIP='" + endIP + '\'' +
                ", startPort='" + startPort + '\'' +
                ", endPort='" + endPort + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", countryName='" + countryName + '\'' +
                '}';
    }
}
