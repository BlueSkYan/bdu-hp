package xyz.blueskyan.bduhpuser;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

public class Generator {
    public static void main(String[] args) {
        String path = System.getProperty("user.dir");
        FastAutoGenerator.create("jdbc:mysql://blueskyan.xyz:3307/bdu_hp", "root", "mysql.blueskyan.xyz")
                .globalConfig(builder -> {
                    builder.author("Shijie Yan") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir(path + "/src/main/java/") // 指定输出目录
                            .disableOpenDir();
                })
                .packageConfig(builder -> {
                    builder.parent("xyz.blueskyan") // 设置父包名
                            .moduleName("bduhpuser") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, path + "/src/main/resources/mappers")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("t_xuqiu_type") // 设置需要生成的表名
                            .addTablePrefix("t_") // 设置过滤表前缀
                            .entityBuilder().enableLombok().columnNaming(NamingStrategy.underline_to_camel).enableTableFieldAnnotation()
                            .controllerBuilder().enableRestStyle()
                            .serviceBuilder().formatServiceFileName("%sService");
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
