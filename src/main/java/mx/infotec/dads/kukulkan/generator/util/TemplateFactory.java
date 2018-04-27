/*
 *  
 * The MIT License (MIT)
 * Copyright (c) 2016 Daniel Cortes Pichardo
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package mx.infotec.dads.kukulkan.generator.util;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.ImmutableList;

import mx.infotec.dads.kukulkan.metamodel.template.TemplateInfo;

/**
 * TemplateFactory for Immutable template list.
 *
 * @author Daniel Cortes Pichardo
 */
public class TemplateFactory {

    /** The Constant MONGO_TEMPLATE_LIST. */
    public static final List<TemplateInfo> MONGO_TEMPLATE_LIST;

    /** The Constant MONGO_TEMPLATE_LIST. */
    public static final List<TemplateInfo> JPA_TEMPLATE_LIST;
    
    /** The Constant MONGO_TEMPLATE_LIST. */
    public static final List<TemplateInfo> ANGULAR_JS_TEMPLATE_LIST;

    public static final String ANGULAR_JS_TEMPLATE = "archetypes/angularjs";
    public static final String ANGULAR_SPRING_JPA_TEMPLATE = "archetypes/angularjs-spring-jpa";
    public static final String ANGULAR_SPRING_MONGO_TEMPLATE = "archetypes/angularjs-spring-mongo";

    static {
        MONGO_TEMPLATE_LIST = ImmutableList.copyOf(getMongoTemplates());
        JPA_TEMPLATE_LIST = ImmutableList.copyOf(getJpaTemplates());
        ANGULAR_JS_TEMPLATE_LIST = ImmutableList.copyOf(getAngularJsTemplates());
    }

    /**
     * Instantiates a new template factory.
     */
    private TemplateFactory() {
    }

