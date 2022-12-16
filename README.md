# GraDuationProject_01_HeiMaMovie

> Name: GraDuationProject_01_HeiMaMovie
> Author: Cola
> Time: 2022/12/16 18:48
> To: 视频网页 后台管理


## 项目描述

本次我们课程的主要目是通过一个小项目来探究`毕业设计`应该如何去做，大家可以先来思考这样一个问题，一个好的毕设项目要满足哪些条件？

~~~markdown

~~~

在互联网快速发展的今天，各种视频网站逐步发展起来，比如优酷，爱奇艺等等。大家思考一下：视频网站最核心的功能是什么？

~~~markdown

~~~

黑马影视对标的项目就是此类视频网站，本项目主要功能分成两部分：

- 影视管理系统（管理员使用）

- 影视门户系统（互联网用户使用）


## 技术说明

~~~markdown
* 数据库：mysql

* 项目管理：maven

* 前端技术：html、vue

* 后端技术：SpringBoot、mybatisplus

* 第三方技术：阿里云OSS、阿里云点播、阿里云视频播放器
~~~

## 环境导入

### 数据库导入

![image-20210713174349244](assets/image-20210713174349244.png)

### 工程导入

![image-20210714150207451](assets/image-20210714150207451.png)

![image-20210714145516612](assets/image-20210714145516612.png)



# 影视管理

## 影视列表

### MovieController

在`movie-web-manager模块`创建`com.itheima.controller.MovieController`，添加下面内容

~~~java
package com.itheima.controller;

import com.itheima.domain.Movie;
import com.itheima.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//影视
@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    //查询影视列表
    @RequestMapping("/admin/movie/findAll")
    public List<Movie> findAll() {
        return movieService.findAll();
    }
}
~~~

### MovieService

在`movie-service模块`创建`com.itheima.service.MovieService`，添加下面内容

~~~java
package com.itheima.service;

import com.itheima.domain.Movie;

import java.util.List;

public interface MovieService {

    //查询列表
    List<Movie> findAll();
}
~~~

### MovieServiceImpl

在`movie-service模块`创建`com.itheima.service.impl.MovieServiceImpl`，添加下面内容

~~~java
package com.itheima.service.impl;

import com.itheima.domain.Movie;
import com.itheima.mapper.MovieMapper;
import com.itheima.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieMapper movieMapper;

    @Override
    public List<Movie> findAll() {
        return movieMapper.selectList(null);
    }
}
~~~

## 影视新增

### MovieController

~~~java
    //添加影视
    @RequestMapping("/admin/movie/save")
    public void save(@RequestBody Movie movie) {
        movieService.save(movie);
    }
~~~

### MovieService

~~~java
    //保存
    void save(Movie movie);
~~~

### MovieServiceImpl

~~~java
    @Override
    public void save(Movie movie) {
        movieMapper.insert(movie);
    }
~~~

## 影视修改-回显

>影视修改主要包括两个操作：1. 根据某条记录的标识查询其详情返显到页面  2. 将修改之后的内容保存到数据库

### MovieController

~~~java
    //根据id查询
    @RequestMapping("/admin/movie/findById")
    public Movie findById(Integer id){
        return movieService.findById(id);
    }
~~~

### MovieService

~~~java
    //根据id查询
    Movie findById(Integer id);
~~~

### MovieServiceImpl

~~~java
    @Override
    public Movie findById(Integer id) {
        return movieMapper.selectById(id);
    }
~~~

## 影视修改-修改

### MovieController

~~~java
    //添加影视
    @RequestMapping("/admin/movie/save")
    public void save(@RequestBody Movie movie) {
        if (movie.getId() == null){ //无id,表示要新增
            movieService.save(movie);
        }else{//有id,表示要更新
            movieService.update(movie);
        }
    }
~~~

### MovieService

~~~java
    //更新
    void update(Movie movie);
~~~

### MovieServiceImpl

~~~java
    @Override
    public void update(Movie movie) {
        movieMapper.updateById(movie);
    }
~~~

## 影视删除

### MovieController

