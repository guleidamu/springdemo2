package com.businessOracle.businessOracle.service.StudentServiceImpl;

import com.businessOracle.businessOracle.data.dto.SearchStudentDto;
import com.businessOracle.businessOracle.data.entity.Course;
import com.businessOracle.businessOracle.data.entity.Student;
import com.businessOracle.businessOracle.data.vo.SchoolClassVo;
import com.businessOracle.businessOracle.data.vo.StudentVo;
import com.businessOracle.businessOracle.mapper.StudentMapper;
import com.businessOracle.businessOracle.service.StudentService;
import com.businessOracle.businessOracle.util.CallBackTest;
import com.businessOracle.businessOracle.util.SendEMailUtil;
import com.businessOracle.businessOracle.util.ThreadPool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Service("studentServiceImpl")
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentMapper studentMapper;

    @Override
    public ArrayList<StudentVo> getStudentByName(SearchStudentDto searchStudentDto) {
        String name = searchStudentDto.getName();
        return studentMapper.getStudentByName(name);
    }

    /**
     * 一条插入一次，遍历n次
     * 插入100000条数据总共耗时：66.712秒
     * @param student
     * @return
     */

    @Override
    public int insertStudent(Student student) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date beginTime = new Date();
        int row = 100000;
        int total = 0;
        for (int i = 0; i < row; i++) {
            Date now = new Date();
            Date dd = new Date();
            //格式化
            SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String createTime = sim.format(now);
            student.setStudentBirthday(now);
            student.setStudentName(Integer.toString(i));
            student.setCreateTime(createTime);
            student.setUpdateTime(createTime);
            total += studentMapper.insertStudent(student);
        }
        Date endTime = new Date();
        log.info("开始时间:" + df.format(beginTime));
        log.info("结束时间:" + df.format(endTime));
        float interval = (float) (endTime.getTime() - beginTime.getTime()) / 1000;
        log.info("插入" + row + "条数据总共耗时：" + interval + "秒");
        return total;
    }

    /**
     * 多线程：插入100000条，单个线程处理的数据量100条,一条条插入。总共耗时：24.383秒
     * 多线程：插入100000条数据,单个线程处理的数据量100条，一起批量插入。 总共耗时：3.035秒
     *  多线程：插入500000条数据,单个线程处理的数据量500条,一起批量插入总共耗时：17.328秒
     * @param student
     * @return
     */
    @Override
    public int insertStudentMethod(Student student) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date beginTime = new Date();
        List<Student> studentList = new ArrayList<>();
        int total = 0;
        int row = student.getNo1();
        int batchCount = student.getNo2();
        for (int i = 0; i < row; i++) {
//            int studnetSeq = studentMapper.studentSeq();
            Date now = new Date();
            String createTime = df.format(now);
            Student studentAdd = new Student();
//            studentAdd.setStudentNo(studnetSeq);
            studentAdd.setStudentBirthday(now);
            studentAdd.setStudentName(Integer.toString(i));
            studentAdd.setCreateTime(createTime);
            studentAdd.setUpdateTime(createTime);
            studentList.add(studentAdd);
        }

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("hello" + i);
        }

        ThreadPool<String> tool = new ThreadPool(batchCount, studentList);
        tool.setCallBackTest(new CallBackTest() {
            @Override
            public void callBackTestMethod(List studentList) {
//                for (int i = 0; i < studentList.size(); i++) {
////                    studentMapper.insertStudentBatchNotSeq(list);
//                    Student insertStudent = (Student) studentList.get(i);
//                    studentMapper.insertStudent(insertStudent);
//                }
                studentMapper.insertStudentBatchNotSeq(studentList);
            }
        });
        try {
            tool.excute();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Date endTime = new Date();
        log.info("批量插入开始时间:" + df.format(beginTime));
        log.info("批量插入结束时间:" + df.format(endTime));
        long endTimeLong = endTime.getTime();
        long beginTimeLong = beginTime.getTime();
        float end = (float) (endTimeLong - beginTimeLong) /1000;
        double doubleEnd = (double) (endTimeLong - beginTimeLong) /1000;
        DecimalFormat dataFormat=new DecimalFormat("0.00");
        float interval = (float) (endTime.getTime() - beginTime.getTime()) / 1000;
        log.info("插入" + row + "条数据,每次插入" + batchCount + "条,总共耗时：" + interval + "秒");
        return total;
    }

    //一条一条获取序列号，new一个对象出来，总共n条一起插入数据库。程序报错：Java heap space内存溢出
    @Override
    public int insertStudentList(Student student) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date beginTime = new Date();
        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<Student> studentList = new ArrayList<>();
        int row = 1000000;
        for (int i = 0; i < row; i++) {
            int studnetSeq = studentMapper.studentSeq();
            Date now = new Date();
            Date dd = new Date();
            String createTime = sim.format(now);
            Student studentAdd = new Student();
            studentAdd.setStudentNo(studnetSeq);
            studentAdd.setStudentBirthday(now);
            studentAdd.setStudentName(Integer.toString(i));
            studentAdd.setCreateTime(createTime);
            studentAdd.setUpdateTime(createTime);
            studentList.add(studentAdd);
        }
        int j = studentMapper.insertStudentBatch(studentList);
        Date endTime = new Date();
        log.info("批量插入开始时间:" + df.format(beginTime));
        log.info("批量插入结束时间:" + df.format(endTime));
        float interval = (endTime.getTime() - beginTime.getTime()) / 1000;
        log.info("插入" + row + "条数据总共耗时：" + interval + "秒");
        return j;
    }

    /**
     * 一条条获取序列号，new n个对象，分批次每次c条，插入数据库。正常
     *插入100001条数据,每次插入150条,总共耗时：30.772秒
     * @param student
     * @return
     */
    //
    @Override
    public int insertStudentBatch(Student student) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date beginTime = new Date();
        List<Student> studentList = new ArrayList<>();
        int total = 0;
        int row = 1000001;
        int batchCount = 150;
        int batchLastIndex = batchCount;
        for (int i = 0; i < row; i++) {
            int studnetSeq = studentMapper.studentSeq();
            Date now = new Date();
            String createTime = df.format(now);
            Student studentAdd = new Student();
            studentAdd.setStudentNo(studnetSeq);
            studentAdd.setStudentBirthday(now);
            studentAdd.setStudentName(Integer.toString(i));
            studentAdd.setCreateTime(createTime);
            studentAdd.setUpdateTime(createTime);
            studentList.add(studentAdd);
        }
        List<Student> insertStudentList = new ArrayList<>();
        for (int index = 0; index < studentList.size(); ) {
            if (batchLastIndex >= studentList.size()) {
                batchLastIndex = studentList.size();
                insertStudentList = studentList.subList(index, batchLastIndex);
                index = batchLastIndex;//设置下一批下标
                batchLastIndex = index + (batchCount);
            } else {
                insertStudentList = studentList.subList(index, batchLastIndex);
                index = batchLastIndex;//设置下一批下标
                batchLastIndex = index + (batchCount);
            }
            //批量插入
            total += studentMapper.insertStudentBatch(insertStudentList);
        }
