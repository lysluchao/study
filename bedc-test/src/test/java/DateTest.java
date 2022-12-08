import com.lc.util.DateUtil;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author luchao
 * @version v1.0
 * @date 2022/10/20 14:15
 */
public class DateTest {

    @Test
    public void test(){
        System.out.println(String.valueOf(new Date()));
    }

    public static void main(String[] args) {
        System.out.println(fem2Yuan("111122777"));
    }


    private static String fem2Yuan(String fen) {
        return fen.substring(0, fen.length() - 2) + "." + fen.substring(fen.length() - 2);
    }

}
