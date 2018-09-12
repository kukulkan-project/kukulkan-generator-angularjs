<div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true"
            ng-click="vm.cancel()">&times;
    </button>
    <h4 class="modal-title" data-translate="login.title">Sign in</h4>
</div>
<div class="modal-body">
    <div class="row">
        <div class="col-md-10 col-md-offset-1">
            <div class="alert alert-danger" ng-show="vm.authenticationError"
                 data-translate="login.messages.error.authentication">
                <strong>Failed to sign in!</strong> Please check your credentials and try again.
            </div>
        </div>
        <div class="col-md-10 col-md-offset-1">
            <form class="form-horizontal" role="form" ng-submit="vm.login($event)">
                <div class="form-group">
                    <label class="col-xs-3" for="username" data-translate="global.form.username">Login</label>
                    <div class="col-xs-9">
                        <input type="text" class="form-control" id="username"
                               placeholder="{{'global.form.username.placeholder' | translate}}" ng-model="vm.username">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-xs-3" for="password" data-translate="login.form.password">Password</label>
                    <div class="col-xs-9">
                        <input type="password" class="form-control" id="password" ng-model="vm.password"
                               placeholder="{{'login.form.password.placeholder' | translate}}">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-xs-offset-3 col-xs-9">
                        <label for="rememberMe">
                            <input type="checkbox" id="rememberMe" ng-model="vm.rememberMe" checked>
                            <span data-translate="login.form.rememberme">Remember me</span>
                        </label>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-xs-4 pull-right">
                        <button type="submit" class="btn btn-primary" data-translate="login.form.button">Sign in
                        </button>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-xs-offset-4 col-xs-8 text-right">
                        <a class="" href="" ng-click="vm.requestResetPassword()" data-translate="login.password.forgot">Did
                            you forget your password?</a>
                    </div>
                </div>
            </form>
            <div data-translate="global.messages.info.register" translate-compile>
                You don't have an account yet?
                <a class="alert-link" href="" ng-click="vm.register()">Register a new account</a>
            </div>
        </div>
    </div>
</div>
