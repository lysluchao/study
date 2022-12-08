import com.lc.bedc.model.SpdFinance1902Info;
import com.lc.bedc.model.SpdFinance1904Info;
import com.lc.bedc.model.SpdFinance1905Info;
import com.lc.bedc.model.SpdFinance1907Info;
import com.lc.bedc.model.SpdFinance1920Info;
import com.lc.bedc.model.SpdFinance1928Info;
import com.lc.bedc.model.SpdFinance1929Info;
import com.lc.bedc.model.SpdFinanceEZ20Info;
import com.lc.bedc.model.SpdFinanceFG51Info;
import com.lc.bedc.model.SpdFinanceFG52Info;
import org.junit.Test;

/**
 * 浦发6002端口环境测试
 *
 * @author luchao
 * @version v1.0
 * @date 2022/10/28 16:18
 */
public class Spd6002Test {

    /**
     * 客户账号：93010078801100011659
     * 理财产品编号：2401194014,2401194020
     * <p>
     * 当前报错：交易失败,该客户不是合格投资者且不符合被动认证要求
     *
     * 1902（6002环境）：
     * 账号：93010078801100011659
     * 理财产品编号：2401194005
     */
    @Test
    public void testE1902() {
        SpdFinance1902Info spdFinance1902Info = new SpdFinance1902Info();
        spdFinance1902Info.setAcctNo("93010078801100011659");
        spdFinance1902Info.setProductCode("2401194005");
        spdFinance1902Info.setSubscribeAmnt("1000.02");
        BedcPostUtil.send("40069", spdFinance1902Info);
    }

    /**
     * 1904（6002环境）：
     * 账号：93010078801100011659
     * 理财产品编号：4601418004
     *
     * 先用930B9435180000010这个账户，5501112018这个产品做申购，然后明天再用1905 做操作
     *
     * 先用93010078801100011659这个账户，5501453220这个产品做申购，明天再用1929做操作
     */
    @Test
    public void testE1904() {
        SpdFinance1904Info spdFinance1904Info = new SpdFinance1904Info();
        spdFinance1904Info.setAcctNo("930B9435180000010");
        spdFinance1904Info.setProductCode("5501112018");
        spdFinance1904Info.setApplyAmnt("10000");
        BedcPostUtil.send("40070", spdFinance1904Info);

        spdFinance1904Info.setAcctNo("93010078801100011659");
        spdFinance1904Info.setProductCode("5501453220");
        spdFinance1904Info.setApplyAmnt("10000");
        BedcPostUtil.send("40070", spdFinance1904Info);
    }

    @Test
    public void test1905() {
        SpdFinance1905Info spdFinance1905Info = new SpdFinance1905Info();
        spdFinance1905Info.setProductCode("4601418004");
        spdFinance1905Info.setAcctNo("93010078801100011659");
        spdFinance1905Info.setTransVol("200");
        BedcPostUtil.send("40071", spdFinance1905Info);

        spdFinance1905Info.setProductCode("5501112018");
        spdFinance1905Info.setAcctNo("930B9435180000010");
        spdFinance1905Info.setTransVol("200");
        BedcPostUtil.send("40071", spdFinance1905Info);
    }

    @Test
    public void test1907() {
        SpdFinance1907Info spdFinance1907Info = new SpdFinance1907Info();
        spdFinance1907Info.setAcctNo("93010078801100011659");
        spdFinance1907Info.setOriginalSerialNo("LC3012518201");
        BedcPostUtil.send("40072", spdFinance1907Info);
    }

    /**
     * 1920
     * 用82010078801900000131这个账号测
     */
    @Test
    public void test1920() {
        SpdFinance1920Info spdFinance1920Info = new SpdFinance1920Info();
        spdFinance1920Info.setAcctNo("82010078801900000131");
        spdFinance1920Info.setOperateFlag("0");
        BedcPostUtil.send("40076", spdFinance1920Info);
    }

    /**
     * 通过
     * 对公账号：930B9435180000010、930B8714770000065
     * 理财产品编号：5501616080、4501419256、4501419264
     */
    @Test
    public void test1928() {
        SpdFinance1928Info spdFinance1928Info = new SpdFinance1928Info();
        spdFinance1928Info.setAcctNo("93010078801100011659");
        spdFinance1928Info.setProductCode("4601418004");
        BedcPostUtil.send("40077", spdFinance1928Info);
    }


