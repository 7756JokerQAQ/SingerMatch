package com.yupi.yupao.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 算法工具类
 */
public class AlgorithmUtils {
    /**
     * 编辑距离算法（用于计算最相似的两组标签）
     * 原理：https://blog.csdn.net/DBC_121/article/details/104198838
     *
     * @param tagList1
     * @param tagList2
     * @return
     */
    public static int minDistance(List<String> tagList1, List<String> tagList2) {
        int n = tagList1.size();
        int m = tagList2.size();

        if (n * m == 0) {
            return n + m;
        }

        int[][] d = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            d[i][0] = i;
        }

        for (int j = 0; j < m + 1; j++) {
            d[0][j] = j;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                int left = d[i - 1][j] + 1;
                int down = d[i][j - 1] + 1;
                int left_down = d[i - 1][j - 1];
                if (!Objects.equals(tagList1.get(i - 1), tagList2.get(j - 1))) {
                    left_down += 1;
                }
                d[i][j] = Math.min(left, Math.min(down, left_down));
            }
        }
        return d[n][m];
    }
    // 计算余弦相似度
    public static int cosineSimilarity(List<String> tag1, List<String> tag2) {
        // 将两个标签列表转换为向量
        Map<String, Integer> vector1 = getVector(tag1);
        Map<String, Integer> vector2 = getVector(tag2);

        // 计算两个向量的点积
        int dotProduct = 0;
        for (String key : vector1.keySet()) {
            if (vector2.containsKey(key)) {
                dotProduct += vector1.get(key) * vector2.get(key);
            }
        }

        // 计算两个向量的模长
        double magnitude1 = getMagnitude(vector1);
        double magnitude2 = getMagnitude(vector2);

        // 计算余弦相似度
        double cosineSimilarity = dotProduct / (magnitude1 * magnitude2);

        return (int)cosineSimilarity;
    }

    // 将标签列表转换为向量
    public static Map<String, Integer> getVector(List<String> tags) {
        Map<String, Integer> vector = new HashMap<>();
        for (String tag : tags) {
            vector.put(tag, vector.getOrDefault(tag, 0) + 1);
        }
        return vector;
    }

    // 计算向量的模长
    public static double getMagnitude(Map<String, Integer> vector) {
        double magnitude = 0;
        for (int value : vector.values()) {
            magnitude += Math.pow(value, 2);
        }
        return Math.sqrt(magnitude);
    }
}
