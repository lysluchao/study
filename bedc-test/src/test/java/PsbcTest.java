import com.lc.bedc.model.BalQueryInfo;
import com.lc.bedc.model.DetailQueryInfo;
import com.lc.bedc.model.EBillDownloadInfo;
import com.lc.bedc.model.HisBalQueryInfo;
import com.lc.bedc.model.HisDetailQueryInfo;
import com.lc.bedc.model.PayInfo;
import com.lc.bedc.model.RequestHead;
import org.junit.Test;

/**
 * 邮储测试
 *
 * @author luchao
 * @version v1.0
 * @date 2022/11/9 15:00
 */
public class PsbcTest {
    @Test
    public void testBal() {
        BalQueryInfo balQueryInfo = new BalQueryInfo();
        balQueryInfo.setBankCode("3403");
        balQueryInfo.setAccId(65911L);
        balQueryInfo.setChannel("CMS");
        balQueryInfo.setGroup("当日余额查询");
        balQueryInfo.setTaskName("当日余额查询_任务名称");
        balQueryInfo.setQDate("2022-10-20");
        RequestHead head = BedcPostUtil.initRequestHead("bal");
        balQueryInfo.setSeqNo(head.getSeqNo());
        BedcPostUtil.send(head, balQueryInfo);
    }

    @Test
    public void testHisBal() {
        HisBalQueryInfo hisBalQueryInfo = new HisBalQueryInfo();
        hisBalQueryInfo.setAccId(65911L);
        hisBalQueryInfo.setBankCode("3403");
        hisBalQueryInfo.setChannel("CMS");
        hisBalQueryInfo.setGroup("历史余额查询");
        hisBalQueryInfo.setTaskName("历史余额查询_任务名称");
        hisBalQueryInfo.setStartDate("2022-02-01");
        hisBalQueryInfo.setEndDate("2022-02-28");
        RequestHead head = BedcPostUtil.initRequestHead("hisbal");
        hisBalQueryInfo.setSeqNo(head.getSeqNo());
        BedcPostUtil.send(head, hisBalQueryInfo);
    }

    @Test
    public void testHisDetail() {
        HisDetailQueryInfo hisDetailQueryInfo = new HisDetailQueryInfo();
        hisDetailQueryInfo.setAccId(65913L);
//        hisDetailQueryInfo.setAccId(5609L);
        hisDetailQueryInfo.setBankCode("3403");
        hisDetailQueryInfo.setChannel("CMS");
        hisDetailQueryInfo.setGroup("ceshi");
        hisDetailQueryInfo.setTaskName("测试查明细");
        hisDetailQueryInfo.setStartDate("2022-11-27");
        hisDetailQueryInfo.setEndDate("2022-12-10");
        String detail = "hisdetail";
        RequestHead head = BedcPostUtil.initRequestHead(detail);
        hisDetailQueryInfo.setSeqNo(head.getSeqNo());
        BedcPostUtil.send(head, hisDetailQueryInfo);
    }

    @Test
    public void testDetail() {
//        DetailQueryInfo detailQueryInfo = new DetailQueryInfo();
//        detailQueryInfo.setAccId(65913L);
//        detailQueryInfo.setBankCode("3403");
//        detailQueryInfo.setChannel("CMS");
//        detailQueryInfo.setGroup("ceshi");
//        detailQueryInfo.setTaskName("测试查明细");
//        detailQueryInfo.setQDate("2022-08-11");
//        String detail = "detail";
//        RequestHead head = BedcPostUtil.initRequestHead(detail);
//        detailQueryInfo.setSeqNo(head.getSeqNo());
//        BedcPostUtil.send(head, detailQueryInfo);
//
        DetailQueryInfo detailQueryInfo = new DetailQueryInfo();
        detailQueryInfo.setAccId(101734L);
        detailQueryInfo.setBankCode("3403");
        detailQueryInfo.setChannel("CMS");
        detailQueryInfo.setGroup("ceshi");
        detailQueryInfo.setTaskName("测试查明细");
        detailQueryInfo.setQDate("2022-12-08");
        String detail = "detail";
        RequestHead head = BedcPostUtil.initRequestHead(detail);
        detailQueryInfo.setSeqNo(head.getSeqNo());
        BedcPostUtil.send(head, detailQueryInfo);
    }

    @Test
    public void testPay() {
        PayInfo payInfo = new PayInfo();
        payInfo.setChannel("CMS"); // CMS 资金结算
        payInfo.setGroup("测试支付"); //
        payInfo.setTaskName("测试任务名称");

        payInfo.setBusiSeqNo("CMS" + System.currentTimeMillis()); // 业务序号
        payInfo.setPayAccId(65911L);
        payInfo.setUrgFlag(0);
        payInfo.setPostscript("付款测试");
        payInfo.setPayBankCode("3403");
        payInfo.setOppClass(0); // 0:对公 , 1：对私
        payInfo.setOppBankCode("3403");
        payInfo.setPurpose("付款测试");
        payInfo.setSummary("测试支付");
        payInfo.setBankFlag(0); // 0:同行 , 1：跨行
        payInfo.setOppBranchCode("308595001013"); // 收款方人行联行号
        payInfo.setOppBranchName("邮储银行惠州分行"); // 收款方人 银行机构名称
        payInfo.setOppAcctNo("100261624350010001");
        payInfo.setOppAcctName("测试姓名010001");
        payInfo.setAmount("151.10");
        payInfo.setAreaFlag(0); // 0:同城 , 1：异地
        RequestHead head = BedcPostUtil.initRequestHead("pay");
        payInfo.setBusiSeqNo(head.getSeqNo());
        payInfo.setSeqNo(head.getSeqNo());
        BedcPostUtil.send(head, payInfo);
    }

    @Test
    public void testEBilDownload() {
        EBillDownloadInfo eBillDownloadInfo = new EBillDownloadInfo();
//        eBillDownloadInfo.setQDate("2022-12-05");
//        eBillDownloadInfo.setAccId(101734L);
//        eBillDownloadInfo.setDetailSeqNo("0000295438202212051929494400100");
//        eBillDownloadInfo.setBankCode("3403");
//        RequestHead head = BedcPostUtil.initRequestHead("ebilldownload");
//        eBillDownloadInfo.setChannel(head.getChannel());
//        eBillDownloadInfo.setSeqNo(head.getSeqNo());
//        eBillDownloadInfo.setTaskName("测试回单下载");
//        eBillDownloadInfo.setGroup("testGroup");

        eBillDownloadInfo.setQDate("2022-11-28");
        eBillDownloadInfo.setAccId(65913L);
        eBillDownloadInfo.setDetailSeqNo("0000287876202211281762918500200");
        eBillDownloadInfo.setBankCode("3403");
        RequestHead head = BedcPostUtil.initRequestHead("ebilldownload");
        eBillDownloadInfo.setChannel(head.getChannel());
        eBillDownloadInfo.setSeqNo(head.getSeqNo());
        eBillDownloadInfo.setTaskName("测试回单下载");
        eBillDownloadInfo.setGroup("testGroup");
        BedcPostUtil.send(head, eBillDownloadInfo);
    }
}
