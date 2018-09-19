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
                    templateUrl: 'app/entities/${entityHyphenNotation}/${entityHyphenNotationPlural}.html',
                    controller: '${entity.name}Controller',
                    controllerAs: 'vm'
                }
            },
            params: {
            <#if !entity.features.sheetable>
                page: {
                    value: '1',
                    squash: true
                },
                search: null,
            </#if>
                sort: {
                    value: 'id,asc',
                    squash: true
                }
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
        })
        .state('${entityCamelCase}-detail', {
            parent: '${entityCamelCase}',
            url: '/${entityCamelCasePlural}/{id}',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: '${projectName}App.${entityCamelCase}.detail.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/${entityHyphenNotation}/${entityHyphenNotation}-detail.html',
                    controller: '${entity.name}DetailController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('${entityHyphenNotation}');
                    return $translate.refresh();
                }],
                entity: ['$stateParams', '${entity.name}', function($stateParams, ${entity.name}) {
                    return ${entity.name}.get({id : $stateParams.id}).$promise;
                }],
                previousState: ["$state", function ($state) {
                    var currentStateData = {
                        name: $state.current.name || '${entityCamelCase}',
                        params: $state.params,
                        url: $state.href($state.current.name, $state.params)
                    };
                    return currentStateData;
                }]
            }
        })
        .state('${entityCamelCase}-detail.edit', {
            parent: '${entityCamelCase}-detail',
            url: '/detail/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/${entityHyphenNotation}/${entityHyphenNotation}-dialog.html',
                    controller: '${entity.name}DialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['${entity.name}', function(${entity.name}) {
                            return ${entity.name}.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('^', {}, { reload: false });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('${entityCamelCase}.new', {
            parent: '${entityCamelCase}',
            url: '/new',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/${entityHyphenNotation}/${entityHyphenNotation}-dialog.html',
                    controller: '${entity.name}DialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: function () {
                            return {
                            	${primaryKey.name}: null,
                          	    <#list properties as property>
                                ${property.name}: <#if property.boolean ==true>false<#else>null</#if><#sep>,</#sep>
                    			</#list>
                            };
                        }
                    }
                }).result.then(function() {
                    $state.go('${entityCamelCase}', null, { reload: '${entityCamelCase}' });
                }, function() {
                    $state.go('${entityCamelCase}');
                });
            }]
        })
        .state('${entityCamelCase}.edit', {
            parent: '${entityCamelCase}',
            url: '/{id}/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/${entityHyphenNotation}/${entityHyphenNotation}-dialog.html',
                    controller: '${entity.name}DialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['${entity.name}', function(${entity.name}) {
                            return ${entity.name}.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('${entityCamelCase}', null, { reload: '${entityCamelCase}' });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('${entityCamelCase}.delete', {
            parent: '${entityCamelCase}',
            url: '/{id}/delete',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/${entityHyphenNotation}/${entityHyphenNotation}-delete-dialog.html',
                    controller: '${entity.name}DeleteController',
                    controllerAs: 'vm',
                    size: 'md',
                    resolve: {
                        entity: ['${entity.name}', function(${entity.name}) {
                            return ${entity.name}.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('${entityCamelCase}', null, { reload: '${entityCamelCase}' });
                }, function() {
                    $state.go('^');
                });
            }]
        });
    }

})();
