(function() {
    'use strict';
    angular
        .module('testcaseApp')
        .factory('LeftUnidirectional', LeftUnidirectional);

    LeftUnidirectional.$inject = ['$resource'];

    function LeftUnidirectional ($resource) {
        var resourceUrl = 'api/leftUnidirectional/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    if (data) {
                        data = angular.fromJson(data);
                    }
                    return data;
                }
            },
            'update': { method:'PUT' }
        });
    }
})();