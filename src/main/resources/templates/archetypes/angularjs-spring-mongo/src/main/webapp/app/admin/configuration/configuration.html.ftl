<div>
    <h2 data-translate="configuration.title">Configuration</h2>

    <span data-translate="configuration.filter">Filter (by prefix)</span> <input type="text" ng-model="filter" class="form-control">
    <h3 ng-hide="filteredConfig.length === 0">Spring configuration</h3>
    <table class="table table-condensed table-striped table-bordered table-responsive"
        style="table-layout:fixed" ng-hide="filteredConfig.length === 0">
        <thead>
        <tr>
            <th ng-click="predicate = 'prefix'; reverse=!reverse" class="col-sm-4"><span data-translate="configuration.table.prefix">Prefix</span></th>
            <th data-translate="configuration.table.properties" class="col-sm-8">Properties</th>
        </tr>
        </thead>

        <tr ng-repeat="entry in filtered = (vm.configuration | filter:filter | orderBy:predicate:reverse)">
            <td><span>{{entry.prefix}}</span></td>
            <td>
                <div class="row" ng-repeat="(key, value) in entry.properties">
                    <div class="col-md-4">{{key}}</div>
                    <div class="col-md-8">
                        <span class="pull-right label label-success break">{{value}}</span>
                    </div>
                </div>
            </td>
        </tr>
    </table>
    <div ng-repeat="(key, value) in vm.allConfiguration">
        <h4 ng-hide="filtered.length === 0"><span>{{key}}</span></h4>
        <table class="table table-condensed table-striped table-bordered table-responsive"
               style="table-layout:fixed" ng-hide="filtered.length === 0">
            <thead>
            <tr>
                <th class="col-sm-4">Property</th>
                <th class="col-sm-8">Value</th>
            </tr>
            </thead>
            <tbody>
            <tr ng-repeat="item in filtered = (value | filter:filter)">
                <td class="break">{{item.key}}</td>
                <td class="break">
                    <span class="pull-right label label-success break">{{item.val}}</span>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
