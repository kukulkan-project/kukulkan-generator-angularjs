(function() {
    'use strict';

    angular
        .module('${projectName}App')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        .state('${entityCamelCase}', {
            parent: 'entity',
            url: '/${entityCamelCasePlural}?page&sort&search',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: '${projectName}App.${entityCamelCase}.home.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/${entityHyphenNotation}/${entityHyphenNotationPlural}-handsontable.html',
                    controller: '${entity.name}SheetController',
                    controllerAs: 'vm'
                }
            },
            params: {
                page: {
                    value: '1',
                    squash: true
                },
                sort: {
                    value: 'id,asc',
                    squash: true
                },
                search: null
            },
            resolve: {
                pagingParams: ['$stateParams', 'PaginationUtil', function ($stateParams, PaginationUtil) {
                    return {
                        page: PaginationUtil.parsePage($stateParams.page),
                        sort: $stateParams.sort,
                        predicate: PaginationUtil.parsePredicate($stateParams.sort),
                        ascending: PaginationUtil.parseAscending($stateParams.sort),
                        search: $stateParams.search
                    };
                }],
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('${entityHyphenNotation}');
                    $translatePartialLoader.addPart('global');
                    return $translate.refresh();
                }]
            }
        });
    }

})();
