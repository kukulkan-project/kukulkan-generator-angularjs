(function() {
    'use strict';

    angular
        .module('testcaseApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        .state('rightOneToOneUnidirectional', {
            parent: 'entity',
            url: '/rightOneToOneUnidirectional?page&sort&search',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'testcaseApp.rightOneToOneUnidirectional.home.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/right-one-to-one-unidirectional/right-one-to-one-unidirectional.html',
                    controller: 'RightOneToOneUnidirectionalController',
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
                    $translatePartialLoader.addPart('right-one-to-one-unidirectional');
                    $translatePartialLoader.addPart('global');
                    return $translate.refresh();
                }]
            }
        })
        .state('rightOneToOneUnidirectional-detail', {
            parent: 'rightOneToOneUnidirectional',
            url: '/rightOneToOneUnidirectional/{id}',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'testcaseApp.rightOneToOneUnidirectional.detail.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/right-one-to-one-unidirectional/right-one-to-one-unidirectional-detail.html',
                    controller: 'RightOneToOneUnidirectionalDetailController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('right-one-to-one-unidirectional');
                    return $translate.refresh();
                }],
                entity: ['$stateParams', 'RightOneToOneUnidirectional', function($stateParams, RightOneToOneUnidirectional) {
                    return RightOneToOneUnidirectional.get({id : $stateParams.id}).$promise;
                }],
                previousState: ["$state", function ($state) {
                    var currentStateData = {
                        name: $state.current.name || 'rightOneToOneUnidirectional',
                        params: $state.params,
                        url: $state.href($state.current.name, $state.params)
                    };
                    return currentStateData;
                }]
            }
        })
        .state('rightOneToOneUnidirectional-detail.edit', {
            parent: 'rightOneToOneUnidirectional-detail',
            url: '/detail/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/right-one-to-one-unidirectional/right-one-to-one-unidirectional-dialog.html',
                    controller: 'RightOneToOneUnidirectionalDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['RightOneToOneUnidirectional', function(RightOneToOneUnidirectional) {
                            return RightOneToOneUnidirectional.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('^', {}, { reload: false });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('rightOneToOneUnidirectional.new', {
            parent: 'rightOneToOneUnidirectional',
            url: '/new',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/right-one-to-one-unidirectional/right-one-to-one-unidirectional-dialog.html',
                    controller: 'RightOneToOneUnidirectionalDialogController',
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
                    $state.go('rightOneToOneUnidirectional', null, { reload: 'rightOneToOneUnidirectional' });
                }, function() {
                    $state.go('rightOneToOneUnidirectional');
                });
            }]
        })
        .state('rightOneToOneUnidirectional.edit', {
            parent: 'rightOneToOneUnidirectional',
            url: '/{id}/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/right-one-to-one-unidirectional/right-one-to-one-unidirectional-dialog.html',
                    controller: 'RightOneToOneUnidirectionalDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['RightOneToOneUnidirectional', function(RightOneToOneUnidirectional) {
                            return RightOneToOneUnidirectional.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('rightOneToOneUnidirectional', null, { reload: 'rightOneToOneUnidirectional' });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('rightOneToOneUnidirectional.delete', {
            parent: 'rightOneToOneUnidirectional',
            url: '/{id}/delete',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/right-one-to-one-unidirectional/right-one-to-one-unidirectional-delete-dialog.html',
                    controller: 'RightOneToOneUnidirectionalDeleteController',
                    controllerAs: 'vm',
                    size: 'md',
                    resolve: {
                        entity: ['RightOneToOneUnidirectional', function(RightOneToOneUnidirectional) {
                            return RightOneToOneUnidirectional.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('rightOneToOneUnidirectional', null, { reload: 'rightOneToOneUnidirectional' });
                }, function() {
                    $state.go('^');
                });
            }]
        });
    }

})();
