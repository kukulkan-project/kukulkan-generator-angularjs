(function() {
    'use strict';
    angular
        .module('testcaseApp')
        .factory('RightOneToManyUnidirectional', RightOneToManyUnidirectional);

    RightOneToManyUnidirectional.$inject = ['$resource'];

    function RightOneToManyUnidirectional ($resource) {
        var resourceUrl = 'api/rightOneToManyUnidirectional/:id';

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