<div class="container-fluid">
    <h2 data-translate="audits.title">Audits</h2>
    <hr class="black"/>
    <div class="row">
        <div class="col-md-6">
            <h4 data-translate="audits.filter.title">Filter by date</h4>
            <div class="col-md-6">
                <div class="form-group datepicker-group">
                    <label class="control-label" for="fromDate" data-translate="audits.filter.from">from:</label>
                    <input id="fromDate" class="form-control" placeholder="aaaa-mm-dd" maxlength="10"
                           name="start" ng-model="vm.fromDate" ng-change="vm.onChangeDate()" required>
                    <span class="glyphicon glyphicon-calendar" aria-hidden="true"></span>
                </div>
            </div>
            <div class="col-md-6">
                <div class="form-group datepicker-group">
                    <label class="control-label" for="toDate" data-translate="audits.filter.to">to:</label>
                    <input id="toDate" class="form-control" placeholder="aaaa-mm-dd" maxlength="10"
                           name="start" ng-model="vm.toDate" ng-change="vm.onChangeDate()" required>
                    <span class="glyphicon glyphicon-calendar" aria-hidden="true"></span>
                </div>
            </div>
        </div>
    </div>


    <table class="table table-condensed table-striped table-bordered table-responsive">
        <thead>
        <tr>
            <th ng-click="predicate = 'timestamp'; reverse=!reverse"><span data-translate="audits.table.header.date">Date</span>
            </th>
            <th ng-click="predicate = 'principal'; reverse=!reverse"><span
                data-translate="audits.table.header.principal">User</span></th>
            <th ng-click="predicate = 'type'; reverse=!reverse"><span
                data-translate="audits.table.header.status">State</span></th>
            <th ng-click="predicate = 'data.message'; reverse=!reverse"><span data-translate="audits.table.header.data">Extra
                            data</span></th>
        </tr>
        </thead>

        <tr ng-repeat="audit in vm.audits | filter:filter | orderBy:predicate:reverse" ng-hide="audit.filtered">
            <td><span>{{audit.timestamp| date:'medium'}}</span></td>
            <td>
                <small>{{audit.principal}}</small>
            </td>
            <td>{{audit.type}}</td>
            <td>
                <span ng-show="audit.data.message">{{audit.data.message}}</span>
                <span ng-show="audit.data.remoteAddress"><span data-translate="audits.table.data.remoteAddress">Remote
                            Address</span> {{audit.data.remoteAddress}}</span>
            </td>
        </tr>
    </table>

    <div class="text-center">
        <uib-pagination class="pagination-sm" total-items="vm.totalItems" ng-model="vm.page"
                        ng-change="vm.loadPage(vm.page)"></uib-pagination>
    </div>
</div>
