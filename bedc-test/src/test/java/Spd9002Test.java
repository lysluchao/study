import com.lc.bedc.model.SpdFinance1902Info;
import com.lc.bedc.model.SpdFinance1904Info;
import com.lc.bedc.model.SpdFinance1905Info;
import com.lc.bedc.model.SpdFinance1907Info;
import com.lc.bedc.model.SpdFinance1913Info;
import com.lc.bedc.model.SpdFinance1914Info;
import com.lc.bedc.model.SpdFinance1915Info;
import com.lc.bedc.model.SpdFinance1920Info;
import com.lc.bedc.model.SpdFinance1928Info;
import com.lc.bedc.model.SpdFinance1929Info;
import com.lc.bedc.model.SpdFinanceA481Info;
import com.lc.bedc.model.SpdFinanceDepositQueryInfo;
import com.lc.bedc.model.SpdFinanceEZ17Info;
import com.lc.bedc.model.SpdFinanceEZ20Info;
import com.lc.bedc.model.SpdFinanceFG51Info;
import com.lc.bedc.model.SpdFinanceFG52Info;
import com.lc.bedc.model.SpdFinanceFT20Info;
import org.junit.Test;

/**
 * 浦发理财测试
 *
 * @author luchao
 * @version v1.0
 * @date 2022/10/21 15:01
 */

public class Spd9002Test {

    /**
     * 6002
     * 客户账号：93010078801100011659
     * 理财产品编号：2401194014,2401194020
     * <p>
     * <p>
     * 1902的数据
     * 93010078801100011659
     * 2401194010
     */
    @Test
    public void testE1902() {
        SpdFinance1902Info spdFinance1902Info = new SpdFinance1902Info();
        spdFinance1902Info.setAcctNo("93010078801100011659");
        spdFinance1902Info.setProductCode("2401194020");
        spdFinance1902Info.setSubscribeAmnt("1000.02");
        BedcPostUtil.send("40069", spdFinance1902Info);
        spdFinance1902Info.setProductCode("2401194020");
        BedcPostUtil.send("40069", spdFinance1902Info);
    }

    @Test
    public void testE1904() {
        SpdFinance1904Info spdFinance1904Info = new SpdFinance1904Info();
        spdFinance1904Info.setAcctNo("930B9435180000010");
        spdFinance1904Info.setProductCode("2401194020");
        spdFinance1904Info.setApplyAmnt("1000.02");
        BedcPostUtil.send("40070", spdFinance1904Info);
    }

    /**
     * 产品代码：4501419260   交易客户号：2644609206  卡号：930B9435180000010  持有份额：1000000
     * 产品代码：4501419260   客户号：2835176021  卡号：93010157810060038  持有份额：1000000
     * 产品代码：5501616080   客户号：2835176021  卡号：93010157810060038  持有份额：10000
     * 产品代码：5501616080   客户号：2644609206  卡号：930B9435180000010  持有份额：990000
     * 产品代码：5501616085   客户号：2644609206  卡号：930B9435180000010  持有份额：1480000
     * 产品代码：5501616085   客户号：2835176021  卡号：93010157810060038  持有份额：1700000
     * 产品代码：5501616086   客户号：2644609206  卡号：930B9435180000010  持有份额：99122.64
     * 产品代码：5501616086   客户号：2835176021  卡号：93010157810060038  持有份额：98120.92
     */
    @Test
    public void test1905() {
        SpdFinance1905Info spdFinance1905Info = new SpdFinance1905Info();
        spdFinance1905Info.setTransVol("200");

        spdFinance1905Info.setProductCode("4501419260");
        spdFinance1905Info.setAcctNo("930B9435180000010");
        BedcPostUtil.send("40071", spdFinance1905Info);
        spdFinance1905Info.setAcctNo("93010157810060038");
        BedcPostUtil.send("40071", spdFinance1905Info);

        spdFinance1905Info.setProductCode("5501616080");
        spdFinance1905Info.setAcctNo("93010157810060038");
        BedcPostUtil.send("40071", spdFinance1905Info);
        spdFinance1905Info.setAcctNo("930B9435180000010");
        BedcPostUtil.send("40071", spdFinance1905Info);

        spdFinance1905Info.setProductCode("5501616085");
        spdFinance1905Info.setAcctNo("930B9435180000010");
        BedcPostUtil.send("40071", spdFinance1905Info);
        spdFinance1905Info.setAcctNo("93010157810060038");
        BedcPostUtil.send("40071", spdFinance1905Info);

        spdFinance1905Info.setProductCode("5501616086");
        spdFinance1905Info.setAcctNo("930B9435180000010");
        BedcPostUtil.send("40071", spdFinance1905Info);
        spdFinance1905Info.setAcctNo("93010157810060038");
        BedcPostUtil.send("40071", spdFinance1905Info);
    }

