(function () {
    'use strict';

    angular
        .module('${project.id}App')
        .config(breadcrumbConfig);

    breadcrumbConfig.$inject = ['$breadcrumbProvider'];

    function breadcrumbConfig($breadcrumbProvider) {
        $breadcrumbProvider.setOptions({
            templateUrl: 'app/layouts/breadcrumb/breadcrumb.html'
        });
    }
})();