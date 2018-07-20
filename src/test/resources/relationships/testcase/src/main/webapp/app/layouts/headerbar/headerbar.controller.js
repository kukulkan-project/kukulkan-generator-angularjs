(function () {
    'use strict';

    angular
        .module('testcaseApp')
        .controller('HeaderbarController', HeaderbarController);

    HeaderbarController.$inject = ['$scope', '$state', 'Principal', 'LoginService', 'Auth'];

    function HeaderbarController($scope, $state, Principal, LoginService, Auth) {
        var vm = this;

        vm.account = null;
        vm.isAuthenticated = null;
        vm.login = LoginService.open;
        vm.logout = logout;

        $scope.$on('authenticationSuccess', function () {
            getAccount();
        });

        getAccount();

        function getAccount() {
            Principal.identity().then(function (account) {
                vm.account = account;
                vm.isAuthenticated = Principal.isAuthenticated;
            });
        }

        function logout() {
            Auth.logout();
            $state.go('home');
        }
    }
})();
