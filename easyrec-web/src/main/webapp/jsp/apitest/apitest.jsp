<%-- 
    Document   : apitest
    Created on : 18.08.2015, 14:49:51
    Author     : stephan
--%>

<input id="host" style="width:100%" value="http://localhost:8084/easyrec-web/api/1.1/json/"><br>
servletname
<select id="servletname" style="width:100%;">
    <option>view</option>
    <option>buy</option>
    <option>rate</option>
    <option>track</option>
    <option>otherusersalsoviewed</option>
    <option>otherusersalsobought</option>
    <option>itemsratedgoodbyotherusers</option>
    <option>recommendationsforuser</option>
    <option>relateditems</option>
    <option>itemtypes</option>
    <option>clusters</option>
    <option>itemsofcluster</option>
    <option>mostvieweditems</option>
    <option>mostboughtitems</option>
    <option>mostrateditems</option>
    <option>bestrateditems</option>
    <option>worstrateditems</option>
    <option>importrule</option>
    <option>importitem</option>
    <option>setitemactive</option>
</select>

<hr/>
apikey<input id="apikey" style="width:100%" value="${apikey}"><br>
tenantid<input id="tenantid" style="width:100%" value="${tenantId}"><br>
<hr/>
itemid<input id="itemid" style="width:100%"><br>
itemdescription<input id="itemdescription" style="width:100%"><br>
itemurl<input id="itemurl" style="width:100%"><br>
itemimageurl<input id="itemimageurl" style="width:100%"><br>
userid<input id="userid" style="width:100%"><br>
sessionid<input id="sessionid" style="width:100%"><br>
itemtype<input id="itemtype" style="width:100%"><br>
actiontime<input id="actiontime" style="width:100%"><br>
ratingvalue<input id="ratingvalue" style="width:100%"><br>
actionInfo<input id="actionInfo" style="width:100%"><br>
<hr/>
numberOfResults<input id="numberOfResults" style="width:100%"><br>
requesteditemtype<input id="requesteditemtype" style="width:100%"><br>
withProfile<input id="withProfile" style="width:100%"><br>
<hr/>
timeRange<input id="timeRange" style="width:100%"><br>
<hr/>
clusterid<input id="clusterid" style="width:100%"><br>
strategy<input id="strategy" style="width:100%"><br>
usefallback<input id="usefallback" style="width:100%"><br>
<hr/>
token<input id="token" style="width:100%"><br>
assoctype<input id="assoctype" style="width:100%"><br>
<a href="javascript:send();">SEND ACTION</a>

<script>
    var url = "";
    function send() {
        url = document.getElementById("host").value +
                document.getElementById("servletname").value + "?";

        url += "apikey=" + document.getElementById("apikey").value + "&" +
                "tenantid=" + document.getElementById("tenantid").value + "&";


        addValue("itemdescription");
        addValue("itemid");
        addValue("itemurl");
        addValue("itemimageurl");
        addValue("userid");
        addValue("sessionid");
        addValue("itemtype");
        addValue("actiontime");
        addValue("ratingvalue");
        addValue("numberOfResults");
        addValue("requesteditemtype");
        addValue("timeRange");
        addValue("clusterid");
        addValue("strategy");
        addValue("usefallback");
        addValue("token");
        addValue("assoctype");
        addValue("withProfile");
        addValue("actionInfo");

        document.getElementById("iframe").src = url;
        document.getElementById("debug").innerHTML = url;
    }

    function addValue(name) {
        if (document.getElementById(name).value != "") {
            url += name + "=" + document.getElementById(name).value + "&";
        }
    }
</script>

<div id="debug" style="background:#eee;"> URL FIELD</div>
<iframe id="iframe" src="../../../../../../../../Dokumente%20und%20Einstellungen/dmann/Desktop"
        style="width:100%;height:600px;"></iframe>
