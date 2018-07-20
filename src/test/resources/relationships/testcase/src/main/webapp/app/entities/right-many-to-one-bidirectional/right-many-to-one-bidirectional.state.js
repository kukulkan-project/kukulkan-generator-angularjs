(function() {
    'use strict';

    angular
        .module('testcaseApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        .state('rightManyToOneBidirectional', {
            parent: 'entity',
            url: '/rightManyToOneBidirectional?page&sort&search',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'testcaseApp.rightManyToOneBidirectional.home.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/right-many-to-one-bidirectional/right-many-to-one-bidirectional.html',
                    controller: 'RightManyToOneBidirectionalController',
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
                    $translatePartialLoader.addPart('right-many-to-one-bidirectional');
                    $translatePartialLoader.addPart('global');
                    return $translate.refresh();
                }]
            }
        })
        .state('rightManyToOneBidirectional-detail', {
            parent: 'rightManyToOneBidirectional',
            url: '/rightManyToOneBidirectional/{id}',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'testcaseApp.rightManyToOneBidirectional.detail.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/right-many-to-one-bidirectional/right-many-to-one-bidirectional-detail.html',
                    controller: 'RightManyToOneBidirectionalDetailController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('right-many-to-one-bidirectional');
                    return $translate.refresh();
                }],
                entity: ['$stateParams', 'RightManyToOneBidirectional', function($stateParams, RightManyToOneBidirectional) {
                    return RightManyToOneBidirectional.get({id : $stateParams.id}).$promise;
                }],
                previousState: ["$state", function ($state) {
                    var currentStateData = {
                        name: $state.current.name || 'rightManyToOneBidirectional',
                        params: $state.params,
                        url: $state.href($state.current.name, $state.params)
                    };
                    return currentStateData;
                }]
            }
        })
        .state('rightManyToOneBidirectional-detail.edit', {
            parent: 'rightManyToOneBidirectional-detail',
            url: '/detail/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/right-many-to-one-bidirectional/right-many-to-one-bidirectional-dialog.html',
                    controller: 'RightManyToOneBidirectionalDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['RightManyToOneBidirectional', function(RightManyToOneBidirectional) {
                            return RightManyToOneBidirectional.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('^', {}, { reload: false });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('rightManyToOneBidirectional.new', {
            parent: 'rightManyToOneBidirectional',
            url: '/new',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/right-many-to-one-bidirectional/right-many-to-one-bidirectional-dialog.html',
                    controller: 'RightManyToOneBidirectionalDialogController',
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
                    $state.go('rightManyToOneBidirectional', null, { reload: 'rightManyToOneBidirectional' });
                }, function() {
                    $state.go('rightManyToOneBidirectional');
                });
            }]
        })
        .state('rightManyToOneBidirectional.edit', {
            parent: 'rightManyToOneBidirectional',
            url: '/{id}/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/right-many-to-one-bidirectional/right-many-to-one-bidirectional-dialog.html',
                    controller: 'RightManyToOneBidirectionalDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['RightManyToOneBidirectional', function(RightManyToOneBidirectional) {
                            return RightManyToOneBidirectional.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('rightManyToOneBidirectional', null, { reload: 'rightManyToOneBidirectional' });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('rightManyToOneBidirectional.delete', {
            parent: 'rightManyToOneBidirectional',
            url: '/{id}/delete',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/right-many-to-one-bidirectional/right-many-to-one-bidirectional-delete-dialog.html',
                    controller: 'RightManyToOneBidirectionalDeleteController',
                    controllerAs: 'vm',
                    size: 'md',
                    resolve: {
                        entity: ['RightManyToOneBidirectional', function(RightManyToOneBidirectional) {
                            return RightManyToOneBidirectional.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('rightManyToOneBidirectional', null, { reload: 'rightManyToOneBidirectional' });
                }, function() {
                    $state.go('^');
                });
            }]
        });
    }

})();
