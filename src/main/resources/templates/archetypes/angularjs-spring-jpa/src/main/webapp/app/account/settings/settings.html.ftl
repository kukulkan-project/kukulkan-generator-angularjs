<div>
    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <h2 data-translate="settings.title" translate-values="{username: '{{vm.settingsAccount.login}}'}">User settings for [<b>{{vm.settingsAccount.login}}</b>]</h2>

            <div class="alert alert-success" ng-show="vm.success" data-translate="settings.messages.success">
                <strong>Settings saved!</strong>
            </div>

           <jhi-alert-error></jhi-alert-error>

            <form name="form" role="form" novalidate ng-submit="vm.save()" show-validation>

                <div class="form-group">
                    <label class="control-label" for="firstName" data-translate="settings.form.firstname">First Name</label>
                    <input type="text" class="form-control" id="firstName" name="firstName" placeholder="{{'settings.form.firstname.placeholder' | translate}}"
                           ng-model="vm.settingsAccount.firstName" ng-minlength=1 ng-maxlength=50 required maxlength="50">
                    <div ng-show="form.firstName.$dirty && form.firstName.$invalid">
                        <p class="help-block"
                               ng-show="form.firstName.$error.required" data-translate="settings.messages.validate.firstname.required">
                            Your first name is required.
                        </p>
                        <p class="help-block"
                               ng-show="form.firstName.$error.minlength" data-translate="settings.messages.validate.firstname.minlength">
                            Your first name is required to be at least 1 character.
                        </p>
                        <p class="help-block"
                               ng-show="form.firstName.$error.maxlength" data-translate="settings.messages.validate.firstname.maxlength">
                            Your first name cannot be longer than 50 characters.
                        </p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label" for="lastName" data-translate="settings.form.lastname">Last Name</label>
                    <input type="text" class="form-control" id="lastName" name="lastName" placeholder="{{'settings.form.lastname.placeholder' | translate}}"
                           ng-model="vm.settingsAccount.lastName" ng-minlength=1 ng-maxlength=50 required maxlength="50">
                    <div ng-show="form.lastName.$dirty && form.lastName.$invalid">
                        <p class="help-block"
                               ng-show="form.lastName.$error.required" data-translate="settings.messages.validate.lastname.required">
                            Your last name is required.
                        </p>
                        <p class="help-block"
                               ng-show="form.lastName.$error.minlength" data-translate="settings.messages.validate.lastname.minlength">
                            Your last name is required to be at least 1 character.
                        </p>
                        <p class="help-block"
                               ng-show="form.lastName.$error.maxlength" data-translate="settings.messages.validate.lastname.maxlength">
                            Your last name cannot be longer than 50 characters.
                        </p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label" for="email" data-translate="global.form.email">Email</label>
                    <input type="email" class="form-control" id="email" name="email" placeholder="{{'global.form.email.placeholder' | translate}}"
                           ng-model="vm.settingsAccount.email" ng-minlength=5 ng-maxlength=100 required maxlength="100">
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
                    <label for="langKey" data-translate="settings.form.language">Language</label>
                    <select id="langKey" name="langKey" class="form-control" ng-model="vm.settingsAccount.langKey" ng-controller="JhiLanguageController as languageVm" ng-options="code as (code | findLanguageFromKey) for code in languageVm.languages"></select>
                </div>

                <button type="submit" ng-disabled="form.$invalid" class="btn btn-primary" data-translate="settings.form.button">Save</button>
            </form>
        </div>
    </div>

</div>
