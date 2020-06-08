package com.msr.edu.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msr.common.constants.ResultCodeEnum;
import com.msr.common.exception.MSRException;
import com.msr.common.vo.R;
import com.msr.edu.entity.Teacher;
import com.msr.edu.query.TeacherQuery;
import com.msr.edu.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author tom
 * @RestController:方法的返回类型是json格式
 * @RequestMapping:请求路径访问 GetMapping :指向的是查询操作
 * @DeleteMapping: 指向的是删除操作
 * @PostMapping :指向的是添加操作
 * @PutMapping :指向的是修改操作
 * @since 2020-06-05
 * springmvc = servlet
 * festfull风格   CURD的方法用语义化的方式来展示
 */
@Api(description = "讲师管理")
@CrossOrigin //跨域
@RestController
@RequestMapping("/edu/teacher")
public class TeacherController {
    //读取所有讲师的信息
    //定义业务层对象
    @Autowired
    private TeacherService teacherService;


    @ApiOperation(value = "所有讲师列表")
    @GetMapping("/list")
    public R list() {
        List<Teacher> teacherList = teacherService.list(null);
        return R.ok().data("list", teacherList);

    }

    @ApiOperation(value = "根据ID删除讲师")
    @DeleteMapping("{id}")  //路径传参 localhost:8080/list/1
    public R removeById(
            @ApiParam(name = "id", value = "讲师ID", required = true)
            @PathVariable String id) {
        teacherService.removeById(id);
        return R.ok();  //1
    }

    @ApiOperation(value = "分页讲师列表")
    @GetMapping("{page}/{limit}")
    public R pageQuery(
            @ApiParam(name = "teacherQuery", value = "查询对象", required = false)
                    TeacherQuery teacherQuery,
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable
                    Long page,

            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit) {
        if(page <= 0 || limit <= 0){
            //throw new MSRException(21003, "参数不正确1");
            throw new MSRException(ResultCodeEnum.PARAM_ERROR);
        }
        Page<Teacher> pageParam = new Page<>(page, limit);

        //teacherService.page(pageParam,null);
        teacherService.pageQuery(pageParam, teacherQuery);

        List<Teacher> records = pageParam.getRecords();//当前页面的集合
        long total = pageParam.getTotal();//总记录数

        return R.ok().data("total", total).data("rows", records);
    }

    @ApiOperation(value = "新增讲师")
    @PostMapping
    public R save(
            @ApiParam(name = "teacher", value = "讲师对象", required = true)
            @RequestBody
            Teacher teacher){ //传递的是josn对象
        teacherService.save(teacher);
        return R.ok();
    }
    @ApiOperation(value = "根据ID查询讲师")
    @GetMapping("{id}")
    public R getById(
            @ApiParam(name = "id", value = "讲师ID", required = true)
            @PathVariable String id) {
        Teacher teacher = teacherService.getById(id);
        return R.ok().data("item",teacher);
    }


    @ApiOperation(value = "根据ID修改讲师")
    @PutMapping("{id}")
    public R updateById(
            @ApiParam(name = "id",value = "讲师ID",required = true)
            @PathVariable String id,
            @ApiParam(name = "teacher",value = "讲师对象",required = true)
            @RequestBody Teacher teacher){

        teacher.setId(id);
        teacherService.updateById(teacher);
        return R.ok();
    }

}

