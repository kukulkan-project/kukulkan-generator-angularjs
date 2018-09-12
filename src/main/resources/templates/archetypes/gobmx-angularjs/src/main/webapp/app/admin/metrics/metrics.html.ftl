<div class="container-fluid">
    <h2 data-translate="metrics.title">Application Metrics</h2>
    <hr class="black"/>
    <p>
    <div class="col-md-12">
        <div class="pull-right">
            <button type="button" class="btn btn-primary" ng-click="vm.refresh()"><span
                class="glyphicon glyphicon-refresh"></span>&nbsp;<span
                data-translate="metrics.refresh.button">Refresh</span></button>
        </div>
    </div>
    </p>

    <h3 data-translate="metrics.jvm.title">JVM Metrics</h3>
    <div class="row" ng-hide="vm.updatingMetrics">
        <div class="col-md-4">
            <b data-translate="metrics.jvm.memory.title">Memory</b>
            <p><span data-translate="metrics.jvm.memory.total">Total Memory</span>
                ({{vm.metrics.gauges['jvm.memory.total.used'].value
                / 1000000 | number:0}}M / {{vm.metrics.gauges['jvm.memory.total.max'].value / 1000000 | number:0}}M)</p>
            <uib-progressbar min="0" max="vm.metrics.gauges['jvm.memory.total.max'].value"
                             value="vm.metrics.gauges['jvm.memory.total.used'].value"
                             class="progress-striped active" type="success">
                    <span>{{vm.metrics.gauges['jvm.memory.total.used'].value * 100 / vm.metrics.gauges['jvm.memory.total.max'].value
                        | number:0}}%</span>
            </uib-progressbar>
            <p><span data-translate="metrics.jvm.memory.heap">Heap Memory</span>
                ({{vm.metrics.gauges['jvm.memory.heap.used'].value
                / 1000000 | number:0}}M / {{vm.metrics.gauges['jvm.memory.heap.max'].value / 1000000 | number:0}}M)</p>
            <uib-progressbar min="0" max="vm.metrics.gauges['jvm.memory.heap.max'].value"
                             value="vm.metrics.gauges['jvm.memory.heap.used'].value"
                             class="progress-striped active" type="success">
                    <span>{{vm.metrics.gauges['jvm.memory.heap.used'].value * 100 / vm.metrics.gauges['jvm.memory.heap.max'].value
                        | number:0}}%</span>
            </uib-progressbar>
            <p><span data-translate="metrics.jvm.memory.nonheap">Non-Heap Memory</span>
                ({{vm.metrics.gauges['jvm.memory.non-heap.used'].value
                / 1000000 | number:0}}M / {{vm.metrics.gauges['jvm.memory.non-heap.committed'].value / 1000000 |
                number:0}}M)</p>
            <uib-progressbar min="0" max="vm.metrics.gauges['jvm.memory.non-heap.committed'].value"
                             value="vm.metrics.gauges['jvm.memory.non-heap.used'].value"
                             class="progress-striped active" type="success">
                    <span>{{vm.metrics.gauges['jvm.memory.non-heap.used'].value * 100 / vm.metrics.gauges['jvm.memory.non-heap.committed'].value
                        | number:0}}%</span>
            </uib-progressbar>
        </div>
        <div class="col-md-4">
            <b data-translate="metrics.jvm.threads.title">Threads</b> (Total:
            {{vm.metrics.gauges['jvm.threads.count'].value}})
            <a class="hand" ng-click="vm.refreshThreadDumpData()" data-toggle="modal" data-target="#threadDump"><i
                class="glyphicon glyphicon-eye-open"></i></a>
            <p><span data-translate="metrics.jvm.threads.runnable">Runnable</span>
                {{vm.metrics.gauges['jvm.threads.runnable.count'].value}}</p>
            <uib-progressbar min="0" value="vm.metrics.gauges['jvm.threads.runnable.count'].value"
                             max="vm.metrics.gauges['jvm.threads.count'].value"
                             class="progress-striped active" type="success">
                    <span>{{vm.metrics.gauges['jvm.threads.runnable.count'].value * 100 / vm.metrics.gauges['jvm.threads.count'].value
                        | number:0}}%</span>
            </uib-progressbar>
            <p><span data-translate="metrics.jvm.threads.timedwaiting">Timed Waiting</span>
                ({{vm.metrics.gauges['jvm.threads.timed_waiting.count'].value}})</p>
            <uib-progressbar min="0" value="vm.metrics.gauges['jvm.threads.timed_waiting.count'].value"
                             max="vm.metrics.gauges['jvm.threads.count'].value"
                             class="progress-striped active" type="warning">
                    <span>{{vm.metrics.gauges['jvm.threads.timed_waiting.count'].value * 100 / vm.metrics.gauges['jvm.threads.count'].value
                        | number:0}}%</span>
            </uib-progressbar>
            <p><span data-translate="metrics.jvm.threads.waiting">Waiting</span>
                ({{vm.metrics.gauges['jvm.threads.waiting.count'].value}})</p>
            <uib-progressbar min="0" value="vm.metrics.gauges['jvm.threads.waiting.count'].value"
                             max="vm.metrics.gauges['jvm.threads.count'].value"
                             class="progress-striped active" type="warning">
                    <span>{{vm.metrics.gauges['jvm.threads.waiting.count'].value * 100 / vm.metrics.gauges['jvm.threads.count'].value
                        | number:0}}%</span>
            </uib-progressbar>
            <p><span data-translate="metrics.jvm.threads.blocked">Blocked</span>
                ({{vm.metrics.gauges['jvm.threads.blocked.count'].value}})</p>
            <uib-progressbar min="0" value="vm.metrics.gauges['jvm.threads.blocked.count'].value"
                             max="vm.metrics.gauges['jvm.threads.count'].value"
                             class="progress-striped active" type="success">
                    <span>{{vm.metrics.gauges['jvm.threads.blocked.count'].value * 100 / vm.metrics.gauges['jvm.threads.count'].value
                        | number:0}}%</span>
            </uib-progressbar>
        </div>
        <div class="col-md-4">
            <b data-translate="metrics.jvm.gc.title">Garbage collections</b>
            <div class="row">
                <div class="col-md-9" data-translate="metrics.jvm.gc.marksweepcount">Mark Sweep count</div>
                <div class="col-md-3 text-right">{{vm.metrics.gauges['jvm.garbage.PS-MarkSweep.count'].value}}</div>
            </div>
            <div class="row">
                <div class="col-md-9" data-translate="metrics.jvm.gc.marksweeptime">Mark Sweep time</div>
                <div class="col-md-3 text-right">{{vm.metrics.gauges['jvm.garbage.PS-MarkSweep.time'].value}}ms</div>
            </div>
            <div class="row">
                <div class="col-md-9" data-translate="metrics.jvm.gc.scavengecount">Scavenge count</div>
                <div class="col-md-3 text-right">{{vm.metrics.gauges['jvm.garbage.PS-Scavenge.count'].value}}</div>
            </div>
            <div class="row">
                <div class="col-md-9" data-translate="metrics.jvm.gc.scavengetime">Scavenge time</div>
                <div class="col-md-3 text-right">{{vm.metrics.gauges['jvm.garbage.PS-Scavenge.time'].value}}ms</div>
            </div>
        </div>
    </div>
    <div class="well well-lg" ng-show="vm.updatingMetrics" data-translate="metrics.updating">Updating...</div>

    <h3 data-translate="metrics.jvm.http.title">HTTP requests (events per second)</h3>
    <p><span data-translate="metrics.jvm.http.active">Active requests</span> <b>{{vm.metrics.counters['com.codahale.metrics.servlet.InstrumentedFilter.activeRequests'].count
        | number:0}}</b> - <span data-translate="metrics.jvm.http.total">Total requests</span> <b>{{vm.metrics.timers['com.codahale.metrics.servlet.InstrumentedFilter.requests'].count
        | number:0}}</b></p>
    <div class="table-responsive">
        <table class="table table-striped">
            <thead>
            <tr>
                <th data-translate="metrics.jvm.http.table.code">Code</th>
                <th data-translate="metrics.jvm.http.table.count">Count</th>
                <th class="text-right" data-translate="metrics.jvm.http.table.mean">Mean</th>
                <th class="text-right"><span data-translate="metrics.jvm.http.table.average">Average</span> (1 min)</th>
                <th class="text-right"><span data-translate="metrics.jvm.http.table.average">Average</span> (5 min)</th>
                <th class="text-right"><span data-translate="metrics.jvm.http.table.average">Average</span> (15 min)
                </th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td data-translate="metrics.jvm.http.code.ok">OK</td>
                <td>
                    <uib-progressbar min="0"
                                     max="vm.metrics.timers['com.codahale.metrics.servlet.InstrumentedFilter.requests'].count"
                                     value="vm.metrics.meters['com.codahale.metrics.servlet.InstrumentedFilter.responseCodes.ok'].count"
                                     class="progress-striped active" type="success">
                        <span>{{vm.metrics.meters['com.codahale.metrics.servlet.InstrumentedFilter.responseCodes.ok'].count}}</span>
                    </uib-progressbar>
                </td>
                <td class="text-right">
                    {{vm.metrics.meters['com.codahale.metrics.servlet.InstrumentedFilter.responseCodes.ok'].mean_rate |
                    number:2}}
                </td>
                <td class="text-right">
                    {{vm.metrics.meters['com.codahale.metrics.servlet.InstrumentedFilter.responseCodes.ok'].m1_rate
                    | number:2}}
                </td>
                <td class="text-right">
                    {{vm.metrics.meters['com.codahale.metrics.servlet.InstrumentedFilter.responseCodes.ok'].m5_rate
                    | number:2}}
                </td>
                <td class="text-right">
                    {{vm.metrics.meters['com.codahale.metrics.servlet.InstrumentedFilter.responseCodes.ok'].m15_rate |
                    number:2}}
                </td>
            </tr>
            <tr>
                <td data-translate="metrics.jvm.http.code.notfound">Not Found</td>
                <td>
                    <uib-progressbar min="0"
                                     max="vm.metrics.timers['com.codahale.metrics.servlet.InstrumentedFilter.requests'].count"
                                     value="vm.metrics.meters['com.codahale.metrics.servlet.InstrumentedFilter.responseCodes.notFound'].count"
                                     class="progress-striped active" type="success">
                        <span>{{vm.metrics.meters['com.codahale.metrics.servlet.InstrumentedFilter.responseCodes.notFound'].count}}</span>
                    </uib-progressbar>
                </td>
                <td class="text-right">
                    {{vm.metrics.meters['com.codahale.metrics.servlet.InstrumentedFilter.responseCodes.notFound'].mean_rate
                    | number:2}}
                </td>
                <td class="text-right">
                    {{vm.metrics.meters['com.codahale.metrics.servlet.InstrumentedFilter.responseCodes.notFound'].m1_rate
                    | number:2}}
                </td>
                <td class="text-right">
                    {{vm.metrics.meters['com.codahale.metrics.servlet.InstrumentedFilter.responseCodes.notFound'].m5_rate
                    | number:2}}
                </td>
                <td class="text-right">
                    {{vm.metrics.meters['com.codahale.metrics.servlet.InstrumentedFilter.responseCodes.notFound'].m15_rate
                    | number:2}}
                </td>
            </tr>
            <tr>
                <td data-translate="metrics.jvm.http.code.servererror">Server error</td>
                <td>
                    <uib-progressbar min="0"
                                     max="vm.metrics.timers['com.codahale.metrics.servlet.InstrumentedFilter.requests'].count"
                                     value="vm.metrics.meters['com.codahale.metrics.servlet.InstrumentedFilter.responseCodes.serverError'].count"
                                     class="progress-striped active" type="success">
                        <span>{{vm.metrics.meters['com.codahale.metrics.servlet.InstrumentedFilter.responseCodes.serverError'].count}}</span>
                    </uib-progressbar>
                </td>
                <td class="text-right">
                    {{vm.metrics.meters['com.codahale.metrics.servlet.InstrumentedFilter.responseCodes.serverError'].mean_rate
                    | number:2}}
                </td>
                <td class="text-right">
                    {{vm.metrics.meters['com.codahale.metrics.servlet.InstrumentedFilter.responseCodes.serverError'].m1_rate
                    | number:2}}
                </td>
                <td class="text-right">
                    {{vm.metrics.meters['com.codahale.metrics.servlet.InstrumentedFilter.responseCodes.serverError'].m5_rate
                    | number:2}}
                </td>
                <td class="text-right">
                    {{vm.metrics.meters['com.codahale.metrics.servlet.InstrumentedFilter.responseCodes.serverError'].m15_rate
                    | number:2}}
                </td>
            </tr>
            </tbody>
        </table>
    </div>

    <h3 data-translate="metrics.servicesstats.title">Services statistics (time in millisecond)</h3>
    <div class="table-responsive">
        <table class="table table-striped">
            <thead>
            <tr>
                <th data-translate="metrics.servicesstats.table.name">Service name</th>
                <th class="text-right" data-translate="metrics.servicesstats.table.count">Count</th>
                <th class="text-right" data-translate="metrics.servicesstats.table.mean">Mean</th>
                <th class="text-right" data-translate="metrics.servicesstats.table.min">Min</th>
                <th class="text-right" data-translate="metrics.servicesstats.table.p50">p50</th>
                <th class="text-right" data-translate="metrics.servicesstats.table.p75">p75</th>
                <th class="text-right" data-translate="metrics.servicesstats.table.p95">p95</th>
                <th class="text-right" data-translate="metrics.servicesstats.table.p99">p99</th>
                <th class="text-right" data-translate="metrics.servicesstats.table.max">Max</th>
            </tr>
            </thead>
            <tbody>
            <tr ng-repeat="(k, v) in vm.servicesStats">
                <td>{{k}}</td>
                <td class="text-right">{{v.count}}</td>
                <td class="text-right">{{v.mean * 1000 | number:0}}</td>
                <td class="text-right">{{v.min * 1000 | number:0}}</td>
                <td class="text-right">{{v.p50 * 1000 | number:0}}</td>
                <td class="text-right">{{v.p75 * 1000 | number:0}}</td>
                <td class="text-right">{{v.p95 * 1000 | number:0}}</td>
                <td class="text-right">{{v.p99 * 1000 | number:0}}</td>
                <td class="text-right">{{v.max * 1000 | number:0}}</td>
            </tr>
            </tbody>
        </table>
    </div>
    <h3 data-translate="metrics.datasource.title"
        ng-show="vm.metrics.gauges['HikariPool-1.pool.TotalConnections'].value > 0">DataSource
        statistics (time in millisecond)</h3>
    <div class="table-responsive" ng-show="vm.metrics.gauges['HikariPool-1.pool.TotalConnections'].value > 0">
        <table class="table table-striped">
            <thead>
            <tr>
                <th><span data-translate="metrics.datasource.usage">Usage</span>
                    ({{vm.metrics.gauges['HikariPool-1.pool.ActiveConnections'].value}}
                    / {{vm.metrics.gauges['HikariPool-1.pool.TotalConnections'].value}})
                </th>
                <th class="text-right" data-translate="metrics.datasource.count">Count</th>
                <th class="text-right" data-translate="metrics.datasource.mean">Mean</th>
                <th class="text-right" data-translate="metrics.datasource.min">Min</th>
                <th class="text-right" data-translate="metrics.datasource.p50">p50</th>
                <th class="text-right" data-translate="metrics.datasource.p75">p75</th>
                <th class="text-right" data-translate="metrics.datasource.p95">p95</th>
                <th class="text-right" data-translate="metrics.datasource.p99">p99</th>
                <th class="text-right" data-translate="metrics.datasource.max">Max</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>
                    <div class="progress progress-striped">
                        <uib-progressbar min="0" max="vm.metrics.gauges['HikariPool-1.pool.TotalConnections'].value"
                                         value="vm.metrics.gauges['HikariPool-1.pool.ActiveConnections'].value"
                                         class="progress-striped active" type="success">
                                    <span>{{vm.metrics.gauges['HikariPool-1.pool.ActiveConnections'].value * 100 / vm.metrics.gauges['HikariPool-1.pool.TotalConnections'].value
                                        | number:0}}%</span>
                        </uib-progressbar>
                    </div>
                </td>
                <td class="text-right">{{vm.metrics.histograms['HikariPool-1.pool.Usage'].count}}</td>
                <td class="text-right">{{vm.metrics.histograms['HikariPool-1.pool.Usage'].mean | number:2}}</td>
                <td class="text-right">{{vm.metrics.histograms['HikariPool-1.pool.Usage'].min | number:2}}</td>
                <td class="text-right">{{vm.metrics.histograms['HikariPool-1.pool.Usage'].p50 | number:2}}</td>
                <td class="text-right">{{vm.metrics.histograms['HikariPool-1.pool.Usage'].p75 | number:2}}</td>
                <td class="text-right">{{vm.metrics.histograms['HikariPool-1.pool.Usage'].p95 | number:2}}</td>
                <td class="text-right">{{vm.metrics.histograms['HikariPool-1.pool.Usage'].p99 | number:2}}</td>
                <td class="text-right">{{vm.metrics.histograms['HikariPool-1.pool.Usage'].max | number:2}}</td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
