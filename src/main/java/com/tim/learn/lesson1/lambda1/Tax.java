package com.tim.learn.lesson1.lambda1;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: yangxz
 * @Description:
 * @CreateDate: 2021/8/18/018 17:00
 * @Version: 1.0
 */
public class Tax {

    public static void main(String[] args) {
        double m = 41000;
        double total = m * 12;
        List<Double> list = new ArrayList<>();
        List<List<String>> rows = new ArrayList<>();
        List<String> rowHead = CollUtil.newArrayList("基数","jj","wx","税","到手","到手jj","到手平均","到手平均jj");
        rows.add(rowHead);
        for (int i = 0; i < 26; i++) {
            double x = 6000 + 1000 * i;
            double wx = new BigDecimal(0.175).multiply(new BigDecimal(x)).multiply(new BigDecimal(12)).setScale(1, BigDecimal.ROUND_DOWN).doubleValue();
            double gjj = new BigDecimal(0.07).multiply(new BigDecimal(x)).multiply(new BigDecimal(24)).setScale(1, BigDecimal.ROUND_DOWN).doubleValue();
            double base = total - 84000 - wx;
            double tax = calAll(total - 84000 - wx);
            double allhand = (total - wx - tax);
            double alljj = (total + gjj - wx - tax);
            list.add(alljj);
            System.out.println(x + "-->" + gjj + "-->" + wx + "-->" +
                    new BigDecimal(tax).setScale(1, BigDecimal.ROUND_DOWN).doubleValue() + "-->" +
                    new BigDecimal(allhand).setScale(1, BigDecimal.ROUND_DOWN).doubleValue() + "-->" +
                    new BigDecimal(alljj).setScale(1, BigDecimal.ROUND_DOWN).doubleValue() + "-->" +
                    new BigDecimal(allhand).divide(new BigDecimal(12), 1, BigDecimal.ROUND_DOWN).doubleValue() + "-->" +
                    new BigDecimal(alljj).divide(new BigDecimal(12), 1, BigDecimal.ROUND_DOWN).doubleValue());
            List<String> row = CollUtil.newArrayList(x + "", gjj + "",
                   wx + "",
                    new BigDecimal(tax).setScale(1, BigDecimal.ROUND_DOWN).doubleValue() + "",
                    new BigDecimal(allhand).setScale(1, BigDecimal.ROUND_DOWN).doubleValue() + "",
                    new BigDecimal(alljj).setScale(1, BigDecimal.ROUND_DOWN).doubleValue() + "",
                    new BigDecimal(allhand).divide(new BigDecimal(12), 1, BigDecimal.ROUND_DOWN).doubleValue() + "",
                    new BigDecimal(alljj).divide(new BigDecimal(12), 1, BigDecimal.ROUND_DOWN).doubleValue() + "");
            rows.add(row);
        }
        Arrays.sort(list.toArray());
        System.out.println(list);
        //通过工具类创建writer
        ExcelWriter writer = ExcelUtil.getWriter("d:/writeTest.xlsx");
        //通过构造方法创建writer
        //ExcelWriter writer = new ExcelWriter("d:/writeTest.xls");

        //跳过当前行，既第一行，非必须，在此演示用
        writer.passCurrentRow();

//        //合并单元格后的标题行，使用默认标题样式
//        writer.merge(row1.size() - 1, "测试标题");
        //一次性写出内容，强制输出标题
        writer.write(rows, true);
        //关闭writer，释放内存
        writer.close();
    }


    private static double calAll(double all) {
        double allTax = zeroSub(all, 300000) * 0.25 +
                156000 * 0.20 +
                108000 * 0.1 +
                36000 * 0.03;
        return allTax;
    }

    private static double zeroSub(double a, double b) {
        return a - b > 0 ? a - b : 0;
    }
}
