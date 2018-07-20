(function() {
    'use strict';
    angular
        .module('testcaseApp')
        .factory('RightOneToOneUnidirectional', RightOneToOneUnidirectional);

    RightOneToOneUnidirectional.$inject = ['$resource'];

    function RightOneToOneUnidirectional ($resource) {
        var resourceUrl = 'api/rightOneToOneUnidirectional/:id';

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