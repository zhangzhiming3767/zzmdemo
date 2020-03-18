package com.example.zzmdemo.nothingtodowithproject.javaBaseTest;

import com.example.zzmdemo.dto.BaseTypeTest;
import com.example.zzmdemo.dto.TestTwo;
import com.example.zzmdemo.entity.SysUser;
import com.example.zzmdemo.utils.DateUtil;
import com.example.zzmdemo.utils.LocalDateUtils;
import com.example.zzmdemo.utils.OtherUtils;
import com.github.pagehelper.Page;
import org.apache.commons.collections.CollectionUtils;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.BeanUtils;
import org.springframework.util.unit.DataUnit;

import javax.annotation.Resource;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.xml.crypto.Data;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zhangzhiming
 * description
 * @date 17:28 2019/10/10
 */
public class MainTestController {

    @Resource
    private InterfaceDemo interfaceDemo;

    public static void main(String[] args) throws IllegalAccessException {
        List<String> testlist=new ArrayList<>();
        testlist.add("233");
        testlist.add("666");
        Integer testa1[]=new Integer[6];
        for(int i=0;i<6;i++){
            testa1[i]=i;
        }
        List<Integer> arrToList=Arrays.asList(testa1);
        testa1[2]=33;
        Map<String,String> newMapTtest=new HashMap<>();
        newMapTtest.put("第一个","aaa");

        System.out.println("");
    }


    /**
     * @author :zhangzhiming
     * description : Integer 测试
     * @date :Create in  2020/2/16 16:54
     */
    private static void integerTest() {
        Set<String> test233=new HashSet<>();
        Boolean result1=test233.add("233");
        Boolean result2=test233.add("233");

        Date test=DateUtil.getYearEndTime(0L,"GMT+8:00");
        Integer year=DateUtil.getYear(new Date());


        SysUser sysUser=new SysUser();
        sysUser.setId("222");
        sysUser.setIdCard("3333");
        SysUser userTwo=new SysUser();
        userTwo.setLoginName("name");
        userTwo.setPhone("123");
        BeanUtils.copyProperties(sysUser,userTwo);
        //大于127后 == 返回就是false
        Integer a = 127;
        Integer b = 127;
        boolean j1 = a == b;
        boolean j2 = a.equals(b);
        String s1="aaa";
        String s2="aaa";
        String s4="a";
        String s5="sabcsszxczxvzxvzxvzxvzbbz";
        char []t8=s5.toCharArray();
        int t7=s5.indexOf("bb",2);

        int al=s1.length();
        String s3=new String("aaa");
        boolean t1=s1==s2;
        boolean t2=s1==s3;
        boolean t3=s1.equals(s3);
        boolean t4=Objects.equals("aa","aa");
        boolean t5=Objects.equals(null,null);
        boolean t6=Objects.equals(s2,s3);
        System.out.println();
    }

    /**
     * @author :zhangzhiming
     * description :八大基础类型与封装类型默认值测试
     * @date :Create in  2020/2/16 16:54
     */
    private static void baseTypeTest() {
        BaseTypeTest baseTypeTest=new BaseTypeTest();
        System.out.println("c");
    }

    private static void bigTest(){
        //        BigDecimal e=new BigDecimal(0.2);
        BigDecimal d = new BigDecimal(Double.toString(0.3));
        BigDecimal e = new BigDecimal(Double.toString(0.2));
//        BigDecimal d=new BigDecimal(3);
//        BigDecimal e=new BigDecimal(2);
        BigDecimal f = d.add(e);
        BigDecimal g = d.subtract(e);
        BigDecimal h = d.multiply(e);
        BigDecimal j = d.divide(e, 2, BigDecimal.ROUND_HALF_UP);
    }

    public static void emptyTest(@NotBlank String id) {
        System.out.println("进来啦");
    }

    public static void gc() {
        float a = 0.3f;
        float b = 0.2f;
        float c = a + b;
        float c2 = a - b;
        float c3 = a * b;
        float c4 = a / b;
        double a1 = 0.3;
        double a2 = 0.2;
        double a3 = a1 + a2;
        double a4 = a1 - a2;
        double a5 = a1 * a2;
        double a6 = a1 / a2;
//        BigDecimal d=new BigDecimal(0.3);
//        BigDecimal e=new BigDecimal(0.2);
        BigDecimal d = new BigDecimal(Double.toString(0.3));
        BigDecimal e = new BigDecimal(Double.toString(0.2));
//        BigDecimal d=new BigDecimal(3);
//        BigDecimal e=new BigDecimal(2);
        BigDecimal f = d.add(e);
        BigDecimal g = d.subtract(e);
        BigDecimal h = d.multiply(e);
        BigDecimal j = d.divide(e, 2, BigDecimal.ROUND_HALF_UP);
        List<Integer> idList = new ArrayList<>();
        for (int i = 0; i < 392; i++) {
            idList.add(i);
        }
        List<TestTwo> testTwoList=new ArrayList<>();
        TestTwo testTwo=new TestTwo();
        testTwo.setStrings(new ArrayList<>());
        try{
            testTwoList.forEach(testTwo1 -> {
                int a21=0;
                int b21=1;
                System.out.println(b/a);
                List<String> strings=new ArrayList<>();
                strings.add("233");
                testTwo1.getStrings().add("233");
                throw new RuntimeException("111");
            });
        }catch (Exception ee){
            System.out.println("");
        }
//        int counts=(idList.size()%100>0?idList.size()/100+1:idList.size()/100);
//        List<Integer> ids=new ArrayList<>();
//        for(int j=0;j<counts;j++){
//            ids=idList.subList(j*100,j*100+(j==counts-1?idList.size()%100:100));
//        }
//        System.out.println(ids.size());
        Date firstDate = DateUtil.getFirstDateOfMonth(new Date());
        Date lastDate = DateUtil.getLastDateOfMonth(new Date());
        int month = DateUtil.getMonth(new Date());
        Date startTime = DateUtil.getStartTime();
        Date endTime = DateUtil.getEndTime();
        Date test = DateUtil.getLastMothStartTime(-1);
        Date test2 = DateUtil.getLastMothEndTime(-1);
        System.out.println(month);
        //        emptyTest(" ");
//        StringBuilder test=new StringBuilder();
//        test.append("233");
//        test.append("qwe");
//        test.append("....");
//        test.delete(0,test.length());
//        System.out.println(test.toString());
//        String test= LocalDateUtils.getWeekDayString(new Date());
//        System.out.println(test);
//
//
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddhhmmss");
//        LocalDateTime now=LocalDateTime.now();
//        String result=formatter.format(now);
//        System.out.println(result);
//        InterfaceDemo.showMessage();
//        StringBuffer test=new StringBuffer();
//        test.append("22").append("33");
//        test14();
//        System.out.println("22".hashCode());
//        AtomicInteger test=new AtomicInteger();
        //自增
//        test.getAndIncrement();
//        System.out.println(test);
//        test13();
//        test12();
//        test11();
//        judgeEquals();
//        lambdaTest();
//        asyncTest();
//        forTest();
//        forTest2();
//        List<String> test1 = new ArrayList<>();
//        List<String> test2 = new ArrayList<>();
//        test2.add("1");
//        test2.add("2");
//        test2.addAll(test1);
//        System.out.println("22");
//        Integer a;
//        a=127;
//        String test="2019101100101";
//        a=Integer.valueOf(test);
//        a=Integer.getInteger(test);
//        System.out.println(a);
    }

