<div>
    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <h1 data-translate="register.title">Registration</h1>

            <div class="alert alert-success" ng-show="vm.success" data-translate="register.messages.success">
                <strong>Registration saved!</strong> Please check your email for confirmation.
            </div>

            <div class="alert alert-danger" ng-show="vm.error" data-translate="register.messages.error.fail">
                <strong>Registration failed!</strong> Please try again later.
            </div>

            <div class="alert alert-danger" ng-show="vm.errorUserExists" data-translate="register.messages.error.userexists">
                <strong>Login name already registered!</strong> Please choose another one.
            </div>

            <div class="alert alert-danger" ng-show="vm.errorEmailExists" data-translate="register.messages.error.emailexists">
                <strong>Email is already in use!</strong> Please choose another one.
            </div>

            <div class="alert alert-danger" ng-show="vm.doNotMatch" data-translate="global.messages.error.dontmatch">
                The password and its confirmation do not match!
            </div>
        </div>
        <div class="col-md-8 col-md-offset-2">
            <form ng-show="!vm.success" name="form" role="form" novalidate ng-submit="vm.register()" show-validation>

                <div class="form-group">
                    <label class="control-label" for="login" data-translate="global.form.username">Username</label>
                    <input type="text" class="form-control" id="login" name="login" placeholder="{{'global.form.username.placeholder' | translate}}"
                           ng-model="vm.registerAccount.login" ng-minlength=1 ng-maxlength=50 ng-pattern="/^[_'.@A-Za-z0-9-]*$/" required>
                    <div ng-show="form.login.$dirty && form.login.$invalid">
                        <p class="help-block"
                               ng-show="form.login.$error.required" data-translate="register.messages.validate.login.required">
                            Your username is required.
                        </p>
                        <p class="help-block"
                               ng-show="form.login.$error.minlength" data-translate="register.messages.validate.login.minlength">
                            Your username is required to be at least 1 character.
                        </p>
                        <p class="help-block"
                               ng-show="form.login.$error.maxlength" data-translate="register.messages.validate.login.maxlength">
                            Your username cannot be longer than 50 characters.
                        </p>
                        <p class="help-block"
                               ng-show="form.login.$error.pattern" data-translate="register.messages.validate.login.pattern">
                            Your username can only contain letters and digits.
                    </p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label" for="email" data-translate="global.form.email">Email</label>
                    <input type="email" class="form-control" id="email" name="email" placeholder="{{'global.form.email.placeholder' | translate}}"
                           ng-model="vm.registerAccount.email" ng-minlength=5 ng-maxlength=100 required>
                    <div ng-show="form.email.$dirty && form.email.$invalid">
                        <p class="help-block"
                               ng-show="form.email.$error.required" data-translate="global.messages.validate.email.required">
                            Your email is required.
                        </p>
                        <p class="help-block"
                               ng-show="form.email.$error.email" data-translate="global.messages.validate.email.invalid">
                            Your email is invalid.
                        </p>
                        <p class="help-block"
                               ng-show="form.email.$error.minlength" data-translate="global.messages.validate.email.minlength">
                            Your email is required to be at least 5 characters.
                        </p>
                        <p class="help-block"
                               ng-show="form.email.$error.maxlength" data-translate="global.messages.validate.email.maxlength">
                            Your email cannot be longer than 100 characters.
                        </p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label" for="password" data-translate="global.form.newpassword">New password</label>
                    <input type="password" class="form-control" id="password" name="password" placeholder="{{'global.form.newpassword.placeholder' | translate}}"
                           ng-model="vm.registerAccount.password" ng-minlength=4 ng-maxlength=50 required>
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
                    <password-strength-bar password-to-check="vm.registerAccount.password"></password-strength-bar>
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

                <button type="submit" ng-disabled="form.$invalid" class="btn btn-primary" data-translate="register.form.button">Register</button>
            </form>
            <p></p>
            <div class="alert alert-warning" data-translate="global.messages.info.authenticated" translate-compile>
                If you want to <a class="alert-link" href="" ng-click="vm.login()">sign in</a>, you can try the default accounts:<br/>- Administrator (login="admin" and password="admin") <br/>- User (login="user" and password="user").
            </div>
        </div>
    </div>
</div>
