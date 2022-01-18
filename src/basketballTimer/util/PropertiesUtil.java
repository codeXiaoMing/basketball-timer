package basketballTimer.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

/**
 * Author: Ming
 * Date: 2022.01.22:16
 * Description: <配置工具类>
 */
public class PropertiesUtil extends Properties {
    private static PropertiesUtil instance = null;

    private PropertiesUtil() { // 私有构造函数，不允许创建对象
        try {
            InputStream inputStream = new FileInputStream(new File("resources/config.properties"));
            this.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String read(String key) {
        if (instance == null) {
            instance = new PropertiesUtil();
        }
        String value = null;
        try {
            value = new String(instance.getProperty(key).getBytes("ISO8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return value;
    }

    public void write() {
        int temp = 0;
        if (instance == null) {
            instance = new PropertiesUtil();
        }
        instance.setProperty("temp", String.valueOf(temp));// 这里只是修改内存中的数据
        FileOutputStream fos = null; // 定义一个字节输出流
        try {
            fos = new FileOutputStream(new File("./src/properties")); // File构造函数的参数为配置文件的路径
            instance.store(fos, null); // 修改文件中的内容
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