~~~java
    //根据id删除
    @RequestMapping("/admin/movie/deleteById")
    public void deleteById(Integer id){
        movieService.deleteById(id);
    }
~~~

### MovieService

~~~java
    //根据id删除
    void deleteById(Integer id);
~~~

### MovieServiceImpl

~~~java
    @Override
    public void deleteById(Integer id) {
        movieMapper.deleteById(id);
    }
~~~

## 影视批量删除

### MovieController

~~~java
    //根据id批量删除
    @RequestMapping("/admin/movie/deleteByIds")
    public void deleteById(Integer[] ids){
        movieService.deleteByIds(ids);
    }
~~~

### MovieService

~~~java
    //根据id批量删除
    void deleteByIds(Integer[] ids);
~~~

### MovieServiceImpl

~~~java
    @Transactional
    @Override
    public void deleteByIds(Integer[] ids) {
        if (ids != null && ids.length > 0) {
            for (Integer id : ids) {
                movieMapper.deleteById(id);
            }
        }
    }
~~~



# 阿里云OSS

## 阿里云OSS

> 图片上传之后，我们可以选择将图片存储在第三方提供的服务平台，在这里我们选择阿里云的oss服务，官网地址：https://www.aliyun.com/product/oss

~~~markdown
1. 开通服务
2. 支付(产品收费)
3. 创建子项目
4. 查看提供一些秘钥
5. 查看使用文档  demo
~~~

### 开通服务

> 选择oss服务, 立即开通，这里推荐使用支付宝账号进行登录；然后店家管理控制台，进入管理系统

![image-20221114181300205](assets/image-20221114181300205.png)

### 创建Bucket

>点击管理控制台，找到Bucket列表，创建Bucket； 然后填写名称、地域、读写权限，其它选项都默认； 最后点击确定完成bucket创建

![image-20221114182434494](assets/image-20221114182434494.png)

### 获取账户秘钥

![image-20210714151748087](assets/image-20210714151748087.png)

###  文件上传代码

>https://help.aliyun.com/document_detail/84781.html

```java
package com.itheima.test;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class OssTest {
    public static void main(String[] args) throws FileNotFoundException {
        // 区域
        String endpoint = "http://oss-cn-beijing.aliyuncs.com";

        // 秘钥
        String accessKeyId = "LTAI4G3uHmEsKn5okn1wWYk6";
        String accessKeySecret = "ZhTbkMEuFhPmRTQvPpQJSRfiY41yCg";
        
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        // 上传文件
        InputStream inputStream = new FileInputStream("C:\\upload\\jr.jpg");
        ossClient.putObject("tanhua-gxm", "haha.jpg", inputStream);

        // 关闭OSSClient。
        ossClient.shutdown();
    }
}
```

## 图片上传

### 工具类

>课程中已经将官网提供的代码制作成了工具类，放在了`movie-common`模块中

![image-20221114195459450](assets/image-20221114195459450.png)

### 配置

> 修改`movie-web-manager`的`application.yaml`文件，在里面配置大家自己的阿里服务器信息

![image-20221114195937312](assets/image-20221114195937312.png)

~~~yaml
# 阿里配置
al:
  oss: #存储
    endpoint: oss-cn-beijing.aliyuncs.com   # 域
    accessKeyId: LTAI5tDut9Ke5Q1eGAcuirpX   # 秘钥
    accessKeySecret: 7XNeasP3svMRr5TZMpxwCyaFg424TI # 秘钥
    bucketName: movie-gxm  # 桶名
    url: https://movie-gxm.oss-cn-beijing.aliyuncs.com  # 访问地址
~~~



### 实现

> 本项目中，当选择图片的时候就将图片发送到服务器保存并且将访问地址返回到页面
>
> 我们需要在`movie-web-manager`中创建`com.itheima.controller.UploadController`,实现文件上传功能

~~~java
package com.itheima.controller;

