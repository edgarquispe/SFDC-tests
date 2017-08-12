package org.fundacionjala.sfdc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by abelb on 8/12/2017.
 */
public  final class Env {

    private static Env instance;
    private Properties properties;

    /**
     * Private constructor for Env.
     */
    private Env() {
        try (FileInputStream input = new FileInputStream("env.properties")) {
            properties = new Properties();
            properties.load(input);

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("File broken.");
            throw new RuntimeException(e);
        }
    }

    /**
     * Returns the Instance for Env.
     *
     * @return Env instance.
     */
    public static Env getInstance() {
        if (instance == null) {
            instance = new Env();
        }
        return instance;
    }

    /**
     * Gets Env Properties.
     *
     * @param env String option.
     * @return String result.
     */
    public String getEnv(String env) {
        return properties.getProperty(env);
    }

    /**
     * Gets the Username value.
     *
     * @return String.
     */
    public String getUsername() {
        return getEnv("username");
    }

    /**
     * Gets the Password value.
     *
     * @return String.
     */
    public String getPassword() {
        return getEnv("password");
    }

    /**
     * Gets the Base Url of Sales Force.
     *
     * @return String.
     */
    public String getBaseUrl() {
        return getEnv("baseUrl");
    }

    /**
     * Gets the Login Url of Sales Force.
     *
     * @return String.
     */
    public String getLoginUrl() {
        return getEnv("loginUrl");
    }
}
