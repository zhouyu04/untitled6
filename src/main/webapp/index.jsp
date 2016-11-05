<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- The jQuery library is a prerequisite for all jqSuite products -->
    <script type="text/ecmascript" src="/jQuery/jquery-2.2.3.min.js"></script>
    <!-- We support more than 40 localizations -->
    <script type="text/ecmascript" src="/jqGrid-master/js/i18n/grid.locale-cn.js"></script>
    <!-- This is the Javascript file of jqGrid -->
    <script type="text/ecmascript" src="/jqGrid-master/js/jquery.jqGrid.js"></script>
    <!-- This is the localization file of the grid controlling messages, labels, etc.
    <!-- A link to a jQuery UI ThemeRoller theme, more than 22 built-in and many more custom -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <!-- The link to the CSS that the grid needs -->
    <link rel="stylesheet" type="text/css" media="screen" href="/jqGrid-master/css/ui.jqgrid-bootstrap.css" />
    <script>
        $.jgrid.defaults.width = 780;
    </script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <meta charset="utf-8" />
    <title>jqGrid Loading Data - Million Rows from a REST service</title>
</head>
<body>
<%--<div style="margin-left:20px">
    <table id="jqGrid"></table>
    <div id="jqGridPager"></div>
</div>--%>
<hr>
<div style="margin-left:20px">
    <table id="info"></table>
    <div id="jqGridPage2"></div>
</div>
<%--<script type="text/javascript">
    $(document).ready(function () {

        $("#jqGrid").jqGrid({
            url: 'http://trirand.com/blog/phpjqgrid/examples/jsonp/getjsonp.php?callback=?&qwery=longorders',
            mtype: "GET",
            styleUI : 'Bootstrap',
            datatype: "jsonp",
            colModel: [
                { label: 'OrderID', name: 'OrderID', key: true, width: 75 },
                { label: 'Customer ID', name: 'CustomerID', width: 150 },
                { label: 'Order Date', name: 'OrderDate', width: 150 },
                { label: 'Freight', name: 'Freight', width: 150 },
                { label:'Ship Name', name: 'ShipName', width: 150 }
            ],
            viewrecords: true,
            height: 250,
            rowNum: 20,
            pager: "#jqGridPager"
        });
    });
</script>--%>
<script type="text/javascript">
    $(document).ready(function () {

        $("#info").jqGrid({
            url : '${pageContext.request.contextPath}/test',
            postData:{'menuId':$('#menuId').val(),'type':$('#type').val()},
            mtype : "POST",
            styleUI : 'Bootstrap',
            contentType : "application/json",
            datatype : "json",
            colModel : [ {
                label : 'id',
                name : 'id',
                key : true,
            }, {
                label : 'name',
                name : 'name'
            }, {
                label : 'age',
                name : 'age'
            }],
            height : '100%',
            pager : 'jqgrid-pager',
            page : "${page}", //初始化查询页数
            rowNum : "${rows}",
            rowList : [ 10, 20, 30 ],
            sortname : 'createTime',
            sortable : true,
            sortorder : 'desc',
            jsonReader : {
                root : "formList", // json中代表实际模型数据的入口
                records : "records", // json中代表数据行总数的数据
                page : "page", // json中代表当前页码的数据
                total : "total", // json中代表页码总数的数据
                repeatitems : false
            },
            multiselect : true,
        });
        // 当前选择记录ID值
        var id = $("#info").jqGrid("getGridParam", "selarrrow");
        // 取当前面页码
        var page = $('#info').getGridParam('page');
    });
</script>
</body>
</html>
