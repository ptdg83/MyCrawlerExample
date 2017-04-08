package crawler.example.exam;

import com.github.abola.crawler.CrawlerPack;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


/**
 * 練習：取得任一篇或多篇文章的 Reactions 總數
 * <p>
 * <p>
 * 重點
 * 1. 先利用Graph Api調整出需要的資料
 * 2. 修改程式，使用爬蟲包取得資料
 * 3. 上傳至GitHub
 *
 * @author Abola Lee
 */

/*
*
* https://www.facebook.com/pbplus.me/videos/1348126178534984/
*
* Results:
* {
*  "231902486824031_1348126178534984": {
*    "reactions": {
*      "data": [
*      ],
*      "summary": {
*        "total_count": 17460
*      }
*    },
*    "id": "231902486824031_1348126178534984"
*  }
* }
*
*
* */

public class FacebookExam_Reactions {

    public static void main(String[] args) {

        // 遠端資料路徑

        String uri = "https://graph.facebook.com/v2.6"
                + "/?ids=231902486824031_1348126178534984&fields=reactions.limit(0).summary(total_count)"
                + "&access_token=260436357754749%7C4fce8ce124a2c621e24fdf2468d819d9";


        Elements elems1 =
                CrawlerPack.start()
                        .getFromJson(uri)
                        .select("id");

        Elements elems2 =
                CrawlerPack.start()
                        .getFromJson(uri)
                        .select("reactions");

        String output = "post_id, post_reactions\n";

        // 遂筆處理
        for (Element data1 : elems1) {
            String id = data1.select("id").text();

            for (Element data2 : elems2) {
                // FIXIT
                String reactions = data2.select("total_count").text();
                output += id + "," + reactions + "\n";
            }
        }
        System.out.println(output);

    }
}
