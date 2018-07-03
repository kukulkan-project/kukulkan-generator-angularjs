<!-- Modal used to display the threads dump -->
<div class="modal-header" modal-draggable>
    <button type="button" class="close" ng-click="vm.cancel()">&times;</button>
    <h4 class="modal-title" data-translate="metrics.jvm.threads.dump.title">Threads dump</h4>
</div>
<div class="modal-body pad">
    <span class="label label-primary" ng-click="threadDumpFilter = {}">All&nbsp;<span class="badge">{{vm.threadDumpAll}}</span></span>&nbsp;
    <span class="label label-success" ng-click="threadDumpFilter = {threadState: 'RUNNABLE'}">Runnable&nbsp;<span class="badge">{{vm.threadDumpRunnable}}</span></span>&nbsp;
    <span class="label label-info" ng-click="threadDumpFilter = {threadState: 'WAITING'}">Waiting&nbsp;<span class="badge">{{vm.threadDumpWaiting}}</span></span>&nbsp;
    <span class="label label-warning" ng-click="threadDumpFilter = {threadState: 'TIMED_WAITING'}">Timed Waiting&nbsp;<span class="badge">{{vm.threadDumpTimedWaiting}}</span></span>&nbsp;
    <span class="label label-danger" ng-click="threadDumpFilter = {threadState: 'BLOCKED'}">Blocked&nbsp;<span class="badge">{{vm.threadDumpBlocked}}</span></span>&nbsp;
    <div class="voffset2">&nbsp;</div>
    Filter
    <input type="text" ng-model="threadDumpFilter" class="form-control">
    <div class="row pad" ng-repeat="(k, v) in vm.threadDump | filter:threadDumpFilter">
        <h5><span class="label" ng-class="vm.getLabelClass(v.threadState)">{{v.threadState}}</span>&nbsp;{{v.threadName}} (ID {{v.threadId}})
            <a ng-click="show = !show">
               <span ng-show="!show" data-translate="metrics.jvm.threads.dump.show">Show StackTrace</span>
               <span ng-show="show" data-translate="metrics.jvm.threads.dump.hide">Hide StackTrace</span>
            </a>
        </h5>
        <div class="well" ng-show="show">
            <div ng-repeat="(stK, stV) in v.stackTrace">
                {{stV.className}}.{{stV.methodName}}({{stV.fileName}}:{{stV.lineNumber}})
                <span class="voffset1"></span>
            </div>
        </div>
        <table class="table table-condensed">
            <thead>
                <tr>
                    <th class="text-right" data-translate="metrics.jvm.threads.dump.blockedtime">Blocked Time</th>
                    <th class="text-right" data-translate="metrics.jvm.threads.dump.blockedcount">Blocked Count</th>
                    <th class="text-right" data-translate="metrics.jvm.threads.dump.waitedtime">Waited Time</th>
                    <th class="text-right" data-translate="metrics.jvm.threads.dump.waitedcount">Waited Count</th>
                    <th data-translate="metrics.jvm.threads.dump.lockname">Lock Name</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>{{v.blockedTime}}</td>
                    <td>{{v.blockedCount}}</td>
                    <td>{{v.waitedTime}}</td>
                    <td>{{v.waitedCount}}</td>
                    <td>{{v.lockName}}</td>
                </tr>
            </tbody>
        </table>

    </div>
</div>
<div class="modal-footer">
    <button type="button" class="btn btn-default  pull-left" data-dismiss="modal" ng-click="vm.cancel()">Done</button>
</div>