    /**
     * 6002
     * 客户账号：93010078801000003676
     * 理财产品编号：2401194115
     */
    @Test
    public void test1929() {
        SpdFinance1929Info spdFinance1929Info = new SpdFinance1929Info();
        spdFinance1929Info.setAcctNo("93010078801100011659");
        //spdFinance1929Info.setProductCode("5501453220");
        spdFinance1929Info.setQueryNumber("20");
        spdFinance1929Info.setBeginNumber("1");
        spdFinance1929Info.setProductFlag("");
        BedcPostUtil.send("40078", spdFinance1929Info);
    }

    /**
     * 对公账号：930B9435180000010、930B8714770000065
     * 理财产品编号：5501616080、4501419256、4501419264
     * <p>
     * EZ20 用 账号：930B8714770000065
     * 编号：8501212888
     */
    @Test
    public void testEZ20() {
        SpdFinanceEZ20Info spdFinanceEZ20Info = new SpdFinanceEZ20Info();

        spdFinanceEZ20Info.setBeginNumber("1");
        spdFinanceEZ20Info.setQueryNumber("20");

//        spdFinanceEZ20Info.setAcctNo("930B9435180000010");
//
//        spdFinanceEZ20Info.setProductCode("5501616080");
//        SpdUtil.send("40081", spdFinanceEZ20Info);
//        spdFinanceEZ20Info.setProductCode("4501419256");
//        SpdUtil.send("40081", spdFinanceEZ20Info);
//        spdFinanceEZ20Info.setProductCode("4501419264");
//        SpdUtil.send("40081", spdFinanceEZ20Info);
//
//        spdFinanceEZ20Info.setAcctNo("930B8714770000065");
//
//        spdFinanceEZ20Info.setProductCode("5501616080");
//        SpdUtil.send("40081", spdFinanceEZ20Info);
//        spdFinanceEZ20Info.setProductCode("4501419256");
//        SpdUtil.send("40081", spdFinanceEZ20Info);
//        spdFinanceEZ20Info.setProductCode("4501419264");
//        SpdUtil.send("40081", spdFinanceEZ20Info);

        spdFinanceEZ20Info.setAcctNo("930B8714770000065");
       // spdFinanceEZ20Info.setProductCode("8501212888");
        BedcPostUtil.send("40081", spdFinanceEZ20Info);
    }

    /**
     * FG51 发行年度送2042 状态送0 起始笔数送1 查询笔数送10
     */
    @Test
    public void testFG51() {
        SpdFinanceFG51Info spdFinanceFG51Info = new SpdFinanceFG51Info();
        spdFinanceFG51Info.setProduuctBatchNo("204200019988");
        spdFinanceFG51Info.setBeginNumber("1");
        spdFinanceFG51Info.setQueryNumber("10");
        spdFinanceFG51Info.setPublishYear("");
        spdFinanceFG51Info.setStatus("");
        BedcPostUtil.send("40082", spdFinanceFG51Info);
    }

    /**
     * FG52 账号送 952A9997220008092
     * 期次号 送 204200019988
     * 金额 1000
     */
    @Test
    public void testFG52() {
        SpdFinanceFG52Info spdFinanceFG52Info = new SpdFinanceFG52Info();
        spdFinanceFG52Info.setProduuctBatchNo("202200010535");
        spdFinanceFG52Info.setAmount("100.99");
        spdFinanceFG52Info.setAcctNo("952A5637670000159");
        BedcPostUtil.send("40083", spdFinanceFG52Info);

        spdFinanceFG52Info.setAcctNo("952A7632920000012");
        BedcPostUtil.send("40083", spdFinanceFG52Info);

        spdFinanceFG52Info.setAcctNo("984A9456510003850");
        BedcPostUtil.send("40083", spdFinanceFG52Info);

        spdFinanceFG52Info.setAcctNo("984A967114190000006");
        BedcPostUtil.send("40083", spdFinanceFG52Info);

        spdFinanceFG52Info.setAcctNo("952A9997220008092");
        spdFinanceFG52Info.setProduuctBatchNo("204200019988");
        spdFinanceFG52Info.setAmount("10000");
        BedcPostUtil.send("40083", spdFinanceFG52Info);

    }
}
