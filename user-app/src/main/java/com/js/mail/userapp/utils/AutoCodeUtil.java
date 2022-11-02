package com.js.mail.userapp.utils;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;

import java.util.ArrayList;
import java.util.List;

public class AutoCodeUtil {
    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        //获取当前项目的系统路径
        String projectPath = System.getProperty("user.dir") + "//user-app";
        //自动生成的代码出现的位置
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("js");//设置作者
        gc.setServiceName("%sService");//去除业务层接口的I前缀
        gc.setMapperName("%sDao");//配置生成的接口的名称
        gc.setOpen(false);//自动生成的代码对应的包是否打开
        // gc.setSwagger2(true); 实体属性 Swagger2 注解
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/mail?useUnicode=true&useSSL=false&characterEncoding=utf8");
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("");
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
//        pc.setModuleName("com.woniuxy.dao");
        pc.setParent("com.js.mail.userapp");//设置父级包名
        pc.setEntity("model");//设置实体类所在包的名字
        pc.setMapper("dao");//设置数据访问层的包名
//        pc.setModuleName("%Dao");
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 如果模板引擎是 freemarker
//        String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/com/js/dao"
                        + "/" + tableInfo.getEntityName() + "Dao" + StringPool.DOT_XML;
            }
        });

        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        // templateConfig.setEntity("templates/entity2.java");
        // templateConfig.setService();
        // templateConfig.setController();

        templateConfig.setXml(null);//生成的xml映射文件内容为空
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
       strategy.setInclude("user_address");//指定生成某一张表的代码，如果不配置它，则会自动生成当前数据源所指向的数据库中所有表的代码
        strategy.setNaming(NamingStrategy.underline_to_camel);//表名驼峰映射
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);//字段名驼峰映射
        strategy.setEntityLombokModel(true);//实体类自动加@Data
        strategy.setRestControllerStyle(true);//控制层类上加@RestController
//        strategy.setTablePrefix(pc.getModuleName() + "_");//生成对应的实体类时不要前缀
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new VelocityTemplateEngine());
        mpg.execute();
    }
}

