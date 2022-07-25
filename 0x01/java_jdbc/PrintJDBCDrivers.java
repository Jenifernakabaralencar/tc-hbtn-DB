import java.sql.*;
import java.util.Enumeration;

public class PrintJDBCDrivers {
    public static void main(String[] args) {
        System.out.println("Lista de Drives JDBC");

        for ( Enumeration<Driver> drivers = DriverManager.getDrivers();drivers.hasMoreElements();){
            Driver driver = drivers.nextElement();
            print(driver);
        }
    }
    public static void print(Driver driver) {
        String className = driver.getClass().getName();
        int majorVersion = driver.getMajorVersion();
        int minorVersion = driver.getMinorVersion();
        System.out.println("----------------------------------------");
        System.out.println("Name Driver: " + className);
        System.out.println("Driver Major Version: " + majorVersion);
        System.out.println("Driver Minor Version: " + minorVersion);
        System.out.println("----------------------------------------");
    }
    }
