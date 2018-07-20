(function () {
    'use strict';

    angular
        .module('testcaseApp')
        .controller('NavbarController', NavbarController);

    NavbarController.$inject = ['$state', 'Principal', 'ProfileService'];

    function NavbarController($state, Principal, ProfileService) {
        var vm = this;

        vm.isNavbarCollapsed = true;
        vm.isAuthenticated = Principal.isAuthenticated;

        ProfileService.getProfileInfo().then(function (response) {
            vm.inProduction = response.inProduction;
            vm.swaggerEnabled = response.swaggerEnabled;
        });

        vm.toggleNavbar = toggleNavbar;
        vm.collapseNavbar = collapseNavbar;
        vm.$state = $state;

        var pageWrapper = angular.element("#page-wrapper");

        function collapseNavbar() {
            pageWrapper.removeClass('open');
            vm.isNavbarCollapsed = true;
        }

        function toggleNavbar() {
            if (vm.isNavbarCollapsed) {
                pageWrapper.addClass('open');
                vm.isNavbarCollapsed = false;
            } else {
                collapseNavbar();
            }
        };
    }
})();
