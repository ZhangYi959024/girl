package com.girl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Enumeration;
import java.util.Properties;

import static sun.misc.Version.println;

//@RestController
//@EnableAutoConfiguration
@SpringBootApplication
public class GirlApplication {
    public static void main(String[] args) {
        SpringApplication.run(GirlApplication.class, args);

   /*     Properties properties = new Properties();
        Enumeration enumeration = properties.propertyNames();
        while (enumeration.hasMoreElements()) {
            String propertiesName = (String) enumeration.nextElement();
            String propertiesValue = properties.getProperty(propertiesName);
            System.out.println("propertiesName:" + propertiesName + "propertiesValue:" + propertiesValue);
        }
        int[] arr = {6, 3, 8, 2, 9, 1};
        System.out.print("排序前数组为：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
        for (int i = 0; i < arr.length - 1; i++) {//外层循环控制排序趟数
            for (int j = 0; j < arr.length - 1 - i; j++) {//内层循环控制每一趟排序多少次
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            System.out.print("第"+i+"趟排出来的结果:");
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("排序后的数组为：");
        for (int num : arr) {
            System.out.print(num + " ");
        }*/
    }
//    @RequestMapping("/")
//    public String hello(){
//        return "Hello SpringBootaaa";
//    }
}
