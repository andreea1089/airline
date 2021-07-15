package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileManager {
    //    private static Logger logger = LogManager.getLogger(PropertyFileManager.class);
    private static PropertyFileManager instance;
    private static final Object lock = new Object();
    private static final String propertyFilePath = "D://Personal projects//airline//src//test//resources//config.properties";
    private static String browserType;
    private static String url;
    private static String driverLocation;

    public static PropertyFileManager getInstance() {
        if (instance == null) {
            synchronized (lock) {
                instance = new PropertyFileManager();
                instance.loadData();
            }
        }
        return instance;
    }

    private void loadData() {
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream(propertyFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        url = prop.getProperty("url");
        browserType = prop.getProperty("browserType");
        driverLocation = prop.getProperty("driverLocation");
    }

    public static String getBrowserType() {
        return browserType;
    }

    public static String getUrl() {
        return url;
    }

    public static String getDriverLocation() {
        return driverLocation;
    }
}