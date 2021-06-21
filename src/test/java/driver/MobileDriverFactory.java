package driver;

public class MobileDriverFactory {

    public static MobileDriverManager getManager(DriverType type) {
        MobileDriverManager driverManager = null;

        switch (type) {
            case ANDROID:
                driverManager = new AndroidDriverManager();
                break;
            case IOS:
                //  driverManager = new IOSDriverManager();
                break;
            case WINDOWS:
                //  driverManager = new WINDOWSDriverManager();
                break;
            default:
                //   driverManager = new DefaultDriverManager();
                break;
        }
        return driverManager;
    }
}
