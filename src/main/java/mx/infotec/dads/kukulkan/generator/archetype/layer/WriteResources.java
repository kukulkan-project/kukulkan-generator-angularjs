/*
 *  
 * The MIT License (MIT)
 * Copyright (c) 2018 Roberto Villarejo Martínez
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

package mx.infotec.dads.kukulkan.generator.archetype.layer;

import java.nio.file.Path;
import java.util.Optional;
import java.util.function.Function;

import mx.infotec.dads.kukulkan.engine.service.WriterService;
import mx.infotec.dads.kukulkan.generator.integration.BannerService;
import mx.infotec.dads.kukulkan.metamodel.foundation.ProjectConfiguration;

public class WriteResources {
    
    private WriteResources() {
        
    }

    public static final String ANGULAR_JS_TEMPLATE = "archetypes/angularjs/";
    public static final String ANGULAR_SPRING_JPA_TEMPLATE = "archetypes/angularjs-spring-jpa/";
    public static final String ANGULAR_SPRING_MONGO_TEMPLATE = "archetypes/angularjs-spring-mongo/";

    public static void generateAngularJs(WriterService writer, ProjectConfiguration pConf, Object model) {
        final Function<String, String> pathBuilderAngularJs = 
                template -> template
                .replace(ANGULAR_JS_TEMPLATE, "${project.id}/")
                .replace(".ftl", "");
                
        Path path = pConf.getOutputDir();
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/content/css/main.css.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/content/css/documentation.css.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/content/images/isotipo.svg", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/content/images/logo-app.png", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/content/images/logo-b.svg", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/content/images/avatar01.svg", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/content/images/app.png", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/content/images/bg-ok.svg", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/content/images/app2x.png", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/content/images/isotipo.png", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/content/images/logo.svg", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/content/images/usuario.svg", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/robots.txt.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/swagger-ui/index.html.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/swagger-ui/images/throbber.gif.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/index.html.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/404.html.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/i18n/en/global.json.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/i18n/en/user-management.json.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/i18n/en/home.json.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/i18n/en/login.json.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/i18n/en/reset.json.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/i18n/en/health.json.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/i18n/en/sessions.json.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/i18n/en/activate.json.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/i18n/en/error.json.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/i18n/en/register.json.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/i18n/en/metrics.json.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/i18n/en/password.json.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/i18n/en/logs.json.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/i18n/en/gateway.json.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/i18n/en/audits.json.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/i18n/en/settings.json.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/i18n/en/configuration.json.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/i18n/es/global.json.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/i18n/es/user-management.json.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/i18n/es/home.json.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/i18n/es/login.json.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/i18n/es/reset.json.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/i18n/es/health.json.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/i18n/es/sessions.json.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/i18n/es/activate.json.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/i18n/es/error.json.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/i18n/es/register.json.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/i18n/es/metrics.json.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/i18n/es/password.json.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/i18n/es/logs.json.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/i18n/es/gateway.json.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/i18n/es/audits.json.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/i18n/es/settings.json.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/i18n/es/configuration.json.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/i18n/angular-locale_es.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/i18n/angular-locale_en.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/favicon.ico", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/manifest.webapp.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/entities/entity.state.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/components/language/language.filter.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/components/language/language.constants.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/components/language/language.service.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/components/language/language.controller.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/components/form/show-validation.directive.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/components/form/minbytes.directive.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/components/form/pagination.constants.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/components/form/maxbytes.directive.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/components/login/login.service.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/components/login/login.html.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/components/login/login.controller.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/components/alert/alert-error.directive.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/components/alert/alert.service.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/components/alert/alert.directive.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/components/util/error.constants.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/components/util/data-util.service.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/components/util/truncate-words.filter.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/components/util/capitalize.filter.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/components/util/modal-draggable.directive.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/components/util/sort-by.directive.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/components/util/parse-links.service.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/components/util/pagination-util.service.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/components/util/truncate-characters.filter.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/components/util/sort.directive.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/components/util/date-util.service.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/components/util/base64.service.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/components/util/jhi-item-count.directive.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/admin/configuration/configuration.state.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/admin/configuration/configuration.controller.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/admin/configuration/configuration.html.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/admin/configuration/configuration.service.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/admin/user-management/user-management.controller.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/admin/user-management/user-management.html.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/admin/user-management/user-management-detail.html.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/admin/user-management/user-management-dialog.html.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/admin/user-management/user-management-delete-dialog.html.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/admin/user-management/user-management-detail.controller.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/admin/user-management/user-management.state.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/admin/user-management/user-management-delete-dialog.controller.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/admin/user-management/user-management-dialog.controller.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/admin/docs/docs.state.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/admin/docs/docs.html.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/admin/audits/audits.controller.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/admin/audits/audits.html.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/admin/audits/audits.service.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/admin/audits/audits.state.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/admin/logs/logs.html.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/admin/logs/logs.service.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/admin/logs/logs.state.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/admin/logs/logs.controller.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/admin/admin.state.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/admin/metrics/metrics.controller.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/admin/metrics/metrics.html.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/admin/metrics/metrics.modal.controller.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/admin/metrics/metrics.state.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/admin/metrics/metrics.service.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/admin/metrics/metrics.modal.html.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/admin/health/health.state.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/admin/health/health.service.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/admin/health/health.modal.html.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/admin/health/health.controller.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/admin/health/health.html.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/admin/health/health.modal.controller.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/layouts/headerbar/headerbar.controller.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/layouts/headerbar/headerbar.html.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/layouts/navbar/navbar.html.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/layouts/navbar/active-menu.directive.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/layouts/navbar/navbar.controller.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/layouts/error/error.state.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/layouts/error/error.html", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/layouts/error/accessdenied.html.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/app.state.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/app.constants.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/blocks/config/compile.config.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/blocks/config/translation-storage.provider.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/blocks/config/translation.config.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/blocks/config/uib-pagination.config.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/blocks/config/alert.config.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/blocks/config/http.config.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/blocks/config/localstorage.config.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/blocks/config/uib-pager.config.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/blocks/handlers/state.handler.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/blocks/handlers/translation.handler.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/blocks/interceptor/auth-expired.interceptor.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/blocks/interceptor/errorhandler.interceptor.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/blocks/interceptor/auth.interceptor.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/blocks/interceptor/notification.interceptor.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/home/home.html.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/home/home.controller.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/home/home.state.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/services/profiles/page-ribbon.directive.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/services/profiles/profile.service.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/services/user/user.service.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/services/auth/has-authority.directive.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/services/auth/register.service.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/services/auth/activate.service.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/services/auth/principal.service.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/services/auth/account.service.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/services/auth/password.service.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/services/auth/password-reset-finish.service.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/services/auth/auth.service.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/services/auth/has-any-authority.directive.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/services/auth/password-reset-init.service.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/services/auth/auth.jwt.service.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/app.module.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/account/account.state.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/account/reset/finish/reset.finish.html.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/account/reset/finish/reset.finish.state.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/account/reset/finish/reset.finish.controller.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/account/reset/request/reset.request.controller.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/account/reset/request/reset.request.html.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/account/reset/request/reset.request.state.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/account/register/register.html.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/account/register/register.state.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/account/register/register.controller.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/account/activate/activate.controller.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/account/activate/activate.html.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/account/activate/activate.state.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/account/password/password.state.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/account/password/password-strength-bar.directive.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/account/password/password.html.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/account/password/password.controller.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/account/settings/settings.html.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/account/settings/settings.state.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/main/webapp/app/account/settings/settings.controller.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/test/javascript/karma.conf.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/test/javascript/spec/app/admin/health/health.controller.spec.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/test/javascript/spec/app/components/login/login.controller.spec.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/test/javascript/spec/app/account/register/register.controller.spec.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/test/javascript/spec/app/account/reset/finish/reset.finish.controller.spec.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/test/javascript/spec/app/account/reset/request/reset.request.controller.spec.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/test/javascript/spec/app/account/activate/activate.controller.spec.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/test/javascript/spec/app/account/password/password.controller.spec.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/test/javascript/spec/app/account/password/password-strength-bar.directive.spec.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/test/javascript/spec/app/account/settings/settings.controller.spec.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/test/javascript/spec/app/services/auth/auth.services.spec.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/test/javascript/spec/helpers/httpBackend.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "src/test/javascript/spec/helpers/module.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "gulp/copy.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "gulp/handle-errors.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "gulp/inject.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "gulp/utils.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "gulp/build.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "gulp/serve.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "gulp/config.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + ".eslintrc.json.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + ".yo-rc.json.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + ".eslintignore.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "gulpfile.js.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "package.json.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "bower.json.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + ".gitattributes.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + "yarn.lock.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + ".editorconfig.ftl", path, pathBuilderAngularJs, model);
        writer.copySmart(ANGULAR_JS_TEMPLATE + ".bowerrc.ftl", path, pathBuilderAngularJs, model);
    }
    
    public static void generateJpaResources(WriterService writer, ProjectConfiguration pConf, Object model) {
        final Function<String, String> pathBuilderJpa = 
                template -> template
                .replace(ANGULAR_SPRING_JPA_TEMPLATE, "${project.id}/")
                .replace(".ftl", "")
                .replace("/package/", "/" + pConf.getPackaging().replaceAll("\\.", "/") + "/")
                .replace("Kukulkan", "${project.id?cap_first}");
                
        Path path = pConf.getOutputDir();
        writer.copy(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/resources/mails/creationEmail.html", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/resources/mails/activationEmail.html", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/resources/mails/passwordResetEmail.html", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/resources/templates/error.html", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/resources/.h2.server.properties.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/resources/config/application.yml.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/resources/config/application-prod.yml.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/resources/config/application-dev.yml.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/resources/config/liquibase/changelog/00000000000000_initial_schema.xml.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/resources/config/liquibase/users_authorities.csv.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/resources/config/liquibase/master.xml.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/resources/config/liquibase/users.csv.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/resources/config/liquibase/authorities.csv.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/resources/i18n/messages_es.properties.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/resources/i18n/messages.properties.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/resources/i18n/messages_en.properties.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/resources/logback-spring.xml.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/docker/Dockerfile", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/docker/.dockerignore.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/docker/mysql.yml.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/docker/sonar.yml.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/docker/app.yml.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/java/package/service/UserService.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/java/package/service/package-info.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/java/package/service/dto/UserDTO.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/java/package/service/dto/package-info.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/java/package/service/mapper/UserMapper.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/java/package/service/mapper/package-info.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/java/package/service/AuditEventService.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/java/package/service/MailService.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/java/package/service/util/RandomUtil.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/java/package/ApplicationWebXml.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/java/package/repository/PersistenceAuditEventRepository.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/java/package/repository/package-info.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/java/package/repository/UserRepository.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/java/package/repository/CustomAuditEventRepository.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/java/package/repository/AuthorityRepository.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/java/package/security/package-info.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/java/package/security/DomainUserDetailsService.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/java/package/security/jwt/TokenProvider.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/java/package/security/jwt/JWTFilter.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/java/package/security/jwt/JWTConfigurer.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/java/package/security/SecurityUtils.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/java/package/security/UserNotActivatedException.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/java/package/security/AuthoritiesConstants.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/java/package/security/SpringSecurityAuditorAware.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/java/package/domain/package-info.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/java/package/domain/Authority.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/java/package/domain/PersistentAuditEvent.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/java/package/domain/User.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/java/package/domain/AbstractAuditingEntity.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/java/package/web/rest/UserResource.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/java/package/web/rest/package-info.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/java/package/web/rest/errors/InvalidPasswordException.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/java/package/web/rest/errors/package-info.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/java/package/web/rest/errors/FieldErrorVM.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/java/package/web/rest/errors/InternalServerErrorException.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/java/package/web/rest/errors/LoginAlreadyUsedException.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/java/package/web/rest/errors/EmailAlreadyUsedException.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/java/package/web/rest/errors/ErrorConstants.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/java/package/web/rest/errors/BadRequestAlertException.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/java/package/web/rest/errors/EmailNotFoundException.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/java/package/web/rest/errors/CustomParameterizedException.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/java/package/web/rest/errors/ExceptionTranslator.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/java/package/web/rest/util/HeaderUtil.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/java/package/web/rest/util/PaginationUtil.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/java/package/web/rest/UserJWTController.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/java/package/web/rest/AccountResource.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/java/package/web/rest/ProfileInfoResource.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/java/package/web/rest/vm/package-info.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/java/package/web/rest/vm/KeyAndPasswordVM.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/java/package/web/rest/vm/ManagedUserVM.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/java/package/web/rest/vm/LoginVM.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/java/package/web/rest/vm/LoggerVM.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/java/package/web/rest/AuditResource.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/java/package/web/rest/LogsResource.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/java/package/config/package-info.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/java/package/config/MetricsConfiguration.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/java/package/config/Constants.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/java/package/config/LocaleConfiguration.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/java/package/config/SecurityConfiguration.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/java/package/config/ThymeleafConfiguration.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/java/package/config/AsyncConfiguration.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/java/package/config/DefaultProfileUtil.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/java/package/config/DatabaseConfiguration.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/java/package/config/WebConfigurer.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/java/package/config/CacheConfiguration.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/java/package/config/ApplicationProperties.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/java/package/config/CloudDatabaseConfiguration.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/java/package/config/LoggingAspectConfiguration.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/java/package/config/audit/AuditEventConverter.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/java/package/config/audit/package-info.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/java/package/config/JacksonConfiguration.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/java/package/config/LoggingConfiguration.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/java/package/config/DateTimeFormatConfiguration.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/java/package/aop/logging/LoggingAspect.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/main/java/package/KukulkanApp.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/test/features/.gitkeep.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/test/features/user/user.feature.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/test/resources/mails/testEmail.html", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/test/resources/logback.xml.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/test/resources/config/application.yml.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/test/resources/i18n/messages_en.properties.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/test/java/package/service/UserServiceIntTest.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/test/java/package/service/MailServiceIntTest.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/test/java/package/repository/CustomAuditEventRepositoryIntTest.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/test/java/package/security/SecurityUtilsUnitTest.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/test/java/package/security/DomainUserDetailsServiceIntTest.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/test/java/package/security/jwt/TokenProviderTest.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/test/java/package/security/jwt/JWTFilterTest.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/test/java/package/cucumber/stepdefs/UserStepDefs.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/test/java/package/cucumber/stepdefs/StepDefs.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/test/java/package/cucumber/CucumberTest.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/test/java/package/web/rest/TestUtil.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/test/java/package/web/rest/UserJWTControllerIntTest.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/test/java/package/web/rest/UserResourceIntTest.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/test/java/package/web/rest/errors/ExceptionTranslatorIntTest.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/test/java/package/web/rest/errors/ExceptionTranslatorTestController.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/test/java/package/web/rest/AccountResourceIntTest.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/test/java/package/web/rest/ProfileInfoResourceIntTest.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/test/java/package/web/rest/util/PaginationUtilUnitTest.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/test/java/package/web/rest/AuditResourceIntTest.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/test/java/package/web/rest/LogsResourceIntTest.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/test/java/package/config/WebConfigurerTest.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "src/test/java/package/config/WebConfigurerTestController.java.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "mvnw.cmd", path, pathBuilderJpa, model).ifPresent(mvnw -> mvnw.setExecutable(true));
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "mvnw", path, pathBuilderJpa, model).ifPresent(mvnw -> mvnw.setExecutable(true));
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "pom.xml.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + ".mvn/wrapper/maven-wrapper.properties", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + ".mvn/wrapper/maven-wrapper.jar", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + "README.md.ftl", path, pathBuilderJpa, model);
        writer.copySmart(ANGULAR_SPRING_JPA_TEMPLATE + ".gitignore.ftl", path, pathBuilderJpa, model);
    }
    
    public static void generateMongo(WriterService writer, ProjectConfiguration pConf, Object model) {
        final Function<String, String> pathBuilderMongo = 
                template -> template
                .replace(ANGULAR_SPRING_MONGO_TEMPLATE, "${project.id}/")
                .replace(".ftl", "")
                .replace("/package/", "/" + pConf.getPackaging().replaceAll("\\.", "/") + "/")
                .replace("Kukulkan", "${project.id?cap_first}");
                
        Path path = pConf.getOutputDir();
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/resources/mails/creationEmail.html", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/resources/mails/activationEmail.html", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/resources/mails/passwordResetEmail.html", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/resources/templates/error.html", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/resources/config/application.yml.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/resources/config/application-prod.yml.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/resources/config/application-dev.yml.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/resources/i18n/messages_es.properties.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/resources/i18n/messages.properties.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/resources/i18n/messages_en.properties.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/resources/logback-spring.xml.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/docker/Dockerfile", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/docker/.dockerignore.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/docker/mongodb/MongoDB.Dockerfile.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/docker/mongodb/scripts/init_replicaset.js.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/docker/mongodb-cluster.yml.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/docker/sonar.yml.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/docker/app.yml.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/docker/mongodb.yml.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/java/package/service/UserService.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/java/package/service/package-info.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/java/package/service/dto/UserDTO.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/java/package/service/dto/package-info.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/java/package/service/mapper/UserMapper.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/java/package/service/mapper/package-info.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/java/package/service/AuditEventService.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/java/package/service/MailService.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/java/package/service/util/RandomUtil.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/java/package/ApplicationWebXml.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/java/package/repository/PersistenceAuditEventRepository.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/java/package/repository/package-info.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/java/package/repository/UserRepository.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/java/package/repository/CustomAuditEventRepository.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/java/package/repository/AuthorityRepository.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/java/package/security/package-info.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/java/package/security/DomainUserDetailsService.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/java/package/security/jwt/TokenProvider.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/java/package/security/jwt/JWTFilter.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/java/package/security/jwt/JWTConfigurer.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/java/package/security/SecurityUtils.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/java/package/security/UserNotActivatedException.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/java/package/security/AuthoritiesConstants.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/java/package/security/SpringSecurityAuditorAware.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/java/package/domain/package-info.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/java/package/domain/Authority.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/java/package/domain/PersistentAuditEvent.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/java/package/domain/User.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/java/package/domain/AbstractAuditingEntity.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/java/package/web/rest/UserResource.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/java/package/web/rest/package-info.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/java/package/web/rest/errors/InvalidPasswordException.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/java/package/web/rest/errors/package-info.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/java/package/web/rest/errors/FieldErrorVM.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/java/package/web/rest/errors/InternalServerErrorException.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/java/package/web/rest/errors/LoginAlreadyUsedException.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/java/package/web/rest/errors/EmailAlreadyUsedException.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/java/package/web/rest/errors/ErrorConstants.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/java/package/web/rest/errors/BadRequestAlertException.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/java/package/web/rest/errors/EmailNotFoundException.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/java/package/web/rest/errors/CustomParameterizedException.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/java/package/web/rest/errors/ExceptionTranslator.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/java/package/web/rest/util/HeaderUtil.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/java/package/web/rest/util/PaginationUtil.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/java/package/web/rest/UserJWTController.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/java/package/web/rest/AccountResource.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/java/package/web/rest/ProfileInfoResource.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/java/package/web/rest/vm/package-info.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/java/package/web/rest/vm/KeyAndPasswordVM.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/java/package/web/rest/vm/ManagedUserVM.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/java/package/web/rest/vm/LoginVM.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/java/package/web/rest/vm/LoggerVM.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/java/package/web/rest/AuditResource.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/java/package/web/rest/LogsResource.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/java/package/config/package-info.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/java/package/config/MetricsConfiguration.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/java/package/config/Constants.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/java/package/config/dbmigrations/package-info.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/java/package/config/dbmigrations/InitialSetupMigration.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/java/package/config/LocaleConfiguration.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/java/package/config/SecurityConfiguration.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/java/package/config/ThymeleafConfiguration.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/java/package/config/AsyncConfiguration.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/java/package/config/DefaultProfileUtil.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/java/package/config/DatabaseConfiguration.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/java/package/config/WebConfigurer.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/java/package/config/CacheConfiguration.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/java/package/config/ApplicationProperties.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/java/package/config/CloudDatabaseConfiguration.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/java/package/config/LoggingAspectConfiguration.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/java/package/config/audit/AuditEventConverter.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/java/package/config/audit/package-info.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/java/package/config/JacksonConfiguration.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/java/package/config/LoggingConfiguration.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/java/package/config/DateTimeFormatConfiguration.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/java/package/aop/logging/LoggingAspect.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/main/java/package/KukulkanApp.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/test/features/.gitkeep.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/test/features/user/user.feature.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/test/resources/mails/testEmail.html", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/test/resources/logback.xml.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/test/resources/config/application.yml.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/test/resources/i18n/messages_en.properties.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/test/java/package/service/UserServiceIntTest.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/test/java/package/service/MailServiceIntTest.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/test/java/package/repository/CustomAuditEventRepositoryIntTest.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/test/java/package/security/SecurityUtilsUnitTest.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/test/java/package/security/DomainUserDetailsServiceIntTest.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/test/java/package/security/jwt/TokenProviderTest.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/test/java/package/security/jwt/JWTFilterTest.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/test/java/package/cucumber/stepdefs/UserStepDefs.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/test/java/package/cucumber/stepdefs/StepDefs.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/test/java/package/cucumber/CucumberTest.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/test/java/package/web/rest/TestUtil.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/test/java/package/web/rest/UserJWTControllerIntTest.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/test/java/package/web/rest/UserResourceIntTest.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/test/java/package/web/rest/errors/ExceptionTranslatorIntTest.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/test/java/package/web/rest/errors/ExceptionTranslatorTestController.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/test/java/package/web/rest/AccountResourceIntTest.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/test/java/package/web/rest/ProfileInfoResourceIntTest.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/test/java/package/web/rest/util/PaginationUtilUnitTest.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/test/java/package/web/rest/AuditResourceIntTest.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/test/java/package/web/rest/LogsResourceIntTest.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/test/java/package/config/WebConfigurerTest.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "src/test/java/package/config/WebConfigurerTestController.java.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "mvnw.cmd", path, pathBuilderMongo, model).ifPresent(mvnw -> mvnw.setExecutable(true));
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "mvnw", path, pathBuilderMongo, model).ifPresent(mvnw -> mvnw.setExecutable(true));
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "pom.xml.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + ".mvn/wrapper/maven-wrapper.properties", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + ".mvn/wrapper/maven-wrapper.jar", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + "README.md.ftl", path, pathBuilderMongo, model);
        writer.copySmart(ANGULAR_SPRING_MONGO_TEMPLATE + ".gitignore.ftl", path, pathBuilderMongo, model);
    }
    
    public static void writeBanner(WriterService writer, BannerService bannerService, ProjectConfiguration pConf) {
        String bannerPath = "src/main/resources/banner.txt";
        Optional<String> generateBanner = bannerService.generateBanner(pConf.getId());

        if (generateBanner.isPresent()) {
            Path toSave = pConf.getOutputDir().resolve(pConf.getId()).resolve(bannerPath);
            writer.save(toSave, generateBanner.get());

        } else {
            writer.copy("banner.txt", pConf.getOutputDir().resolve(pConf.getId()), bannerPath);
        }
    }
}
