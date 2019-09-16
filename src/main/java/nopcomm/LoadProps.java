package nopcomm;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.util.Properties;

public class LoadProps {
    static Properties props;

    static FileInputStream inputStream;

    public String getProperty(String key) {
        props = new Properties();
        try {
            inputStream = new FileInputStream("src\\main\\Resources\\testdataConfig.properties");
            props.load(inputStream);
            inputStream.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        return props.getProperty(key);
    }

    @Test
    public void test1() {
        System.out.println(getProperty("url"));

    }
}