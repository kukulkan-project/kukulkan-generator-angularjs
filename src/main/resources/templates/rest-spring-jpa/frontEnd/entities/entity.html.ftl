<#if !entity.features.sheetable>
<#assign translateKey>${projectName}App.${entityCamelCase}</#assign>
<div class="widget">
    <rd-widget-header>
        <div class="widget-header ng-binding">
            <i class="fas icon" data-translate="${translateKey}.home.title">${entityCamelCasePlural?cap_first}</i>
        </div>
    </rd-widget-header>
</div>
<jhi-alert></jhi-alert>
<div class="row top">
    <div class="pull-right">
        <button class="btn btn-primary" ui-sref="${entityCamelCase}.new">
            <span class="glyphicon glyphicon-plus"></span>
            <span data-translate="${translateKey}.home.createLabel">
                Create new ${entity.name}
            </span>
        </button>
    </div>
    <div class="col-xs-8 no-padding-right">
        <form name="searchForm" class="form-inline">
            <div class="input-group pull-right">
                <input type="text" class="form-control" ng-model="vm.searchQuery" id="searchQuery" placeholder="{{ '${translateKey}.home.search' | translate }}">
                <span class="input-group-btn width-min">
                    <button class="btn btn-info" ng-click="vm.search(vm.searchQuery)">
                        <span class="glyphicon glyphicon-search"></span>
                    </button>
                </span>
                <span class="input-group-btn width-min" ng-if="vm.currentSearch">
                    <button class="btn btn-info" ng-click="vm.clear()">
                        <span class="glyphicon glyphicon-trash"></span>
                    </button>
                </span>
            </div>
        </form>
    </div>
</div>
<br/>
<div class="table-responsive">
    <table class="jh-table table table-striped">
        <thead>
            <tr jh-sort="vm.predicate" ascending="vm.reverse" callback="vm.transition()">
                <th jh-sort-by="id"><span data-translate="global.field.id">ID</span> <span class="glyphicon glyphicon-sort"></span></th>
                <#list properties as property>
                    <#if property.name?ends_with("ContentType") == false>
                <th jh-sort-by="${property.name}"><span data-translate="${translateKey}.${property.name}">${property.name?cap_first}</span> <span class="glyphicon glyphicon-sort"></span></th>
                    </#if>
                </#list>
                <#include "/rest-spring-jpa/frontEnd/entities/read/associations/header.ftl">
                <#if entity.features.auditable>
                <th jh-sort-by="createdDate">
                    <span data-translate="${translateKey}.createdDate">Created Date</span>
                    <span class="glyphicon fa-sort"></span>
                </th>
                <th jh-sort-by="lastModifiedBy">
                    <span data-translate="${translateKey}.lastModifiedBy">Last Modified By</span>
                    <span class="glyphicon fa-sort"></span>
                </th>
                <th jh-sort-by="lastModifiedDate">
                    <span data-translate="${translateKey}.lastModifiedDate">Last Modified Date</span>
                    <span class="glyphicon fa-sort"></span>
                </th>
                </#if>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <tr ng-repeat="${entityCamelCase} in vm.${entityCamelCasePlural} track by ${entityCamelCase}.id">
                <td><a ui-sref="${entityCamelCase}-detail({id:${entityCamelCase}.id})">{{${entityCamelCase}.id}}</a></td>
                <#list properties as property>
                    <#if property.name?ends_with("ContentType") == false >
                        <#if property.time == true>
                            <#if property.zoneDateTime == true || property.instant == true>
                <td>{{${entityCamelCase}.${property.name} | date:'medium'}}</td>
                            <#elseif property.localDate == true>
                <td>{{${entityCamelCase}.${property.name} | date:'mediumDate'}}</td>
                        </#if>
                        <#elseif property.blob == true>
                            <#if property.clob == true>
                <td>{{${entityCamelCase}.${property.name}}}</td>        
                            <#else>
                <td>
                    <a ng-if="${entityCamelCase}.${property.name}" ng-click="vm.openFile(${entityCamelCase}.${property.name}ContentType, ${entityCamelCase}.${property.name})" data-translate="entity.action.open">open</a>
                    <span ng-if="${entityCamelCase}.${property.name}">{{${entityCamelCase}.${property.name}ContentType}}, {{vm.byteSize(${entityCamelCase}.${property.name})}}</span> 
                </td>     
                            </#if>
                        <#else>
                <td>{{${entityCamelCase}.${property.name}}}</td>
                        </#if>
                    </#if>
                </#list>
                <#include "/rest-spring-jpa/frontEnd/entities/read/associations/association-properties.ftl">
                <#if entity.features.auditable>
                <td>{{${entityCamelCase}.createdDate | date:'dd/MM/yy HH:mm'}}</td>
                <td>{{${entityCamelCase}.lastModifiedBy}}</td>
                <td>{{${entityCamelCase}.lastModifiedDate | date:'dd/MM/yy HH:mm'}}</td>
                </#if>
                <td class="text-right">
                    <div class="btn-group flex-btn-group-container">
                        <button type="submit"
                                ui-sref="${entityCamelCase}-detail({id:${entityCamelCase}.id})"
                                class="btn btn-info btn-sm">
                            <span class="glyphicon glyphicon-eye-open"></span>
                            <span class="hidden-sm-down" data-translate="entity.action.view"></span>
                        </button>
                        <button type="submit"
                                ui-sref="${entityCamelCase}.edit({id:${entityCamelCase}.id})"
                                class="btn btn-primary btn-sm">
                            <span class="glyphicon glyphicon-pencil"></span>
                            <span class="hidden-sm-down" data-translate="entity.action.edit"></span>
                        </button>
                        <button type="submit"
                                ui-sref="${entityCamelCase}.delete({id:${entityCamelCase}.id})"
                                class="btn btn-danger btn-sm">
                            <span class="glyphicon glyphicon-remove-circle"></span>
                            <span class="hidden-sm-down" data-translate="entity.action.delete"></span>
                        </button>
                    </div>
                </td>
            </tr>
        </tbody>
    </table>
