import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;
import pojo.Person;
import pojo.User;

import javax.swing.text.DateFormatter;
import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @Description
 * @Auther: fyd20
 * @Date: 2023/7/10 19:29
 * @Description: test
 * @Version 1.0.0
 */
public class test {


    public static Date transferString2Date(String s) {
        Date date = new Date();
        try {
            date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(s);
        } catch (ParseException e) {
            //LOGGER.error("时间转换错误, string = {}", s, e);
        }
        return date;
    }

    public static void main(String[] args) {

        System.out.println(transferString2Date("2022-01-02 12:34:56"));
        long first = 10100020122L;
        Timestamp timestamp = new Timestamp(first);
        timestamp.setNanos(0);
        System.out.println(timestamp);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(Arrays.toString(list.toArray()));


        for (Integer integer : list) {
            if (integer != 5){
//                return null;
            }
        }


    }


    @Test
    public void test2() throws InvocationTargetException, IllegalAccessException {
        User user = new User();
        List<User> users = new ArrayList<>();
        users.add(new User(1,"121"));
        users.add(new User(2,"12222"));
        List<Person> personList = new ArrayList<>();
        BeanUtils.copyProperties(users,personList);
        System.out.println(Arrays.toString(personList.toArray()));



        String a = "12121_1212_2";
        System.out.println("长度" + a.length());


        List<String> list = new ArrayList<>();
        for (String s : list) {
            System.out.println("打印s" + s);
        }


    }

}
