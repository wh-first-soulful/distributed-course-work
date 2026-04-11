package com.lightmall.common.redis;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.springframework.stereotype.Component;

import java.nio.charset.Charset;

@Component
public class BloomFilterUtil {

    // 布隆过滤器，用于防止缓存穿透
    private static final BloomFilter<String> bloomFilter = BloomFilter.create(
            Funnels.stringFunnel(Charset.forName("UTF-8")),
            100000, // 预计插入数量
            0.01    // 期望的误判率
    );

    /**
     * 将元素添加到布隆过滤器
     * @param key 元素键
     */
    public void add(String key) {
        bloomFilter.put(key);
    }

    /**
     * 检查元素是否可能存在于布隆过滤器
     * @param key 元素键
     * @return true表示可能存在，false表示一定不存在
     */
    public boolean mightContain(String key) {
        return bloomFilter.mightContain(key);
    }

    /**
     * 批量添加元素到布隆过滤器
     * @param keys 元素键数组
     */
    public void addAll(String... keys) {
        for (String key : keys) {
            add(key);
        }
    }
}
