package com.dwp.controller;

import com.dwp.service.RedisService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 文档解析控制器
 *
 * @author dengweiping
 * @date 2020/12/31 10:02
 */
@RestController
@RequestMapping("/api/redis")
public class ReadController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReadController.class);
    @Autowired
    private RedisService redisService;

    /**
     * 读取redis
     *
     * @param key
     * @return
     */
    @ApiOperation(value = "读取redis", notes = "读取redis", produces = "application/json")
    @ApiResponses({@ApiResponse(code = 200, message = "查询成功")})
    @RequestMapping(value = "/{key}", method = RequestMethod.GET)
    public ResponseEntity<Object> read(@PathVariable("key") String key) {
        LOGGER.debug("REST request to read redis: {}", key);
        return new ResponseEntity<>(redisService.read(key), HttpStatus.OK);
    }

    /**
     * 写入Redis
     *
     * @param map
     * @return
     */
    @ApiOperation(value = "写入Redis", notes = "写入Redis", produces = "application/json")
    @ApiResponses({@ApiResponse(code = 200, message = "操作成功")})
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> write(@RequestBody Map<String, Object> map) {
        LOGGER.debug("REST request to write redis, data: {}", map);
        return new ResponseEntity<>(redisService.write(map), HttpStatus.OK);
    }

}
