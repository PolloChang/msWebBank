<%--
  動態階層選單
  Created by IntelliJ IDEA.
  User: JamesChang
  Date: 2019/4/7
  Time: 上午 09:49
--%>
<g:each in="${bs.Bs000.findAllByStatusAndShowOnMenuAndActionType("5",true,"isDropdown",[sort:'idx',order:'asc'])}" var="row" status="i">
    <g:set var="childAppL" value="${bs.Bs000.findAllByStatusAndShowOnMenuAndParentApp("5",true,row.appName,[sort:'idx',order:'asc'])}" />
    <g:set var="childAppSize" value="${childAppL.size()}" />
    <g:if test="${childAppSize>0}">
        <div class="card">
            <div class="card-header" id="heading_${i}">
                <h2 class="mb-0">
                    <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#collapse_${i}" aria-expanded="true" aria-controls="collapse_${i}">
                        <icon:svg iconType="folder" message="${row.appCname}" />
                    </button>
                </h2>
            </div>
            <div id="collapse_${i}" class="collapse" aria-labelledby="heading_${i}">
                <div class="card-body">
                    <ul class='nav flex-column'>
                        <g:if test="${(row.controller) && (row.action)}">
                            <li id="tab-select-${row.id.toString()}" class="nav-item" onclick="changeIframeMain('${createLink(controller:row.controller,action: row.action)}','${row.id.toString()}')">
                                <a class='nav-link' href='#'>
                                    <icon:svg iconType="fileWhite" message="${row.appCname}" />
                                </a>
                            </li>
                        </g:if>
                        <g:each in="${childAppL}" var="rowL">
                            <li id="tab-select-${rowL.id.toString()}" class="nav-item" onclick="changeIframeMain('${createLink(controller:rowL.controller,action: rowL.action)}','${rowL.id.toString()}')">
                                <a class='nav-link' href='#'>
                                    <icon:svg iconType="fileWhite" message="${rowL.appCname}" />
                                </a>
                            </li>
                        </g:each>
                    </ul>
                </div>
            </div>
        </div>
    </g:if>
    <g:else>
        <ul class='nav flex-column'>
            <li id="tab-select-${row.id.toString()}" class="nav-item" onclick="changeIframeMain('${createLink(controller:row.controller,action: row.action)}','${row.id.toString()}','${row.appCname}')">
                <a class='nav-link' href='#'>
                    <icon:svg iconType="fileWhite" message="${row.appCname}" />
                </a>
            </li>
        </ul>
    </g:else>


</g:each>