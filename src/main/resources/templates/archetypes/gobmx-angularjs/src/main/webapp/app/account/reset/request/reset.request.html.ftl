<div>
    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <h1 data-translate="reset.request.title">Reset your password</h1>

            <div class="alert alert-danger" data-translate="reset.request.messages.notfound"
                 ng-show="vm.errorEmailNotExists">
                <strong>Email address isn't registered!</strong> Please check and try again.
            </div>

            <div class="alert alert-warning" ng-hide="vm.success">
                <p data-translate="reset.request.messages.info">Enter the email address you used to register.</p>
            </div>

            <div class="alert alert-success" ng-show="vm.success === 'OK'">
                <p data-translate="reset.request.messages.success">
                    Check your emails for details on how to reset your password.
                </p>
            </div>

            <form ng-show="!vm.success" name="form" role="form" novalidate ng-submit="vm.requestReset()"
                  show-validation>
                <div class="form-group">
                    <label class="control-label" for="email" data-translate="global.form.email">Email</label>
                    <input type="email" class="form-control" id="email" name="email"
                           placeholder="{{'global.form.email.placeholder' | translate}}"
                           ng-model="vm.resetAccount.email" ng-minlength=5 ng-maxlength=100 required>
                    <div ng-show="form.email.$dirty && form.email.$invalid">
                        <p class="help-block" ng-show="form.email.$error.required"
                           data-translate="global.messages.validate.email.required">
                            Your email is required.
                        </p>
                        <p class="help-block" ng-show="form.email.$error.email"
                           data-translate="global.messages.validate.email.invalid">
                            Your email is invalid.
                        </p>
                        <p class="help-block" ng-show="form.email.$error.minlength"
                           data-translate="global.messages.validate.email.minlength">
                            Your email is required to be at least 5 characters.
                        </p>
                        <p class="help-block" ng-show="form.email.$error.maxlength"
                           data-translate="global.messages.validate.email.maxlength">
                            Your email cannot be longer than 100 characters.
                        </p>
                    </div>
                </div>
                <div class="pull-right">
                    <button type="submit" ng-disabled="form.$invalid" class="btn btn-primary"
                            data-translate="reset.request.form.button">Reset
                    </button>
                </div>
            </form>

        </div>
    </div>
</div>
