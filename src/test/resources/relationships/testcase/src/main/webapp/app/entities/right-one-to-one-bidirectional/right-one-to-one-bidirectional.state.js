(function() {
    'use strict';

    angular
        .module('testcaseApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        .state('rightOneToOneBidirectional', {
            parent: 'entity',
            url: '/rightOneToOneBidirectional?page&sort&search',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'testcaseApp.rightOneToOneBidirectional.home.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/right-one-to-one-bidirectional/right-one-to-one-bidirectional.html',
                    controller: 'RightOneToOneBidirectionalController',
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
                    $translatePartialLoader.addPart('right-one-to-one-bidirectional');
                    $translatePartialLoader.addPart('global');
                    return $translate.refresh();
                }]
            }
        })
        .state('rightOneToOneBidirectional-detail', {
            parent: 'rightOneToOneBidirectional',
            url: '/rightOneToOneBidirectional/{id}',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'testcaseApp.rightOneToOneBidirectional.detail.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/right-one-to-one-bidirectional/right-one-to-one-bidirectional-detail.html',
                    controller: 'RightOneToOneBidirectionalDetailController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('right-one-to-one-bidirectional');
                    return $translate.refresh();
                }],
                entity: ['$stateParams', 'RightOneToOneBidirectional', function($stateParams, RightOneToOneBidirectional) {
                    return RightOneToOneBidirectional.get({id : $stateParams.id}).$promise;
                }],
                previousState: ["$state", function ($state) {
                    var currentStateData = {
                        name: $state.current.name || 'rightOneToOneBidirectional',
                        params: $state.params,
                        url: $state.href($state.current.name, $state.params)
                    };
                    return currentStateData;
                }]
            }
        })
        .state('rightOneToOneBidirectional-detail.edit', {
            parent: 'rightOneToOneBidirectional-detail',
            url: '/detail/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/right-one-to-one-bidirectional/right-one-to-one-bidirectional-dialog.html',
                    controller: 'RightOneToOneBidirectionalDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['RightOneToOneBidirectional', function(RightOneToOneBidirectional) {
                            return RightOneToOneBidirectional.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('^', {}, { reload: false });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('rightOneToOneBidirectional.new', {
            parent: 'rightOneToOneBidirectional',
            url: '/new',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/right-one-to-one-bidirectional/right-one-to-one-bidirectional-dialog.html',
                    controller: 'RightOneToOneBidirectionalDialogController',
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
                    $state.go('rightOneToOneBidirectional', null, { reload: 'rightOneToOneBidirectional' });
                }, function() {
                    $state.go('rightOneToOneBidirectional');
                });
            }]
        })
        .state('rightOneToOneBidirectional.edit', {
            parent: 'rightOneToOneBidirectional',
            url: '/{id}/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/right-one-to-one-bidirectional/right-one-to-one-bidirectional-dialog.html',
                    controller: 'RightOneToOneBidirectionalDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['RightOneToOneBidirectional', function(RightOneToOneBidirectional) {
                            return RightOneToOneBidirectional.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('rightOneToOneBidirectional', null, { reload: 'rightOneToOneBidirectional' });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('rightOneToOneBidirectional.delete', {
            parent: 'rightOneToOneBidirectional',
            url: '/{id}/delete',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/right-one-to-one-bidirectional/right-one-to-one-bidirectional-delete-dialog.html',
                    controller: 'RightOneToOneBidirectionalDeleteController',
                    controllerAs: 'vm',
                    size: 'md',
                    resolve: {
                        entity: ['RightOneToOneBidirectional', function(RightOneToOneBidirectional) {
                            return RightOneToOneBidirectional.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('rightOneToOneBidirectional', null, { reload: 'rightOneToOneBidirectional' });
                }, function() {
                    $state.go('^');
                });
            }]
        });
    }

})();
