package com.zhuwj.dict.config;

import com.zhuwj.dict.service.DictCacheService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 初始化数据字典数据
 * </p>
 *
 * @author zhuwj
 * @since 2020-05-10
 */
@RequiredArgsConstructor
@Component
public class DictCommandLineRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(DictCommandLineRunner.class);

    private final DictCacheService dictCacheService;

    @Override
    public void run(String... args)  {

        logger.info("*********************** dict start cache *********************** ");
        dictCacheService.dictCache();
        logger.info("*********************** dict cache success *********************** ");

    }
}