    @Test
    public void test1907() {
        SpdFinance1907Info spdFinance1907Info = new SpdFinance1907Info();
        spdFinance1907Info.setAcctNo("930B9435180000010");
        spdFinance1907Info.setOriginalSerialNo("930B9435180000010930B9435180000010930B9435180000010930B9435180000010930B9435180000010");
        BedcPostUtil.send("40072", spdFinance1907Info);
    }

    /**
     * 通过
     */
    @Test
    public void test1913() {
        SpdFinance1913Info spdFinance1913Info = new SpdFinance1913Info();
        spdFinance1913Info.setAcctNo("930B9435180000010");
        spdFinance1913Info.setQueryNumber("10");
        spdFinance1913Info.setBeginNumber("1");
        BedcPostUtil.send("40073", spdFinance1913Info);
    }

    /**
     * 通过
     * <p>
     * 账号：93010078801100011659
     * 理财产品编号：4601418004
     */
    @Test
    public void test1914() {
        SpdFinance1914Info spdFinance1914Info = new SpdFinance1914Info();
        spdFinance1914Info.setAcctNo("93010078801100011659");
        spdFinance1914Info.setProductCode("4601418004");
        spdFinance1914Info.setBeginDate("20221031");
        spdFinance1914Info.setEndDate("20231031");
        spdFinance1914Info.setBeginNumber("1");
        spdFinance1914Info.setQueryNumber("1");
        BedcPostUtil.send("40074", spdFinance1914Info);
    }

    /**
     * 账号：930B9435180000010
     */
    @Test
    public void test1915() {
        SpdFinance1915Info spdFinance1915Info = new SpdFinance1915Info();
        spdFinance1915Info.setAcctNo("930B9435180000010");
        spdFinance1915Info.setBeginDate("20210601");
        spdFinance1915Info.setEndDate("20210610");
        spdFinance1915Info.setBeginNumber("1");
        spdFinance1915Info.setQueryNumber("20");
        BedcPostUtil.send("40075", spdFinance1915Info);
    }

    /**
     * 没有测试数据
     */
    @Test
    public void test1920() {
        SpdFinance1920Info spdFinance1920Info = new SpdFinance1920Info();
        spdFinance1920Info.setAcctNo("93010078801100011659");
        spdFinance1920Info.setOperateFlag("1");
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
        spdFinance1928Info.setAcctNo("930B9435180000010");
        spdFinance1928Info.setProductCode("5501616080");
        BedcPostUtil.send("40077", spdFinance1928Info);
    }

    /**
     * 6002
     * 客户账号：93010078801000003676
     * 理财产品编号：2401194115
     * <p>
     * 93010078801100011659
     * 1902：2401194005
     * 1904：5501112018
     * 1929：5501453220(必须前一天做完1904后才能做1929)
     */
    @Test
    public void test1929() {
        SpdFinance1929Info spdFinance1929Info = new SpdFinance1929Info();
        spdFinance1929Info.setAcctNo("93010078801100011659");
        spdFinance1929Info.setQueryNumber("20");
        spdFinance1929Info.setBeginNumber("1");
        spdFinance1929Info.setProductCode("4501419359");
        BedcPostUtil.send("40078", spdFinance1929Info);
    }

