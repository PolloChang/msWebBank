<g:hiddenField name="requestMap.id" value="${requestMapI?.id}"/>
<g:hiddenField name="requestMap.version" value="${requestMapI?.version}"/>
<bootstrap:fromTable>
    <tbody>
    <tr>
        <th>
            ${message(code: "requestMap.configAttribute.label")}
        </th>
        <td>
            <g:each in="${bs.Bs101.findAllByIssureAndPtype(2,'BS_CONFIG_ATTRIBUTE')}" var="bs101I" status="i" >
                <g:checkBox name="requestMap.configAttribut" id="requestMap-configAttribut-${bs101I.pcode}" checked="${requestMapI?.configAttribute?.tokenize(",")?.contains(bs101I.pcode)}" value="${bs101I.pcode}" />${bs101I.typedesc}<br/>
            </g:each>
        </td>
        <th>
            ${message(code:"requestMap.httpMethod.label")}
        </th>
        <td>
            <bootstrap:multipleSelect
                    name="requestMap.httpMethod" value="${requestMapI?.httpMethod}"
                    from="${bs.Bs101?.findAllByPtypeAndIssure('BS_HTTP_METHOD',2)}"
                    optionKey="pcode" optionValue="typedesc"
                    noSelection="['':'---']"
            />
        </td>
    </tr>
    <tr>
        <th>
            ${message(code:"requestMap.url.label")}
        </th>
        <td colspan="3">
            <bootstrap:textField name="requestMap.url" value="${requestMapI?.url}" />
        </td>
    </tr>
    </tbody>
</bootstrap:fromTable>