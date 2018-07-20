(function() {
    'use strict';

    angular
        .module('testcaseApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        .state('rightManyToOneUnidirectional', {
            parent: 'entity',
            url: '/rightManyToOneUnidirectional?page&sort&search',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'testcaseApp.rightManyToOneUnidirectional.home.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/right-many-to-one-unidirectional/right-many-to-one-unidirectional.html',
                    controller: 'RightManyToOneUnidirectionalController',
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
                    $translatePartialLoader.addPart('right-many-to-one-unidirectional');
                    $translatePartialLoader.addPart('global');
                    return $translate.refresh();
                }]
            }
        })
        .state('rightManyToOneUnidirectional-detail', {
            parent: 'rightManyToOneUnidirectional',
            url: '/rightManyToOneUnidirectional/{id}',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'testcaseApp.rightManyToOneUnidirectional.detail.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/right-many-to-one-unidirectional/right-many-to-one-unidirectional-detail.html',
                    controller: 'RightManyToOneUnidirectionalDetailController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('right-many-to-one-unidirectional');
                    return $translate.refresh();
                }],
                entity: ['$stateParams', 'RightManyToOneUnidirectional', function($stateParams, RightManyToOneUnidirectional) {
                    return RightManyToOneUnidirectional.get({id : $stateParams.id}).$promise;
                }],
                previousState: ["$state", function ($state) {
                    var currentStateData = {
                        name: $state.current.name || 'rightManyToOneUnidirectional',
                        params: $state.params,
                        url: $state.href($state.current.name, $state.params)
                    };
                    return currentStateData;
                }]
            }
        })
        .state('rightManyToOneUnidirectional-detail.edit', {
            parent: 'rightManyToOneUnidirectional-detail',
            url: '/detail/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/right-many-to-one-unidirectional/right-many-to-one-unidirectional-dialog.html',
                    controller: 'RightManyToOneUnidirectionalDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['RightManyToOneUnidirectional', function(RightManyToOneUnidirectional) {
                            return RightManyToOneUnidirectional.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('^', {}, { reload: false });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('rightManyToOneUnidirectional.new', {
            parent: 'rightManyToOneUnidirectional',
            url: '/new',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/right-many-to-one-unidirectional/right-many-to-one-unidirectional-dialog.html',
                    controller: 'RightManyToOneUnidirectionalDialogController',
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
                    $state.go('rightManyToOneUnidirectional', null, { reload: 'rightManyToOneUnidirectional' });
                }, function() {
                    $state.go('rightManyToOneUnidirectional');
                });
            }]
        })
        .state('rightManyToOneUnidirectional.edit', {
            parent: 'rightManyToOneUnidirectional',
            url: '/{id}/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/right-many-to-one-unidirectional/right-many-to-one-unidirectional-dialog.html',
                    controller: 'RightManyToOneUnidirectionalDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['RightManyToOneUnidirectional', function(RightManyToOneUnidirectional) {
                            return RightManyToOneUnidirectional.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('rightManyToOneUnidirectional', null, { reload: 'rightManyToOneUnidirectional' });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('rightManyToOneUnidirectional.delete', {
            parent: 'rightManyToOneUnidirectional',
            url: '/{id}/delete',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/right-many-to-one-unidirectional/right-many-to-one-unidirectional-delete-dialog.html',
                    controller: 'RightManyToOneUnidirectionalDeleteController',
                    controllerAs: 'vm',
                    size: 'md',
                    resolve: {
                        entity: ['RightManyToOneUnidirectional', function(RightManyToOneUnidirectional) {
                            return RightManyToOneUnidirectional.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('rightManyToOneUnidirectional', null, { reload: 'rightManyToOneUnidirectional' });
                }, function() {
                    $state.go('^');
                });
            }]
        });
    }

})();