//        int j = studentMapper.insertStudentBatch(studentList);
        Date endTime = new Date();
        log.info("批量插入开始时间:" + df.format(beginTime));
        log.info("批量插入结束时间:" + df.format(endTime));
        float interval = (float) (endTime.getTime() - beginTime.getTime()) / 1000;
        log.info("插入" + row + "条数据,每次插入" + batchCount + "条,总共耗时：" + interval + "秒");
        return total;
    }

    /**
     * 批量录入，序列号在mybatis插入的时候自动获取，
     * 插入100000条数据,每次插入150条,总共耗时：7.235秒
     */
    @Override
    public int insertStudentBatchNotSeq(Student student) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date beginTime = new Date();
        List<Student> studentList = new ArrayList<>();
        int total = 0;
        int row = 100000;
        int batchCount = 150;
        int batchLastIndex = batchCount;
        for (int i = 0; i < row; i++) {
//            int studnetSeq = studentMapper.studentSeq();
            Date now = new Date();
            String createTime = df.format(now);
            Student studentAdd = new Student();
//            studentAdd.setStudentNo(studnetSeq);
            studentAdd.setStudentBirthday(now);
            studentAdd.setStudentName(Integer.toString(i));
            studentAdd.setCreateTime(createTime);
            studentAdd.setUpdateTime(createTime);
            studentList.add(studentAdd);
        }
        List<Student> insertStudentList = new ArrayList<>();
        for (int index = 0; index < studentList.size(); ) {
            if (batchLastIndex >= studentList.size()) {
                batchLastIndex = studentList.size();
                insertStudentList = studentList.subList(index, batchLastIndex);
                index = batchLastIndex;//设置下一批下标
                batchLastIndex = index + batchCount;
            } else {
                insertStudentList = studentList.subList(index, batchLastIndex);
                index = batchLastIndex;//设置下一批下标
                batchLastIndex = index + batchCount;
            }
            //批量插入
            total += studentMapper.insertStudentBatchNotSeq(insertStudentList);
        }
//        int j = studentMapper.insertStudentBatch(studentList);
        Date endTime = new Date();
        log.info("批量插入开始时间:" + df.format(beginTime));
        log.info("批量插入结束时间:" + df.format(endTime));
        long endTimeLong = endTime.getTime();
        long beginTimeLong = beginTime.getTime();
        float end = (float) (endTimeLong - beginTimeLong) /1000;
        double doubleEnd = (double) (endTimeLong - beginTimeLong) /1000;
        DecimalFormat dataFormat=new DecimalFormat("0.00");
        float interval = (float) (endTime.getTime() - beginTime.getTime()) / 1000;
        log.info("插入" + row + "条数据,每次插入" + batchCount + "条,总共耗时：" + interval + "秒");
        return total;
    }

    @Override
    public int insertStudentBatchThreadAndNotSeq(Student student) {
        return 0;
    }

    @Override
    public int insertCourse(Course course) {
        int j = studentMapper.insertCourse(course);
        int m = 1 / 0;
        return j;
    }

    @Override
    public int sendMail() {
        SendEMailUtil sendEMailUtil = new SendEMailUtil();
        try {
            sendEMailUtil.setSimpleMail();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public ArrayList<SchoolClassVo> querySchoolClassAndStudents(String teacherName) {
        return studentMapper.selectSchoolClass(teacherName);
    }

    public int insertCourseTo(Course course) {
        return 0;
    }
}
