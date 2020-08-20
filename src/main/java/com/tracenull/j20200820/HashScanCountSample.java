package com.tracenull.j20200820;

import io.lettuce.core.*;
import io.lettuce.core.api.sync.RedisCommands;

/**
 * https://mp.weixin.qq.com/s/E3TW_WB3MlUDbSaZddxUEQ
 */
public class HashScanCountSample {
    static String KEY = "HS";
    static int THRESHOLD = 513;
    static int COUNT = 5;

    public static void main(String[] args) throws Exception {
        ScanArgs scanArgs = new ScanArgs().limit(COUNT);
        RedisURI redisURI = RedisURI.create("redis://123456@localhost:6379");
        RedisClient redisClient = RedisClient.create(redisURI);
        RedisCommands<String, String> commands = redisClient.connect().sync();
        commands.del(KEY);
        int total = 10;
        for (int i = 0; i < total; i++) {
            String fv = String.valueOf(i);
            commands.hset(KEY, fv, fv);
        }

        ScanCursor scanCursor = ScanCursor.INITIAL;
        int idx = 1;
        processScan(total, scanArgs, commands, scanCursor, idx);

        for (int i = 0; i < THRESHOLD; i++) {
            String fv = String.valueOf(i);
            commands.hset(KEY, fv, fv);
        }
        scanCursor = ScanCursor.INITIAL;
        total = THRESHOLD;
        idx = 1;
        processScan(total, scanArgs, commands, scanCursor, idx);
    }

    private static void processScan(int total, ScanArgs scanArgs, RedisCommands<String, String> commands, ScanCursor scanCursor, int idx) {
        System.out.println(String.format("%d个F-V的HS的编码:%s", total, commands.objectEncoding(KEY)));
        System.out.println(String.format("%d个F-V的HS进行HSCAN...", total));
        MapScanCursor<String, String> result;
        while (!(result = commands.hscan(KEY, scanCursor, scanArgs)).isFinished()) {
            System.out.println(String.format("%d个F-V的HS进行HSCAN第%d次遍历,size=%d", total, idx, result.getMap().size()));
            scanCursor = new ScanCursor(result.getCursor(), result.isFinished());
            idx++;
        }
        System.out.println(String.format("%d个F-V的HS进行HSCAN第%d次遍历,size=%d", total, idx, result.getMap().size()));
    }
}