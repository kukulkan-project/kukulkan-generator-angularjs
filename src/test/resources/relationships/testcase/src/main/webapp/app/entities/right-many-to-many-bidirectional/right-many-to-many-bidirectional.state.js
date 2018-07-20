(function() {
    'use strict';

    angular
        .module('testcaseApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        .state('rightManyToManyBidirectional', {
            parent: 'entity',
            url: '/rightManyToManyBidirectional?page&sort&search',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'testcaseApp.rightManyToManyBidirectional.home.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/right-many-to-many-bidirectional/right-many-to-many-bidirectional.html',
                    controller: 'RightManyToManyBidirectionalController',
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
                    $translatePartialLoader.addPart('right-many-to-many-bidirectional');
                    $translatePartialLoader.addPart('global');
                    return $translate.refresh();
                }]
            }
        })
        .state('rightManyToManyBidirectional-detail', {
            parent: 'rightManyToManyBidirectional',
            url: '/rightManyToManyBidirectional/{id}',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'testcaseApp.rightManyToManyBidirectional.detail.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/right-many-to-many-bidirectional/right-many-to-many-bidirectional-detail.html',
                    controller: 'RightManyToManyBidirectionalDetailController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('right-many-to-many-bidirectional');
                    return $translate.refresh();
                }],
                entity: ['$stateParams', 'RightManyToManyBidirectional', function($stateParams, RightManyToManyBidirectional) {
                    return RightManyToManyBidirectional.get({id : $stateParams.id}).$promise;
                }],
                previousState: ["$state", function ($state) {
                    var currentStateData = {
                        name: $state.current.name || 'rightManyToManyBidirectional',
                        params: $state.params,
                        url: $state.href($state.current.name, $state.params)
                    };
                    return currentStateData;
                }]
            }
        })
        .state('rightManyToManyBidirectional-detail.edit', {
            parent: 'rightManyToManyBidirectional-detail',
            url: '/detail/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/right-many-to-many-bidirectional/right-many-to-many-bidirectional-dialog.html',
                    controller: 'RightManyToManyBidirectionalDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['RightManyToManyBidirectional', function(RightManyToManyBidirectional) {
                            return RightManyToManyBidirectional.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('^', {}, { reload: false });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('rightManyToManyBidirectional.new', {
            parent: 'rightManyToManyBidirectional',
            url: '/new',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/right-many-to-many-bidirectional/right-many-to-many-bidirectional-dialog.html',
                    controller: 'RightManyToManyBidirectionalDialogController',
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
                    $state.go('rightManyToManyBidirectional', null, { reload: 'rightManyToManyBidirectional' });
                }, function() {
                    $state.go('rightManyToManyBidirectional');
                });
            }]
        })
        .state('rightManyToManyBidirectional.edit', {
            parent: 'rightManyToManyBidirectional',
            url: '/{id}/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/right-many-to-many-bidirectional/right-many-to-many-bidirectional-dialog.html',
                    controller: 'RightManyToManyBidirectionalDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['RightManyToManyBidirectional', function(RightManyToManyBidirectional) {
                            return RightManyToManyBidirectional.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('rightManyToManyBidirectional', null, { reload: 'rightManyToManyBidirectional' });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('rightManyToManyBidirectional.delete', {
            parent: 'rightManyToManyBidirectional',
            url: '/{id}/delete',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/right-many-to-many-bidirectional/right-many-to-many-bidirectional-delete-dialog.html',
                    controller: 'RightManyToManyBidirectionalDeleteController',
                    controllerAs: 'vm',
                    size: 'md',
                    resolve: {
                        entity: ['RightManyToManyBidirectional', function(RightManyToManyBidirectional) {
                            return RightManyToManyBidirectional.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('rightManyToManyBidirectional', null, { reload: 'rightManyToManyBidirectional' });
                }, function() {
                    $state.go('^');
                });
            }]
        });
    }

})();