    public static void test14() throws IllegalAccessException {
        SysUser sysUser = new SysUser();
        sysUser.setId("233");
        sysUser.setIdCard("qwe");
        Class cls = sysUser.getClass();
        Field[] fields = cls.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field f = fields[i];
            f.setAccessible(true);
            System.out.println("属性名:" + f.getName() + " 属性值:" + f.get(sysUser));
        }
    }

    /**
     * @author :zhangzhiming
     * description :泛型
     * @date :Create in  2020/2/15 15:46
     */
    public static <T> List<T> page(List<T> list, @NotNull Integer current, @NotNull Integer pageSize) {

        return null;
    }

    public static void test13() {
        List<String> test1 = new ArrayList<>();
        test1.add("22");
        test1.add("33");
        test1.add("55");
        for (String test : test1) {
            test = test + "1";
        }
        System.out.println(test1);
    }


    /**
     * @author :zhangzhiming
     * description :如果两个数都为1则为1，否则为0。
     * @date :Create in  2019/12/17 9:08
     */
    public static void test11() {
        int a = 0;
        if ((1 < 0) & (a++ > 0)) {

        }
        System.out.println("这是a：" + a);
        System.out.println(129 & 128);
    }

    /**
     * @author :zhangzhiming
     * description :相同为0，不同为1
     * @date :Create in  2019/12/17 10:13
     */
    public static void test12() {
        //01
        int a = 1;
        //10
        int b = 2;
        //11
        int c = 3;
        System.out.println("第一个：" + (2 ^ 1));
        System.out.println("第二个：" + (2 ^ 3));
    }

    /**
     * @author :zhangzhiming
     * description :重写equals与hashCode
     * @date :Create in  2019/12/10 11:42
     */
    public static void judgeEquals() {
        List<String> test = new ArrayList<>(2);
        test.add("1");
        test.add("2");
        test.add("3");
        test.add("4");
//        System.out.println("isBlank:"+ StringUtils.isBlank(" "));
//        System.out.println("isEmpty:"+ StringUtils.isEmpty(" "));
//        StringUtils.split("","");
//        String a="233";
//        String b="233";
//        int c=10;
//        int d=10;
//        System.out.println("判断:"+a==b);
//        System.out.println("判断:"+a.equals(b));
//        System.out.println(c==d);
//        Student stu = new Student(123, "Tom");
//        HashSet<Student> set = new HashSet<>();
//        set.add(stu);
//        set.add(new Student(456, "Jerry"));
//        set.add(new Student(123, "Lily"));
//        Iterator<Student> iterator = set.iterator();
//        while (iterator.hasNext()) {
//            Student student = iterator.next();
//            System.out.println(student.getStuNum() + " --- " + student.getName());
//        }
    }

    /**
     * @author zhangzhiming
     * description 测一下   大循环写在内, 小循环写在外 两种写法的区别  抽空用多线程试试
     * @date 17:29 2019/10/10
     */
    private static void forTest() {
        SimpleDateFormat date = new SimpleDateFormat("yyyy年MM月dd日：HH:mm:ss---SSS(毫秒)");
        int count = 0;
        System.out.println("开始时间1：" + date.format(new Date(System.currentTimeMillis())));
        for (int a = 0; a < 2147483647; a++) {
            for (int b = 0; b < 21474836; b++) {
                count++;
            }
        }
        System.out.println("结束时间1：" + count + " " + date.format(new Date(System.currentTimeMillis())));
    }

    private static void forTest2() {
        SimpleDateFormat date = new SimpleDateFormat("yyyy年MM月dd日：HH:mm:ss---SSS(毫秒)");
        int count = 0;
        System.out.println("开始时间2：" + date.format(new Date(System.currentTimeMillis())));
        for (int a = 0; a < 21474836; a++) {
            for (int b = 0; b < 2147483647; b++) {
                count++;
            }
        }
        System.out.println("结束时间2：" + count + " " + date.format(new Date(System.currentTimeMillis())));
    }
}