    public static List<TemplateInfo> getAngularJsTemplates() {
        List<TemplateInfo> templates = new ArrayList<>();
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/admin/admin.state.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/admin/admin.state.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/admin/user-management/user-management-delete-dialog.html.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/admin/user-management/user-management.state.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/admin/user-management/user-management-dialog.html.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/admin/user-management/user-management-dialog.controller.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/admin/user-management/user-management.controller.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/admin/user-management/user-management-delete-dialog.controller.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/admin/user-management/user-management-detail.html.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/admin/user-management/user-management-detail.controller.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/admin/user-management/user-management.html.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/admin/logs/logs.state.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/admin/logs/logs.controller.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/admin/logs/logs.html.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/admin/logs/logs.service.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/admin/metrics/metrics.controller.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/admin/metrics/metrics.service.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/admin/metrics/metrics.html.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/admin/metrics/metrics.state.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/admin/metrics/metrics.modal.html.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/admin/metrics/metrics.modal.controller.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/admin/configuration/configuration.service.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/admin/configuration/configuration.controller.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/admin/configuration/configuration.state.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/admin/configuration/configuration.html.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/admin/health/health.modal.html.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/admin/health/health.html.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/admin/health/health.state.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/admin/health/health.service.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/admin/health/health.controller.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/admin/health/health.modal.controller.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/admin/audits/audits.html.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/admin/audits/audits.service.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/admin/audits/audits.state.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/admin/audits/audits.controller.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/admin/docs/docs.html.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/admin/docs/docs.state.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/app.constants.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/app.module.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/layouts/error/error.state.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/layouts/error/accessdenied.html.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/layouts/error/error.html"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/layouts/navbar/navbar.html.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/layouts/navbar/active-menu.directive.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/layouts/navbar/navbar.controller.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/app.state.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/entities/entity.state.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/home/home.controller.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/home/home.state.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/home/home.html.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/blocks/handlers/state.handler.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/blocks/handlers/translation.handler.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/blocks/config/compile.config.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/blocks/config/uib-pagination.config.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/blocks/config/translation-storage.provider.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/blocks/config/translation.config.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/blocks/config/localstorage.config.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/blocks/config/alert.config.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/blocks/config/uib-pager.config.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/blocks/config/http.config.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/blocks/interceptor/notification.interceptor.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/blocks/interceptor/auth-expired.interceptor.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/blocks/interceptor/errorhandler.interceptor.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/blocks/interceptor/auth.interceptor.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/components/alert/alert.service.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/components/alert/alert.directive.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/components/alert/alert-error.directive.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/components/login/login.controller.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/components/login/login.html.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/components/login/login.service.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/components/util/sort.directive.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/components/util/base64.service.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/components/util/capitalize.filter.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/components/util/truncate-words.filter.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/components/util/pagination-util.service.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/components/util/error.constants.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/components/util/sort-by.directive.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/components/util/parse-links.service.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/components/util/truncate-characters.filter.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/components/util/date-util.service.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/components/util/jhi-item-count.directive.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/components/util/data-util.service.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/components/language/language.controller.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/components/language/language.service.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/components/language/language.filter.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/components/language/language.constants.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/components/form/show-validation.directive.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/components/form/pagination.constants.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/components/form/minbytes.directive.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/components/form/maxbytes.directive.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/account/register/register.controller.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/account/register/register.html.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/account/register/register.state.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/account/reset/finish/reset.finish.state.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/account/reset/finish/reset.finish.controller.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/account/reset/finish/reset.finish.html.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/account/reset/request/reset.request.controller.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/account/reset/request/reset.request.html.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/account/reset/request/reset.request.state.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/account/account.state.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/account/activate/activate.controller.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/account/activate/activate.html.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/account/activate/activate.state.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/account/password/password.html.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/account/password/password-strength-bar.directive.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/account/password/password.state.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/account/password/password.controller.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/account/settings/settings.controller.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/account/settings/settings.html.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/account/settings/settings.state.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/services/profiles/page-ribbon.directive.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/services/profiles/profile.service.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/services/auth/password-reset-finish.service.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/services/auth/password-reset-init.service.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/services/auth/password.service.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/services/auth/has-any-authority.directive.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/services/auth/principal.service.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/services/auth/activate.service.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/services/auth/account.service.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/services/auth/has-authority.directive.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/services/auth/auth.jwt.service.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/services/auth/auth.service.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/services/auth/register.service.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/app/services/user/user.service.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/404.html.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/swagger-ui/images/throbber.gif.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/swagger-ui/index.html.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/robots.txt.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/favicon.ico"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/i18n/angular-locale_es.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/i18n/es/password.json.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/i18n/es/settings.json.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/i18n/es/user-management.json.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/i18n/es/health.json.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/i18n/es/configuration.json.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/i18n/es/register.json.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/i18n/es/logs.json.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/i18n/es/reset.json.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/i18n/es/gateway.json.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/i18n/es/error.json.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/i18n/es/metrics.json.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/i18n/es/home.json.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/i18n/es/sessions.json.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/i18n/es/audits.json.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/i18n/es/global.json.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/i18n/es/activate.json.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/i18n/es/login.json.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/i18n/en/password.json.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/i18n/en/settings.json.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/i18n/en/user-management.json.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/i18n/en/health.json.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/i18n/en/configuration.json.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/i18n/en/register.json.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/i18n/en/logs.json.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/i18n/en/reset.json.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/i18n/en/gateway.json.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/i18n/en/error.json.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/i18n/en/metrics.json.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/i18n/en/home.json.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/i18n/en/sessions.json.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/i18n/en/audits.json.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/i18n/en/global.json.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/i18n/en/activate.json.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/i18n/en/login.json.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/i18n/angular-locale_en.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/index.html.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/content/images/app.png"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/content/images/logo-app.png"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/content/images/app2x.png"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/content/css/documentation.css.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/content/css/main.css.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/main/webapp/manifest.webapp.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/test/javascript/karma.conf.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/test/javascript/spec/app/admin/health/health.controller.spec.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/test/javascript/spec/app/components/login/login.controller.spec.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/test/javascript/spec/app/account/register/register.controller.spec.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/test/javascript/spec/app/account/reset/finish/reset.finish.controller.spec.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/test/javascript/spec/app/account/reset/request/reset.request.controller.spec.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/test/javascript/spec/app/account/activate/activate.controller.spec.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/test/javascript/spec/app/account/password/password.controller.spec.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/test/javascript/spec/app/account/password/password-strength-bar.directive.spec.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/test/javascript/spec/app/account/settings/settings.controller.spec.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/test/javascript/spec/app/services/auth/auth.services.spec.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/test/javascript/spec/helpers/httpBackend.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "src/test/javascript/spec/helpers/module.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "gulp/copy.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "gulp/handle-errors.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "gulp/inject.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "gulp/utils.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "gulp/build.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "gulp/serve.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "gulp/config.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, ".eslintrc.json.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, ".yo-rc.json.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, ".eslintignore.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "gulpfile.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "package.json.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "bower.json.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, ".gitattributes.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, "yarn.lock.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, ".editorconfig.ftl"));
        templates.add(new TemplateInfo(ANGULAR_JS_TEMPLATE, ".bowerrc.ftl"));
        return templates;
    }

    
    private static List<TemplateInfo> getMongoTemplates() {
        List<TemplateInfo> templates = new ArrayList<>();
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/resources/banner.txt"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/resources/mails/creationEmail.html"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/resources/mails/activationEmail.html"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/resources/mails/passwordResetEmail.html"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/resources/templates/error.html"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/resources/config/application.yml.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/resources/config/application-prod.yml.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/resources/config/application-dev.yml.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/resources/i18n/messages_es.properties.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/resources/i18n/messages.properties.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/resources/i18n/messages_en.properties.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/resources/logback-spring.xml.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/docker/Dockerfile"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/docker/.dockerignore.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/docker/mongodb/MongoDB.Dockerfile.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/docker/mongodb/scripts/init_replicaset.js.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/docker/mongodb-cluster.yml.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/docker/sonar.yml.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/docker/app.yml.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/docker/mongodb.yml.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/java/package/service/UserService.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/java/package/service/package-info.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/java/package/service/dto/UserDTO.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/java/package/service/dto/package-info.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/java/package/service/mapper/UserMapper.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/java/package/service/mapper/package-info.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/java/package/service/AuditEventService.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/java/package/service/MailService.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/java/package/service/util/RandomUtil.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/java/package/ApplicationWebXml.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/java/package/repository/PersistenceAuditEventRepository.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/java/package/repository/package-info.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/java/package/repository/UserRepository.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/java/package/repository/CustomAuditEventRepository.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/java/package/repository/AuthorityRepository.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/java/package/security/package-info.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/java/package/security/DomainUserDetailsService.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/java/package/security/jwt/TokenProvider.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/java/package/security/jwt/JWTFilter.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/java/package/security/jwt/JWTConfigurer.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/java/package/security/SecurityUtils.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/java/package/security/UserNotActivatedException.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/java/package/security/AuthoritiesConstants.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/java/package/security/SpringSecurityAuditorAware.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/java/package/domain/package-info.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/java/package/domain/Authority.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/java/package/domain/PersistentAuditEvent.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/java/package/domain/User.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/java/package/domain/AbstractAuditingEntity.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/java/package/web/rest/UserResource.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/java/package/web/rest/package-info.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/java/package/web/rest/errors/InvalidPasswordException.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/java/package/web/rest/errors/package-info.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/java/package/web/rest/errors/FieldErrorVM.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/java/package/web/rest/errors/InternalServerErrorException.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/java/package/web/rest/errors/LoginAlreadyUsedException.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/java/package/web/rest/errors/EmailAlreadyUsedException.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/java/package/web/rest/errors/ErrorConstants.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/java/package/web/rest/errors/BadRequestAlertException.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/java/package/web/rest/errors/EmailNotFoundException.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/java/package/web/rest/errors/CustomParameterizedException.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/java/package/web/rest/errors/ExceptionTranslator.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/java/package/web/rest/util/HeaderUtil.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/java/package/web/rest/util/PaginationUtil.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/java/package/web/rest/UserJWTController.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/java/package/web/rest/AccountResource.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/java/package/web/rest/ProfileInfoResource.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/java/package/web/rest/vm/package-info.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/java/package/web/rest/vm/KeyAndPasswordVM.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/java/package/web/rest/vm/ManagedUserVM.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/java/package/web/rest/vm/LoginVM.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/java/package/web/rest/vm/LoggerVM.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/java/package/web/rest/AuditResource.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/java/package/web/rest/LogsResource.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/java/package/config/package-info.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/java/package/config/MetricsConfiguration.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/java/package/config/Constants.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/java/package/config/dbmigrations/package-info.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/java/package/config/dbmigrations/InitialSetupMigration.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/java/package/config/LocaleConfiguration.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/java/package/config/SecurityConfiguration.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/java/package/config/ThymeleafConfiguration.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/java/package/config/AsyncConfiguration.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/java/package/config/DefaultProfileUtil.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/java/package/config/DatabaseConfiguration.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/java/package/config/WebConfigurer.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/java/package/config/CacheConfiguration.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/java/package/config/ApplicationProperties.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/java/package/config/CloudDatabaseConfiguration.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/java/package/config/LoggingAspectConfiguration.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/java/package/config/audit/AuditEventConverter.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/java/package/config/audit/package-info.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/java/package/config/JacksonConfiguration.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/java/package/config/LoggingConfiguration.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/java/package/config/DateTimeFormatConfiguration.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/java/package/aop/logging/LoggingAspect.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/main/java/package/KukulkanApp.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/test/features/.gitkeep.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/test/features/user/user.feature.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/test/resources/mails/testEmail.html"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/test/resources/logback.xml.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/test/resources/config/application.yml.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/test/resources/i18n/messages_en.properties.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/test/java/package/service/UserServiceIntTest.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/test/java/package/service/MailServiceIntTest.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/test/java/package/repository/CustomAuditEventRepositoryIntTest.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/test/java/package/security/SecurityUtilsUnitTest.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/test/java/package/security/DomainUserDetailsServiceIntTest.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/test/java/package/security/jwt/TokenProviderTest.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/test/java/package/security/jwt/JWTFilterTest.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/test/java/package/cucumber/stepdefs/UserStepDefs.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/test/java/package/cucumber/stepdefs/StepDefs.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/test/java/package/cucumber/CucumberTest.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/test/java/package/web/rest/TestUtil.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/test/java/package/web/rest/UserJWTControllerIntTest.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/test/java/package/web/rest/UserResourceIntTest.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/test/java/package/web/rest/errors/ExceptionTranslatorIntTest.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/test/java/package/web/rest/errors/ExceptionTranslatorTestController.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/test/java/package/web/rest/AccountResourceIntTest.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/test/java/package/web/rest/ProfileInfoResourceIntTest.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/test/java/package/web/rest/util/PaginationUtilUnitTest.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/test/java/package/web/rest/AuditResourceIntTest.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/test/java/package/web/rest/LogsResourceIntTest.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/test/java/package/config/WebConfigurerTest.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"src/test/java/package/config/WebConfigurerTestController.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"mvnw.cmd"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"mvnw"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"pom.xml.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,".mvn/wrapper/maven-wrapper.properties"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,".mvn/wrapper/maven-wrapper.jar"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,"README.md.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_MONGO_TEMPLATE,".gitignore.ftl"));
        return templates;
    }
    
    private static List<TemplateInfo> getJpaTemplates() {
        List<TemplateInfo> templates = new ArrayList<>();
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/resources/banner.txt"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/resources/mails/creationEmail.html"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/resources/mails/activationEmail.html"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/resources/mails/passwordResetEmail.html"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/resources/templates/error.html"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/resources/.h2.server.properties.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/resources/config/application.yml.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/resources/config/application-prod.yml.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/resources/config/application-dev.yml.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/resources/config/liquibase/changelog/00000000000000_initial_schema.xml.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/resources/config/liquibase/users_authorities.csv.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/resources/config/liquibase/master.xml.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/resources/config/liquibase/users.csv.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/resources/config/liquibase/authorities.csv.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/resources/i18n/messages_es.properties.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/resources/i18n/messages.properties.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/resources/i18n/messages_en.properties.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/resources/logback-spring.xml.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/docker/Dockerfile"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/docker/.dockerignore.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/docker/mysql.yml.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/docker/sonar.yml.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/docker/app.yml.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/java/package/service/UserService.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/java/package/service/package-info.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/java/package/service/dto/UserDTO.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/java/package/service/dto/package-info.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/java/package/service/mapper/UserMapper.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/java/package/service/mapper/package-info.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/java/package/service/AuditEventService.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/java/package/service/MailService.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/java/package/service/util/RandomUtil.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/java/package/ApplicationWebXml.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/java/package/repository/PersistenceAuditEventRepository.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/java/package/repository/package-info.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/java/package/repository/UserRepository.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/java/package/repository/CustomAuditEventRepository.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/java/package/repository/AuthorityRepository.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/java/package/security/package-info.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/java/package/security/DomainUserDetailsService.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/java/package/security/jwt/TokenProvider.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/java/package/security/jwt/JWTFilter.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/java/package/security/jwt/JWTConfigurer.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/java/package/security/SecurityUtils.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/java/package/security/UserNotActivatedException.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/java/package/security/AuthoritiesConstants.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/java/package/security/SpringSecurityAuditorAware.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/java/package/domain/package-info.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/java/package/domain/Authority.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/java/package/domain/PersistentAuditEvent.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/java/package/domain/User.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/java/package/domain/AbstractAuditingEntity.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/java/package/web/rest/UserResource.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/java/package/web/rest/package-info.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/java/package/web/rest/errors/InvalidPasswordException.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/java/package/web/rest/errors/package-info.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/java/package/web/rest/errors/FieldErrorVM.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/java/package/web/rest/errors/InternalServerErrorException.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/java/package/web/rest/errors/LoginAlreadyUsedException.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/java/package/web/rest/errors/EmailAlreadyUsedException.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/java/package/web/rest/errors/ErrorConstants.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/java/package/web/rest/errors/BadRequestAlertException.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/java/package/web/rest/errors/EmailNotFoundException.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/java/package/web/rest/errors/CustomParameterizedException.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/java/package/web/rest/errors/ExceptionTranslator.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/java/package/web/rest/util/HeaderUtil.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/java/package/web/rest/util/PaginationUtil.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/java/package/web/rest/UserJWTController.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/java/package/web/rest/AccountResource.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/java/package/web/rest/ProfileInfoResource.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/java/package/web/rest/vm/package-info.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/java/package/web/rest/vm/KeyAndPasswordVM.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/java/package/web/rest/vm/ManagedUserVM.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/java/package/web/rest/vm/LoginVM.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/java/package/web/rest/vm/LoggerVM.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/java/package/web/rest/AuditResource.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/java/package/web/rest/LogsResource.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/java/package/config/package-info.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/java/package/config/MetricsConfiguration.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/java/package/config/Constants.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/java/package/config/LocaleConfiguration.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/java/package/config/SecurityConfiguration.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/java/package/config/ThymeleafConfiguration.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/java/package/config/AsyncConfiguration.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/java/package/config/DefaultProfileUtil.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/java/package/config/DatabaseConfiguration.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/java/package/config/WebConfigurer.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/java/package/config/CacheConfiguration.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/java/package/config/ApplicationProperties.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/java/package/config/CloudDatabaseConfiguration.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/java/package/config/LoggingAspectConfiguration.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/java/package/config/audit/AuditEventConverter.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/java/package/config/audit/package-info.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/java/package/config/JacksonConfiguration.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/java/package/config/LoggingConfiguration.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/java/package/config/DateTimeFormatConfiguration.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/java/package/aop/logging/LoggingAspect.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/main/java/package/KukulkanApp.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/test/features/.gitkeep.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/test/features/user/user.feature.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/test/resources/mails/testEmail.html"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/test/resources/logback.xml.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/test/resources/config/application.yml.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/test/resources/i18n/messages_en.properties.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/test/java/package/service/UserServiceIntTest.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/test/java/package/service/MailServiceIntTest.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/test/java/package/repository/CustomAuditEventRepositoryIntTest.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/test/java/package/security/SecurityUtilsUnitTest.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/test/java/package/security/DomainUserDetailsServiceIntTest.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/test/java/package/security/jwt/TokenProviderTest.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/test/java/package/security/jwt/JWTFilterTest.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/test/java/package/cucumber/stepdefs/UserStepDefs.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/test/java/package/cucumber/stepdefs/StepDefs.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/test/java/package/cucumber/CucumberTest.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/test/java/package/web/rest/TestUtil.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/test/java/package/web/rest/UserJWTControllerIntTest.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/test/java/package/web/rest/UserResourceIntTest.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/test/java/package/web/rest/errors/ExceptionTranslatorIntTest.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/test/java/package/web/rest/errors/ExceptionTranslatorTestController.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/test/java/package/web/rest/AccountResourceIntTest.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/test/java/package/web/rest/ProfileInfoResourceIntTest.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/test/java/package/web/rest/util/PaginationUtilUnitTest.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/test/java/package/web/rest/AuditResourceIntTest.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/test/java/package/web/rest/LogsResourceIntTest.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/test/java/package/config/WebConfigurerTest.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"src/test/java/package/config/WebConfigurerTestController.java.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"mvnw.cmd"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"pom.xml.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,".mvn/wrapper/maven-wrapper.properties"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,".mvn/wrapper/maven-wrapper.jar"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,"README.md.ftl"));
        templates.add(new TemplateInfo(ANGULAR_SPRING_JPA_TEMPLATE,".gitignore.ftl"));
        return templates;
    }
}