    /**
     * 9002端口，通过
     */
    @Test
    public void testA481() {
        SpdFinanceA481Info spdFinanceA481Info = new SpdFinanceA481Info();
        spdFinanceA481Info.setAcctNo("370B5652760000010");
        BedcPostUtil.send("40079", spdFinanceA481Info);
        spdFinanceA481Info.setAcctNo("941A8067540000017");
        BedcPostUtil.send("40079", spdFinanceA481Info);
        spdFinanceA481Info.setAcctNo("650E8067540000017");
        BedcPostUtil.send("40079", spdFinanceA481Info);
        spdFinanceA481Info.setAcctNo("115B8067540000010");
        BedcPostUtil.send("40079", spdFinanceA481Info);
        spdFinanceA481Info.setAcctNo("941A8067540000025");
        BedcPostUtil.send("40079", spdFinanceA481Info);
        spdFinanceA481Info.setAcctNo("981E8067540000017");
        BedcPostUtil.send("40079", spdFinanceA481Info);
        spdFinanceA481Info.setAcctNo("985J5652760000011");
        BedcPostUtil.send("40079", spdFinanceA481Info);
        spdFinanceA481Info.setAcctNo("890H8067540000013");
        BedcPostUtil.send("40079", spdFinanceA481Info);

        //使用FT20返回的定期账户查询
        spdFinanceA481Info.setAcctNo("95200076801200000041");
        BedcPostUtil.send("40079", spdFinanceA481Info);

    }

    /**
     * 通过
     */
    @Test
    public void testEZ17() {
        SpdFinanceEZ17Info spdFinanceEZ17Info = new SpdFinanceEZ17Info();
        spdFinanceEZ17Info.setProductCode("4601418004");
        BedcPostUtil.send("40080", spdFinanceEZ17Info);
    }

    /**
     * 通过
     * 对公账号：930B9435180000010、930B8714770000065
     * 理财产品编号：5501616080、4501419256、4501419264
     */
    @Test
    public void testEZ20() {
        SpdFinanceEZ20Info spdFinanceEZ20Info = new SpdFinanceEZ20Info();

        spdFinanceEZ20Info.setBeginNumber("1");
        spdFinanceEZ20Info.setQueryNumber("20");

        spdFinanceEZ20Info.setAcctNo("93010078801100011659");

        spdFinanceEZ20Info.setProductCode("2401194010");
        BedcPostUtil.send("40081", spdFinanceEZ20Info);
    }


    @Test
    public void testFG51() {
        SpdFinanceFG51Info spdFinanceFG51Info = new SpdFinanceFG51Info();
        spdFinanceFG51Info.setPublishYear("2042");
        spdFinanceFG51Info.setProduuctBatchNo("");
        spdFinanceFG51Info.setBeginNumber("1");
        spdFinanceFG51Info.setQueryNumber("11");
        BedcPostUtil.send("40082", spdFinanceFG51Info);
    }

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
    }

    /**
     * 通过
     * <p>
     * 9002
     * 交易客户号：2489675304
     */
    @Test
    public void testFT20() {
        SpdFinanceFT20Info spdFinanceFT20Info = new SpdFinanceFT20Info();
        spdFinanceFT20Info.setTransMasterID("2489675304");
        spdFinanceFT20Info.setBeginNumber("1");
        spdFinanceFT20Info.setQueryNumber("2");
        BedcPostUtil.send("40084", spdFinanceFT20Info);
    }

    @Test
    public void testDeposit() {
        SpdFinanceFT20Info spdFinanceFT20Info = new SpdFinanceFT20Info();
        spdFinanceFT20Info.setTransMasterID("2489675304");
        BedcPostUtil.send("40085", spdFinanceFT20Info);
    }

    @Test
    public void testDepositQuery() {
        SpdFinanceDepositQueryInfo spdFinanceDepositQueryInfo = new SpdFinanceDepositQueryInfo();
        spdFinanceDepositQueryInfo.setSeqNo("400851668417037489");
        spdFinanceDepositQueryInfo.setBeginNumber("1");
        spdFinanceDepositQueryInfo.setQueryNumber("3");
        BedcPostUtil.send("40086", spdFinanceDepositQueryInfo);
    }
}
