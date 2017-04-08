package crawler.example.exam;

import com.github.abola.crawler.CrawlerPack;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


/**
 * 練習：取得任一篇或多篇文章的 Reactions 總數
 *
 *
 * 重點
 * 1. 先利用Graph Api調整出需要的資料
 * 2. 修改程式，使用爬蟲包取得資料
 * 3. 上傳至GitHub
 * 
 * @author Abola Lee
 *
 */
public class FacebookExam_BDSE0411 {
	
	public static void main(String[] args) {
		
		// 遠端資料路徑

		String uri = 
				"https://graph.facebook.com/v2.6"
				+ "/chuchupepper/insights?since=1440019257&until=1440278457"
				+ "&access_token=EAACEdEose0cBACvImeP9zHrP9GUwjzADRjI4tRuojl7oWDpvhra9jMi4ZC3e52zymPMJSiFeJnHvNv9vMiAPiIp0Uvm1RrOcWZCIfZAfCZCpSyq6pTb21nEUGd8kJv0ZBQp36FmjgTKfL0V775NdMCoAE5t6BvoctdDKjUN9BfbWtMHAo9vvoFMlvbco1gNsZD";


		Elements elems =
				CrawlerPack.start()
				.getFromJson(uri)
				.select("data");
		
		String output = "id,reactions";

		// 遂筆處理
		for( Element data: elems ){
			String id = data.select("id").text();

			// FIXIT
			String reactions = "";


			output += id + "," + reactions + "\n";
		}

		System.out.println( output );
	} 
}
