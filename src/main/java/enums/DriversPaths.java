package enums;

public enum DriversPaths {

    Chrome(".\\src\\main\\resources\\Drivers\\chromedriver.exe"),
    FireFox64(".\\src\\main\\resources\\seleniumDrivers\\geckodriver.exe");

    private final String path;

    DriversPaths(String path) {
        this.path = path;
    }

    public String getPath() {
        return this.path;
    }
}