import com.itheima.common.OssTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class UploadController {

    @Autowired
    private OssTemplate ossTemplate;

    //图片上传
    @RequestMapping("/admin/upload/image")
    public String uploadImage(MultipartFile uploadImage) throws IOException {
        String imagePath = ossTemplate.upload(uploadImage.getOriginalFilename(), uploadImage.getInputStream());
        System.out.println("图片上传之后的访问地址是:" + imagePath);
        return imagePath;
    }
}
~~~

# 阿里云点播

## 阿里云点播

> 官网地址：https://www.aliyun.com/product/vod

### 开通服务

![image-20210714153902942](assets/image-20210714153902942.png)

### 创建存储

![image-20210714160152345](assets/image-20210714160152345.png)

### 上传视频

> 虽然我们使用的是阿里的点播系统，但是本质上阿里还是将文件存在了OSS里面
>
> 存储之后，阿里会返回一个视频在其系统中的唯一ID，后面我们需要根据这个ID获取视频的详细信息(playAuth  playID)

![image-20210714160747427](assets/image-20210714160747427.png)

### SDK使用

>https://help.aliyun.com/document_detail/57723.html

阿里云有个坐标还在测试阶段，没有放入中央仓库，需要我们手动安装一个jar包到本地仓库(在提供好的文件夹中运行下面命令)

~~~shell
mvn install:install-file -DgroupId=com.aliyun -DartifactId=aliyun-sdk-vod-upload -Dversion=1.4.14 -Dpackaging=jar -Dfile=aliyun-java-vod-upload-1.4.14.jar
~~~

## 视频上传

### 工具类

>课程中已经将官网提供的代码制作成了工具类，放在了`movie-common`模块中

![image-20221114201810263](assets/image-20221114201810263.png)

### 配置

> 修改`movie-web-manager`的`application.yaml`文件，在里面配置大家自己的阿里服务器信息

![image-20221114201948246](assets/image-20221114201948246.png)

~~~yaml
# 阿里配置
al:
  oss: #存储
    endpoint: oss-cn-beijing.aliyuncs.com   # 域
    accessKeyId: LTAI5tDut9Ke5Q1eGAcuirpX   # 秘钥
    accessKeySecret: 7XNeasP3svMRr5TZMpxwCyaFg424TI # 秘钥
    bucketName: movie-gxm  # 桶名
    url: https://movie-gxm.oss-cn-beijing.aliyuncs.com  # 访问地址
  vod: # 视频
    regionId: cn-shanghai
    accessKeyId: LTAI5tDut9Ke5Q1eGAcuirpX
    accessKeySecret: 7XNeasP3svMRr5TZMpxwCyaFg424TI
~~~

### 实现

> 在`movie-web-manager`模块中的`UploadController`中添加`uploadVideo`方法

~~~java
    @Autowired
    private VodTemplate vodTemplate;
    
    //视频上传
    @RequestMapping("/upload/video")
    public String uploadVideo(MultipartFile uploadVideo) throws IOException {
        String playId = vodTemplate.uploadVideo(uploadVideo.getOriginalFilename(), uploadVideo.getInputStream());
        System.out.println("视频的播放id是:" + playId);

        return playId;
    }
~~~



# 后台登录

## 管理员登录

### 登录思路分析



### UserController

在`movie-web-manager模块`创建`com.itheima.controller.UserController`，添加下面内容

~~~java
package com.itheima.controller;

import com.itheima.domain.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

//管理员
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    //登录
    @RequestMapping("/admin/user/login")
    public Map<String, String> login(String username, String password) {
        User user = userService.login(username, password);

        Map<String, String> map = new HashMap<String, String>();
        if (user != null) {//登录成功
            map.put("code", "1");
        } else {//登录失败
            map.put("code", "0");
        }

        return map;
    }
}
~~~

### UserService

在`movie-service模块`创建`com.itheima.service.UserService`，添加下面内容

~~~java
package com.itheima.service;

import com.itheima.domain.User;

public interface UserService {

    //根据账号和密码查询用户
    User login(String username, String password);
}
~~~

### UserServiceImpl

在`movie-service模块`创建`com.itheima.service.impl.UserServiceImpl`，添加下面内容

~~~java
package com.itheima.service.impl;

