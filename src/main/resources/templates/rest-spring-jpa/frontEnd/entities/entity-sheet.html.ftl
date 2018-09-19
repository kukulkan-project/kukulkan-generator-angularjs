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

        <hot-table settings=vm.settings datarows="vm.${entityCamelCasePlural}" hot-id="${entityCamelCase}Sheet" height=450>
            <hot-column title="'Id'" data="id" read-only></hot-column>
        </hot-table>
    </div>
</div>