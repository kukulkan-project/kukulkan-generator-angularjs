(function() {
    'use strict';

    angular
        .module('testcaseApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        .state('leftUnidirectional', {
            parent: 'entity',
            url: '/leftUnidirectional?page&sort&search',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'testcaseApp.leftUnidirectional.home.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/left-unidirectional/left-unidirectional.html',
                    controller: 'LeftUnidirectionalController',
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
                    $translatePartialLoader.addPart('left-unidirectional');
                    $translatePartialLoader.addPart('global');
                    return $translate.refresh();
                }]
            }
        })
        .state('leftUnidirectional-detail', {
            parent: 'leftUnidirectional',
            url: '/leftUnidirectional/{id}',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'testcaseApp.leftUnidirectional.detail.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/left-unidirectional/left-unidirectional-detail.html',
                    controller: 'LeftUnidirectionalDetailController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('left-unidirectional');
                    return $translate.refresh();
                }],
                entity: ['$stateParams', 'LeftUnidirectional', function($stateParams, LeftUnidirectional) {
                    return LeftUnidirectional.get({id : $stateParams.id}).$promise;
                }],
                previousState: ["$state", function ($state) {
                    var currentStateData = {
                        name: $state.current.name || 'leftUnidirectional',
                        params: $state.params,
                        url: $state.href($state.current.name, $state.params)
                    };
                    return currentStateData;
                }]
            }
        })
        .state('leftUnidirectional-detail.edit', {
            parent: 'leftUnidirectional-detail',
            url: '/detail/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/left-unidirectional/left-unidirectional-dialog.html',
                    controller: 'LeftUnidirectionalDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['LeftUnidirectional', function(LeftUnidirectional) {
                            return LeftUnidirectional.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('^', {}, { reload: false });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('leftUnidirectional.new', {
            parent: 'leftUnidirectional',
            url: '/new',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/left-unidirectional/left-unidirectional-dialog.html',
                    controller: 'LeftUnidirectionalDialogController',
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
                    $state.go('leftUnidirectional', null, { reload: 'leftUnidirectional' });
                }, function() {
                    $state.go('leftUnidirectional');
                });
            }]
        })
        .state('leftUnidirectional.edit', {
            parent: 'leftUnidirectional',
            url: '/{id}/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/left-unidirectional/left-unidirectional-dialog.html',
                    controller: 'LeftUnidirectionalDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['LeftUnidirectional', function(LeftUnidirectional) {
                            return LeftUnidirectional.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('leftUnidirectional', null, { reload: 'leftUnidirectional' });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('leftUnidirectional.delete', {
            parent: 'leftUnidirectional',
            url: '/{id}/delete',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/left-unidirectional/left-unidirectional-delete-dialog.html',
                    controller: 'LeftUnidirectionalDeleteController',
                    controllerAs: 'vm',
                    size: 'md',
                    resolve: {
                        entity: ['LeftUnidirectional', function(LeftUnidirectional) {
                            return LeftUnidirectional.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('leftUnidirectional', null, { reload: 'leftUnidirectional' });
                }, function() {
                    $state.go('^');
                });
            }]
        });
    }

})();
