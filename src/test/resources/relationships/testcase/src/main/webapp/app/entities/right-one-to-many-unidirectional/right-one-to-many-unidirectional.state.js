(function() {
    'use strict';

    angular
        .module('testcaseApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        .state('rightOneToManyUnidirectional', {
            parent: 'entity',
            url: '/rightOneToManyUnidirectional?page&sort&search',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'testcaseApp.rightOneToManyUnidirectional.home.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/right-one-to-many-unidirectional/right-one-to-many-unidirectional.html',
                    controller: 'RightOneToManyUnidirectionalController',
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
                    $translatePartialLoader.addPart('right-one-to-many-unidirectional');
                    $translatePartialLoader.addPart('global');
                    return $translate.refresh();
                }]
            }
        })
        .state('rightOneToManyUnidirectional-detail', {
            parent: 'rightOneToManyUnidirectional',
            url: '/rightOneToManyUnidirectional/{id}',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'testcaseApp.rightOneToManyUnidirectional.detail.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/right-one-to-many-unidirectional/right-one-to-many-unidirectional-detail.html',
                    controller: 'RightOneToManyUnidirectionalDetailController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('right-one-to-many-unidirectional');
                    return $translate.refresh();
                }],
                entity: ['$stateParams', 'RightOneToManyUnidirectional', function($stateParams, RightOneToManyUnidirectional) {
                    return RightOneToManyUnidirectional.get({id : $stateParams.id}).$promise;
                }],
                previousState: ["$state", function ($state) {
                    var currentStateData = {
                        name: $state.current.name || 'rightOneToManyUnidirectional',
                        params: $state.params,
                        url: $state.href($state.current.name, $state.params)
                    };
                    return currentStateData;
                }]
            }
        })
        .state('rightOneToManyUnidirectional-detail.edit', {
            parent: 'rightOneToManyUnidirectional-detail',
            url: '/detail/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/right-one-to-many-unidirectional/right-one-to-many-unidirectional-dialog.html',
                    controller: 'RightOneToManyUnidirectionalDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['RightOneToManyUnidirectional', function(RightOneToManyUnidirectional) {
                            return RightOneToManyUnidirectional.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('^', {}, { reload: false });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('rightOneToManyUnidirectional.new', {
            parent: 'rightOneToManyUnidirectional',
            url: '/new',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/right-one-to-many-unidirectional/right-one-to-many-unidirectional-dialog.html',
                    controller: 'RightOneToManyUnidirectionalDialogController',
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
                    $state.go('rightOneToManyUnidirectional', null, { reload: 'rightOneToManyUnidirectional' });
                }, function() {
                    $state.go('rightOneToManyUnidirectional');
                });
            }]
        })
        .state('rightOneToManyUnidirectional.edit', {
            parent: 'rightOneToManyUnidirectional',
            url: '/{id}/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/right-one-to-many-unidirectional/right-one-to-many-unidirectional-dialog.html',
                    controller: 'RightOneToManyUnidirectionalDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['RightOneToManyUnidirectional', function(RightOneToManyUnidirectional) {
                            return RightOneToManyUnidirectional.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('rightOneToManyUnidirectional', null, { reload: 'rightOneToManyUnidirectional' });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('rightOneToManyUnidirectional.delete', {
            parent: 'rightOneToManyUnidirectional',
            url: '/{id}/delete',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/right-one-to-many-unidirectional/right-one-to-many-unidirectional-delete-dialog.html',
                    controller: 'RightOneToManyUnidirectionalDeleteController',
                    controllerAs: 'vm',
                    size: 'md',
                    resolve: {
                        entity: ['RightOneToManyUnidirectional', function(RightOneToManyUnidirectional) {
                            return RightOneToManyUnidirectional.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('rightOneToManyUnidirectional', null, { reload: 'rightOneToManyUnidirectional' });
                }, function() {
                    $state.go('^');
                });
            }]
        });
    }

})();
