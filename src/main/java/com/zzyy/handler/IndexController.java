package com.zzyy.handler;

import com.zzyy.entity.Customer;
import com.zzyy.response.DataResponse;
import com.zzyy.response.JqgridListForm;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zliu on 16-11-2.
 */
@Controller
public class IndexController {

    private List<Customer> dataList;

    public List<Customer> getDataList() {
        return dataList;
    }

    public void setDataList(List<Customer> dataList) {
        this.dataList = dataList;
    }

    @RequestMapping(value = {"/", "/index"})
    public String index() {

        return "index";
    }

    @RequestMapping(value = {"pojo"})
    @ResponseBody
    public DataResponse<Customer> pojo(
            Customer customer,
            @RequestParam(defaultValue = "1", value = "page") String page,
            @RequestParam(defaultValue = "10", value = "rows") String rows) {

        int totalRecord = 80;
        int records;     //总记录数
        int totalPages;  //总页数
        int pageSize = StringUtils.isEmpty(rows) ? 10 : Integer.valueOf(rows);  //每页显示记录数
        int currPage = StringUtils.isEmpty(page) ? 1 : Integer.valueOf(page); //当前页码
        int totalPage = totalRecord % Integer.parseInt(rows) == 0 ? totalRecord
                / Integer.parseInt(rows) : totalRecord / Integer.parseInt(rows);
        DataResponse response = new DataResponse<Customer>();

        try {
            records = 10;

            response.setData(String.valueOf(records));
            response.setData(String.valueOf(totalPage));
            response.setData(String.valueOf(currPage));
            for (int i = 0; i < 25; i++) {
                dataList.add(new Customer(i, "z3", 20 + i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    @RequestMapping(value = {"test"})
    @ResponseBody
    public JqgridListForm controllerName(
            @RequestParam(value = "page", defaultValue = "1") String page,
            @RequestParam(value = "rows", defaultValue = "10") String rows,
            @RequestParam(value = "sidx", required = false) String sidx,
            @RequestParam(value = "sord", required = false) String sord,
            @RequestParam(value = "searchField", required = false) String searchField) {
       /* // 当前页码
        int pageNo = Integer.parseInt(page);
        // 显示条数，默认10条
        int size = 10;
        if (!StringUtils.isEmpty(rows)) {
            size = Integer.parseInt(rows);
        }
        List list = new ArrayList();
        for (int i = 0; i <25 ; i++) {
            list.add(new Customer(i,"z"+i+"",20+i));
        }*/
        int totalRecord = 25; // 总记录数(应根据数据库取得，在此只是模拟)
        int totalPage = totalRecord % Integer.parseInt(rows) == 0 ? totalRecord
                / Integer.parseInt(rows) : totalRecord / Integer.parseInt(rows)
                + 1;
        try {
            int index = (Integer.parseInt(page) - 1) * Integer.parseInt(rows); // 开始记录数
            int pageSize = Integer.parseInt(rows);
        } catch (Exception ex) {

        }
        ;
        List list = new ArrayList();
        for (int i = 0; i < 25; i++) {
            list.add(new Customer(i, "z" + i + "", 20 + i));
        }
        return new JqgridListForm(Integer.getInteger(page), totalPage, totalRecord, list);

    }
}