import com.aliyun.vod.upload.common.MD5Util;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.itheima.domain.User;
import com.itheima.mapper.UserMapper;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String username, String password) {
        //前端传过来的密码进行加密
        String passwordWithMd5 = MD5Util.md5(password);

        //根据用户名和加密之后的密码从数据库查询用户
        //select * from user where username = ? and password = ?
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<User>();
        wrapper.eq(User::getUsername,username);
        wrapper.eq(User::getPassword,passwordWithMd5);

        //返回查询结果
        return userMapper.selectOne(wrapper);
    }
}
~~~



## JWT

### 引入

>目前已经实现了登录的功能，但是还存在一个问题，就是用户可以越过登录页面直接去访问列表页面，如何解决这个问题呢？这就需要jwt的支持了

![image-20201219175917983](assets/image-20201219175917983.png)

~~~markdown
* JWT，全称为JSON Web token，是用于对应用程序上的用户进行身份验证的标记。
	在身份验证过程中, 当用户使用其凭据成功登录时，将返回JWT，客户端会将其保存到本地存储中，而后每次请求都会携带。

* JWT本质上就是一个经过加密处理与校验处理的字符串，它由三部分组成：头信息.有效载荷.签名
	头信息: 一般由两部分组成，令牌类型（即：JWT）和散列算法（HMAC、RSASSA、RSASSA-PSS等）
	有效载荷: 一般里面可以存储自定义的实体的信息
	签名: 用于保证消息在传输过程中不会被篡改
~~~

![image-20201216203745734](assets/image-20201216203745734.png)

### 流程

![image-20201216160302413](assets/image-20201216160302413.png)

### 使用

```java
public class JwtUtilTest {
    @Test
    public void testParseToken() {
        Map map = JwtUtil.parseToken("eyJhbGciOiJIUzI1NiJ9.eyJwaG9uZSI6IjEzODAxMzgwMTIzIiwiaWQiOiIxIn0.2nbUycVwcGIfGrm55y6cst7ge5txroxPVZIQ994Pk9s");
        System.out.println(map);
    }

    @Test
    public void testCreateToken() {
        Map map = new HashMap();
        map.put("id", "1");
        map.put("phone", "13801380123");

        String token = JwtUtil.createToken(map);
        System.out.println(token);
    }
}
```

## 访问校验

### 前端拦截器

>在前端拦截器中处理请求和响应
>
>- 请求: 每次请求都会添加一个token
>- 响应: 发现响应状态码为401时,给出错误提示

![image-20221114210513233](assets/image-20221114210513233.png)

### 后端拦截器

> 编写拦截器：在`movie-web-manager`模块中创建`com.itheima.interceptor.LoginInterceptor`

~~~java
package com.itheima.interceptor;

import cn.hutool.core.bean.BeanUtil;
import com.itheima.common.JwtUtil;
import com.itheima.domain.Member;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

//访问拦截器
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {
            String token = request.getHeader("token");//从请求头获取token
            Map map = JwtUtil.parseToken(token);
            BeanUtil.mapToBean(map, Member.class, true);
            return true;//放行
        } catch (Exception e) {
            response.setStatus(401);
            return false;//禁止通行,返回401状态码
        }
    }
}
~~~

> 配置拦截器：在`movie-web-manager`模块中创建`com.itheima.config.ManagerConfig`

~~~java
package com.itheima.config;

import com.itheima.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;

