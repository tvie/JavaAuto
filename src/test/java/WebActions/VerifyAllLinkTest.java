package WebActions;

//import core.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test; //
//import pages.Homepage;

import java.util.List;

public class VerifyAllLinkTest {

    @Test
    public void test() throws InterruptedException {
        // Khởi tạo ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Mở rộng cửa sổ trình duyệt
        driver.manage().window().maximize();

        // Mở trang web
        driver.get("https://sleek-theme-demo.myshopify.com/");

        // In tiêu đề trang ra console
        System.out.println("🟢 Đã mở: " + driver.getTitle());

        // Lấy toàn bộ thẻ <a>
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("🔗 Tổng số thẻ <a>: " + links.size());
        System.out.println("-----------------------------------------------------");

        int index = 1;
        for (WebElement link : links) {
            String href = link.getAttribute("href");
            String text = link.getText().trim();
            String textcontent = link.getAttribute("textContent").trim();
            // In ra toàn bộ thông tin của từng thẻ <a>
            System.out.println("[" + index + "] 🏷️ Text: " + (textcontent.isEmpty() ? "(no text)" : textcontent));
            System.out.println("    🔗 href: " + href);
            System.out.println("-----------------------------------------------------");

            // Kiểm tra link lỗi hoặc thiếu
            if (href == null || href.isEmpty() ||
                    href.endsWith("/#") ||
                    href.startsWith("javascript")) {
                System.out.println("⚠️  Link bị thiếu hoặc không hợp lệ ở vị trí " + index + ": " + textcontent);
                System.out.println("-----------------------------------------------------");
            }

            index++;
        }
        // (Tùy chọn) đóng trình duyệt sau vài giây
        try {
            Thread.sleep(10000); // đợi 5 giây để xem trang
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.quit();

    }
}