<div>
    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <h2 data-translate="password.title" translate-values="{username: '{{vm.account.login}}'}">Password for [<b>{{vm.account.login}}</b>]</h2>

            <div class="alert alert-success" ng-show="vm.success" data-translate="password.messages.success">
                <strong>Password changed!</strong>
            </div>
            <div class="alert alert-danger" ng-show="vm.error"  data-translate="password.messages.error">
                <strong>An error has occurred!</strong> The password could not be changed.
            </div>

            <div class="alert alert-danger" ng-show="vm.doNotMatch" data-translate="global.messages.error.dontmatch">
                The password and its confirmation do not match!
            </div>

            <form name="form" role="form" novalidate ng-submit="vm.changePassword()" show-validation>

                <div class="form-group">
                    <label class="control-label" for="password" data-translate="global.form.newpassword">New password</label>
                    <input type="password" class="form-control" id="password" name="password" placeholder="{{'global.form.newpassword.placeholder' | translate}}"
                           ng-model="vm.password" ng-minlength=4 ng-maxlength=50 required>
                    <div ng-show="form.password.$dirty && form.password.$invalid">
                        <p class="help-block"
                           ng-show="form.password.$error.required" data-translate="global.messages.validate.newpassword.required">
                            Your password is required.
                        </p>
                        <p class="help-block"
                           ng-show="form.password.$error.minlength" data-translate="global.messages.validate.newpassword.minlength">
                            Your password is required to be at least 4 characters.
                        </p>
                        <p class="help-block"
                           ng-show="form.password.$error.maxlength" data-translate="global.messages.validate.newpassword.maxlength">
                            Your password cannot be longer than 50 characters.
                        </p>
                    </div>
                    <password-strength-bar password-to-check="vm.password"></password-strength-bar>
                </div>
                <div class="form-group">
                    <label class="control-label" for="confirmPassword" data-translate="global.form.confirmpassword">New password confirmation</label>
                    <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" placeholder="{{'global.form.confirmpassword.placeholder' | translate}}"
                           ng-model="vm.confirmPassword" ng-minlength=4 ng-maxlength=50 required>
                    <div ng-show="form.confirmPassword.$dirty && form.confirmPassword.$invalid">
                        <p class="help-block"
                           ng-show="form.confirmPassword.$error.required" data-translate="global.messages.validate.confirmpassword.required">
                            Your confirmation password is required.
                        </p>
                        <p class="help-block"
                           ng-show="form.confirmPassword.$error.minlength" data-translate="global.messages.validate.confirmpassword.minlength">
                            Your confirmation password is required to be at least 4 characters.
                        </p>
                        <p class="help-block"
                           ng-show="form.confirmPassword.$error.maxlength" data-translate="global.messages.validate.confirmpassword.maxlength">
                            Your confirmation password cannot be longer than 50 characters.
                        </p>
                    </div>
                </div>

                <button type="submit" ng-disabled="form.$invalid" class="btn btn-primary" data-translate="password.form.button">Save</button>
            </form>
        </div>
    </div>
</div>
