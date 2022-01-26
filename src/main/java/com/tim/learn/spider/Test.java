package com.tim.learn.spider;

import com.yishuifengxiao.common.crawler.Crawler;
import com.yishuifengxiao.common.crawler.CrawlerBuilder;
import com.yishuifengxiao.common.crawler.domain.eunm.Pattern;
import com.yishuifengxiao.common.crawler.domain.eunm.Rule;
import com.yishuifengxiao.common.crawler.domain.eunm.Statu;
import com.yishuifengxiao.common.crawler.domain.model.ExtractFieldRule;
import com.yishuifengxiao.common.crawler.domain.model.ExtractRule;
import com.yishuifengxiao.common.crawler.domain.model.MatcherRule;
import java.util.Arrays;

/**
 * @Author: yangxz
 * @Description:
 * @CreateDate: 2020/12/2/002 17:45
 * @Version: 1.0
 */
public class Test {

    public static void main(String[] args) {
        // 创建一个提取属性规则
// 该提取规则标识XPATH表示使用XPATH提取器进行提取，
// 该XPATH提取器的XPATH表达式为 //h1/text() ， 该提取提取器的作用顺序是0
        ExtractFieldRule extractFieldRule = new ExtractFieldRule(Rule.XPATH, "//h1/text()", "", 0);

// 创建一个提取项
        ExtractRule extractRule = new ExtractRule();
        extractRule
                // 提取项代码，不能为空,同一组提取规则之内每一个提取项的编码必须唯一
                .setCode("code")
                // 提取项名字，可以不设置
                .setName("加密电子货币名字")
                // 设置提取属性规则
                .setRules(Arrays.asList(extractFieldRule));

// 创建一个风铃虫实例
        Crawler crawler = CrawlerBuilder.create()
                // 风铃虫的起始链接
                .startUrl("https://hk.finance.yahoo.com/cryptocurrencies")
                // 风铃虫会将请求到的网页中的URL先全部提取出来
                // 然后将匹配链接提取规则的链接过滤出来，放入请求池中
                // 请求池中的链接会作为下次抓取请求的种子链接
                // 可以以添加多个链接提取规则，多个规则之间是并列(或连接)的关系
                // 如果不设置则表示提取链接中所有包含域名关键字（例如此例中的yahoo）的链接放入链接池
                // 此例中表示符合该正则表达式的链接都会被提取出来
                .addLinkRule(new MatcherRule(Pattern.REGEX, "https://hk.finance.yahoo.com/quote/.+"))
                // 内容页地址规则是告诉风铃虫哪些页面是内容页
                // 对于复杂情况下，可以与 内容匹配规则 配合使用
                // 只有符合内容页规则的页面才会被提取数据
                // 对于非内容页，风铃虫不会尝试从中提取数据
                // 此例中表示符合该正则表达式的网页都是内容页，风铃虫会从这些页面里提取数据
                .contentPageRule(new MatcherRule(Pattern.REGEX, "https://hk.finance.yahoo.com/quote/.+"))
                // 风铃虫可以设置多个提取项，这里为了演示只设置了一个提取项
                // 增加一个提取项规则
                .addExtractRule(extractRule)
                // 请求间隔时间
                // 如果不设置则使用默认时间10秒，此值是为了防止抓取频率太高被服务器封杀
                .interval(3000)// 每次进行爬取时的平均间隔时间，单位为毫秒，
                .creatCrawler();

        // 启动爬虫实例
        crawler.start();

        // 这里没有设置信息输出器，表示使用默认的信息输出器
        // 默认的信息输出器使用的logback日志输出方法，因此需要看控制台信息

        // 由于风铃虫是异步运行的，所以演示时这里加入循环
        while (Statu.STOP != crawler.getStatu()) {
            try {
                Thread.sleep(1000 * 20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
