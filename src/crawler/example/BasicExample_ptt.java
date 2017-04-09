package crawler.example;

import com.github.abola.crawler.CrawlerPack;
import org.apache.commons.logging.impl.SimpleLog;
import org.jsoup.select.Elements;


/**
 * 爬蟲包程式的全貌，就只有這固定的模式
 * 
 * @author Abola Lee
 *
 */
public class BasicExample_ptt {
	// commit test  1st git commit
	public static void main(String[] args) {

		// set to debug level
		//CrawlerPack.setLoggerLevel(SimpleLog.LOG_LEVEL_DEBUG);

		// turn off logging
		CrawlerPack.setLoggerLevel(SimpleLog.LOG_LEVEL_OFF);

		// 遠端資料路徑
/*		String uri = "https://www.ptt.cc/bbs/Gossiping/M.1491703320.A.848.html";

		System.out.println(
				CrawlerPack.start()
				
				// 參數設定
			    .addCookie("over18","1")	// 設定cookie
				//.setRemoteEncoding("big5")// 設定遠端資料文件編碼
				
				// 選擇資料格式 (三選一)
				//.getFromJson(uri)
			    .getFromHtml(uri)
			    //.getFromXml(uri)
			    
			    // 這兒開始是 Jsoup Document 物件操作
			    //.select("div.push > span.f1.hl.push-tag, div.push > span.hl.push-tag, div.push > span.f3.push-content")
                //.select("div.article-metaline > span.article-meta-value")
				.select("div.push:contains(推)")

		);
	*/
/*		Elements jsoup = CrawlerPack.start()
				.addCookie("over18","1")
				.getFromHtml(uri)
				.select("#main-content.bbs-screen.bbs-content");
		jsoup.select("div,span").remove();
        System.out.println(
        		jsoup.text()
		);
*/
		String uri = "https://www.ptt.cc/bbs/Baseball/index.html";
		System.out.println(

				CrawlerPack.start()
			    //.addCookie("over18","1")	// 設定cookie
			    .getFromHtml(uri)
			    //.select(".btn-group.btn-group-paging > a:eq(1)")
				.select("div.title > a")
		);

	}
}
