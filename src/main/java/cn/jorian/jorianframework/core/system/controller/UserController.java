package cn.jorian.jorianframework.core.system.controller;

import cn.jorian.jorianframework.common.response.ResponseCode;
import cn.jorian.jorianframework.common.response.SystemResponse;
import cn.jorian.jorianframework.core.system.dto.UserAddDTO;
import cn.jorian.jorianframework.core.system.dto.UserFindDTO;
import cn.jorian.jorianframework.core.system.entity.SysUser;
import cn.jorian.jorianframework.core.system.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: jorian
 * @Date: 2019/4/17 09:24
 * @Description:
 */
@RestController
@RequestMapping("/system")
@Api(tags = {"用户管理"})
public class UserController {
 @Autowired
 private UserService userService;

 @ApiOperation(value = "新增用户")
 @RequestMapping(value = "/user", method = RequestMethod.POST)
 public SystemResponse add(@RequestBody @Validated @ApiParam(value = "用户数据") UserAddDTO addDTO) {
  userService.add(addDTO);
  return new SystemResponse(ResponseCode.SUCCESS);
 }

 @ApiOperation("删除用户")
 @RequestMapping(value = "role/{id}", method = RequestMethod.DELETE)
 public SystemResponse roleDelete(@PathVariable("id") @ApiParam(value = "用户id") String id) {
  userService.delete(id);
  return new SystemResponse(ResponseCode.SUCCESS);
 }

 @ApiOperation("更新用户")
 @RequestMapping(value = "role", method = RequestMethod.PUT)
 public SystemResponse roleUpdate(@RequestBody @Validated @ApiParam(value = "用户更新数据") SysUser sysUser) {
  userService.updateById(sysUser);
  return new SystemResponse(ResponseCode.SUCCESS);
 }

 @ApiOperation("用户列表查询")
 @RequestMapping(value = "role/list", method = RequestMethod.GET)
 public SystemResponse roleList(UserFindDTO roleFindDTO) {
  return new SystemResponse(ResponseCode.SUCCESS, userService.getList(roleFindDTO));
 }

 @ApiOperation("用户树查询")
 @RequestMapping(value = "role/tree", method = RequestMethod.GET)
 public SystemResponse roleTree() {
  return new SystemResponse(ResponseCode.SUCCESS, userService.getTree());

 }
}