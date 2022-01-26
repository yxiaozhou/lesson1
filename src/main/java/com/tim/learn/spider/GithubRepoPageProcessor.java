//package com.tim.learn.spider;
//
//import us.codecraft.webmagic.Page;
//import us.codecraft.webmagic.Site;
//import us.codecraft.webmagic.Spider;
//import us.codecraft.webmagic.processor.PageProcessor;
//
///**
// * @Author: yangxz
// * @Description:
// * @CreateDate: 2020/12/2/002 17:34
// * @Version: 1.0
// */
//public class GithubRepoPageProcessor implements PageProcessor {
//    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000).setTimeOut(10000);
//
////    @Override
//    public void process(Page page) {
//        page.addTargetRequests(page.getHtml().links().regex("(https://github\\.com/[\\w\\-]+/[\\w\\-]+)").all());
//        page.addTargetRequests(page.getHtml().links().regex("(https://github\\.com/[\\w\\-])").all());
//        page.putField("author", page.getUrl().regex("https://github\\.com/(\\w+)/.*").toString());
//        page.putField("name", page.getHtml().xpath("//h1[@class='entry-title public']/strong/a/text()").toString());
//        if (page.getResultItems().get("name")==null){
//            //skip this page
//            page.setSkip(true);
//        }
//        page.putField("readme", page.getHtml().xpath("//div[@id='readme']/tidyText()"));
//    }
//
////    @Override
//    public Site getSite() {
//        return site;
//    }
//
//    public static void main(String[] args) {
//        Spider.create(new GithubRepoPageProcessor()).addUrl("http://webmagic.io/").thread(5).run();
//    }
//}
