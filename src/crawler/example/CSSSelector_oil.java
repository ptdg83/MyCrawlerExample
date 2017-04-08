package crawler.example;

import com.github.abola.crawler.CrawlerPack;
import org.apache.commons.logging.impl.SimpleLog;

/**
 * 範例: 使用爬蟲包取得八卦版最後50篇文章的網址
 *
 *  Google Chrome 的開發人員工具
 *  在指定的區塊按右鍵 > Copy > Copy Selector
 *
 * @author Abola Lee
 */
class CSSSelector_oil {

    public static void main(String[] args) {

        // set to debug level
        //CrawlerPack.setLoggerLevel(SimpleLog.LOG_LEVEL_DEBUG);

        // turn off logging
        CrawlerPack.setLoggerLevel(SimpleLog.LOG_LEVEL_OFF);

        // 遠端資料路徑
        //String uri = "https://tw.yahoo.com";
        String uri = "http://new.cpc.com.tw/division/mb/oil-more4.aspx";
        System.out.println(
                CrawlerPack.start()

                        // 參數設定
                        //.addCookie("key","value")	// 設定cookie
                        //.setRemoteEncoding("big5")// 設定遠端資料文件編碼

                        // 選擇資料格式 (三選一)
                        //.getFromJson(uri).toString()
                        .getFromHtml(uri)
                        //.getFromXml(uri)

                        // 這兒開始是 Jsoup Document 物件操作
                        //.select(" li:nth-child(2) > div > span > a > span")
                        //汽、柴、燃油歷史價格
                        .select("#formTable > div.TL > h1")

        );
    }
}