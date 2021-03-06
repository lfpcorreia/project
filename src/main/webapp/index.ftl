<#assign title = "我的freemarker">

<#macro head>
<script type="text/javascript" src="assets/jquery/1.8.3/jquery.min.js"></script>
</#macro>

<#macro content>

<div class="container">
    <div class="row-fluid">
        <div class="span12" style="text-align: center">
            <h2>人数统计测试</h2>（每10秒刷新一次）
        </div>
        <h4 style="text-align: center;">${mess!}</h4>
    </div>
    <div class="row-fluid" style="margin-top: 30px">
        <div class="span1">
            <span>进</span>
        </div>
        <div class="span10">
            <div class="progress progress-info">
                <div class="bar" style="width: ${count1}%"></div>
            </div>
        </div>
        <div class="span1">
            <span>${count1}人</span>
        </div>
    </div>
    <div class="row-fluid">
        <div class="span1">
            <span>出</span>
        </div>
        <div class="span10">
            <div class="progress progress-success">
                <div class="bar" style="width: ${count2}%"></div>
            </div>
        </div>
        <div class="span1">
            <span>${count2}人</span>
        </div>
    </div>

    <div class="row-fluid">
        <div class="span12">
            <div class="well well-large">
                <p style="font-size: 20px;"> 日志记录 </p>
                <#list logs?reverse as log>
                ${log} <br/>
                </#list>
            </div>
        </div>
    </div>

<#--&lt;#&ndash;&ndash;&gt;-->
<#--<div class="row-fluid">-->
<#--<div class="span1">-->
<#--<span>停留人数</span>-->
<#--</div>-->
<#--<div class="span10">-->
<#--<div class="progress progress-warning">-->
<#--<div class="bar" style="width: ${count3}%"></div>-->
<#--</div>-->
<#--</div>-->
<#--&lt;#&ndash;&ndash;&gt;-->
<#--<div class="span1">-->
<#--<span>${count3}人</span>-->
<#--</div>-->
<#--</div>-->

</div>
</#macro>

<#macro script>
<script type="text/javascript">
    $(function () {
        setTimeout(function () {
            location.reload();
        }, 10000);
    })
</script>
</#macro>
