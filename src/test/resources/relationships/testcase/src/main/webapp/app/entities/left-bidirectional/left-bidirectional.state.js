(function() {
    'use strict';

    angular
        .module('testcaseApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        .state('leftBidirectional', {
            parent: 'entity',
            url: '/leftBidirectional?page&sort&search',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'testcaseApp.leftBidirectional.home.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/left-bidirectional/left-bidirectional.html',
                    controller: 'LeftBidirectionalController',
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
                    $translatePartialLoader.addPart('left-bidirectional');
                    $translatePartialLoader.addPart('global');
                    return $translate.refresh();
                }]
            }
        })
        .state('leftBidirectional-detail', {
            parent: 'leftBidirectional',
            url: '/leftBidirectional/{id}',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'testcaseApp.leftBidirectional.detail.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/left-bidirectional/left-bidirectional-detail.html',
                    controller: 'LeftBidirectionalDetailController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('left-bidirectional');
                    return $translate.refresh();
                }],
                entity: ['$stateParams', 'LeftBidirectional', function($stateParams, LeftBidirectional) {
                    return LeftBidirectional.get({id : $stateParams.id}).$promise;
                }],
                previousState: ["$state", function ($state) {
                    var currentStateData = {
                        name: $state.current.name || 'leftBidirectional',
                        params: $state.params,
                        url: $state.href($state.current.name, $state.params)
                    };
                    return currentStateData;
                }]
            }
        })
        .state('leftBidirectional-detail.edit', {
            parent: 'leftBidirectional-detail',
            url: '/detail/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/left-bidirectional/left-bidirectional-dialog.html',
                    controller: 'LeftBidirectionalDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['LeftBidirectional', function(LeftBidirectional) {
                            return LeftBidirectional.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('^', {}, { reload: false });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('leftBidirectional.new', {
            parent: 'leftBidirectional',
            url: '/new',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/left-bidirectional/left-bidirectional-dialog.html',
                    controller: 'LeftBidirectionalDialogController',
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
                    $state.go('leftBidirectional', null, { reload: 'leftBidirectional' });
                }, function() {
                    $state.go('leftBidirectional');
                });
            }]
        })
        .state('leftBidirectional.edit', {
            parent: 'leftBidirectional',
            url: '/{id}/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/left-bidirectional/left-bidirectional-dialog.html',
                    controller: 'LeftBidirectionalDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['LeftBidirectional', function(LeftBidirectional) {
                            return LeftBidirectional.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('leftBidirectional', null, { reload: 'leftBidirectional' });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('leftBidirectional.delete', {
            parent: 'leftBidirectional',
            url: '/{id}/delete',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/left-bidirectional/left-bidirectional-delete-dialog.html',
                    controller: 'LeftBidirectionalDeleteController',
                    controllerAs: 'vm',
                    size: 'md',
                    resolve: {
                        entity: ['LeftBidirectional', function(LeftBidirectional) {
                            return LeftBidirectional.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('leftBidirectional', null, { reload: 'leftBidirectional' });
                }, function() {
                    $state.go('^');
                });
            }]
        });
    }

})();
