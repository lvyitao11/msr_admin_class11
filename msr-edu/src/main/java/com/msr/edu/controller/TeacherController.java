package com.msr.edu.controller;


import com.msr.edu.entity.Teacher;
import com.msr.edu.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author tom
 * @since 2020-06-05
 * springmvc = servlet
 * festfull风格   CURD的方法用语义化的方式来展示
 *
 * @RestController:方法的返回类型是json格式
 * @RequestMapping:请求路径访问
 *
 * GetMapping :指向的是查询操作
 * @DeleteMapping:  指向的是删除操作
 * @PostMapping  :指向的是添加操作
 * @PutMapping :指向的是修改操作
 */

@RestController
@RequestMapping("/edu/teacher")
public class TeacherController {
    //读取所有讲师的信息
    //定义业务层对象
    @Autowired
    private TeacherService teacherService;

    @GetMapping
    public List<Teacher> list(){
        return teacherService.list(null);

    }
}