//配置
@Configuration
public class ManagerConfig implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;

    //设置拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //定义放行路径
        ArrayList<String> urls = new ArrayList<>();
        urls.add("/**/*.js");//管理系统静态资源
        urls.add("/**/*.css");//管理系统静态资源
        urls.add("/**/*.jpg");//管理系统静态资源
        urls.add("/**/*.png");//管理系统静态资源
        urls.add("/**/*.html");//管理系统静态资源
        urls.add("/admin/user/login");//管理系统登录请求
        urls.add("/admin/user/logout");//管理系统退出请求

        //配置拦截器和路径
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/admin/**")//拦截所有
                .excludePathPatterns(urls); //放行指定路径
    }
}
~~~

### 修改登录方法

![image-20221114212212232](assets/image-20221114212212232.png)



# 会员管理

>由于前面我们已经完成了影视的管理功能，这里我们快速完成

## MemberController

在`movie-web-manager模块`创建`com.itheima.controller.MemberController`，添加下面内容

~~~java
package com.itheima.controller;

import com.itheima.domain.Member;
import com.itheima.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//会员
@RestController
public class MemberController {

    @Autowired
    private MemberService memberService;

    //查询会员列表
    @RequestMapping("/admin/member/findAll")
    public List<Member> findAll() {
        return memberService.findAll();
    }

    //添加会员
    @RequestMapping("/admin/member/save")
    public void save(@RequestBody Member member) {
        if (member.getId() == null) { //无id,表示要新增
            memberService.save(member);
        } else {//有id,表示要更新
            memberService.update(member);
        }
    }

    //根据id查询
    @RequestMapping("/admin/member/findById")
    public Member findById(Integer id) {
        return memberService.findById(id);
    }

    //根据id删除
    @RequestMapping("/admin/member/deleteById")
    public void deleteById(Integer id) {
        memberService.deleteById(id);
    }

    //根据id批量删除
    @RequestMapping("/admin/member/deleteByIds")
    public void deleteById(Integer[] ids) {
        memberService.deleteByIds(ids);
    }
}
~~~

## MemberService

在`movie-service模块`创建`com.itheima.service.MemberService`，添加下面内容

~~~java
package com.itheima.service;

import com.itheima.domain.Member;
import com.itheima.domain.Movie;

import java.util.List;

public interface MemberService {

    //查询列表
    List<Member> findAll();

    //保存
    void save(Member member);

    //根据id查询
    Member findById(Integer id);

    //更新
    void update(Member member);

    //根据id删除
    void deleteById(Integer id);

    //根据id批量删除
    void deleteByIds(Integer[] ids);
}
~~~

## MemberServiceImpl

在`movie-service模块`创建`com.itheima.service.impl.MemberServiceImpl`，添加下面内容

~~~java
package com.itheima.service.impl;

import com.itheima.domain.Member;
import com.itheima.mapper.MemberMapper;
import com.itheima.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper memberMapper;

    @Override
    public List<Member> findAll() {
        return memberMapper.selectList(null);
    }

    @Override
    public void save(Member member) {
        memberMapper.insert(member);
    }

    @Override
    public Member findById(Integer id) {
        return memberMapper.selectById(id);
    }

    @Override
    public void update(Member member) {
        memberMapper.updateById(member);
    }

    @Override
    public void deleteById(Integer id) {
        memberMapper.deleteById(id);
    }

    @Transactional
    @Override
    public void deleteByIds(Integer[] ids) {
        if (ids != null && ids.length > 0) {
            for (Integer id : ids) {
                memberMapper.deleteById(id);
            }
        }
    }
}
~~~

# 门户系统

## 导航栏

### CategoryController

在`movie-web-portal模块`下创建`com.itheima.controller.CategoryController`

~~~java
package com.itheima.controller;

import com.itheima.domain.Category;
import com.itheima.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    //查询所有分类
    @GetMapping("/portal/category/findAll")
    public List<Category> findAll(){
        return categoryService.findAll();
    }
}
~~~

### CategoryService

在`movie-service模块`下创建`com.itheima.web.service.CategoryService`

~~~java
package com.itheima.service;

import com.itheima.domain.Category;

import java.util.List;

public interface CategoryService {
    
    //查询所有
    List<Category> findAll();
}
~~~

### CategoryServiceImpl

在`movie-service模块`下创建`com.itheima.web.service.impl.CategoryServiceImpl`

~~~java
package com.itheima.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.itheima.domain.Category;
import com.itheima.mapper.CategoryMapper;
import com.itheima.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> findAll() {
        QueryWrapper<Category> wrapper = new QueryWrapper<>();
        return categoryMapper.selectList(wrapper);
    }
}
~~~

## 列表页

>视频列表页是查询指定分类(比如电视剧 电影)的视频列表，所以要根据栏目对应的标识查询

### MovieController

在`movie-web-portal模块`下创建`com.itheima.web.controller.MovieController`

~~~java
package com.itheima.controller;

import com.itheima.domain.Movie;
import com.itheima.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    //根据分类查询
    @RequestMapping("/portal/movie/findByCid")
    public List<Movie> movieList(Integer cid) {
        return movieService.findByCid(cid);
    }
}
~~~

### MovieService

~~~java
    //根据cid查询影视列表
    List<Movie> findByCid(Integer cid);
~~~

### MovieServiceImpl

~~~java
    @Override
    public List<Movie> findByCid(Integer cid) {
        QueryWrapper<Movie> wrapper = new QueryWrapper<>();
        wrapper.eq("cid", cid);//设置查询条件where cid = ?
        return movieMapper.selectList(wrapper);
    }
~~~

## 详情页

>视频详情页要根据传入的视频id查询视频信息，并且要集成阿里的web播放器进行视频播放

```java
    //根据id查询影视详情
    @RequestMapping("/portal/movie/findById")
    public Movie findById(Integer id) throws Exception {
        //1. 查询影视信息
        Movie movie = movieService.findById(id);

        //2. 根据播放id从阿里获取播放秘钥
        if (movie != null && StringUtils.equals(movie.getType(), "2")) {//收费视频
            String playAuth = vodTemplate.getVideoPlayAuth(movie.getPlayId()).getPlayAuth();
            movie.setPlayAuth(playAuth);
        }

        //3. 返回
        return movie;
    }
```

## 阿里播放器

集成文档：https://help.aliyun.com/document_detail/125570.html

功能展示：https://player.alicdn.com/aliplayer/presentation/index.html



# 后期展望

>大家思考下，我们的网站后期还可以添加哪些功能，才能称为一个真正的视频网站呢？

~~~markdown

~~~



>项目库   https://pip.itcast.cn/java



# 论文

## 开题报告

~~~markdown
0. 关于格式

1. 选题的背景及意义
	为什么要选择这个题目
	此项目的实际意义是什么
	搜索----摘抄----替换
2. 课题的基本内容与构想
	你想把这个系统做成什么样
	主要功能是什么, 特色是什么
	主要有哪些模块构成
3. 系统相关技术与开发环境
	开发过程中使用的开发工具和开发技术是什么
	数据库:
	中间件:
	开发工具:
	开发语言:
	管理工具:
4. 系统需求分析与概要设计
	业务流程: 阐述每种角色分别可以做哪些事
	功能结构: 详细描述系统中的一级一级的功能
	数据库概念模型:ER图
		实体:矩形
		属性:椭圆(主键使用PK  外键使用FK表示)
		表关系:菱形  1:N   1:1   M:N
	数据流程分析: DFD图
		外部实体: 矩形
		数据流: 圆角矩形
		加工: 方向箭头
		存储: 双横线
	数据字典
    	数据表结构的详细描述
5. 总结
	已完成部分
	未完成部分
	遇到的问题及解决方案
	研究基础和最终目标: 现成东西和成型项目
	写作进度
6. 参考文献	
~~~

## 正式论文

~~~markdown
0. 任务书
	要完成什么东西(概述、任务描述、阶段任务、进度安排)
1. 摘要
	题目、技术点、章节内容、实现目的、关键词
2. 目录
	自动生成
3. 前言
	吹一下自己的项目，解决了哪些问题，能给社会带来什么福利
4. 选题的背景及意义
5. 内容和基本构想
6. 系统相关技术与开发环境
7. 系统需求分析与概要设计
	上面四三部分把开题报告抄过来，然后稍加润色和补充
	系统界面：界面配合代码
8. 系统测试
	测试理论
	黑盒测试
	白盒测试
9. 结论
	回扣主题
10. 致谢
	感谢导师  感谢朋友  
11. 参考文献
	[编号]作者1,作者2.<<书名>>.出版社.出版日期:参考页码
	
~~~

