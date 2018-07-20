(function() {
    'use strict';

    angular
        .module('testcaseApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        .state('rightManyToManyUnidirectional', {
            parent: 'entity',
            url: '/rightManyToManyUnidirectional?page&sort&search',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'testcaseApp.rightManyToManyUnidirectional.home.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/right-many-to-many-unidirectional/right-many-to-many-unidirectional.html',
                    controller: 'RightManyToManyUnidirectionalController',
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
                    $translatePartialLoader.addPart('right-many-to-many-unidirectional');
                    $translatePartialLoader.addPart('global');
                    return $translate.refresh();
                }]
            }
        })
        .state('rightManyToManyUnidirectional-detail', {
            parent: 'rightManyToManyUnidirectional',
            url: '/rightManyToManyUnidirectional/{id}',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'testcaseApp.rightManyToManyUnidirectional.detail.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/right-many-to-many-unidirectional/right-many-to-many-unidirectional-detail.html',
                    controller: 'RightManyToManyUnidirectionalDetailController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('right-many-to-many-unidirectional');
                    return $translate.refresh();
                }],
                entity: ['$stateParams', 'RightManyToManyUnidirectional', function($stateParams, RightManyToManyUnidirectional) {
                    return RightManyToManyUnidirectional.get({id : $stateParams.id}).$promise;
                }],
                previousState: ["$state", function ($state) {
                    var currentStateData = {
                        name: $state.current.name || 'rightManyToManyUnidirectional',
                        params: $state.params,
                        url: $state.href($state.current.name, $state.params)
                    };
                    return currentStateData;
                }]
            }
        })
        .state('rightManyToManyUnidirectional-detail.edit', {
            parent: 'rightManyToManyUnidirectional-detail',
            url: '/detail/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/right-many-to-many-unidirectional/right-many-to-many-unidirectional-dialog.html',
                    controller: 'RightManyToManyUnidirectionalDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['RightManyToManyUnidirectional', function(RightManyToManyUnidirectional) {
                            return RightManyToManyUnidirectional.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('^', {}, { reload: false });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('rightManyToManyUnidirectional.new', {
            parent: 'rightManyToManyUnidirectional',
            url: '/new',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/right-many-to-many-unidirectional/right-many-to-many-unidirectional-dialog.html',
                    controller: 'RightManyToManyUnidirectionalDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: function () {
                            return {
                            	id: null,
                            };
                        }
                    }
                }).result.then(function() {
                    $state.go('rightManyToManyUnidirectional', null, { reload: 'rightManyToManyUnidirectional' });
                }, function() {
                    $state.go('rightManyToManyUnidirectional');
                });
            }]
        })
        .state('rightManyToManyUnidirectional.edit', {
            parent: 'rightManyToManyUnidirectional',
            url: '/{id}/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/right-many-to-many-unidirectional/right-many-to-many-unidirectional-dialog.html',
                    controller: 'RightManyToManyUnidirectionalDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['RightManyToManyUnidirectional', function(RightManyToManyUnidirectional) {
                            return RightManyToManyUnidirectional.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('rightManyToManyUnidirectional', null, { reload: 'rightManyToManyUnidirectional' });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('rightManyToManyUnidirectional.delete', {
            parent: 'rightManyToManyUnidirectional',
            url: '/{id}/delete',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/right-many-to-many-unidirectional/right-many-to-many-unidirectional-delete-dialog.html',
                    controller: 'RightManyToManyUnidirectionalDeleteController',
                    controllerAs: 'vm',
                    size: 'md',
                    resolve: {
                        entity: ['RightManyToManyUnidirectional', function(RightManyToManyUnidirectional) {
                            return RightManyToManyUnidirectional.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('rightManyToManyUnidirectional', null, { reload: 'rightManyToManyUnidirectional' });
                }, function() {
                    $state.go('^');
                });
            }]
        });
    }

})();
