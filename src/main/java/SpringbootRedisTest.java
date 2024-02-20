import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.hzbank.pojo.Student;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;
import com.hzbank.pojo.Person;
import com.hzbank.pojo.User;

import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description
 * @Auther: fyd20
 * @Date: 2023/7/10 19:29
 * @Description: test
 * @Version 1.0.0
 */
public class SpringbootRedisTest {


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
        String str = "{'name':'name0','age':''}";
        JsonObject jsonObject = new JsonObject();
        jsonObject.getAsJsonObject();
        Gson gson = new Gson();
        Person person = gson.fromJson(str, Person.class);
        System.out.println(person.toString());


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


    @Test
    public void test3(){
        List<Student> list = new ArrayList<>();
        Student s1 = new Student("a", 11, new Date(2020, 1, 1));
        Student s2 = new Student("b", 12, new Date(2020, 1, 2));
        Student s3 = new Student("c", 13, null);
        Student s4 = new Student("d", 13, null);
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);

        list = list.stream().sorted(Comparator.comparing(Student::getDate,Comparator.nullsLast(Comparator.reverseOrder()))).collect(Collectors.toList());
        System.out.println(list);

    }

}