</div>
<div class="text-center">
    <jhi-item-count page="vm.page" total="vm.queryCount" items-per-page="vm.itemsPerPage"></jhi-item-count>
    <uib-pagination class="pagination-sm" total-items="vm.totalItems" items-per-page="vm.itemsPerPage" ng-model="vm.page" ng-change="vm.transition()"></uib-pagination>
</div>
<#else>
<#assign translateKey>${projectName}App.${entityCamelCase}</#assign>
<div class="widget">
    <rd-widget-header>
        <div class="widget-header ng-binding">
            <i class="fas icon" data-translate="${translateKey}.home.title">${entityCamelCasePlural?cap_first}</i>
        </div>
    </rd-widget-header>
</div>
<jhi-alert></jhi-alert>
<div class="content container-fluid">
    <div class="well">
        <div class="row">
            <div class="col-md-6">
                <div class="col-md-2">
                    <button type="menu" class="btn pull-left" ng-click="vm.download()" title="Download"><i class="fa fa-download"></i></button>
                </div>
                <div class="col-md-1">
                    <button type="menu" class="btn pull-left" ui-sref="${entityCamelCase}.new"><i class="fa fa-plus"></i></button>
                </div>
            </div>
            <div class="col-md-6 text-right">
                <button type="button" class="btn .navbar-right" ng-click="vm.refresh()">
                    <span class="glyphicon glyphicon-refresh"></span>&nbsp;
                </button>
            </div>
        </div>

        <hot-table settings=vm.settings datarows="vm.${entityCamelCasePlural}" hot-id="${entityCamelCasePlural}Sheet" height=450>
            <hot-column title="'Id'" data="id" read-only/>
            <#list properties as property>
                <#if property.name?ends_with("ContentType") == false>
                <hot-column title="'${property.name?cap_first}'" data ="${property.name}"
                	<#if property.localDate>
                	type="'date'" 
                	date-format="'YYYY-MM-DD'"
                	<#elseif property.number>
                	type="'numeric'" 
                	<#elseif property.boolean>
                	type="'checkbox'" 
                	<#elseif property.literal>
                	type="'text'" 
                	</#if>
                />
                </#if>
            </#list>
            <#list entity.entityReferences as reference>
            	<#if reference.type.name() != "MANY_TO_MANY">
            	<hot-column title="'${reference.propertyName?cap_first}'" data ="${reference.propertyName}.${reference.displayField.name}"
                	type="'text'" 
                	read-only/>
            	</#if>
            </#list>
        </hot-table>
    </div>
</div>
</#if>