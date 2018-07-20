(function() {
    'use strict';

    angular
        .module('testcaseApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        .state('rightOneToManyBidirectional', {
            parent: 'entity',
            url: '/rightOneToManyBidirectional?page&sort&search',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'testcaseApp.rightOneToManyBidirectional.home.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/right-one-to-many-bidirectional/right-one-to-many-bidirectional.html',
                    controller: 'RightOneToManyBidirectionalController',
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
                    $translatePartialLoader.addPart('right-one-to-many-bidirectional');
                    $translatePartialLoader.addPart('global');
                    return $translate.refresh();
                }]
            }
        })
        .state('rightOneToManyBidirectional-detail', {
            parent: 'rightOneToManyBidirectional',
            url: '/rightOneToManyBidirectional/{id}',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'testcaseApp.rightOneToManyBidirectional.detail.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/right-one-to-many-bidirectional/right-one-to-many-bidirectional-detail.html',
                    controller: 'RightOneToManyBidirectionalDetailController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('right-one-to-many-bidirectional');
                    return $translate.refresh();
                }],
                entity: ['$stateParams', 'RightOneToManyBidirectional', function($stateParams, RightOneToManyBidirectional) {
                    return RightOneToManyBidirectional.get({id : $stateParams.id}).$promise;
                }],
                previousState: ["$state", function ($state) {
                    var currentStateData = {
                        name: $state.current.name || 'rightOneToManyBidirectional',
                        params: $state.params,
                        url: $state.href($state.current.name, $state.params)
                    };
                    return currentStateData;
                }]
            }
        })
        .state('rightOneToManyBidirectional-detail.edit', {
            parent: 'rightOneToManyBidirectional-detail',
            url: '/detail/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/right-one-to-many-bidirectional/right-one-to-many-bidirectional-dialog.html',
                    controller: 'RightOneToManyBidirectionalDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['RightOneToManyBidirectional', function(RightOneToManyBidirectional) {
                            return RightOneToManyBidirectional.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('^', {}, { reload: false });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('rightOneToManyBidirectional.new', {
            parent: 'rightOneToManyBidirectional',
            url: '/new',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/right-one-to-many-bidirectional/right-one-to-many-bidirectional-dialog.html',
                    controller: 'RightOneToManyBidirectionalDialogController',
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
                    $state.go('rightOneToManyBidirectional', null, { reload: 'rightOneToManyBidirectional' });
                }, function() {
                    $state.go('rightOneToManyBidirectional');
                });
            }]
        })
        .state('rightOneToManyBidirectional.edit', {
            parent: 'rightOneToManyBidirectional',
            url: '/{id}/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/right-one-to-many-bidirectional/right-one-to-many-bidirectional-dialog.html',
                    controller: 'RightOneToManyBidirectionalDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['RightOneToManyBidirectional', function(RightOneToManyBidirectional) {
                            return RightOneToManyBidirectional.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('rightOneToManyBidirectional', null, { reload: 'rightOneToManyBidirectional' });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('rightOneToManyBidirectional.delete', {
            parent: 'rightOneToManyBidirectional',
            url: '/{id}/delete',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/right-one-to-many-bidirectional/right-one-to-many-bidirectional-delete-dialog.html',
                    controller: 'RightOneToManyBidirectionalDeleteController',
                    controllerAs: 'vm',
                    size: 'md',
                    resolve: {
                        entity: ['RightOneToManyBidirectional', function(RightOneToManyBidirectional) {
                            return RightOneToManyBidirectional.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('rightOneToManyBidirectional', null, { reload: 'rightOneToManyBidirectional' });
                }, function() {
                    $state.go('^');
                });
            }]
        });
    }

})();
